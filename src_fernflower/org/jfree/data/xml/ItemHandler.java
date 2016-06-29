package org.jfree.data.xml;

import org.jfree.data.xml.CategorySeriesHandler;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.KeyHandler;
import org.jfree.data.xml.PieDatasetHandler;
import org.jfree.data.xml.RootHandler;
import org.jfree.data.xml.ValueHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ItemHandler extends DefaultHandler implements DatasetTags {
   private RootHandler root;
   private DefaultHandler parent;
   private Comparable key;
   private Number value;

   public ItemHandler(RootHandler var1, DefaultHandler var2) {
      this.root = var1;
      this.parent = var2;
      this.key = null;
      this.value = null;
   }

   public Comparable getKey() {
      return this.key;
   }

   public void setKey(Comparable var1) {
      this.key = var1;
   }

   public Number getValue() {
      return this.value;
   }

   public void setValue(Number var1) {
      this.value = var1;
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      if(var3.equals("Item")) {
         KeyHandler var5 = new KeyHandler(this.root, this);
         this.root.pushSubHandler(var5);
      } else {
         if(!var3.equals("Value")) {
            throw new SAXException("Expected <Item> or <Value>...found " + var3);
         }

         ValueHandler var6 = new ValueHandler(this.root, this);
         this.root.pushSubHandler(var6);
      }

   }

   public void endElement(String var1, String var2, String var3) {
      if(this.parent instanceof PieDatasetHandler) {
         PieDatasetHandler var4 = (PieDatasetHandler)this.parent;
         var4.addItem(this.key, this.value);
         this.root.popSubHandler();
      } else if(this.parent instanceof CategorySeriesHandler) {
         CategorySeriesHandler var5 = (CategorySeriesHandler)this.parent;
         var5.addItem(this.key, this.value);
         this.root.popSubHandler();
      }

   }
}
