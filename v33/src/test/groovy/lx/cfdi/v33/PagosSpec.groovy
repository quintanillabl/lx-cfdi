package lx.cfdi.v33

import groovy.util.slurpersupport.GPathResult
import groovy.xml.XmlUtil
import lx.cfdi.utils.DateUtils
import lx.cfdi.v33.pagos.PagosUtils
import spock.lang.Specification

import javax.xml.bind.MarshalException

/**
 * Created by rcancino on 20/06/17.
 */
class PagosSpec extends Specification{

    ObjectFactory factory

    def setup(){
        factory = new ObjectFactory()
    }

    def 'Generar un cfdi tipo P valido'(){

        given: 'Una cfdi valido'
        Comprobante comprobante = buildComprobanteValido()

        and: 'Un StringWriter'
        StringWriter writer = new StringWriter()

        when: 'Salvamos el comprobante  a un StringWriter'
        //CfdiUtils.marshall(comprobante,writer)
        PagosUtils.getMarshaller(true,null)
        .marshal(comprobante, writer)

        then: 'Obtenemos el comprobante  en XML'
        notThrown(MarshalException)
        GPathResult res = new XmlSlurper().parse(new ByteArrayInputStream(writer.toString().bytes))
        'Comprobante' == res.name()
        println XmlUtil.serialize(res)
    }



    def buildComprobanteValido(){
        Comprobante comprobante = factory.createComprobante()
        comprobante.tipoDeComprobante = CTipoDeComprobante.I
        comprobante.version = "3.3"
        comprobante.serie = 'CFDI'
        comprobante.folio = '1'
        comprobante.fecha = DateUtils.getCfdiDate(new Date())
        comprobante.sello = "C2uRW/hW6cBqlWQftRIXtLTl312NO6tzDpRiR5uw46sY8xdvcayErk2XGfjdyiff6D9BaB+LhwMf1WTf2MaCjgUlgPLgfyLNsx6MD45+rR1MVV7CzbWVEUAVEh7yKL7zskk9iKBhip5gbbkaYoc2mnPRhx0hq4mqtkgH/a3/abY="
        comprobante.setNoCertificado('00001000000304410871')
        comprobante.certificado = "MIIEiTCCA3GgAwIBAgIUMDAwMDEwMDAwMDAzMDQ0MTA4NzEwDQYJKoZIhvcNAQEFBQAwggGKMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMR8wHQYJKoZIhvcNAQkBFhBhY29kc0BzYXQuZ29iLm14MSYwJAYDVQQJDB1Bdi4gSGlkYWxnbyA3NywgQ29sLiBHdWVycmVybzEOMAwGA1UEEQwFMDYzMDAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBEaXN0cml0byBGZWRlcmFsMRQwEgYDVQQHDAtDdWF1aHTDqW1vYzEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTUwMwYJKoZIhvcNAQkCDCZSZXNwb25zYWJsZTogQ2xhdWRpYSBDb3ZhcnJ1YmlhcyBPY2hvYTAeFw0xNDA2MTExOTAwNDNaFw0xODA2MTExOTAwNDNaMIHVMSUwIwYDVQQDExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQpExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQKExxIT1RFTEVSQSBTQUNPWSBHUlVQIFNBIERFIENWMSUwIwYDVQQtExxIU0cwOTEwMjZMN0EgLyBNQUFNNDcxMDI1SzQyMR4wHAYDVQQFExUgLyBNQUFNNDcxMDI1SE5FVEJOMDYxFzAVBgNVBAsTDkhPVEVMRVJBIFNBQ09ZMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrgncjOH+NFWtJWiGvqfllBdyCtn/uYyLi5LDzHSEcDw4CrF+wRDIMTdds7jH8ZlZrcYxMeNzJTsypU6NVOWIxH1eKF9+yIyW2mThhCkP+kH2pueCD1Z0lr4D9oAOAxMh0Cy/v9wal3dQVOf2hGjhs6cn3E9Zx1HxhQQ3dmKbxfwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQUFAAOCAQEAxVPQlAzMEvOpIT19qteXXFt635WU/rEv7XQ3JTCm45owu6Rz6e/kYrYTXjSKNNaV+FwXcaE5cb/rpz6LbzXWHiBB6wuY7l0xctznC76SWvPtZHJK4FL88wxwmRWElla78Yeu23f0wrxd9DyrxVfgayepDnIAxnR+b0UaHVzq00mtOlQrVNwDXg0sXjKm3x06y0S+SeKUDUv7JRAD/ZDZ/ZyOomTEDrUbRgQehbkz4v6lbPmFhT7s7s5xzY15dMBI7kEBzBtscrKBxPDbSfk1kJYUpMI1AyNRWYbmfNuYXyR7HogqjwHAOHMUA6rm0regk1QPKJPzUP2dstprAOyYdQ=="
        comprobante.subTotal = 0
        comprobante.moneda = CMoneda.XXX
        comprobante.total = 0
        comprobante.lugarExpedicion = '02840'

        /**** Emisor ****/
        Comprobante.Emisor emisor = factory.createComprobanteEmisor()
        emisor.rfc = "HSG091026L7A"
        emisor.nombre = "HOTELERA SACOY GRUP SA DE CV"
        emisor.regimenFiscal = '601'
        comprobante.emisor = emisor

        /** Receptor ***/
        Comprobante.Receptor receptor = factory.createComprobanteReceptor()
        receptor.rfc = "CARR700317575"
        receptor.nombre = "RUBEN CANCINO RAMOS"
        receptor.usoCFDI = CUsoCFDI.P_01
        comprobante.receptor = receptor

        /** Conceptos ***/
        Comprobante.Conceptos conceptos = factory.createComprobanteConceptos()
        Comprobante.Conceptos.Concepto concepto = factory.createComprobanteConceptosConcepto()
        concepto.with {
            claveProdServ = "84111506" // Valor fijo
            cantidad = 1
            claveUnidad = 'ACT'
            descripcion = "Pago"
            valorUnitario = 0
            importe = 0
        }
        conceptos.concepto.add(concepto)
        comprobante.conceptos = conceptos

        Comprobante.Complemento complemento = factory.createComprobanteComplemento()

        Pagos pagos = factory.createPagos()
        pagos.version = '1.0'
        // Primer pago
        Pagos.Pago pago = factory.createPagosPago()
        pago.fechaPago =  DateUtils.getCfdiDate(new Date() + 1)
        pago.formaDePagoP = '04'
        pago.monedaP = CMoneda.MXN
        pago.monto = 1160.00
        pago.numOperacion = '533345'
        Pagos.Pago.DoctoRelacionado docto = factory.createPagosPagoDoctoRelacionado()
        docto.idDocumento = '6E9122AA-7E57-49F4-A5D0-417ED2583A9C'
        docto.serie = 'CFDI'
        docto.folio = '01'
        docto.monedaDR = CMoneda.MXN
        docto.metodoDePagoDR = CMetodoPago.PPD
        docto.numParcialidad = 1
        docto.impSaldoAnt = 11160.00
        //docto.impPagado = 11160.00 // Obligatorio cuando hay mas de un documento relacionado
        docto.impSaldoInsoluto = docto.impSaldoAnt - pago.monto

        pagos.pago.add(pago)
        

        complemento.any.add(pagos)
        comprobante.complemento = complemento
        return comprobante
    }
}
