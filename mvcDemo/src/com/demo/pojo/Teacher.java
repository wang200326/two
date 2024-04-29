package com.demo.pojo;

import java.io.Serializable;
import java.util.List;

import com.demo.pojo.Base;

/**
 * 该POJO是一个JavaBean，所有的属性都是跟数据库一致，包括字段名，数据类型
 * 为每个属性添加一个get()和set()，顺便再加一个toString()，便于程序调试
 * 以后所有的POJO类都继承Base，就不用再考虑where、limit、order by的问题了
 */

public class Teacher extends Base implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private int id;
  private String sequence;
  private String name;
  private String gender;
  private String birthday;
  private String card;
  private String nation;
  private String nativePlace;
  private String political;
  private int userId;
  
  private User user;

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
  
  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  
  public String getBirthday() {
    return birthday;
  }
  
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }
  
  public String getCard() {
    return card;
  }
  
  public void setCard(String card) {
    this.card = card;
  }
  
  public String getNation() {
    return nation;
  }
  
  public void setNation(String nation) {
    this.nation = nation;
  }
  
  public String getNativePlace() {
    return nativePlace;
  }
  
  public void setNativePlace(String nativePlace) {
    this.nativePlace = nativePlace;
  }
  
  public String getPolitical() {
    return political;
  }
  
  public void setPolitical(String political) {
    this.political = political;
  }
  
  public int getUserId() {
    return userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }
  
  @Override
  public String toString() {
    return "Student [id=" + id 
    		+ ", sequence=" + sequence 
    		+ ", name=" + name 
    		+ ", gender=" + gender 
    		+ ", birthday=" + birthday 
    		+ ", card=" + card 
    		+ ", nation=" + nation 
    		+ ", nativePlace=" + nativePlace 
    		+ ", political=" + political 
    		+ ", userId=" + userId 
    		+ ", user=" + user 
    		+ "]";
  }
  
}