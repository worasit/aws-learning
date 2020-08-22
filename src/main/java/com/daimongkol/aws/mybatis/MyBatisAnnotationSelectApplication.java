package com.daimongkol.aws.mybatis;

import com.daimongkol.aws.mybatis.mapper.StudentMapper;
import com.daimongkol.aws.mybatis.pojo.Student;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisAnnotationSelectApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    sqlSession.getConfiguration().addMapper(StudentMapper.class);
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    // Get all students
    List<Student> students = studentMapper.getAll();
    students.forEach(student -> log.info(student.toString()));

    // Get students by id
    Student student = studentMapper.getById(2);
    log.info(Optional.ofNullable(student).map(Student::toString).orElse("A student not found."));

    sqlSession.commit();
    sqlSession.close();
  }
}
