package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class MultipleXYSeriesLabelGenerator implements Serializable, Cloneable, XYSeriesLabelGenerator, PublicCloneable {
   private static final long serialVersionUID = 138976236941898560L;
   public static final String DEFAULT_LABEL_FORMAT = "{0}";
   private String formatPattern;
   private String additionalFormatPattern;
   private Map seriesLabelLists;

   public MultipleXYSeriesLabelGenerator() {
      this("{0}");
   }

   public MultipleXYSeriesLabelGenerator(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'format\' argument.");
      } else {
         this.formatPattern = var1;
         this.additionalFormatPattern = "\n{0}";
         this.seriesLabelLists = new HashMap();
      }
   }

   public void addSeriesLabel(int var1, String var2) {
      Integer var3 = new Integer(var1);
      Object var4 = (List)this.seriesLabelLists.get(var3);
      if(var4 == null) {
         var4 = new ArrayList();
         this.seriesLabelLists.put(var3, var4);
      }

      ((List)var4).add(var2);
   }

   public void clearSeriesLabels(int var1) {
      Integer var2 = new Integer(var1);
      this.seriesLabelLists.put(var2, (Object)null);
   }

   public String generateLabel(XYDataset var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         StringBuffer var3 = new StringBuffer();
         var3.append(MessageFormat.format(this.formatPattern, this.createItemArray(var1, var2)));
         Integer var4 = new Integer(var2);
         List var5 = (List)this.seriesLabelLists.get(var4);
         if(var5 != null) {
            Object[] var6 = new Object[1];

            for(int var7 = 0; var7 < var5.size(); ++var7) {
               var6[0] = var5.get(var7);
               String var8 = MessageFormat.format(this.additionalFormatPattern, var6);
               var3.append(var8);
            }
         }

         return var3.toString();
      }
   }

   protected Object[] createItemArray(XYDataset var1, int var2) {
      Object[] var3 = new Object[]{var1.getSeriesKey(var2).toString()};
      return var3;
   }

   public Object clone() {
      MultipleXYSeriesLabelGenerator var1 = (MultipleXYSeriesLabelGenerator)super.clone();
      var1.seriesLabelLists = new HashMap();
      Set var2 = this.seriesLabelLists.keySet();

      Object var4;
      Object var6;
      for(Iterator var3 = var2.iterator(); var3.hasNext(); var1.seriesLabelLists.put(var4, var6)) {
         var4 = var3.next();
         Object var5 = this.seriesLabelLists.get(var4);
         var6 = var5;
         if(var5 instanceof PublicCloneable) {
            PublicCloneable var7 = (PublicCloneable)var5;
            var6 = var7.clone();
         }
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MultipleXYSeriesLabelGenerator)) {
         return false;
      } else {
         MultipleXYSeriesLabelGenerator var2 = (MultipleXYSeriesLabelGenerator)var1;
         return !this.formatPattern.equals(var2.formatPattern)?false:(!this.additionalFormatPattern.equals(var2.additionalFormatPattern)?false:this.seriesLabelLists.equals(var2.seriesLabelLists));
      }
   }
}
