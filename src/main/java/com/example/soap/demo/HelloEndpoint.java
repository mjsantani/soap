package com.example.soap.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetHelloRequest;
import io.spring.guides.gs_producing_web_service.GetHelloResponse;

@Endpoint
public class HelloEndpoint {
    static Logger log = LoggerFactory.getLogger(HelloEndpoint.class.getName());

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloRequest")
    @ResponsePayload
    public GetHelloResponse getHello(@RequestPayload GetHelloRequest request) {
        GetHelloResponse response = new GetHelloResponse();
        response.setGreetingresponse(request.getGreetingrequest());
        log.info("getHello() Returning Greetingresponse");
        return response;
    }
}