package org.example.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.example.entity.MyBooks;
import org.example.entity.MyEntity;
import org.hibernate.SessionFactory;
import java.util.List;
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

    public List<MyBooks> getAllBooks() {
        return query("select name from MyBooks").list();
    }

    public List<MyBooks> getBookByID(Integer id) {

        return query("select name from MyBooks where author_id=" + id).getResultList();
    }

    public Integer save(MyBooks book) {
         return persist(MyBooks).getBookId();
    }






}
