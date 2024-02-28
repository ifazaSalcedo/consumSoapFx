package app.fx.soap.client;

import app.fx.soap.wsdl.ConsultaRucRequest;
import app.fx.soap.wsdl.ConsultaRucResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ConsultaRucSoapClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ConsultaRucSoapClient.class);
    public ConsultaRucResponse getConsultaRuc(String ruc){
        ConsultaRucRequest request= new ConsultaRucRequest();
        request.setRucParamentro(ruc);
        log.info("Respuesta a RUC "+ ruc);
        ConsultaRucResponse response= (ConsultaRucResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8097/ws/consultaRuc",
                        request,new SoapActionCallback("http://wsoap.com/pwserver/consulta/ConsultaRucRequest"));
        return  response;
    }
}
