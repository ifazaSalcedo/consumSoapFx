
package app.fx.soap.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rucContribuyente" type="{http://wsoap.com/pwserver/consulta}rucContribuyente"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rucContribuyente"
})
@XmlRootElement(name = "consultaRucResponse")
public class ConsultaRucResponse {

    @XmlElement(required = true)
    protected RucContribuyente rucContribuyente;

    /**
     * Obtiene el valor de la propiedad rucContribuyente.
     * 
     * @return
     *     possible object is
     *     {@link RucContribuyente }
     *     
     */
    public RucContribuyente getRucContribuyente() {
        return rucContribuyente;
    }

    /**
     * Define el valor de la propiedad rucContribuyente.
     * 
     * @param value
     *     allowed object is
     *     {@link RucContribuyente }
     *     
     */
    public void setRucContribuyente(RucContribuyente value) {
        this.rucContribuyente = value;
    }

}
