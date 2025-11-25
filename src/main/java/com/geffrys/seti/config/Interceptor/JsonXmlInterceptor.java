package com.geffrys.seti.config.Interceptor;

import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.geffrys.seti.model.EnviarPedidoWrapper;
import com.geffrys.seti.model.Pedido;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.xml.XmlMapper;

@Component
public class JsonXmlInterceptor implements HandlerInterceptor {

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String jsonBody = request.getReader().lines().collect(Collectors.joining());
            EnviarPedidoWrapper enviarPedidoWrapper = jsonMapper.readValue(jsonBody, EnviarPedidoWrapper.class);
            Pedido pedido = enviarPedidoWrapper.getPedidoWrapper();
            String xmlBody = xmlMapper.writeValueAsString(pedido);
            request.setAttribute("pedido", xmlBody);
            System.out.println("Body en xml: " + xmlBody);
        }
        return true;
    }
    
}
