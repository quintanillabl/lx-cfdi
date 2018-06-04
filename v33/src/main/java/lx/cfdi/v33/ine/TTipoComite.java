//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.30 a las 10:39:04 AM CDT 
//


package lx.cfdi.v33.ine;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para t_TipoComite.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="t_TipoComite">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ejecutivo Nacional"/>
 *     &lt;enumeration value="Ejecutivo Estatal"/>
 *     &lt;enumeration value="Directivo Estatal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "t_TipoComite")
@XmlEnum
public enum TTipoComite {

    @XmlEnumValue("Ejecutivo Nacional")
    EJECUTIVO_NACIONAL("Ejecutivo Nacional"),
    @XmlEnumValue("Ejecutivo Estatal")
    EJECUTIVO_ESTATAL("Ejecutivo Estatal"),
    @XmlEnumValue("Directivo Estatal")
    DIRECTIVO_ESTATAL("Directivo Estatal");
    private final String value;

    TTipoComite(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTipoComite fromValue(String v) {
        for (TTipoComite c: TTipoComite.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
