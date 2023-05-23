package org.example.resource;

import org.example.dao.MyDAO;
import org.example.entity.MyEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/mywriter")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    private final MyDAO dao;

    @Inject
    public MyResource(MyDAO dao) {
        this.dao = dao;
    }

    @GET
    public String getAll() {
        return dao.findAll();
    }

    @GET
    @Path("/{id}")
    public MyEntity getById(@PathParam("id") Long id) {
        return dao.findById(id);
    }

    @POST
    public MyEntity create(MyEntity entity) {
        return dao.save(entity);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        final MyEntity entity = dao.findById(id);
        dao.delete(entity);
    }

}