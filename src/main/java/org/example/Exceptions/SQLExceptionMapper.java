package org.example.Exceptions;


import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.example.FilterDTO.ErrorMessage;
import org.glassfish.jersey.internal.Errors;

import java.sql.SQLException;

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException exception) {
        ErrorMessage err = new ErrorMessage();
        err.setErrorContent(exception.getMessage());
        err.setErrorCode(500);
        err.setDocumentationUrl("https://google.com");

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(err)
                .build();
    }
}