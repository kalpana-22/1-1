package author.publisher.nexus.backendpro.repository;

import author.publisher.nexus.backendpro.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findByName(String name);

    Book findByFile(String file);
}
