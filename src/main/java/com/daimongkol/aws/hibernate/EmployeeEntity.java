package com.daimongkol.aws.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "employee", schema = "public", catalog = "agoda_core")
public class EmployeeEntity {
  private int id;
  private String firstName;
  private String lastName;
  private Integer salary;

  @Id
  @Column(name = "id", updatable = false, unique = true)
  @GeneratedValue(generator = "employee_generator", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "employee_generator", sequenceName = "employee_id_seq", catalog = "agoda_core", schema = "public", allocationSize = 0)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "salary")
  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EmployeeEntity that = (EmployeeEntity) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(salary, that.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, salary);
  }
}
