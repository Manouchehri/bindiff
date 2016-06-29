/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockFrame;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class LineBorder
implements Serializable,
BlockFrame {
    private transient Paint paint;
    private transient Stroke stroke;
    private RectangleInsets insets;

    public LineBorder() {
        this(Color.black, new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
    }

    public LineBorder(Paint paint, Stroke stroke, RectangleInsets rectangleInsets) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        this.paint = paint;
        this.stroke = stroke;
        this.insets = rectangleInsets;
    }

    public Paint getPaint() {
        return this.paint;
    }

    @Override
    public RectangleInsets getInsets() {
        return this.insets;
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        double d2 = rectangle2D.getWidth();
        double d3 = rectangle2D.getHeight();
        double d4 = this.insets.calculateTopInset(d3);
        double d5 = this.insets.calculateBottomInset(d3);
        double d6 = this.insets.calculateLeftInset(d2);
        double d7 = this.insets.calculateRightInset(d2);
        double d8 = rectangle2D.getX();
        double d9 = rectangle2D.getY();
        double d10 = d8 + d6 / 2.0;
        double d11 = d8 + d2 - d7 / 2.0;
        double d12 = d9 + d3 - d5 / 2.0;
        double d13 = d9 + d4 / 2.0;
        graphics2D.setPaint(this.getPaint());
        graphics2D.setStroke(this.getStroke());
        Line2D.Double double_ = new Line2D.Double();
        if (d4 > 0.0) {
            double_.setLine(d10, d13, d11, d13);
            graphics2D.draw(double_);
        }
        if (d5 > 0.0) {
            double_.setLine(d10, d12, d11, d12);
            graphics2D.draw(double_);
        }
        if (d6 > 0.0) {
            double_.setLine(d10, d12, d10, d13);
            graphics2D.draw(double_);
        }
        if (d7 <= 0.0) return;
        double_.setLine(d11, d12, d11, d13);
        graphics2D.draw(double_);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LineBorder)) {
            return false;
        }
        LineBorder lineBorder = (LineBorder)object;
        if (!PaintUtilities.equal(this.paint, lineBorder.paint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.stroke, lineBorder.stroke)) {
            return false;
        }
        if (this.insets.equals(lineBorder.insets)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
    }
}

