package org.jfree.chart.plot;

import java.awt.geom.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import org.jfree.chart.*;
import java.awt.*;

public class DefaultDrawingSupplier implements Serializable, Cloneable, DrawingSupplier, PublicCloneable
{
    private static final long serialVersionUID = -7339847061039422538L;
    public static final Paint[] DEFAULT_PAINT_SEQUENCE;
    public static final Paint[] DEFAULT_OUTLINE_PAINT_SEQUENCE;
    public static final Stroke[] DEFAULT_STROKE_SEQUENCE;
    public static final Stroke[] DEFAULT_OUTLINE_STROKE_SEQUENCE;
    public static final Shape[] DEFAULT_SHAPE_SEQUENCE;
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
        this(DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
    }
    
    public DefaultDrawingSupplier(final Paint[] paintSequence, final Paint[] outlinePaintSequence, final Stroke[] strokeSequence, final Stroke[] outlineStrokeSequence, final Shape[] shapeSequence) {
        this.paintSequence = paintSequence;
        this.outlinePaintSequence = outlinePaintSequence;
        this.strokeSequence = strokeSequence;
        this.outlineStrokeSequence = outlineStrokeSequence;
        this.shapeSequence = shapeSequence;
    }
    
    public Paint getNextPaint() {
        final Paint paint = this.paintSequence[this.paintIndex % this.paintSequence.length];
        ++this.paintIndex;
        return paint;
    }
    
    public Paint getNextOutlinePaint() {
        final Paint paint = this.outlinePaintSequence[this.outlinePaintIndex % this.outlinePaintSequence.length];
        ++this.outlinePaintIndex;
        return paint;
    }
    
    public Stroke getNextStroke() {
        final Stroke stroke = this.strokeSequence[this.strokeIndex % this.strokeSequence.length];
        ++this.strokeIndex;
        return stroke;
    }
    
    public Stroke getNextOutlineStroke() {
        final Stroke stroke = this.outlineStrokeSequence[this.outlineStrokeIndex % this.outlineStrokeSequence.length];
        ++this.outlineStrokeIndex;
        return stroke;
    }
    
    public Shape getNextShape() {
        final Shape shape = this.shapeSequence[this.shapeIndex % this.shapeSequence.length];
        ++this.shapeIndex;
        return shape;
    }
    
