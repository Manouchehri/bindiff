/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class ClusteredXYBarRenderer
extends XYBarRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 5864462149177133147L;
    private boolean centerBarAtStartValue;

    public ClusteredXYBarRenderer() {
        this(0.0, false);
    }

    public ClusteredXYBarRenderer(double d2, boolean bl2) {
        super(d2);
        this.centerBarAtStartValue = bl2;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2;
        Object object;
        double d3;
        IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
        if (this.getUseYInterval()) {
            d3 = intervalXYDataset.getStartYValue(n2, n3);
            d2 = intervalXYDataset.getEndYValue(n2, n3);
        } else {
            d3 = this.getBase();
            d2 = intervalXYDataset.getYValue(n2, n3);
        }
        if (Double.isNaN(d3)) return;
        if (Double.isNaN(d2)) {
            return;
        }
        double d4 = valueAxis2.valueToJava2D(d3, rectangle2D, xYPlot.getRangeAxisEdge());
        double d5 = valueAxis2.valueToJava2D(d2, rectangle2D, xYPlot.getRangeAxisEdge());
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        double d6 = intervalXYDataset.getStartXValue(n2, n3);
        double d7 = valueAxis.valueToJava2D(d6, rectangle2D, rectangleEdge);
        double d8 = intervalXYDataset.getEndXValue(n2, n3);
        double d9 = valueAxis.valueToJava2D(d8, rectangle2D, rectangleEdge);
        double d10 = Math.max(1.0, Math.abs(d9 - d7));
        double d11 = Math.abs(d4 - d5);
        if (this.centerBarAtStartValue) {
            d7 -= d10 / 2.0;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        double d12 = this.getMargin();
        if (d12 > 0.0) {
            double d13 = d10 * this.getMargin();
            d10 -= d13;
            d7 = plotOrientation == PlotOrientation.HORIZONTAL ? (d7 -= d13 / 2.0) : (d7 += d13 / 2.0);
        }
        int n5 = xYDataset.getSeriesCount();
        double d14 = d10 / (double)n5;
        Rectangle2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Rectangle2D.Double(Math.min(d4, d5), d7 - d14 * (double)(n5 - n2), d11, d14);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Rectangle2D.Double(d7 + d14 * (double)n2, Math.min(d4, d5), d14, d11);
        }
        Paint paint = this.getItemPaint(n2, n3);
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            object = (GradientPaint)paint;
            paint = this.getGradientPaintTransformer().transform((GradientPaint)object, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && Math.abs(d9 - d7) > 3.0) {
            graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
            graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
            graphics2D.draw(double_);
        }
        if (this.isItemLabelVisible(n2, n3)) {
            object = this.getItemLabelGenerator(n2, n3);
            this.drawItemLabel(graphics2D, xYDataset, n2, n3, xYPlot, (XYItemLabelGenerator)object, double_, d2 < 0.0);
        }
        if (plotRenderingInfo == null) return;
        object = plotRenderingInfo.getOwner().getEntityCollection();
        if (object == null) return;
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string2 = null;
        if (this.getURLGenerator() != null) {
            string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(double_, xYDataset, n2, n3, string, string2);
        object.add(xYItemEntity);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ClusteredXYBarRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        ClusteredXYBarRenderer clusteredXYBarRenderer = (ClusteredXYBarRenderer)object;
        if (this.centerBarAtStartValue == clusteredXYBarRenderer.centerBarAtStartValue) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

