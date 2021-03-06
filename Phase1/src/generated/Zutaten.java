//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.09 at 10:06:33 PM CEST 
//


package generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="zutat" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zutatname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="menge" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="einheit">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="g"/>
 *                         &lt;enumeration value="ml"/>
 *                         &lt;enumeration value="EL"/>
 *                         &lt;enumeration value="TL"/>
 *                         &lt;enumeration value="Tasse"/>
 *                         &lt;enumeration value="nach_Belieben"/>
 *                         &lt;enumeration value="Stck."/>
 *                         &lt;enumeration value="Pck."/>
 *                         &lt;enumeration value="ein_Spritzer"/>
 *                         &lt;enumeration value="Dose"/>
 *                         &lt;enumeration value="Schheibe"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "zutat"
})
@XmlRootElement(name = "zutaten")
public class Zutaten {

    @XmlElement(required = true)
    protected List<Zutaten.Zutat> zutat;

    /**
     * Gets the value of the zutat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zutat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZutat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zutaten.Zutat }
     * 
     * 
     */
    public List<Zutaten.Zutat> getZutat() {
        if (zutat == null) {
            zutat = new ArrayList<Zutaten.Zutat>();
        }
        return this.zutat;
    }


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
     *         &lt;element name="zutatname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="menge" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="einheit">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="g"/>
     *               &lt;enumeration value="ml"/>
     *               &lt;enumeration value="EL"/>
     *               &lt;enumeration value="TL"/>
     *               &lt;enumeration value="Tasse"/>
     *               &lt;enumeration value="nach_Belieben"/>
     *               &lt;enumeration value="Stck."/>
     *               &lt;enumeration value="Pck."/>
     *               &lt;enumeration value="ein_Spritzer"/>
     *               &lt;enumeration value="Dose"/>
     *               &lt;enumeration value="Schheibe"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
        "zutatname",
        "menge",
        "einheit"
    })
    public static class Zutat {

        @XmlElement(required = true)
        protected String zutatname;
        @XmlElement(required = true)
        protected BigDecimal menge;
        @XmlElement(required = true)
        protected String einheit;

        /**
         * Gets the value of the zutatname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZutatname() {
            return zutatname;
        }

        /**
         * Sets the value of the zutatname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZutatname(String value) {
            this.zutatname = value;
        }

        /**
         * Gets the value of the menge property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMenge() {
            return menge;
        }

        /**
         * Sets the value of the menge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMenge(BigDecimal value) {
            this.menge = value;
        }

        /**
         * Gets the value of the einheit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEinheit() {
            return einheit;
        }

        /**
         * Sets the value of the einheit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEinheit(String value) {
            this.einheit = value;
        }

    }

}
