package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.chart.entity.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.labels.*;

public class YIntervalRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -2951586537224143260L;
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        Shape bounds = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
        final double xValue = intervalXYDataset.getXValue(n, n2);
        final double startYValue = intervalXYDataset.getStartYValue(n, n2);
        final double endYValue = intervalXYDataset.getEndYValue(n, n2);
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(startYValue, rectangle2D, rangeAxisEdge);
        final double valueToJava2D3 = valueAxis2.valueToJava2D(endYValue, rectangle2D, rangeAxisEdge);
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        Line2D line2D = null;
        final Shape itemShape = this.getItemShape(n, n2);
        Shape shape = null;
        Shape shape2 = null;
        final PlotOrientation orientation = xyPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            line2D = new Line2D.Double(valueToJava2D2, valueToJava2D, valueToJava2D3, valueToJava2D);
            shape = ShapeUtilities.createTranslatedShape(itemShape, valueToJava2D3, valueToJava2D);
            shape2 = ShapeUtilities.createTranslatedShape(itemShape, valueToJava2D2, valueToJava2D);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            line2D = new Line2D.Double(valueToJava2D, valueToJava2D2, valueToJava2D, valueToJava2D3);
            shape = ShapeUtilities.createTranslatedShape(itemShape, valueToJava2D, valueToJava2D3);
            shape2 = ShapeUtilities.createTranslatedShape(itemShape, valueToJava2D, valueToJava2D2);
        }
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        graphics2D.draw(line2D);
        graphics2D.fill(shape);
        graphics2D.fill(shape2);
        if (entityCollection != null) {
            if (bounds == null) {
                bounds = line2D.getBounds();
            }
            String generateToolTip = null;
            final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
            if (toolTipGenerator != null) {
                generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
            }
            String generateURL = null;
            if (this.getURLGenerator() != null) {
                generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
            }
            entityCollection.add(new XYItemEntity(bounds, xyDataset, n, n2, generateToolTip, generateURL));
        }
    }
    
    public Object clone() {
        return super.clone();
    }
}
