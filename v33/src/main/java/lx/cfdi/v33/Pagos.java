package lx.cfdi.v33;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="Pago" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DoctoRelacionado" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="IdDocumento" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="16"/>
 *                                 &lt;maxLength value="36"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="([a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12})|([0-9]{3}-[0-9]{2}-[0-9]{9})"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Serie">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="25"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,25}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Folio">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="40"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,40}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="MonedaDR" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
 *                           &lt;attribute name="TipoCambioDR">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                 &lt;fractionDigits value="6"/>
 *                                 &lt;minInclusive value="0.000001"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="MetodoDePagoDR" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_MetodoPago" />
 *                           &lt;attribute name="NumParcialidad">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[1-9][0-9]{0,2}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ImpSaldoAnt" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="ImpPagado" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="ImpSaldoInsoluto" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Impuestos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Retenciones" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Retencion" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                               &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Traslados" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Traslado" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                               &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                               &lt;attribute name="TasaOCuota" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                     &lt;fractionDigits value="6"/>
 *                                                     &lt;minInclusive value="0.000000"/>
 *                                                     &lt;whiteSpace value="collapse"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="FechaPago" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_FechaH" />
 *                 &lt;attribute name="FormaDePagoP" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_FormaPago" />
 *                 &lt;attribute name="MonedaP" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
 *                 &lt;attribute name="TipoCambioP">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                       &lt;fractionDigits value="6"/>
 *                       &lt;minInclusive value="0.000001"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Monto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                 &lt;attribute name="NumOperacion">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="100"/>
 *                       &lt;pattern value="[^|]{1,100}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RfcEmisorCtaOrd">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="12"/>
 *                       &lt;maxLength value="13"/>
 *                       &lt;pattern value="XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="NomBancoOrdExt">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[^|]{1,300}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="CtaOrdenante">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="10"/>
 *                       &lt;maxLength value="50"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-Z0-9_]{10,50}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RfcEmisorCtaBen" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC_PM" />
 *                 &lt;attribute name="CtaBeneficiario">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="10"/>
 *                       &lt;maxLength value="50"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[A-Z0-9_]{10,50}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="TipoCadPago" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/Pagos}c_TipoCadenaPago" />
 *                 &lt;attribute name="CertPago">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="CadPago">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="8192"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="SelloPago">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" use="required" fixed="1.0">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
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
    "pago"
})
@XmlRootElement(name = "Pagos",namespace = "http://www.sat.gob.mx/Pagos")
public class Pagos {

    @XmlElement(name = "Pago", required = true, namespace = "http://www.sat.gob.mx/Pagos")
    protected List<Pago> pago;
    @XmlAttribute(name = "Version", required = true)
    protected String version;

