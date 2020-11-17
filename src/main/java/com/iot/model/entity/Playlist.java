package com.iot.model.entity;


public class Playlist {
  private Integer id;
  private String name;
  private Integer numberOfSongs;
  private Integer genreId;
  private Integer labelId;
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
  
  public Playlist(Integer id, String name, Integer numberOfSongs, Integer genreId, Integer labelId,
      Integer userId) {
    this.id = id;
    this.name = name;
    this.numberOfSongs = numberOfSongs;
    this.genreId = genreId;
    this.labelId = labelId;
    this.userId = userId;
  }
  
  public Playlist(String name, Integer numberOfSongs, Integer genreId, Integer labelId,
      Integer userId) {
    this(null, name, numberOfSongs, genreId, labelId, userId);
  }
  @Override
  public String toString() {
    return "\n\nPlaylist: id: " + id + ", name: " + name + ", numberOfSongs: " + numberOfSongs
        + ", genreId: " + genreId + ", labelId: " + labelId + ", userId: " + userId + "";
  }
  
   
}
