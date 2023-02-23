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
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
             clientes.salvar( new Cliente("Gabriel"));
             clientes.salvar( new Cliente("Outro CLiente"));

             List<Cliente> todosClientes =  clientes.obterTodos();
             todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}