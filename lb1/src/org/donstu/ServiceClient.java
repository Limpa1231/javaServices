package org.donstu;

import org.donstu.client.FitnessService;
import org.donstu.client.FitnessService_Service;
import org.donstu.client.GymZone;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceClient {
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
        try {
            FitnessService_Service svc = new FitnessService_Service(url, FQDN);
            FitnessService port = svc.getFitnessPort();

            List<GymZone> zones = port.getAvailableZones();

            if (zones.isEmpty()) {
                System.out.println("Нет доступных зон в фитнес-клубе.");
                return;
            }

            System.out.println("Доступные зоны в фитнес-клубе:");
            zones.forEach(zone -> System.out.printf(
                    "Зона: %-15s Вместимость: %d%n",
                    zone.getZoneName(),
                    zone.getCapacity()
            ));

        } catch (Exception e) {
            System.err.println("Ошибка при получении данных о зонах:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/fitness?wsdl");
            ServiceClient client = new ServiceClient();
            client.processAvailableZones(wsdlUrl);
        } catch (Exception e) {
            System.err.println("Фатальная ошибка при запуске клиента:");
            e.printStackTrace();
        }
    }
}