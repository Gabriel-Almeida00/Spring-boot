package org.gabriel;


import org.gabriel.domain.entity.Cliente;
import org.gabriel.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    @Bean
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
        return args -> {
            Cliente cliente = new Cliente(null,"fulano");
            clientes.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}