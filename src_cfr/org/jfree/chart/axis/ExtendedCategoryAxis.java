/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextBlock;
import org.jfree.text.TextFragment;
import org.jfree.text.TextLine;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

public class ExtendedCategoryAxis
extends CategoryAxis {
    private Map sublabels = new HashMap();
    private Font sublabelFont = new Font("SansSerif", 0, 10);
    private transient Paint sublabelPaint = Color.black;

    public ExtendedCategoryAxis(String string) {
        super(string);
    }

    public Font getSubLabelFont() {
        return this.sublabelFont;
    }

    public void setSubLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.sublabelFont = font;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getSubLabelPaint() {
        return this.sublabelPaint;
    }

    public void setSubLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.sublabelPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public void addSubLabel(Comparable comparable, String string) {
        this.sublabels.put(comparable, string);
    }

    @Override
    protected TextBlock createLabel(Comparable comparable, float f2, RectangleEdge rectangleEdge, Graphics2D graphics2D) {
        TextLine textLine;
        TextBlock textBlock = super.createLabel(comparable, f2, rectangleEdge, graphics2D);
        String string = (String)this.sublabels.get(comparable);
        if (string == null) return textBlock;
        if (rectangleEdge == RectangleEdge.TOP || rectangleEdge == RectangleEdge.BOTTOM) {
            TextLine textLine2 = new TextLine(string, this.sublabelFont, this.sublabelPaint);
            textBlock.addLine(textLine2);
            return textBlock;
        }
        if (rectangleEdge != RectangleEdge.LEFT) {
            if (rectangleEdge != RectangleEdge.RIGHT) return textBlock;
        }
        if ((textLine = textBlock.getLastLine()) == null) return textBlock;
        textLine.addFragment(new TextFragment(new StringBuffer().append("  ").append(string).toString(), this.sublabelFont, this.sublabelPaint));
        return textBlock;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ExtendedCategoryAxis)) {
            return false;
        }
        ExtendedCategoryAxis extendedCategoryAxis = (ExtendedCategoryAxis)object;
        if (!this.sublabelFont.equals(extendedCategoryAxis.sublabelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.sublabelPaint, extendedCategoryAxis.sublabelPaint)) {
            return false;
        }
        if (this.sublabels.equals(extendedCategoryAxis.sublabels)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        ExtendedCategoryAxis extendedCategoryAxis = (ExtendedCategoryAxis)super.clone();
        extendedCategoryAxis.sublabels = new HashMap(this.sublabels);
        return extendedCategoryAxis;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.sublabelPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.sublabelPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

