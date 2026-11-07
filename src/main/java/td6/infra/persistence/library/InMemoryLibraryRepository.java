package td6.infra.persistence.library;

import td6.domain.Library;
import td6.domain.LibraryName;
import td6.domain.LibraryRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLibraryRepository implements LibraryRepository {

    private static final Map<LibraryName, Library> libraries = new HashMap<>();

    @Override
    public Library findByName(LibraryName name) {
        return libraries.get(name);
    }

    @Override
    public void saveOrUpdate(Library library) {
        libraries.put(library.getName(), library);
    }
}
