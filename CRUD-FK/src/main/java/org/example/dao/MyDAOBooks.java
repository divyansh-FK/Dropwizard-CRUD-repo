package org.example.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.example.entity.MyBooks;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Singleton
public class MyDAOBooks extends AbstractDAO<MyBooks> {

    @Inject
    public MyDAOBooks(SessionFactory sessionFactory) {
        super(sessionFactory);
    }



    public MyBooks save(MyBooks entity) {
        return persist(entity);
    }


}
