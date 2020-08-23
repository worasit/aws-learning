package com.daimongkol.aws.postgresql;

import com.daimongkol.aws.hikaricp.HikariPoolName;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgresDataSource {

  private static final HikariConfig hikariConfig = new HikariConfig();
  private static final HikariDataSource hikariDataSource;

  static {
    hikariConfig.setPoolName(HikariPoolName.POSTGRES_OLTP.getPoolName());
    hikariConfig.setUsername("postgres");
    hikariConfig.setPassword("admin");
    hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/testdb");
    hikariConfig.setMaximumPoolSize(20);
    hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    hikariDataSource = new HikariDataSource(hikariConfig);
  }

  private PostgresDataSource() {
  }

  public static Connection getConnection() throws SQLException {
    return hikariDataSource.getConnection();
  }
}
