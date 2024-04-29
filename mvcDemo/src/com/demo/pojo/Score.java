package com.demo.pojo;

import java.io.Serializable;

/**
 * 该POJO是一个JavaBean，所有的属性都是跟数据库一致，包括字段名，数据类型
 * 为每个属性添加一个get()和set()，顺便再加一个toString()，便于程序调试
 * 以后所有的POJO类都继承Base，就不用再考虑where、limit、order by的问题了
 * 
 * 需要强调的是，该POJO对应的数据表是一张联系表，在查询的时候，需要关联其他表并获得数据
 * 所以，与它关联的表(即外键)都增加一个对应的属性(Object类型)
 */

public class Score extends Base implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private int id;
  private int studentId;
  private int teacherId;
  private int courseId;
  private double score;
  private String term;
  private String state;
  private String memo;
  
  private Student student;//查询时需要关联Student表
  private Teacher teacher;//查询时需要关联Teacher表
  private Course course;//查询时需要关联Course表
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getStudentId() {
    return studentId;
  }
  
  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }
  
  public int getTeacherId() {
    return teacherId;
  }
  
  public void setTeacherId(int teacherId) {
    this.teacherId = teacherId;
  }
  
  public int getCourseId() {
    return courseId;
  }
  
  public void setCourseId(int courseId) {
    this.courseId = courseId;
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
  
  public Student getStudent() {
    return student;
  }
  
  public void setStudent(Student student) {
    this.student = student;
  }
  
  public Teacher getTeacher() {
    return teacher;
  }
  
  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
  
  public Course getCourse() {
    return course;
  }
  
  public void setCourse(Course course) {
    this.course = course;
  }
  
  @Override
  public String toString() {
    return "Score [id=" + id 
    		+ ", studentId=" + studentId 
    		+ ", teacherId=" + teacherId 
    		+ ", courseId=" + courseId 
    		+ ", score=" + score 
    		+ ", term=" + term 
    		+ ", state=" + state 
    		+ ", memo=" + memo 
    		+ ", student=" + student 
    		+ ", Teacher=" + teacher 
    		+ ", course=" + course 
    		+ "]";
  }

}
