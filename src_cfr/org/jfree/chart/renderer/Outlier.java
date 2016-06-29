/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.awt.geom.Point2D;

public class Outlier
implements Comparable {
    private Point2D point;
    private double radius;

    public Outlier(double d2, double d3, double d4) {
        this.point = new Point2D.Double(d2 - d4, d3 - d4);
        this.radius = d4;
    }

    public Point2D getPoint() {
        return this.point;
    }

    public void setPoint(Point2D point2D) {
        this.point = point2D;
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

    public void setRadius(double d2) {
        this.radius = d2;
    }

    public int compareTo(Object object) {
        Point2D point2D;
        Outlier outlier = (Outlier)object;
        Point2D point2D2 = this.getPoint();
        if (point2D2.equals(point2D = outlier.getPoint())) {
            return 0;
        }
        if (point2D2.getX() < point2D.getX()) return -1;
        if (point2D2.getY() >= point2D.getY()) return 1;
        return -1;
    }

    public boolean overlaps(Outlier outlier) {
        if (outlier.getX() < this.getX() - this.radius * 1.1) return false;
        if (outlier.getX() > this.getX() + this.radius * 1.1) return false;
        if (outlier.getY() < this.getY() - this.radius * 1.1) return false;
        if (outlier.getY() > this.getY() + this.radius * 1.1) return false;
        return true;
    }

    public String toString() {
        return new StringBuffer().append("{").append(this.getX()).append(",").append(this.getY()).append("}").toString();
    }
}

