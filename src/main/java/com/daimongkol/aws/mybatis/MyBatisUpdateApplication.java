package com.daimongkol.aws.mybatis;

import java.io.IOException;
import java.io.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisUpdateApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // Get existing Student for updating
    Student updatedStudent = sqlSession.selectOne("Student.getById", 2);

    // Update the selected updatedStudent
    updatedStudent.setEmail("update@email.com");
    int affectedRows = sqlSession.update("Student.update", updatedStudent);

    log.info(String.format("updated %d records.", affectedRows));

    sqlSession.commit();
    sqlSession.close();
  }
}
