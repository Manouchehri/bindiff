/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class XYStepRenderer
extends XYLineAndShapeRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -8918141928884796108L;

    public XYStepRenderer() {
        this(null, null);
    }

    public XYStepRenderer(XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        this.setBaseToolTipGenerator(xYToolTipGenerator);
        this.setURLGenerator(xYURLGenerator);
        this.setShapesVisible(false);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2;
        double d3;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        double d4 = xYDataset.getXValue(n2, n3);
        double d5 = xYDataset.getYValue(n2, n3);
        if (Double.isNaN(d5)) {
            return;
        }
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d6 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge);
        double d7 = valueAxis2.valueToJava2D(d5, rectangle2D, rectangleEdge2);
        if (n3 > 0) {
            d3 = xYDataset.getXValue(n2, n3 - 1);
            d2 = xYDataset.getYValue(n2, n3 - 1);
            if (!Double.isNaN(d2)) {
                double d8 = valueAxis.valueToJava2D(d3, rectangle2D, rectangleEdge);
                double d9 = valueAxis2.valueToJava2D(d2, rectangle2D, rectangleEdge2);
                Line2D line2D = xYItemRendererState.workingLine;
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    if (d9 == d7) {
                        line2D.setLine(d9, d8, d7, d6);
                        graphics2D.draw(line2D);
                    } else {
                        line2D.setLine(d9, d8, d9, d6);
                        graphics2D.draw(line2D);
                        line2D.setLine(d9, d6, d7, d6);
                        graphics2D.draw(line2D);
                    }
                } else if (plotOrientation == PlotOrientation.VERTICAL) {
                    if (d9 == d7) {
                        line2D.setLine(d8, d9, d6, d7);
                        graphics2D.draw(line2D);
                    } else {
                        line2D.setLine(d8, d9, d6, d9);
                        graphics2D.draw(line2D);
                        line2D.setLine(d6, d9, d6, d7);
                        graphics2D.draw(line2D);
                    }
                }
            }
        }
        if (this.isItemLabelVisible(n2, n3)) {
            d3 = d6;
            d2 = d7;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                d3 = d7;
                d2 = d6;
            }
            this.drawItemLabel(graphics2D, plotOrientation, xYDataset, n2, n3, d3, d2, d5 < 0.0);
        }
        int n5 = xYPlot.getDomainAxisIndex(valueAxis);
        int n6 = xYPlot.getRangeAxisIndex(valueAxis2);
        this.updateCrosshairValues(crosshairState, d4, d5, n5, n6, d6, d7, plotOrientation);
        if (xYItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = xYItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        int n7 = this.getDefaultEntityRadius();
        Rectangle2D.Double double_ = plotOrientation == PlotOrientation.VERTICAL ? new Rectangle2D.Double(d6 - (double)n7, d7 - (double)n7, 2 * n7, 2 * n7) : new Rectangle2D.Double(d7 - (double)n7, d6 - (double)n7, 2 * n7, 2 * n7);
        if (double_ == null) return;
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

    @Override
    public Object clone() {
        return super.clone();
    }
}

