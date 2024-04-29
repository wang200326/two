package com.demo.pojo;

import com.demo.pojo.Base;

/**
 * 该POJO是一个JavaBean，所有的属性都是跟数据库一致，包括字段名，数据类型
 * 为每个属性添加一个get()和set()，顺便再加一个toString()，便于程序调试
 * 以后所有的POJO类都继承Base，就不用再考虑where、limit、order by的问题了
 */

public class Course extends Base{

  private static final long serialVersionUID = 1L;
  
  private int id;
  private String sequence;
  private String name;
  private String py;
  private String nature;
  private int credits;
  private int hours;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getSequence() {
    return sequence;
  }
  
  public void setSequence(String sequence) {
    this.sequence = sequence;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPy() {
    return py;
  }
  
  public void setPy(String py) {
    this.py = py;
  }
  
  public String getNature() {
    return nature;
  }
  
  public void setNature(String nature) {
    this.nature = nature;
  }
  
  public int getCredits() {
    return credits;
  }
  
  public void setCredits(int credits) {
    this.credits = credits;
  }
  public int getHours() {
    return hours;
  }
  
  public void setHours(int hours) {
    this.hours = hours;
  }
  
  @Override
  public String toString() {
    return "Course [id=" + id 
    		+ ", sequence=" + sequence 
    		+ ", name=" + name 
    		+ ", py=" + py 
    		+ ", nature=" + nature 
    		+ ", credits=" + credits 
    		+ ", hours=" + hours 
    		+ "]";
  }
  
  

}