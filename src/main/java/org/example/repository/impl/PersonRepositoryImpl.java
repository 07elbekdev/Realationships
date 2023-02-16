package org.example.repository.impl;

import org.example.configuration.Connection;
import org.example.repository.PersonRepository;
import org.example.unit.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    private final SessionFactory sessionFactory = Connection.getSessionFactory();

    public void save(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.save(person);
        }
    }

    public Person getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Person> query = session.createQuery("select p from Person p right join fetch p.phones where p.id=:id", Person.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = getById(id);
            session.delete(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Person> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Person> query = session.createQuery("select p from Person p", Person.class);
            List<Person> people = query.getResultList();
            return people;
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Person p").executeUpdate();
            session.createQuery("delete from Phones p").executeUpdate();
            session.getTransaction().commit();
        }
    }
}