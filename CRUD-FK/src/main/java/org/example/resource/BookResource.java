package org.example.resource;

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

    private final MyDAOBooks dao;

    @Inject
    public BookResource(MyDAOBooks dao) {
        this.dao = dao;
    }

    @GET
    public List<MyEntity> getAll() {
        return dao.findAll();
    }

    @GET
    @Path("/{id}")
    public MyEntity getById(@PathParam("id") Long id) {
        return dao.findById(id);
    }

    @POST
    public MyBooks create(MyBooks entity) {
        return dao.save(entity);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        final MyEntity entity = dao.findById(id);
        dao.delete(entity);
    }

}