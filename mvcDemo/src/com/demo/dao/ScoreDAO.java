package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;
import com.demo.pojo.Score;
import com.demo.vo.ScoreCount;
import com.demo.vo.ScoreVO;

/**
 * 每个DAO对应数据库中的一张表
 * 包含添加、删除、修改、查询、统计等操作
 */

public interface ScoreDAO {
  public ArrayList<Score> select(Score obj) throws SQLException;//查询记录
  public int count(Score obj) throws SQLException;//统计记录数
  public ArrayList<ScoreCount> scoreCount(ScoreCount obj) throws SQLException;//统计分数段
}