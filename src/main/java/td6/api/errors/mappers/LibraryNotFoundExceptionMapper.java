package td6.api.errors.mappers;

import td6.api.errors.ErrorResponse;
import td6.domain.exceptions.LibraryNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LibraryNotFoundExceptionMapper implements ExceptionMapper<LibraryNotFoundException> {

    @Override
    public Response toResponse(LibraryNotFoundException exception) {
        ErrorResponse error = new ErrorResponse("LIBRARY_NOT_FOUND", exception.getMessage());
        return Response.status(404).entity(error).build();
    }
}
