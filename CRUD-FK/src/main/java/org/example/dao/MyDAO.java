package org.example.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.example.entity.MyEntity;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Singleton
public class MyDAO extends AbstractDAO<MyEntity> {

    @Inject
    public MyDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public MyEntity findById(Long id) {
        return query("select name from MyEntity where id=" + id).getFirstResult();
    }

    public MyEntity save(MyEntity entity) {
        return persist(entity);
    }

    public void delete(MyEntity entity) {
        currentSession().delete(entity);
    }

}
