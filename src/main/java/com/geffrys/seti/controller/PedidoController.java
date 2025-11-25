package com.geffrys.seti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geffrys.seti.model.EstadoPedido;

import tools.jackson.dataformat.xml.XmlMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @PostMapping
    public String getPedidoEstado(@RequestAttribute("pedido") String pedidoXml) {
        System.out.println("Pedido recibido en XML: " + pedidoXml);
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setCodigoEnvio("123456");
        estadoPedido.setEstado("Pedido recibido correctamente");
        XmlMapper xmlMapper = new XmlMapper();
        String xmlResponse = xmlMapper.writeValueAsString(estadoPedido);
        System.out.println("Respuesta XML: " + xmlResponse);
        return xmlResponse;
    }
    
}
