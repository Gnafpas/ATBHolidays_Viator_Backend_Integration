
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_InsuranceRelPaxDist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_InsuranceRelPaxDist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelPaxDist" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceRelPaxDist" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_InsuranceRelPaxDist", propOrder = {
    "relPaxDist"
})
public class ArrayOfJPInsuranceRelPaxDist {

    @XmlElement(name = "RelPaxDist")
    protected List<JPInsuranceRelPaxDist> relPaxDist;

    /**
     * Gets the value of the relPaxDist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relPaxDist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelPaxDist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPInsuranceRelPaxDist }
     * 
     * 
     */
    public List<JPInsuranceRelPaxDist> getRelPaxDist() {
        if (relPaxDist == null) {
            relPaxDist = new ArrayList<JPInsuranceRelPaxDist>();
        }
        return this.relPaxDist;
    }

}
