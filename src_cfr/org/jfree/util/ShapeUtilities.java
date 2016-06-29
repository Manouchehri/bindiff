/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.ObjectUtilities;

public class ShapeUtilities {
    private static final float SQRT2 = (float)Math.pow(2.0, 0.5);

    private ShapeUtilities() {
    }

    public static Shape clone(Shape shape) {
        if (!(shape instanceof Cloneable)) return null;
        try {
            return (Shape)ObjectUtilities.clone(shape);
        }
        catch (CloneNotSupportedException var1_1) {
            // empty catch block
        }
        return null;
    }

    public static boolean equal(Shape shape, Shape shape2) {
        if (shape instanceof Line2D && shape2 instanceof Line2D) {
            return ShapeUtilities.equal((Line2D)shape, (Line2D)shape2);
        }
        if (shape instanceof Ellipse2D && shape2 instanceof Ellipse2D) {
            return ShapeUtilities.equal((Ellipse2D)shape, (Ellipse2D)shape2);
        }
        if (shape instanceof Arc2D && shape2 instanceof Arc2D) {
            return ShapeUtilities.equal((Arc2D)shape, (Arc2D)shape2);
        }
        if (shape instanceof Polygon && shape2 instanceof Polygon) {
            return ShapeUtilities.equal((Polygon)shape, (Polygon)shape2);
        }
        if (!(shape instanceof GeneralPath)) return ObjectUtilities.equal(shape, shape2);
        if (!(shape2 instanceof GeneralPath)) return ObjectUtilities.equal(shape, shape2);
        return ShapeUtilities.equal((GeneralPath)shape, (GeneralPath)shape2);
    }

    public static boolean equal(Line2D line2D, Line2D line2D2) {
        if (line2D == null) {
            if (line2D2 != null) return false;
            return true;
        }
        if (line2D2 == null) {
            return false;
        }
        if (!line2D.getP1().equals(line2D2.getP1())) {
            return false;
        }
        if (line2D.getP2().equals(line2D2.getP2())) return true;
        return false;
    }

    public static boolean equal(Ellipse2D ellipse2D, Ellipse2D ellipse2D2) {
        if (ellipse2D == null) {
            if (ellipse2D2 != null) return false;
            return true;
        }
        if (ellipse2D2 == null) {
            return false;
        }
        if (ellipse2D.getFrame().equals(ellipse2D2.getFrame())) return true;
        return false;
    }

    public static boolean equal(Arc2D arc2D, Arc2D arc2D2) {
        if (arc2D == null) {
            if (arc2D2 != null) return false;
            return true;
        }
        if (arc2D2 == null) {
            return false;
        }
        if (!arc2D.getFrame().equals(arc2D2.getFrame())) {
            return false;
        }
        if (arc2D.getAngleStart() != arc2D2.getAngleStart()) {
            return false;
        }
        if (arc2D.getAngleExtent() != arc2D2.getAngleExtent()) {
            return false;
        }
        if (arc2D.getArcType() == arc2D2.getArcType()) return true;
        return false;
    }

    public static boolean equal(Polygon polygon, Polygon polygon2) {
        if (polygon == null) {
            if (polygon2 != null) return false;
            return true;
        }
        if (polygon2 == null) {
            return false;
        }
        if (polygon.npoints != polygon2.npoints) {
            return false;
        }
        if (!Arrays.equals(polygon.xpoints, polygon2.xpoints)) {
            return false;
        }
        if (Arrays.equals(polygon.ypoints, polygon2.ypoints)) return true;
        return false;
    }

    public static boolean equal(GeneralPath generalPath, GeneralPath generalPath2) {
        if (generalPath == null) {
            if (generalPath2 != null) return false;
            return true;
        }
        if (generalPath2 == null) {
            return false;
        }
        if (generalPath.getWindingRule() != generalPath2.getWindingRule()) {
            return false;
        }
        PathIterator pathIterator = generalPath.getPathIterator(null);
        PathIterator pathIterator2 = generalPath.getPathIterator(null);
        double[] arrd = new double[6];
        double[] arrd2 = new double[6];
        if (pathIterator.isDone() && pathIterator2.isDone()) {
            return true;
        }
        boolean bl2 = false;
        boolean bl3 = bl2;
        while (!bl3) {
            int n2;
            if (pathIterator.isDone() != pathIterator2.isDone()) {
                return false;
            }
            int n3 = pathIterator.currentSegment(arrd);
            if (n3 != (n2 = pathIterator2.currentSegment(arrd2))) {
                return false;
            }
            if (!Arrays.equals(arrd, arrd2)) {
                return false;
            }
            pathIterator.next();
            pathIterator2.next();
            if (pathIterator.isDone() && pathIterator2.isDone()) {
                return true;
            }
            boolean bl4 = false;
            bl3 = bl4;
        }
        return true;
    }

