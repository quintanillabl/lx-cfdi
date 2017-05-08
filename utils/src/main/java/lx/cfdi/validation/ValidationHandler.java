package lx.cfdi.validation;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/**
 * Created by rcancino on 02/08/16.
 */
public class ValidationHandler implements ValidationEventHandler{

    public boolean handleEvent(ValidationEvent event) {
        System.out.println("\nEVENT");
        System.out.println("SEVERITY:  " + event.getSeverity());
        System.out.println("MESSAGE:  " + event.getMessage());
        System.out.println("LOCATOR");
        System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
        System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
        System.out.println("    OFFSET:  " + event.getLocator().getOffset());
        System.out.println("    OBJECT:  " + event.getLocator().getObject());
        System.out.println("    NODE:  " + event.getLocator().getNode());
        System.out.println("    URL:  " + event.getLocator().getURL());
        return false;
    }
}
