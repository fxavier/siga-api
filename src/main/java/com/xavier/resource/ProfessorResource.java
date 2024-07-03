package com.xavier.resource;

import com.xavier.dto.ProfessorDTO;
import com.xavier.service.ProfessorService;

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

@Path("/professores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    @Inject
    private ProfessorService professorService;

    @POST
    public Response create(ProfessorDTO professorDTO) {
        ProfessorDTO professorCriado = professorService.create(professorDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(professorCriado)
                       .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(professorService.findAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(professorService.findById(id))
                       .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProfessorDTO professorDTO) {
        return Response.ok(professorService.update(id, professorDTO))
                       .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        professorService.delete(id);
        return Response.noContent()
                       .build();
    }
    
}
