package com.xavier.resource;

import com.xavier.dto.InscricaoDTO;
import com.xavier.service.InscricacaoService;

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

@Path("/inscricoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InscricaoResource {

    @Inject
    private InscricacaoService inscricacaoService;

    @POST
    public Response create(InscricaoDTO inscricaoDTO) {
        InscricaoDTO inscricao = inscricacaoService.create(inscricaoDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(inscricao)
                       .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(inscricacaoService.findAll())
                       .build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(inscricacaoService.findById(id))
                       .build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, InscricaoDTO inscricaoDTO) {
        InscricaoDTO inscricao = inscricacaoService.update(id, inscricaoDTO);
        return Response.ok(inscricao)
                       .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        inscricacaoService.delete(id);
        return Response.noContent()
                       .build();
    }

    
}
