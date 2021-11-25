package com.test.service;

import com.test.api.models.EmployeeParseFlowMeta;
import com.test.dao.IEmpDaoImpl;
import com.test.dao.models.EmployeeMetaRow;
import com.test.dao.models.EmployeeRow;
import com.test.service.mappers.Mapper;
import com.test.service.models.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmpServiceImpl {

    private final IEmpDaoImpl dao;

    public EmpServiceImpl(IEmpDaoImpl dao) {
        this.dao = dao;
    }

    public Employee add(EmployeeMeta employeeMeta) {
        try {

            EmployeeRow employeeRow = Mapper.toEmployeeRow(employeeMeta);
            dao.insert(employeeRow);
            return getEmployee(employeeRow.getUuid());
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("record can't inserted");
        }
    }

    public List<Employee> findAllEmp() {
        try {

            List<EmployeeRow> employeeRows = dao.findAll();
            return Mapper.toEmployeeList(employeeRows);
        }
        catch (Exception e)
        {
            throw new RuntimeException("record not found");
        }
    }

  // main delete
     public Employee deleteEmployeeByid(UUID uuid)
    {
        Optional<EmployeeRow> employeeRow=dao.find(uuid);
        if(employeeRow.isPresent())
        {
            dao.deleteById(uuid);
            EmployeeRow employeeRow1=employeeRow.get();
            return new Employee(employeeRow1.getUuid(),employeeRow1.getName(),employeeRow1.getCity(),employeeRow1.getPhone(),employeeRow1.getRowMeta());
        }
         throw new RuntimeException("record not found");
    }


    public Employee updateMeta(EmployeeParseFlowMeta employeeParseFlowMeta)
    {
        //user supplied data
        EmployeeMetaRow employeeMetaRow=Mapper.toEmployeeMetaRow(employeeParseFlowMeta);

        Optional<EmployeeRow> employeeRow=dao.find(employeeParseFlowMeta.getUuid());
        if(employeeRow.isPresent())
        {
            //allready avail record
         EmployeeRow employeeRowRetrive=employeeRow.get();
         dao.updateEmployeeMeta(employeeMetaRow);

         /*String arg2[]=employeeRowRetrive.getRowMeta().split(",");
            HashSet<String> stringHashSet=new HashSet<String>();
            for(int count=0;count<arg2.length;count++)
            {
                stringHashSet.add(arg2[count]);

            }
            stringHashSet.add(arg);
            String data=stringHashSet.toString();
             employeeMetaRow.setMeta(data);
            dao.updateEmployeeMeta(employeeMetaRow);*/
            Optional<EmployeeRow> employeeRow1 = dao.find(employeeParseFlowMeta.getUuid());
            return Mapper.toEmployee(employeeRow1.get());
        }
        else {
            throw new RuntimeException("not update");
        }
        }




    public EmployeeMeta addMeta(String meta) {
        return null;
    }

    public Employee updateEmpById(UUID id, EmployeeMeta request) {
        //for updatation request
        EmployeeRow employeeRow = Mapper.toEmployeeRow(request);

        Optional<EmployeeRow> employee = dao.find(id);

        if (employee.isPresent()) {
            dao.updateEmp(new EmployeeRow(id, employeeRow.getName(), employeeRow.getCity(), employeeRow.getPhone(),employeeRow.getRowMeta()));
            Optional<EmployeeRow> objj = dao.find(id);
            return getEmployee(objj.get().getUuid());
        }
        throw new RuntimeException("record not found");

    }

    public Employee getEmployee(UUID employeeId) {
        Optional<EmployeeRow> row = dao.find(employeeId);
        if (row.isPresent()) {
            return Mapper.toEmployee(row.get());
        } else {
            throw new RuntimeException("Employee not found");
        }
    }



}
