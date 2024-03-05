package app.fx.soap.client;

import app.fx.soap.wsdl.ConsultaRucRequest;
import app.fx.soap.wsdl.ConsultaRucResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class ConsultaRucSoapClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(ConsultaRucSoapClient.class);
//    private String usuario= "user";
//    private String clave = "password";

//    public ConsultaRucSoapClient() throws Exception {
//
//        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
//        securityInterceptor.setSecurementActions("UsernameToken");
//        securityInterceptor.setSecurementUsername(usuario);
//        securityInterceptor.setSecurementPassword(clave);
//        securityInterceptor.afterPropertiesSet();
//
//        // Set the security interceptor to the WebServiceTemplate
//        getWebServiceTemplate().setInterceptors(new ClientInterceptor[]{securityInterceptor});
//
//    }

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
