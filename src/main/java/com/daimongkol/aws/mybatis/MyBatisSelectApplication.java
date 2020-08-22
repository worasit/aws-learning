package com.daimongkol.aws.mybatis;

import com.daimongkol.aws.mybatis.pojo.Student;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisSelectApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    List<Student> students = sqlSession.selectList("Student.getAll");
    students.forEach(student -> log.info(student.toString()));

    Student student = sqlSession.selectOne("Student.getById", 1);
    log.info(student.toString());

    sqlSession.commit();
    sqlSession.close();
  }
}
