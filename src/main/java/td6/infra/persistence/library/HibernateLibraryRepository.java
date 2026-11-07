package td6.infra.persistence.library;

import td6.domain.Library;
import td6.domain.LibraryName;
import td6.domain.LibraryRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateLibraryRepository implements LibraryRepository {
    private static final Logger logger = LoggerFactory.getLogger(HibernateLibraryRepository.class);

    @Override
    public Library findByName(LibraryName name) {
        try (Session session = SessionProvider.getOpenSession()) {
            return session.get(Library.class, name);
        } catch (Exception e) {
            logger.error("Error while trying to find Library with name {}", name, e);
            throw e;
        }
    }

    @Override
    public void saveOrUpdate(Library library) {
        Transaction transaction = null;

        try (Session session = SessionProvider.getOpenSession()) {
            transaction = session.beginTransaction();

            session.merge(library);

            transaction.commit();
        } catch (Exception e) {
            logger.error("Error while trying to save Library with name {}", library.getName(), e);

            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }

            throw e;
        }
    }
}
