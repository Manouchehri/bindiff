/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io;

import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import com.google.security.zynamics.bindiff.io.matches.ManagingHandler;
import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SocketXmlReader {
    public static IReadXmlHandlerData readXMLData(InputStream inputStream) {
        try {
            XMLReader xMLReader = XMLReaderFactory.createXMLReader();
            ManagingHandler managingHandler = new ManagingHandler();
            xMLReader.setContentHandler(managingHandler);
            xMLReader.setErrorHandler(managingHandler);
            xMLReader.parse(new InputSource(inputStream));
            return managingHandler.getReadData();
        }
        catch (SAXException var1_2) {
            String string;
            String string2 = String.valueOf(var1_2.getMessage());
            if (string2.length() != 0) {
                string = "'Visual diff failed. Error while parsing socket stream data: ".concat(string2);
                throw new IOException(string);
            }
            string = new String("'Visual diff failed. Error while parsing socket stream data: ");
            throw new IOException(string);
        }
        catch (IOException var1_3) {
            String string;
            String string3 = String.valueOf(var1_3.getMessage());
            if (string3.length() != 0) {
                string = "Visual diff failed. Couldn't read socket stream data: ".concat(string3);
                throw new IOException(string);
            }
            string = new String("Visual diff failed. Couldn't read socket stream data: ");
            throw new IOException(string);
        }
    }
}

