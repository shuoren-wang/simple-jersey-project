package application;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import resource.UserResource;

import java.io.IOException;
import java.net.URI;


public class Application {
    private static final Logger LOGGER = LogManager.getLogger(Application.class);
    public static String BASE_URL = "http://127.0.0.1:1234";

    private Application() {
    }


    public static HttpServer startServer() throws IOException {

        ResourceConfig resourceConfig = new ResourceConfig()
                .register(UserResource.class)
                .register(JacksonFeature.class);

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), resourceConfig);

        server.start();
        HttpHandler httpHandler = server.getHttpHandler();
        httpHandler.setAllowEncodedSlash(true);
        return server;
    }

    public static void main(String[] args) {

        try {
            startServer();
            LOGGER.info(String.format("HTTP server started: %s", BASE_URL));
        } catch (Exception e) {
            LOGGER.info("Failed to start the application:", e);
            System.exit(-1);
        }
    }
}
