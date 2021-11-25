package com.test.api.exceptions;

import com.test.MetisException;
import com.test.api.common.models.ErrorCode;

import javax.ws.rs.core.Response;

public class AllFieldMandatoryException extends MetisException {
public AllFieldMandatoryException(String s)
{

    super(
            ErrorCode.ERR_ALL_FIELD_MANDATORY,
            Response.Status.NOT_FOUND,
            " All field mandatory"
    );
}
}
