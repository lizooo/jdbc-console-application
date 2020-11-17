package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GenericDAO;
import com.iot.model.entity.Genre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class GenreDAO implements GenericDAO<Genre> {
  private static final String GET_ALL = "SELECT * FROM spotify.genre";
  private static final String GET_ONE = "SELECT * FROM spotify.genre WHERE id=?";
  private static final String CREATE = "INSERT spotify.genre "
          + "(name) VALUES (?)";
  private static final String UPDATE = "UPDATE spotify.genre"
          + " SET name=? WHERE id=?";
  private static final String DELETE = "DELETE FROM spotify.genre WHERE id=?";
  
  @Override
  public List<Genre> findAll() {
    List<Genre> genres = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Genre genre = new Genre(
            resultSet.getInt("id"), 
            resultSet.getString("name")
        );
        genres.add(genre);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return genres;
  }
  
  @Override
  public Genre findOne(Integer id) {
    Genre genre = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        genre = new Genre(
           resultSet.getInt("id"), 
           resultSet.getString("name")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return genre;
  }
  
  @Override
  public void create(Genre genre) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
     
      statement.setString(1, String.valueOf(genre.getName()));

      statement.executeUpdate();
      System.out.println(statement);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    
  }
  @Override
  public void update(Integer id, Genre genre) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
   
      statement.setString(1, genre.getName());
      statement.setInt(2, genre.getId());
   
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
