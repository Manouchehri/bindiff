package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.license.CLicenseFile$1;
import java.util.LinkedHashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

class CLicenseFile$CLicenseFileReader extends DefaultHandler {
   private final LinkedHashMap m_values;
   private String m_content;
   private boolean ignoreFromHere;

   private CLicenseFile$CLicenseFileReader() {
      this.m_values = new LinkedHashMap();
      this.m_content = "";
      this.ignoreFromHere = false;
   }

   public void characters(char[] var1, int var2, int var3) {
      // $FF: Couldn't be decompiled
   }

   public void endElement(String var1, String var2, String var3) {
      this.ignoreFromHere = var3.equals("License");
      if(!this.ignoreFromHere && !this.m_content.isEmpty()) {
         this.m_values.put(var3, this.m_content);
         this.m_content = "";
      }
   }

   public void fatalError(SAXParseException var1) {
      if(!this.ignoreFromHere) {
         throw var1;
      }
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      this.m_content = "";
   }

   // $FF: synthetic method
   CLicenseFile$CLicenseFileReader(CLicenseFile$1 var1) {
      this();
   }

   // $FF: synthetic method
   static LinkedHashMap access$100(CLicenseFile$CLicenseFileReader var0) {
      return var0.m_values;
   }
}
