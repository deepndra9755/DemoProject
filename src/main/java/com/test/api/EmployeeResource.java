package com.test.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.api.mappers.Mapper;
import com.test.api.models.*;
import com.test.service.EmpServiceImpl;
import com.codahale.metrics.annotation.Timed;
import com.test.service.models.*;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Timed
@Path("/api/v1")
@Api(value = "Employee Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class EmployeeResource {

    private final EmpServiceImpl service;

    public EmployeeResource(EmpServiceImpl service) {
        this.service = service;
    }


    @POST
    @Path("/employees")
    public Response add(@Valid EmployeeRequest employeeRequest) {
        log.info("request: {}", employeeRequest);
        EmployeeMeta employeeMeta = Mapper.toEmployeeFlowMeta(employeeRequest);
        Employee employee = service.add(employeeMeta);
        EmployeeResponse response = Mapper.toEmployeeResponse(employee);
        return Response.ok(response).build();
    }

    @GET
    @Path("/employees/{id}")
    public Response findEmpById(@PathParam("id") String id) {
        UUID uuid = UUID.fromString(id);
        Employee employee = service.getEmployee(uuid);
        EmployeeResponse employeeResponse = Mapper.toEmployeeResponse(employee);
        return Response.ok(employeeResponse).build();

    }

    @GET
    @Path("/employees")
    public Response findAllEmp() {
        //main//List<Employee> employees=service.findAllEmployees();
        List<Employee> employees = service.findAllEmp();
        List<EmployeeResponse> workFlowResponses = Mapper.toEmployeeResponse(employees);
        return Response.ok(workFlowResponses).build();

    }

    @DELETE
    @Path("/employees/{id}")
    public Response deleteEmployeeById(@PathParam("id") String id) {
        UUID uuid = UUID.fromString(id);
        Employee employee = service.deleteEmployeeByid(uuid);
        EmployeeResponse employeeResponse = Mapper.toEmployeeResponse(employee);
        return Response.ok(employeeResponse).build();
    }


    @PUT
    @Path("/employees/{id}")
    public Response updateEmployeeById(@PathParam("id") String id, @Valid EmployeeRequest request) {
        EmployeeMeta employeeMeta = Mapper.toEmployeeFlowMeta(request);
        Employee emp = service.updateEmpById(UUID.fromString(id), employeeMeta);
        EmployeeResponse employeeResponse = Mapper.toEmployeeResponse(emp);
        return Response.ok(employeeResponse).build();

    }

    @PATCH
    @Path("/employees/{id}")
    public Response updateEmployeeMeta(@PathParam("id") String id, @Valid EmployeeRequestParse employeeRequestParse) {
        UUID uuid = UUID.fromString(id);
        EmployeeParseFlowMeta employeeParseFlowMeta = Mapper.toEmployeeParseMeta(employeeRequestParse, uuid);
        Employee employee = service.updateMeta(employeeParseFlowMeta);
        EmployeeResponse employeeResponse = Mapper.toEmployeeResponse(employee);
        return Response.ok(employeeResponse).build();
    }


}