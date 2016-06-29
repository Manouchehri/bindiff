package com.google.security.zynamics.bindiff.io.matches;

import com.google.common.base.CharMatcher;
import com.google.security.zynamics.bindiff.io.matches.AbstractXmlHandler;
import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import com.google.security.zynamics.bindiff.io.matches.SingleFunctionDiffFlowgraphSocketXmlHandler;
import java.util.Arrays;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class ManagingHandler extends DefaultHandler {
   private static final String ELEMENT_TYPE = "Type";
   private static final String ATTRIBUTE_VALUE = "value";
   private static final String TYPE_VALUE_FLOWGRAPH = "flowgraph";
   private final Stack router = new Stack();
   private final SingleFunctionDiffFlowgraphSocketXmlHandler flowgraphHander = new SingleFunctionDiffFlowgraphSocketXmlHandler();

   public void characters(char[] var1, int var2, int var3) {
      if(!this.router.isEmpty()) {
         String var4 = new String(Arrays.copyOfRange(var1, var2, var2 + var3));
         var4 = CharMatcher.anyOf("\\\"\n\r\t").removeFrom(var4);
         AbstractXmlHandler var5 = (AbstractXmlHandler)this.router.peek();
         var5.setValue(var4);
      }
   }

   public void endDocument() {
   }

   public void endElement(String var1, String var2, String var3) {
   }

   public IReadXmlHandlerData getReadData() {
      return ((AbstractXmlHandler)this.router.peek()).getReadData();
   }

   public void startDocument() {
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      if(var2.equals("Type")) {
         if(var4.getValue("value").equals("flowgraph")) {
            this.router.push(this.flowgraphHander);
         }
      } else if(this.router.size() > 0) {
         ((AbstractXmlHandler)this.router.peek()).startElement(var2, var4);
      }

   }
}
