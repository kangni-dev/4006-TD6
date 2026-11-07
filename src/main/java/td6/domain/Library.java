package td6.domain;

import td6.domain.exceptions.BookAlreadyPresentException;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Map;

@Entity
public class Library {

    @Id
    private LibraryName name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapKey(name = "name")
    @Fetch(FetchMode.SELECT)
    private Map<BookName, Book> books;

    public Library(LibraryName name, Map<BookName, Book> books) {
        this.name = name;
        this.books = books;
    }

    protected Library() {

    }

    public LibraryName getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books.values().stream().toList();
    }

    public void addBook(Book book) {
        if (books.containsKey(book.getName()))
            throw new BookAlreadyPresentException();

        books.put(book.getName(), book);
    }
}
