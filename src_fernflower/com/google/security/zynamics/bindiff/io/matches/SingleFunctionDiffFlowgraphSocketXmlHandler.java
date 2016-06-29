package com.google.security.zynamics.bindiff.io.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.AbstractXmlHandler;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import org.xml.sax.Attributes;

public class SingleFunctionDiffFlowgraphSocketXmlHandler extends AbstractXmlHandler {
   private static String DATABASE = "Database";
   private static String PRIMARY = "Primary";
   private static String SECONDARY = "Secondary";
   private static String PATH = "path";
   private static String OFFSET = "offset";
   private final FunctionDiffSocketXmlData recievedData = new FunctionDiffSocketXmlData();

   void endElement(String var1) {
   }

   void startElement(String var1, Attributes var2) {
      if(var1.equals(DATABASE)) {
         this.recievedData.setMatchesDBPath(var2.getValue(PATH));
      } else if(var1.equals(PRIMARY)) {
         this.recievedData.setFlowgraphsPath(var2.getValue(PATH), ESide.PRIMARY);
         this.recievedData.setFlowgraphOffset(Integer.valueOf(var2.getValue(OFFSET)).intValue(), ESide.PRIMARY);
      } else if(var1.equals(SECONDARY)) {
         this.recievedData.setFlowgraphsPath(var2.getValue(PATH), ESide.SECONDARY);
         this.recievedData.setFlowgraphOffset(Integer.valueOf(var2.getValue(OFFSET)).intValue(), ESide.SECONDARY);
      }

   }

   public FunctionDiffSocketXmlData getReadData() {
      return this.recievedData;
   }
}
