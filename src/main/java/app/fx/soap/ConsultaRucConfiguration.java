package app.fx.soap;

import app.fx.soap.client.ConsultaRucSoapClient;
import app.fx.soap.wsdl.RucContribuyente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class ConsultaRucConfiguration {

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);

        // Configurar la seguridad
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setSecurementUsername("user"); // Nombre de usuario
        securityInterceptor.setSecurementPassword("password"); // Contraseña
        //securityInterceptor.setSecurementPasswordType("PasswordText"); // Tipo de contraseña

        // Agregar el interceptor de seguridad al WebServiceTemplate
        webServiceTemplate.setInterceptors(new org.springframework.ws.client.support.interceptor.ClientInterceptor[] {securityInterceptor});

        // Configurar un sender HTTP para el transporte
        //webServiceTemplate.setMessageSender(new HttpComponentsMessageSender());

        return webServiceTemplate;
    }
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller= new Jaxb2Marshaller();
        marshaller.setContextPath("app.fx.soap.wsdl");
        return marshaller;
    }
    @Bean
    public ConsultaRucSoapClient consultaRucSoapClient(Jaxb2Marshaller marshaller){
        ConsultaRucSoapClient client = null;
        try {
            client = new ConsultaRucSoapClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        client.setDefaultUri("http://localhost/ws");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
        client.setWebServiceTemplate(webServiceTemplate(marshaller));
        return client;
    }
}
