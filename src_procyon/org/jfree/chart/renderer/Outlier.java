package org.jfree.chart.renderer;

import java.awt.geom.*;

public class Outlier implements Comparable
{
    private Point2D point;
    private double radius;
    
    public Outlier(final double n, final double n2, final double radius) {
        this.point = new Point2D.Double(n - radius, n2 - radius);
        this.radius = radius;
    }
    
    public Point2D getPoint() {
        return this.point;
    }
    
    public void setPoint(final Point2D point) {
        this.point = point;
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
    
    public void setRadius(final double radius) {
        this.radius = radius;
    }
    
    public int compareTo(final Object o) {
        final Outlier outlier = (Outlier)o;
        final Point2D point = this.getPoint();
        final Point2D point2 = outlier.getPoint();
        if (point.equals(point2)) {
            return 0;
        }
        if (point.getX() < point2.getX() || point.getY() < point2.getY()) {
            return -1;
        }
        return 1;
    }
    
    public boolean overlaps(final Outlier outlier) {
        return outlier.getX() >= this.getX() - this.radius * 1.1 && outlier.getX() <= this.getX() + this.radius * 1.1 && outlier.getY() >= this.getY() - this.radius * 1.1 && outlier.getY() <= this.getY() + this.radius * 1.1;
    }
    
    public String toString() {
        return "{" + this.getX() + "," + this.getY() + "}";
    }
}
