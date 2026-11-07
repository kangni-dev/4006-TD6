package td6.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    private String name;

    public Author(String name) {
        this.name = name;
    }

    protected Author() {

    }

    public String getName() {
        return name;
    }
}
