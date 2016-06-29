package org.jfree.chart.plot;

import java.awt.geom.Rectangle2D;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.RendererState;

public class PiePlotState extends RendererState {
   private int passesRequired = 1;
   private double total = 0.0D;
   private double latestAngle;
   private Rectangle2D explodedPieArea;
   private Rectangle2D pieArea;
   private double pieCenterX;
   private double pieCenterY;
   private double pieHRadius;
   private double pieWRadius;
   private Rectangle2D linkArea;

   public PiePlotState(PlotRenderingInfo var1) {
      super(var1);
   }

   public int getPassesRequired() {
      return this.passesRequired;
   }

   public void setPassesRequired(int var1) {
      this.passesRequired = var1;
   }

   public double getTotal() {
      return this.total;
   }

   public void setTotal(double var1) {
      this.total = var1;
   }

   public double getLatestAngle() {
      return this.latestAngle;
   }

   public void setLatestAngle(double var1) {
      this.latestAngle = var1;
   }

   public Rectangle2D getPieArea() {
      return this.pieArea;
   }

   public void setPieArea(Rectangle2D var1) {
      this.pieArea = var1;
   }

   public Rectangle2D getExplodedPieArea() {
      return this.explodedPieArea;
   }

   public void setExplodedPieArea(Rectangle2D var1) {
      this.explodedPieArea = var1;
   }

   public double getPieCenterX() {
      return this.pieCenterX;
   }

   public void setPieCenterX(double var1) {
      this.pieCenterX = var1;
   }

   public double getPieCenterY() {
      return this.pieCenterY;
   }

   public void setPieCenterY(double var1) {
      this.pieCenterY = var1;
   }

   public Rectangle2D getLinkArea() {
      return this.linkArea;
   }

   public void setLinkArea(Rectangle2D var1) {
      this.linkArea = var1;
   }

   public double getPieHRadius() {
      return this.pieHRadius;
   }

   public void setPieHRadius(double var1) {
      this.pieHRadius = var1;
   }

   public double getPieWRadius() {
      return this.pieWRadius;
   }

   public void setPieWRadius(double var1) {
      this.pieWRadius = var1;
   }
}
