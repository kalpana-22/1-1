package author.publisher.nexus.backendpro.repository;


import author.publisher.nexus.backendpro.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends MongoRepository<Publisher, String> {

   Publisher findByName(String name);

   Publisher findByEmail(String email);

   Publisher findByPassword(String password);
}
