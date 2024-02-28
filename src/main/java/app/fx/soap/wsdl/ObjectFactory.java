
package app.fx.soap.wsdl;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the app.fx.soap.wsdl package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: app.fx.soap.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaRucRequest }
     * 
     */
    public ConsultaRucRequest createConsultaRucRequest() {
        return new ConsultaRucRequest();
    }

    /**
     * Create an instance of {@link ConsultaRucResponse }
     * 
     */
    public ConsultaRucResponse createConsultaRucResponse() {
        return new ConsultaRucResponse();
    }

    /**
     * Create an instance of {@link RucContribuyente }
     * 
     */
    public RucContribuyente createRucContribuyente() {
        return new RucContribuyente();
    }

}
