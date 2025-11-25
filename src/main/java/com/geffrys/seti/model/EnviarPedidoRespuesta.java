package com.geffrys.seti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Data
public class EnviarPedidoRespuesta {

    @JacksonXmlProperty(localName = "EnvioPedidoResponse")
    @JsonProperty("enviarPedidoRespuesta")
    EstadoPedido estadoPedido;
}
