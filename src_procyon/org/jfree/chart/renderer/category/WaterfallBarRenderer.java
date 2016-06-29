package org.jfree.chart.renderer.category;

import org.jfree.data.category.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class WaterfallBarRenderer extends BarRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -2482910643727230911L;
    private transient Paint firstBarPaint;
    private transient Paint lastBarPaint;
    private transient Paint positiveBarPaint;
    private transient Paint negativeBarPaint;
    
    public WaterfallBarRenderer() {
        this(new GradientPaint(0.0f, 0.0f, new Color(34, 34, 255), 0.0f, 0.0f, new Color(102, 102, 255)), new GradientPaint(0.0f, 0.0f, new Color(34, 255, 34), 0.0f, 0.0f, new Color(102, 255, 102)), new GradientPaint(0.0f, 0.0f, new Color(255, 34, 34), 0.0f, 0.0f, new Color(255, 102, 102)), new GradientPaint(0.0f, 0.0f, new Color(255, 255, 34), 0.0f, 0.0f, new Color(255, 255, 102)));
    }
    
    public WaterfallBarRenderer(final Paint firstBarPaint, final Paint positiveBarPaint, final Paint negativeBarPaint, final Paint lastBarPaint) {
        if (firstBarPaint == null) {
            throw new IllegalArgumentException("Null 'firstBarPaint' argument");
        }
        if (positiveBarPaint == null) {
            throw new IllegalArgumentException("Null 'positiveBarPaint' argument");
        }
        if (negativeBarPaint == null) {
            throw new IllegalArgumentException("Null 'negativeBarPaint' argument");
        }
        if (lastBarPaint == null) {
            throw new IllegalArgumentException("Null 'lastBarPaint' argument");
        }
        this.firstBarPaint = firstBarPaint;
        this.lastBarPaint = lastBarPaint;
        this.positiveBarPaint = positiveBarPaint;
        this.negativeBarPaint = negativeBarPaint;
        this.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        this.setMinimumBarLength(1.0);
    }
    
    public Range findRangeBounds(final CategoryDataset categoryDataset) {
        return DatasetUtilities.findCumulativeRangeBounds(categoryDataset);
    }
    
    public Paint getFirstBarPaint() {
        return this.firstBarPaint;
    }
    
    public void setFirstBarPaint(final Paint firstBarPaint) {
        if (firstBarPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.firstBarPaint = firstBarPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getLastBarPaint() {
        return this.lastBarPaint;
    }
    
    public void setLastBarPaint(final Paint lastBarPaint) {
        if (lastBarPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.lastBarPaint = lastBarPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getPositiveBarPaint() {
        return this.positiveBarPaint;
    }
    
    public void setPositiveBarPaint(final Paint positiveBarPaint) {
        if (positiveBarPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.positiveBarPaint = positiveBarPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getNegativeBarPaint() {
        return this.negativeBarPaint;
    }
    
    public void setNegativeBarPaint(final Paint negativeBarPaint) {
        if (negativeBarPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.negativeBarPaint = negativeBarPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        double seriesRunningTotal = categoryItemRendererState.getSeriesRunningTotal();
        if (n2 == categoryDataset.getColumnCount() - 1) {
            seriesRunningTotal = 0.0;
        }
        double seriesRunningTotal2 = 0.0;
        final Number value = categoryDataset.getValue(n, n2);
        if (value != null) {
            seriesRunningTotal2 = seriesRunningTotal + value.doubleValue();
        }
        categoryItemRendererState.setSeriesRunningTotal(seriesRunningTotal2);
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        final PlotOrientation orientation = categoryPlot.getOrientation();
        double n4 = 0.0;
        double n5 = 0.0;
        final RectangleEdge domainAxisEdge = categoryPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        double valueToJava2D = valueAxis.valueToJava2D(seriesRunningTotal, rectangle2D, rangeAxisEdge);
        double valueToJava2D2 = valueAxis.valueToJava2D(seriesRunningTotal2, rectangle2D, rangeAxisEdge);
        final double n6 = seriesRunningTotal2 - seriesRunningTotal;
        if (valueToJava2D2 < valueToJava2D) {
            final double n7 = valueToJava2D2;
            valueToJava2D2 = valueToJava2D;
            valueToJava2D = n7;
        }
        double n8 = categoryItemRendererState.getBarWidth();
        double n9 = Math.max(this.getMinimumBarLength(), Math.abs(valueToJava2D2 - valueToJava2D));
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, domainAxisEdge);
            if (rowCount > 1) {
                n5 = categoryStart + n * (categoryItemRendererState.getBarWidth() + rectangle2D.getHeight() * this.getItemMargin() / (columnCount * (rowCount - 1)));
            }
            else {
                n5 = categoryStart + n * categoryItemRendererState.getBarWidth();
            }
            n4 = valueToJava2D;
            n9 = categoryItemRendererState.getBarWidth();
            n8 = Math.max(this.getMinimumBarLength(), Math.abs(valueToJava2D2 - valueToJava2D));
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            final double categoryStart2 = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, domainAxisEdge);
            if (rowCount > 1) {
                n4 = categoryStart2 + n * (categoryItemRendererState.getBarWidth() + rectangle2D.getWidth() * this.getItemMargin() / (columnCount * (rowCount - 1)));
            }
            else {
                n4 = categoryStart2 + n * categoryItemRendererState.getBarWidth();
            }
            n5 = valueToJava2D;
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(n4, n5, n8, n9);
        this.getFirstBarPaint();
        Paint paint;
        if (n2 == 0) {
            paint = this.getFirstBarPaint();
        }
        else if (n2 == columnCount - 1) {
            paint = this.getLastBarPaint();
        }
        else if (n6 < 0.0) {
            paint = this.getNegativeBarPaint();
        }
        else if (n6 > 0.0) {
            paint = this.getPositiveBarPaint();
        }
        else {
            paint = this.getLastBarPaint();
        }
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            paint = this.getGradientPaintTransformer().transform((GradientPaint)paint, double1);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double1);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            final Stroke itemOutlineStroke = this.getItemOutlineStroke(n, n2);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(n, n2);
            if (itemOutlineStroke != null && itemOutlinePaint != null) {
                graphics2D.setStroke(itemOutlineStroke);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(double1);
            }
        }
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, n6 < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            this.addItemEntity(entityCollection, categoryDataset, n, n2, double1);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof WaterfallBarRenderer)) {
            return false;
        }
        final WaterfallBarRenderer waterfallBarRenderer = (WaterfallBarRenderer)o;
        return PaintUtilities.equal(this.firstBarPaint, waterfallBarRenderer.firstBarPaint) && PaintUtilities.equal(this.lastBarPaint, waterfallBarRenderer.lastBarPaint) && PaintUtilities.equal(this.positiveBarPaint, waterfallBarRenderer.positiveBarPaint) && PaintUtilities.equal(this.negativeBarPaint, waterfallBarRenderer.negativeBarPaint);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.firstBarPaint, objectOutputStream);
        SerialUtilities.writePaint(this.lastBarPaint, objectOutputStream);
        SerialUtilities.writePaint(this.positiveBarPaint, objectOutputStream);
        SerialUtilities.writePaint(this.negativeBarPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.firstBarPaint = SerialUtilities.readPaint(objectInputStream);
        this.lastBarPaint = SerialUtilities.readPaint(objectInputStream);
        this.positiveBarPaint = SerialUtilities.readPaint(objectInputStream);
        this.negativeBarPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
