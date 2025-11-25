// package com.geffrys.seti.controller.advice;

// import org.jspecify.annotations.Nullable;
// import org.springframework.core.MethodParameter;
// import org.springframework.http.MediaType;
// import org.springframework.http.converter.HttpMessageConverter;
// import org.springframework.http.server.ServerHttpRequest;
// import org.springframework.http.server.ServerHttpResponse;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

// import com.geffrys.seti.controller.PedidoController;
// import com.geffrys.seti.model.EstadoPedido;

// import tools.jackson.dataformat.xml.XmlMapper;

// @ControllerAdvice(assignableTypes = PedidoController.class)
// public class XMLtoJsonResponseAdvice implements ResponseBodyAdvice<Object> {
//     private final XmlMapper xmlMapper = new XmlMapper();

//     @Override
//     public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//         return true;
//     }

//     @Override
// public @Nullable Object beforeBodyWrite(@Nullable Object body,
//                                         MethodParameter returnType,
//                                         MediaType selectedContentType,
//                                         Class<? extends HttpMessageConverter<?>> selectedConverterType,
//                                         ServerHttpRequest request,
//                                         ServerHttpResponse response) {
//     System.out.println("Respuesta XML recibida por XML ADVICE: " + body);

//     try {
//         if (body instanceof String xml && xml.trim().startsWith("<")) {
//             EstadoPedido estadoPedido = xmlMapper.readValue(xml, EstadoPedido.class);
//             response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//             return estadoPedido; 
//         }

       
//         if (body instanceof EstadoPedido estadoPedido) {
//             response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//             return estadoPedido; 
//         }

//         return body;

//     } catch (Exception e) {
//         e.printStackTrace();
//         response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
//         return "Error al convertir respuesta: " + e.getMessage();
//     }
// }


// }
