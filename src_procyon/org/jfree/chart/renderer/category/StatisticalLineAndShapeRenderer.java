package org.jfree.chart.renderer.category;

import org.jfree.chart.event.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.data.statistics.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class StatisticalLineAndShapeRenderer extends LineAndShapeRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -3557517173697777579L;
    private transient Paint errorIndicatorPaint;
    
    public StatisticalLineAndShapeRenderer() {
        this(true, true);
    }
    
    public StatisticalLineAndShapeRenderer(final boolean b, final boolean b2) {
        super(b, b2);
        this.errorIndicatorPaint = null;
    }
    
    public Paint getErrorIndicatorPaint() {
        return this.errorIndicatorPaint;
    }
    
    public void setErrorIndicatorPaint(final Paint errorIndicatorPaint) {
        this.errorIndicatorPaint = errorIndicatorPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (categoryDataset.getValue(n, n2) == null) {
            return;
        }
        final StatisticalCategoryDataset statisticalCategoryDataset = (StatisticalCategoryDataset)categoryDataset;
        final Number meanValue = statisticalCategoryDataset.getMeanValue(n, n2);
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double categoryMiddle = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double valueToJava2D = valueAxis.valueToJava2D(meanValue.doubleValue(), rectangle2D, categoryPlot.getRangeAxisEdge());
        Shape shape = this.getItemShape(n, n2);
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D, categoryMiddle);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, categoryMiddle, valueToJava2D);
        }
        if (this.getItemShapeVisible(n, n2)) {
            if (this.getItemShapeFilled(n, n2)) {
                graphics2D.setPaint(this.getItemPaint(n, n2));
                graphics2D.fill(shape);
            }
            else {
                if (this.getUseOutlinePaint()) {
                    graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                }
                else {
                    graphics2D.setPaint(this.getItemPaint(n, n2));
                }
                graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
                graphics2D.draw(shape);
            }
        }
        if (this.getItemLineVisible(n, n2) && n2 != 0) {
            final Number value = statisticalCategoryDataset.getValue(n, n2 - 1);
            if (value != null) {
                final double doubleValue = value.doubleValue();
                final double categoryMiddle2 = categoryAxis.getCategoryMiddle(n2 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
                final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge());
                Shape shape2 = null;
                if (orientation == PlotOrientation.HORIZONTAL) {
                    shape2 = new Line2D.Double(valueToJava2D2, categoryMiddle2, valueToJava2D, categoryMiddle);
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    shape2 = new Line2D.Double(categoryMiddle2, valueToJava2D2, categoryMiddle, valueToJava2D);
                }
                graphics2D.setPaint(this.getItemPaint(n, n2));
                graphics2D.setStroke(this.getItemStroke(n, n2));
                graphics2D.draw(shape2);
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double n4 = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) + n * categoryItemRendererState.getBarWidth();
        graphics2D.setPaint(this.getItemPaint(n, n2));
        final double doubleValue2 = statisticalCategoryDataset.getStdDevValue(n, n2).doubleValue();
        double n5;
        if (meanValue.doubleValue() + doubleValue2 > valueAxis.getRange().getUpperBound()) {
            n5 = valueAxis.valueToJava2D(valueAxis.getRange().getUpperBound(), rectangle2D, rangeAxisEdge);
        }
        else {
            n5 = valueAxis.valueToJava2D(meanValue.doubleValue() + doubleValue2, rectangle2D, rangeAxisEdge);
        }
        double n6;
        if (meanValue.doubleValue() + doubleValue2 < valueAxis.getRange().getLowerBound()) {
            n6 = valueAxis.valueToJava2D(valueAxis.getRange().getLowerBound(), rectangle2D, rangeAxisEdge);
        }
        else {
            n6 = valueAxis.valueToJava2D(meanValue.doubleValue() - doubleValue2, rectangle2D, rangeAxisEdge);
        }
        if (this.errorIndicatorPaint != null) {
            graphics2D.setPaint(this.errorIndicatorPaint);
        }
        else {
            graphics2D.setPaint(this.getItemPaint(n, n2));
        }
        final Line2D.Double double1 = new Line2D.Double();
        if (orientation == PlotOrientation.HORIZONTAL) {
            double1.setLine(n6, categoryMiddle, n5, categoryMiddle);
            graphics2D.draw(double1);
            double1.setLine(n6, categoryMiddle - 5.0, n6, categoryMiddle + 5.0);
            graphics2D.draw(double1);
            double1.setLine(n5, categoryMiddle - 5.0, n5, categoryMiddle + 5.0);
            graphics2D.draw(double1);
        }
        else {
            double1.setLine(categoryMiddle, n6, categoryMiddle, n5);
            graphics2D.draw(double1);
            double1.setLine(categoryMiddle - 5.0, n5, categoryMiddle + 5.0, n5);
            graphics2D.draw(double1);
            double1.setLine(categoryMiddle - 5.0, n6, categoryMiddle + 5.0, n6);
            graphics2D.draw(double1);
        }
        if (this.isItemLabelVisible(n, n2)) {
            if (orientation == PlotOrientation.HORIZONTAL) {
                this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, valueToJava2D, categoryMiddle, meanValue.doubleValue() < 0.0);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, categoryMiddle, valueToJava2D, meanValue.doubleValue() < 0.0);
            }
        }
        if (categoryItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null && shape != null) {
                String generateToolTip = null;
                final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(categoryDataset, n, n2);
                }
                String generateURL = null;
                if (this.getItemURLGenerator(n, n2) != null) {
                    generateURL = this.getItemURLGenerator(n, n2).generateURL(categoryDataset, n, n2);
                }
                entityCollection.add(new CategoryItemEntity(shape, generateToolTip, generateURL, categoryDataset, n, categoryDataset.getColumnKey(n2), n2));
            }
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StatisticalLineAndShapeRenderer && super.equals(o) && PaintUtilities.equal(this.errorIndicatorPaint, ((StatisticalLineAndShapeRenderer)o).errorIndicatorPaint));
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
