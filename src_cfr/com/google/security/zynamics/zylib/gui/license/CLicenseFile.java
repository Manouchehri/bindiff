/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.license.CLicenseFile$1;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile$CLicenseFileReader;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileException;
import java.io.IOException;
import java.util.LinkedHashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class CLicenseFile {
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String CUSTOMER_COMPANY = "CustomerCompany";
    public static final String PURCHASE_DATE = "PurchaseDate";
    public static final String EXPIRY_DATE = "SupportExpiryDate";
    public static final String DOCUMENT_ELEMENT = "License";
    private final LinkedHashMap m_values;

    public CLicenseFile(LinkedHashMap linkedHashMap) {
        this.m_values = linkedHashMap;
    }

    private static boolean verifyValues(LinkedHashMap linkedHashMap) {
        if (!linkedHashMap.containsKey("CustomerName")) return false;
        if (!linkedHashMap.containsKey("PurchaseDate")) return false;
        if (!linkedHashMap.containsKey("SupportExpiryDate")) return false;
        return true;
    }

    public static CLicenseFile parse(String string) {
        CLicenseFile$CLicenseFileReader cLicenseFile$CLicenseFileReader = new CLicenseFile$CLicenseFileReader(null);
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        try {
            sAXParserFactory.setFeature("http://apache.org/xml/features/continue-after-fatal-error", true);
            SAXParser sAXParser = sAXParserFactory.newSAXParser();
            sAXParser.parse(string, (DefaultHandler)cLicenseFile$CLicenseFileReader);
        }
        catch (ParserConfigurationException var3_4) {
        }
        catch (SAXException var3_5) {
            String string2;
            String string3 = String.valueOf(var3_5.getMessage());
            if (string3.length() != 0) {
                string2 = "Malformed license file: ".concat(string3);
                throw new CLicenseFileException(string2);
            }
            string2 = new String("Malformed license file: ");
            throw new CLicenseFileException(string2);
        }
        catch (IOException var3_6) {
            String string4;
            String string5 = String.valueOf(string);
            if (string5.length() != 0) {
                string4 = "License file could not be found: ".concat(string5);
                throw new CLicenseFileException(string4);
            }
            string4 = new String("License file could not be found: ");
            throw new CLicenseFileException(string4);
        }
        if (CLicenseFile.verifyValues(CLicenseFile$CLicenseFileReader.access$100(cLicenseFile$CLicenseFileReader))) return new CLicenseFile(CLicenseFile$CLicenseFileReader.access$100(cLicenseFile$CLicenseFileReader));
        throw new CLicenseFileException("Incomplete license file");
    }

    public String getValue(String string) {
        return (String)this.m_values.get(string);
    }
}

