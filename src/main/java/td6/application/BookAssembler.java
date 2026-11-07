package td6.application;

import td6.domain.Author;
import td6.domain.Book;
import td6.domain.BookName;

import java.util.List;

public class BookAssembler {

    public Book fromDto(BookDto bookDto)
    {
        BookName bookName = new BookName(bookDto.title);
        Author author = new Author(bookDto.author);
        return new Book(bookName, author);
    }

    public List<BookDto> toDtos(List<Book> books) {
        return books.stream().map(book -> new BookDto(book.getName().toString(), book.getAuthor().getName())).toList();
    }
}
