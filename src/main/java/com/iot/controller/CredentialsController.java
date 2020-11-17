package com.iot.controller;

import java.sql.SQLException;
import java.util.List;
import com.iot.controller.GenericController;
import com.iot.model.entity.Credentials;
import com.iot.model.dao.implementation.CredentialsDAO;

public class CredentialsController implements GenericController<Credentials>  {
  
  CredentialsDAO dao = new CredentialsDAO();

  @Override
  public List<Credentials> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public Credentials findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(Credentials entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Credentials entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
    
  }

}
