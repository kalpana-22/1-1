package author.publisher.nexus.backendpro.repository;

import author.publisher.nexus.backendpro.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends MongoRepository<Author, String> {
    Author findByUsername(String username);
    //
    Author findByPassword(String password);

    Author findByEmail(String email);


   // Account findByAccoutId();
}
