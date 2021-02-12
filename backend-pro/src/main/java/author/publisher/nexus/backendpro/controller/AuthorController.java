package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.dto.AuthorDTO;
import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.model.Author;
import author.publisher.nexus.backendpro.repository.AccountRepository;
import author.publisher.nexus.backendpro.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    private Object String;

    @Autowired
    private AccountRepository accountRepository;

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
    public Author getAuthorByUserName(@RequestBody AuthorDTO authorDTO) {
        if (authorDTO.getUsername()==null) {
            System.out.println("Need user name");
        } else if (authorDTO.getEmail()==null) {
            System.out.println("Need email");
        } else if (authorDTO.getPassword()==null) {
            System.out.println("Need password");
        } else if (authorDTO.getPhonenumber()==null) {
            System.out.println("Need contact number");
        } else if (authorRepository.findByUsername(authorDTO.getUsername())!=null) {
            System.out.println("Try different username");
        } else if (authorRepository.findByPassword(authorDTO.getPassword())!=null) {
            System.out.println("Try different password");
        } else if (authorRepository.findByEmail(authorDTO.getEmail())!=null) {
            System.out.println("Try different Email");

            //authorRepository.findByUsername(author.getUsername());
            //return authorRepository.save(author);
        } else {
            Account account = new Account();
            account.setPassword(authorDTO.getPassword());
            account.setUsername(authorDTO.getUsername());
            account = accountRepository.save(account);

            Author author = new Author();
            author.setPhonenumber(authorDTO.getPhonenumber());
            author.setEmail(authorDTO.getEmail());
            author.setAccountId(account.getId());
            return authorRepository.save(author);

        }

        return new Author();
    }

    @PutMapping
    public Author UpdateAuthor(@RequestBody AuthorDTO authorDTO) {
        if (authorDTO.getUsername()==null) {
            System.out.println("Need user name");
        } else if (authorDTO.getEmail()==null) {
            System.out.println("Need email");
        } else if (authorDTO.getPassword()==null) {
            System.out.println("Need password");
        } else if (authorDTO.getPhonenumber()==null) {
            System.out.println("Need contact number");
        } else {


            Author author = authorRepository.findById(authorDTO.getId()).get();
            author.setPhonenumber(authorDTO.getPhonenumber());
            author.setEmail(authorDTO.getEmail());
            author.setAccountId(authorDTO.getId());
            Account account = accountRepository.findById(author.getAccountId()).get();       //authorDTO.getAccountId()
           // Account account = accountRepository.findById(authorDTO.getAccountId()).get();
            account.setUsername(authorDTO.getUsername());
            account.setPassword(authorDTO.getPassword());
            return authorRepository.save(author);
        }

//        return authorRepository.findById(authorDTO.getId()).get();
          return new Author();
    }
}

