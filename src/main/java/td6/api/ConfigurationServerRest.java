package td6.api;

import td6.application.BookAssembler;
import td6.application.LibraryService;
import td6.domain.LibraryRepository;
import td6.infra.persistence.library.HibernateLibraryRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import td6.infra.persistence.library.InMemoryLibraryRepository;

public class ConfigurationServerRest extends AbstractBinder {
    private static LibraryRepository LibraryRepositoryInstance = new HibernateLibraryRepository();

    public static void useInMemoryRepositories() {
        LibraryRepositoryInstance = new InMemoryLibraryRepository();
    }

    @Override
    protected void configure() {
        bindAsContract(BookAssembler.class);
        bindAsContract(LibraryService.class);
        bind(LibraryRepositoryInstance).to(LibraryRepository.class);
    }
}
