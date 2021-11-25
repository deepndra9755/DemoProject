package com.test.api.exceptions;

import com.test.MetisException;
import com.test.api.common.models.ErrorCode;
import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

import javax.ws.rs.core.Response;

public class FormValidationException extends MetisException {
    public FormValidationException(String s, Exception e)
    {
        super(
                ErrorCode.ERR_FORM_VALIDATION_EXCEPTION,
                Response.Status.BAD_REQUEST,
                ""
        );
    }
}
