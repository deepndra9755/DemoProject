package com.test.api.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.api.models.*;
import com.test.api.models.User;
import com.test.service.models.*;
import io.dropwizard.jackson.Jackson;

import java.io.UncheckedIOException;
import java.time.Instant;
import java.util.*;

public class Mapper {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    public static Map<String, Object> toMap(String jsonString) {
        if (jsonString == null) return null;
        JsonNode jsonNode = null;
        try {
            jsonNode = MAPPER.readTree(jsonString);
            return MAPPER.convertValue(jsonNode, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException exception) {
            throw new UncheckedIOException(exception);
        }
    }


    public static List<String> toList(String jsonString) {
        if (jsonString == null) return null;
        JsonNode jsonNode = null;
        try {
            jsonNode = MAPPER.readTree(jsonString);
            return MAPPER.convertValue(jsonNode, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException exception) {
            throw new UncheckedIOException(exception);
        }
    }






    public static EmployeeMeta toEmployeeFlowMeta(EmployeeRequest request) {
        return new EmployeeMeta(newRowUuid(), request.getName(), request.getCity(), request.getPhone(), request.getMeta());
    }

    public static EmployeeResponse toEmployeeResponse(Employee employee) {
        return new EmployeeResponse(employee.getUuid(), employee.getName(), employee.getCity(), employee.getPhone(), toMap(employee.getMeta()));
    }

    public static List<EmployeeResponse> toEmployeeResponse(List<Employee> employees) {
        List<EmployeeResponse> employeeResponses = new ArrayList<EmployeeResponse>();
        for (Employee employee : employees) {
            EmployeeResponse employeeResponse = new EmployeeResponse(employee.getUuid(), employee.getName(), employee.getCity(), employee.getPhone(), toMap(employee.getMeta()));
            employeeResponses.add(employeeResponse);
        }
        return employeeResponses;
    }


    public static StudentResponse toStudentResponse(Student student) {
        return new StudentResponse(student.getUuid(), student.getName(), student.getCity(), student.getPhone(), toMap(student.getMarks()));
    }

    public static StudentFlowMeta toStudentFlowMeta(StudentRequest request) {
        return new StudentFlowMeta(newRowUuid(), request.getName(), request.getCity(), request.getPhone(), request.getMarks());
    }

    public static UserMeta toUserMeta(UserRequest request)  {

           List<UserAddressRequest> addrss = request.getAddress();
           List<UserAddressMeta> userAddressinformations=new ArrayList();
           for(UserAddressRequest addressRequest:addrss)
           {
               UserAddressMeta addressinformation=new UserAddressMeta(addressRequest.getHouse_number(),addressRequest.getStreet(),addressRequest.getLandmark(),addressRequest.getCity(),addressRequest.getState(),addressRequest.getZipcode());
               userAddressinformations.add(addressinformation);
           }

     return new UserMeta(request.getFirstName(),request.getLastName(),request.getPhone(),request.getHobbies(),request.getDescription(),Instant.now(),Instant.now(),userAddressinformations) ;
    }

    public static String toList(List<String> strings) {
             String s1=strings.toString().replace("[","");
             s1=s1.replace("]","").trim();
             return s1;
    }

    public static StudentFlowMeta toStudentFlowMeta(StudentRequest request, UUID uuid) {
        return new StudentFlowMeta(uuid, request.getName(), request.getCity(), request.getPhone(), request.getMarks());
    }

    private static UUID newRowUuid() {
        return UUID.randomUUID();
    }

    public static List<StudentResponse> toStudentResponseList(List<Student> studentList) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : studentList) {
            StudentResponse studentResponse = new StudentResponse(student.getUuid(), student.getName(), student.getCity(), student.getPhone(), toMap(student.getMarks()));
            studentResponses.add(studentResponse);
        }
        return studentResponses;
    }

    public static StudentParseFlowMeta toStudentParseFlowMeta(StudentRequestParse studentRequestParse, UUID uuid) {

        return new StudentParseFlowMeta(uuid, studentRequestParse.getMarks());
    }

    public static EmployeeParseFlowMeta toEmployeeParseMeta(EmployeeRequestParse employeeRequestParse, UUID uuid) {

        return new EmployeeParseFlowMeta(uuid, employeeRequestParse.getMeta());
    }


   /* public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getFirst_name(), user.getLast_name(), user.getPhone(),toList(user.getHobbies()),user.getDescription(),user.getHouse_number(),user.getStreet(),user.getCity(),user.getLandmark(),user.getState(),user.getZipcode());
    }*/

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getUuid(),user.getFirstName(),user.getLastLame(),user.getPhone(),toList(user.getHobbies()),user.getDescription(),user.getCreatedAt(),user.getUpdatedAt(),user.getAddress());
    }


   /*public static List<UserResponse> toUserList(List<User> users) {

        ArrayList arrayList=new ArrayList();
        for(User user: users)
        {
            UserResponse response=new UserResponse(user.getFirst_name(), user.getLast_name(),user.getPhone(),toList(user.getHobbies()),user.getDescription());

        }
      return arrayList;
    }*/

    public static AddressMeta toUserAddress(UserAddressRequest request) {
        return new AddressMeta(request.getHouse_number(),request.getStreet(),request.getLandmark(),request.getCity(),request.getState(),request.getZipcode());

    }

    public static List<UserResponse> toUserResponse(List<User> list) {
        List <UserResponse> list1=new ArrayList<UserResponse>();
        for(User response:list)
        {
          UserResponse response1=Mapper.toUserResponse(response);
          list1.add(response1);
        }
        return list1;
    }
}


