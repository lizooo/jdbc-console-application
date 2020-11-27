package com.iot.model.dao.implementation;

import com.iot.model.entity.User;
import com.iot.model.dao.GenericDAO;
import com.iot.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UserDAO implements GenericDAO<User> {
  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<User> findAll() {
    List<User> users = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      users = session.createQuery("from User").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public User findOne(Integer id) throws SQLException {
    User playlist = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      playlist = session.get(User.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return playlist;
  }

  @Override
  public void create(User user) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(user);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, User user) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(user);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      User label = session.get(User.class, id);
      if (label != null) {
        session.delete(label);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
