/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class YIntervalRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -2951586537224143260L;

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        Rectangle rectangle = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
        double d2 = intervalXYDataset.getXValue(n2, n3);
        double d3 = intervalXYDataset.getStartYValue(n2, n3);
        double d4 = intervalXYDataset.getEndYValue(n2, n3);
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d5 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d6 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2);
        double d7 = valueAxis2.valueToJava2D(d4, rectangle2D, rectangleEdge2);
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        Line2D.Double double_ = null;
        Shape shape = this.getItemShape(n2, n3);
        Shape shape2 = null;
        Shape shape3 = null;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(d6, d5, d7, d5);
            shape2 = ShapeUtilities.createTranslatedShape(shape, d7, d5);
            shape3 = ShapeUtilities.createTranslatedShape(shape, d6, d5);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(d5, d6, d5, d7);
            shape2 = ShapeUtilities.createTranslatedShape(shape, d5, d7);
            shape3 = ShapeUtilities.createTranslatedShape(shape, d5, d6);
        }
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        graphics2D.draw(double_);
        graphics2D.fill(shape2);
        graphics2D.fill(shape3);
        if (entityCollection == null) return;
        if (rectangle == null) {
            rectangle = double_.getBounds();
        }
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string2 = null;
        if (this.getURLGenerator() != null) {
            string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(rectangle, xYDataset, n2, n3, string, string2);
        entityCollection.add(xYItemEntity);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

