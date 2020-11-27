package com.iot.controller;

import java.sql.SQLException;
import java.util.List;
import com.iot.model.dao.implementation.GenreDAO;
import com.iot.model.entity.Genre;

public class GenreController implements GenericController<Genre>  {
  
  GenreDAO dao = new GenreDAO();

  @Override
  public List<Genre> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public Genre findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(Genre entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Genre entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }

}
