package com.google.security.zynamics.zylib.gui.license;

import org.xml.sax.helpers.*;
import java.util.*;
import org.xml.sax.*;

class CLicenseFile$CLicenseFileReader extends DefaultHandler
{
    private final LinkedHashMap m_values;
    private String m_content;
    private boolean ignoreFromHere;
    
    private CLicenseFile$CLicenseFileReader() {
        this.m_values = new LinkedHashMap();
        this.m_content = "";
        this.ignoreFromHere = false;
    }
    
    @Override
    public void characters(final char[] array, final int n, final int n2) {
        final String value = String.valueOf(this.m_content);
        final String value2 = String.valueOf(new String(array, n, n2));
        this.m_content = ((value2.length() != 0) ? value.concat(value2) : new String(value));
    }
    
    @Override
    public void endElement(final String s, final String s2, final String s3) {
        this.ignoreFromHere = s3.equals("License");
        if (this.ignoreFromHere || this.m_content.isEmpty()) {
            return;
        }
        this.m_values.put(s3, this.m_content);
        this.m_content = "";
    }
    
    @Override
    public void fatalError(final SAXParseException ex) {
        if (!this.ignoreFromHere) {
            throw ex;
        }
    }
    
    @Override
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        this.m_content = "";
    }
}
