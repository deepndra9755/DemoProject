package com.test.dao;

import com.test.dao.models.StudentMarksRow;
import com.test.dao.models.StudentRow;
import com.test.dao.models.StudentRowGen;
import com.test.dao.models.StudentRowMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RegisterRowMapper(StudentRowMapper.class)
public interface StudentDaoImpl {

    @SqlQuery("SELECT * FROM  studentinfo where id=:studId")
    Optional<StudentRow> findStud(@Bind("studId") UUID studId);


    @SqlUpdate("INSERT INTO studentinfo (id, name, city, phone, marks) "+"VALUES (:uuid, :name, :city, :phone, cast(:marks as jsonb))")
    void insertStudentInfo(@BindBean StudentRow studentRow);

    @SqlQuery("SELECT * FROM studentinfo limit :limit offset :offset" )
    List<StudentRow> findAllStudents(@Bind("limit") Integer limit,@Bind("offset") Integer offset);

    @SqlUpdate("update studentinfo set name=:name,city=:city,phone=:phone,marks=cast(:marks as jsonb) where id=:uuid")
    void updateStudentById(@BindBean StudentRow studentRow);


    @SqlUpdate("DELETE FROM studentinfo where id=:id")
    void deleteStudentByid(@Bind("id") UUID id);

    @SqlUpdate("update studentinfo set marks=cast(:marks as jsonb) where id=:uuid")
    void updateStudentMarks(@BindBean StudentRow studentRow);

    @SqlUpdate("INSERT INTO studentinfo (id, name, city, phone, marks) "+"VALUES (:uuid, :name, :city, :phone, cast(:marks as jsonb),:dates)")
    void insertStudentReq(@BindBean StudentRowGen studentRowGen);

}
