package com.iot.model.dao.implementation;

import com.iot.model.dao.GenericDAO;
import com.iot.model.entity.Genre;
import com.iot.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class GenreDAO implements GenericDAO<Genre> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Genre> findAll() {
    List<Genre> credentials = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      credentials = session.createQuery("from Genre").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return credentials;
  }

  @Override
  public Genre findOne(Integer id) throws SQLException {
    Genre genre = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      genre = session.get(Genre.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return genre;
  }

  @Override
  public void create(Genre genre) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(genre);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Genre genre) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(genre);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Genre credential = session.get(Genre.class, id);
      if (credential != null) {
        session.delete(credential);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
