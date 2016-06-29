/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockFrame;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.PaintUtilities;

public class BlockBorder
implements Serializable,
BlockFrame {
    private static final long serialVersionUID = 4961579220410228283L;
    public static final BlockBorder NONE = new BlockBorder(RectangleInsets.ZERO_INSETS, Color.white);
    private RectangleInsets insets;
    private transient Paint paint;

    public BlockBorder() {
        this(Color.black);
    }

    public BlockBorder(Paint paint) {
        this(new RectangleInsets(1.0, 1.0, 1.0, 1.0), paint);
    }

    public BlockBorder(double d2, double d3, double d4, double d5) {
        this(new RectangleInsets(d2, d3, d4, d5), Color.black);
    }

    public BlockBorder(double d2, double d3, double d4, double d5, Paint paint) {
        this(new RectangleInsets(d2, d3, d4, d5), paint);
    }

    public BlockBorder(RectangleInsets rectangleInsets, Paint paint) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.insets = rectangleInsets;
        this.paint = paint;
    }

    @Override
    public RectangleInsets getInsets() {
        return this.insets;
    }

    public Paint getPaint() {
        return this.paint;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        double d2 = this.insets.calculateTopInset(rectangle2D.getHeight());
        double d3 = this.insets.calculateBottomInset(rectangle2D.getHeight());
        double d4 = this.insets.calculateLeftInset(rectangle2D.getWidth());
        double d5 = this.insets.calculateRightInset(rectangle2D.getWidth());
        double d6 = rectangle2D.getX();
        double d7 = rectangle2D.getY();
        double d8 = rectangle2D.getWidth();
        double d9 = rectangle2D.getHeight();
        graphics2D.setPaint(this.paint);
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        if (d2 > 0.0) {
            double_.setRect(d6, d7, d8, d2);
            graphics2D.fill(double_);
        }
        if (d3 > 0.0) {
            double_.setRect(d6, d7 + d9 - d3, d8, d3);
            graphics2D.fill(double_);
        }
        if (d4 > 0.0) {
            double_.setRect(d6, d7, d4, d9);
            graphics2D.fill(double_);
        }
        if (d5 <= 0.0) return;
        double_.setRect(d6 + d8 - d5, d7, d5, d9);
        graphics2D.fill(double_);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BlockBorder)) {
            return false;
        }
        BlockBorder blockBorder = (BlockBorder)object;
        if (!this.insets.equals(blockBorder.insets)) {
            return false;
        }
        if (PaintUtilities.equal(this.paint, blockBorder.paint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
    }
}

