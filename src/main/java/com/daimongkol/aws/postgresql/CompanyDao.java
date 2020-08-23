package com.daimongkol.aws.postgresql;

import com.daimongkol.aws.postgresql.pojo.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {

  private final Connection connection;

  public CompanyDao(Connection connection) {
    this.connection = connection;
  }

  List<Company> getCompanies() throws SQLException {
    List<Company> companies = new ArrayList<>();
    try (PreparedStatement preparedStatement =
        this.connection.prepareStatement("select * from public.company;");
        final ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        final Company company =
            Company.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .age(resultSet.getInt("age"))
                .address(resultSet.getString("address"))
                .salary(resultSet.getFloat("salary"))
                .joinDate(resultSet.getDate("join_date"))
                .build();
        companies.add(company);
      }
    }
    return companies;
  }
}
