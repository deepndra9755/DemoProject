package com.test.api;

import com.codahale.metrics.annotation.Timed;
import com.test.api.mappers.Mapper;
import com.test.api.models.StudentRequest;
import com.test.api.models.StudentRequestParse;
import com.test.api.models.StudentResponse;
import com.test.service.StudentServiceImpl;
import com.test.service.models.Student;
import com.test.service.models.StudentFlowMeta;
import com.test.service.models.StudentParseFlowMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Timed
@Path("/api/v1")
@Api(value = "Student Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class StudentResource {
    StudentServiceImpl service;
    public StudentResource(StudentServiceImpl studentService)
    {
        this.service=studentService;
    }

    @POST
    @Path("/student")
    public Response addStudent(@Valid StudentRequest request) {
        StudentFlowMeta studentFlowMeta = Mapper.toStudentFlowMeta(request);
        Student student = service.insertStudent(studentFlowMeta);
        StudentResponse studentResponse = Mapper.toStudentResponse(student);

        return Response.ok(studentResponse).build();
    }

    @GET
    @Path("/student")
    public Response findAllStudents(@QueryParam("limit")  @DefaultValue("10") String limit,@QueryParam("offset") Integer offset) {

        List<Student> studentList=service.findAllStudents(Integer.parseInt(limit),offset);
        List<StudentResponse> studentResponses= Mapper.toStudentResponseList(studentList);

        return Response.ok(studentResponses).build();

    }

    @DELETE
    @Path("/student/{id}")
    public Response deleteStudentById(@PathParam("id") String id)
    {
        UUID uuid=UUID.fromString(id);
        Student student=service.deleteStudById(uuid);
        StudentResponse studentResponse=Mapper.toStudentResponse(student);
        return Response.ok(studentResponse).build();
    }

    @PUT
    @Path("/student/{id}")
    public Response updateStudentInfoById(@PathParam("id") String id,@Valid StudentRequest request)
    {
        UUID uuid=UUID.fromString(id);

        //StudentFlowMeta studentFlowMeta=Mapper.toStudentFlowMeta(request);
        StudentFlowMeta studentFlowMeta=Mapper.toStudentFlowMeta(request,uuid);

        Student student= service.updateStudentById(uuid,studentFlowMeta);
        StudentResponse studentResponse=Mapper.toStudentResponse(student);
        return Response.ok(studentResponse).build();
    }


    @GET
    @Path("/student/{id}")
    public Response findStudentById(@PathParam("id") String id)
    {
        UUID uuid=UUID.fromString(id);
        Student student=service.getStudent(uuid);
        StudentResponse studentResponse= Mapper.toStudentResponse(student);

        return Response.ok(studentResponse).build();
    }
    @PATCH
    @Path("/student/{id}")
    public Response updateStudentMarks(@PathParam("id") String  id,@Valid StudentRequestParse studentRequestParse)
    {
        UUID uuid=UUID.fromString(id);

        StudentParseFlowMeta studentParseFlowMeta =Mapper.toStudentParseFlowMeta(studentRequestParse,uuid);
        Student student=service.updateStudentMarks(uuid,studentParseFlowMeta);
        StudentResponse studentResponse=Mapper.toStudentResponse(student);
        return Response.ok(studentResponse).build();

    }








}
