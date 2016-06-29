/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class WaterfallBarRenderer
extends BarRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -2482910643727230911L;
    private transient Paint firstBarPaint;
    private transient Paint lastBarPaint;
    private transient Paint positiveBarPaint;
    private transient Paint negativeBarPaint;

    public WaterfallBarRenderer() {
        this(new GradientPaint(0.0f, 0.0f, new Color(34, 34, 255), 0.0f, 0.0f, new Color(102, 102, 255)), new GradientPaint(0.0f, 0.0f, new Color(34, 255, 34), 0.0f, 0.0f, new Color(102, 255, 102)), new GradientPaint(0.0f, 0.0f, new Color(255, 34, 34), 0.0f, 0.0f, new Color(255, 102, 102)), new GradientPaint(0.0f, 0.0f, new Color(255, 255, 34), 0.0f, 0.0f, new Color(255, 255, 102)));
    }

    public WaterfallBarRenderer(Paint paint, Paint paint2, Paint paint3, Paint paint4) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'firstBarPaint' argument");
        }
        if (paint2 == null) {
            throw new IllegalArgumentException("Null 'positiveBarPaint' argument");
        }
        if (paint3 == null) {
            throw new IllegalArgumentException("Null 'negativeBarPaint' argument");
        }
        if (paint4 == null) {
            throw new IllegalArgumentException("Null 'lastBarPaint' argument");
        }
        this.firstBarPaint = paint;
        this.lastBarPaint = paint4;
        this.positiveBarPaint = paint2;
        this.negativeBarPaint = paint3;
        this.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        this.setMinimumBarLength(1.0);
    }

    @Override
    public Range findRangeBounds(CategoryDataset categoryDataset) {
        return DatasetUtilities.findCumulativeRangeBounds(categoryDataset);
    }

    public Paint getFirstBarPaint() {
        return this.firstBarPaint;
    }

    public void setFirstBarPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.firstBarPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getLastBarPaint() {
        return this.lastBarPaint;
    }

    public void setLastBarPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.lastBarPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getPositiveBarPaint() {
        return this.positiveBarPaint;
    }

    public void setPositiveBarPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.positiveBarPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getNegativeBarPaint() {
        return this.negativeBarPaint;
    }

    public void setNegativeBarPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        this.negativeBarPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        double d2;
        double d3;
        Object object;
        Object object2;
        double d4 = categoryItemRendererState.getSeriesRunningTotal();
        if (n3 == categoryDataset.getColumnCount() - 1) {
            d4 = 0.0;
        }
        double d5 = 0.0;
        Number number = categoryDataset.getValue(n2, n3);
        if (number != null) {
            d5 = d4 + number.doubleValue();
        }
        categoryItemRendererState.setSeriesRunningTotal(d5);
        int n5 = this.getRowCount();
        int n6 = this.getColumnCount();
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d6 = 0.0;
        double d7 = 0.0;
        RectangleEdge rectangleEdge = categoryPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = categoryPlot.getRangeAxisEdge();
        double d8 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge2);
        double d9 = valueAxis.valueToJava2D(d5, rectangle2D, rectangleEdge2);
        double d10 = d5 - d4;
        if (d9 < d8) {
            d2 = d9;
            d9 = d8;
            d8 = d2;
        }
        d2 = categoryItemRendererState.getBarWidth();
        double d11 = Math.max(this.getMinimumBarLength(), Math.abs(d9 - d8));
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d7 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
            if (n5 > 1) {
                d3 = rectangle2D.getHeight() * this.getItemMargin() / (double)(n6 * (n5 - 1));
                d7 += (double)n2 * (categoryItemRendererState.getBarWidth() + d3);
            } else {
                d7 += (double)n2 * categoryItemRendererState.getBarWidth();
            }
            d6 = d8;
            d11 = categoryItemRendererState.getBarWidth();
            d2 = Math.max(this.getMinimumBarLength(), Math.abs(d9 - d8));
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d6 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
            if (n5 > 1) {
                d3 = rectangle2D.getWidth() * this.getItemMargin() / (double)(n6 * (n5 - 1));
                d6 += (double)n2 * (categoryItemRendererState.getBarWidth() + d3);
            } else {
                d6 += (double)n2 * categoryItemRendererState.getBarWidth();
            }
            d7 = d8;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(d6, d7, d2, d11);
        Paint paint = this.getFirstBarPaint();
        paint = n3 == 0 ? this.getFirstBarPaint() : (n3 == n6 - 1 ? this.getLastBarPaint() : (d10 < 0.0 ? this.getNegativeBarPaint() : (d10 > 0.0 ? this.getPositiveBarPaint() : this.getLastBarPaint())));
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            object = (GradientPaint)paint;
            paint = this.getGradientPaintTransformer().transform((GradientPaint)object, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            object = this.getItemOutlineStroke(n2, n3);
            object2 = this.getItemOutlinePaint(n2, n3);
            if (object != null && object2 != null) {
                graphics2D.setStroke((Stroke)object);
                graphics2D.setPaint((Paint)object2);
                graphics2D.draw(double_);
            }
        }
        if ((object = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, (CategoryItemLabelGenerator)object, double_, d10 < 0.0);
        }
        if ((object2 = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity((EntityCollection)object2, categoryDataset, n2, n3, double_);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof WaterfallBarRenderer)) {
            return false;
        }
        WaterfallBarRenderer waterfallBarRenderer = (WaterfallBarRenderer)object;
        if (!PaintUtilities.equal(this.firstBarPaint, waterfallBarRenderer.firstBarPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.lastBarPaint, waterfallBarRenderer.lastBarPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.positiveBarPaint, waterfallBarRenderer.positiveBarPaint)) {
            return false;
        }
        if (PaintUtilities.equal(this.negativeBarPaint, waterfallBarRenderer.negativeBarPaint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.firstBarPaint, objectOutputStream);
        SerialUtilities.writePaint(this.lastBarPaint, objectOutputStream);
        SerialUtilities.writePaint(this.positiveBarPaint, objectOutputStream);
        SerialUtilities.writePaint(this.negativeBarPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.firstBarPaint = SerialUtilities.readPaint(objectInputStream);
        this.lastBarPaint = SerialUtilities.readPaint(objectInputStream);
        this.positiveBarPaint = SerialUtilities.readPaint(objectInputStream);
        this.negativeBarPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

