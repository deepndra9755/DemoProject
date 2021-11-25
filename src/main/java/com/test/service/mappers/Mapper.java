package com.test.service.mappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.api.models.*;
import com.test.api.models.User;
import com.test.dao.models.*;
import com.test.service.models.*;
import io.dropwizard.jackson.Jackson;
import lombok.NonNull;

import java.io.UncheckedIOException;
import java.util.*;
import java.util.stream.Collectors;

public class Mapper {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    public static EmployeeRow toEmployeeRow(EmployeeMeta employeeMeta)
    {
     return new EmployeeRow(newRowUuid(), employeeMeta.getName(), employeeMeta.getCity(), employeeMeta.getPhone(), toJson(employeeMeta.getEmeta()));
    }

    public static UserRow toUserRow(UserMeta userMeta)
    {
        return new UserRow(newRowUuid(),userMeta.getFirstName(),userMeta.getLastName(),userMeta.getPhone(),toJson(userMeta.getHobbies()),userMeta.getDescription(),userMeta.getCreatedAt(),userMeta.getUpdatedAt());
    }

    public static StudentMarksRow toStudentMarksRow(StudentParseFlowMeta studentParseFlowMeta)
    {
       return new StudentMarksRow(studentParseFlowMeta.getUuid(),toJson(studentParseFlowMeta.getMarks()));
    }




