package com.test.dao;

import com.test.dao.models.*;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RegisterRowMapper(EmployeeRowMapper.class)
public interface IEmpDaoImpl{

    @SqlUpdate(
            "INSERT INTO employees (id, name, city, phone, meta) "
                    + "VALUES (:uuid, :name, :city, :phone, cast(:rowMeta as jsonb))")
    void insert(@BindBean EmployeeRow row);

    @SqlQuery("SELECT * FROM employees WHERE id =:employeeId")
    Optional<EmployeeRow> find(@Bind("employeeId") UUID employeeId);

    @SqlQuery("SELECT * FROM employees")
    List<EmployeeRow> findAll();

    @SqlUpdate("delete from employees where id=:employeeID")
    void  deleteById(@Bind("employeeID")UUID employeeID);

    @SqlUpdate("update employees set name=:name,city=:city,phone=:phone where id=:uuid")
    void updateEmp(@BindBean EmployeeRow upd) ;


    @SqlUpdate("update employees set marks=jsonb_set() where id=:uuid")
    void updateEmployeeMeta(@BindBean EmployeeMetaRow employeeMetaRow);

//testdb=> update studentinfo set marks=jsonb_set(marks,'{hindi}','46') where name='niraj';

}
