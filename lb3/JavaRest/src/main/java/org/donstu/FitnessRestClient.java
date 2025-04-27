package org.donstu;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class FitnessRestClient {
    private static final String BASE_URL = "http://localhost:8080/workout/";
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) {
        try {
            System.out.println("Список доступных тренировок:");
            String response = sendGetRequest("list");
            System.out.println("Ответ сервера:\n" + response);
        } catch (IOException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        } finally {
            closeHttpClient();
        }
    }

    private static String sendGetRequest(String endpoint) throws IOException {
        HttpGet request = new HttpGet(BASE_URL + endpoint);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
    }

    private static void closeHttpClient() {
        try {
            httpClient.close();
        } catch (IOException e) {
            System.err.println("Ошибка при закрытии HTTP клиента: " + e.getMessage());
        }
    }
}