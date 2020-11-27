package com.iot.model.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "label")
@Entity
public class Label {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "labelId", fetch = FetchType.EAGER)
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

  public Label(Integer id, String name, Set<Playlist> playlist) {
    this.id = id;
    this.name = name;
    this.playlist = playlist;
  }

  public Label(String name, Set<Playlist> playlist) {
    this.name = name;
    this.playlist = playlist;
  }

  public Label(String name) {
    this.name = name;
  }

  public Label() {
  }

  @Override
  public String toString() {
    return "Label{"
      +  "id=" + id
      +  ", name='" + name + '\''
      +  ", playlist=" + playlist
      +  '}';
  }
}
