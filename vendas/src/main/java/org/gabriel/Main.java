package org.gabriel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    @GetMapping("/hello")
    public String helloWord(){
        return "Hello Word";
    }
    public static void main(String[] args) {
       SpringApplication.run(Main.class, args);
    }
}