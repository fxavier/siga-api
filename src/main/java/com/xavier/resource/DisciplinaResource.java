package com.xavier.resource;

import com.xavier.dto.DisciplinaDTO;
import com.xavier.service.impl.DisciplinaService;

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

@Path("/disciplinas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    @Inject
    private DisciplinaService disciplinaService;

    @POST
    public Response create(DisciplinaDTO disciplinaDTO) {
        DisciplinaDTO disciplinaCriada = disciplinaService.create(disciplinaDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(disciplinaCriada)
                       .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(disciplinaService.findAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(disciplinaService.findById(id))
                       .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DisciplinaDTO disciplinaDTO) {
        return Response.ok(disciplinaService.update(id, disciplinaDTO))
                       .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        disciplinaService.delete(id);
        return Response.noContent()
                       .build();
    }
    
}
