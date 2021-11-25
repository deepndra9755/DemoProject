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

public interface UserDao {

    @SqlUpdate("INSERT INTO user_info(uuid, first_name, last_name, phone,hobbies ,description, created_at, updated_at) VALUES(:uuid, :firstName, :lastName, :phone,cast(:hobbies as jsonb),:description, :createdAt, :updatedAt)")
    void insert(@BindBean UserRow userRows);

    @SqlQuery("SELECT EXISTS (SELECT 1 FROM user_info WHERE uuid = :rowUuid)")
    boolean exists(@Bind("rowUuid") UUID rowUuid);

    @SqlQuery("SELECT * from user_info where uuid=:id")
    @RegisterRowMapper(UserRowMapper.class)
    Optional<UserRow> findByID(@Bind("id") UUID uuid);

    @SqlQuery("SELECT * from user_info")
    @RegisterRowMapper(UserRowMapper.class)
    List<UserRow> findUsers();

    @SqlUpdate("UPDATE user_info SET first_name=:firstName, last_name=:lastName, phone=:phone, hobbies=cast(:hobbies as jsonb),description=:description, updated_at=:updatedAt where uuid=:id")
    void updateUser(@Bind("id") UUID uuid,@BindBean UserRow row);

    @SqlUpdate("DELETE from user_info WHERE uuid =:id")
    void deleteUser(@Bind("id") UUID uuid);

    @SqlUpdate("UPDATE user_info SET updated_at=:teem WHERE uuid =:id")
    void updateTime(@Bind("id")UUID id,@Bind("teem") Instant instant);


}
