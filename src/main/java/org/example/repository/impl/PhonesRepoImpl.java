package org.example.repository.impl;

import org.example.configuration.Connection;
import org.example.repository.PhonesRepository;
import org.example.unit.Phones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PhonesRepoImpl implements PhonesRepository {

    private final SessionFactory sessionfactory = Connection.getSessionFactory();

    @Override
    public void save(Phones phones) {
        try (Session session = sessionfactory.openSession()) {
            session.save(phones);
        }
    }

    @Override
    public Phones getById(Long id) {
        try (Session session = sessionfactory.openSession()) {
            return session.get(Phones.class, id);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionfactory.openSession()) {
            session.beginTransaction();
            Phones phones = getById(id);
            session.delete(phones);
            session.getTransaction().commit();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public List<Phones> findAll() {
        try (Session session = sessionfactory.openSession()) {
            Query<Phones> query = session.createQuery("select p from Phones p", Phones.class);
            List<Phones> people = query.getResultList();
            return people;
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = sessionfactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Phones p").executeUpdate();
            session.getTransaction().commit();
        }
    }
}