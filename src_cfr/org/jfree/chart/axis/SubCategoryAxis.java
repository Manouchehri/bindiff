/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class SubCategoryAxis
extends CategoryAxis
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -1279463299793228344L;
    private List subCategories = new ArrayList();
    private Font subLabelFont = new Font("SansSerif", 0, 10);
    private transient Paint subLabelPaint = Color.black;

    public SubCategoryAxis(String string) {
        super(string);
    }

    public void addSubCategory(Comparable comparable) {
        this.subCategories.add(comparable);
    }

    public Font getSubLabelFont() {
        return this.subLabelFont;
    }

    public void setSubLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.subLabelFont = font;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getSubLabelPaint() {
        return this.subLabelPaint;
    }

    public void setSubLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.subLabelPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    public AxisSpace reserveSpace(Graphics2D graphics2D, Plot plot, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        if (axisSpace == null) {
            axisSpace = new AxisSpace();
        }
        if (!this.isVisible()) {
            return axisSpace;
        }
        axisSpace = super.reserveSpace(graphics2D, plot, rectangle2D, rectangleEdge, axisSpace);
        double d2 = this.getMaxDim(graphics2D, rectangleEdge);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            axisSpace.add(d2, rectangleEdge);
            return axisSpace;
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return axisSpace;
        axisSpace.add(d2, rectangleEdge);
        return axisSpace;
    }

    private double getMaxDim(Graphics2D graphics2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        graphics2D.setFont(this.subLabelFont);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Iterator iterator = this.subCategories.iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            String string = comparable.toString();
            Rectangle2D rectangle2D = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
            double d3 = 0.0;
            d3 = RectangleEdge.isLeftOrRight(rectangleEdge) ? rectangle2D.getWidth() : rectangle2D.getHeight();
            d2 = Math.max(d2, d3);
        }
        return d2;
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            return new AxisState(d2);
        }
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, d2, rectangle2D2, rectangleEdge);
        }
        AxisState axisState = new AxisState(d2);
        axisState = this.drawSubCategoryLabels(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState, plotRenderingInfo);
        axisState = this.drawCategoryLabels(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState, plotRenderingInfo);
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState);
    }

    protected AxisState drawSubCategoryLabels(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, AxisState axisState, PlotRenderingInfo plotRenderingInfo) {
        if (axisState == null) {
            throw new IllegalArgumentException("Null 'state' argument.");
        }
        graphics2D.setFont(this.subLabelFont);
        graphics2D.setPaint(this.subLabelPaint);
        CategoryPlot categoryPlot = (CategoryPlot)this.getPlot();
        CategoryDataset categoryDataset = categoryPlot.getDataset();
        int n2 = categoryDataset.getColumnCount();
        double d2 = this.getMaxDim(graphics2D, rectangleEdge);
        int n3 = 0;
        do {
            double d3;
            double d4;
            float f2;
            float f3;
            int n4;
            float f4;
            Rectangle2D.Double double_;
            float f5;
            if (n3 < n2) {
                d3 = 0.0;
                double d5 = 0.0;
                d4 = 0.0;
                double d6 = 0.0;
                if (rectangleEdge == RectangleEdge.TOP) {
                    d3 = this.getCategoryStart(n3, n2, rectangle2D2, rectangleEdge);
                    d5 = this.getCategoryEnd(n3, n2, rectangle2D2, rectangleEdge);
                    d6 = axisState.getCursor();
                    d4 = d6 - d2;
                } else if (rectangleEdge == RectangleEdge.BOTTOM) {
                    d3 = this.getCategoryStart(n3, n2, rectangle2D2, rectangleEdge);
                    d5 = this.getCategoryEnd(n3, n2, rectangle2D2, rectangleEdge);
                    d4 = axisState.getCursor();
                    d6 = d4 + d2;
                } else if (rectangleEdge == RectangleEdge.LEFT) {
                    d4 = this.getCategoryStart(n3, n2, rectangle2D2, rectangleEdge);
                    d6 = this.getCategoryEnd(n3, n2, rectangle2D2, rectangleEdge);
                    d5 = axisState.getCursor();
                    d3 = d5 - d2;
                } else if (rectangleEdge == RectangleEdge.RIGHT) {
                    d4 = this.getCategoryStart(n3, n2, rectangle2D2, rectangleEdge);
                    d6 = this.getCategoryEnd(n3, n2, rectangle2D2, rectangleEdge);
                    d3 = axisState.getCursor();
                    d5 = d3 + d2;
                }
                double_ = new Rectangle2D.Double(d3, d4, d5 - d3, d6 - d4);
                n4 = this.subCategories.size();
                f3 = (float)((d5 - d3) / (double)n4);
                f2 = (float)((d6 - d4) / (double)n4);
                f4 = 0.0f;
                f5 = 0.0f;
            } else {
                if (rectangleEdge.equals(RectangleEdge.TOP)) {
                    double d7 = d2;
                    axisState.cursorUp(d7);
                    return axisState;
                }
                if (rectangleEdge.equals(RectangleEdge.BOTTOM)) {
                    double d8 = d2;
                    axisState.cursorDown(d8);
                    return axisState;
                }
                if (rectangleEdge == RectangleEdge.LEFT) {
                    double d9 = d2;
                    axisState.cursorLeft(d9);
                    return axisState;
                }
                if (rectangleEdge != RectangleEdge.RIGHT) return axisState;
                double d10 = d2;
                axisState.cursorRight(d10);
                return axisState;
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
                    f4 = (float)(d3 + ((double)i2 + 0.5) * (double)f3);
                    f5 = (float)double_.getCenterY();
                } else {
                    f4 = (float)double_.getCenterX();
                    f5 = (float)(d4 + ((double)i2 + 0.5) * (double)f2);
                }
                String string = this.subCategories.get(i2).toString();
                TextUtilities.drawRotatedString(string, graphics2D, f4, f5, TextAnchor.CENTER, 0.0, TextAnchor.CENTER);
            }
            ++n3;
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SubCategoryAxis)) return false;
        if (!super.equals(object)) return false;
        SubCategoryAxis subCategoryAxis = (SubCategoryAxis)object;
        if (!this.subCategories.equals(subCategoryAxis.subCategories)) {
            return false;
        }
        if (!this.subLabelFont.equals(subCategoryAxis.subLabelFont)) {
            return false;
        }
        if (this.subLabelPaint.equals(subCategoryAxis.subLabelPaint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.subLabelPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.subLabelPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

