package com.daimongkol.aws.mybatis.mapper;

import com.daimongkol.aws.mybatis.pojo.Student;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface StudentMapper {
  @Select(value = "select * from students")
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

  @Select(value = "select * from students where ID = #{id}")
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

  @Insert(
      value = {
        "insert into students (NAME, BRANCH, PERCENTAGE, PHONE, EMAIL)"
            + "VALUES(#{name}, #{branch}, #{percentage}, #{phone}, #{email} )"
      })
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insert(Student student);

  @Update(
      value =
          "update students "
              + "set NAME = #{name},"
              + "BRANCH = #{branch},"
              + "PERCENTAGE = #{percentage},"
              + "PHONE = #{phone},"
              + "EMAIL = #{email}"
              + "where ID = #{id};")
  @Options(keyProperty = "id")
  int update(Student student);
}
