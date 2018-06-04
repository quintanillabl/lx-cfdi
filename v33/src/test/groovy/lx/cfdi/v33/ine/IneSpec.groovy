package lx.cfdi.v33.ine

import groovy.util.slurpersupport.GPathResult
import groovy.xml.XmlUtil
import lx.cfdi.utils.DateUtils
import lx.cfdi.v33.CEstado
import lx.cfdi.v33.CMetodoPago
import lx.cfdi.v33.CMoneda
import lx.cfdi.v33.CTipoDeComprobante
import lx.cfdi.v33.CTipoFactor
import lx.cfdi.v33.CUsoCFDI
import lx.cfdi.v33.CfdiUtils
import lx.cfdi.v33.Comprobante
import lx.cfdi.v33.ObjectFactory
import spock.lang.Specification

import javax.xml.bind.MarshalException

/**
 * Created by rcancino on 22/06/17.
 */
class IneSpec extends  Specification{

    ObjectFactory factory

    def setup(){
        factory = new ObjectFactory()
    }

    def 'Generar un complemento valido'(){
        given: 'Un complemento valido'
        INE ine = buildComplemento()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Transformamos a xml el complemento'
        IneUtils.getMarshaller().marshal(ine,writer)

        then: 'Obtenemos el XMl'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new ByteArrayInputStream(writer.toString().bytes))
        'INE' == res.name()
        println XmlUtil.serialize(res)
    }


    def 'Generar un cfdi valido'(){

        given: 'Una cfdi valido'
        Comprobante comprobante = buildComprobanteValido()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Salvamos el comprobante  a un StringWriter'
        IneUtils
                .getMarshaller()
                .marshal(comprobante,writer)


        then: 'Obtenemos el comprobante  en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new ByteArrayInputStream(writer.toString().bytes))
        'Comprobante' == res.name()
        println XmlUtil.serialize(res)
    }


    def buildComplemento(){
        INE ine = factory.createINE()
        ine.version = '1.1'
        ine.tipoProceso = TTipoProc.CAMPANA
        return ine
    }


    def buildComprobanteValido(){
        Comprobante comprobante = factory.createComprobante()
        comprobante.version = "3.3"
        comprobante.serie = 'NOMINA'
        comprobante.folio = '001'

        comprobante.setFecha(DateUtils.getCfdiDate(new Date()))
        comprobante.sello = "C2uRW/hW6cBqlWQftRIXtLTl312NO6tzDpRiR5uw46sY8xdvcayErk2XGfjdyiff6D9BaB+LhwMf1WTf2MaCjgUlgPLgfyLNsx6MD45+rR1MVV7CzbWVEUAVEh7yKL7zskk9iKBhip5gbbkaYoc2mnPRhx0hq4mqtkgH/a3/abY="
        comprobante.formaPago = '04'
        comprobante.setNoCertificado('00001000000304410871')
        comprobante.certificado = "MIIEiTCCA3GgAwIBAgIUMDAwMDEwMDAwMDAzMDQ0MTA4NzEwDQYJKoZIhvcNAQEFBQAwggGKMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMR8wHQYJKoZIhvcNAQkBFhBhY29kc0BzYXQuZ29iLm14MSYwJAYDVQQJDB1Bdi4gSGlkYWxnbyA3NywgQ29sLiBHdWVycmVybzEOMAwGA1UEEQwFMDYzMDAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBEaXN0cml0byBGZWRlcmFsMRQwEgYDVQQHDAtDdWF1aHTDqW1vYzEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTUwMwYJKoZIhvcNAQkCDCZSZXNwb25zYWJsZTogQ2xhdWRpYSBDb3ZhcnJ1YmlhcyBPY2hvYTAeFw0xNDA2MTExOTAwNDNaFw0xODA2MTExOTAwNDNaMIHVMSUwIwYDVQQDExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQpExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQKExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQtExxIU0cwOTEwMjZMN0EgLyBNQUFNNDcxMDI1SzQyMR4wHAYDVQQFExUgLyBNQUFNNDcxMDI1SE5FVEJOMDYxFzAVBgNVBAsTDkhPVEVMRVJBIFNBQ09ZMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrgncjOH+NFWtJWiGvqfllBdyCtn/uYyLi5LDzHSEcDw4CrF+wRDIMTdds7jH8ZlZrcYxMeNzJTsypU6NVOWIxH1eKF9+yIyW2mThhCkP+kH2pueCD1Z0lr4D9oAOAxMh0Cy/v9wal3dQVOf2hGjhs6cn3E9Zx1HxhQQ3dmKbxfwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQUFAAOCAQEAxVPQlAzMEvOpIT19qteXXFt635WU/rEv7XQ3JTCm45owu6Rz6e/kYrYTXjSKNNaV+FwXcaE5cb/rpz6LbzXWHiBB6wuY7l0xctznC76SWvPtZHJK4FL88wxwmRWElla78Yeu23f0wrxd9DyrxVfgayepDnIAxnR+b0UaHVzq00mtOlQrVNwDXg0sXjKm3x06y0S+SeKUDUv7JRAD/ZDZ/ZyOomTEDrUbRgQehbkz4v6lbPmFhT7s7s5xzY15dMBI7kEBzBtscrKBxPDbSfk1kJYUpMI1AyNRWYbmfNuYXyR7HogqjwHAOHMUA6rm0regk1QPKJPzUP2dstprAOyYdQ=="
        comprobante.condicionesDePago = 'Contado'
        comprobante.subTotal = 630.25
        //comprobante.descuento = 0.0
        comprobante.moneda = CMoneda.MXN
        comprobante.total = 750.00
        comprobante.tipoDeComprobante = CTipoDeComprobante.N
        comprobante.metodoPago = CMetodoPago.PUE
        comprobante.lugarExpedicion = '02840'



        /**** Emisor ****/
        Comprobante.Emisor emisor = factory.createComprobanteEmisor()
        emisor.rfc = "HSG091026L7A"
        emisor.nombre = "HOTELERA SACOY GRUP SA DE CV"
        emisor.regimenFiscal = '601'

        comprobante.emisor = emisor

        comprobante.lugarExpedicion

        /** Receptor ***/
        Comprobante.Receptor receptor = factory.createComprobanteReceptor()
        receptor.rfc = "CARR700317575"
        receptor.nombre = "RUBEN CANCINO RAMOS"
        receptor.usoCFDI = CUsoCFDI.G_01 // Adquisicion de mercancías

        comprobante.receptor = receptor

        /** Conceptos ***/
        Comprobante.Conceptos conceptos = factory.createComprobanteConceptos()
        Comprobante.Conceptos.Concepto concepto = factory.createComprobanteConceptosConcepto()
        concepto.with {
            claveProdServ = "01010101" // No existe en el catálogo
            noIdentificacion = "05"
            cantidad = 1.00
            claveUnidad = 'EA'
            unidad = 'Pieza'
            descripcion = "HABITACION JUNIOR SUITE DIA COMPLETO&#xA;CHECK IN 15:00&#xA;CHECK OUT 13:00&#xA;04/04/17-05/04/17"
            valorUnitario = 630.25
            importe = 630.25
        }
        concepto.impuestos = factory.createComprobanteConceptosConceptoImpuestos()
        concepto.impuestos.traslados = factory.createComprobanteConceptosConceptoImpuestosTraslados()
        Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado traslado1 = factory.createComprobanteConceptosConceptoImpuestosTrasladosTraslado()
        traslado1.base =  630.25
        traslado1.impuesto = '002'
        traslado1.tipoFactor = CTipoFactor.TASA
        traslado1.tasaOCuota = '0.160000'
        traslado1.importe = 100.84
        concepto.impuestos.traslados.traslado.add(traslado1)

        conceptos.concepto.add(concepto)
        comprobante.conceptos = conceptos

        /** Impuestos **/

        Comprobante.Impuestos impuestos = factory.createComprobanteImpuestos()
        impuestos.setTotalImpuestosTrasladados(100.84)
        Comprobante.Impuestos.Traslados traslados = factory.createComprobanteImpuestosTraslados()

        Comprobante.Impuestos.Traslados.Traslado traslado = factory.createComprobanteImpuestosTrasladosTraslado()
        traslado.impuesto = '002'
        traslado.tipoFactor = CTipoFactor.TASA
        traslado.tasaOCuota = '0.160000'
        traslado.importe = 100.84
        traslados.traslado.add(traslado)
        impuestos.traslados = traslados
        comprobante.setImpuestos(impuestos)

        INE ine = buildComplemento()

        Comprobante.Complemento complemento = factory.createComprobanteComplemento()
        complemento.any.add(ine)
        comprobante.complemento = complemento
        return comprobante
    }
}
