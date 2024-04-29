package com.demo.pojo;

import java.io.Serializable;

import com.demo.pojo.Base;

/**
 * 该POJO是一个JavaBean，所有的属性都是跟数据库一致，包括字段名，数据类型
 * 为每个属性添加一个get()和set()，顺便再加一个toString()，便于程序调试
 * 以后所有的POJO类都继承Base，就不用再考虑where、limit、order by的问题了
 */

public class User extends Base implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private int id;
  private String userName;
  private String nickName;
  private String password;
  private String role;
  private String imgURL;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getNickName() {
    return nickName;
  }
  
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  public String getRole() {
    return role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public String getImgURL() {
    return imgURL;
  }
  
  public void setImgURL(String imgURL) {
    this.imgURL = imgURL;
  }
  
  @Override
  public String toString() {
    return "User [id=" + id 
    		+ ", userName=" + userName 
    		+ ", nickName=" + nickName 
    		+ ", password=" + password 
    		+ ", role=" + role 
    		+ ", imgURL=" + imgURL 
    		+ "]";
  }

  

}