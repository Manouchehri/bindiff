package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.license.CLicenseFile$1;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile$CLicenseFileReader;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileException;
import java.util.LinkedHashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public final class CLicenseFile {
   public static final String CUSTOMER_NAME = "CustomerName";
   public static final String CUSTOMER_COMPANY = "CustomerCompany";
   public static final String PURCHASE_DATE = "PurchaseDate";
   public static final String EXPIRY_DATE = "SupportExpiryDate";
   public static final String DOCUMENT_ELEMENT = "License";
   private final LinkedHashMap m_values;

   public CLicenseFile(LinkedHashMap var1) {
      this.m_values = var1;
   }

   private static boolean verifyValues(LinkedHashMap var0) {
      return var0.containsKey("CustomerName") && var0.containsKey("PurchaseDate") && var0.containsKey("SupportExpiryDate");
   }

   public static CLicenseFile parse(String var0) {
      // $FF: Couldn't be decompiled
   }

   public String getValue(String var1) {
      return (String)this.m_values.get(var1);
   }
}
