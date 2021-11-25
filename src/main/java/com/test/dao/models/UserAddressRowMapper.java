package com.test.dao.models;

import com.test.dao.Columns;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAddressRowMapper implements RowMapper<AddressRow> {

    @Override
    public AddressRow map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new AddressRow(Columns.uuidOrThrow(rs,Columns.UUId),
                Columns.uuidOrThrow(rs,Columns.USER_ID),
                Columns.integerOrThrow(rs, Columns.HOUSE_NUMBER),
                Columns.stringOrThrows(rs,Columns.STREET),
                Columns.stringOrThrow(rs, Columns.LANDMARK),
                Columns.stringOrThrow(rs, Columns.CITY),
                Columns.stringOrThrow(rs, Columns.STATE),
                Columns.integerOrThrow(rs, Columns.ZIPCODE));
    }
}
