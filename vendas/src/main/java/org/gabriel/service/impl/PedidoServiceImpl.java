package org.gabriel.service.impl;

import lombok.RequiredArgsConstructor;
import org.gabriel.domain.entity.Cliente;
import org.gabriel.domain.entity.ItemPedido;
import org.gabriel.domain.entity.Pedido;
import org.gabriel.domain.entity.Produto;
import org.gabriel.domain.enums.StatusPedido;
import org.gabriel.domain.repository.Clientes;
import org.gabriel.domain.repository.ItensPedidos;
import org.gabriel.domain.repository.Pedidos;
import org.gabriel.domain.repository.Produtos;
import org.gabriel.exception.RegrasNegocioException;
import org.gabriel.rest.dto.ItemPedidoDTO;
import org.gabriel.rest.dto.PedidoDTO;
import org.gabriel.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedidos pedidoRepository;

    @Autowired
    private Clientes clienteRepository;

    @Autowired
    private Produtos produtoRepository;

    @Autowired
    private ItensPedidos itensPedidosRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegrasNegocioException("Código de cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedidos = converterItems(pedido, dto.getItens());
        pedidoRepository.save(pedido);
        itensPedidosRepository.saveAll(itemsPedidos);
        pedido.setItens(itemsPedidos);
        return pedido;
    }


    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegrasNegocioException
                    ("Não é possível realizar um pedidio sem items");
        }
        return items
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtoRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegrasNegocioException(
                                            "Código de produto inválido: "+ idProduto
                                    ));

                    ItemPedido item = new ItemPedido();
                    item.setQuantidade(dto.getQuantidade());
                    item.setPedido(pedido);
                    item.setProduto(produto);

                    return item;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFecthItens(id);
    }
}
