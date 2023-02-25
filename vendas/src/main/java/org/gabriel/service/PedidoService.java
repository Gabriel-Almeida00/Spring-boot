package org.gabriel.service;

import org.gabriel.domain.entity.Pedido;
import org.gabriel.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);

}
