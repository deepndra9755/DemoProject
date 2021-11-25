package com.test.service;

import com.test.MetisException;
import com.test.api.exceptions.NotInsertedException;
import com.test.api.exceptions.UserIdNotFoundException;
import com.test.api.models.*;
import com.test.dao.UserAddressDao;
import com.test.dao.UserDao;
import com.test.dao.models.*;
import com.test.service.exceptions.MetisServiceException;
import com.test.service.mappers.Mapper;
import com.test.service.models.UserAddressMeta;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class UserService {

    private UserDao userDao;
    private UserAddressDao userAddressDao;

    public UserService(UserDao userDao, UserAddressDao userAddressDao) {
        this.userDao = userDao;
        this.userAddressDao = userAddressDao;
    }

    public User createUser(UserMeta userMeta) throws MetisException {
        try {
            UserRow row = Mapper.toUserRow(userMeta);
            UUID uuid = insertUser(row);
/*
            List<UserAddressMeta> userAddressinformations = userMeta.getAddress();
*/
            userMeta.getAddress().stream().map(Mapper::toAddressRow).forEach(addressRow -> {
                log.info("AddressRow : {}", addressRow);
                userAddressDao.insertAddress(uuid, addressRow);
            });
            return getUserDetails(uuid);
        } catch (Exception exception) {
            log.error("Failed to create user '{}'.", userMeta.getFirstName(), exception);
            throw new NotInsertedException("Failed to insert record.");
        }

    }


    public User getUserDetails(UUID uuid) throws MetisException {
        try {
            UserRow row = mustGet(uuid);
            List<AddressRow> list = userAddressDao.findBy(row.getUuid());
            List<Address> address = Mapper.toUserAddressInformation(list);
            return Mapper.toUserMetaInfo(row, address);

        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to get user for id '{}'",
                    uuid,
                    e);
            throw new MetisServiceException("Failed to get user.", e);
        }
    }

    public List<User> listAll() throws MetisException {
        try {
            List<User> usersFinal = new ArrayList<>();

            List<UserRow> users = userDao.findUsers();

            List<AddressRow> address = userAddressDao.findAllAddress();

            for (int user = 0; user < users.size(); user++) {
                UserRow row = users.get(user);
                UserRow metaRow = Mapper.toUserMetaRow(row);
                ArrayList<Address> obj = new ArrayList<Address>();

                for (int userAddress = 0; userAddress < address.size(); userAddress++) {
                    AddressRow urow = address.get(userAddress);

                    if (row.getUuid().toString().equals(urow.getUid().toString())) {
                        Address address1 = Mapper.toUserAddress(urow);
                        obj.add(address1);
                    }
                }
                User info = Mapper.toUserMetaInfo(metaRow, obj);
                usersFinal.add(info);
            }
            return usersFinal;
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to get all users",
                    e);
            throw new MetisServiceException("Failed to get all users.", e);
        }
    }

    public UUID insertUser(UserRow row) throws MetisException {
        try {
            userDao.insert(row);
            return row.getUuid();
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to insert user'",
                    e);
            throw new MetisServiceException("Failed to insert record.", e);
        }

    }

    public User addUserAddress(UUID uuid, AddressMeta request) throws MetisException {
        try {
            AddressRow row = Mapper.toAddressRow(request);
            userAddressDao.insertAddres(uuid, row);
            userDao.updateTime(uuid,Instant.now());
            return getUserinfo(uuid);
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to adding address record'",
                    e);
            throw new MetisServiceException("Failed to adding address record.", e);
        }
    }

    public User getUserinfo(UUID uuid) throws MetisException {
        try {
            UserRow row = mustGet(uuid);
            List<AddressRow> list = userAddressDao.findBy(uuid);
            List<Address> address = Mapper.toUserAddressInformation(list);
            return Mapper.toUserMetaInfo(row, address);
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to get record'",
                    e);
            throw new MetisServiceException("Failed to get record.", e);
        }

    }

    public User updateUser(UUID uuid, UserMeta meta) throws MetisException {
        try {
            UserRow userRow = Mapper.toUserRow(meta);
            userRow.setUpdatedAt(Instant.now());
            userDao.updateUser(uuid, userRow);
            List<UserAddressMeta> list = meta.getAddress();
            for (UserAddressMeta address : list) {
                AddressRow addressRow = Mapper.toAddressRow(address);
                userAddressDao.updateUserAddress(uuid, addressRow);
            }
            return getUserDetails(uuid);
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to update user for id '{}' with meta: {}",
                    uuid,
                    meta,
                    e);
            throw new MetisServiceException("Failed to update user.", e);
        }
    }

    public User delete(UUID uuid) throws MetisException {
        try {
            User info = getUserinfo(uuid);
            userAddressDao.deleteUser(uuid);
            userDao.deleteUser(uuid);
            return info;
        } catch (UnableToExecuteStatementException e) {
            log.error(
                    "Failed to delete user for id '{} :",
                    uuid,
                    e);
            throw new MetisServiceException("Failed to delete user.", e);
        }
    }

    public boolean exists(UUID uuid) {

        return userDao.exists(uuid);
    }

    private UserRow mustGet(UUID userId) {
        return userDao.findByID(userId).orElseThrow(() -> new UserIdNotFoundException(userId));
    }
}

