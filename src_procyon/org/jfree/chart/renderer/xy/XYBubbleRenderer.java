package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.*;

public class XYBubbleRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    public static final long serialVersionUID = -5221991598674249125L;
    public static final int SCALE_ON_BOTH_AXES = 0;
    public static final int SCALE_ON_DOMAIN_AXIS = 1;
    public static final int SCALE_ON_RANGE_AXIS = 2;
    private int scaleType;
    
    public XYBubbleRenderer() {
        this(0);
    }
    
    public XYBubbleRenderer(final int scaleType) {
        if (scaleType < 0 || scaleType > 2) {
            throw new IllegalArgumentException("Invalid 'scaleType'.");
        }
        this.scaleType = scaleType;
    }
    
    public int getScaleType() {
        return this.scaleType;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final double xValue = xyDataset.getXValue(n, n2);
        final double yValue = xyDataset.getYValue(n, n2);
        double zValue = Double.NaN;
        if (xyDataset instanceof XYZDataset) {
            zValue = ((XYZDataset)xyDataset).getZValue(n, n2);
        }
        if (!Double.isNaN(zValue)) {
            final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
            final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
            final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
            final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
            double n5 = 0.0;
            double n4 = 0.0;
            switch (this.getScaleType()) {
                case 1: {
                    n4 = (n5 = valueAxis.valueToJava2D(zValue, rectangle2D, domainAxisEdge) - valueAxis.valueToJava2D(0.0, rectangle2D, domainAxisEdge));
                    break;
                }
                case 2: {
                    n5 = (n4 = valueAxis2.valueToJava2D(0.0, rectangle2D, rangeAxisEdge) - valueAxis2.valueToJava2D(zValue, rectangle2D, rangeAxisEdge));
                    break;
                }
                default: {
                    final double valueToJava2D3 = valueAxis.valueToJava2D(0.0, rectangle2D, domainAxisEdge);
                    final double valueToJava2D4 = valueAxis2.valueToJava2D(0.0, rectangle2D, rangeAxisEdge);
                    n4 = valueAxis.valueToJava2D(zValue, rectangle2D, domainAxisEdge) - valueToJava2D3;
                    n5 = valueToJava2D4 - valueAxis2.valueToJava2D(zValue, rectangle2D, rangeAxisEdge);
                    break;
                }
            }
            final double abs = Math.abs(n4);
            final double abs2 = Math.abs(n5);
            Shape shape = null;
            if (orientation == PlotOrientation.VERTICAL) {
                shape = new Ellipse2D.Double(valueToJava2D - abs / 2.0, valueToJava2D2 - abs2 / 2.0, abs, abs2);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                shape = new Ellipse2D.Double(valueToJava2D2 - abs2 / 2.0, valueToJava2D - abs / 2.0, abs2, abs);
            }
            graphics2D.setPaint(this.getItemPaint(n, n2));
            graphics2D.fill(shape);
            graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(shape);
            if (this.isItemLabelVisible(n, n2)) {
                if (orientation == PlotOrientation.VERTICAL) {
                    this.drawItemLabel(graphics2D, orientation, xyDataset, n, n2, valueToJava2D, valueToJava2D2, false);
                }
                else if (orientation == PlotOrientation.HORIZONTAL) {
                    this.drawItemLabel(graphics2D, orientation, xyDataset, n, n2, valueToJava2D2, valueToJava2D, false);
                }
            }
            EntityCollection entityCollection = null;
            if (plotRenderingInfo != null) {
                entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
            }
            if (entityCollection != null) {
                String generateToolTip = null;
                final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
                }
                String generateURL = null;
                if (this.getURLGenerator() != null) {
                    generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
                }
                entityCollection.add(new XYItemEntity(shape, xyDataset, n, n2, generateToolTip, generateURL));
            }
            this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, valueToJava2D2, orientation);
        }
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        LegendItem legendItem = null;
        final XYPlot plot = this.getPlot();
        if (plot != null) {
            final XYDataset dataset = plot.getDataset(n);
            if (dataset != null && this.getItemVisible(n2, 0)) {
                final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, n2);
                String generateLabel2 = null;
                if (this.getLegendItemToolTipGenerator() != null) {
                    generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, n2);
                }
                String generateLabel3 = null;
                if (this.getLegendItemURLGenerator() != null) {
                    generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, n2);
                }
                legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0), this.getSeriesPaint(n2), this.getSeriesOutlineStroke(n2), this.getSeriesOutlinePaint(n2));
            }
        }
        return legendItem;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof XYBubbleRenderer && this.scaleType == ((XYBubbleRenderer)o).scaleType && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
