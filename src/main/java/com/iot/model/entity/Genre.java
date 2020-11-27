package com.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "genre")
@Entity
public class Genre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;


  @OneToMany(mappedBy = "genreId", fetch = FetchType.EAGER)
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

  public Set<Playlist> getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Set<Playlist> playlist) {
    this.playlist = playlist;
  }

  public Genre(Integer id, String name, Set<Playlist> playlist) {
    this.id = id;
    this.name = name;
    this.playlist = playlist;
  }

  public Genre(String name, Set<Playlist> playlist) {
    this.name = name;
    this.playlist = playlist;
  }

  public Genre(String name) {
    this.name = name;
  }

  public Genre() {
  }

  @Override
  public String toString() {
    return "Genre{"
       + "id=" + id
       + ", name='" + name + '\''
       + ", playlist=" + playlist
       + '}';
  }
}
