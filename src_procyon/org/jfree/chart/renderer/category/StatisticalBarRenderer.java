package org.jfree.chart.renderer.category;

import org.jfree.chart.event.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.data.statistics.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class StatisticalBarRenderer extends BarRenderer implements Serializable, Cloneable, CategoryItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -4986038395414039117L;
    private transient Paint errorIndicatorPaint;
    
    public StatisticalBarRenderer() {
        this.errorIndicatorPaint = Color.gray;
    }
    
    public Paint getErrorIndicatorPaint() {
        return this.errorIndicatorPaint;
    }
    
    public void setErrorIndicatorPaint(final Paint errorIndicatorPaint) {
        this.errorIndicatorPaint = errorIndicatorPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (!(categoryDataset instanceof StatisticalCategoryDataset)) {
            throw new IllegalArgumentException("Requires StatisticalCategoryDataset.");
        }
        final StatisticalCategoryDataset statisticalCategoryDataset = (StatisticalCategoryDataset)categoryDataset;
        final PlotOrientation orientation = categoryPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, statisticalCategoryDataset, n, n2);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            this.drawVerticalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, statisticalCategoryDataset, n, n2);
        }
    }
    
    protected void drawHorizontalItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final StatisticalCategoryDataset statisticalCategoryDataset, final int n, final int n2) {
        final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        double n3;
        if (rowCount > 1) {
            n3 = categoryStart + n * (categoryItemRendererState.getBarWidth() + rectangle2D.getHeight() * this.getItemMargin() / (columnCount * (rowCount - 1)));
        }
        else {
            n3 = categoryStart + n * categoryItemRendererState.getBarWidth();
        }
        final Number meanValue = statisticalCategoryDataset.getMeanValue(n, n2);
        double doubleValue = meanValue.doubleValue();
        double lowerClip = 0.0;
        final double lowerClip2 = this.getLowerClip();
        final double upperClip = this.getUpperClip();
        if (upperClip <= 0.0) {
            if (doubleValue >= upperClip) {
                return;
            }
            lowerClip = upperClip;
            if (doubleValue <= lowerClip2) {
                doubleValue = lowerClip2;
            }
        }
        else if (lowerClip2 <= 0.0) {
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
            else if (doubleValue <= lowerClip2) {
                doubleValue = lowerClip2;
            }
        }
        else {
            if (doubleValue <= lowerClip2) {
                return;
            }
            lowerClip = this.getLowerClip();
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(lowerClip, rectangle2D, rangeAxisEdge);
        final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge);
        final double min = Math.min(valueToJava2D2, valueToJava2D);
        final double barWidth = categoryItemRendererState.getBarWidth();
        final Rectangle2D.Double double1 = new Rectangle2D.Double(min, n3, Math.abs(valueToJava2D2 - valueToJava2D), barWidth);
        graphics2D.setPaint(this.getItemPaint(n, n2));
        graphics2D.fill(double1);
        if (categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(double1);
        }
        final double doubleValue2 = statisticalCategoryDataset.getStdDevValue(n, n2).doubleValue();
        final double valueToJava2D3 = valueAxis.valueToJava2D(meanValue.doubleValue() + doubleValue2, rectangle2D, rangeAxisEdge);
        final double valueToJava2D4 = valueAxis.valueToJava2D(meanValue.doubleValue() - doubleValue2, rectangle2D, rangeAxisEdge);
        if (this.errorIndicatorPaint != null) {
            graphics2D.setPaint(this.errorIndicatorPaint);
        }
        else {
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
        }
        graphics2D.draw(new Line2D.Double(valueToJava2D4, n3 + barWidth / 2.0, valueToJava2D3, n3 + barWidth / 2.0));
        graphics2D.draw(new Line2D.Double(valueToJava2D3, n3 + barWidth * 0.25, valueToJava2D3, n3 + barWidth * 0.75));
        graphics2D.draw(new Line2D.Double(valueToJava2D4, n3 + barWidth * 0.25, valueToJava2D4, n3 + barWidth * 0.75));
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, statisticalCategoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, doubleValue < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            this.addItemEntity(entityCollection, statisticalCategoryDataset, n, n2, double1);
        }
    }
    
    protected void drawVerticalItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final StatisticalCategoryDataset statisticalCategoryDataset, final int n, final int n2) {
        final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        double n3;
        if (rowCount > 1) {
            n3 = categoryStart + n * (categoryItemRendererState.getBarWidth() + rectangle2D.getWidth() * this.getItemMargin() / (columnCount * (rowCount - 1)));
        }
        else {
            n3 = categoryStart + n * categoryItemRendererState.getBarWidth();
        }
        final Number meanValue = statisticalCategoryDataset.getMeanValue(n, n2);
        double doubleValue = meanValue.doubleValue();
        double lowerClip = 0.0;
        final double lowerClip2 = this.getLowerClip();
        final double upperClip = this.getUpperClip();
        if (upperClip <= 0.0) {
            if (doubleValue >= upperClip) {
                return;
            }
            lowerClip = upperClip;
            if (doubleValue <= lowerClip2) {
                doubleValue = lowerClip2;
            }
        }
        else if (lowerClip2 <= 0.0) {
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
            else if (doubleValue <= lowerClip2) {
                doubleValue = lowerClip2;
            }
        }
        else {
            if (doubleValue <= lowerClip2) {
                return;
            }
            lowerClip = this.getLowerClip();
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(lowerClip, rectangle2D, rangeAxisEdge);
        final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge);
        final double min = Math.min(valueToJava2D2, valueToJava2D);
        final double barWidth = categoryItemRendererState.getBarWidth();
        final Rectangle2D.Double double1 = new Rectangle2D.Double(n3, min, barWidth, Math.abs(valueToJava2D2 - valueToJava2D));
        graphics2D.setPaint(this.getItemPaint(n, n2));
        graphics2D.fill(double1);
        if (categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(double1);
        }
        final double doubleValue2 = statisticalCategoryDataset.getStdDevValue(n, n2).doubleValue();
        final double valueToJava2D3 = valueAxis.valueToJava2D(meanValue.doubleValue() + doubleValue2, rectangle2D, rangeAxisEdge);
        final double valueToJava2D4 = valueAxis.valueToJava2D(meanValue.doubleValue() - doubleValue2, rectangle2D, rangeAxisEdge);
        if (this.errorIndicatorPaint != null) {
            graphics2D.setPaint(this.errorIndicatorPaint);
        }
        else {
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
        }
        graphics2D.draw(new Line2D.Double(n3 + barWidth / 2.0, valueToJava2D4, n3 + barWidth / 2.0, valueToJava2D3));
        graphics2D.draw(new Line2D.Double(n3 + barWidth / 2.0 - 5.0, valueToJava2D3, n3 + barWidth / 2.0 + 5.0, valueToJava2D3));
        graphics2D.draw(new Line2D.Double(n3 + barWidth / 2.0 - 5.0, valueToJava2D4, n3 + barWidth / 2.0 + 5.0, valueToJava2D4));
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, statisticalCategoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, doubleValue < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            this.addItemEntity(entityCollection, statisticalCategoryDataset, n, n2, double1);
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StatisticalBarRenderer && super.equals(o) && PaintUtilities.equal(this.errorIndicatorPaint, ((StatisticalBarRenderer)o).errorIndicatorPaint));
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.errorIndicatorPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.errorIndicatorPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
