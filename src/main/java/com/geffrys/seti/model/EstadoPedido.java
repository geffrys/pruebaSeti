package com.geffrys.seti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EstadoPedido {
    @JsonProperty("codigoEnvio")
    @JacksonXmlProperty(localName = "Codigo")
    String codigoEnvio;
    @JsonProperty("estado")
    @JacksonXmlProperty(localName = "Mensaje")
    String estado;
}
