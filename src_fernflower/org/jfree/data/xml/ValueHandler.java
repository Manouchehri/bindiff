package org.jfree.data.xml;

import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ValueHandler extends DefaultHandler implements DatasetTags {
   private RootHandler rootHandler;
   private ItemHandler itemHandler;
   private StringBuffer currentText;

   public ValueHandler(RootHandler var1, ItemHandler var2) {
      this.rootHandler = var1;
      this.itemHandler = var2;
      this.currentText = new StringBuffer();
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      if(var3.equals("Value")) {
         this.clearCurrentText();
      } else {
         throw new SAXException("Expecting <Value> but found " + var3);
      }
   }

   public void endElement(String var1, String var2, String var3) {
      if(var3.equals("Value")) {
         Double var4;
         try {
            var4 = Double.valueOf(this.currentText.toString());
            if(((Double)var4).isNaN()) {
               var4 = null;
            }
         } catch (NumberFormatException var6) {
            var4 = null;
         }

         this.itemHandler.setValue(var4);
         this.rootHandler.popSubHandler();
      } else {
         throw new SAXException("Expecting </Value> but found " + var3);
      }
   }

   public void characters(char[] var1, int var2, int var3) {
      if(this.currentText != null) {
         this.currentText.append(String.copyValueOf(var1, var2, var3));
      }

   }

   protected String getCurrentText() {
      return this.currentText.toString();
   }

   protected void clearCurrentText() {
      this.currentText.delete(0, this.currentText.length());
   }
}
