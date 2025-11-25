package com.geffrys.seti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geffrys.seti.model.Pedido;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @PostMapping
    public String getPedidoEstado(@RequestBody Pedido param) {
        return "Super";
    }
    
}
