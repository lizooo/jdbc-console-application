package com.iot.controller;

import java.sql.SQLException;
import java.util.List;
import com.iot.model.dao.implementation.UserDAO;
import com.iot.model.entity.User;

public class UserController implements GenericController<User> {
  
  UserDAO dao = new UserDAO();

  @Override
  public List<User> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public User findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(User entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, User entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
    
  }
}
