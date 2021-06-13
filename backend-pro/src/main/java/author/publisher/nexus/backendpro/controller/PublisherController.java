package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.dto.PublisherDTO;
import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.model.Publisher;
import author.publisher.nexus.backendpro.repository.AccountRepository;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public List<PublisherDTO> getPublisher(){

        List<Publisher> publishers =  publisherRepository.findAll();
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        publishers.forEach(publisher -> {
            Account account = accountRepository.findById(publisher.getAccountId()).get();
            PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setName(publisher.getName());
            publisherDTO.setLogo(publisher.getLogo());
            publisherDTO.setDescription(publisher.getDescription());
            publisherDTO.setImage(publisher.getImage());
            publisherDTO.setComments(publisher.getComments());
            publisherDTO.setId(publisher.getId());
            publisherDTO.setAccountId(publisher.getAccountId());
            publisherDTO.setEmail(publisher.getEmail());
            publisherDTO.setUsername(account.getUsername());
            publisherDTO.setPassword(account.getPassword());

            publisherDTOS.add(publisherDTO);
        });

        return publisherDTOS;
    }

    @GetMapping("{id}")
    public PublisherDTO getPublisherById(@PathVariable("id") String id){
        //return publisherRepository.findById(id).get();
    //    Account account = accountRepository.findById(id).get();
    //    return publisherRepository.findByAccountId(account.getId());
        Publisher publisher= publisherRepository.findById(id).get();
        Account account = accountRepository.findById(publisher.getAccountId()).get();
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setEmail(publisher.getEmail());
        publisherDTO.setPassword(account.getPassword());
        publisherDTO.setUsername(account.getUsername());
        publisherDTO.setAccountId(account.getId());
        publisherDTO.setId(publisher.getId());
        publisherDTO.setComments(publisher.getComments());
        publisherDTO.setImage(publisher.getImage());
        publisherDTO.setDescription(publisher.getDescription());
        publisherDTO.setLogo(publisher.getLogo());
        publisherDTO.setName(publisher.getName());
        return publisherDTO;
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") String id){
        Publisher publisher = publisherRepository.findById(id).get();
        Account account = accountRepository.findById(publisher.getAccountId()).get();
        publisherRepository.delete(publisher);
        accountRepository.delete(account);
        return("success");
    }

    @DeleteMapping("email/{email}")
    public String deleteByEmail(@PathVariable("email") String email){
        Publisher b = publisherRepository.findByEmail(email);
        Account a = accountRepository.findById(b.getAccountId()).get();
        publisherRepository.delete(b);
        accountRepository.delete(a);
        return (email+" delete successfully");
    }

    @DeleteMapping("publication/{publication}")
    public String deleteByName(@PathVariable("publication") String publication){
       // Publisher b = publisherRepository.findByUsername(publication);
        Account a = accountRepository.findByUsername(publication);
        Publisher b = publisherRepository.findByAccountId(a.getId());
        publisherRepository.delete(b);
        accountRepository.delete(a);
        return (publication+" delete successfully");
    }

    @GetMapping("publication/{publication}")
    public Publisher getByPublication(@PathVariable("publication") String publication){
        //return publisherRepository.findByUsername(publication);
        Account account = accountRepository.findByUsername(publication);
        return publisherRepository.findByAccountId(account.getId());
    }

    @GetMapping("email/{email}")
    public Publisher getByEmail(@PathVariable("email") String email){

        return publisherRepository.findByEmail(email);
    }
//
    @GetMapping("password/{password}")
    public Publisher getByPassword(@PathVariable("password") String password){
       // return publisherRepository.findByPassword(password);
        Account account = accountRepository.findByPassword(password);
        return publisherRepository.findByAccountId(account.getId());
    }

    @PostMapping
    public Publisher getPublisherByName(@RequestBody PublisherDTO publisherDTO) {
        if (publisherDTO.getUsername() == null) {
            System.out.println("Need Publication name");
        } else if (publisherDTO.getEmail() == null) {
            System.out.println("Need email");
        } else if (publisherDTO.getPassword() == null) {
            System.out.println("Need password");
        } else if (accountRepository.findByUsername(publisherDTO.getUsername()) != null) {
            System.out.println("Try different name");
        } else if (accountRepository.findByPassword(publisherDTO.getPassword()) != null) {
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


//        @PutMapping
//        public Publisher UpdatePublisher(@RequestBody PublisherDTO publisherDTO){
//            if (publisherDTO.getUsername() == null) {
//                System.out.println("Need user name");
//            } else if (publisherDTO.getEmail() == null) {
//                System.out.println("Need email");
//            } else if (publisherDTO.getPassword() == null) {
//                System.out.println("Need password");
//
//            } else {
//                Publisher publisher = publisherRepository.findById(publisherDTO.getId()).get();
//                publisher.setName(publisherDTO.getName());
//                publisher.setImage(publisherDTO.getImage());
//                publisher.setDescription(publisherDTO.getDescription());
//                publisher.setComments(publisherDTO.getComments());
//                publisher.setEmail(publisherDTO.getEmail());
//                publisher.setLogo(publisher.getLogo());
//                publisher.setAccountId(publisherDTO.getId());
//                Account account = accountRepository.findById(publisherDTO.getAccountId()).get();
//                account.setUsername(publisherDTO.getUsername());
//                account.setPassword(publisherDTO.getPassword());
//                return publisherRepository.save(publisher);
//            }
//
//            return new Publisher();
//        }
//error//uda eka kalin eka yata eka passe 6/13/2021
    @PutMapping
    public Publisher UpdatePublisher(@RequestBody PublisherDTO publisherDTO){
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
            publisher.setAccountId(publisherDTO.getId());
            Account account = accountRepository.findById(publisher.getAccountId()).get();
            account.setUsername(publisherDTO.getUsername());
            account.setPassword(publisherDTO.getPassword());
            return publisherRepository.save(publisher);
        }

        return new Publisher();
    }

}
