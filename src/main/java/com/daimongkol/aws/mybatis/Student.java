package com.daimongkol.aws.mybatis;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Student implements Serializable {
  private int id;
  private String name;
  private String branch;
  private int percentage;
  private int phone;
  private String email;

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Student(String name, String branch, int percentage, int phone, String email) {
    this.name = name;
    this.branch = branch;
    this.percentage = percentage;
    this.phone = phone;
    this.email = email;
  }
}
