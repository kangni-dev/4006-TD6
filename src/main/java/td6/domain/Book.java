package td6.domain;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    private BookName name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Author author;

    public Book(BookName name, Author author) {
        this.name = name;
        this.author = author;
    }

    protected Book() {

    }

    public BookName getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }
}
