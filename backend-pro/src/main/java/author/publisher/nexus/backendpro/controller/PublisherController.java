package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.model.Publisher;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;
    private Object String;

    @GetMapping
    public List<Publisher> getPublisher(){
        return publisherRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Publisher> getPublisherById(@PathVariable("id") String id){
        return publisherRepository.findById(id);
    }

    @DeleteMapping("{name}")
    public String deleteByName(@PathVariable("name") String name){
        Publisher b = publisherRepository.findByName(name);
        publisherRepository.delete(b);
        return (name+" delete successfully");
    }

    @GetMapping("name/{name}")
    public Publisher getByName(@PathVariable("name") String name){
        return publisherRepository.findByName(name);
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
    public Publisher getPublisherByName(@RequestBody Publisher publisher) {
        if (publisher.getName()==null) {
            System.out.println("Need user name");
        } else if (publisher.getEmail()==null) {
            System.out.println("Need email");
        } else if (publisher.getPassword()==null) {
            System.out.println("Need password");
        } else if (publisherRepository.findByName(publisher.getName())!=null) {
            System.out.println("Try different name");
        } else if (publisherRepository.findByPassword(publisher.getPassword())!=null) {
            System.out.println("Try different password");
        } else if (publisherRepository.findByEmail(publisher.getEmail())!=null) {
            System.out.println("Try different Email");

            //authorRepository.findByUsername(author.getUsername());
            //return authorRepository.save(author);
        } else {
            return publisherRepository.save(publisher);
        }

        return publisher;
    }

    @PutMapping
    public Publisher UpdatePublisher(@RequestBody Publisher publisher) {
        if (publisher.getName()==null) {
            System.out.println("Need user name");
        } else if (publisher.getEmail()==null) {
            System.out.println("Need email");
        } else if (publisher.getPassword()==null) {
            System.out.println("Need password");

        } else {
            return publisherRepository.save(publisher);
        }

        return publisher;
    }

}
