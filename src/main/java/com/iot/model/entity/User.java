package com.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "user")
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "surname")
  private String surname;
  @Column(name = "email")
  private String email;

//  @Column(name = "credentials_id")
//  private String credentialsId;


  @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
  private Set<Playlist> playlist;

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

//  public String getCredentialsId() {
//    return credentialsId;
//  }
//
//  public void setCredentialsId(String credentialsId) {
//    this.credentialsId = credentialsId;
//  }

  public Set<Playlist> getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Set<Playlist> playlist) {
    this.playlist = playlist;
  }

  public User(Integer id, String name, String surname, String email, Set<Playlist> playlist) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.playlist = playlist;
  }

  public User(String name, String surname, String email) {
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User{"
       + "id=" + id
       + ", name='" + name + '\''
       + ", surname='" + surname + '\''
       + ", email='" + email + '\''
       + ", playlist=" + playlist
       + '}';
  }
}
