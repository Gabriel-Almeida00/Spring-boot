package org.gabriel.service;

import org.gabriel.domain.entity.Pedido;
import org.gabriel.domain.enums.StatusPedido;
import org.gabriel.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizarStatus(Integer id, StatusPedido statusPedido);

}
