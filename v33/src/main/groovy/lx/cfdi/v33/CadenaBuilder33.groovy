package lx.cfdi.v33

import org.w3c.dom.Document
import org.xml.sax.InputSource

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.URIResolver
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

/**
 * Created by rcancino on 14/06/17.
 */
class CadenaBuilder33 implements  URIResolver{

    private Transformer transformer

    String build(Comprobante comprobante){

        Transformer transformer = getTransformer()
        StreamSource xmlSource = buildSource(comprobante)

        ByteArrayOutputStream out = new ByteArrayOutputStream()
        StreamResult target = new StreamResult(out)

        transformer.transform(xmlSource, target)
        byte[] cadenaOritinal = out.toByteArray()
        String cadena = new String(cadenaOritinal, "UTF-8")
        return cadena

    }




    Transformer getTransformer() {
        if (!this.transformer) {
            TransformerFactory factory=TransformerFactory.newInstance()
            factory.setURIResolver(this)
            StreamSource source	= new StreamSource(readXslFile())

            this.transformer = factory.newTransformer(source)
        }
        return this.transformer
    }


    InputStream readXslFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader()
        InputStream is = classloader.getResourceAsStream("cfdi33/xslt/cadenaoriginal_3_3.xslt")
        return is
    }

    StreamSource buildSource(Comprobante comprobante) {
        String xml = CfdiUtils.serialize(comprobante)
        Reader reader = new StringReader(xml)
        return  new StreamSource(reader)
    }

    @Override
    Source resolve(String href, String base) throws TransformerException {
        println "Resolviendo href: ${href}"
        String location = "cfdi33/xslt/${href}"
        ClassLoader classloader = Thread.currentThread().getContextClassLoader()
        InputStream is = classloader.getResourceAsStream(location)
        println "Resource found ${location} ${is}"
        assert is !=  null, "No existe el resource: ${location}"
        StreamSource source = new StreamSource(is)
        return source
    }

}
