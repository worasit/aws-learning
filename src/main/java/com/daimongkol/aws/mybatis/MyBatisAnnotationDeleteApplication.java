package com.daimongkol.aws.mybatis;

import com.daimongkol.aws.mybatis.mapper.StudentMapper;
import java.io.IOException;
import java.io.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class MyBatisAnnotationDeleteApplication {
  public static void main(String[] args) throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    sqlSession.getConfiguration().addMapper(StudentMapper.class);

    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    int affectedRecords = studentMapper.delete(1);

    log.info(String.format("Successfully delete with total records %d", affectedRecords));
    sqlSession.commit();
    sqlSession.close();
  }
}
