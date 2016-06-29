package org.jfree.chart.block;

import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class BlockBorder implements Serializable, BlockFrame
{
    private static final long serialVersionUID = 4961579220410228283L;
    public static final BlockBorder NONE;
    private RectangleInsets insets;
    private transient Paint paint;
    
    public BlockBorder() {
        this(Color.black);
    }
    
    public BlockBorder(final Paint paint) {
        this(new RectangleInsets(1.0, 1.0, 1.0, 1.0), paint);
    }
    
    public BlockBorder(final double n, final double n2, final double n3, final double n4) {
        this(new RectangleInsets(n, n2, n3, n4), Color.black);
    }
    
    public BlockBorder(final double n, final double n2, final double n3, final double n4, final Paint paint) {
        this(new RectangleInsets(n, n2, n3, n4), paint);
    }
    
    public BlockBorder(final RectangleInsets insets, final Paint paint) {
        if (insets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.insets = insets;
        this.paint = paint;
    }
    
    public RectangleInsets getInsets() {
        return this.insets;
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final double calculateTopInset = this.insets.calculateTopInset(rectangle2D.getHeight());
        final double calculateBottomInset = this.insets.calculateBottomInset(rectangle2D.getHeight());
        final double calculateLeftInset = this.insets.calculateLeftInset(rectangle2D.getWidth());
        final double calculateRightInset = this.insets.calculateRightInset(rectangle2D.getWidth());
        final double x = rectangle2D.getX();
        final double y = rectangle2D.getY();
        final double width = rectangle2D.getWidth();
        final double height = rectangle2D.getHeight();
        graphics2D.setPaint(this.paint);
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        if (calculateTopInset > 0.0) {
            double1.setRect(x, y, width, calculateTopInset);
            graphics2D.fill(double1);
        }
        if (calculateBottomInset > 0.0) {
            double1.setRect(x, y + height - calculateBottomInset, width, calculateBottomInset);
            graphics2D.fill(double1);
        }
        if (calculateLeftInset > 0.0) {
            double1.setRect(x, y, calculateLeftInset, height);
            graphics2D.fill(double1);
        }
        if (calculateRightInset > 0.0) {
            double1.setRect(x + width - calculateRightInset, y, calculateRightInset, height);
            graphics2D.fill(double1);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockBorder)) {
            return false;
        }
        final BlockBorder blockBorder = (BlockBorder)o;
        return this.insets.equals(blockBorder.insets) && PaintUtilities.equal(this.paint, blockBorder.paint);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        NONE = new BlockBorder(RectangleInsets.ZERO_INSETS, Color.white);
    }
}
