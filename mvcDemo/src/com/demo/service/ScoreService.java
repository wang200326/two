package com.demo.service;

import com.demo.pojo.JsonData;
import com.demo.pojo.Score;
import com.demo.vo.ScoreCount;

/**
 * 每个Service对应前端一个页面
 * 页面中需要实现的业务逻辑都在这里定义
 */

public interface ScoreService {
  public JsonData select(Score score);//查询业务
  public JsonData scoreCount(ScoreCount scoreCount);//成绩统计业务
}