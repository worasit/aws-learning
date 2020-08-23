package com.daimongkol.aws.postgresql.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * company.
 *
 * @author
 */
@Data
@Builder
public class Company implements Serializable {

  private Integer id;

  private String name;

  private Integer age;

  private String address;

  private Float salary;

  private Date joinDate;
}
