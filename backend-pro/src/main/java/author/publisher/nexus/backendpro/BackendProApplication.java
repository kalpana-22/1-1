package author.publisher.nexus.backendpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BackendProApplication {

	public static void main(String[] args) { SpringApplication.run(BackendProApplication.class, args);

	}

}