    public static Shape createTranslatedShape(Shape shape, double d2, double d3) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        AffineTransform affineTransform = AffineTransform.getTranslateInstance(d2, d3);
        return affineTransform.createTransformedShape(shape);
    }

    public static Shape createTranslatedShape(Shape shape, RectangleAnchor rectangleAnchor, double d2, double d3) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        Point2D point2D = RectangleAnchor.coordinates(shape.getBounds2D(), rectangleAnchor);
        AffineTransform affineTransform = AffineTransform.getTranslateInstance(d2 - point2D.getX(), d3 - point2D.getY());
        return affineTransform.createTransformedShape(shape);
    }

    public static Shape rotateShape(Shape shape, double d2, float f2, float f3) {
        if (shape == null) {
            return null;
        }
        AffineTransform affineTransform = AffineTransform.getRotateInstance(d2, f2, f3);
        return affineTransform.createTransformedShape(shape);
    }

    public static void drawRotatedShape(Graphics2D graphics2D, Shape shape, double d2, float f2, float f3) {
        AffineTransform affineTransform = graphics2D.getTransform();
        AffineTransform affineTransform2 = AffineTransform.getRotateInstance(d2, f2, f3);
        graphics2D.transform(affineTransform2);
        graphics2D.draw(shape);
        graphics2D.setTransform(affineTransform);
    }

    public static Shape createDiagonalCross(float f2, float f3) {
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(- f2 - f3, - f2 + f3);
        generalPath.lineTo(- f2 + f3, - f2 - f3);
        generalPath.lineTo(0.0f, (- f3) * SQRT2);
        generalPath.lineTo(f2 - f3, - f2 - f3);
        generalPath.lineTo(f2 + f3, - f2 + f3);
        generalPath.lineTo(f3 * SQRT2, 0.0f);
        generalPath.lineTo(f2 + f3, f2 - f3);
        generalPath.lineTo(f2 - f3, f2 + f3);
        generalPath.lineTo(0.0f, f3 * SQRT2);
        generalPath.lineTo(- f2 + f3, f2 + f3);
        generalPath.lineTo(- f2 - f3, f2 - f3);
        generalPath.lineTo((- f3) * SQRT2, 0.0f);
        generalPath.closePath();
        return generalPath;
    }

    public static Shape createRegularCross(float f2, float f3) {
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(- f2, f3);
        generalPath.lineTo(- f3, f3);
        generalPath.lineTo(- f3, f2);
        generalPath.lineTo(f3, f2);
        generalPath.lineTo(f3, f3);
        generalPath.lineTo(f2, f3);
        generalPath.lineTo(f2, - f3);
        generalPath.lineTo(f3, - f3);
        generalPath.lineTo(f3, - f2);
        generalPath.lineTo(- f3, - f2);
        generalPath.lineTo(- f3, - f3);
        generalPath.lineTo(- f2, - f3);
        generalPath.closePath();
        return generalPath;
    }

    public static Shape createDiamond(float f2) {
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, - f2);
        generalPath.lineTo(f2, 0.0f);
        generalPath.lineTo(0.0f, f2);
        generalPath.lineTo(- f2, 0.0f);
        generalPath.closePath();
        return generalPath;
    }

    public static Shape createUpTriangle(float f2) {
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, - f2);
        generalPath.lineTo(f2, f2);
        generalPath.lineTo(- f2, f2);
        generalPath.closePath();
        return generalPath;
    }

    public static Shape createDownTriangle(float f2) {
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, f2);
        generalPath.lineTo(f2, - f2);
        generalPath.lineTo(- f2, - f2);
        generalPath.closePath();
        return generalPath;
    }

    public static Shape createLineRegion(Line2D line2D, float f2) {
        GeneralPath generalPath = new GeneralPath();
        float f3 = (float)line2D.getX1();
        float f4 = (float)line2D.getX2();
        float f5 = (float)line2D.getY1();
        float f6 = (float)line2D.getY2();
        if ((double)(f4 - f3) != 0.0) {
            double d2 = Math.atan((f6 - f5) / (f4 - f3));
            float f7 = (float)Math.sin(d2) * f2;
            float f8 = (float)Math.cos(d2) * f2;
            generalPath.moveTo(f3 - f7, f5 + f8);
            generalPath.lineTo(f3 + f7, f5 - f8);
            generalPath.lineTo(f4 + f7, f6 - f8);
            generalPath.lineTo(f4 - f7, f6 + f8);
            generalPath.closePath();
            return generalPath;
        }
        generalPath.moveTo(f3 - f2 / 2.0f, f5);
        generalPath.lineTo(f3 + f2 / 2.0f, f5);
        generalPath.lineTo(f4 + f2 / 2.0f, f6);
        generalPath.lineTo(f4 - f2 / 2.0f, f6);
        generalPath.closePath();
        return generalPath;
    }

    public static Point2D getPointInRectangle(double d2, double d3, Rectangle2D rectangle2D) {
        d2 = Math.max(rectangle2D.getMinX(), Math.min(d2, rectangle2D.getMaxX()));
        d3 = Math.max(rectangle2D.getMinY(), Math.min(d3, rectangle2D.getMaxY()));
        return new Point2D.Double(d2, d3);
    }

    public static boolean contains(Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        double d2 = rectangle2D.getX();
        double d3 = rectangle2D.getY();
        double d4 = rectangle2D2.getX();
        double d5 = rectangle2D2.getY();
        double d6 = rectangle2D2.getWidth();
        double d7 = rectangle2D2.getHeight();
        if (d4 < d2) return false;
        if (d5 < d3) return false;
        if (d4 + d6 > d2 + rectangle2D.getWidth()) return false;
        if (d5 + d7 > d3 + rectangle2D.getHeight()) return false;
        return true;
    }

    public static boolean intersects(Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        double d2 = rectangle2D.getX();
        double d3 = rectangle2D.getY();
        double d4 = rectangle2D2.getX();
        double d5 = rectangle2D2.getWidth();
        double d6 = rectangle2D2.getY();
        double d7 = rectangle2D2.getHeight();
        if (d4 + d5 < d2) return false;
        if (d6 + d7 < d3) return false;
        if (d4 > d2 + rectangle2D.getWidth()) return false;
        if (d6 > d3 + rectangle2D.getHeight()) return false;
        return true;
    }
}

