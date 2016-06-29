package org.jfree.data.xml;

import java.util.Iterator;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.xml.CategoryDatasetHandler;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CategorySeriesHandler extends DefaultHandler implements DatasetTags {
   private RootHandler root;
   private Comparable seriesKey;
   private DefaultKeyedValues values;

   public CategorySeriesHandler(RootHandler var1) {
      this.root = var1;
      this.values = new DefaultKeyedValues();
   }

   public void setSeriesKey(Comparable var1) {
      this.seriesKey = var1;
   }

   public void addItem(Comparable var1, Number var2) {
      this.values.addValue(var1, var2);
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      ItemHandler var5;
      if(var3.equals("Series")) {
         this.setSeriesKey(var4.getValue("name"));
         var5 = new ItemHandler(this.root, this);
         this.root.pushSubHandler(var5);
      } else {
         if(!var3.equals("Item")) {
            throw new SAXException("Expecting <Series> or <Item> tag...found " + var3);
         }

         var5 = new ItemHandler(this.root, this);
         this.root.pushSubHandler(var5);
         var5.startElement(var1, var2, var3, var4);
      }

   }

   public void endElement(String var1, String var2, String var3) {
      if(this.root instanceof CategoryDatasetHandler) {
         CategoryDatasetHandler var4 = (CategoryDatasetHandler)this.root;
         Iterator var5 = this.values.getKeys().iterator();

         while(var5.hasNext()) {
            Comparable var6 = (Comparable)var5.next();
            Number var7 = this.values.getValue(var6);
            var4.addItem(this.seriesKey, var6, var7);
         }

         this.root.popSubHandler();
      }

   }
}
