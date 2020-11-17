package com.iot.controller;

import java.sql.SQLException;
import java.util.List;


public interface GenericController<E> {

  List<E> findAll() throws SQLException;

  E findOne(Integer id) throws SQLException;

  void create(E entity) throws SQLException;

  void update(Integer id, E entity) throws SQLException;

  void delete(Integer id) throws SQLException;
  
}
