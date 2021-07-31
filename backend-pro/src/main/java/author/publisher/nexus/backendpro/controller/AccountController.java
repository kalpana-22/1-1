package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.repository.AccountRepository;
import author.publisher.nexus.backendpro.repository.AuthorRepository;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    private Object String;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("password/{password}")
    public Account getAccountByPassword(@PathVariable("password") String password) {
        Account account = accountRepository.findByPassword(password);
        return account;
    }

    @DeleteMapping("{username}")
    public String deleteAccountByUserName(@PathVariable("username") String username) {
        Account a = accountRepository.findByUsername(username);
        accountRepository.delete(a);
        return "Delete Successful";
    }

    @PostMapping("login")
    public ResponseEntity getAccountByUsernamePassword(@RequestBody Account account){
        if(account.getUsername() != null && account.getPassword() != null) {
            Account account1 = accountRepository.findByUsername(account.getUsername());
            if(account1 != null && account1.getPassword().equals(account.getPassword())) {
                return ResponseEntity.ok(account1);
            }
        }

        return ResponseEntity.badRequest().body("Invalid Login request");


//        if (account.getUsername() == null) System.out.println("Need Username");
//        else if (account.getPassword() == null) System.out.println("Need password");
//        else if (accountRepository.findByUsername(account.getUsername())==null) System.out.println("Incorrect User name");
//        else if (accountRepository.findByPassword(account.getPassword())==null) System.out.println("Incorrect Password");
//        else {
//            if (accountRepository.findByUsername(account.getUsername())!=null && accountRepository.findByPassword(account.getPassword())!=null){
//                account = accountRepository.findByPassword(account.getPassword());
//               // account.setPassword(account.getPassword());
//                //account.setUsername(account.getUsername());
//               // account.getEmail()
//                return account;
//            }
//        }
//        return account;
    }

    @PostMapping
    public Account getAccountByName(@RequestBody Account account){
        if (account.getUsername() == null) System.out.println("Need name");
        else if (account.getEmail() == null) System.out.println("Need email");
        else if (account.getPassword() == null) System.out.println("Need password");
        else if (account.getPhonenumber() == null) System.out.println("Need phonenumber");
        else{
            Account a = new Account();
            a.setEmail(account.getEmail());
            a.setUsername(account.getUsername());
            a.setPhonenumber(account.getPhonenumber());
            a.setPassword(account.getPassword());
            return accountRepository.save(a);
        }
        return new Account();
    }


}