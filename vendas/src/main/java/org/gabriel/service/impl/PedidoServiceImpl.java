package org.gabriel.service.impl;

import org.gabriel.domain.repository.Pedidos;
import org.gabriel.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedidos repository;
}
