package org.gabriel.service;

import org.gabriel.model.Cliente;
import org.gabriel.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesServices {
    @Autowired(required = true)
    public ClientesRepository repository;

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
