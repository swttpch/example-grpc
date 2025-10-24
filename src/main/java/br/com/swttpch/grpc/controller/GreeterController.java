package br.com.swttpch.grpc.controller;

import br.com.swttpch.grpc.client.GreeterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {
    @Value("${grpc.server.port}")
    private String test;
    private final GreeterClient greeterClient;

    @Autowired
    public GreeterController(GreeterClient greeterClient){
        this.greeterClient = greeterClient;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name){

        return greeterClient.sayHello(name);
    }
}
