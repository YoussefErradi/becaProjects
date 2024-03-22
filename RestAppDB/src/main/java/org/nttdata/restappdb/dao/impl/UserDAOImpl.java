package org.nttdata.restappdb.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.nttdata.restappdb.dao.UserDAO;
import org.nttdata.restappdb.model.User;
import org.nttdata.restappdb.util.HibernateUtil;


import java.util.List;

public class UserDAOImpl implements UserDAO {

    public void addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> listUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void removeUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserByLogin(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where name = :name");
        query.setParameter("name", name);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User getUserByLoginAndPassword(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where name = :name and password = :password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
