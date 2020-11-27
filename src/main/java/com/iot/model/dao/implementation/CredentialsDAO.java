package com.iot.model.dao.implementation;

import com.iot.model.entity.Credentials;
import com.iot.model.dao.GenericDAO;
import com.iot.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class CredentialsDAO implements GenericDAO<Credentials> {

  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Credentials> findAll() {
    List<Credentials> credentials = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      credentials = session.createQuery("from Credentials").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return credentials;
  }

  @Override
  public Credentials findOne(Integer id) throws SQLException {
    Credentials credential = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      credential = session.get(Credentials.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return credential;
  }

  @Override
  public void create(Credentials credential) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(credential);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Credentials credential) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(credential);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Credentials credential = session.get(Credentials.class, id);
      if (credential != null) {
        session.delete(credential);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
