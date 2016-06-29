package com.google.security.zynamics.zylib.gui.license;

import java.util.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;

public final class CLicenseFile
{
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String CUSTOMER_COMPANY = "CustomerCompany";
    public static final String PURCHASE_DATE = "PurchaseDate";
    public static final String EXPIRY_DATE = "SupportExpiryDate";
    public static final String DOCUMENT_ELEMENT = "License";
    private final LinkedHashMap m_values;
    
    public CLicenseFile(final LinkedHashMap values) {
        this.m_values = values;
    }
    
    private static boolean verifyValues(final LinkedHashMap linkedHashMap) {
        return linkedHashMap.containsKey("CustomerName") && linkedHashMap.containsKey("PurchaseDate") && linkedHashMap.containsKey("SupportExpiryDate");
    }
    
    public static CLicenseFile parse(final String s) {
        final CLicenseFile$CLicenseFileReader cLicenseFile$CLicenseFileReader = new CLicenseFile$CLicenseFileReader(null);
        final SAXParserFactory instance = SAXParserFactory.newInstance();
        try {
            instance.setFeature("http://apache.org/xml/features/continue-after-fatal-error", true);
            instance.newSAXParser().parse(s, cLicenseFile$CLicenseFileReader);
        }
        catch (ParserConfigurationException ex2) {}
        catch (SAXException ex) {
            final String s2 = "Malformed license file: ";
            final String value = String.valueOf(ex.getMessage());
            throw new CLicenseFileException((value.length() != 0) ? s2.concat(value) : new String(s2));
        }
        catch (IOException ex3) {
            final String s3 = "License file could not be found: ";
            final String value2 = String.valueOf(s);
            throw new CLicenseFileException((value2.length() != 0) ? s3.concat(value2) : new String(s3));
        }
        if (!verifyValues(cLicenseFile$CLicenseFileReader.m_values)) {
            throw new CLicenseFileException("Incomplete license file");
        }
        return new CLicenseFile(cLicenseFile$CLicenseFileReader.m_values);
    }
    
    public String getValue(final String s) {
        return this.m_values.get(s);
    }
}
