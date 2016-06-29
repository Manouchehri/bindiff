package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.util.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class ClusteredXYBarRenderer extends XYBarRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 5864462149177133147L;
    private boolean centerBarAtStartValue;
    
    public ClusteredXYBarRenderer() {
        this(0.0, false);
    }
    
    public ClusteredXYBarRenderer(final double n, final boolean centerBarAtStartValue) {
        super(n);
        this.centerBarAtStartValue = centerBarAtStartValue;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
        double n4;
        double n5;
        if (this.getUseYInterval()) {
            n4 = intervalXYDataset.getStartYValue(n, n2);
            n5 = intervalXYDataset.getEndYValue(n, n2);
        }
        else {
            n4 = this.getBase();
            n5 = intervalXYDataset.getYValue(n, n2);
        }
        if (Double.isNaN(n4) || Double.isNaN(n5)) {
            return;
        }
        final double valueToJava2D = valueAxis2.valueToJava2D(n4, rectangle2D, xyPlot.getRangeAxisEdge());
        final double valueToJava2D2 = valueAxis2.valueToJava2D(n5, rectangle2D, xyPlot.getRangeAxisEdge());
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        double valueToJava2D3 = valueAxis.valueToJava2D(intervalXYDataset.getStartXValue(n, n2), rectangle2D, domainAxisEdge);
        final double valueToJava2D4 = valueAxis.valueToJava2D(intervalXYDataset.getEndXValue(n, n2), rectangle2D, domainAxisEdge);
        double max = Math.max(1.0, Math.abs(valueToJava2D4 - valueToJava2D3));
        final double abs = Math.abs(valueToJava2D - valueToJava2D2);
        if (this.centerBarAtStartValue) {
            valueToJava2D3 -= max / 2.0;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        if (this.getMargin() > 0.0) {
            final double n6 = max * this.getMargin();
            max -= n6;
            if (orientation == PlotOrientation.HORIZONTAL) {
                valueToJava2D3 -= n6 / 2.0;
            }
            else {
                valueToJava2D3 += n6 / 2.0;
            }
        }
        final int seriesCount = xyDataset.getSeriesCount();
        final double n7 = max / seriesCount;
        Rectangle2D rectangle2D2 = null;
        if (orientation == PlotOrientation.HORIZONTAL) {
            rectangle2D2 = new Rectangle2D.Double(Math.min(valueToJava2D, valueToJava2D2), valueToJava2D3 - n7 * (seriesCount - n), abs, n7);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            rectangle2D2 = new Rectangle2D.Double(valueToJava2D3 + n7 * n, Math.min(valueToJava2D, valueToJava2D2), n7, abs);
        }
        Paint paint = this.getItemPaint(n, n2);
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            paint = this.getGradientPaintTransformer().transform((GradientPaint)paint, rectangle2D2);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(rectangle2D2);
        if (this.isDrawBarOutline() && Math.abs(valueToJava2D4 - valueToJava2D3) > 3.0) {
            graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(rectangle2D2);
        }
        if (this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, xyDataset, n, n2, xyPlot, this.getItemLabelGenerator(n, n2), rectangle2D2, n5 < 0.0);
        }
        if (plotRenderingInfo != null) {
            final EntityCollection entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
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
                entityCollection.add(new XYItemEntity(rectangle2D2, xyDataset, n, n2, generateToolTip, generateURL));
            }
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof ClusteredXYBarRenderer && super.equals(o) && this.centerBarAtStartValue == ((ClusteredXYBarRenderer)o).centerBarAtStartValue);
    }
    
    public Object clone() {
        return super.clone();
    }
}
