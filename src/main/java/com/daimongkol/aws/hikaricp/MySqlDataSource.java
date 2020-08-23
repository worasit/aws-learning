package com.daimongkol.aws.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDataSource {

  private static final HikariConfig hikariConfig = new HikariConfig();
  private static final HikariDataSource hikariDataSource;

  static {
    hikariConfig.setPoolName(HikariPoolName.MYSQL_OLTP.getPoolName());
    hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/details");
    hikariConfig.setUsername("root");
    hikariConfig.setPassword("admin");
    hikariConfig.setMaximumPoolSize(20);
    hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    hikariDataSource = new HikariDataSource(hikariConfig);
  }

  private MySqlDataSource() {
  }

  public static Connection getConnection() throws SQLException {
    return hikariDataSource.getConnection();
  }
}
