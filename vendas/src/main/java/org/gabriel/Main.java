package org.gabriel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

   @Value("${application.name}")
    private String applicationName;

   @Cachorro
   private Animal animal;

   @Bean(name = "executarAnimal")
   public CommandLineRunner executar(){
       return args -> {
         animal.fazerBarulho();
       };
   }

    @GetMapping("/hello")
    public String helloWord(){
        return applicationName;
    }

    public static void main(String[] args) {
       SpringApplication.run(Main.class, args);
    }
}