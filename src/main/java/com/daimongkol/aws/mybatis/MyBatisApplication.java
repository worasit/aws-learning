package com.daimongkol.aws.mybatis;

import java.io.IOException;
import java.io.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // Create a new student object
    Student student = new Student("Mohammad", "It", 80, 984803322, "Mohammad@gmail.com");

    // Insert a student data
    sqlSession.insert("Student.insert", student);
    log.info("record inserted successfully");
    sqlSession.commit();
    sqlSession.close();
  }
}
