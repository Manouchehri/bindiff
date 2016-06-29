package org.jfree.chart.renderer;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.renderer.Outlier;

public class OutlierList {
   private List outliers = new ArrayList();
   private Outlier averagedOutlier;
   private boolean multiple = false;

   public OutlierList(Outlier var1) {
      this.setAveragedOutlier(var1);
   }

   public boolean add(Outlier var1) {
      return this.outliers.add(var1);
   }

   public int getItemCount() {
      return this.outliers.size();
   }

   public Outlier getAveragedOutlier() {
      return this.averagedOutlier;
   }

   public void setAveragedOutlier(Outlier var1) {
      this.averagedOutlier = var1;
   }

   public boolean isMultiple() {
      return this.multiple;
   }

   public void setMultiple(boolean var1) {
      this.multiple = var1;
   }

   public boolean isOverlapped(Outlier var1) {
      if(var1 == null) {
         return false;
      } else {
         boolean var2 = var1.overlaps(this.getAveragedOutlier());
         return var2;
      }
   }

   public void updateAveragedOutlier() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      int var5 = this.getItemCount();

      Outlier var7;
      for(Iterator var6 = this.outliers.iterator(); var6.hasNext(); var3 += var7.getY()) {
         var7 = (Outlier)var6.next();
         var1 += var7.getX();
      }

      this.getAveragedOutlier().getPoint().setLocation(new Double(var1 / (double)var5, var3 / (double)var5));
   }
}
