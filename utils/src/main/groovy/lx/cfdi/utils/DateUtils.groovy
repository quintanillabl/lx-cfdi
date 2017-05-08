package lx.cfdi.utils

import javax.xml.datatype.DatatypeFactory
import javax.xml.datatype.XMLGregorianCalendar

/**
 * Created by rcancino on 03/08/16.
 */
class DateUtils {


    public static XMLGregorianCalendar getXmlGregorianCalendar(Date fecha){
        GregorianCalendar cal = new GregorianCalendar()
        cal.setTime(fecha)
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal)
        return xmlGregorianCalendar
    }
}
