
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingRS" type="{http://www.juniper.es/webservice/2007/}JP_BookingRS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookingRS"
})
@XmlRootElement(name = "ServiceBookingResponse")
public class ServiceBookingResponse {

    @XmlElement(name = "BookingRS")
    protected JPBookingRS bookingRS;

    /**
     * Gets the value of the bookingRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingRS }
     *     
     */
    public JPBookingRS getBookingRS() {
        return bookingRS;
    }

    /**
     * Sets the value of the bookingRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingRS }
     *     
     */
    public void setBookingRS(JPBookingRS value) {
        this.bookingRS = value;
    }

}
