package author.publisher.nexus.backendpro;

import author.publisher.nexus.backendpro.model.Author;
import author.publisher.nexus.backendpro.model.Publisher;
import author.publisher.nexus.backendpro.repository.AuthorRepository;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setUsername("kalpana");
        author.setPassword("rajeshwari");
        authorRepository.save(author);

        Author author2 = new Author();
        author2.setEmail("sss@gmail.com");
        author2.setUsername("kamal");
        author2.setPassword("gunarathnam");
        authorRepository.save(author2);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Sarasavi");
        publisher1.setEmail("sarasavi@gmail.com");
        publisher1.setPassword("sarasavi");
        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Gunasena");
        publisher2.setEmail("gunasena@gmail.com");
        publisher2.setPassword("gunasena");
        publisherRepository.save(publisher2);
    }

}
