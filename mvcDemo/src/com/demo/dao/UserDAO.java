package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import com.demo.pojo.User;

/**
 * 每个DAO对应数据库中的一张表
 * 包含添加、删除、修改、查询、统计等操作
 */

public interface UserDAO {
  public ArrayList<User> select(User obj) throws SQLException;//查询记录
  public ArrayList<User> loginCheck(User obj) throws SQLException;//登录查询
  public ArrayList<User> selectRnd(User obj) throws SQLException;//随机查询3条记录
  public int count(User obj) throws SQLException;//统计记录数
  public int insert(User obj) throws SQLException;//添加记录
  public int update(User obj) throws SQLException;//更新记录
  public int delete(User obj) throws SQLException;//删除记录
}