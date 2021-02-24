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
//
    @DeleteMapping("{username}")
    public String deleteAuthorByUserName(@PathVariable("username") String username) {
        Account a = accountRepository.findByUsername(username);
        accountRepository.delete(a);
        return "Delete Successful";
    }
//111//
    @GetMapping("{id}")
    public AuthorDTO getAuthor(@PathVariable("id") String id) {

        Author author = authorRepository.findById(id).get();
        Account account = accountRepository.findById(author.getAccountId()).get();
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setEmail(author.getEmail());
        authorDTO.setPassword(account.getPassword());
        authorDTO.setPhonenumber(author.getPhonenumber());
        authorDTO.setUsername(account.getUsername());
        authorDTO.setAccountId(account.getId());
        authorDTO.setId(author.getId());

        return authorDTO;
    }
//
    @GetMapping("username/{username}")
    public AuthorDTO getAuthorByUserName(@PathVariable("username") String username) {
       // Account account = accountRepository.findByUsername(username);
        Account account = accountRepository.findByUsername(username);
        Author author= authorRepository.findByAccountId(account.getId());
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setEmail(author.getEmail());
        authorDTO.setPassword(account.getPassword());
        authorDTO.setPhonenumber(author.getPhonenumber());
        authorDTO.setUsername(account.getUsername());
        authorDTO.setAccountId(account.getId());
        authorDTO.setId(author.getId());

        return authorDTO;
       // return authorRepository.findByAccountId(account.getId());
    }

    @GetMapping("password/{password}")
    public AuthorDTO getAuthorByPassWord(@PathVariable("password") String password) {
        //Account account = accountRepository.findByUsername(password);
        Account account = accountRepository.findByPassword(password);
        Author author= authorRepository.findByAccountId(account.getId());
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setEmail(author.getEmail());
        authorDTO.setPassword(account.getPassword());
        authorDTO.setPhonenumber(author.getPhonenumber());
        authorDTO.setUsername(account.getUsername());
        authorDTO.setAccountId(account.getId());
        authorDTO.setId(author.getId());

        return authorDTO;
        //return authorRepository.findByPassword(password);
    }

    @GetMapping("email/{email}")
    public AuthorDTO getAuthorByEmail(@PathVariable("email") String email) {

        //return authorRepository.findByEmail(email);
        Author author = authorRepository.findByEmail(email);
        Account account = accountRepository.findById(author.getAccountId()).get();
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setEmail(author.getEmail());
        authorDTO.setPassword(account.getPassword());
        authorDTO.setPhonenumber(author.getPhonenumber());
        authorDTO.setUsername(account.getUsername());
        authorDTO.setAccountId(account.getId());
        authorDTO.setId(author.getId());

        return authorDTO;
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
        } else if (accountRepository.findByUsername(authorDTO.getUsername())!=null) {
            System.out.println("Try different username");
        } else if (accountRepository.findByPassword(authorDTO.getPassword())!=null) {
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

