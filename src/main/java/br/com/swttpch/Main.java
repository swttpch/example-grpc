package br.com.swttpch;

import br.com.swttpch.grpc.server.GreeterService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        int port = 9090;
        SpringApplication.run(Main.class, args);
        Server server = ServerBuilder.forPort(port)
                .addService(new GreeterService())
                .build();
        server.start();
        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }
}