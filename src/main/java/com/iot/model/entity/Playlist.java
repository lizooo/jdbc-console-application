package com.iot.model.entity;

import javax.persistence.*;

@Table(name = "playlist")
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "number_of_songs")
  private Integer numberOfSongs;
  @Column(name = "genre_id")
  private Integer genreId;
  @Column(name = "label_id")
  private Integer labelId;
  @Column(name = "user_id")
  private Integer userId;

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

  public Integer getNumberOfSongs() {
    return numberOfSongs;
  }

  public void setNumberOfSongs(Integer numberOfSongs) {
    this.numberOfSongs = numberOfSongs;
  }

  public Integer getGenreId() {
    return genreId;
  }

  public void setGenreId(Integer genreId) {
    this.genreId = genreId;
  }

  public Integer getLabelId() {
    return labelId;
  }

  public void setLabelId(Integer labelId) {
    this.labelId = labelId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Playlist(Integer id, String name, Integer numberOfSongs, Integer genreId, Integer labelId, Integer userId) {
    this.id = id;
    this.name = name;
    this.numberOfSongs = numberOfSongs;
    this.genreId = genreId;
    this.labelId = labelId;
    this.userId = userId;
  }

  public Playlist(String name, Integer numberOfSongs, Integer genreId, Integer labelId, Integer userId) {
    this.name = name;
    this.numberOfSongs = numberOfSongs;
    this.genreId = genreId;
    this.labelId = labelId;
    this.userId = userId;
  }

  public Playlist() {
  }

  @Override
  public String toString() {
    return "Playlist{" +
         "id=" + id
       + ", name='" + name + '\''
       + ", numberOfSongs=" + numberOfSongs
       + ", genreId=" + genreId
       + ", labelId=" + labelId
       + ", userId=" + userId
       + '}';
  }
}
