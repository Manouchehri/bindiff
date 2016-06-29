/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.jfree.chart.ChartColor;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class DefaultDrawingSupplier
implements Serializable,
Cloneable,
DrawingSupplier,
PublicCloneable {
    private static final long serialVersionUID = -7339847061039422538L;
    public static final Paint[] DEFAULT_PAINT_SEQUENCE = ChartColor.createDefaultPaintArray();
    public static final Paint[] DEFAULT_OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.lightGray};
    public static final Stroke[] DEFAULT_STROKE_SEQUENCE = new Stroke[]{new BasicStroke(1.0f, 2, 2)};
    public static final Stroke[] DEFAULT_OUTLINE_STROKE_SEQUENCE = new Stroke[]{new BasicStroke(1.0f, 2, 2)};
    public static final Shape[] DEFAULT_SHAPE_SEQUENCE = DefaultDrawingSupplier.createStandardSeriesShapes();
    private transient Paint[] paintSequence;
    private int paintIndex;
    private transient Paint[] outlinePaintSequence;
    private int outlinePaintIndex;
    private transient Stroke[] strokeSequence;
    private int strokeIndex;
    private transient Stroke[] outlineStrokeSequence;
    private int outlineStrokeIndex;
    private transient Shape[] shapeSequence;
    private int shapeIndex;

    public DefaultDrawingSupplier() {
        this(DEFAULT_PAINT_SEQUENCE, DEFAULT_OUTLINE_PAINT_SEQUENCE, DEFAULT_STROKE_SEQUENCE, DEFAULT_OUTLINE_STROKE_SEQUENCE, DEFAULT_SHAPE_SEQUENCE);
    }

    public DefaultDrawingSupplier(Paint[] arrpaint, Paint[] arrpaint2, Stroke[] arrstroke, Stroke[] arrstroke2, Shape[] arrshape) {
        this.paintSequence = arrpaint;
        this.outlinePaintSequence = arrpaint2;
        this.strokeSequence = arrstroke;
        this.outlineStrokeSequence = arrstroke2;
        this.shapeSequence = arrshape;
    }

    @Override
    public Paint getNextPaint() {
        Paint paint = this.paintSequence[this.paintIndex % this.paintSequence.length];
        ++this.paintIndex;
        return paint;
    }

    @Override
    public Paint getNextOutlinePaint() {
        Paint paint = this.outlinePaintSequence[this.outlinePaintIndex % this.outlinePaintSequence.length];
        ++this.outlinePaintIndex;
        return paint;
    }

    @Override
    public Stroke getNextStroke() {
        Stroke stroke = this.strokeSequence[this.strokeIndex % this.strokeSequence.length];
        ++this.strokeIndex;
        return stroke;
    }

    @Override
    public Stroke getNextOutlineStroke() {
        Stroke stroke = this.outlineStrokeSequence[this.outlineStrokeIndex % this.outlineStrokeSequence.length];
        ++this.outlineStrokeIndex;
        return stroke;
    }

    @Override
    public Shape getNextShape() {
        Shape shape = this.shapeSequence[this.shapeIndex % this.shapeSequence.length];
        ++this.shapeIndex;
        return shape;
    }

    public static Shape[] createStandardSeriesShapes() {
        Shape[] arrshape = new Shape[10];
        double d2 = 6.0;
        double d3 = d2 / 2.0;
        int[] arrn = null;
        int[] arrn2 = null;
        arrshape[0] = new Rectangle2D.Double(- d3, - d3, d2, d2);
        arrshape[1] = new Ellipse2D.Double(- d3, - d3, d2, d2);
        arrn = DefaultDrawingSupplier.intArray(0.0, d3, - d3);
        arrn2 = DefaultDrawingSupplier.intArray(- d3, d3, d3);
        arrshape[2] = new Polygon(arrn, arrn2, 3);
        arrn = DefaultDrawingSupplier.intArray(0.0, d3, 0.0, - d3);
        arrn2 = DefaultDrawingSupplier.intArray(- d3, 0.0, d3, 0.0);
        arrshape[3] = new Polygon(arrn, arrn2, 4);
        arrshape[4] = new Rectangle2D.Double(- d3, (- d3) / 2.0, d2, d2 / 2.0);
        arrn = DefaultDrawingSupplier.intArray(- d3, d3, 0.0);
        arrn2 = DefaultDrawingSupplier.intArray(- d3, - d3, d3);
        arrshape[5] = new Polygon(arrn, arrn2, 3);
        arrshape[6] = new Ellipse2D.Double(- d3, (- d3) / 2.0, d2, d2 / 2.0);
        arrn = DefaultDrawingSupplier.intArray(- d3, d3, - d3);
        arrn2 = DefaultDrawingSupplier.intArray(- d3, 0.0, d3);
        arrshape[7] = new Polygon(arrn, arrn2, 3);
        arrshape[8] = new Rectangle2D.Double((- d3) / 2.0, - d3, d2 / 2.0, d2);
        arrn = DefaultDrawingSupplier.intArray(- d3, d3, d3);
        arrn2 = DefaultDrawingSupplier.intArray(0.0, - d3, d3);
        arrshape[9] = new Polygon(arrn, arrn2, 3);
        return arrshape;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultDrawingSupplier)) {
            return false;
        }
        DefaultDrawingSupplier defaultDrawingSupplier = (DefaultDrawingSupplier)object;
        if (!Arrays.equals(this.paintSequence, defaultDrawingSupplier.paintSequence)) {
            return false;
        }
        if (this.paintIndex != defaultDrawingSupplier.paintIndex) {
            return false;
        }
        if (!Arrays.equals(this.outlinePaintSequence, defaultDrawingSupplier.outlinePaintSequence)) {
            return false;
        }
        if (this.outlinePaintIndex != defaultDrawingSupplier.outlinePaintIndex) {
            return false;
        }
        if (!Arrays.equals(this.strokeSequence, defaultDrawingSupplier.strokeSequence)) {
            return false;
        }
        if (this.strokeIndex != defaultDrawingSupplier.strokeIndex) {
            return false;
        }
        if (!Arrays.equals(this.outlineStrokeSequence, defaultDrawingSupplier.outlineStrokeSequence)) {
            return false;
        }
        if (this.outlineStrokeIndex != defaultDrawingSupplier.outlineStrokeIndex) {
            return false;
        }
        if (!this.equalShapes(this.shapeSequence, defaultDrawingSupplier.shapeSequence)) {
            return false;
        }
        if (this.shapeIndex == defaultDrawingSupplier.shapeIndex) return true;
        return false;
    }

    private boolean equalShapes(Shape[] arrshape, Shape[] arrshape2) {
        if (arrshape == null) {
            if (arrshape2 != null) return false;
            return true;
        }
        if (arrshape2 == null) {
            return false;
        }
        if (arrshape.length != arrshape2.length) {
            return false;
        }
        int n2 = 0;
        while (n2 < arrshape.length) {
            if (!ShapeUtilities.equal(arrshape[n2], arrshape2[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int n2;
        int n3;
        int n4;
        int n5;
        objectOutputStream.defaultWriteObject();
        int n6 = this.paintSequence.length;
        objectOutputStream.writeInt(n6);
        for (n5 = 0; n5 < n6; ++n5) {
            SerialUtilities.writePaint(this.paintSequence[n5], objectOutputStream);
        }
        n5 = this.outlinePaintSequence.length;
        objectOutputStream.writeInt(n5);
        for (n3 = 0; n3 < n5; ++n3) {
            SerialUtilities.writePaint(this.outlinePaintSequence[n3], objectOutputStream);
        }
        n3 = this.strokeSequence.length;
        objectOutputStream.writeInt(n3);
        for (n4 = 0; n4 < n3; ++n4) {
            SerialUtilities.writeStroke(this.strokeSequence[n4], objectOutputStream);
        }
        n4 = this.outlineStrokeSequence.length;
        objectOutputStream.writeInt(n4);
        for (n2 = 0; n2 < n4; ++n2) {
            SerialUtilities.writeStroke(this.outlineStrokeSequence[n2], objectOutputStream);
        }
        n2 = this.shapeSequence.length;
        objectOutputStream.writeInt(n2);
        int n7 = 0;
        while (n7 < n2) {
            SerialUtilities.writeShape(this.shapeSequence[n7], objectOutputStream);
            ++n7;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        int n3;
        int n4;
        int n5;
        objectInputStream.defaultReadObject();
        int n6 = objectInputStream.readInt();
        this.paintSequence = new Paint[n6];
        for (n5 = 0; n5 < n6; ++n5) {
            this.paintSequence[n5] = SerialUtilities.readPaint(objectInputStream);
        }
        n5 = objectInputStream.readInt();
        this.outlinePaintSequence = new Paint[n5];
        for (n3 = 0; n3 < n5; ++n3) {
            this.outlinePaintSequence[n3] = SerialUtilities.readPaint(objectInputStream);
        }
        n3 = objectInputStream.readInt();
        this.strokeSequence = new Stroke[n3];
        for (n4 = 0; n4 < n3; ++n4) {
            this.strokeSequence[n4] = SerialUtilities.readStroke(objectInputStream);
        }
        n4 = objectInputStream.readInt();
        this.outlineStrokeSequence = new Stroke[n4];
        for (n2 = 0; n2 < n4; ++n2) {
            this.outlineStrokeSequence[n2] = SerialUtilities.readStroke(objectInputStream);
        }
        n2 = objectInputStream.readInt();
        this.shapeSequence = new Shape[n2];
        int n7 = 0;
        while (n7 < n2) {
            this.shapeSequence[n7] = SerialUtilities.readShape(objectInputStream);
            ++n7;
        }
    }

    private static int[] intArray(double d2, double d3, double d4) {
        return new int[]{(int)d2, (int)d3, (int)d4};
    }

    private static int[] intArray(double d2, double d3, double d4, double d5) {
        return new int[]{(int)d2, (int)d3, (int)d4, (int)d5};
    }

    @Override
    public Object clone() {
        return (DefaultDrawingSupplier)super.clone();
    }
}

