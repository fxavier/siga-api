package com.xavier.resource;

import com.xavier.dto.PaiDTO;
import com.xavier.service.PaiService;

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

@Path("/pais")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaiResource {
    
    @Inject
    private PaiService paiService;

    @POST
    public Response create(PaiDTO paiDTO) {
        PaiDTO paiCriado = paiService.create(paiDTO);
        return Response.status(Response.Status.CREATED)
                .entity(paiCriado)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PaiDTO paiDTO) {
        return Response.ok(paiService.update(id, paiDTO))
                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(paiService.findAll())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(paiService.findById(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        paiService.delete(id);
        return Response.noContent()
                .build();
    }
}
