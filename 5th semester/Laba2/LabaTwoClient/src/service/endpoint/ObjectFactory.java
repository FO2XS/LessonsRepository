
package service.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.endpoint package. 
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

    private final static QName _AuthenticationResponse_QNAME = new QName("http://endpoint.service/", "authenticationResponse");
    private final static QName _GetSumOfTovar_QNAME = new QName("http://endpoint.service/", "getSumOfTovar");
    private final static QName _SetNewTovar_QNAME = new QName("http://endpoint.service/", "setNewTovar");
    private final static QName _SetNewTovarResponse_QNAME = new QName("http://endpoint.service/", "setNewTovarResponse");
    private final static QName _GetSumOfTovarResponse_QNAME = new QName("http://endpoint.service/", "getSumOfTovarResponse");
    private final static QName _Authentication_QNAME = new QName("http://endpoint.service/", "authentication");
    private final static QName _GetAllTovarResponse_QNAME = new QName("http://endpoint.service/", "getAllTovarResponse");
    private final static QName _GetAllTovar_QNAME = new QName("http://endpoint.service/", "getAllTovar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthenticationResponse }
     * 
     */
    public AuthenticationResponse createAuthenticationResponse() {
        return new AuthenticationResponse();
    }

    /**
     * Create an instance of {@link GetSumOfTovar }
     * 
     */
    public GetSumOfTovar createGetSumOfTovar() {
        return new GetSumOfTovar();
    }

    /**
     * Create an instance of {@link SetNewTovar }
     * 
     */
    public SetNewTovar createSetNewTovar() {
        return new SetNewTovar();
    }

    /**
     * Create an instance of {@link GetSumOfTovarResponse }
     * 
     */
    public GetSumOfTovarResponse createGetSumOfTovarResponse() {
        return new GetSumOfTovarResponse();
    }

    /**
     * Create an instance of {@link SetNewTovarResponse }
     * 
     */
    public SetNewTovarResponse createSetNewTovarResponse() {
        return new SetNewTovarResponse();
    }

    /**
     * Create an instance of {@link GetAllTovar }
     * 
     */
    public GetAllTovar createGetAllTovar() {
        return new GetAllTovar();
    }

    /**
     * Create an instance of {@link Authentication }
     * 
     */
    public Authentication createAuthentication() {
        return new Authentication();
    }

    /**
     * Create an instance of {@link GetAllTovarResponse }
     * 
     */
    public GetAllTovarResponse createGetAllTovarResponse() {
        return new GetAllTovarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "authenticationResponse")
    public JAXBElement<AuthenticationResponse> createAuthenticationResponse(AuthenticationResponse value) {
        return new JAXBElement<AuthenticationResponse>(_AuthenticationResponse_QNAME, AuthenticationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSumOfTovar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "getSumOfTovar")
    public JAXBElement<GetSumOfTovar> createGetSumOfTovar(GetSumOfTovar value) {
        return new JAXBElement<GetSumOfTovar>(_GetSumOfTovar_QNAME, GetSumOfTovar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewTovar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "setNewTovar")
    public JAXBElement<SetNewTovar> createSetNewTovar(SetNewTovar value) {
        return new JAXBElement<SetNewTovar>(_SetNewTovar_QNAME, SetNewTovar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNewTovarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "setNewTovarResponse")
    public JAXBElement<SetNewTovarResponse> createSetNewTovarResponse(SetNewTovarResponse value) {
        return new JAXBElement<SetNewTovarResponse>(_SetNewTovarResponse_QNAME, SetNewTovarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSumOfTovarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "getSumOfTovarResponse")
    public JAXBElement<GetSumOfTovarResponse> createGetSumOfTovarResponse(GetSumOfTovarResponse value) {
        return new JAXBElement<GetSumOfTovarResponse>(_GetSumOfTovarResponse_QNAME, GetSumOfTovarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authentication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "authentication")
    public JAXBElement<Authentication> createAuthentication(Authentication value) {
        return new JAXBElement<Authentication>(_Authentication_QNAME, Authentication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTovarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "getAllTovarResponse")
    public JAXBElement<GetAllTovarResponse> createGetAllTovarResponse(GetAllTovarResponse value) {
        return new JAXBElement<GetAllTovarResponse>(_GetAllTovarResponse_QNAME, GetAllTovarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTovar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.service/", name = "getAllTovar")
    public JAXBElement<GetAllTovar> createGetAllTovar(GetAllTovar value) {
        return new JAXBElement<GetAllTovar>(_GetAllTovar_QNAME, GetAllTovar.class, null, value);
    }

}
