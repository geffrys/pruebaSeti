package com.geffrys.seti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Data
public class EnviarPedidoWrapper {
    @JsonProperty("enviarPedido")
    @JacksonXmlProperty(localName = "EnvioPedidoRequest")
    Pedido pedidoWrapper;
    
}
