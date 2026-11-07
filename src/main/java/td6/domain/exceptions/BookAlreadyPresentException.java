package td6.domain.exceptions;

public class BookAlreadyPresentException extends RuntimeException {

    public BookAlreadyPresentException() {
        super("Book already present in library");
    }
}