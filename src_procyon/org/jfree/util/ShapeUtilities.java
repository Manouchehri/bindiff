package org.jfree.util;

import java.util.*;
import org.jfree.ui.*;
import java.awt.*;
import java.awt.geom.*;

public class ShapeUtilities
{
    private static final float SQRT2;
    
    public static Shape clone(final Shape shape) {
        if (shape instanceof Cloneable) {
            try {
                return (Shape)ObjectUtilities.clone(shape);
            }
            catch (CloneNotSupportedException ex) {}
        }
        return null;
    }
    
    public static boolean equal(final Shape shape, final Shape shape2) {
        if (shape instanceof Line2D && shape2 instanceof Line2D) {
            return equal((Line2D)shape, (Line2D)shape2);
        }
        if (shape instanceof Ellipse2D && shape2 instanceof Ellipse2D) {
            return equal((Ellipse2D)shape, (Ellipse2D)shape2);
        }
        if (shape instanceof Arc2D && shape2 instanceof Arc2D) {
            return equal((Arc2D)shape, (Arc2D)shape2);
        }
        if (shape instanceof Polygon && shape2 instanceof Polygon) {
            return equal((Polygon)shape, (Polygon)shape2);
        }
        if (shape instanceof GeneralPath && shape2 instanceof GeneralPath) {
            return equal((GeneralPath)shape, (GeneralPath)shape2);
        }
        return ObjectUtilities.equal(shape, shape2);
    }
    
    public static boolean equal(final Line2D line2D, final Line2D line2D2) {
        if (line2D == null) {
            return line2D2 == null;
        }
        return line2D2 != null && line2D.getP1().equals(line2D2.getP1()) && line2D.getP2().equals(line2D2.getP2());
    }
    
    public static boolean equal(final Ellipse2D ellipse2D, final Ellipse2D ellipse2D2) {
        if (ellipse2D == null) {
            return ellipse2D2 == null;
        }
        return ellipse2D2 != null && ellipse2D.getFrame().equals(ellipse2D2.getFrame());
    }
    
    public static boolean equal(final Arc2D arc2D, final Arc2D arc2D2) {
        if (arc2D == null) {
            return arc2D2 == null;
        }
        return arc2D2 != null && arc2D.getFrame().equals(arc2D2.getFrame()) && arc2D.getAngleStart() == arc2D2.getAngleStart() && arc2D.getAngleExtent() == arc2D2.getAngleExtent() && arc2D.getArcType() == arc2D2.getArcType();
    }
    
    public static boolean equal(final Polygon polygon, final Polygon polygon2) {
        if (polygon == null) {
            return polygon2 == null;
        }
        return polygon2 != null && polygon.npoints == polygon2.npoints && Arrays.equals(polygon.xpoints, polygon2.xpoints) && Arrays.equals(polygon.ypoints, polygon2.ypoints);
    }
    
    public static boolean equal(final GeneralPath generalPath, final GeneralPath generalPath2) {
        if (generalPath == null) {
            return generalPath2 == null;
        }
        if (generalPath2 == null) {
            return false;
        }
        if (generalPath.getWindingRule() != generalPath2.getWindingRule()) {
            return false;
        }
        final PathIterator pathIterator = generalPath.getPathIterator(null);
        final PathIterator pathIterator2 = generalPath.getPathIterator(null);
        final double[] array = new double[6];
        final double[] array2 = new double[6];
        for (boolean b = pathIterator.isDone() && pathIterator2.isDone(); !b; b = (pathIterator.isDone() && pathIterator2.isDone())) {
            if (pathIterator.isDone() != pathIterator2.isDone()) {
                return false;
            }
            if (pathIterator.currentSegment(array) != pathIterator2.currentSegment(array2)) {
                return false;
            }
            if (!Arrays.equals(array, array2)) {
                return false;
            }
            pathIterator.next();
            pathIterator2.next();
        }
        return true;
    }
    
