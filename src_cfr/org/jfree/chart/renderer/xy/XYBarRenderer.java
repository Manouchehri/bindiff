/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer$XYBarRendererState;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYBarRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = 770559577251370036L;
    private double base;
    private boolean useYInterval;
    private double margin;
    private boolean drawBarOutline;
    private GradientPaintTransformer gradientPaintTransformer;
    private transient Shape legendBar;
    private ItemLabelPosition positiveItemLabelPositionFallback;
    private ItemLabelPosition negativeItemLabelPositionFallback;

    public XYBarRenderer() {
        this(0.0);
    }

    public XYBarRenderer(double d2) {
        this.margin = d2;
        this.base = 0.0;
        this.useYInterval = false;
        this.gradientPaintTransformer = new StandardGradientPaintTransformer();
        this.drawBarOutline = true;
        this.legendBar = new Rectangle2D.Double(-3.0, -5.0, 6.0, 10.0);
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double d2) {
        this.base = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getUseYInterval() {
        return this.useYInterval;
    }

    public void setUseYInterval(boolean bl2) {
        if (this.useYInterval == bl2) return;
        this.useYInterval = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getMargin() {
        return this.margin;
    }

    public void setMargin(double d2) {
        this.margin = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean isDrawBarOutline() {
        return this.drawBarOutline;
    }

    public void setDrawBarOutline(boolean bl2) {
        this.drawBarOutline = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public GradientPaintTransformer getGradientPaintTransformer() {
        return this.gradientPaintTransformer;
    }

    public void setGradientPaintTransformer(GradientPaintTransformer gradientPaintTransformer) {
        this.gradientPaintTransformer = gradientPaintTransformer;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Shape getLegendBar() {
        return this.legendBar;
    }

    public void setLegendBar(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'bar' argument.");
        }
        this.legendBar = shape;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public ItemLabelPosition getPositiveItemLabelPositionFallback() {
        return this.positiveItemLabelPositionFallback;
    }

    public void setPositiveItemLabelPositionFallback(ItemLabelPosition itemLabelPosition) {
        this.positiveItemLabelPositionFallback = itemLabelPosition;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public ItemLabelPosition getNegativeItemLabelPositionFallback() {
        return this.negativeItemLabelPositionFallback;
    }

    public void setNegativeItemLabelPositionFallback(ItemLabelPosition itemLabelPosition) {
        this.negativeItemLabelPositionFallback = itemLabelPosition;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        XYBarRenderer$XYBarRendererState xYBarRenderer$XYBarRendererState = new XYBarRenderer$XYBarRendererState(this, plotRenderingInfo);
        ValueAxis valueAxis = xYPlot.getRangeAxisForDataset(xYPlot.indexOf(xYDataset));
        xYBarRenderer$XYBarRendererState.setG2Base(valueAxis.valueToJava2D(this.base, rectangle2D, xYPlot.getRangeAxisEdge()));
        return xYBarRenderer$XYBarRendererState;
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        LegendItem legendItem = null;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) return legendItem;
        XYDataset xYDataset = xYPlot.getDataset(n2);
        if (xYDataset == null) return legendItem;
        XYSeriesLabelGenerator xYSeriesLabelGenerator = this.getLegendItemLabelGenerator();
        String string2 = string = xYSeriesLabelGenerator.generateLabel(xYDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(xYDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(xYDataset, n3);
        }
        Shape shape = this.legendBar;
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.getSeriesOutlinePaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        legendItem = this.drawBarOutline ? new LegendItem(string, string2, string3, string4, shape, paint, stroke, paint2) : new LegendItem(string, string2, string3, string4, shape, paint);
        if (this.getGradientPaintTransformer() == null) return legendItem;
        legendItem.setFillPaintTransformer(this.getGradientPaintTransformer());
        return legendItem;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2;
        double d3;
        Object object;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
        if (this.useYInterval) {
            d3 = intervalXYDataset.getStartYValue(n2, n3);
            d2 = intervalXYDataset.getEndYValue(n2, n3);
        } else {
            d3 = this.base;
            d2 = intervalXYDataset.getYValue(n2, n3);
        }
        if (Double.isNaN(d3)) return;
        if (Double.isNaN(d2)) {
            return;
        }
        if (d3 <= d2 ? !valueAxis2.getRange().intersects(d3, d2) : !valueAxis2.getRange().intersects(d2, d3)) {
            return;
        }
        double d4 = valueAxis2.valueToJava2D(d3, rectangle2D, xYPlot.getRangeAxisEdge());
        double d5 = valueAxis2.valueToJava2D(d2, rectangle2D, xYPlot.getRangeAxisEdge());
        double d6 = Math.min(d4, d5);
        double d7 = Math.max(d4, d5);
        double d8 = intervalXYDataset.getStartXValue(n2, n3);
        if (Double.isNaN(d8)) {
            return;
        }
        double d9 = intervalXYDataset.getEndXValue(n2, n3);
        if (Double.isNaN(d9)) {
            return;
        }
        if (d8 <= d9 ? !valueAxis.getRange().intersects(d8, d9) : !valueAxis.getRange().intersects(d9, d8)) {
            return;
        }
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        double d10 = valueAxis.valueToJava2D(d8, rectangle2D, rectangleEdge);
        double d11 = valueAxis.valueToJava2D(d9, rectangle2D, rectangleEdge);
        double d12 = Math.max(1.0, Math.abs(d11 - d10));
        if (this.getMargin() > 0.0) {
            double d13 = d12 * this.getMargin();
            d12 -= d13;
            d10 += d13 / 2.0;
        }
        Rectangle2D.Double double_ = null;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d6 = Math.max(d6, rectangle2D.getMinX());
            d7 = Math.min(d7, rectangle2D.getMaxX());
            double_ = new Rectangle2D.Double(d6, Math.min(d10, d11), d7 - d6, d12);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d6 = Math.max(d6, rectangle2D.getMinY());
            d7 = Math.min(d7, rectangle2D.getMaxY());
            double_ = new Rectangle2D.Double(Math.min(d10, d11), d6, d12, d7 - d6);
        }
        Paint paint = this.getItemPaint(n2, n3);
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            object = (GradientPaint)paint;
            paint = this.getGradientPaintTransformer().transform((GradientPaint)object, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && Math.abs(d11 - d10) > 3.0) {
            object = this.getItemOutlineStroke(n2, n3);
            Paint paint2 = this.getItemOutlinePaint(n2, n3);
            if (object != null && paint2 != null) {
                graphics2D.setStroke((Stroke)object);
                graphics2D.setPaint(paint2);
                graphics2D.draw(double_);
            }
        }
        if (this.isItemLabelVisible(n2, n3)) {
            object = this.getItemLabelGenerator(n2, n3);
            this.drawItemLabel(graphics2D, xYDataset, n2, n3, xYPlot, (XYItemLabelGenerator)object, double_, d2 < 0.0);
        }
        double d14 = (d8 + d9) / 2.0;
        double d15 = xYDataset.getYValue(n2, n3);
        double d16 = valueAxis.valueToJava2D(d14, rectangle2D, rectangleEdge);
        double d17 = valueAxis2.valueToJava2D(d15, rectangle2D, xYPlot.getRangeAxisEdge());
        int n5 = xYPlot.getDomainAxisIndex(valueAxis);
        int n6 = xYPlot.getRangeAxisIndex(valueAxis2);
        this.updateCrosshairValues(crosshairState, d14, d15, n5, n6, d16, d17, xYPlot.getOrientation());
        if (plotRenderingInfo == null) return;
        EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        if (entityCollection == null) return;
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
        entityCollection.add(xYItemEntity);
    }

    protected void drawItemLabel(Graphics2D graphics2D, XYDataset xYDataset, int n2, int n3, XYPlot xYPlot, XYItemLabelGenerator xYItemLabelGenerator, Rectangle2D rectangle2D, boolean bl2) {
        Shape shape;
        String string = xYItemLabelGenerator.generateLabel(xYDataset, n2, n3);
        if (string == null) {
            return;
        }
        Font font = this.getItemLabelFont(n2, n3);
        graphics2D.setFont(font);
        Paint paint = this.getItemLabelPaint(n2, n3);
        graphics2D.setPaint(paint);
        ItemLabelPosition itemLabelPosition = null;
        itemLabelPosition = !bl2 ? this.getPositiveItemLabelPosition(n2, n3) : this.getNegativeItemLabelPosition(n2, n3);
        Point2D point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, xYPlot.getOrientation());
        if (this.isInternalAnchor(itemLabelPosition.getItemLabelAnchor()) && (shape = TextUtilities.calculateRotatedStringBounds(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor())) != null && !rectangle2D.contains(shape.getBounds2D())) {
            itemLabelPosition = !bl2 ? this.getPositiveItemLabelPositionFallback() : this.getNegativeItemLabelPositionFallback();
            if (itemLabelPosition != null) {
                point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, xYPlot.getOrientation());
            }
        }
        if (itemLabelPosition == null) return;
        TextUtilities.drawRotatedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
    }

    private Point2D calculateLabelAnchorPoint(ItemLabelAnchor itemLabelAnchor, Rectangle2D rectangle2D, PlotOrientation plotOrientation) {
        Point2D.Double double_ = null;
        double d2 = this.getItemLabelAnchorOffset();
        double d3 = rectangle2D.getX() - d2;
        double d4 = rectangle2D.getX();
        double d5 = rectangle2D.getX() + d2;
        double d6 = rectangle2D.getCenterX();
        double d7 = rectangle2D.getMaxX() - d2;
        double d8 = rectangle2D.getMaxX();
        double d9 = rectangle2D.getMaxX() + d2;
        double d10 = rectangle2D.getMaxY() + d2;
        double d11 = rectangle2D.getMaxY();
        double d12 = rectangle2D.getMaxY() - d2;
        double d13 = rectangle2D.getCenterY();
        double d14 = rectangle2D.getMinY() + d2;
        double d15 = rectangle2D.getMinY();
        double d16 = rectangle2D.getMinY() - d2;
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) {
            return new Point2D.Double(d6, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) {
            return new Point2D.Double(d7, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) {
            return new Point2D.Double(d7, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) {
            return new Point2D.Double(d7, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) {
            return new Point2D.Double(d7, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) {
            return new Point2D.Double(d7, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) {
            return new Point2D.Double(d6, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) {
            return new Point2D.Double(d5, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) {
            return new Point2D.Double(d5, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) {
            return new Point2D.Double(d5, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) {
            return new Point2D.Double(d5, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) {
            return new Point2D.Double(d5, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) {
            return new Point2D.Double(d6, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE1) {
            return new Point2D.Double(d8, d16);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE2) {
            return new Point2D.Double(d9, d15);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE3) {
            return new Point2D.Double(d9, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE4) {
            return new Point2D.Double(d9, d11);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE5) {
            return new Point2D.Double(d8, d10);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE6) {
            return new Point2D.Double(d6, d10);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE7) {
            return new Point2D.Double(d4, d10);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE8) {
            return new Point2D.Double(d3, d11);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE9) {
            return new Point2D.Double(d3, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE10) {
            return new Point2D.Double(d3, d15);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE11) {
            return new Point2D.Double(d4, d16);
        }
        if (itemLabelAnchor != ItemLabelAnchor.OUTSIDE12) return double_;
        return new Point2D.Double(d6, d16);
    }

    private boolean isInternalAnchor(ItemLabelAnchor itemLabelAnchor) {
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) return true;
        return false;
    }

    @Override
    public Range findDomainBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        return DatasetUtilities.findDomainBounds(xYDataset, true);
    }

    @Override
    public Object clone() {
        XYBarRenderer xYBarRenderer = (XYBarRenderer)super.clone();
        if (this.gradientPaintTransformer != null) {
            xYBarRenderer.gradientPaintTransformer = (GradientPaintTransformer)ObjectUtilities.clone(this.gradientPaintTransformer);
        }
        xYBarRenderer.legendBar = ShapeUtilities.clone(this.legendBar);
        return xYBarRenderer;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYBarRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYBarRenderer xYBarRenderer = (XYBarRenderer)object;
        if (this.base != xYBarRenderer.base) {
            return false;
        }
        if (this.drawBarOutline != xYBarRenderer.drawBarOutline) {
            return false;
        }
        if (this.margin != xYBarRenderer.margin) {
            return false;
        }
        if (this.useYInterval != xYBarRenderer.useYInterval) {
            return false;
        }
        if (!ObjectUtilities.equal(this.gradientPaintTransformer, xYBarRenderer.gradientPaintTransformer)) {
            return false;
        }
        if (!ShapeUtilities.equal(this.legendBar, xYBarRenderer.legendBar)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.positiveItemLabelPositionFallback, xYBarRenderer.positiveItemLabelPositionFallback)) {
            return false;
        }
        if (ObjectUtilities.equal(this.negativeItemLabelPositionFallback, xYBarRenderer.negativeItemLabelPositionFallback)) return true;
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendBar = SerialUtilities.readShape(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendBar, objectOutputStream);
    }
}

