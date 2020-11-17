package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GenericDAO;
import com.iot.model.entity.Label;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LabelDAO implements GenericDAO<Label> {
  private static final String GET_ALL = "SELECT * FROM spotify.label";
  private static final String GET_ONE = "SELECT * FROM spotify.label WHERE id=?";
  private static final String CREATE = "INSERT spotify.label "
          + "(name) VALUES (?)";
  private static final String UPDATE = "UPDATE spotify.label"
          + " SET name=? WHERE id=?";
  private static final String DELETE = "DELETE FROM spotify.label WHERE id=?";
  
  @Override
  public List<Label> findAll() {
    List<Label> labels = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Label label = new Label(
            resultSet.getInt("id"), 
            resultSet.getString("name")
        );
        labels.add(label);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return labels;
  }
  
  @Override
  public Label findOne(Integer id) {
    Label label = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        label = new Label(
           resultSet.getInt("id"), 
           resultSet.getString("name")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return label;
  }
  
  @Override
  public void create(Label label) throws SQLException {

    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
     
      statement.setString(1, String.valueOf(label.getName()));

      statement.executeUpdate();
      System.out.println(statement);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    
  }
  @Override
  public void update(Integer id, Label label) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
   
      statement.setString(1, label.getName());
      statement.setInt(2, label.getId());
   
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
