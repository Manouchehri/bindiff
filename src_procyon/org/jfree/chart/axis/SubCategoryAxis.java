package org.jfree.chart.axis;

import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.text.*;
import java.awt.*;
import java.util.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import org.jfree.io.*;
import java.io.*;

public class SubCategoryAxis extends CategoryAxis implements Serializable, Cloneable
{
    private static final long serialVersionUID = -1279463299793228344L;
    private List subCategories;
    private Font subLabelFont;
    private transient Paint subLabelPaint;
    
    public SubCategoryAxis(final String s) {
        super(s);
        this.subLabelFont = new Font("SansSerif", 0, 10);
        this.subLabelPaint = Color.black;
        this.subCategories = new ArrayList();
    }
    
    public void addSubCategory(final Comparable comparable) {
        this.subCategories.add(comparable);
    }
    
    public Font getSubLabelFont() {
        return this.subLabelFont;
    }
    
    public void setSubLabelFont(final Font subLabelFont) {
        if (subLabelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.subLabelFont = subLabelFont;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Paint getSubLabelPaint() {
        return this.subLabelPaint;
    }
    
    public void setSubLabelPaint(final Paint subLabelPaint) {
        if (subLabelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.subLabelPaint = subLabelPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public AxisSpace reserveSpace(final Graphics2D graphics2D, final Plot plot, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, AxisSpace reserveSpace) {
        if (reserveSpace == null) {
            reserveSpace = new AxisSpace();
        }
        if (!this.isVisible()) {
            return reserveSpace;
        }
        reserveSpace = super.reserveSpace(graphics2D, plot, rectangle2D, rectangleEdge, reserveSpace);
        final double maxDim = this.getMaxDim(graphics2D, rectangleEdge);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            reserveSpace.add(maxDim, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            reserveSpace.add(maxDim, rectangleEdge);
        }
        return reserveSpace;
    }
    
    private double getMaxDim(final Graphics2D graphics2D, final RectangleEdge rectangleEdge) {
        double max = 0.0;
        graphics2D.setFont(this.subLabelFont);
        final FontMetrics fontMetrics = graphics2D.getFontMetrics();
        final Iterator<Comparable<?>> iterator = this.subCategories.iterator();
        while (iterator.hasNext()) {
            final Rectangle2D textBounds = TextUtilities.getTextBounds(iterator.next().toString(), graphics2D, fontMetrics);
            double n;
            if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
                n = textBounds.getWidth();
            }
            else {
                n = textBounds.getHeight();
            }
            max = Math.max(max, n);
        }
        return max;
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        if (!this.isVisible()) {
            return new AxisState(n);
        }
        if (this.isAxisLineVisible()) {
            this.drawAxisLine(graphics2D, n, rectangle2D2, rectangleEdge);
        }
        return this.drawLabel(this.getLabel(), graphics2D, rectangle2D, rectangle2D2, rectangleEdge, this.drawCategoryLabels(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, this.drawSubCategoryLabels(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, new AxisState(n), plotRenderingInfo), plotRenderingInfo));
    }
    
    protected AxisState drawSubCategoryLabels(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final AxisState axisState, final PlotRenderingInfo plotRenderingInfo) {
        if (axisState == null) {
            throw new IllegalArgumentException("Null 'state' argument.");
        }
        graphics2D.setFont(this.subLabelFont);
        graphics2D.setPaint(this.subLabelPaint);
        final int columnCount = ((CategoryPlot)this.getPlot()).getDataset().getColumnCount();
        final double maxDim = this.getMaxDim(graphics2D, rectangleEdge);
        for (int i = 0; i < columnCount; ++i) {
            double n = 0.0;
            double n2 = 0.0;
            double n3 = 0.0;
            double n4 = 0.0;
            if (rectangleEdge == RectangleEdge.TOP) {
                n = this.getCategoryStart(i, columnCount, rectangle2D2, rectangleEdge);
                n2 = this.getCategoryEnd(i, columnCount, rectangle2D2, rectangleEdge);
                n4 = axisState.getCursor();
                n3 = n4 - maxDim;
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                n = this.getCategoryStart(i, columnCount, rectangle2D2, rectangleEdge);
                n2 = this.getCategoryEnd(i, columnCount, rectangle2D2, rectangleEdge);
                n3 = axisState.getCursor();
                n4 = n3 + maxDim;
            }
            else if (rectangleEdge == RectangleEdge.LEFT) {
                n3 = this.getCategoryStart(i, columnCount, rectangle2D2, rectangleEdge);
                n4 = this.getCategoryEnd(i, columnCount, rectangle2D2, rectangleEdge);
                n2 = axisState.getCursor();
                n = n2 - maxDim;
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                n3 = this.getCategoryStart(i, columnCount, rectangle2D2, rectangleEdge);
                n4 = this.getCategoryEnd(i, columnCount, rectangle2D2, rectangleEdge);
                n = axisState.getCursor();
                n2 = n + maxDim;
            }
            final Rectangle2D.Double double1 = new Rectangle2D.Double(n, n3, n2 - n, n4 - n3);
            final int size = this.subCategories.size();
            final float n5 = (float)((n2 - n) / size);
            final float n6 = (float)((n4 - n3) / size);
            for (int j = 0; j < size; ++j) {
                float n7;
                float n8;
                if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
                    n7 = (float)(n + (j + 0.5) * n5);
                    n8 = (float)double1.getCenterY();
                }
                else {
                    n7 = (float)double1.getCenterX();
                    n8 = (float)(n3 + (j + 0.5) * n6);
                }
                TextUtilities.drawRotatedString(this.subCategories.get(j).toString(), graphics2D, n7, n8, TextAnchor.CENTER, 0.0, TextAnchor.CENTER);
            }
        }
        if (rectangleEdge.equals(RectangleEdge.TOP)) {
            axisState.cursorUp(maxDim);
        }
        else if (rectangleEdge.equals(RectangleEdge.BOTTOM)) {
            axisState.cursorDown(maxDim);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            axisState.cursorLeft(maxDim);
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            axisState.cursorRight(maxDim);
        }
        return axisState;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SubCategoryAxis && super.equals(o)) {
            final SubCategoryAxis subCategoryAxis = (SubCategoryAxis)o;
            return this.subCategories.equals(subCategoryAxis.subCategories) && this.subLabelFont.equals(subCategoryAxis.subLabelFont) && this.subLabelPaint.equals(subCategoryAxis.subLabelPaint);
        }
        return false;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.subLabelPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.subLabelPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
