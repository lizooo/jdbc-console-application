package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GenericDAO; 
import com.iot.model.entity.Credentials;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CredentialsDAO implements GenericDAO<Credentials>{

  private static final String GET_ALL = "SELECT * FROM spotify.credentials";
  private static final String GET_ONE = "SELECT * FROM spotify.credentials WHERE id=?";
  private static final String CREATE = "INSERT spotify.credentials "
          + "(dcrypt_password, username) VALUES (?, ?)";
  private static final String UPDATE = "UPDATE spotify.credentials"
          + " SET dcrypt_password=?, username=? WHERE id=?";
  private static final String DELETE = "DELETE FROM spotify.credentials WHERE id=?";
  
  @Override
  public List<Credentials> findAll() {
    List<Credentials> credentials = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Credentials credential = new Credentials(
            resultSet.getInt("id"), 
            resultSet.getString("username"), 
            resultSet.getString("dcrypt_password") 
        );
        credentials.add(credential);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return credentials;
  }
  
  @Override
  public Credentials findOne(Integer id) {
    Credentials credential = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        credential = new Credentials(
           resultSet.getInt("id"), 
           resultSet.getString("username"), 
           resultSet.getString("dcrypt_password") 
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return credential;
  }
  
  @Override
  public void create(Credentials credential) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
     
      statement.setString(1, String.valueOf(credential.getUserName()));
      statement.setString(2, String.valueOf(credential.getDcryptPassword()));

      statement.executeUpdate();
      System.out.println(statement);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    
  }
  @Override
  public void update(Integer id, Credentials credential) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
   
      statement.setString(1, credential.getUserName());
      statement.setString(2, credential.getDcryptPassword());
      statement.setInt(3, credential.getId());
   
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
  

  