    /**
     * Gets the value of the pago property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pago property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPago().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pagos.Pago }
     *
     *
     */
    public List<Pago> getPago() {
        if (pago == null) {
            pago = new ArrayList<Pago>();
        }
        return this.pago;
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
            return "1.0";
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
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DoctoRelacionado" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="IdDocumento" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="16"/>
     *                       &lt;maxLength value="36"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="([a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12})|([0-9]{3}-[0-9]{2}-[0-9]{9})"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Serie">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="25"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,25}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Folio">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="40"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,40}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="MonedaDR" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
     *                 &lt;attribute name="TipoCambioDR">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                       &lt;fractionDigits value="6"/>
     *                       &lt;minInclusive value="0.000001"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="MetodoDePagoDR" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_MetodoPago" />
     *                 &lt;attribute name="NumParcialidad">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[1-9][0-9]{0,2}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ImpSaldoAnt" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="ImpPagado" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="ImpSaldoInsoluto" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Impuestos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Retenciones" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Retencion" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Traslados" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Traslado" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                                     &lt;attribute name="TasaOCuota" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                           &lt;fractionDigits value="6"/>
     *                                           &lt;minInclusive value="0.000000"/>
     *                                           &lt;whiteSpace value="collapse"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="FechaPago" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_FechaH" />
     *       &lt;attribute name="FormaDePagoP" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_FormaPago" />
     *       &lt;attribute name="MonedaP" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
     *       &lt;attribute name="TipoCambioP">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *             &lt;fractionDigits value="6"/>
     *             &lt;minInclusive value="0.000001"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="Monto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *       &lt;attribute name="NumOperacion">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="100"/>
     *             &lt;pattern value="[^|]{1,100}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="RfcEmisorCtaOrd">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="12"/>
     *             &lt;maxLength value="13"/>
     *             &lt;pattern value="XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="NomBancoOrdExt">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="300"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[^|]{1,300}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="CtaOrdenante">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="10"/>
     *             &lt;maxLength value="50"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[A-Z0-9_]{10,50}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="RfcEmisorCtaBen" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC_PM" />
     *       &lt;attribute name="CtaBeneficiario">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="10"/>
     *             &lt;maxLength value="50"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[A-Z0-9_]{10,50}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="TipoCadPago" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/Pagos}c_TipoCadenaPago" />
     *       &lt;attribute name="CertPago">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="CadPago">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="8192"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="SelloPago">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
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
        "doctoRelacionado",
        "impuestos"
    })
    public static class Pago {

        @XmlElement(name = "DoctoRelacionado")
        protected List<DoctoRelacionado> doctoRelacionado;
        @XmlElement(name = "Impuestos")
        protected List<Impuestos> impuestos;

        @XmlAttribute(name = "FechaPago", required = true)
        //protected XMLGregorianCalendar fechaPago;
        protected String fechaPago;

        @XmlAttribute(name = "FormaDePagoP", required = true)
        protected String formaDePagoP;
        @XmlAttribute(name = "MonedaP", required = true)
        protected CMoneda monedaP;
        @XmlAttribute(name = "TipoCambioP")
        protected BigDecimal tipoCambioP;
        @XmlAttribute(name = "Monto", required = true)
        protected BigDecimal monto;
        @XmlAttribute(name = "NumOperacion")
        protected String numOperacion;
        @XmlAttribute(name = "RfcEmisorCtaOrd")
        protected String rfcEmisorCtaOrd;
        @XmlAttribute(name = "NomBancoOrdExt")
        protected String nomBancoOrdExt;
        @XmlAttribute(name = "CtaOrdenante")
        protected String ctaOrdenante;
        @XmlAttribute(name = "RfcEmisorCtaBen")
        protected String rfcEmisorCtaBen;
        @XmlAttribute(name = "CtaBeneficiario")
        protected String ctaBeneficiario;
        @XmlAttribute(name = "TipoCadPago")
        protected String tipoCadPago;
        @XmlAttribute(name = "CertPago")
        protected byte[] certPago;
        @XmlAttribute(name = "CadPago")
        protected String cadPago;
        @XmlAttribute(name = "SelloPago")
        protected byte[] selloPago;

        /**
         * Gets the value of the doctoRelacionado property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doctoRelacionado property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoctoRelacionado().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Pagos.Pago.DoctoRelacionado }
         *
         *
         */
        public List<DoctoRelacionado> getDoctoRelacionado() {
            if (doctoRelacionado == null) {
                doctoRelacionado = new ArrayList<DoctoRelacionado>();
            }
            return this.doctoRelacionado;
        }

        /**
         * Gets the value of the impuestos property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the impuestos property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImpuestos().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Pagos.Pago.Impuestos }
         *
         *
         */
        public List<Impuestos> getImpuestos() {
            if (impuestos == null) {
                impuestos = new ArrayList<Impuestos>();
            }
            return this.impuestos;
        }

        /**
         * Obtiene el valor de la propiedad fechaPago.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public String getFechaPago() {
            return fechaPago;
        }

        /**
         * Define el valor de la propiedad fechaPago.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setFechaPago(String value) {
            this.fechaPago = value;
        }

        /**
         * Obtiene el valor de la propiedad formaDePagoP.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFormaDePagoP() {
            return formaDePagoP;
        }

        /**
         * Define el valor de la propiedad formaDePagoP.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFormaDePagoP(String value) {
            this.formaDePagoP = value;
        }

        /**
         * Obtiene el valor de la propiedad monedaP.
         *
         * @return
         *     possible object is
         *     {@link CMoneda }
         *
         */
        public CMoneda getMonedaP() {
            return monedaP;
        }

        /**
         * Define el valor de la propiedad monedaP.
         *
         * @param value
         *     allowed object is
         *     {@link CMoneda }
         *
         */
        public void setMonedaP(CMoneda value) {
            this.monedaP = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoCambioP.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTipoCambioP() {
            return tipoCambioP;
        }

        /**
         * Define el valor de la propiedad tipoCambioP.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTipoCambioP(BigDecimal value) {
            this.tipoCambioP = value;
        }

        /**
         * Obtiene el valor de la propiedad monto.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getMonto() {
            return monto;
        }

        /**
         * Define el valor de la propiedad monto.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setMonto(BigDecimal value) {
            this.monto = value;
        }

        /**
         * Obtiene el valor de la propiedad numOperacion.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNumOperacion() {
            return numOperacion;
        }

        /**
         * Define el valor de la propiedad numOperacion.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNumOperacion(String value) {
            this.numOperacion = value;
        }

        /**
         * Obtiene el valor de la propiedad rfcEmisorCtaOrd.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRfcEmisorCtaOrd() {
            return rfcEmisorCtaOrd;
        }

        /**
         * Define el valor de la propiedad rfcEmisorCtaOrd.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRfcEmisorCtaOrd(String value) {
            this.rfcEmisorCtaOrd = value;
        }

        /**
         * Obtiene el valor de la propiedad nomBancoOrdExt.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNomBancoOrdExt() {
            return nomBancoOrdExt;
        }

        /**
         * Define el valor de la propiedad nomBancoOrdExt.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNomBancoOrdExt(String value) {
            this.nomBancoOrdExt = value;
        }

        /**
         * Obtiene el valor de la propiedad ctaOrdenante.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCtaOrdenante() {
            return ctaOrdenante;
        }

        /**
         * Define el valor de la propiedad ctaOrdenante.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCtaOrdenante(String value) {
            this.ctaOrdenante = value;
        }

        /**
         * Obtiene el valor de la propiedad rfcEmisorCtaBen.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRfcEmisorCtaBen() {
            return rfcEmisorCtaBen;
        }

        /**
         * Define el valor de la propiedad rfcEmisorCtaBen.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRfcEmisorCtaBen(String value) {
            this.rfcEmisorCtaBen = value;
        }

        /**
         * Obtiene el valor de la propiedad ctaBeneficiario.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCtaBeneficiario() {
            return ctaBeneficiario;
        }

        /**
         * Define el valor de la propiedad ctaBeneficiario.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCtaBeneficiario(String value) {
            this.ctaBeneficiario = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoCadPago.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTipoCadPago() {
            return tipoCadPago;
        }

        /**
         * Define el valor de la propiedad tipoCadPago.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTipoCadPago(String value) {
            this.tipoCadPago = value;
        }

        /**
         * Obtiene el valor de la propiedad certPago.
         *
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getCertPago() {
            return certPago;
        }

        /**
         * Define el valor de la propiedad certPago.
         *
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setCertPago(byte[] value) {
            this.certPago = value;
        }

        /**
         * Obtiene el valor de la propiedad cadPago.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCadPago() {
            return cadPago;
        }

        /**
         * Define el valor de la propiedad cadPago.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCadPago(String value) {
            this.cadPago = value;
        }

        /**
         * Obtiene el valor de la propiedad selloPago.
         *
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getSelloPago() {
            return selloPago;
        }

        /**
         * Define el valor de la propiedad selloPago.
         *
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setSelloPago(byte[] value) {
            this.selloPago = value;
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
         *       &lt;attribute name="IdDocumento" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="16"/>
         *             &lt;maxLength value="36"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="([a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12})|([0-9]{3}-[0-9]{2}-[0-9]{9})"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Serie">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="25"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,25}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Folio">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="40"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,40}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="MonedaDR" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
         *       &lt;attribute name="TipoCambioDR">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *             &lt;fractionDigits value="6"/>
         *             &lt;minInclusive value="0.000001"/>
         *             &lt;whiteSpace value="collapse"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="MetodoDePagoDR" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_MetodoPago" />
         *       &lt;attribute name="NumParcialidad">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[1-9][0-9]{0,2}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ImpSaldoAnt" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="ImpPagado" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="ImpSaldoInsoluto" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DoctoRelacionado {

            @XmlAttribute(name = "IdDocumento", required = true)
            protected String idDocumento;
            @XmlAttribute(name = "Serie")
            protected String serie;
            @XmlAttribute(name = "Folio")
            protected String folio;
            @XmlAttribute(name = "MonedaDR", required = true)
            protected CMoneda monedaDR;
            @XmlAttribute(name = "TipoCambioDR")
            protected BigDecimal tipoCambioDR;
            @XmlAttribute(name = "MetodoDePagoDR", required = true)
            protected CMetodoPago metodoDePagoDR;
            @XmlAttribute(name = "NumParcialidad")
            protected BigInteger numParcialidad;
            @XmlAttribute(name = "ImpSaldoAnt")
            protected BigDecimal impSaldoAnt;
            @XmlAttribute(name = "ImpPagado")
            protected BigDecimal impPagado;
            @XmlAttribute(name = "ImpSaldoInsoluto")
            protected BigDecimal impSaldoInsoluto;

            /**
             * Obtiene el valor de la propiedad idDocumento.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getIdDocumento() {
                return idDocumento;
            }

            /**
             * Define el valor de la propiedad idDocumento.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setIdDocumento(String value) {
                this.idDocumento = value;
            }

            /**
             * Obtiene el valor de la propiedad serie.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSerie() {
                return serie;
            }

            /**
             * Define el valor de la propiedad serie.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSerie(String value) {
                this.serie = value;
            }

            /**
             * Obtiene el valor de la propiedad folio.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getFolio() {
                return folio;
            }

            /**
             * Define el valor de la propiedad folio.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setFolio(String value) {
                this.folio = value;
            }

            /**
             * Obtiene el valor de la propiedad monedaDR.
             *
             * @return
             *     possible object is
             *     {@link CMoneda }
             *
             */
            public CMoneda getMonedaDR() {
                return monedaDR;
            }

            /**
             * Define el valor de la propiedad monedaDR.
             *
             * @param value
             *     allowed object is
             *     {@link CMoneda }
             *
             */
            public void setMonedaDR(CMoneda value) {
                this.monedaDR = value;
            }

            /**
             * Obtiene el valor de la propiedad tipoCambioDR.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getTipoCambioDR() {
                return tipoCambioDR;
            }

            /**
             * Define el valor de la propiedad tipoCambioDR.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setTipoCambioDR(BigDecimal value) {
                this.tipoCambioDR = value;
            }

            /**
             * Obtiene el valor de la propiedad metodoDePagoDR.
             *
             * @return
             *     possible object is
             *     {@link CMetodoPago }
             *
             */
            public CMetodoPago getMetodoDePagoDR() {
                return metodoDePagoDR;
            }

            /**
             * Define el valor de la propiedad metodoDePagoDR.
             *
             * @param value
             *     allowed object is
             *     {@link CMetodoPago }
             *
             */
            public void setMetodoDePagoDR(CMetodoPago value) {
                this.metodoDePagoDR = value;
            }

            /**
             * Obtiene el valor de la propiedad numParcialidad.
             *
             * @return
             *     possible object is
             *     {@link BigInteger }
             *
             */
            public BigInteger getNumParcialidad() {
                return numParcialidad;
            }

            /**
             * Define el valor de la propiedad numParcialidad.
             *
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *
             */
            public void setNumParcialidad(BigInteger value) {
                this.numParcialidad = value;
            }

            /**
             * Obtiene el valor de la propiedad impSaldoAnt.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getImpSaldoAnt() {
                return impSaldoAnt;
            }

            /**
             * Define el valor de la propiedad impSaldoAnt.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setImpSaldoAnt(BigDecimal value) {
                this.impSaldoAnt = value;
            }

            /**
             * Obtiene el valor de la propiedad impPagado.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getImpPagado() {
                return impPagado;
            }

            /**
             * Define el valor de la propiedad impPagado.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setImpPagado(BigDecimal value) {
                this.impPagado = value;
            }

            /**
             * Obtiene el valor de la propiedad impSaldoInsoluto.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getImpSaldoInsoluto() {
                return impSaldoInsoluto;
            }

            /**
             * Define el valor de la propiedad impSaldoInsoluto.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setImpSaldoInsoluto(BigDecimal value) {
                this.impSaldoInsoluto = value;
            }

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
         *         &lt;element name="Retenciones" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Retencion" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Traslados" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Traslado" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                           &lt;attribute name="TasaOCuota" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                 &lt;fractionDigits value="6"/>
         *                                 &lt;minInclusive value="0.000000"/>
         *                                 &lt;whiteSpace value="collapse"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "retenciones",
            "traslados"
        })
        public static class Impuestos {

            @XmlElement(name = "Retenciones")
            protected Pagos.Pago.Impuestos.Retenciones retenciones;
            @XmlElement(name = "Traslados")
            protected Pagos.Pago.Impuestos.Traslados traslados;
            @XmlAttribute(name = "TotalImpuestosRetenidos")
            protected BigDecimal totalImpuestosRetenidos;
            @XmlAttribute(name = "TotalImpuestosTrasladados")
            protected BigDecimal totalImpuestosTrasladados;

            /**
             * Obtiene el valor de la propiedad retenciones.
             *
             * @return
             *     possible object is
             *     {@link Pagos.Pago.Impuestos.Retenciones }
             *
             */
            public Pagos.Pago.Impuestos.Retenciones getRetenciones() {
                return retenciones;
            }

            /**
             * Define el valor de la propiedad retenciones.
             *
             * @param value
             *     allowed object is
             *     {@link Pagos.Pago.Impuestos.Retenciones }
             *
             */
            public void setRetenciones(Pagos.Pago.Impuestos.Retenciones value) {
                this.retenciones = value;
            }

            /**
             * Obtiene el valor de la propiedad traslados.
             *
             * @return
             *     possible object is
             *     {@link Pagos.Pago.Impuestos.Traslados }
             *
             */
            public Pagos.Pago.Impuestos.Traslados getTraslados() {
                return traslados;
            }

            /**
             * Define el valor de la propiedad traslados.
             *
             * @param value
             *     allowed object is
             *     {@link Pagos.Pago.Impuestos.Traslados }
             *
             */
            public void setTraslados(Pagos.Pago.Impuestos.Traslados value) {
                this.traslados = value;
            }

            /**
             * Obtiene el valor de la propiedad totalImpuestosRetenidos.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getTotalImpuestosRetenidos() {
                return totalImpuestosRetenidos;
            }

            /**
             * Define el valor de la propiedad totalImpuestosRetenidos.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setTotalImpuestosRetenidos(BigDecimal value) {
                this.totalImpuestosRetenidos = value;
            }

            /**
             * Obtiene el valor de la propiedad totalImpuestosTrasladados.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getTotalImpuestosTrasladados() {
                return totalImpuestosTrasladados;
            }

            /**
             * Define el valor de la propiedad totalImpuestosTrasladados.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setTotalImpuestosTrasladados(BigDecimal value) {
                this.totalImpuestosTrasladados = value;
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
             *         &lt;element name="Retencion" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
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
                "retencion"
            })
            public static class Retenciones {

                @XmlElement(name = "Retencion", required = true)
                protected List<Retencion> retencion;

                /**
                 * Gets the value of the retencion property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the retencion property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getRetencion().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Pagos.Pago.Impuestos.Retenciones.Retencion }
                 *
                 *
                 */
                public List<Retencion> getRetencion() {
                    if (retencion == null) {
                        retencion = new ArrayList<Retencion>();
                    }
                    return this.retencion;
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
                 *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                 *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Retencion {

                    @XmlAttribute(name = "Impuesto", required = true)
                    protected String impuesto;
                    @XmlAttribute(name = "Importe", required = true)
                    protected BigDecimal importe;

                    /**
                     * Obtiene el valor de la propiedad impuesto.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getImpuesto() {
                        return impuesto;
                    }

                    /**
                     * Define el valor de la propiedad impuesto.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setImpuesto(String value) {
                        this.impuesto = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad importe.
                     *
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *
                     */
                    public BigDecimal getImporte() {
                        return importe;
                    }

                    /**
                     * Define el valor de la propiedad importe.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *
                     */
                    public void setImporte(BigDecimal value) {
                        this.importe = value;
                    }

                }

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
             *         &lt;element name="Traslado" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *                 &lt;attribute name="TasaOCuota" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                       &lt;fractionDigits value="6"/>
             *                       &lt;minInclusive value="0.000000"/>
             *                       &lt;whiteSpace value="collapse"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
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
                "traslado"
            })
            public static class Traslados {

                @XmlElement(name = "Traslado", required = true)
                protected List<Traslado> traslado;

                /**
                 * Gets the value of the traslado property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the traslado property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTraslado().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Pagos.Pago.Impuestos.Traslados.Traslado }
                 *
                 *
                 */
                public List<Traslado> getTraslado() {
                    if (traslado == null) {
                        traslado = new ArrayList<Traslado>();
                    }
                    return this.traslado;
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
                 *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                 *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                 *       &lt;attribute name="TasaOCuota" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *             &lt;fractionDigits value="6"/>
                 *             &lt;minInclusive value="0.000000"/>
                 *             &lt;whiteSpace value="collapse"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Traslado {

                    @XmlAttribute(name = "Impuesto", required = true)
                    protected String impuesto;
                    @XmlAttribute(name = "TipoFactor", required = true)
                    protected CTipoFactor tipoFactor;
                    @XmlAttribute(name = "TasaOCuota", required = true)
                    protected BigDecimal tasaOCuota;
                    @XmlAttribute(name = "Importe", required = true)
                    protected BigDecimal importe;

                    /**
                     * Obtiene el valor de la propiedad impuesto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getImpuesto() {
                        return impuesto;
                    }

                    /**
                     * Define el valor de la propiedad impuesto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setImpuesto(String value) {
                        this.impuesto = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad tipoFactor.
                     * 
                     * @return
                     *     possible object is
                     *     {@link CTipoFactor }
                     *     
                     */
                    public CTipoFactor getTipoFactor() {
                        return tipoFactor;
                    }

                    /**
                     * Define el valor de la propiedad tipoFactor.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link CTipoFactor }
                     *     
                     */
                    public void setTipoFactor(CTipoFactor value) {
                        this.tipoFactor = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad tasaOCuota.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getTasaOCuota() {
                        return tasaOCuota;
                    }

                    /**
                     * Define el valor de la propiedad tasaOCuota.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setTasaOCuota(BigDecimal value) {
                        this.tasaOCuota = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad importe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getImporte() {
                        return importe;
                    }

                    /**
                     * Define el valor de la propiedad importe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setImporte(BigDecimal value) {
                        this.importe = value;
                    }

                }

            }

        }

    }

}
