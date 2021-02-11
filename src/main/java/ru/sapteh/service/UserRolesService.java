package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.UserRoles;

import java.util.List;

public class UserRolesService implements DAO<UserRoles, Integer> {
    private final SessionFactory factory;

    public UserRolesService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public UserRoles read(Integer id) {
        try (Session session = factory.openSession()) {
            UserRoles userRoles = session.get(UserRoles.class, id);
            return userRoles;
        }
    }

    @Override
    public List<UserRoles> findByAll() {
        try (Session session = factory.openSession()) {
            Query<UserRoles> result = session.createQuery("FROM UserRoles ");
            return result.list();
        }
    }

    @Override
    public void create(UserRoles userRoles) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(userRoles);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(UserRoles userRoles) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(userRoles);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(UserRoles userRoles) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(userRoles);
            session.getTransaction().commit();
        }
    }
}

