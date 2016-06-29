package org.jfree.chart.plot;

import org.jfree.text.TextBox;

public class PieLabelRecord implements Comparable {
   private Comparable key;
   private double angle;
   private double baseY;
   private double allocatedY;
   private TextBox label;
   private double labelHeight;
   private double gap;
   private double linkPercent;

   public PieLabelRecord(Comparable var1, double var2, double var4, TextBox var6, double var7, double var9, double var11) {
      this.key = var1;
      this.angle = var2;
      this.baseY = var4;
      this.allocatedY = var4;
      this.label = var6;
      this.labelHeight = var7;
      this.gap = var9;
      this.linkPercent = var11;
   }

   public double getBaseY() {
      return this.baseY;
   }

   public void setBaseY(double var1) {
      this.baseY = var1;
   }

   public double getLowerY() {
      return this.allocatedY - this.labelHeight / 2.0D;
   }

   public double getUpperY() {
      return this.allocatedY + this.labelHeight / 2.0D;
   }

   public double getAngle() {
      return this.angle;
   }

   public Comparable getKey() {
      return this.key;
   }

   public TextBox getLabel() {
      return this.label;
   }

   public double getLabelHeight() {
      return this.labelHeight;
   }

   public double getAllocatedY() {
      return this.allocatedY;
   }

   public void setAllocatedY(double var1) {
      this.allocatedY = var1;
   }

   public double getGap() {
      return this.gap;
   }

   public double getLinkPercent() {
      return this.linkPercent;
   }

   public int compareTo(Object var1) {
      byte var2 = 0;
      if(var1 instanceof PieLabelRecord) {
         PieLabelRecord var3 = (PieLabelRecord)var1;
         if(this.baseY < var3.baseY) {
            var2 = -1;
         } else if(this.baseY > var3.baseY) {
            var2 = 1;
         }
      }

      return var2;
   }

   public String toString() {
      return this.baseY + ", " + this.key.toString();
   }
}
