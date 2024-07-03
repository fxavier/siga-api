package com.xavier.resource;

import com.xavier.dto.TurmaDTO;
import com.xavier.service.TurmaService;

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

@Path("/turmas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TurmaResource {

    @Inject
    TurmaService turmaService;

    @POST
    public Response create(TurmaDTO turmaDTO) {
        TurmaDTO turmaCriada = turmaService.create(turmaDTO);
        return Response.status(Response.Status.CREATED).entity(turmaCriada).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(turmaService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(turmaService.findById(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TurmaDTO turmaDTO) {
        return Response.ok(turmaService.update(id, turmaDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        turmaService.delete(id);
        return Response.noContent().build();
    }
    
}
