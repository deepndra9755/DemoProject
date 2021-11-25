package com.test.dao;

import com.test.dao.models.AddressRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Columns {

    /* Employees*/
    public static final String ID = "id";
    public static final String UUId = "uuid";
    public static final String USER_ID = "user_id";
    public static final String NAME = "name";
    public static final String CITY = "city";
    public static final String PHONE = "phone";
    public static final String META="meta";
    public static final String MARKS="marks";
    public static final String FIRST_NAME="first_name";
    public static final String LAST_NAME="last_name";
    public static final String HOBBIES="hobbies";
    public static final String DESCRIPTION="description";
    public static final String HOUSE_NUMBER="house_number";
    public static final String STREET="street";
    public static final String LANDMARK="landmark";
    public static final String STATE="state";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String ZIPCODE="zipcode";
    public static final String ADDRESS="address";

    /*public static AddressRow addressinfo(final ResultSet results, final String column)
    {
        if (results.(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getObject(column, UUID.class);
    }*/

    public static UUID uuidOrThrow(final ResultSet results, final String column) throws SQLException {
        if (results.getObject(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getObject(column, UUID.class);
    }

    public static String stringFirst_NameOrThrow(final ResultSet results, final String column)
            throws SQLException {
        if (results.getObject(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getString(column);
    }
    public static String stringLast_NameOrThrow(final ResultSet results, final String column)
            throws SQLException {
        if (results.getObject(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getString(column);
    }

/*public static  hobbiesOrThrow(final ResultSet results, final String column) throws SQLException {
    if(results.getObject(column)==null)
    {
        throw new IllegalArgumentException("meta hobiie info not found");
    }
    return results.getObject(column);
}*/
    public static Instant timestampOrThrow(final ResultSet results, final String column)
            throws SQLException {
        if (results.getObject(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getTimestamp(column).toInstant();
    }

    public static String stringOrThrow(final ResultSet results, final String column)
            throws SQLException {
        if (results.getObject(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getString(column);
    }
    public static Map<String,Object> metaOrThrow(ResultSet resultSet,String column)throws SQLException
    {
     if(resultSet.getObject(column)==null)
     {
         throw new IllegalArgumentException("meta map info not found");
     }
     return (Map<String, Object>) resultSet.getObject(column);
    }public static String stringOrThrows(ResultSet resultSet,String column)throws SQLException
    {
        if(resultSet.getObject(column)==null)
        {
            throw new IllegalArgumentException("masrk info not found");
        }
        return resultSet.getString(column);
    }

    public static Integer integerOrThrow(final ResultSet results, final String column)
            throws SQLException {
        if (results.getObject(column) == null) {
            throw new IllegalArgumentException();
        }
        return results.getInt(column);
    }
}
