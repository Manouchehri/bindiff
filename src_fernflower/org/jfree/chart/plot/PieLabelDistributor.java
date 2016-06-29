package org.jfree.chart.plot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.plot.PieLabelRecord;

public class PieLabelDistributor {
   private List labels;
   private double minGap = 4.0D;

   public PieLabelDistributor(int var1) {
      this.labels = new ArrayList(var1);
   }

   public PieLabelRecord getPieLabelRecord(int var1) {
      return (PieLabelRecord)this.labels.get(var1);
   }

   public void addPieLabelRecord(PieLabelRecord var1) {
      this.labels.add(var1);
   }

   public int getItemCount() {
      return this.labels.size();
   }

   public void distributeLabels(double var1, double var3) {
      this.sort();
      if(this.isOverlap()) {
         this.adjustInwards();
      }

      if(this.isOverlap()) {
         this.adjustDownwards(var1, var3);
      }

      if(this.isOverlap()) {
         this.adjustUpwards(var1, var3);
      }

      if(this.isOverlap()) {
         this.spreadEvenly(var1, var3);
      }

   }

   private boolean isOverlap() {
      double var1 = 0.0D;

      for(int var3 = 0; var3 < this.labels.size(); ++var3) {
         PieLabelRecord var4 = this.getPieLabelRecord(var3);
         if(var1 > var4.getLowerY()) {
            return true;
         }

         var1 = var4.getUpperY();
      }

      return false;
   }

   protected void adjustInwards() {
      int var1 = 0;

      for(int var2 = this.labels.size() - 1; var2 > var1; --var2) {
         PieLabelRecord var3;
         PieLabelRecord var4;
         double var5;
         if(var1 < var2 - 1) {
            var3 = this.getPieLabelRecord(var1);
            var4 = this.getPieLabelRecord(var1 + 1);
            if(var4.getLowerY() < var3.getUpperY()) {
               var5 = var3.getUpperY() - var4.getLowerY() + this.minGap;
               var4.setAllocatedY(var4.getAllocatedY() + var5);
            }
         }

         var3 = this.getPieLabelRecord(var2 - 1);
         var4 = this.getPieLabelRecord(var2);
         if(var3.getUpperY() > var4.getLowerY()) {
            var5 = var3.getUpperY() - var4.getLowerY() + this.minGap;
            var3.setAllocatedY(var3.getAllocatedY() - var5);
         }

         ++var1;
      }

   }

   protected void adjustDownwards(double var1, double var3) {
      for(int var5 = 0; var5 < this.labels.size() - 1; ++var5) {
         PieLabelRecord var6 = this.getPieLabelRecord(var5);
         PieLabelRecord var7 = this.getPieLabelRecord(var5 + 1);
         if(var7.getLowerY() < var6.getUpperY()) {
            var7.setAllocatedY(Math.min(var1 + var3, var6.getUpperY() + this.minGap + var7.getLabelHeight() / 2.0D));
         }
      }

   }

   protected void adjustUpwards(double var1, double var3) {
      for(int var5 = this.labels.size() - 1; var5 > 0; --var5) {
         PieLabelRecord var6 = this.getPieLabelRecord(var5);
         PieLabelRecord var7 = this.getPieLabelRecord(var5 - 1);
         if(var7.getUpperY() > var6.getLowerY()) {
            var7.setAllocatedY(Math.max(var1, var6.getLowerY() - this.minGap - var7.getLabelHeight() / 2.0D));
         }
      }

   }

   protected void spreadEvenly(double var1, double var3) {
      double var5 = var1;
      double var7 = 0.0D;

      for(int var9 = 0; var9 < this.labels.size(); ++var9) {
         var7 += this.getPieLabelRecord(var9).getLabelHeight();
      }

      double var13 = var3 - var7;
      if(this.labels.size() > 1) {
         var13 /= (double)(this.labels.size() - 1);
      }

      for(int var11 = 0; var11 < this.labels.size(); ++var11) {
         PieLabelRecord var12 = this.getPieLabelRecord(var11);
         var5 += var12.getLabelHeight() / 2.0D;
         var12.setAllocatedY(var5);
         var5 = var5 + var12.getLabelHeight() / 2.0D + var13;
      }

   }

   public void sort() {
      Collections.sort(this.labels);
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();

      for(int var2 = 0; var2 < this.labels.size(); ++var2) {
         var1.append(this.getPieLabelRecord(var2).toString()).append("\n");
      }

      return var1.toString();
   }
}
