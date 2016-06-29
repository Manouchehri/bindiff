package org.jfree.chart.urls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

public class CustomXYURLGenerator implements Serializable, XYURLGenerator {
   private static final long serialVersionUID = -8565933356596551832L;
   private ArrayList urlSeries = new ArrayList();

   public int getListCount() {
      return this.urlSeries.size();
   }

   public int getURLCount(int var1) {
      int var2 = 0;
      List var3 = (List)this.urlSeries.get(var1);
      if(var3 != null) {
         var2 = var3.size();
      }

      return var2;
   }

   public String getURL(int var1, int var2) {
      String var3 = null;
      if(var1 < this.getListCount()) {
         List var4 = (List)this.urlSeries.get(var1);
         if(var4 != null && var2 < var4.size()) {
            var3 = (String)var4.get(var2);
         }
      }

      return var3;
   }

   public String generateURL(XYDataset var1, int var2, int var3) {
      return this.getURL(var2, var3);
   }

   public void addURLSeries(List var1) {
      this.urlSeries.add(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CustomXYURLGenerator)) {
         return false;
      } else {
         CustomXYURLGenerator var2 = (CustomXYURLGenerator)var1;
         int var3 = this.getListCount();
         if(var3 != var2.getListCount()) {
            return false;
         } else {
            for(int var4 = 0; var4 < var3; ++var4) {
               int var5 = this.getURLCount(var4);
               if(var5 != var2.getURLCount(var4)) {
                  return false;
               }

               for(int var6 = 0; var6 < var5; ++var6) {
                  String var7 = this.getURL(var4, var6);
                  String var8 = var2.getURL(var4, var6);
                  if(var7 != null) {
                     if(!var7.equals(var8)) {
                        return false;
                     }
                  } else if(var8 != null) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }
}
