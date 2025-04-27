package org.donstu;


import org.donstu.async.FitnessService;
import org.donstu.async.FitnessService_Service;
import org.donstu.async.GetAvailableZonesResponse;
import org.donstu.async.GymZone;


import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServiceClientAsync {
    private static final QName FQDN = new QName("https://donstu.org/fitness", "FitnessService");

    // Метод для безопасного создания URL с обработкой ошибок
    private static URL getWsdlUrl(String urlStr) {
        try {
            return new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Неверный URL WSDL: " + urlStr, e);
        }
    }

    // Основной метод обработки данных
    public void processAvailableZones(URL url) {
        Response<GetAvailableZonesResponse> response = null;
        try {
            FitnessService_Service svc = new FitnessService_Service(url, FQDN);
            FitnessService port = svc.getFitnessPort();
            response = port.getAvailableZonesAsync();
            while (!response.isDone()) {
                try {
                    System.out.println("Ждём ответа...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при получении данных о зонах:");
            e.printStackTrace();
        }
        try {
            List<GymZone> zones = response.get().getReturn();
            zones.forEach(zone -> System.out.println(
                   "Зона: " +
                   "Название='" + zone.getZoneName() + '\'' +
                   ", Вместимость=" + zone.getCapacity() +
                            '}'
            ));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    class AviableZonesAsyncHandler implements AsyncHandler<GetAvailableZonesResponse> {

        @Override
        public void handleResponse(Response<GetAvailableZonesResponse> res) {
            System.out.println("Результат готов!");
            try {
                List<GymZone> zones = res.get().getReturn();
                zones.forEach(zone -> System.out.println(
                        "Зона: " +
                        "Название='" + zone.getZoneName() + '\'' +
                        ", Вместимость=" + zone.getCapacity() +
                                '}'
                ));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void processAvailableZonesCallback(URL url) {
        try {
            FitnessService_Service svc = new FitnessService_Service(url, FQDN);
            FitnessService port = svc.getFitnessPort();

            port.getAvailableZonesAsync(new AviableZonesAsyncHandler());

            System.out.println("Запрос отправлен, ожидаем callback...");
            // Даем время для получения ответа
            Thread.sleep(5000);

        } catch (Exception e) {
            System.err.println("Ошибка при обработке callback:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/fitness?wsdl");
            ServiceClientAsync client = new ServiceClientAsync();
            client.processAvailableZones(wsdlUrl);
            client.processAvailableZonesCallback(wsdlUrl);
        } catch (Exception e) {
            System.err.println("Фатальная ошибка при запуске клиента:");
            e.printStackTrace();
        }
    }
}