package org.gabriel;


import org.gabriel.domain.entity.Cliente;
import org.gabriel.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Dougllas"));
            clientes.save(new Cliente("Outro Cliente"));

            boolean existe  = clientes.existsByNome("Dougllas");
            System.out.println("existe um cliente com o nome Dougllas ? " + existe);
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}