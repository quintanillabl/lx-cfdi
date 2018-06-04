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
 * <p>Clase Java para t_ClaveEntidad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="t_ClaveEntidad">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AGU"/>
 *     &lt;enumeration value="BCN"/>
 *     &lt;enumeration value="BCS"/>
 *     &lt;enumeration value="CAM"/>
 *     &lt;enumeration value="CHP"/>
 *     &lt;enumeration value="CHH"/>
 *     &lt;enumeration value="COA"/>
 *     &lt;enumeration value="COL"/>
 *     &lt;enumeration value="CR1"/>
 *     &lt;enumeration value="CR2"/>
 *     &lt;enumeration value="CR3"/>
 *     &lt;enumeration value="CR4"/>
 *     &lt;enumeration value="CR5"/>
 *     &lt;enumeration value="DIF"/>
 *     &lt;enumeration value="DUR"/>
 *     &lt;enumeration value="GUA"/>
 *     &lt;enumeration value="GRO"/>
 *     &lt;enumeration value="HID"/>
 *     &lt;enumeration value="JAL"/>
 *     &lt;enumeration value="MEX"/>
 *     &lt;enumeration value="MIC"/>
 *     &lt;enumeration value="MOR"/>
 *     &lt;enumeration value="NAC"/>
 *     &lt;enumeration value="NAY"/>
 *     &lt;enumeration value="NLE"/>
 *     &lt;enumeration value="OAX"/>
 *     &lt;enumeration value="PUE"/>
 *     &lt;enumeration value="QUE"/>
 *     &lt;enumeration value="ROO"/>
 *     &lt;enumeration value="SLP"/>
 *     &lt;enumeration value="SIN"/>
 *     &lt;enumeration value="SON"/>
 *     &lt;enumeration value="TAB"/>
 *     &lt;enumeration value="TAM"/>
 *     &lt;enumeration value="TLA"/>
 *     &lt;enumeration value="VER"/>
 *     &lt;enumeration value="YUC"/>
 *     &lt;enumeration value="ZAC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "t_ClaveEntidad")
@XmlEnum
public enum TClaveEntidad {

    AGU("AGU"),
    BCN("BCN"),
    BCS("BCS"),
    CAM("CAM"),
    CHP("CHP"),
    CHH("CHH"),
    COA("COA"),
    COL("COL"),
    @XmlEnumValue("CR1")
    CR_1("CR1"),
    @XmlEnumValue("CR2")
    CR_2("CR2"),
    @XmlEnumValue("CR3")
    CR_3("CR3"),
    @XmlEnumValue("CR4")
    CR_4("CR4"),
    @XmlEnumValue("CR5")
    CR_5("CR5"),
    DIF("DIF"),
    DUR("DUR"),
    GUA("GUA"),
    GRO("GRO"),
    HID("HID"),
    JAL("JAL"),
    MEX("MEX"),
    MIC("MIC"),
    MOR("MOR"),
    NAC("NAC"),
    NAY("NAY"),
    NLE("NLE"),
    OAX("OAX"),
    PUE("PUE"),
    QUE("QUE"),
    ROO("ROO"),
    SLP("SLP"),
    SIN("SIN"),
    SON("SON"),
    TAB("TAB"),
    TAM("TAM"),
    TLA("TLA"),
    VER("VER"),
    YUC("YUC"),
    ZAC("ZAC");
    private final String value;

    TClaveEntidad(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TClaveEntidad fromValue(String v) {
        for (TClaveEntidad c: TClaveEntidad.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
