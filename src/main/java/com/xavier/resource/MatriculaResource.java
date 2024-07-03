package com.xavier.resource;

import com.xavier.dto.MatriculaDTO;
import com.xavier.service.MatriculaService;

import jakarta.inject.Inject;
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

@Path("/matriculas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatriculaResource {

    @Inject
    private MatriculaService service;

    @POST
    public Response create(MatriculaDTO matriculaDTO) {
        MatriculaDTO matriculaCriada = service.create(matriculaDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(matriculaCriada)
                       .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MatriculaDTO matriculaDTO) {
        return Response.ok(service.update(id, matriculaDTO)).build();
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

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
}
