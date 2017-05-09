package com.luxsoft.cfdi.v32

import groovy.util.slurpersupport.GPathResult
import groovy.xml.XmlUtil
import lx.cfdi.utils.DateUtils
import lx.cfdi.v32.Comprobante
import lx.cfdi.v32.ObjectFactory
import lx.cfdi.v32.TUbicacion
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
        expect: CfdiUtils.schemaUrl.toString()  == 'http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd'

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

    def 'Tratar de  XML de un cfdi invalido'(){

        given: 'Un cfdi invalido'
        Comprobante cfdi = buildComprobanteInvalido()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Salvamos la balanza  a un StringWriter'
        CfdiUtils.marshall(cfdi,writer)

        then: 'Debemos obtener un error'
        thrown(MarshalException)

    }



    def 'Debe generar un cfdi valido'(){

        given: 'Una cfdi valido'
        Comprobante comprobante = buildComprobanteValido()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Salvamos el comprobante  a un StringWriter'
        CfdiUtils.marshall(comprobante,writer)

        then: 'Obtenemos el comprobante  en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new ByteArrayInputStream(writer.toString().bytes))
        'Comprobante' == res.name()
        println XmlUtil.serialize(res)
    }



    def 'Debe persister un xml valido al file system '(){

        given: 'Cfdi valido'
        Comprobante comprobante = buildComprobanteValido()

        and: 'Un StringWriter'
        def target = File.createTempFile('cfdi', '.xml')
        //def target = new File('/Users/rcancino/data', 'cfdi-de-prueba.xml')
        when: 'Salvamos el cfdi a un StringWriter'
        CfdiUtils.marshall(comprobante,target)

        then: 'Obtenemos una balanza en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new File(target.absolutePath))
        'Comprobante' == res.name()
        println res.name()
    }


    def 'Debe obtner un Comprobante a partir de un archivo xml  '(){

        given: 'Una balanza valida'
        //Balanza balanza = buildBalanzaValida()
        File xmlFile = new File('./src/test/resources/demo.xml')
        assert xmlFile.exists()

        when: 'Parseamos el archivo'
        byte[] bytes = xmlFile.bytes
        Comprobante comprobante = CfdiUtils.read(bytes)

        then: 'La instancia de Catalogo obtenida es valida'
        comprobante.fecha
        comprobante.emisor
        comprobante.receptor
        comprobante.conceptos

    }

    

    def buildComprobanteInvalido(){
        Comprobante comprobante = factory.createComprobante()
        comprobante.setSerie('CFDI')
        comprobante.setFolio('001')
        return comprobante
    }

    def buildComprobanteValido(){
        Comprobante comprobante = factory.createComprobante()
        comprobante.version = "3.2"
        comprobante.setFecha(DateUtils.getXmlGregorianCalendar(new Date()))
        comprobante.setFormaDePago('PAGO EN UNA SOLA EXHIBICION')
        comprobante.setNoCertificado('00001000000304410871')
        comprobante.metodoDePago ="04"
        comprobante.certificado = "MIIEiTCCA3GgAwIBAgIUMDAwMDEwMDAwMDAzMDQ0MTA4NzEwDQYJKoZIhvcNAQEFBQAwggGKMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMR8wHQYJKoZIhvcNAQkBFhBhY29kc0BzYXQuZ29iLm14MSYwJAYDVQQJDB1Bdi4gSGlkYWxnbyA3NywgQ29sLiBHdWVycmVybzEOMAwGA1UEEQwFMDYzMDAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBEaXN0cml0byBGZWRlcmFsMRQwEgYDVQQHDAtDdWF1aHTDqW1vYzEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTUwMwYJKoZIhvcNAQkCDCZSZXNwb25zYWJsZTogQ2xhdWRpYSBDb3ZhcnJ1YmlhcyBPY2hvYTAeFw0xNDA2MTExOTAwNDNaFw0xODA2MTExOTAwNDNaMIHVMSUwIwYDVQQDExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQpExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQKExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQtExxIU0cwOTEwMjZMN0EgLyBNQUFNNDcxMDI1SzQyMR4wHAYDVQQFExUgLyBNQUFNNDcxMDI1SE5FVEJOMDYxFzAVBgNVBAsTDkhPVEVMRVJBIFNBQ09ZMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrgncjOH+NFWtJWiGvqfllBdyCtn/uYyLi5LDzHSEcDw4CrF+wRDIMTdds7jH8ZlZrcYxMeNzJTsypU6NVOWIxH1eKF9+yIyW2mThhCkP+kH2pueCD1Z0lr4D9oAOAxMh0Cy/v9wal3dQVOf2hGjhs6cn3E9Zx1HxhQQ3dmKbxfwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQUFAAOCAQEAxVPQlAzMEvOpIT19qteXXFt635WU/rEv7XQ3JTCm45owu6Rz6e/kYrYTXjSKNNaV+FwXcaE5cb/rpz6LbzXWHiBB6wuY7l0xctznC76SWvPtZHJK4FL88wxwmRWElla78Yeu23f0wrxd9DyrxVfgayepDnIAxnR+b0UaHVzq00mtOlQrVNwDXg0sXjKm3x06y0S+SeKUDUv7JRAD/ZDZ/ZyOomTEDrUbRgQehbkz4v6lbPmFhT7s7s5xzY15dMBI7kEBzBtscrKBxPDbSfk1kJYUpMI1AyNRWYbmfNuYXyR7HogqjwHAOHMUA6rm0regk1QPKJPzUP2dstprAOyYdQ=="
        comprobante.tipoCambio = "1"
        comprobante.moneda = "Peso Mexicano"
        comprobante.subTotal = 630.25
        comprobante.total = 750.00
        comprobante.tipoDeComprobante = "ingreso"
        comprobante.lugarExpedicion = "CUITLAHUAC 2701 , OBRERO POPULAR, 02840, Azcapotzalco, Ciudad de México, Distrito Federal, México"
        comprobante.with {
            serie = 'CFDI'
            folio = '001'
        }
        comprobante.sello = "C2uRW/hW6cBqlWQftRIXtLTl312NO6tzDpRiR5uw46sY8xdvcayErk2XGfjdyiff6D9BaB+LhwMf1WTf2MaCjgUlgPLgfyLNsx6MD45+rR1MVV7CzbWVEUAVEh7yKL7zskk9iKBhip5gbbkaYoc2mnPRhx0hq4mqtkgH/a3/abY="

        /**** Emisor ****/
        Comprobante.Emisor emisor = factory.createComprobanteEmisor()
        emisor.rfc = "HSG091026L7A"
        emisor.nombre = "HOTELERA SACOY GRUP SA DE CV"
        comprobante.emisor = emisor
        comprobante.emisor.domicilioFiscal = factory.createTUbicacionFiscal()
        comprobante.emisor.domicilioFiscal.with {
            calle="CUITLAHUAC"
            noExterior="2701"
            colonia="OBRERO POPULAR"
            localidad="Ciudad de México"
            municipio="Azcapotzalco"
            estado="Distrito Federal"
            pais="México"
            codigoPostal="02840"
        }
        Comprobante.Emisor.RegimenFiscal rf = factory.createComprobanteEmisorRegimenFiscal()
        rf.setRegimen("REGIMEN GENERAL DE LEY PERSONA MORAL")
        emisor.getRegimenFiscal().add(rf)

        /** Receptor ***/
        Comprobante.Receptor receptor = factory.createComprobanteReceptor()
        receptor.rfc = "CARR700317575"
        receptor.nombre = "RUBEN CANCINO RAMOS"

        TUbicacion  domicilio =  factory.createTUbicacion()
        domicilio.with {
            calle = "PASEO DE POTRERO"
            noExterior = "109"
            colonia = "PEDREGAL DEL GIGANTE"
            estado = "GUANAJUATO"
            pais = "MEXICO"
            codigoPostal = "37296"
        }
        receptor.domicilio = domicilio
        comprobante.receptor = receptor

        /** Conceptos ***/
        Comprobante.Conceptos conceptos = factory.createComprobanteConceptos()
        Comprobante.Conceptos.Concepto concepto = factory.createComprobanteConceptosConcepto()
        concepto.with {
            cantidad = 1.00
            unidad = "No aplica"
            noIdentificacion = "05"
            descripcion = "HABITACION JUNIOR SUITE DIA COMPLETO&#xA;CHECK IN 15:00&#xA;CHECK OUT 13:00&#xA;04/04/17-05/04/17"
            valorUnitario = 630.25
            importe = 630.25
        }
        conceptos.concepto.add(concepto)
        comprobante.conceptos = conceptos

        /** Impuestos **/

        Comprobante.Impuestos impuestos = factory.createComprobanteImpuestos()
        impuestos.setTotalImpuestosTrasladados(100.84)

        Comprobante.Impuestos.Traslados traslados = factory.createComprobanteImpuestosTraslados();

        Comprobante.Impuestos.Traslados.Traslado traslado = factory.createComprobanteImpuestosTrasladosTraslado()
        traslado.with {
            impuesto="IVA"
            tasa = 16.00
            importe =100.84
        }
        traslados.traslado.add(traslado)
        impuestos.traslados = traslados
        comprobante.setImpuestos(impuestos)

        return comprobante
    }
}
