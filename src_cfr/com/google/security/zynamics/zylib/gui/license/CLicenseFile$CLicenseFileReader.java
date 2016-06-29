/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.license.CLicenseFile$1;
import java.util.LinkedHashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

class CLicenseFile$CLicenseFileReader
extends DefaultHandler {
    private final LinkedHashMap m_values = new LinkedHashMap();
    private String m_content = "";
    private boolean ignoreFromHere = false;

    private CLicenseFile$CLicenseFileReader() {
    }

    @Override
    public void characters(char[] arrc, int n2, int n3) {
        String string = String.valueOf(this.m_content);
        String string2 = String.valueOf(new String(arrc, n2, n3));
        this.m_content = string2.length() != 0 ? string.concat(string2) : new String(string);
    }

    @Override
    public void endElement(String string, String string2, String string3) {
        this.ignoreFromHere = string3.equals("License");
        if (this.ignoreFromHere) return;
        if (this.m_content.isEmpty()) {
            return;
        }
        this.m_values.put(string3, this.m_content);
        this.m_content = "";
    }

    @Override
    public void fatalError(SAXParseException sAXParseException) {
        if (this.ignoreFromHere) return;
        throw sAXParseException;
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        this.m_content = "";
    }

    /* synthetic */ CLicenseFile$CLicenseFileReader(CLicenseFile$1 cLicenseFile$1) {
        this();
    }

    static /* synthetic */ LinkedHashMap access$100(CLicenseFile$CLicenseFileReader cLicenseFile$CLicenseFileReader) {
        return cLicenseFile$CLicenseFileReader.m_values;
    }
}

