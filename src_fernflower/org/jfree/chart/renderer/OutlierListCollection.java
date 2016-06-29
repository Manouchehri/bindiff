package org.jfree.chart.renderer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;

public class OutlierListCollection {
   private List outlierLists = new ArrayList();
   private boolean highFarOut = false;
   private boolean lowFarOut = false;

   public boolean isHighFarOut() {
      return this.highFarOut;
   }

   public void setHighFarOut(boolean var1) {
      this.highFarOut = var1;
   }

   public boolean isLowFarOut() {
      return this.lowFarOut;
   }

   public void setLowFarOut(boolean var1) {
      this.lowFarOut = var1;
   }

   public boolean add(Outlier var1) {
      if(this.outlierLists.isEmpty()) {
         return this.outlierLists.add(new OutlierList(var1));
      } else {
         boolean var2 = false;
         Iterator var3 = this.outlierLists.iterator();

         while(var3.hasNext()) {
            OutlierList var4 = (OutlierList)var3.next();
            if(var4.isOverlapped(var1)) {
               var2 = this.updateOutlierList(var4, var1);
            }
         }

         if(!var2) {
            var2 = this.outlierLists.add(new OutlierList(var1));
         }

         return var2;
      }
   }

   public Iterator iterator() {
      return this.outlierLists.iterator();
   }

   private boolean updateOutlierList(OutlierList var1, Outlier var2) {
      boolean var3 = false;
      var3 = var1.add(var2);
      var1.updateAveragedOutlier();
      var1.setMultiple(true);
      return var3;
   }
}
