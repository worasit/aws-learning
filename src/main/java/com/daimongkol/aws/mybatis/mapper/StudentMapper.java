package com.daimongkol.aws.mybatis.mapper;

import com.daimongkol.aws.mybatis.pojo.Student;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface StudentMapper {
  @Select("select * from students")
  @Results(
      value = {
        @Result(property = "id", column = "ID", jdbcType = JdbcType.INTEGER, id = true),
        @Result(property = "name", column = "NAME", jdbcType = JdbcType.VARCHAR),
        @Result(property = "branch", column = "BRANCH", jdbcType = JdbcType.VARCHAR),
        @Result(property = "percentage", column = "PERCENTAGE", jdbcType = JdbcType.INTEGER),
        @Result(property = "phone", column = "PHONE", jdbcType = JdbcType.VARCHAR),
        @Result(property = "email", column = "EMAIL", jdbcType = JdbcType.VARCHAR)
      })
  List<Student> getAll();

  @Select("select * from students where ID = #{id}")
  @Results(
      value = {
        @Result(property = "id", column = "ID", jdbcType = JdbcType.INTEGER, id = true),
        @Result(property = "name", column = "NAME", jdbcType = JdbcType.VARCHAR),
        @Result(property = "branch", column = "BRANCH", jdbcType = JdbcType.VARCHAR),
        @Result(property = "percentage", column = "PERCENTAGE", jdbcType = JdbcType.INTEGER),
        @Result(property = "phone", column = "PHONE", jdbcType = JdbcType.VARCHAR),
        @Result(property = "email", column = "EMAIL", jdbcType = JdbcType.VARCHAR)
      })
  Student getById(Integer id);
}
