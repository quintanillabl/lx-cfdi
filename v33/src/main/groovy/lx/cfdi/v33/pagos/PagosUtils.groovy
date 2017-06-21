package lx.cfdi.v33.pagos

import groovy.util.slurpersupport.GPathResult
import groovy.xml.XmlUtil
import lx.cfdi.v33.Pagos
import lx.cfdi.v33.Comprobante

import javax.xml.XMLConstants
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.ValidationEventHandler
import javax.xml.transform.stream.StreamSource
import javax.xml.transform.Source
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory

/**
 * Created by rcancino on 20/06/17.
 */
class PagosUtils {

    static String xsiSchemaLocation = "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd"

    private static Schema schema = null

    public static JAXBContext getContext(){
        JAXBContext context = JAXBContext.newInstance(Comprobante.class, Pagos.class)
        return context
    }

    static Marshaller getMarshaller(validation = true, ValidationEventHandler validationHandler = null){
        JAXBContext context = getContext()
        Marshaller marshaller = context.createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true)
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,xsiSchemaLocation)

        if(validation){
            marshaller.setSchema(getSchema())
        }
        marshaller.setEventHandler(validationHandler);
        return marshaller
    }

    static Schema getSchema (){
        if(!schema){
            Source schema1 = new StreamSource("http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd")
            Source schema2 = new StreamSource("http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd")
            Source[] schemas = [schema1, schema2]
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
            schema = sf.newSchema(schemas)

        }
        return schema
    }

    static String serialize(Comprobante comprobante){
        StringWriter writer = new StringWriter()
        JAXBContext context = getContext()
        Marshaller marshaller = getMarshaller(false)
        marshaller.marshal(comprobante, writer)
        GPathResult res = new XmlSlurper().parse(new ByteArrayInputStream(writer.toString().bytes))
        return XmlUtil.serialize(res)
    }

    static byte[] toXmlByteArray(Comprobante comprobante){
        JAXBContext context = getContext()
        Marshaller marshaller = getMarshaller()
        ByteArrayOutputStream os = new ByteArrayOutputStream()
        marshaller.marshal(comprobante, os)
        return os.toByteArray()
    }
}
