package lx.cfdi.v33

import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

/**
 * Created by rcancino on 14/06/17.
 */
class CadenaBuilder33 {

    String build(Comprobante comprobante){

        TransformerFactory factory = TransformerFactory.newInstance()
        StreamSource source	= new StreamSource("http://www.sat.gob.mx/sitio_internet/cfd/3/cadenaoriginal_3_3/cadenaoriginal_3_3.xslt")
        Transformer transformer = factory.newTransformer(source)

        Reader reader = new StringReader()

        Writer writer = new StringWriter()
        StreamResult target = new StreamResult(writer)
        StreamSource xmlSource = new StreamSource()
        transformer.transform(xmlSoure, target)


    }
}
