package org.jfree.data.xml;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xml.CategorySeriesHandler;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CategoryDatasetHandler extends RootHandler implements DatasetTags {
   private DefaultCategoryDataset dataset = null;

   public CategoryDataset getDataset() {
      return this.dataset;
   }

   public void addItem(Comparable var1, Comparable var2, Number var3) {
      this.dataset.addValue(var3, var1, var2);
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      DefaultHandler var5 = this.getCurrentHandler();
      if(var5 != this) {
         var5.startElement(var1, var2, var3, var4);
      } else if(var3.equals("CategoryDataset")) {
         this.dataset = new DefaultCategoryDataset();
      } else {
         if(!var3.equals("Series")) {
            throw new SAXException("Element not recognised: " + var3);
         }

         CategorySeriesHandler var6 = new CategorySeriesHandler(this);
         this.getSubHandlers().push(var6);
         var6.startElement(var1, var2, var3, var4);
      }

   }

   public void endElement(String var1, String var2, String var3) {
      DefaultHandler var4 = this.getCurrentHandler();
      if(var4 != this) {
         var4.endElement(var1, var2, var3);
      }

   }
}
