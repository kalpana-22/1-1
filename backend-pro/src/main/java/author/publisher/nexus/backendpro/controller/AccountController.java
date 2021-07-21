package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.repository.AccountRepository;
import author.publisher.nexus.backendpro.repository.AuthorRepository;
import author.publisher.nexus.backendpro.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("{username}")
    public String deleteAccountByUserName(@PathVariable("username") String username) {
        Account a = accountRepository.findByUsername(username);
        accountRepository.delete(a);
        return "Delete Successful";
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

//    @PostMapping("/login")
//    public Account login(@RequestBody Account account){
//        if (account.getUsername() == null) System.out.println("Need name");
//        else if (account.getPassword() == null) System.out.println("Need password");
//        else {
//            Account account1 = accountRepository.findByPassword(account.getPassword());
//            accountRepository.save(account1);
//            if (account1.getId()==)
//        }
//
//
//    }
}
