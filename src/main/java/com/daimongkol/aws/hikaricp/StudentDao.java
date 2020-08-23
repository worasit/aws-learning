package com.daimongkol.aws.hikaricp;

import com.daimongkol.aws.mybatis.pojo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDao {

  private final Connection connection;
  public static final String GET_ALL_STUDENTS = "select * from students;";

  public StudentDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Returns all students.
   *
   * @return Student POJO
   * @throws SQLException throws this when connection pool is failed
   */
  public List<Student> getAllStudents() throws SQLException {
    List<Student> students = new ArrayList<>(Collections.emptyList());
    try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
        final ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        final Student student =
            new Student(
                resultSet.getInt("ID"),
                resultSet.getString("NAME"),
                resultSet.getString("BRANCH"),
                resultSet.getInt("PERCENTAGE"),
                resultSet.getInt("PHONE"),
                resultSet.getString("EMAIL"));
        students.add(student);
      }
    }
    return students;
  }
}
