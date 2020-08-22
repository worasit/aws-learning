package com.daimongkol.aws.mybatis.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Student implements Serializable {

  private int id;
  private String name;
  private String branch;
  private int percentage;
  private int phone;
  private String email;

  public Student(int id, String name, String branch, int percentage, int phone, String email) {
    this.id = id;
    this.name = name;
    this.branch = branch;
    this.percentage = percentage;
    this.phone = phone;
    this.email = email;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Student(String name, String branch, int percentage, int phone, String email) {
    this.name = name;
    this.branch = branch;
    this.percentage = percentage;
    this.phone = phone;
    this.email = email;
  }
}
