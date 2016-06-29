package org.jfree.chart.renderer;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Outlier implements Comparable {
   private Point2D point;
   private double radius;

   public Outlier(double var1, double var3, double var5) {
      this.point = new Double(var1 - var5, var3 - var5);
      this.radius = var5;
   }

   public Point2D getPoint() {
      return this.point;
   }

   public void setPoint(Point2D var1) {
      this.point = var1;
   }

   public double getX() {
      return this.getPoint().getX();
   }

   public double getY() {
      return this.getPoint().getY();
   }

   public double getRadius() {
      return this.radius;
   }

   public void setRadius(double var1) {
      this.radius = var1;
   }

   public int compareTo(Object var1) {
      Outlier var2 = (Outlier)var1;
      Point2D var3 = this.getPoint();
      Point2D var4 = var2.getPoint();
      return var3.equals(var4)?0:(var3.getX() >= var4.getX() && var3.getY() >= var4.getY()?1:-1);
   }

   public boolean overlaps(Outlier var1) {
      return var1.getX() >= this.getX() - this.radius * 1.1D && var1.getX() <= this.getX() + this.radius * 1.1D && var1.getY() >= this.getY() - this.radius * 1.1D && var1.getY() <= this.getY() + this.radius * 1.1D;
   }

   public String toString() {
      return "{" + this.getX() + "," + this.getY() + "}";
   }
}
