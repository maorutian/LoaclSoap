
package com.mycompany.restservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMovieByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMovieByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetMovieById" type="{http://services.soapservice.mycompany.com/}movie" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMovieByIdResponse", propOrder = {
    "getMovieById"
})
public class GetMovieByIdResponse {

    @XmlElement(name = "GetMovieById")
    protected Movie getMovieById;

    /**
     * Gets the value of the getMovieById property.
     * 
     * @return
     *     possible object is
     *     {@link Movie }
     *     
     */
    public Movie getGetMovieById() {
        return getMovieById;
    }

    /**
     * Sets the value of the getMovieById property.
     * 
     * @param value
     *     allowed object is
     *     {@link Movie }
     *     
     */
    public void setGetMovieById(Movie value) {
        this.getMovieById = value;
    }

}
