package author.publisher.nexus.backendpro.repository;

import author.publisher.nexus.backendpro.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends MongoRepository<Author, String> {
    //8//Author findByUsername(String username);
    //
    //8//Author findByPassword(String password);

   // Author findByEmail(String email);

    Author findByAccountId(String id);

}
