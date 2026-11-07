package td6.domain;

public interface LibraryRepository {
    Library findByName(LibraryName name);

    void saveOrUpdate(Library library);
}
