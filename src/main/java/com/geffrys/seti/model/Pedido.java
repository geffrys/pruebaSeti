package com.geffrys.seti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Data
@JacksonXmlRootElement(localName = "EnvioPedidoRequest")
public class Pedido {
    @JacksonXmlProperty(localName = "Pedido")
    @JsonProperty("numPedido")
    String numPedido;
    @JacksonXmlProperty(localName = "Cantidad")
    @JsonProperty("cantidadPedido")
    String cantidadPedido;
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
