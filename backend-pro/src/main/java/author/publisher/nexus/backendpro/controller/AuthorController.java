package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.model.Author;
import author.publisher.nexus.backendpro.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    private Object String;

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @DeleteMapping("{username}")
    public String deleteAuthorByUserName(@PathVariable("username") String username) {
        Author a = authorRepository.findByUsername(username);
        authorRepository.delete(a);
        return "Delete Successful";
    }

    @GetMapping("{id}")
    public Author getAuthor(@PathVariable("id") String id) {

        return authorRepository.findById(id).get();
    }

    @GetMapping("username/{username}")
    public Author getAuthorByUserName(@PathVariable("username") String username) {
        return authorRepository.findByUsername(username);
    }

    @GetMapping("password/{password}")
    public Author getAuthorByPassWord(@PathVariable("password") String password) {
        return authorRepository.findByPassword(password);
    }

    @GetMapping("email/{email}")
    public Author getAuthorByEmail(@PathVariable("email") String email) {
        return authorRepository.findByEmail(email);
    }

    @PostMapping
    public Author getAuthorByUserName(@RequestBody Author author) {
        if (author.getUsername()==null) {
            System.out.println("Need user name");
        } else if (author.getEmail()==null) {
            System.out.println("Need email");
        } else if (author.getPassword()==null) {
            System.out.println("Need password");
        } else if (authorRepository.findByUsername(author.getUsername())!=null) {
            System.out.println("Try different username");
        } else if (authorRepository.findByPassword(author.getPassword())!=null) {
            System.out.println("Try different password");
        } else if (authorRepository.findByEmail(author.getEmail())!=null) {
            System.out.println("Try different Email");

            //authorRepository.findByUsername(author.getUsername());
            //return authorRepository.save(author);
        } else {
            return authorRepository.save(author);
        }

        return author;
    }

    @PutMapping
    public Author UpdateAuthor(@RequestBody Author author) {
        if (author.getUsername()==null) {
            System.out.println("Need user name");
        } else if (author.getEmail()==null) {
            System.out.println("Need email");
        } else if (author.getPassword()==null) {
            System.out.println("Need password");

        } else {
            return authorRepository.save(author);
        }

        return author;
    }
}

