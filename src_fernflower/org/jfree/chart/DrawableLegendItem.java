package org.jfree.chart;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import org.jfree.chart.LegendItem;

public class DrawableLegendItem {
   private LegendItem item;
   private double x;
   private double y;
   private double width;
   private double height;
   private Shape marker;
   private Line2D line;
   private Point2D labelPosition;

   public DrawableLegendItem(LegendItem var1) {
      this.item = var1;
   }

   public LegendItem getItem() {
      return this.item;
   }

   public double getX() {
      return this.x;
   }

   public void setX(double var1) {
      this.x = var1;
   }

   public double getY() {
      return this.y;
   }

   public void setY(double var1) {
      this.y = var1;
   }

   public double getWidth() {
      return this.width;
   }

   public double getHeight() {
      return this.height;
   }

   public double getMaxX() {
      return this.getX() + this.getWidth();
   }

   public double getMaxY() {
      return this.getY() + this.getHeight();
   }

   public Shape getMarker() {
      return this.marker;
   }

   public void setMarker(Shape var1) {
      this.marker = var1;
   }

   public void setLine(Line2D var1) {
      this.line = var1;
   }

   public Line2D getLine() {
      return this.line;
   }

   public Point2D getLabelPosition() {
      return this.labelPosition;
   }

   public void setLabelPosition(Point2D var1) {
      this.labelPosition = var1;
   }

   public void setBounds(double var1, double var3, double var5, double var7) {
      this.x = var1;
      this.y = var3;
      this.width = var5;
      this.height = var7;
   }
}
