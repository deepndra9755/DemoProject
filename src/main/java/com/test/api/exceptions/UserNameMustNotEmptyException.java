package com.test.api.exceptions;

import com.test.MetisException;
import com.test.api.common.models.ErrorCode;

import javax.ws.rs.core.Response;

public class UserNameMustNotEmptyException extends MetisException {
    public UserNameMustNotEmptyException(String s)
    {
        super(
                ErrorCode.ERR_USER_NAME_MUST_NOT_EMPTY,
                Response.Status.BAD_REQUEST,
                String.format("User '--'."));
    }
}
