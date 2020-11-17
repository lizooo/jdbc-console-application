package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GenericDAO;
import com.iot.model.entity.Playlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlaylistDAO implements GenericDAO<Playlist>{
  
  private static final String GET_ALL = "SELECT * FROM spotify.playlist";
  private static final String GET_ONE = "SELECT * FROM spotify.playlist WHERE id=?";
  private static final String CREATE = "INSERT spotify.playlist "
          + "(name, number_of_songs, genre_id, label_id, user_id) VALUES (?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE spotify.playlist"
          + " SET name=?, number_of_songs=?, genre_id=?, label_id=?, user_id=?  WHERE id=?";
  private static final String DELETE = "DELETE FROM spotify.playlist WHERE id=?";
  
  @Override
  public List<Playlist> findAll() {
    List<Playlist> playlists = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Playlist playlist = new Playlist(
            resultSet.getInt("id"), 
            resultSet.getString("name"),
            resultSet.getInt("number_of_songs"),
            resultSet.getInt("genre_id"),
            resultSet.getInt("label_id"),
            resultSet.getInt("user_id")
        );
        playlists.add(playlist);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return playlists;
  }
  
  @Override
  public Playlist findOne(Integer id) {
    Playlist playlist = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        playlist = new Playlist(
            resultSet.getInt("id"), 
            resultSet.getString("name"),
            resultSet.getInt("number_of_songs"),
            resultSet.getInt("genre_id"),
            resultSet.getInt("label_id"),
            resultSet.getInt("user_id")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return playlist;
  }
  
  @Override
  public void create(Playlist playlist) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
     

      statement.setString(1, String.valueOf(playlist.getName()));
      statement.setInt(2, playlist.getNumberOfSongs());
      statement.setInt(3, playlist.getGenreId());
      statement.setInt(4, playlist.getLabelId());
      statement.setInt(5, playlist.getUserId());

      statement.executeUpdate();
      System.out.println(statement);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    
  }
  @Override
  public void update(Integer id, Playlist playlist) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
   
      statement.setString(1, String.valueOf(playlist.getName()));
      statement.setInt(2, playlist.getNumberOfSongs());
      statement.setInt(3, playlist.getGenreId());
      statement.setInt(4, playlist.getLabelId());
      statement.setInt(5, playlist.getUserId());
      statement.setInt(6, id);
   
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void delete(Integer id) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
