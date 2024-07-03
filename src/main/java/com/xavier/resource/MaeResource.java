package com.xavier.resource;


import com.xavier.dto.MaeDTO;
import com.xavier.service.MaeService;

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

@Path("/maes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MaeResource {

    @Inject
    MaeService maeService;

    @POST
    public Response create(MaeDTO maeDTO) {
       MaeDTO maeCriada = maeService.create(maeDTO);
        return Response.status(Response.Status.CREATED)
                .entity(maeCriada)
                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(maeService.findAll())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(maeService.findById(id))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MaeDTO maeDTO) {
        return Response.ok(maeService.update(id, maeDTO))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        maeService.delete(id);
        return Response.noContent()
                .build();
    }

    
}