    public static String toJson(@NonNull final Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Employee toEmployee(EmployeeRow employeeRow) {
        return new Employee(
                employeeRow.getUuid(),
                employeeRow.getName(),
                employeeRow.getCity(),
                employeeRow.getPhone(),
                employeeRow.getRowMeta());
    }
    public static Student toStudent(StudentRow studentRow)
    {
       return new Student(studentRow.getUuid(),studentRow.getName(),studentRow.getCity(),studentRow.getPhone(),studentRow.getMarks());
    }

    public static List<Employee> toEmployeeList(List<EmployeeRow> employeeRows)
    {
        List<Employee> employees=new ArrayList<Employee>();
        for(EmployeeRow employeeRow:employeeRows) {

          Employee employee=new Employee(employeeRow.getUuid(),employeeRow.getName(),employeeRow.getCity(),employeeRow.getPhone(), employeeRow.getRowMeta());
          employees.add(employee);
        }
        return employees;
    }
    private static UUID newRowUuid() {
        return UUID.randomUUID();
    }


    public static StudentRow toStudentRow(StudentFlowMeta studentFlowMeta) {
      return new StudentRow(studentFlowMeta.getUuid(),studentFlowMeta.getName(),studentFlowMeta.getCity(),studentFlowMeta.getPhone(),toJson(studentFlowMeta.getMarks()));

    }
         public static AddressRow toAddressRow(AddressMeta userMeta) {
        return new AddressRow(newRowUuid(), userMeta.getHouse_number(), userMeta.getStreet(), userMeta.getLandmark(), userMeta.getCity(), userMeta.getState(), userMeta.getZipcode());
    }

        public static StudentRowGen toStudentRowGen(StudentFlowMeta studentflowmeta) {
     return new StudentRowGen(studentflowmeta.getUuid(),studentflowmeta.getName(),studentflowmeta.getCity(),studentflowmeta.getPhone(),new Date(),toJson(studentflowmeta.getMarks()));
    }

/*
    public static User toUser(UserInfoAddressRow userInfoRo) {
        return new User(userInfoRo.getUuid(),userInfoRo.getFirst_name(),userInfoRo.getLast_name(),userInfoRo.getPhone(),Arrays.asList(userInfoRo.getHobbies()),userInfoRo.getDescription(),userInfoRo.getCreated_at(),userInfoRo.getUpdated_at(),userInfoRo.getHouse_number(),userInfoRo.getCity(),userInfoRo.getStreet(),userInfoRo.getLandmark(),userInfoRo.getState(),userInfoRo.getZipcode());
    }*/

  /*  public static User toUserFlow(UserMeta userInfoRo) {
        return new User(userInfoRo.getUuid(),userInfoRo.getFirstName(),userInfoRo.getLastName(),userInfoRo.getPhone(),toJson(userInfoRo.getHobbies()),userInfoRo.getDescription(),userInfoRo.getCreatedAt(),userInfoRo.getUpdatedAt(),userInfoRo.getAddress());

    }*/


   /* public static com.test.service.models.User toUser(UserInfoAddressRow userInfo) {

return new com.test.service.models.User(userInfo.getUuid(),userInfo.getFirst_name(),userInfo.getLast_name(),userInfo.getPhone(),userInfo.getHobbies(),userInfo.getDescription(),userInfo.getCreated_at(),userInfo.getCreated_at(),userInfo.getHouse_number(),userInfo.getCity(),userInfo.getStreet(),userInfo.getLandmark(),userInfo.getState(),userInfo.getZipcode());

    }
*/

   /* public static List<com.test.service.models.User> toUserList(List<UserInfoAddressRow> rows) {
        ArrayList obj=new ArrayList();
        for (UserInfoAddressRow row:rows)
        {
         com.test.service.models.User user=new com.test.service.models.User(row.getUuid(),row.getFirst_name(),row.getLast_name(),row.getPhone(),row.getHobbies(),row.getDescription(),row.getCreated_at(),row.getUpdated_at(),row.getHouse_number(),row.getCity(),row.getStreet(),row.getLandmark(),row.getState(),row.getZipcode());
          user.toString();
         obj.add(user);
        }
        return obj;
    }*/

    public static List<Address> toUserAddressInformation(List<AddressRow> list) {
        ArrayList object=new ArrayList();
        for(AddressRow row:list)
        {
           // Address addressinformation=new Address(row.getUuid(),row.getHouse_number(),row.getStreet(),row.getLandmark(),row.getCity(),row.getState(),row.getZipcode());
        Address addressinformation= new Address(row.getHouseNumber(),row.getStreet(),row.getCity(),row.getLandmark(),row.getState(),row.getZipcode());
           object.add(addressinformation);
        }
        return object;
    }

    public static User toUserMetaInfo(UserRow meta, List<Address> addresses) {

   return new User(meta.getUuid(),meta.getFirstName(),meta.getLastName(),meta.getPhone(),meta.getHobbies(),meta.getDescription(),meta.getCreatedAt(),meta.getUpdatedAt(),addresses);
    }

/*

    public static UserFlowMeta toUserFlowMeta(UserRow row) {
        return new UserFlowMeta(row.getUuid(),row.getFirstName(),row.getLastName(),row.getPhone(),row.getHobbies(),row.getDescription(),row.getCreatedAt(),row.getUpdatedAt());
    }*/

/*
    public static UserAddressinformation toUserAddressinformation(UserRow row) {
        return new UserAddressinformation(row.getHouse_number(),row.getStreet(),row.getLandmark(),row.getCity(),row.getState(),row.getZipcode());
    }*/

    public static UserRow toUserMetaRow(UserRow row) {
        return new UserRow(row.getUuid(),row.getFirstName(),row.getLastName(),row.getPhone(),row.getHobbies(),row.getDescription(),row.getCreatedAt(),row.getUpdatedAt());
    }

    public static Address toUserAddress(AddressRow urow) {
       return new Address(urow.getHouseNumber(),urow.getStreet(),urow.getCity(),urow.getLandmark(),urow.getState(),urow.getZipcode());
    }

    public static AddressRow toAddressRow(UserAddressMeta addressinformation) {
        return new AddressRow(newRowUuid(),addressinformation.getHouse_number(),addressinformation.getStreet(),addressinformation.getLandmark(),addressinformation.getCity(),addressinformation.getState(),addressinformation.getZipcode());
    }


/*
    public UserAddressMetaRow toUserAddressMetaRow(UserMeta userMeta)
{
return null;
}
*/
    public static List<Student> toStudentList(List<StudentRow> studentRows)
    {
        return studentRows.stream().map(Mapper::toStudent).collect(Collectors.toList());
    }


    public static EmployeeMetaRow toEmployeeMetaRow(EmployeeParseFlowMeta employeeParseFlowMeta) {
        return new EmployeeMetaRow(employeeParseFlowMeta.getUuid(),employeeParseFlowMeta.getMeta());
    }
    /*  public static UserRowMeta toUserRowMeta(UserMeta userMeta)
       {
           return new UserRowMeta(newRowUuid(),userMeta.getFirstName(),userMeta.getLastName(),userMeta.getPhone(),toJson(userMeta.getHobbies()),userMeta.getDescription(),userMeta.getCreatedAt(),userMeta.getUpdatedAt());
       }*/

     /*  public static AddressRow toAddressRow(UserAddressRequest userMeta)
       {
    return new AddressRow(newRowUuid(),userMeta.getHouse_number(),userMeta.getStreet(),userMeta.getLandmark(),userMeta.getCity(),userMeta.getState(),userMeta.getZipcode());
       }*/

}
