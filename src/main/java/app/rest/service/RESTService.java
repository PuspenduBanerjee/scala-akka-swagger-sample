package app.rest.service;

import app.rest.model.DummyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by 258265 on 9/13/2016.
 */
@Api(value = "Service Root")
@Path("/service")
public interface RESTService {
    @GET
    @ApiOperation(value = "whoami")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    DummyResponse getInfo(@QueryParam(value = "whoami") String whoami);
}
