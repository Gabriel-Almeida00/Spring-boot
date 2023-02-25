package org.gabriel.rest.controller;

import org.gabriel.exception.PedidoNaoEncontradoExecption;
import org.gabriel.exception.RegrasNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvide {

    @ExceptionHandler(RegrasNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegrasNegocioException(RegrasNegocioException ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(PedidoNaoEncontradoExecption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlePedidoNotFoundException(PedidoNaoEncontradoExecption ex){
        return new ApiErrors(ex.getMessage());
    }
}
