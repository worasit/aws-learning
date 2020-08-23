package com.daimongkol.aws.hikaricp;

import lombok.Getter;

public enum HikariPoolName {
  NONE("None"),
  MYSQL_OLTP("MySql_OLTP"),
  POSTGRES_OLTP("Postgres_OLTP");

  @Getter
  private final String poolName;

  HikariPoolName(String poolName) {
    this.poolName = poolName;
  }
}
