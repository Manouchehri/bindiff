package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.ui.*;
import org.jfree.chart.renderer.*;
import org.jfree.chart.event.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.util.*;

public class XYBlockRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer
{
    private double blockWidth;
    private double blockHeight;
    private RectangleAnchor blockAnchor;
    private double xOffset;
    private double yOffset;
    private PaintScale paintScale;
    
    public XYBlockRenderer() {
        this.blockWidth = 1.0;
        this.blockHeight = 1.0;
        this.blockAnchor = RectangleAnchor.CENTER;
        this.updateOffsets();
        this.paintScale = new LookupPaintScale();
    }
    
    public double getBlockWidth() {
        return this.blockWidth;
    }
    
    public void setBlockWidth(final double blockWidth) {
        if (blockWidth <= 0.0) {
            throw new IllegalArgumentException("The 'width' argument must be > 0.0");
        }
        this.blockWidth = blockWidth;
        this.updateOffsets();
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getBlockHeight() {
        return this.blockHeight;
    }
    
    public void setBlockHeight(final double blockHeight) {
        if (blockHeight <= 0.0) {
            throw new IllegalArgumentException("The 'height' argument must be > 0.0");
        }
        this.blockHeight = blockHeight;
        this.updateOffsets();
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public RectangleAnchor getBlockAnchor() {
        return this.blockAnchor;
    }
    
    public void setBlockAnchor(final RectangleAnchor blockAnchor) {
        if (blockAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        if (this.blockAnchor.equals(blockAnchor)) {
            return;
        }
        this.blockAnchor = blockAnchor;
        this.updateOffsets();
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public PaintScale getPaintScale() {
        return this.paintScale;
    }
    
    public void setPaintScale(final PaintScale paintScale) {
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
        }
        else if (this.blockAnchor.equals(RectangleAnchor.BOTTOM)) {
            this.xOffset = -this.blockWidth / 2.0;
            this.yOffset = 0.0;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.BOTTOM_RIGHT)) {
            this.xOffset = -this.blockWidth;
            this.yOffset = 0.0;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.LEFT)) {
            this.xOffset = 0.0;
            this.yOffset = -this.blockHeight / 2.0;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.CENTER)) {
            this.xOffset = -this.blockWidth / 2.0;
            this.yOffset = -this.blockHeight / 2.0;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.RIGHT)) {
            this.xOffset = -this.blockWidth;
            this.yOffset = -this.blockHeight / 2.0;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.TOP_LEFT)) {
            this.xOffset = 0.0;
            this.yOffset = -this.blockHeight;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.TOP)) {
            this.xOffset = -this.blockWidth / 2.0;
            this.yOffset = -this.blockHeight;
        }
        else if (this.blockAnchor.equals(RectangleAnchor.TOP_RIGHT)) {
            this.xOffset = -this.blockWidth;
            this.yOffset = -this.blockHeight;
        }
    }
    
    public Range findDomainBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            final Range domainBounds = DatasetUtilities.findDomainBounds(xyDataset, false);
            return new Range(domainBounds.getLowerBound() + this.xOffset, domainBounds.getUpperBound() + this.blockWidth + this.xOffset);
        }
        return null;
    }
    
    public Range findRangeBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            final Range rangeBounds = DatasetUtilities.findRangeBounds(xyDataset, false);
            return new Range(rangeBounds.getLowerBound() + this.yOffset, rangeBounds.getUpperBound() + this.blockHeight + this.yOffset);
        }
        return null;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final double xValue = xyDataset.getXValue(n, n2);
        final double yValue = xyDataset.getYValue(n, n2);
        double zValue = 0.0;
        if (xyDataset instanceof XYZDataset) {
            zValue = ((XYZDataset)xyDataset).getZValue(n, n2);
        }
        final Paint paint = this.paintScale.getPaint(zValue);
        final double valueToJava2D = valueAxis.valueToJava2D(xValue + this.xOffset, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue + this.yOffset, rectangle2D, xyPlot.getRangeAxisEdge());
        final double valueToJava2D3 = valueAxis.valueToJava2D(xValue + this.blockWidth + this.xOffset, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue + this.blockHeight + this.yOffset, rectangle2D, xyPlot.getRangeAxisEdge());
        Rectangle2D.Double double1;
        if (xyPlot.getOrientation().equals(PlotOrientation.HORIZONTAL)) {
            double1 = new Rectangle2D.Double(Math.min(valueToJava2D2, valueToJava2D4), Math.min(valueToJava2D, valueToJava2D3), Math.abs(valueToJava2D4 - valueToJava2D2), Math.abs(valueToJava2D - valueToJava2D3));
        }
        else {
            double1 = new Rectangle2D.Double(Math.min(valueToJava2D, valueToJava2D3), Math.min(valueToJava2D2, valueToJava2D4), Math.abs(valueToJava2D3 - valueToJava2D), Math.abs(valueToJava2D4 - valueToJava2D2));
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double1);
        graphics2D.setStroke(new BasicStroke(1.0f));
        graphics2D.draw(double1);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYBlockRenderer)) {
            return false;
        }
        final XYBlockRenderer xyBlockRenderer = (XYBlockRenderer)o;
        return this.blockHeight == xyBlockRenderer.blockHeight && this.blockWidth == xyBlockRenderer.blockWidth && this.blockAnchor.equals(xyBlockRenderer.blockAnchor) && this.paintScale.equals(xyBlockRenderer.paintScale) && super.equals(o);
    }
    
    public Object clone() {
        final XYBlockRenderer xyBlockRenderer = (XYBlockRenderer)super.clone();
        if (this.paintScale instanceof PublicCloneable) {
            xyBlockRenderer.paintScale = (PaintScale)((PublicCloneable)this.paintScale).clone();
        }
        return xyBlockRenderer;
    }
}
