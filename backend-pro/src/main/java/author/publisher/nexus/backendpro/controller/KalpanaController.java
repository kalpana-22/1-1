package author.publisher.nexus.backendpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dodo")
public class KalpanaController {

    @GetMapping("{name}")
    public String sayHello(@PathVariable String name) {
        System.out.println("name:"+name);
        return "Hello WOld "+ name;
    }
}
