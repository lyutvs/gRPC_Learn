package com.example.grpc;

import com.example.grpc.server.GrpcServer;
import com.example.grpc.server.GrpcServerService;
import io.grpc.BindableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        final int port = 54321;
        final BindableService helloService = (BindableService) new GrpcServerService();

        GrpcServer server = new GrpcServer(port, helloService);

        server.start();

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> server.shutdown())
        );
    }


}
