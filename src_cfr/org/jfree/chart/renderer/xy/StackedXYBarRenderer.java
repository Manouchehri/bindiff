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
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer$XYBarRendererState;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class StackedXYBarRenderer
extends XYBarRenderer {
    private static final long serialVersionUID = -7049101055533436444L;
    private boolean renderAsPercentages = false;
    static Class class$org$jfree$data$xy$IntervalXYDataset;
    static Class class$org$jfree$data$xy$TableXYDataset;

    public StackedXYBarRenderer() {
        this(0.0);
    }

    public StackedXYBarRenderer(double d2) {
        super(d2);
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        this.setBasePositiveItemLabelPosition(itemLabelPosition);
        this.setBaseNegativeItemLabelPosition(itemLabelPosition);
        this.setPositiveItemLabelPositionFallback(null);
        this.setNegativeItemLabelPositionFallback(null);
    }

    public boolean getRenderAsPercentages() {
        return this.renderAsPercentages;
    }

    public void setRenderAsPercentages(boolean bl2) {
        this.renderAsPercentages = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public int getPassCount() {
        return 2;
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        return new XYBarRenderer$XYBarRendererState(this, plotRenderingInfo);
    }

    @Override
    public Range findRangeBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        if (!this.renderAsPercentages) return DatasetUtilities.findStackedRangeBounds((TableXYDataset)xYDataset);
        return new Range(0.0, 1.0);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2;
        double d3;
        if (!(xYDataset instanceof IntervalXYDataset) || !(xYDataset instanceof TableXYDataset)) {
            String string = new StringBuffer().append("dataset (type ").append(xYDataset.getClass().getName()).append(") has wrong type:").toString();
            boolean bl2 = false;
            Class class_ = class$org$jfree$data$xy$IntervalXYDataset == null ? (StackedXYBarRenderer.class$org$jfree$data$xy$IntervalXYDataset = StackedXYBarRenderer.class$("org.jfree.data.xy.IntervalXYDataset")) : class$org$jfree$data$xy$IntervalXYDataset;
            if (!class_.isAssignableFrom(xYDataset.getClass())) {
                string = new StringBuffer().append(string).append(" it is no IntervalXYDataset").toString();
                bl2 = true;
            }
            Class class_2 = class$org$jfree$data$xy$TableXYDataset == null ? (StackedXYBarRenderer.class$org$jfree$data$xy$TableXYDataset = StackedXYBarRenderer.class$("org.jfree.data.xy.TableXYDataset")) : class$org$jfree$data$xy$TableXYDataset;
            if (class_2.isAssignableFrom(xYDataset.getClass())) throw new IllegalArgumentException(string);
            if (bl2) {
                string = new StringBuffer().append(string).append(" and").toString();
            }
            string = new StringBuffer().append(string).append(" it is no TableXYDataset").toString();
            throw new IllegalArgumentException(string);
        }
        IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
        double d4 = intervalXYDataset.getYValue(n2, n3);
        if (Double.isNaN(d4)) {
            return;
        }
        double d5 = 0.0;
        if (this.renderAsPercentages) {
            d5 = DatasetUtilities.calculateStackTotal((TableXYDataset)xYDataset, n3);
            d4 /= d5;
        }
        double d6 = 0.0;
        double d7 = 0.0;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d8 = xYDataset.getYValue(i2, n3);
            if (Double.isNaN(d8)) continue;
            if (this.renderAsPercentages) {
                d8 /= d5;
            }
            if (d8 > 0.0) {
                d6 += d8;
                continue;
            }
            d7 += d8;
        }
        RectangleEdge rectangleEdge = xYPlot.getRangeAxisEdge();
        if (d4 > 0.0) {
            d2 = valueAxis2.valueToJava2D(d6, rectangle2D, rectangleEdge);
            d3 = valueAxis2.valueToJava2D(d6 + d4, rectangle2D, rectangleEdge);
        } else {
            d2 = valueAxis2.valueToJava2D(d7, rectangle2D, rectangleEdge);
            d3 = valueAxis2.valueToJava2D(d7 + d4, rectangle2D, rectangleEdge);
        }
        RectangleEdge rectangleEdge2 = xYPlot.getDomainAxisEdge();
        double d9 = intervalXYDataset.getStartXValue(n2, n3);
        if (Double.isNaN(d9)) {
            return;
        }
        double d10 = valueAxis.valueToJava2D(d9, rectangle2D, rectangleEdge2);
        double d11 = intervalXYDataset.getEndXValue(n2, n3);
        if (Double.isNaN(d11)) {
            return;
        }
        double d12 = valueAxis.valueToJava2D(d11, rectangle2D, rectangleEdge2);
        double d13 = Math.max(1.0, Math.abs(d12 - d10));
        double d14 = Math.abs(d3 - d2);
        if (this.getMargin() > 0.0) {
            double d15 = d13 * this.getMargin();
            d13 -= d15;
            d10 += d15 / 2.0;
        }
        Rectangle2D.Double double_ = null;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Rectangle2D.Double(Math.min(d2, d3), d12, d14, d13);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Rectangle2D.Double(d10, Math.min(d2, d3), d13, d14);
        }
        if (n4 == 0) {
            Object object;
            Paint paint = this.getItemPaint(n2, n3);
            if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
                object = (GradientPaint)paint;
                paint = this.getGradientPaintTransformer().transform((GradientPaint)object, double_);
            }
            graphics2D.setPaint(paint);
            graphics2D.fill(double_);
            if (this.isDrawBarOutline() && Math.abs(d12 - d10) > 3.0) {
                graphics2D.setStroke(this.getItemStroke(n2, n3));
                graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                graphics2D.draw(double_);
            }
            if (plotRenderingInfo == null) return;
            object = plotRenderingInfo.getOwner().getEntityCollection();
            if (object == null) return;
            this.addEntity((EntityCollection)object, double_, xYDataset, n2, n3, double_.getCenterX(), double_.getCenterY());
            return;
        }
        if (n4 != 1) return;
        if (!this.isItemLabelVisible(n2, n3)) return;
        XYItemLabelGenerator xYItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        this.drawItemLabel(graphics2D, xYDataset, n2, n3, xYPlot, xYItemLabelGenerator, double_, d4 < 0.0);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StackedXYBarRenderer)) {
            return false;
        }
        StackedXYBarRenderer stackedXYBarRenderer = (StackedXYBarRenderer)object;
        if (this.renderAsPercentages == stackedXYBarRenderer.renderAsPercentages) return super.equals(object);
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        return n2 * 37 + (this.renderAsPercentages ? 1 : 0);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

