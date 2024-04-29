package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import com.demo.pojo.Student;

/**
 * 每个DAO对应数据库中的一张表
 * 包含添加、删除、修改、查询、统计等操作
 */

public interface StudentDAO {
  public ArrayList<Student> select(Student obj) throws SQLException;//查询记录
  public int count(Student obj) throws SQLException;//统计记录数
  public int insert(Student obj) throws SQLException;//添加记录
  public int update(Student obj) throws SQLException;//更新记录
  public int delete(Student obj) throws SQLException;//删除记录
}