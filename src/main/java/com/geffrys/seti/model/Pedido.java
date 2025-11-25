package com.geffrys.seti.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Pedido {
    @JacksonXmlProperty(localName = "Pedido")
    @JsonProperty("numPedido")
    Long numPedido;
    @JacksonXmlProperty(localName = "Cantidad")
    @JsonProperty("cantidadPedido")
    int cantidadPedido;
    @JacksonXmlProperty(localName = "EAN")
    @JsonProperty("codigoEAN")
    String codigoEAN;
    @JacksonXmlProperty(localName = "Producto")
    @JsonProperty("nombreProducto")
    String nombreProducto;
    @JacksonXmlProperty(localName = "Cedula")
    @JsonProperty("numDocumento")
    String numDocumento;
    @JacksonXmlProperty(localName = "Direccion")
    @JsonProperty("direccion")
    String direccion;
}
