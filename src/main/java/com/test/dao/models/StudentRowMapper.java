package com.test.dao.models;

import com.test.dao.Columns;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentRow> {

    @Override
    public StudentRow map(ResultSet rs, StatementContext ctx) throws SQLException {

    return  new StudentRow(Columns.uuidOrThrow(rs,Columns.ID),
                 Columns.stringOrThrow(rs,Columns.NAME),
                 Columns.stringOrThrow(rs,Columns.CITY),
                 Columns.integerOrThrow(rs,Columns.PHONE),
                 Columns.stringOrThrows(rs,Columns.MARKS)

                 );

    }
}
