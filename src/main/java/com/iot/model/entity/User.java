package com.iot.model.entity;


public class User {
  private Integer id;
  private String name;
  private String surname;
  private String email;
  private String credentialsId;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getCredentialsId() {
    return credentialsId;
  }
  public void setCredentialsId(String credentialsId) {
    this.credentialsId = credentialsId;
  }
  @Override
  public String toString() {
    return "\n\nUser: "
        + "id: " + id +  ", "
        + "name: " + name + ", "
        + "surname: " + surname + ", "
        + "email: " + email + ", "
        + "credentialsId: " + credentialsId + " ";
  }
  public User(Integer id, String name, String surname, String email, String credentialsId) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.credentialsId = credentialsId;
  }
  
  public User( String name, String surname, String email, String credentialsId) {
    this( null, name, surname, email, credentialsId);
  }
  
  
}
