package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GenericDAO;
import com.iot.model.entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements GenericDAO<User>  {
  
  private static final String GET_ALL = "SELECT * FROM spotify.user";
  private static final String GET_ONE = "SELECT * FROM spotify.user WHERE id=?";
  private static final String CREATE = "INSERT spotify.user "
          + "(name, surname, email, credentials_id) VALUES (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE spotify.user"
          + " SET name=?, surname=?, email=?, credentials_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM spotify.user WHERE id=?";
  
  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        User user = new User(
            resultSet.getInt("id"), 
            resultSet.getString("name"),
            resultSet.getString("surname"),
            resultSet.getString("email"),
            resultSet.getString("credentials_id")
        );
        users.add(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return users;
  }
  
  @Override
  public User findOne(Integer id) {
    User user = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        user = new User(
            resultSet.getInt("id"), 
            resultSet.getString("name"),
            resultSet.getString("surname"),
            resultSet.getString("email"),
            resultSet.getString("credentials_id")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }
  
  @Override
  public void create(User user) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
     
      statement.setString(1, String.valueOf(user.getName()));
      statement.setString(2, String.valueOf(user.getSurname()));
      statement.setString(3, String.valueOf(user.getEmail()));
      statement.setString(4, String.valueOf(user.getCredentialsId()));

      statement.executeUpdate();
      System.out.println(statement);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    
  }
  @Override
  public void update(Integer id, User user) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
   
      statement.setString(1, user.getName());
      statement.setString(2, user.getSurname());
      statement.setString(3, user.getEmail());
      statement.setString(4, user.getCredentialsId());
      statement.setInt(5, user.getId());
   
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
