package author.publisher.nexus.backendpro.repository;

import author.publisher.nexus.backendpro.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findByUsername(String username);

    Account findByPassword(String password);


}
