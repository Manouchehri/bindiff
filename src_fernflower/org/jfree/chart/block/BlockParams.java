package org.jfree.chart.block;

import org.jfree.chart.block.EntityBlockParams;

public class BlockParams implements EntityBlockParams {
   private boolean generateEntities = false;
   private double translateX = 0.0D;
   private double translateY = 0.0D;

   public boolean getGenerateEntities() {
      return this.generateEntities;
   }

   public void setGenerateEntities(boolean var1) {
      this.generateEntities = var1;
   }

   public double getTranslateX() {
      return this.translateX;
   }

   public void setTranslateX(double var1) {
      this.translateX = var1;
   }

   public double getTranslateY() {
      return this.translateY;
   }

   public void setTranslateY(double var1) {
      this.translateY = var1;
   }
}
