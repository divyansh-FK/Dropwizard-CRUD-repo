package org.example.resource;

import io.dropwizard.hibernate.UnitOfWork;
import org.example.entity.MyBooks;
import org.example.dao.MyDAOBooks;
import org.example.entity.MyEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final MyDAOBooks bookDao;

    @Inject
    public BookResource(MyDAOBooks bookDao) {
        this.bookDao = bookDao;
    }

    @GET
    @Path("/{id}")
    public MyBooks getBooksByAuthId(@PathParam("id") Integer id) {

        return bookDao.getBookByID(id);
    }

    @GET
    public MyBooks getAllBooks() {

        return bookDao.getAllBooks();
    }
    @POST
    public Integer create(MyBooks entity) {
        return bookDao.save(entity);
    }



}