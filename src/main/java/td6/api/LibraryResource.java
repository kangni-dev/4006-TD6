package td6.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import td6.application.BookDto;
import td6.application.LibraryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

@Path("/libraries/{libraryName}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibraryResource {

    private final LibraryService libraryService;

    @Inject

    public LibraryResource(LibraryService libraryService) {this.libraryService = libraryService;}

    @POST
    @Path(("/books"))
    public Response addBook(@PathParam("libraryName") String libraryName, BookDto bookDto){
        libraryService.addBook(libraryName, bookDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path(("/books"))
    public Response getAllBooks(@PathParam("libraryName") String libraryName) {
        List<BookDto> bookDtos = libraryService.getAllBooks(libraryName);
        return Response.ok(Collections.singletonMap("books", bookDtos)).build();
    }
}
