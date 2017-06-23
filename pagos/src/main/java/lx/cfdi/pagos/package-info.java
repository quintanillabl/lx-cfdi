@javax.xml.bind.annotation.XmlSchema(
        //namespace = "http://www.sat.gob.mx/Pagos",
        xmlns = {
                @XmlNs(prefix = "cfdi", namespaceURI = "http://www.sat.gob.mx/cfd/3"),
                @XmlNs(prefix = "pago10", namespaceURI = "http://www.sat.gob.mx/Pagos"),
        },
        elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED
)
@XmlAccessorType(XmlAccessType.FIELD)
package lx.cfdi.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlNs;