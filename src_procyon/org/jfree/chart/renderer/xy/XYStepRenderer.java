package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.chart.entity.*;

public class XYStepRenderer extends XYLineAndShapeRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -8918141928884796108L;
    
    public XYStepRenderer() {
        this(null, null);
    }
    
    public XYStepRenderer(final XYToolTipGenerator baseToolTipGenerator, final XYURLGenerator urlGenerator) {
        this.setBaseToolTipGenerator(baseToolTipGenerator);
        this.setURLGenerator(urlGenerator);
        this.setShapesVisible(false);
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        final double xValue = xyDataset.getXValue(n, n2);
        final double yValue = xyDataset.getYValue(n, n2);
        if (Double.isNaN(yValue)) {
            return;
        }
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
        if (n2 > 0) {
            final double xValue2 = xyDataset.getXValue(n, n2 - 1);
            final double yValue2 = xyDataset.getYValue(n, n2 - 1);
            if (!Double.isNaN(yValue2)) {
                final double valueToJava2D3 = valueAxis.valueToJava2D(xValue2, rectangle2D, domainAxisEdge);
                final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue2, rectangle2D, rangeAxisEdge);
                final Line2D workingLine = xyItemRendererState.workingLine;
                if (orientation == PlotOrientation.HORIZONTAL) {
                    if (valueToJava2D4 == valueToJava2D2) {
                        workingLine.setLine(valueToJava2D4, valueToJava2D3, valueToJava2D2, valueToJava2D);
                        graphics2D.draw(workingLine);
                    }
                    else {
                        workingLine.setLine(valueToJava2D4, valueToJava2D3, valueToJava2D4, valueToJava2D);
                        graphics2D.draw(workingLine);
                        workingLine.setLine(valueToJava2D4, valueToJava2D, valueToJava2D2, valueToJava2D);
                        graphics2D.draw(workingLine);
                    }
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    if (valueToJava2D4 == valueToJava2D2) {
                        workingLine.setLine(valueToJava2D3, valueToJava2D4, valueToJava2D, valueToJava2D2);
                        graphics2D.draw(workingLine);
                    }
                    else {
                        workingLine.setLine(valueToJava2D3, valueToJava2D4, valueToJava2D, valueToJava2D4);
                        graphics2D.draw(workingLine);
                        workingLine.setLine(valueToJava2D, valueToJava2D4, valueToJava2D, valueToJava2D2);
                        graphics2D.draw(workingLine);
                    }
                }
            }
        }
        if (this.isItemLabelVisible(n, n2)) {
            double n4 = valueToJava2D;
            double n5 = valueToJava2D2;
            if (orientation == PlotOrientation.HORIZONTAL) {
                n4 = valueToJava2D2;
                n5 = valueToJava2D;
            }
            this.drawItemLabel(graphics2D, orientation, xyDataset, n, n2, n4, n5, yValue < 0.0);
        }
        this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, valueToJava2D2, orientation);
        if (xyItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = xyItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                final int defaultEntityRadius = this.getDefaultEntityRadius();
                final Rectangle2D.Double double1 = (orientation == PlotOrientation.VERTICAL) ? new Rectangle2D.Double(valueToJava2D - defaultEntityRadius, valueToJava2D2 - defaultEntityRadius, 2 * defaultEntityRadius, 2 * defaultEntityRadius) : new Rectangle2D.Double(valueToJava2D2 - defaultEntityRadius, valueToJava2D - defaultEntityRadius, 2 * defaultEntityRadius, 2 * defaultEntityRadius);
                if (double1 != null) {
                    String generateToolTip = null;
                    final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                    if (toolTipGenerator != null) {
                        generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
                    }
                    String generateURL = null;
                    if (this.getURLGenerator() != null) {
                        generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
                    }
                    entityCollection.add(new XYItemEntity(double1, xyDataset, n, n2, generateToolTip, generateURL));
                }
            }
        }
    }
    
    public Object clone() {
        return super.clone();
    }
}
