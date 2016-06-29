package org.jfree.chart.block;

import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class LineBorder implements Serializable, BlockFrame
{
    private transient Paint paint;
    private transient Stroke stroke;
    private RectangleInsets insets;
    
    public LineBorder() {
        this(Color.black, new BasicStroke(1.0f), new RectangleInsets(1.0, 1.0, 1.0, 1.0));
    }
    
    public LineBorder(final Paint paint, final Stroke stroke, final RectangleInsets insets) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (insets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        this.paint = paint;
        this.stroke = stroke;
        this.insets = insets;
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public RectangleInsets getInsets() {
        return this.insets;
    }
    
    public Stroke getStroke() {
        return this.stroke;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        final double width = rectangle2D.getWidth();
        final double height = rectangle2D.getHeight();
        final double calculateTopInset = this.insets.calculateTopInset(height);
        final double calculateBottomInset = this.insets.calculateBottomInset(height);
        final double calculateLeftInset = this.insets.calculateLeftInset(width);
        final double calculateRightInset = this.insets.calculateRightInset(width);
        final double x = rectangle2D.getX();
        final double y = rectangle2D.getY();
        final double n = x + calculateLeftInset / 2.0;
        final double n2 = x + width - calculateRightInset / 2.0;
        final double n3 = y + height - calculateBottomInset / 2.0;
        final double n4 = y + calculateTopInset / 2.0;
        graphics2D.setPaint(this.getPaint());
        graphics2D.setStroke(this.getStroke());
        final Line2D.Double double1 = new Line2D.Double();
        if (calculateTopInset > 0.0) {
            double1.setLine(n, n4, n2, n4);
            graphics2D.draw(double1);
        }
        if (calculateBottomInset > 0.0) {
            double1.setLine(n, n3, n2, n3);
            graphics2D.draw(double1);
        }
        if (calculateLeftInset > 0.0) {
            double1.setLine(n, n3, n, n4);
            graphics2D.draw(double1);
        }
        if (calculateRightInset > 0.0) {
            double1.setLine(n2, n3, n2, n4);
            graphics2D.draw(double1);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LineBorder)) {
            return false;
        }
        final LineBorder lineBorder = (LineBorder)o;
        return PaintUtilities.equal(this.paint, lineBorder.paint) && ObjectUtilities.equal(this.stroke, lineBorder.stroke) && this.insets.equals(lineBorder.insets);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
    }
}
