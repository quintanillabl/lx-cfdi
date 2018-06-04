//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.30 a las 10:39:04 AM CDT 
//


package lx.cfdi.v33.ine;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Entidad" maxOccurs="76" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Contabilidad" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="IdContabilidad" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                 &lt;totalDigits value="6"/>
 *                                 &lt;fractionDigits value="0"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ClaveEntidad" use="required" type="{http://www.sat.gob.mx/ine}t_ClaveEntidad" />
 *                 &lt;attribute name="Ambito">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.sat.gob.mx/ine}t_Ambito">
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" use="required" fixed="1.1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="TipoProceso" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.sat.gob.mx/ine}t_TipoProc">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="TipoComite">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.sat.gob.mx/ine}t_TipoComite">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="IdContabilidad">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;totalDigits value="6"/>
 *             &lt;fractionDigits value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entidad"
})
@XmlRootElement(name = "INE")
public class INE {

    @XmlElement(name = "Entidad")
    protected List<Entidad> entidad;
    @XmlAttribute(name = "Version", required = true)
    protected String version;
    @XmlAttribute(name = "TipoProceso", required = true)
    protected TTipoProc tipoProceso;
    @XmlAttribute(name = "TipoComite")
    protected TTipoComite tipoComite;
    @XmlAttribute(name = "IdContabilidad")
    protected Integer idContabilidad;

    /**
     * Gets the value of the entidad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entidad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntidad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Entidad }
     * 
     * 
     */
    public List<Entidad> getEntidad() {
        if (entidad == null) {
            entidad = new ArrayList<Entidad>();
        }
        return this.entidad;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.1";
        } else {
            return version;
        }
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoProceso.
     * 
     * @return
     *     possible object is
     *     {@link TTipoProc }
     *     
     */
    public TTipoProc getTipoProceso() {
        return tipoProceso;
    }

    /**
     * Define el valor de la propiedad tipoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link TTipoProc }
     *     
     */
    public void setTipoProceso(TTipoProc value) {
        this.tipoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoComite.
     * 
     * @return
     *     possible object is
     *     {@link TTipoComite }
     *     
     */
    public TTipoComite getTipoComite() {
        return tipoComite;
    }

    /**
     * Define el valor de la propiedad tipoComite.
     * 
     * @param value
     *     allowed object is
     *     {@link TTipoComite }
     *     
     */
    public void setTipoComite(TTipoComite value) {
        this.tipoComite = value;
    }

    /**
     * Obtiene el valor de la propiedad idContabilidad.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdContabilidad() {
        return idContabilidad;
    }

    /**
     * Define el valor de la propiedad idContabilidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdContabilidad(Integer value) {
        this.idContabilidad = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Contabilidad" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="IdContabilidad" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                       &lt;totalDigits value="6"/>
     *                       &lt;fractionDigits value="0"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="ClaveEntidad" use="required" type="{http://www.sat.gob.mx/ine}t_ClaveEntidad" />
     *       &lt;attribute name="Ambito">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.sat.gob.mx/ine}t_Ambito">
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "contabilidad"
    })
    public static class Entidad {

        @XmlElement(name = "Contabilidad")
        protected List<Contabilidad> contabilidad;
        @XmlAttribute(name = "ClaveEntidad", required = true)
        protected TClaveEntidad claveEntidad;
        @XmlAttribute(name = "Ambito")
        protected TAmbito ambito;

        /**
         * Gets the value of the contabilidad property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contabilidad property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContabilidad().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Contabilidad }
         * 
         * 
         */
        public List<Contabilidad> getContabilidad() {
            if (contabilidad == null) {
                contabilidad = new ArrayList<Contabilidad>();
            }
            return this.contabilidad;
        }

        /**
         * Obtiene el valor de la propiedad claveEntidad.
         * 
         * @return
         *     possible object is
         *     {@link TClaveEntidad }
         *     
         */
        public TClaveEntidad getClaveEntidad() {
            return claveEntidad;
        }

        /**
         * Define el valor de la propiedad claveEntidad.
         * 
         * @param value
         *     allowed object is
         *     {@link TClaveEntidad }
         *     
         */
        public void setClaveEntidad(TClaveEntidad value) {
            this.claveEntidad = value;
        }

        /**
         * Obtiene el valor de la propiedad ambito.
         * 
         * @return
         *     possible object is
         *     {@link TAmbito }
         *     
         */
        public TAmbito getAmbito() {
            return ambito;
        }

        /**
         * Define el valor de la propiedad ambito.
         * 
         * @param value
         *     allowed object is
         *     {@link TAmbito }
         *     
         */
        public void setAmbito(TAmbito value) {
            this.ambito = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="IdContabilidad" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *             &lt;totalDigits value="6"/>
         *             &lt;fractionDigits value="0"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Contabilidad {

            @XmlAttribute(name = "IdContabilidad", required = true)
            protected int idContabilidad;

            /**
             * Obtiene el valor de la propiedad idContabilidad.
             * 
             */
            public int getIdContabilidad() {
                return idContabilidad;
            }

            /**
             * Define el valor de la propiedad idContabilidad.
             * 
             */
            public void setIdContabilidad(int value) {
                this.idContabilidad = value;
            }

        }

    }

}
