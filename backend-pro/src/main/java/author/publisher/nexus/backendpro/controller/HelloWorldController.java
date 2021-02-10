package author.publisher.nexus.backendpro.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    @GetMapping
    public String sayHello() {
        return "Hello WOld";
    }


    @GetMapping("{username}/{password}")
    public String userNameSave(@PathVariable String username, @PathVariable String password) {
        System.out.println("Hi.. "+ username);
        return username + " " + password;
    }
}
