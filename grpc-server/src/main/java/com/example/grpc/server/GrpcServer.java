package com.example.grpc.server;


import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class GrpcServer {

    private final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    private final int port;
    private final Server server;

    public GrpcServer(int port, BindableService service) throws IOException {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(service)
                .build();
    }

    public void start() throws IOException, InterruptedException {
        this.server.start();
        logger.info("gRPC Server Listening on port " + port);
        this.server.awaitTermination();
    }

    public void shutdown() {
        System.err.println("gRPC 서버 종료..");
        server.shutdown();
        System.err.println("gRPC 서버 종료 완료");
    }

}