    public static Shape createTranslatedShape(final Shape shape, final double n, final double n2) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        return AffineTransform.getTranslateInstance(n, n2).createTransformedShape(shape);
    }
    
    public static Shape createTranslatedShape(final Shape shape, final RectangleAnchor rectangleAnchor, final double n, final double n2) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        final Point2D coordinates = RectangleAnchor.coordinates(shape.getBounds2D(), rectangleAnchor);
        return AffineTransform.getTranslateInstance(n - coordinates.getX(), n2 - coordinates.getY()).createTransformedShape(shape);
    }
    
    public static Shape rotateShape(final Shape shape, final double n, final float n2, final float n3) {
        if (shape == null) {
            return null;
        }
        return AffineTransform.getRotateInstance(n, n2, n3).createTransformedShape(shape);
    }
    
    public static void drawRotatedShape(final Graphics2D graphics2D, final Shape shape, final double n, final float n2, final float n3) {
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.transform(AffineTransform.getRotateInstance(n, n2, n3));
        graphics2D.draw(shape);
        graphics2D.setTransform(transform);
    }
    
    public static Shape createDiagonalCross(final float n, final float n2) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(-n - n2, -n + n2);
        generalPath.lineTo(-n + n2, -n - n2);
        generalPath.lineTo(0.0f, -n2 * ShapeUtilities.SQRT2);
        generalPath.lineTo(n - n2, -n - n2);
        generalPath.lineTo(n + n2, -n + n2);
        generalPath.lineTo(n2 * ShapeUtilities.SQRT2, 0.0f);
        generalPath.lineTo(n + n2, n - n2);
        generalPath.lineTo(n - n2, n + n2);
        generalPath.lineTo(0.0f, n2 * ShapeUtilities.SQRT2);
        generalPath.lineTo(-n + n2, n + n2);
        generalPath.lineTo(-n - n2, n - n2);
        generalPath.lineTo(-n2 * ShapeUtilities.SQRT2, 0.0f);
        generalPath.closePath();
        return generalPath;
    }
    
    public static Shape createRegularCross(final float n, final float n2) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(-n, n2);
        generalPath.lineTo(-n2, n2);
        generalPath.lineTo(-n2, n);
        generalPath.lineTo(n2, n);
        generalPath.lineTo(n2, n2);
        generalPath.lineTo(n, n2);
        generalPath.lineTo(n, -n2);
        generalPath.lineTo(n2, -n2);
        generalPath.lineTo(n2, -n);
        generalPath.lineTo(-n2, -n);
        generalPath.lineTo(-n2, -n2);
        generalPath.lineTo(-n, -n2);
        generalPath.closePath();
        return generalPath;
    }
    
    public static Shape createDiamond(final float n) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, -n);
        generalPath.lineTo(n, 0.0f);
        generalPath.lineTo(0.0f, n);
        generalPath.lineTo(-n, 0.0f);
        generalPath.closePath();
        return generalPath;
    }
    
    public static Shape createUpTriangle(final float n) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, -n);
        generalPath.lineTo(n, n);
        generalPath.lineTo(-n, n);
        generalPath.closePath();
        return generalPath;
    }
    
    public static Shape createDownTriangle(final float n) {
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, n);
        generalPath.lineTo(n, -n);
        generalPath.lineTo(-n, -n);
        generalPath.closePath();
        return generalPath;
    }
    
    public static Shape createLineRegion(final Line2D line2D, final float n) {
        final GeneralPath generalPath = new GeneralPath();
        final float n2 = (float)line2D.getX1();
        final float n3 = (float)line2D.getX2();
        final float n4 = (float)line2D.getY1();
        final float n5 = (float)line2D.getY2();
        if (n3 - n2 != 0.0) {
            final double atan = Math.atan((n5 - n4) / (n3 - n2));
            final float n6 = (float)Math.sin(atan) * n;
            final float n7 = (float)Math.cos(atan) * n;
            generalPath.moveTo(n2 - n6, n4 + n7);
            generalPath.lineTo(n2 + n6, n4 - n7);
            generalPath.lineTo(n3 + n6, n5 - n7);
            generalPath.lineTo(n3 - n6, n5 + n7);
            generalPath.closePath();
        }
        else {
            generalPath.moveTo(n2 - n / 2.0f, n4);
            generalPath.lineTo(n2 + n / 2.0f, n4);
            generalPath.lineTo(n3 + n / 2.0f, n5);
            generalPath.lineTo(n3 - n / 2.0f, n5);
            generalPath.closePath();
        }
        return generalPath;
    }
    
    public static Point2D getPointInRectangle(double max, double max2, final Rectangle2D rectangle2D) {
        max = Math.max(rectangle2D.getMinX(), Math.min(max, rectangle2D.getMaxX()));
        max2 = Math.max(rectangle2D.getMinY(), Math.min(max2, rectangle2D.getMaxY()));
        return new Point2D.Double(max, max2);
    }
    
    public static boolean contains(final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2) {
        final double x = rectangle2D.getX();
        final double y = rectangle2D.getY();
        final double x2 = rectangle2D2.getX();
        final double y2 = rectangle2D2.getY();
        final double width = rectangle2D2.getWidth();
        final double height = rectangle2D2.getHeight();
        return x2 >= x && y2 >= y && x2 + width <= x + rectangle2D.getWidth() && y2 + height <= y + rectangle2D.getHeight();
    }
    
    public static boolean intersects(final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2) {
        final double x = rectangle2D.getX();
        final double y = rectangle2D.getY();
        final double x2 = rectangle2D2.getX();
        final double width = rectangle2D2.getWidth();
        final double y2 = rectangle2D2.getY();
        final double height = rectangle2D2.getHeight();
        return x2 + width >= x && y2 + height >= y && x2 <= x + rectangle2D.getWidth() && y2 <= y + rectangle2D.getHeight();
    }
    
    static {
        SQRT2 = (float)Math.pow(2.0, 0.5);
    }
}
