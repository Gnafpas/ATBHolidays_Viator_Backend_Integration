
package DAOs.CarnectAPIDAOs.DestinationsDAOs;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "destination", targetNamespace = "http://www.opentravel.org/OTA/2003/05", wsdlLocation = "https://ota2007a.micronnexus-staging.com/destination.asmx?WSDL")
public class Destination
    extends Service
{

    private final static URL DESTINATION_WSDL_LOCATION;
    private final static WebServiceException DESTINATION_EXCEPTION;
    private final static QName DESTINATION_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "destination");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://ota2007a.micronnexus-staging.com/destination.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DESTINATION_WSDL_LOCATION = url;
        DESTINATION_EXCEPTION = e;
    }

    public Destination() {
        super(__getWsdlLocation(), DESTINATION_QNAME);
    }

    public Destination(WebServiceFeature... features) {
        super(__getWsdlLocation(), DESTINATION_QNAME, features);
    }

    public Destination(URL wsdlLocation) {
        super(wsdlLocation, DESTINATION_QNAME);
    }

    public Destination(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DESTINATION_QNAME, features);
    }

    public Destination(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Destination(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DestinationSoap
     */
    @WebEndpoint(name = "destinationSoap")
    public DestinationSoap getDestinationSoap() {
        return super.getPort(new QName("http://www.opentravel.org/OTA/2003/05", "destinationSoap"), DestinationSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DestinationSoap
     */
    @WebEndpoint(name = "destinationSoap")
    public DestinationSoap getDestinationSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.opentravel.org/OTA/2003/05", "destinationSoap"), DestinationSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DESTINATION_EXCEPTION!= null) {
            throw DESTINATION_EXCEPTION;
        }
        return DESTINATION_WSDL_LOCATION;
    }

}
