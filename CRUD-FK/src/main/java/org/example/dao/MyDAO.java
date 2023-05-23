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

    public String findAll() {
        final CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        final CriteriaQuery<MyEntity> criteria = builder.createQuery(MyEntity.class);
        final Root<MyEntity> root = criteria.from(MyEntity.class);
        criteria.select(root);
        return "list(criteria)";
    }

    public MyEntity findById(Long id) {
        return get(id);
    }

    public MyEntity save(MyEntity entity) {
        return persist(entity);
    }

    public void delete(MyEntity entity) {
        currentSession().delete(entity);
    }

}
