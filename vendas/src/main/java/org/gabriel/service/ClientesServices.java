package org.gabriel.service;

import org.gabriel.model.Cliente;
import org.gabriel.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServices {

    public ClientesRepository repository;

    @Autowired
    public ClientesServices (ClientesRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
