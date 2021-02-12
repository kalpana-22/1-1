package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.model.Account;
import author.publisher.nexus.backendpro.repository.AccountRepository;
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

}
