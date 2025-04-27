
package org.donstu.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.donstu.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAvailableZones_QNAME = new QName("https://donstu.org/fitness", "getAvailableZones");
    private final static QName _GetAvailableZonesResponse_QNAME = new QName("https://donstu.org/fitness", "getAvailableZonesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.donstu.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAvailableZonesResponse }
     * 
     */
    public GetAvailableZonesResponse createGetAvailableZonesResponse() {
        return new GetAvailableZonesResponse();
    }

    /**
     * Create an instance of {@link GetAvailableZones }
     * 
     */
    public GetAvailableZones createGetAvailableZones() {
        return new GetAvailableZones();
    }

    /**
     * Create an instance of {@link GymZone }
     * 
     */
    public GymZone createGymZone() {
        return new GymZone();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableZones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/fitness", name = "getAvailableZones")
    public JAXBElement<GetAvailableZones> createGetAvailableZones(GetAvailableZones value) {
        return new JAXBElement<GetAvailableZones>(_GetAvailableZones_QNAME, GetAvailableZones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableZonesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/fitness", name = "getAvailableZonesResponse")
    public JAXBElement<GetAvailableZonesResponse> createGetAvailableZonesResponse(GetAvailableZonesResponse value) {
        return new JAXBElement<GetAvailableZonesResponse>(_GetAvailableZonesResponse_QNAME, GetAvailableZonesResponse.class, null, value);
    }

}
