package org.gabriel.exception;

public class PedidoNaoEncontradoExecption extends RuntimeException {

    public PedidoNaoEncontradoExecption() {
        super("Pedido não encontrado");
    }
}
