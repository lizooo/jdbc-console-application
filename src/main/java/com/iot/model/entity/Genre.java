package com.iot.model.entity;


public class Genre {
  private Integer id;
  private String name;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Genre(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Genre(String name) {
    this(null, name);
  }
  
  @Override
  public String toString() {
    return "\n\nGenre: id: " + id + ", name: " + name + "";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
}
