package com.xavier.resource;

import com.xavier.dto.TipoDocumentoDTO;
import com.xavier.service.TipoDocumentoService;

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

@Path("/tipo-documentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoDocumentoResource {

    @Inject
    TipoDocumentoService tipoDocumentoService;

    @POST
    public Response create(TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumentoDTO tipoDocumentoCriado = tipoDocumentoService.create(tipoDocumentoDTO);
        return Response.status(Response.Status.CREATED)
                .entity(tipoDocumentoCriado)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TipoDocumentoDTO tipoDocumentoDTO) {
        return Response.ok(tipoDocumentoService.update(id, tipoDocumentoDTO))
                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(tipoDocumentoService.findAll())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(tipoDocumentoService.findById(id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        tipoDocumentoService.delete(id);
        return Response.noContent()
                .build();
    }
    
}
