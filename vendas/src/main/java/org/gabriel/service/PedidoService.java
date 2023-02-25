package org.gabriel.service;

import org.gabriel.domain.entity.Pedido;
import org.gabriel.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

}