    public static Shape[] createStandardSeriesShapes() {
        final Shape[] array = new Shape[10];
        final double n = 6.0;
        final double n2 = n / 2.0;
        array[0] = new Rectangle2D.Double(-n2, -n2, n, n);
        array[1] = new Ellipse2D.Double(-n2, -n2, n, n);
        array[2] = new Polygon(intArray(0.0, n2, -n2), intArray(-n2, n2, n2), 3);
        array[3] = new Polygon(intArray(0.0, n2, 0.0, -n2), intArray(-n2, 0.0, n2, 0.0), 4);
        array[4] = new Rectangle2D.Double(-n2, -n2 / 2.0, n, n / 2.0);
        array[5] = new Polygon(intArray(-n2, n2, 0.0), intArray(-n2, -n2, n2), 3);
        array[6] = new Ellipse2D.Double(-n2, -n2 / 2.0, n, n / 2.0);
        array[7] = new Polygon(intArray(-n2, n2, -n2), intArray(-n2, 0.0, n2), 3);
        array[8] = new Rectangle2D.Double(-n2 / 2.0, -n2, n / 2.0, n);
        array[9] = new Polygon(intArray(-n2, n2, n2), intArray(0.0, -n2, n2), 3);
        return array;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultDrawingSupplier)) {
            return false;
        }
        final DefaultDrawingSupplier defaultDrawingSupplier = (DefaultDrawingSupplier)o;
        return Arrays.equals(this.paintSequence, defaultDrawingSupplier.paintSequence) && this.paintIndex == defaultDrawingSupplier.paintIndex && Arrays.equals(this.outlinePaintSequence, defaultDrawingSupplier.outlinePaintSequence) && this.outlinePaintIndex == defaultDrawingSupplier.outlinePaintIndex && Arrays.equals(this.strokeSequence, defaultDrawingSupplier.strokeSequence) && this.strokeIndex == defaultDrawingSupplier.strokeIndex && Arrays.equals(this.outlineStrokeSequence, defaultDrawingSupplier.outlineStrokeSequence) && this.outlineStrokeIndex == defaultDrawingSupplier.outlineStrokeIndex && this.equalShapes(this.shapeSequence, defaultDrawingSupplier.shapeSequence) && this.shapeIndex == defaultDrawingSupplier.shapeIndex;
    }
    
    private boolean equalShapes(final Shape[] array, final Shape[] array2) {
        if (array == null) {
            return array2 == null;
        }
        if (array2 == null) {
            return false;
        }
        if (array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (!ShapeUtilities.equal(array[i], array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        final int length = this.paintSequence.length;
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; ++i) {
            SerialUtilities.writePaint(this.paintSequence[i], objectOutputStream);
        }
        final int length2 = this.outlinePaintSequence.length;
        objectOutputStream.writeInt(length2);
        for (int j = 0; j < length2; ++j) {
            SerialUtilities.writePaint(this.outlinePaintSequence[j], objectOutputStream);
        }
        final int length3 = this.strokeSequence.length;
        objectOutputStream.writeInt(length3);
        for (int k = 0; k < length3; ++k) {
            SerialUtilities.writeStroke(this.strokeSequence[k], objectOutputStream);
        }
        final int length4 = this.outlineStrokeSequence.length;
        objectOutputStream.writeInt(length4);
        for (int l = 0; l < length4; ++l) {
            SerialUtilities.writeStroke(this.outlineStrokeSequence[l], objectOutputStream);
        }
        final int length5 = this.shapeSequence.length;
        objectOutputStream.writeInt(length5);
        for (int n = 0; n < length5; ++n) {
            SerialUtilities.writeShape(this.shapeSequence[n], objectOutputStream);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final int int1 = objectInputStream.readInt();
        this.paintSequence = new Paint[int1];
        for (int i = 0; i < int1; ++i) {
            this.paintSequence[i] = SerialUtilities.readPaint(objectInputStream);
        }
        final int int2 = objectInputStream.readInt();
        this.outlinePaintSequence = new Paint[int2];
        for (int j = 0; j < int2; ++j) {
            this.outlinePaintSequence[j] = SerialUtilities.readPaint(objectInputStream);
        }
        final int int3 = objectInputStream.readInt();
        this.strokeSequence = new Stroke[int3];
        for (int k = 0; k < int3; ++k) {
            this.strokeSequence[k] = SerialUtilities.readStroke(objectInputStream);
        }
        final int int4 = objectInputStream.readInt();
        this.outlineStrokeSequence = new Stroke[int4];
        for (int l = 0; l < int4; ++l) {
            this.outlineStrokeSequence[l] = SerialUtilities.readStroke(objectInputStream);
        }
        final int int5 = objectInputStream.readInt();
        this.shapeSequence = new Shape[int5];
        for (int n = 0; n < int5; ++n) {
            this.shapeSequence[n] = SerialUtilities.readShape(objectInputStream);
        }
    }
    
    private static int[] intArray(final double n, final double n2, final double n3) {
        return new int[] { (int)n, (int)n2, (int)n3 };
    }
    
    private static int[] intArray(final double n, final double n2, final double n3, final double n4) {
        return new int[] { (int)n, (int)n2, (int)n3, (int)n4 };
    }
    
    public Object clone() {
        return super.clone();
    }
    
    static {
        DEFAULT_PAINT_SEQUENCE = ChartColor.createDefaultPaintArray();
        DEFAULT_OUTLINE_PAINT_SEQUENCE = new Paint[] { Color.lightGray };
        DEFAULT_STROKE_SEQUENCE = new Stroke[] { new BasicStroke(1.0f, 2, 2) };
        DEFAULT_OUTLINE_STROKE_SEQUENCE = new Stroke[] { new BasicStroke(1.0f, 2, 2) };
        DEFAULT_SHAPE_SEQUENCE = createStandardSeriesShapes();
    }
}
