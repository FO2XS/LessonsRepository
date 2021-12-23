
package service.endpoint;

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
@WebServiceClient(name = "TovarServiceService", targetNamespace = "http://endpoint.service/", wsdlLocation = "http://localhost:8080/ws02/TovarService?wsdl")
public class TovarServiceService
    extends Service
{

    private final static URL TOVARSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException TOVARSERVICESERVICE_EXCEPTION;
    private final static QName TOVARSERVICESERVICE_QNAME = new QName("http://endpoint.service/", "TovarServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ws02/TovarService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TOVARSERVICESERVICE_WSDL_LOCATION = url;
        TOVARSERVICESERVICE_EXCEPTION = e;
    }

    public TovarServiceService() {
        super(__getWsdlLocation(), TOVARSERVICESERVICE_QNAME);
    }

    public TovarServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TOVARSERVICESERVICE_QNAME, features);
    }

    public TovarServiceService(URL wsdlLocation) {
        super(wsdlLocation, TOVARSERVICESERVICE_QNAME);
    }

    public TovarServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TOVARSERVICESERVICE_QNAME, features);
    }

    public TovarServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TovarServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TovarService
     */
    @WebEndpoint(name = "TovarServicePort")
    public TovarService getTovarServicePort() {
        return super.getPort(new QName("http://endpoint.service/", "TovarServicePort"), TovarService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TovarService
     */
    @WebEndpoint(name = "TovarServicePort")
    public TovarService getTovarServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoint.service/", "TovarServicePort"), TovarService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TOVARSERVICESERVICE_EXCEPTION!= null) {
            throw TOVARSERVICESERVICE_EXCEPTION;
        }
        return TOVARSERVICESERVICE_WSDL_LOCATION;
    }

}
