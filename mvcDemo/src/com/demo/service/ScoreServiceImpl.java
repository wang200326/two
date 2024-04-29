package com.demo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.demo.dao.ScoreDAOImpl;
import com.demo.pojo.JsonData;
import com.demo.pojo.Score;
import com.demo.util.DButil;
import com.demo.vo.ScoreCount;
import com.demo.vo.ScoreVO;

public class ScoreServiceImpl implements ScoreService{
  /**
   * 查询业务，此处做3件事：
   * 1、调用DAO层的select方法，返回查询到的记录集
   * 2、调用DAO层的count方法，返回查询到的记录数
   * 3、利用JsonData将记录数total与记录集studentList拼接成“total=50,rows=[{},{}...{}]”格式
   */
  boolean success;//操作成功与否
  String msg;//返回的结果信息
  int total;//返回记录数
  JsonData jd;//将数据转换为指定JSON格式的对象，并返回给Controller层
  
  @Override
  public JsonData select(Score pojo) {
    Connection conn = DButil.getConnection();
    ScoreDAOImpl dao = new ScoreDAOImpl(conn);
    try{
      ArrayList<Score> rows = new ArrayList<Score>();
      rows = dao.select(pojo);//返回记录集
      total = dao.count(pojo);//返回记录数
      conn.commit();
      success = true;
      msg = "查询成功";
      jd = new JsonData(success,msg,total,rows);
      return jd;
    }catch(Exception e){
      try {
        conn.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
      success = false; 
      msg = "查询失败";
      jd = new JsonData(success,msg);
      return jd;
    }finally{
      if(conn != null){
        DButil.closeConnection(conn);
      }
    }
  }
  
  /**
   * 成绩统计业务
   */
  @Override
  public JsonData scoreCount(ScoreCount pojo) {
    Connection conn = DButil.getConnection();
    ScoreDAOImpl dao = new ScoreDAOImpl(conn);
    try{
      ArrayList<ScoreCount> rows = new ArrayList<ScoreCount>();
      rows = dao.scoreCount(pojo);//返回统计结果
      conn.commit();
      msg = "查询成功";
      jd = new JsonData(success,msg,total,rows);
      return jd;
    }catch(Exception e){
      try {
        conn.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
      success = false; 
      msg = "查询失败";
      jd = new JsonData(success,msg);
      return jd;
    }finally{
      if(conn != null){
        DButil.closeConnection(conn);
      }
    }
  }
  
}