package com.test.api.exceptions;

import com.test.MetisException;
import com.test.api.common.models.ErrorCode;

import javax.ws.rs.core.Response;

public class UserLastNameMustNotEmptyException extends MetisException {

    public UserLastNameMustNotEmptyException(String s)
    {
    super(
    ErrorCode.ERR_USER_LAST_NAME_MUST_NOT_EMPTY,
    Response.Status.BAD_REQUEST,
            String.format("User '--'."));
}
}
