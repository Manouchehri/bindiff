package org.jfree.chart.labels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class CustomXYToolTipGenerator implements Serializable, Cloneable, XYToolTipGenerator, PublicCloneable {
   private static final long serialVersionUID = 8636030004670141362L;
   private List toolTipSeries = new ArrayList();

   public int getListCount() {
      return this.toolTipSeries.size();
   }

   public int getToolTipCount(int var1) {
      int var2 = 0;
      List var3 = (List)this.toolTipSeries.get(var1);
      if(var3 != null) {
         var2 = var3.size();
      }

      return var2;
   }

   public String getToolTipText(int var1, int var2) {
      String var3 = null;
      if(var1 < this.getListCount()) {
         List var4 = (List)this.toolTipSeries.get(var1);
         if(var4 != null && var2 < var4.size()) {
            var3 = (String)var4.get(var2);
         }
      }

      return var3;
   }

   public void addToolTipSeries(List var1) {
      this.toolTipSeries.add(var1);
   }

   public String generateToolTip(XYDataset var1, int var2, int var3) {
      return this.getToolTipText(var2, var3);
   }

   public Object clone() {
      CustomXYToolTipGenerator var1 = (CustomXYToolTipGenerator)super.clone();
      if(this.toolTipSeries != null) {
         var1.toolTipSeries = new ArrayList(this.toolTipSeries);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CustomXYToolTipGenerator)) {
         return false;
      } else {
         CustomXYToolTipGenerator var2 = (CustomXYToolTipGenerator)var1;
         boolean var3 = true;

         for(int var4 = 0; var4 < this.getListCount(); ++var4) {
            for(int var5 = 0; var5 < this.getToolTipCount(var4); ++var5) {
               String var6 = this.getToolTipText(var4, var5);
               String var7 = var2.getToolTipText(var4, var5);
               if(var6 != null) {
                  var3 = var3 && var6.equals(var7);
               } else {
                  var3 = var3 && var7 == null;
               }
            }
         }

         return var3;
      }
   }
}
