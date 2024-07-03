package com.xavier.resource;


import com.xavier.dto.DocumentoDTO;
import com.xavier.service.DocumentoService;

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

@Path("/documentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentoResource {

    @Inject
    private DocumentoService documentoService;

    @POST
    public Response create(DocumentoDTO documentoDTO) {
        DocumentoDTO documentoCriado = documentoService.create(documentoDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(documentoCriado)
                       .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(documentoService.findAll())
                       .build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(documentoService.findById(id))
                       .build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, DocumentoDTO documentoDTO) {
        DocumentoDTO documentoAtualizado = documentoService.update(id, documentoDTO);
        return Response.ok(documentoAtualizado)
                       .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        documentoService.delete(id);
        return Response.noContent()
                       .build();
    }
    
    
}
