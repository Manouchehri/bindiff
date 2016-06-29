package com.google.security.zynamics.bindiff.io.matches;

import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import org.xml.sax.Attributes;

public abstract class AbstractXmlHandler {
   private String value = "";

   protected String getValue() {
      return this.value;
   }

   protected void setValue(String var1) {
      this.value = var1;
   }

   abstract void endElement(String var1);

   abstract void startElement(String var1, Attributes var2);

   public abstract IReadXmlHandlerData getReadData();
}
