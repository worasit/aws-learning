package com.daimongkol.aws.hikaricp;

import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HikariCpApplication {

  public static void main(String[] args) throws SQLException {
    final Connection connection = MySqlDataSource.getConnection();
    final StudentDao studentDao = new StudentDao(connection);
    studentDao.getAllStudents().forEach(student -> log.info(student.toString()));
  }
}
