package com.iot.model.dao.implementation;

import com.iot.model.entity.Label;
import com.iot.model.dao.GenericDAO;
import com.iot.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class LabelDAO implements GenericDAO<Label> {
  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Label> findAll() {
    List<Label> labels = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      labels = session.createQuery("from Label").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return labels;
  }

  @Override
  public Label findOne(Integer id) throws SQLException {
    Label label = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      label = session.get(Label.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return label;
  }

  @Override
  public void create(Label label) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(label);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Label label) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(label);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Label label = session.get(Label.class, id);
      if (label != null) {
        session.delete(label);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
