package org.jfree.data.xml;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PieDatasetHandler extends RootHandler implements DatasetTags {
   private DefaultPieDataset dataset = null;

   public PieDataset getDataset() {
      return this.dataset;
   }

   public void addItem(Comparable var1, Number var2) {
      this.dataset.setValue(var1, var2);
   }

   public void startElement(String var1, String var2, String var3, Attributes var4) {
      DefaultHandler var5 = this.getCurrentHandler();
      if(var5 != this) {
         var5.startElement(var1, var2, var3, var4);
      } else if(var3.equals("PieDataset")) {
         this.dataset = new DefaultPieDataset();
      } else if(var3.equals("Item")) {
         ItemHandler var6 = new ItemHandler(this, this);
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
