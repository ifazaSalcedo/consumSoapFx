package app.fx.soap;

import app.fx.soap.client.ConsultaRucSoapClient;
import app.fx.soap.wsdl.RucContribuyente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConsultaRucConfiguration {


    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller= new Jaxb2Marshaller();
        marshaller.setContextPath("app.fx.soap.wsdl");
        return marshaller;
    }
    @Bean
    public ConsultaRucSoapClient consultaRucSoapClient(Jaxb2Marshaller marshaller){
        ConsultaRucSoapClient client = new ConsultaRucSoapClient();
        client.setDefaultUri("http://localhost:8097/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
