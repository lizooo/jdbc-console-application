package com.iot.model.entity;

import javax.persistence.*;

@Table(name = "credentials")
@Entity
public class Credentials {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "username")
  private String userName;
  @Column(name = "dcrypt_password")
  private String dcryptPassword;


  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDcryptPassword() {
    return dcryptPassword;
  }

  public void setDcryptPassword(String dcryptPassword) {
    this.dcryptPassword = dcryptPassword;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Credentials(Integer id, String userName, String dcryptPassword, User user) {
    this.id = id;
    this.userName = userName;
    this.dcryptPassword = dcryptPassword;
    this.user = user;
  }

  public Credentials(String userName, String dcryptPassword, User user) {
    this.userName = userName;
    this.dcryptPassword = dcryptPassword;
    this.user = user;
  }

  public Credentials() {
  }

  @Override
  public String toString() {
    return "Credentials{"
       + "id=" + id
       + ", userName='" + userName + '\''
       + ", dcryptPassword='" + dcryptPassword + '\''
       + ", user=" + user
       + '}';
  }
}
