package com.test.dao;

import com.test.dao.models.*;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RegisterRowMapper(UserAddressRowMapper.class)
public interface UserAddressDao {


    @SqlQuery("SELECT * from user_address where user_id=:id")
    @RegisterRowMapper(UserAddressRowMapper.class)
    List<AddressRow> findBy(@Bind("id") UUID uuid);

  @SqlUpdate("INSERT INTO user_address(uuid,user_id,house_number,street,landmark,city,state,zipcode) values(:uuid,:id,:houseNumber,:street,:landmark,:city,:state,:zipcode)")
    void insertAddress(@Bind("id") UUID uuid, @BindBean AddressRow addressRow);

  @SqlUpdate("INSERT INTO user_address(uuid,user_id,house_number,street,landmark,city,state,zipcode) values(:uuid,:id,:houseNumber,:street,:landmark,:city,:state,:zipcode)")
    void insertAddres(@Bind("id") UUID uuid, @BindBean AddressRow addressRow);


    @SqlUpdate("UPDATE user_address SET house_number=:houseNumber,street=:street,landmark=:landmark,city=:city,state=:state ,zipcode=:zipcode where user_id=:id")
    void updateUserAddress(@Bind("id") UUID uuid, @BindBean AddressRow row);

    @SqlUpdate("DELETE from user_address WHERE user_id=:id")
    void deleteUser(@Bind("id") UUID uuid);

    @SqlQuery("SELECT * from user_address")
    @RegisterRowMapper(UserAddressRowMapper.class)
    List<AddressRow> findAllAddress();



 /*   @SqlQuery("SELECT * from user_address where user_id=:id")
    @RegisterRowMapper(UserAddressRowMapper.class)
    List<AddressRow> findAllAddres();*/

}
