package com.daimongkol.aws.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostgresApplication {

  public static void main(String[] args) throws SQLException {
    final Connection connection = PostgresDataSource.getConnection();
    final CompanyDao companyDao = new CompanyDao(connection);
    companyDao.getCompanies().forEach(company -> log.info(company.toString()));
  }
}
