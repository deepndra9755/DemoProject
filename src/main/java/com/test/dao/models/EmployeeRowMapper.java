package com.test.dao.models;

import lombok.NonNull;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.test.dao.Columns.*;
public final class EmployeeRowMapper implements RowMapper<EmployeeRow> {
    @Override
    public EmployeeRow map(@NonNull ResultSet results, @NonNull StatementContext context)
            throws SQLException {
        return new EmployeeRow(
                uuidOrThrow(results,ID),
                stringOrThrow(results, NAME),
                stringOrThrow(results, CITY),
                integerOrThrow(results, PHONE),
                stringOrThrow(results,META)
        );

    }
}
