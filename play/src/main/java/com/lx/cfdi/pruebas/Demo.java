package com.lx.cfdi.pruebas;

import lx.cfdi.v32.Comprobante;
import lx.cfdi.v32.ObjectFactory;

import java.util.List;

/**
 * Created by rcancino on 08/05/17.
 */
public class Demo {

    public void createComprobante(){
        ObjectFactory of = new ObjectFactory();
        Comprobante comprobante = of.createComprobante();
        comprobante.getFecha().toGregorianCalendar().getTime();
        comprobante.getImpuestos().getTotalImpuestosTrasladados();
        comprobante.getReceptor().getDomicilio()  ;
        comprobante.getEmisor().getDomicilioFiscal();
        //comprobante.getEmisor().getRegimenFiscal().get(0).
        //List<Comprobante.Conceptos.Concepto> conceptos = comprobante.getConceptos().getConcepto();
        

    }
}
