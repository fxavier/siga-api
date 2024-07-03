package com.xavier.resource;

import com.xavier.model.Country;
import com.xavier.service.CountryService;

import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/countries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {
    
    @Inject
    CountryService countryService;

    @POST
    public Response create(Country country) {
        Country countryCriado = countryService.create(country);
        return Response.status(Response.Status.CREATED)
                       .entity(countryCriado)
                       .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(countryService.findAll())
                       .build();
    }
    @GET
    @Path("{id}")
    public Response findById(Long id) {
        return Response.ok(countryService.findById(id))
                       .build();
    }

    @PUT
    @Path("{id}")
    public Response update(Long id, Country country) {
        return Response.ok(countryService.update(id, country))
                       .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(Long id) {
        countryService.delete(id);
        return Response.noContent()
                       .build();
    }
}
