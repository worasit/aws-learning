package com.daimongkol.aws.mybatis;

import java.io.IOException;
import java.io.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisDeleteApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    int affectedRow = sqlSession.delete("Student.deleteById", 1);

    log.info(String.format("Affected row: %d", affectedRow));
    sqlSession.commit();
    sqlSession.close();
  }
}
