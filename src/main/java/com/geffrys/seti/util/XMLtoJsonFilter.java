package com.geffrys.seti.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geffrys.seti.model.EstadoPedido;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.dataformat.xml.XmlMapper;

@Component
@Order(1)
public class XMLtoJsonFilter implements Filter {

    private final XmlMapper xmlMapper = new XmlMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (!httpRequest.getRequestURI().contains("/pedido")) {
            chain.doFilter(request, response);
            return;
        }

        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpResponse);

        try {
            chain.doFilter(request, responseWrapper);

            byte[] responseBody = responseWrapper.getContentAsByteArray();
            String responseContent = new String(responseBody, StandardCharsets.UTF_8);

            System.out.println("=== XmlToJsonResponseFilter ===");
            System.out.println("Respuesta capturada: " + responseContent);

            if (responseContent.trim().startsWith("<")) {
                try {
                    // Parsear XML a objeto
                    EstadoPedido estadoPedido = xmlMapper.readValue(responseContent, EstadoPedido.class);
                    
                    // Crear estructura manualmente
                    Map<String, Object> wrapper = new LinkedHashMap<>();
                    Map<String, Object> pedidoData = new LinkedHashMap<>();
                    pedidoData.put("codigoEnvio", estadoPedido.getCodigoEnvio());
                    pedidoData.put("estado", estadoPedido.getEstado());
                    wrapper.put("enviarPedidoRespuesta", pedidoData);
                    
                    // Convertir a JSON
                    String jsonResponse = objectMapper.writeValueAsString(wrapper);
                    
                    System.out.println("JSON generado: " + jsonResponse);

                    responseWrapper.resetBuffer();
                    httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    httpResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
                    
                    byte[] jsonBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
                    httpResponse.setContentLength(jsonBytes.length);
                    httpResponse.getOutputStream().write(jsonBytes);
                    httpResponse.getOutputStream().flush();
                    
                    return;
                    
                } catch (Exception e) {
                    System.err.println("Error al convertir XML a JSON: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            responseWrapper.copyBodyToResponse();

        } catch (Exception e) {
            System.err.println("Error en XmlToJsonResponseFilter: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}