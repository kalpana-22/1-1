package author.publisher.nexus.backendpro;

import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.model.Author;
import author.publisher.nexus.backendpro.model.Book;
import author.publisher.nexus.backendpro.model.Publisher;
import author.publisher.nexus.backendpro.repository.AccountRepository;
import author.publisher.nexus.backendpro.repository.AuthorRepository;
import author.publisher.nexus.backendpro.repository.BookRepository;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {

       // Author author = new Author();
        Account account = new Account();
        account.setUsername("Kalpana");
        account.setPassword("kalpana");
        account.setEmail("kalpana@gmail.com");
        account.setPhonenumber("0978678564");
        accountRepository.save(account);

        Author a = new Author();
        a.setAccountId(account.getId());
        authorRepository.save(a);



        Account account1 = new Account();
        account1.setPassword("Manel");
        account1.setUsername("Kamal");
        account1.setPhonenumber("058463223");
        account1.setEmail("fhgdjsgd.dhjh@mskdk.ck");
        accountRepository.save(account1);



        Account account3 = new Account();
        account3.setUsername("A");
        account3.setPassword("a");
        account3.setEmail("a@gmail.com");
        account3.setPhonenumber("0352267769");
        account3 = accountRepository.save(account3);
        Publisher publisher3 = new Publisher();
        publisher3.setAccountId(account3.getId());
        publisher3.setLogo("/assets/img/book4.png");
        publisher3.setDescription("A A A A publication is something made to communicate with the public. Publications are usually printed on paper (like magazines and books), but online publications are delivered via the Internet. If you are an aspiring author, publication of your work is, most likely, the Holy Grail you seek. ");
        publisher3.setImage("/assets/img/book2.jpg");
        publisher3.setName("Mr.A");
        publisherRepository.save(publisher3);

        Book book1 = new Book();
        book1.setName("Durga");
        book1.setFile("sada");
        book1.setFileSource("pdf");

        bookRepository.save(book1);
    }

}
