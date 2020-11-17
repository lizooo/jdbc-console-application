package com.iot.controller;

import java.sql.SQLException;
import java.util.List;
import com.iot.model.dao.implementation.PlaylistDAO;
import com.iot.model.entity.Playlist;


public class PlaylistController implements GenericController<Playlist>  {
  
  PlaylistDAO dao = new PlaylistDAO();

  @Override
  public List<Playlist> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public Playlist findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(Playlist entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Playlist entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
    
  }
}
