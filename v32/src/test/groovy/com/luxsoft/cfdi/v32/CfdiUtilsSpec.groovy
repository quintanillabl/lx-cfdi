package com.luxsoft.cfdi.v32

import groovy.util.slurpersupport.GPathResult
import lx.cfdi.v32.ObjectFactory
import spock.lang.Specification

import javax.xml.bind.JAXBContext
import javax.xml.bind.MarshalException

/**
 * Created by rcancino on 08/05/17.
 */
class CfdiUtilsSpec extends Specification{

    ObjectFactory factory

    def setup(){
        factory = new ObjectFactory()
    }

    def 'Proporcionar un contexto '(){
        expect: CfdiUtils.getContext() instanceof JAXBContext
    }

    def 'Debe proporiconar un URL para el schema'(){
        expect: CfdiUtils.schemaUrl.toString()  == 'http://www.sat.gob.mx/esquemas/ContabilidadE/1_1/BalanzaComprobacion/BalanzaComprobacion_1_1.xsd'

    }

    def 'Debe proporcinar una instancia de Schema'() {
        expect: CfdiUtils.getSchema()
    }

    def 'Debe proporcionar un Marhaller '() {
        expect: CfdiUtils.getMarshaller()
    }

    def 'Debe proporcionar un  Unmarshaller'(){
        expect: CfdiUtils.getUnmarshaller()
    }

    def 'Generacion  XML '(){

        /*given: 'Una cfdi valid0'
        Balanza balanza = buildBalanzaValida()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Salvamos la balanza  a un StringWriter'
        BalanzaUtils.marshall(balanza,writer)

        then: 'Obtenemos la balanza  en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new ByteArrayInputStream(writer.toString().bytes))
        'Balanza' == res.name()
        println res.name()*/
    }

    /*def 'Tratar de  XML de un balanza invalida'(){

        given: 'Un balanza invalido'
        Balanza balanza = buildBalanzaInvalida()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Salvamos la balanza  a un StringWriter'
        BalanzaUtils.marshall(balanza,writer)

        then: 'Debemos obtener un error'
        thrown(MarshalException)

    }

    def 'Persistencia a XML File de una balanza '(){

        given: 'Una balanza valida'
        Balanza balanza = buildBalanzaValida()

        and: 'Un StringWriter'
        def target = File.createTempFile('balanza', '.xml')
        when: 'Salvamos el catalogo a un StringWriter'
        BalanzaUtils.marshall(balanza,target)

        then: 'Obtenemos una balanza en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new File(target.absolutePath))
        'Balanza' == res.name()
        println res.name()
    }

    def 'Debe poder leer en byte[] una balanza en XML  '(){

        given: 'Una balanza valida'
        Balanza balanza = buildBalanzaValida()

        when: 'Obtenemos el byte array'
        byte[] bytes = BalanzaUtils.toXmlByteArray(balanza)
        ByteArrayInputStream is = new ByteArrayInputStream(bytes)

        then: 'Obtenemos una balanza en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(is)
        'Balanza' == res.name()
        println res.name()
    }

    def 'Debe obtener una balanza a partir de arreglo de bytes' (){
        given: 'Una balanza valida'
        Balanza balanza = buildBalanzaValida()

        when: 'Obtenemos un byte[] del mismo'
        byte[] data = BalanzaUtils.toXmlByteArray(balanza)

        and: 'Leemos los bytes'
        Balanza res = BalanzaUtils.read(data)

        then: 'La instancia de Catalogo obtenida es valida'
        res.anio == balanza.anio
        res.mes == balanza.mes
        res.rfc == balanza.rfc
    }

    def 'Obtener el nombre valido para un archvio xml de envio al SAT'(){
        given: 'Una balanza valida'
        Balanza balanza = buildBalanzaValida()

        when: 'Obtenemos el nombre del archivo'
        String fileName = BalanzaUtils.getFileName(balanza)

        then: 'El nombre debe ser valido'
        fileName == "${balanza.rfc}${balanza.anio}${balanza.mes}B${balanza.tipoEnvio}.xml"
    }

    def 'Obtener una Balanza a partir de un archivo'(){
        given: 'Un Catalogo XML en archivo'
        def file = new File('src/test/resources/balanza.xml')
        assert file.exists(), 'No existe el archivo de prueba en src/test/resources/catalogo.xml'
        file.geN
        when:' leemos el archivo'
        Balanza balanza = BalanzaUtils.read(file)

        then: 'Obtenemos una instancia de Balanza'
        notThrown(Exception)
        balanza
        balanza.anio == 2016


    }

    def buildBalanzaInvalida(){
        Balanza balanza = factory.createBalanza()
        balanza.setAnio(2016)
        balanza.setMes('01')
        return balanza
    }

    def buildBalanzaValida(){
        Balanza balanza = factory.createBalanza()
        balanza.with {
            version = '1.1'
            anio = 2016
            mes = '01'
            rfc = 'CARR700317575'
            tipoEnvio = 'N'

        }
        balanza.setFechaModBal(DateUtils.getXmlGregorianCalendar(new Date()))
        Balanza.Ctas ctas = factory.createBalanzaCtas()
        ctas.with {
            debe = 100.00
            haber = 0.0
            numCta = '100-000'
            saldoIni = 0.0
            saldoFin = 100.00
        }
        balanza.getCtas().add(ctas)

        return balanza
    }*/
}
