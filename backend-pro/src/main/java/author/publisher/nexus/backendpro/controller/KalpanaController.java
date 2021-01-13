package author.publisher.nexus.backendpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KalpanaController {

    @GetMapping
    public String sayHello() {
        return "Hello WOld";
    }
}
