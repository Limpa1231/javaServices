package org.donstu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.donstu.domain.Workout;

public class FitnessRestService {
    private static final int PORT = 8080;
    private static final int OK = 200;
    private static final int NOT_ALLOWED = 405;
    private static List<Workout> workouts = new ArrayList();

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            httpServer.createContext("/workout/list", (httpExchange) -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                    httpExchange.sendResponseHeaders(OK, 0L);
                    ObjectMapper mapper = new ObjectMapper();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    mapper.writeValue(baos, workouts);
                    byte[] body = baos.toByteArray();
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(body);
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1L);
                }
            });
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        workouts.add(new Workout("Йога", new Date(), 60, "Анна Петрова"));
        workouts.add(new Workout("Фитнес", new Date(), 45, "Иван Сидоров"));
        workouts.add(new Workout("Пилатес", new Date(), 55, "Мария Иванова"));
    }
}