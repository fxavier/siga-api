package com.xavier.resource;

import com.xavier.dto.ClasseDTO;
import com.xavier.service.ClasseService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/classes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClasseResource {

    @Inject
    private ClasseService service;

    @POST
    public Response create(ClasseDTO classeDTO) {
        ClasseDTO classeCriada = service.create(classeDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(classeCriada)
                       .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(service.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid ClasseDTO classeDTO) {
        return Response.ok(service.update(id, classeDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
}
