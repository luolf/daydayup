package org.llf.sofaboot.demo.web.endpoint.facade;

import org.llf.sofaboot.demo.web.endpoint.exception.CommonException;
import org.llf.sofaboot.demo.web.endpoint.constants.RestConstants;

import javax.ws.rs.*;

@Path("/favicon.ico")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface FaviconRestFacade {

    @GET
    public String faviconIco() throws CommonException;
}
