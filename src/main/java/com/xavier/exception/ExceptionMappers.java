package com.xavier.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.NotFoundException;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<String> mapException(NotFoundException x) {
        return RestResponse.status(Response.Status.NOT_FOUND);
    }

}
