package org.jfree.chart.plot;

import java.awt.geom.Point2D;
import org.jfree.chart.plot.PlotOrientation;

public class CrosshairState {
   private boolean calculateDistanceInDataSpace;
   private double anchorX;
   private double anchorY;
   private Point2D anchor;
   private double crosshairX;
   private double crosshairY;
   private int domainAxisIndex;
   private int rangeAxisIndex;
   private double distance;

   public CrosshairState() {
      this(false);
   }

   public CrosshairState(boolean var1) {
      this.calculateDistanceInDataSpace = false;
      this.calculateDistanceInDataSpace = var1;
   }

   public double getCrosshairDistance() {
      return this.distance;
   }

   public void setCrosshairDistance(double var1) {
      this.distance = var1;
   }

   public void updateCrosshairPoint(double var1, double var3, double var5, double var7, PlotOrientation var9) {
      this.updateCrosshairPoint(var1, var3, 0, 0, var5, var7, var9);
   }

   public void updateCrosshairPoint(double var1, double var3, int var5, int var6, double var7, double var9, PlotOrientation var11) {
      if(this.anchor != null) {
         double var12 = 0.0D;
         if(this.calculateDistanceInDataSpace) {
            var12 = (var1 - this.anchorX) * (var1 - this.anchorX) + (var3 - this.anchorY) * (var3 - this.anchorY);
         } else {
            double var14 = this.anchor.getX();
            double var16 = this.anchor.getY();
            if(var11 == PlotOrientation.HORIZONTAL) {
               double var18 = var16;
               var16 = var14;
               var14 = var18;
            }

            var12 = (var7 - var14) * (var7 - var14) + (var9 - var16) * (var9 - var16);
         }

         if(var12 < this.distance) {
            this.crosshairX = var1;
            this.crosshairY = var3;
            this.domainAxisIndex = var5;
            this.rangeAxisIndex = var6;
            this.distance = var12;
         }
      }

   }

   public void updateCrosshairX(double var1) {
      this.updateCrosshairX(var1, 0);
   }

   public void updateCrosshairX(double var1, int var3) {
      double var4 = Math.abs(var1 - this.anchorX);
      if(var4 < this.distance) {
         this.crosshairX = var1;
         this.domainAxisIndex = var3;
         this.distance = var4;
      }

   }

   public void updateCrosshairY(double var1) {
      this.updateCrosshairY(var1, 0);
   }

   public void updateCrosshairY(double var1, int var3) {
      double var4 = Math.abs(var1 - this.anchorY);
      if(var4 < this.distance) {
         this.crosshairY = var1;
         this.rangeAxisIndex = var3;
         this.distance = var4;
      }

   }

   public Point2D getAnchor() {
      return this.anchor;
   }

   public void setAnchor(Point2D var1) {
      this.anchor = var1;
   }

   public double getAnchorX() {
      return this.anchorX;
   }

   public void setAnchorX(double var1) {
      this.anchorX = var1;
   }

   public double getAnchorY() {
      return this.anchorY;
   }

   public void setAnchorY(double var1) {
      this.anchorY = var1;
   }

   public double getCrosshairX() {
      return this.crosshairX;
   }

   public void setCrosshairX(double var1) {
      this.crosshairX = var1;
   }

   public double getCrosshairY() {
      return this.crosshairY;
   }

   public void setCrosshairY(double var1) {
      this.crosshairY = var1;
   }

   public int getDomainAxisIndex() {
      return this.domainAxisIndex;
   }

   public int getRangeAxisIndex() {
      return this.rangeAxisIndex;
   }
}
