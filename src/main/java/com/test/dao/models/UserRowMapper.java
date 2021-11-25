package com.test.dao.models;

import com.test.dao.Columns;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserRow> {

    @Override
    public UserRow map(ResultSet rs, StatementContext ctx) throws SQLException {

        return new UserRow(Columns.uuidOrThrow(rs,Columns.UUId),
                Columns.stringFirst_NameOrThrow(rs,Columns.FIRST_NAME),
                Columns.stringLast_NameOrThrow(rs,Columns.LAST_NAME),
               Columns.stringOrThrow(rs,Columns.PHONE),
                Columns.stringOrThrows(rs,Columns.HOBBIES),
                Columns.stringOrThrow(rs,Columns.DESCRIPTION),
                Columns.timestampOrThrow(rs,Columns.CREATED_AT),
                Columns.timestampOrThrow(rs,Columns.UPDATED_AT)


        );
    }
}
