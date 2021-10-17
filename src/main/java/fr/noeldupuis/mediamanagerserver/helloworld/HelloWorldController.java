package fr.noeldupuis.mediamanagerserver.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/greetings")
    public String getGreetings() {
        return "Hello, World!";
    }
}
