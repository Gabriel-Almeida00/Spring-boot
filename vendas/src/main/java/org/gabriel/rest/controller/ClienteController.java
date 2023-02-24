package org.gabriel.rest.controller;

import org.gabriel.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @RequestMapping(
            value = {"/api/clientes/hello/{nome}", "/api/hello"},
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    @ResponseBody
    public Cliente helloCliente(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente) {
        return String.format("Hello %s ", nomeCliente);
    }

}
