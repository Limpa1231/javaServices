package org.donstu.service;

import org.donstu.domain.GymZone;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED;
import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService(serviceName = "FitnessService", portName = "FitnessPort",
        targetNamespace = "https://donstu.org/fitness")
@SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = WRAPPED)
public class FitnessService {

    @WebMethod(operationName = "getAvailableZones")
    public List<GymZone> getAvailableZones() {
        List<GymZone> zones = new ArrayList<>();
        zones.add(new GymZone("Тренажеры", 15));
        zones.add(new GymZone("Аэробика", 10));
        zones.add(new GymZone("Бассейн", 12));
        return zones;
    }
}