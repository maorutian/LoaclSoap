
package com.mycompany.soapservice.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UploadImageResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadImageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UploadImage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadImageResponse", propOrder = {
    "uploadImage"
})
public class UploadImageResponse {

    @XmlElement(name = "UploadImage")
    protected int uploadImage;

    /**
     * Gets the value of the uploadImage property.
     * 
     */
    public int getUploadImage() {
        return uploadImage;
    }

    /**
     * Sets the value of the uploadImage property.
     * 
     */
    public void setUploadImage(int value) {
        this.uploadImage = value;
    }

}
