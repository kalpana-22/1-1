package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.dto.PublisherDTO;
import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.model.Publisher;
import author.publisher.nexus.backendpro.repository.AccountRepository;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;
    private Object String;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Publisher> getPublisher(){
        return publisherRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Publisher> getPublisherById(@PathVariable("id") String id){
        return publisherRepository.findById(id);
    }

    @DeleteMapping("{publication}")
    public String deleteByName(@PathVariable("publication") String publication){
        Publisher b = publisherRepository.findByUsername(publication);
        publisherRepository.delete(b);
        return (publication+" delete successfully");
    }

    @GetMapping("publication/{publication}")
    public Publisher getByPublication(@PathVariable("publication") String publication){
        return publisherRepository.findByUsername(publication);
    }

    @GetMapping("email/{email}")
    public Publisher getByEmail(@PathVariable("email") String email){
        return publisherRepository.findByEmail(email);
    }

    @GetMapping("password/{password}")
    public Publisher getByPassword(@PathVariable("password") String password){
        return publisherRepository.findByPassword(password);
    }

    @PostMapping
    public Publisher getPublisherByName(@RequestBody PublisherDTO publisherDTO) {
        if (publisherDTO.getUsername() == null) {
            System.out.println("Need Publication name");
        } else if (publisherDTO.getEmail() == null) {
            System.out.println("Need email");
        } else if (publisherDTO.getPassword() == null) {
            System.out.println("Need password");
        } else if (publisherRepository.findByUsername(publisherDTO.getUsername()) != null) {
            System.out.println("Try different name");
        } else if (publisherRepository.findByPassword(publisherDTO.getPassword()) != null) {
            System.out.println("Try different password");
        } else if (publisherRepository.findByEmail(publisherDTO.getEmail()) != null) {
            System.out.println("Try different Email");

                //authorRepository.findByUsername(author.getUsername());
                //return authorRepository.save(author);
        } else {
            Account account = new Account();
            account.setPassword(publisherDTO.getPassword());
            account.setUsername(publisherDTO.getUsername());
            account = accountRepository.save(account);

            Publisher publisher = new Publisher();
            publisher.setLogo(publisherDTO.getLogo());
            publisher.setImage(publisherDTO.getImage());
            publisher.setName(publisherDTO.getName());
            publisher.setEmail(publisherDTO.getEmail());
            publisher.setAccountId(account.getId());   //account id eka magin ganu labanne.. uda ati kotasin accout ekak nirmanaya kala bawini
            publisher.setComments(publisherDTO.getComments());
            publisher.setDescription(publisherDTO.getDescription());
            return publisherRepository.save(publisher);
        }

            return new Publisher();
        }

        @PutMapping
        public Publisher UpdatePublisher (@RequestBody PublisherDTO publisherDTO){
            if (publisherDTO.getUsername() == null) {
                System.out.println("Need user name");
            } else if (publisherDTO.getEmail() == null) {
                System.out.println("Need email");
            } else if (publisherDTO.getPassword() == null) {
                System.out.println("Need password");

            } else {
                Publisher publisher = publisherRepository.findById(publisherDTO.getId()).get();
                publisher.setName(publisherDTO.getName());
                publisher.setImage(publisherDTO.getImage());
                publisher.setDescription(publisherDTO.getDescription());
                publisher.setComments(publisherDTO.getComments());
                publisher.setEmail(publisherDTO.getEmail());
                publisher.setLogo(publisher.getLogo());
                publisher.setAccountId(publisherDTO.getAccountId());
                Account account = accountRepository.findById(publisherDTO.getAccountId()).get();
                account.setUsername(publisherDTO.getUsername());
                account.setPassword(publisherDTO.getPassword());
                return publisherRepository.save(publisher);
            }

            return new Publisher();
        }

}
