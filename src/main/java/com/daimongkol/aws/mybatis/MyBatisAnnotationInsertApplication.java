package com.daimongkol.aws.mybatis;

import com.daimongkol.aws.mybatis.mapper.StudentMapper;
import com.daimongkol.aws.mybatis.pojo.Student;
import java.io.IOException;
import java.io.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisAnnotationInsertApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    sqlSession.getConfiguration().addMapper(StudentMapper.class);

    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    Student student = new Student("worasit", "Thailand", 100, 9000, "worasit.dmk501@gmail.com");

    int affectedRows = studentMapper.insert(student);

    log.info(String.format("Insert student successfully with total %d records.", affectedRows));

    sqlSession.commit();
    sqlSession.close();
  }
}
