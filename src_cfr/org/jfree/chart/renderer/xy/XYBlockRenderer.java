/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYBlockRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer {
    private double blockWidth = 1.0;
    private double blockHeight = 1.0;
    private RectangleAnchor blockAnchor = RectangleAnchor.CENTER;
    private double xOffset;
    private double yOffset;
    private PaintScale paintScale;

    public XYBlockRenderer() {
        this.updateOffsets();
        this.paintScale = new LookupPaintScale();
    }

    public double getBlockWidth() {
        return this.blockWidth;
    }

    public void setBlockWidth(double d2) {
        if (d2 <= 0.0) {
            throw new IllegalArgumentException("The 'width' argument must be > 0.0");
        }
        this.blockWidth = d2;
        this.updateOffsets();
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getBlockHeight() {
        return this.blockHeight;
    }

    public void setBlockHeight(double d2) {
        if (d2 <= 0.0) {
            throw new IllegalArgumentException("The 'height' argument must be > 0.0");
        }
        this.blockHeight = d2;
        this.updateOffsets();
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public RectangleAnchor getBlockAnchor() {
        return this.blockAnchor;
    }

    public void setBlockAnchor(RectangleAnchor rectangleAnchor) {
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        if (this.blockAnchor.equals(rectangleAnchor)) {
            return;
        }
        this.blockAnchor = rectangleAnchor;
        this.updateOffsets();
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public PaintScale getPaintScale() {
        return this.paintScale;
    }

    public void setPaintScale(PaintScale paintScale) {
        if (paintScale == null) {
            throw new IllegalArgumentException("Null 'scale' argument.");
        }
        this.paintScale = paintScale;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    private void updateOffsets() {
        if (this.blockAnchor.equals(RectangleAnchor.BOTTOM_LEFT)) {
            this.xOffset = 0.0;
            this.yOffset = 0.0;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.BOTTOM)) {
            this.xOffset = (- this.blockWidth) / 2.0;
            this.yOffset = 0.0;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.BOTTOM_RIGHT)) {
            this.xOffset = - this.blockWidth;
            this.yOffset = 0.0;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.LEFT)) {
            this.xOffset = 0.0;
            this.yOffset = (- this.blockHeight) / 2.0;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.CENTER)) {
            this.xOffset = (- this.blockWidth) / 2.0;
            this.yOffset = (- this.blockHeight) / 2.0;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.RIGHT)) {
            this.xOffset = - this.blockWidth;
            this.yOffset = (- this.blockHeight) / 2.0;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.TOP_LEFT)) {
            this.xOffset = 0.0;
            this.yOffset = - this.blockHeight;
            return;
        }
        if (this.blockAnchor.equals(RectangleAnchor.TOP)) {
            this.xOffset = (- this.blockWidth) / 2.0;
            this.yOffset = - this.blockHeight;
            return;
        }
        if (!this.blockAnchor.equals(RectangleAnchor.TOP_RIGHT)) return;
        this.xOffset = - this.blockWidth;
        this.yOffset = - this.blockHeight;
    }

    @Override
    public Range findDomainBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        Range range = DatasetUtilities.findDomainBounds(xYDataset, false);
        return new Range(range.getLowerBound() + this.xOffset, range.getUpperBound() + this.blockWidth + this.xOffset);
    }

    @Override
    public Range findRangeBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        Range range = DatasetUtilities.findRangeBounds(xYDataset, false);
        return new Range(range.getLowerBound() + this.yOffset, range.getUpperBound() + this.blockHeight + this.yOffset);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2 = xYDataset.getXValue(n2, n3);
        double d3 = xYDataset.getYValue(n2, n3);
        double d4 = 0.0;
        if (xYDataset instanceof XYZDataset) {
            d4 = ((XYZDataset)xYDataset).getZValue(n2, n3);
        }
        Paint paint = this.paintScale.getPaint(d4);
        double d5 = valueAxis.valueToJava2D(d2 + this.xOffset, rectangle2D, xYPlot.getDomainAxisEdge());
        double d6 = valueAxis2.valueToJava2D(d3 + this.yOffset, rectangle2D, xYPlot.getRangeAxisEdge());
        double d7 = valueAxis.valueToJava2D(d2 + this.blockWidth + this.xOffset, rectangle2D, xYPlot.getDomainAxisEdge());
        double d8 = valueAxis2.valueToJava2D(d3 + this.blockHeight + this.yOffset, rectangle2D, xYPlot.getRangeAxisEdge());
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Rectangle2D.Double double_ = plotOrientation.equals(PlotOrientation.HORIZONTAL) ? new Rectangle2D.Double(Math.min(d6, d8), Math.min(d5, d7), Math.abs(d8 - d6), Math.abs(d5 - d7)) : new Rectangle2D.Double(Math.min(d5, d7), Math.min(d6, d8), Math.abs(d7 - d5), Math.abs(d8 - d6));
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        graphics2D.setStroke(new BasicStroke(1.0f));
        graphics2D.draw(double_);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYBlockRenderer)) {
            return false;
        }
        XYBlockRenderer xYBlockRenderer = (XYBlockRenderer)object;
        if (this.blockHeight != xYBlockRenderer.blockHeight) {
            return false;
        }
        if (this.blockWidth != xYBlockRenderer.blockWidth) {
            return false;
        }
        if (!this.blockAnchor.equals(xYBlockRenderer.blockAnchor)) {
            return false;
        }
        if (this.paintScale.equals(xYBlockRenderer.paintScale)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        XYBlockRenderer xYBlockRenderer = (XYBlockRenderer)super.clone();
        if (!(this.paintScale instanceof PublicCloneable)) return xYBlockRenderer;
        PublicCloneable publicCloneable = (PublicCloneable)((Object)this.paintScale);
        xYBlockRenderer.paintScale = (PaintScale)publicCloneable.clone();
        return xYBlockRenderer;
    }
}

