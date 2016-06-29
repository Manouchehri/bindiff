package org.jfree.chart.urls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.PublicCloneable;

public class CustomPieURLGenerator implements Serializable, Cloneable, PieURLGenerator, PublicCloneable {
   private static final long serialVersionUID = 7100607670144900503L;
   private ArrayList urls = new ArrayList();

   public String generateURL(PieDataset var1, Comparable var2, int var3) {
      return this.getURL(var2, var3);
   }

   public int getListCount() {
      return this.urls.size();
   }

   public int getURLCount(int var1) {
      int var2 = 0;
      Map var3 = (Map)this.urls.get(var1);
      if(var3 != null) {
         var2 = var3.size();
      }

      return var2;
   }

   public String getURL(Comparable var1, int var2) {
      String var3 = null;
      if(var2 < this.getListCount()) {
         Map var4 = (Map)this.urls.get(var2);
         if(var4 != null) {
            var3 = (String)var4.get(var1);
         }
      }

      return var3;
   }

   public void addURLs(Map var1) {
      this.urls.add(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CustomPieURLGenerator)) {
         return false;
      } else {
         CustomPieURLGenerator var2 = (CustomPieURLGenerator)var1;
         if(this.getListCount() != var2.getListCount()) {
            return false;
         } else {
            for(int var4 = 0; var4 < this.getListCount(); ++var4) {
               if(this.getURLCount(var4) != var2.getURLCount(var4)) {
                  return false;
               }

               Set var3 = ((HashMap)this.urls.get(var4)).keySet();
               Iterator var6 = var3.iterator();

               while(var6.hasNext()) {
                  String var5 = (String)var6.next();
                  if(!this.getURL(var5, var4).equals(var2.getURL(var5, var4))) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   public Object clone() {
      CustomPieURLGenerator var1 = new CustomPieURLGenerator();

      HashMap var3;
      for(Iterator var5 = this.urls.iterator(); var5.hasNext(); var3 = null) {
         Map var2 = (Map)var5.next();
         var3 = new HashMap();
         Iterator var6 = var2.keySet().iterator();

         while(var6.hasNext()) {
            String var4 = (String)var6.next();
            var3.put(var4, var2.get(var4));
         }

         var1.addURLs(var3);
      }

      return var1;
   }
}
