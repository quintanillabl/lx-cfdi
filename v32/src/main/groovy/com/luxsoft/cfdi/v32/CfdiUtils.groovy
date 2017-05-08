package com.luxsoft.cfdi.v32

import lx.cfdi.v32.Comprobante

import javax.xml.XMLConstants
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller
import javax.xml.bind.ValidationEventHandler
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory


/**
 * Created by rcancino on 08/05/17.
 */
class CfdiUtils {


    static String xsiSchemaLocation = "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd"

    static URL schemaUrl = new URL("http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd")

    public static JAXBContext getContext(){
        JAXBContext context = JAXBContext.newInstance(Comprobante.class)
        return context
    }

    private static Schema schema = null

    static Schema getSchema (){
        if(!schema){
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
            schema = sf.newSchema(schemaUrl)
        }
        return schema
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

    static marshall(Comprobante comprobante,Writer writer){
        JAXBContext context = getContext()
        Marshaller marshaller = getMarshaller()
        marshaller.marshal(comprobante, writer)
    }

    static marshall(Comprobante comprobante,File file){
        JAXBContext context = getContext()
        Marshaller marshaller = getMarshaller()
        marshaller.marshal(comprobante, file)
    }

    static byte[] toXmlByteArray(Comprobante comprobante){
        JAXBContext context = getContext()
        Marshaller marshaller = getMarshaller()
        ByteArrayOutputStream os = new ByteArrayOutputStream()
        marshaller.marshal(comprobante, os)
        return os.toByteArray()
    }

    static Unmarshaller getUnmarshaller(validation = true, ValidationEventHandler validationHandler = null){
        JAXBContext context = getContext()
        Unmarshaller unmarshaller = context.createUnmarshaller()
        if(validation){
            unmarshaller.setSchema(getSchema())
        }
        unmarshaller.setEventHandler(validationHandler)
        return unmarshaller
    }

    static Comprobante read(byte[] data){
        Unmarshaller unmarshaller = getUnmarshaller()
        return (Comprobante)unmarshaller.unmarshal(new ByteArrayInputStream(data))
    }

    static Comprobante read(File file){
        Unmarshaller unmarshaller = getUnmarshaller()
        return (Comprobante)unmarshaller.unmarshal(file)
    }

    static String getFileName(Comprobante comprobante){
        String name = "${comprobante.tipoDeComprobante}-${comprobante.serie}-${comprobante.folio}+${comprobante.folio}"
        return name
    }
}
