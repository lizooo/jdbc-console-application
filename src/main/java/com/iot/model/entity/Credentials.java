package com.iot.model.entity;
import java.util.Objects;


public class Credentials {
  
  public String getDcryptPassword() {
    return dcryptPassword;
  }
  public void setDcryptPassword(String dcryptPassword) {
    this.dcryptPassword = dcryptPassword;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  private Integer id;
  private String userName;
  private String dcryptPassword;
  
  public Credentials(Integer id, String userName, String dcryptPassword) {
    this.id = id;
    this.userName = userName;
    this.dcryptPassword = dcryptPassword;
  }
  
  public Credentials(String userName, String dcryptPassword) {
    this(-1, userName, dcryptPassword);
  }
  
  @Override
  public String toString() {
    return "\n\nCredentials: id: " + id + ", userName: " + userName + ", dcryptPassword: " + dcryptPassword
        + "]";
  }
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  
}
