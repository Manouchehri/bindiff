package org.jfree.chart.axis;

import java.util.*;
import org.jfree.chart.event.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.text.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class ExtendedCategoryAxis extends CategoryAxis
{
    private Map sublabels;
    private Font sublabelFont;
    private transient Paint sublabelPaint;
    
    public ExtendedCategoryAxis(final String s) {
        super(s);
        this.sublabels = new HashMap();
        this.sublabelFont = new Font("SansSerif", 0, 10);
        this.sublabelPaint = Color.black;
    }
    
    public Font getSubLabelFont() {
        return this.sublabelFont;
    }
    
    public void setSubLabelFont(final Font sublabelFont) {
        if (sublabelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.sublabelFont = sublabelFont;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Paint getSubLabelPaint() {
        return this.sublabelPaint;
    }
    
    public void setSubLabelPaint(final Paint sublabelPaint) {
        if (sublabelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.sublabelPaint = sublabelPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public void addSubLabel(final Comparable comparable, final String s) {
        this.sublabels.put(comparable, s);
    }
    
    protected TextBlock createLabel(final Comparable comparable, final float n, final RectangleEdge rectangleEdge, final Graphics2D graphics2D) {
        final TextBlock label = super.createLabel(comparable, n, rectangleEdge, graphics2D);
        final String s = this.sublabels.get(comparable);
        if (s != null) {
            if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
                label.addLine(new TextLine(s, this.sublabelFont, this.sublabelPaint));
            }
            else if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                final TextLine lastLine = label.getLastLine();
                if (lastLine != null) {
                    lastLine.addFragment(new TextFragment("  " + s, this.sublabelFont, this.sublabelPaint));
                }
            }
        }
        return label;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ExtendedCategoryAxis)) {
            return false;
        }
        final ExtendedCategoryAxis extendedCategoryAxis = (ExtendedCategoryAxis)o;
        return this.sublabelFont.equals(extendedCategoryAxis.sublabelFont) && PaintUtilities.equal(this.sublabelPaint, extendedCategoryAxis.sublabelPaint) && this.sublabels.equals(extendedCategoryAxis.sublabels) && super.equals(o);
    }
    
    public Object clone() {
        final ExtendedCategoryAxis extendedCategoryAxis = (ExtendedCategoryAxis)super.clone();
        extendedCategoryAxis.sublabels = new HashMap(this.sublabels);
        return extendedCategoryAxis;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.sublabelPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.sublabelPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
