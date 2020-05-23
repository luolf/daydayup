package org.llf.sofaboot.demo.web.endpoint.facade;

import org.llf.sofaboot.demo.web.endpoint.constants.URLConstants;
import org.llf.sofaboot.demo.web.endpoint.exception.CommonException;
import org.llf.sofaboot.demo.web.endpoint.constants.RestConstants;
import org.llf.sofaboot.demo.web.endpoint.model.DemoUserModel;
import org.llf.sofaboot.demo.web.endpoint.response.RestSampleFacadeResp;

import javax.ws.rs.*;

@Path(URLConstants.REST_API_PEFFIX + "/users")
@Consumes(RestConstants.DEFAULT_CONTENT_TYPE)
@Produces(RestConstants.DEFAULT_CONTENT_TYPE)
public interface SampleRestFacade {

    /**
     * Query for user.
     * For example: http://localhost:8341/webapi/users/xiaoming
     * @param userName user's account name
     * @return
     */
    @GET
    @Path("/{userName}")
    public RestSampleFacadeResp<DemoUserModel> userInfo(@PathParam("userName") String userName) throws CommonException;

    /***
     * Add user, you can use postman to mock the post request.
     * @param userName user's account name
     * @param realName user's real name
     * @return
     */
    @POST
    @Path("/")
    public RestSampleFacadeResp<Integer> addUserInfo(DemoUserModel user);

    /**
     * Delete user.
     * @param userName user's account name
     * @return
     */
    @DELETE
    @Path("/{userName}")
    public RestSampleFacadeResp<Integer> deleteUser(@PathParam("userName") String userName);

    /***
     * Update user.
     * @param userName user's account name
     * @param demoUserModel demo user model
     * @return
     */
    @PUT
    @Path("/{userName}")
    public RestSampleFacadeResp<Integer> updateUser(@PathParam("userName") String userName, DemoUserModel demoUserModel);
}
