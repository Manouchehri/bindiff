package com.google.security.zynamics.bindiff.io;

import org.xml.sax.helpers.*;
import com.google.security.zynamics.bindiff.io.matches.*;
import java.io.*;
import org.xml.sax.*;

public class SocketXmlReader
{
    public static IReadXmlHandlerData readXMLData(final InputStream inputStream) {
        try {
            final XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            final ManagingHandler managingHandler = new ManagingHandler();
            xmlReader.setContentHandler(managingHandler);
            xmlReader.setErrorHandler(managingHandler);
            xmlReader.parse(new InputSource(inputStream));
            return managingHandler.getReadData();
        }
        catch (SAXException ex) {
            final String s = "'Visual diff failed. Error while parsing socket stream data: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        catch (IOException ex2) {
            final String s2 = "Visual diff failed. Couldn't read socket stream data: ";
            final String value2 = String.valueOf(ex2.getMessage());
            throw new IOException((value2.length() != 0) ? s2.concat(value2) : new String(s2));
        }
    }
}
