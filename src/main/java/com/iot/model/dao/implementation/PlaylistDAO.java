package com.iot.model.dao.implementation;

import com.iot.model.entity.Playlist;
import com.iot.model.dao.GenericDAO;
import com.iot.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class PlaylistDAO implements GenericDAO<Playlist> {
  protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  @Override
  public List<Playlist> findAll() {
    List<Playlist> playlists = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      playlists = session.createQuery("from Playlist").getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return playlists;
  }

  @Override
  public Playlist findOne(Integer id) throws SQLException {
    Playlist playlist = null;

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      playlist = session.get(Playlist.class, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return playlist;
  }

  @Override
  public void create(Playlist playlist) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.save(playlist);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Playlist playlist) throws SQLException {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      session.update(playlist);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) {
    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      Playlist playlist = session.get(Playlist.class, id);
      if (playlist != null) {
        session.delete(playlist);
      }
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
