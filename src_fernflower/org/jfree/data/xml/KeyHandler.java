package org.jfree.data.xml;

import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.jfree.data.xml.ValueHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class KeyHandler extends DefaultHandler implements DatasetTags {
   private RootHandler rootHandler;
   private ItemHandler itemHandler;
   private StringBuffer currentText;

   public KeyHandler(RootHandler var1, ItemHandler var2) {
      this.rootHandler = var1;
      this.itemHandler = var2;
      this.currentText = new StringBuffer();
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      if(var3.equals("Key")) {
         this.clearCurrentText();
      } else {
         throw new SAXException("Expecting <Key> but found " + var3);
      }
   }

   public void endElement(String var1, String var2, String var3) {
      if(var3.equals("Key")) {
         this.itemHandler.setKey(this.getCurrentText());
         this.rootHandler.popSubHandler();
         this.rootHandler.pushSubHandler(new ValueHandler(this.rootHandler, this.itemHandler));
      } else {
         throw new SAXException("Expecting </Key> but found " + var3);
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
