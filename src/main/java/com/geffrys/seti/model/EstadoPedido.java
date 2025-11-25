package com.geffrys.seti.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Data
@JacksonXmlRootElement(localName = "EnvioPedidoResponse")
@JsonRootName("EnviarPedidoRespuesta")
public class EstadoPedido {
    @JsonProperty("codigoEnvio")
    @JacksonXmlProperty(localName = "Codigo")
    String codigoEnvio;
    @JsonProperty("estado")
    @JacksonXmlProperty(localName = "Mensaje")
    String estado;
}
