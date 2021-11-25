package com.test.service;

import com.test.dao.IEmpDaoImpl;
import com.test.dao.StudentDaoImpl;
import com.test.dao.models.EmployeeRow;
import com.test.dao.models.StudentMarksRow;
import com.test.dao.models.StudentRow;
import com.test.dao.models.StudentRowGen;
import com.test.service.mappers.Mapper;
import com.test.service.models.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentServiceImpl {


    private final StudentDaoImpl dao;

    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.dao = studentDao;
    }

    public Student insertStudent(StudentFlowMeta studentFlowMeta)
    {
        StudentRow studentRow=Mapper.toStudentRow(studentFlowMeta);
        StudentRowGen studentRowGen=Mapper.toStudentRowGen(studentFlowMeta);
        dao.insertStudentInfo(studentRow);
        dao.insertStudentReq(studentRowGen);
        return  getStudent(studentFlowMeta.getUuid());
    }
    public Student deleteStudById(UUID uuid)
    {
        Optional<StudentRow> studentRow=dao.findStud(uuid);
        if(studentRow.isPresent())
        {
            StudentRow studentRow1=studentRow.get();
            dao.deleteStudentByid(uuid);
            return Mapper.toStudent(studentRow1);
        }
        throw new RuntimeException();
    }


    public Student updateStudentMarks(UUID uuid, StudentParseFlowMeta studentParseFlowMeta)
    {

        StudentMarksRow studentMarksRow=Mapper.toStudentMarksRow(studentParseFlowMeta);
        Optional<StudentRow> studentRow=dao.findStud(uuid);
        if(studentRow.isPresent())
        {
            //1st
            StudentRow studentRow1=studentRow.get();
            studentRow1.setMarks(studentMarksRow.getMarks());
            dao.updateStudentMarks(studentRow1);
            Optional<StudentRow> studentRow5=dao.findStud(uuid);
            StudentRow studentRow6=studentRow5.get();
            return Mapper.toStudent(studentRow6);
        }
        throw new RuntimeException("not found");
    }


    public Student updateStudentById(UUID uuid,StudentFlowMeta studentFlowMeta)
    {
        StudentRow studentRow=Mapper.toStudentRow(studentFlowMeta);

        Optional<StudentRow> studentRow1=dao.findStud(uuid);
        if(studentRow1.isPresent())
        {
        /*    StudentRow studentRow4=studentRow1.get();
            studentRow.setCity(studentRow4.getCity());
            studentRow.setName(studentRow4.getName());
            studentRow.setPhone(studentRow4.getPhone());*/

            dao.updateStudentById(studentRow);
            Optional<StudentRow> studentRow2=dao.findStud(uuid);
            if(studentRow2.isPresent())
            {
                StudentRow studentRow3=studentRow2.get();
                return Mapper.toStudent(studentRow3);
            }
        }
        throw new RuntimeException("record not found");

    }



    public List<Student> findAllStudents(Integer limit,Integer offset)
    {
        List<StudentRow> studentRows=dao.findAllStudents(limit,offset);
        return Mapper.toStudentList(studentRows);

    }


    public Student getStudent(UUID stdid) {
        Optional<StudentRow> row = dao.findStud(stdid);
        if (row.isPresent()) {
            return Mapper.toStudent(row.get());
        } else {
            throw new RuntimeException("student not found");
        }
    }

}
