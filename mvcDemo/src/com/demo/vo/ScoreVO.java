package com.demo.vo;

import com.demo.pojo.Base;

public class ScoreVO extends Base {

  /**
   * VO(Value Object)类即值对象
   * 该VO也是一个JavaBean，一般用于返回数据结果
   * 类中的属性取决于项目中需要哪些数据，不用与数据表一致
   * 
   * 顺便了解一下其他Object：
   * DAO(Data Access Object)数据访问对象，负责持久层的操作，主要用来封装对数据库的访问
   * PO(Persistent Object)持久层对象，它是由一组属性和属性的get和set方法组成，我们可以将数据库表中的一条记录理解为一个持久层对象
   * BO(Business Object)业务层对象，主要作用是把业务逻辑封装为一个对象
   * VO(Value Object)值对象，通常用于业务层之间的数据传递，和 PO 一样也是仅仅包含数据而已，但 VO 应该是抽象出的业务对象
   * DTO(Data Transfer Object)数据传输对象，主要用于远程调用等需要大量传输对象的地方
   * POJO(Plain Ordinary Java Object)简单的 Java 对象，没有业务逻辑，也不允许有业务方法，也不能携带有connection之类的方法
   * 
   * POJO 是 JavaEE 世界里面最灵活的对象：
   * 在简单系统中，如果从数据库到页面展示都是 POJO 的话，它可以是 DTO
   * 如果从数据库中到业务处理中都是 POJO 的话，它可以是 BO
   * 如果从数据库到整个页面的展示的话，它也可以是 VO
   */
  private static final long serialVersionUID = 1L;
  
  int id;
  String studentName;
  String teacherName;
  String courseName;
  double score;
  String term;
  String state;
  String memo;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getStudentName() {
    return studentName;
  }
  
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }
  
  public String getTeacherName() {
    return teacherName;
  }
  
  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }
  
  public String getCourseName() {
    return courseName;
  }
  
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  
  public double getScore() {
    return score;
  }
  
  public void setScore(double score) {
    this.score = score;
  }
  
  public String getTerm() {
    return term;
  }
  
  public void setTerm(String term) {
    this.term = term;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public String getMemo() {
    return memo;
  }
  
  public void setMemo(String memo) {
    this.memo = memo;
  }
  
  @Override
  public String toString() {
    return "Score [id=" + id 
    		+ ", studentName=" + studentName 
    		+ ", teacherName=" + teacherName 
    		+ ", courseName=" + courseName 
    		+ ", score=" + score 
    		+ ", term=" + term 
    		+ ", state=" + state 
    		+ ", memo=" + memo 
    		+ "]";
  }

}
