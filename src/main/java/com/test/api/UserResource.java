package com.test.api;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;
import com.test.MetisException;
import com.test.api.exceptions.*;
import com.test.api.mappers.Mapper;
import com.test.api.models.*;
import com.test.service.UserService;
import com.test.service.exceptions.MetisServiceException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Path("/api/v1")
@Api(value = "User Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @Timed
    @ResponseMetered
    @ExceptionMetered
    @POST
    @Path("/users/{userid}")
    public Response createUser(@Valid UserRequest request) throws MetisException {
        toUserValidation(request);
        toNumberValidation(request.getPhone());
        UserMeta userMeta = Mapper.toUserMeta(request);
        User info = userService.createUser(userMeta);
        UserResponse response = Mapper.toUserResponse(info);
        return Response.ok(response).build();
    }


    @Timed
    @ResponseMetered
    @ExceptionMetered
    @GET
    @Path("/users/{userid}")
    public Response get(@PathParam("userid") UUID uuid) throws MetisException {
        throwIfIdNotExist(uuid);
        User info = userService.getUserDetails(uuid);
        UserResponse response = Mapper.toUserResponse(info);
        return Response.ok(response).build();
    }

    @Timed
    @ResponseMetered
    @ExceptionMetered
    @GET
    @Path("/users")
    public Response getList() throws MetisException {
        List<User> list = userService.listAll();
        List<UserResponse> userResponses = Mapper.toUserResponse(list);
        return Response.ok(userResponses).build();
    }

    @Timed
    @ResponseMetered
    @ExceptionMetered
    @PUT
    @Path("/users/{userid}")
    public Response updateUser(@PathParam("userid") UUID uuid, UserRequest request) throws MetisException {
        throwIfIdNotExist(uuid);
        toNumberValidation(request.getPhone());
        UserMeta userMeta = Mapper.toUserMeta(request);
        User info = userService.updateUser(uuid, userMeta);
        UserResponse response = Mapper.toUserResponse(info);
        return Response.ok(response).build();
    }

    @Timed
    @ResponseMetered
    @ExceptionMetered
    @PATCH
    @Path("/users/{userid}/address")
    public Response addAddress(@PathParam("userid") UUID uuid, UserAddressRequest request) throws MetisException {
        throwIfIdNotExist(uuid);
        AddressMeta meta = Mapper.toUserAddress(request);
        User info = userService.addUserAddress(uuid, meta);
        UserResponse response = Mapper.toUserResponse(info);
        return Response.ok(response).build();
    }

    @Timed
    @ResponseMetered
    @ExceptionMetered
    @DELETE
    @Path("/users/{userid}")
    public Response deleteUser(@PathParam("userid") UUID uuid) throws MetisException {
        throwIfIdNotExist(uuid);
        User info = userService.delete(uuid);
        UserResponse response = Mapper.toUserResponse(info);
        return Response.ok(response).build();
    }


    public void throwIfIdNotExist(UUID uuid) {
        if (!userService.exists(uuid)) {
            throw new UserIdNotFoundException(uuid);
        }
    }


    private void toUserValidation(UserRequest request) {
        try {
            if (request.getFirstName().isEmpty()) {
                throw new UserNameMustNotEmptyException("");
            } else if (request.getLastName().isEmpty()) {
                throw new UserLastNameMustNotEmptyException("");
            }

        } catch (NullPointerException e) {
            throw new AllFieldMandatoryException("");
        } catch (Exception e) {
            log.error(
                    "Failed to validate '{} :",
                    e);
            throw new FormValidationException("",e);
        }


    }


    void toNumberValidation(String num) throws MetisException {
        try {
            String regex = "[+-]?[0-9]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(num);
            if (num.length() == 10 && m.find() && m.group().equals(num)) {

            } else
                throw new InvalidPhoneNumberException();
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Mobile Number Not Valid'",
                    e);
            throw new InvalidPhoneNumberException();
        }
    }

    void toZipcodeValid(String num) throws MetisException {
        try {
            String regex = "[+-]?[0-9]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(num);
            if (num.length() == 6 && m.find() && m.group().equals(num)) {
            } else
                throw new InvalidZipcodeException("");
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Mobile Number Not Valid'",
                    e);
            throw new InvalidZipcodeException("Zipcode Format Not Currect");
        }
    }


}
