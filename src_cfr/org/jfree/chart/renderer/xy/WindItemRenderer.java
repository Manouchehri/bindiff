/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class WindItemRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = 8078914101916976844L;

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        WindDataset windDataset = (WindDataset)xYDataset;
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        Number number = windDataset.getX(n2, n3);
        Number number2 = windDataset.getWindDirection(n2, n3);
        Number number3 = windDataset.getWindForce(n2, n3);
        double d2 = number3.doubleValue();
        double d3 = Math.toRadians(number2.doubleValue() * -30.0 - 90.0);
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d4 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, rectangleEdge);
        double d5 = valueAxis2.valueToJava2D(0.0, rectangle2D, rectangleEdge2);
        double d6 = number.doubleValue() + d2 * Math.cos(d3) * 8000000.0;
        double d7 = d2 * Math.sin(d3);
        double d8 = valueAxis.valueToJava2D(d6, rectangle2D, rectangleEdge);
        double d9 = valueAxis2.valueToJava2D(d7, rectangle2D, rectangleEdge2);
        int n5 = number2.intValue();
        int n6 = number3.intValue();
        String string = new StringBuffer().append(n5).append("-").append(n6).toString();
        Line2D.Double double_ = new Line2D.Double(d4, d5, d8, d9);
        graphics2D.draw(double_);
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(new Font("foo", 1, 9));
        graphics2D.drawString(string, (float)d4, (float)d5);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        double d10 = Math.toRadians(number2.doubleValue() * -30.0 - 90.0 - 5.0);
        double d11 = number3.doubleValue() * Math.cos(d10) * 8000000.0 * 0.8 + number.doubleValue();
        double d12 = number3.doubleValue() * Math.sin(d10) * 0.8;
        double d13 = valueAxis.valueToJava2D(d11, rectangle2D, rectangleEdge);
        double d14 = valueAxis2.valueToJava2D(d12, rectangle2D, rectangleEdge2);
        double_ = new Line2D.Double(d13, d14, d8, d9);
        graphics2D.draw(double_);
        double d15 = Math.toRadians(number2.doubleValue() * -30.0 - 90.0 + 5.0);
        double d16 = number3.doubleValue() * Math.cos(d15) * 8000000.0 * 0.8 + number.doubleValue();
        double d17 = number3.doubleValue() * Math.sin(d15) * 0.8;
        double d18 = valueAxis.valueToJava2D(d16, rectangle2D, rectangleEdge);
        double d19 = valueAxis2.valueToJava2D(d17, rectangle2D, rectangleEdge2);
        double_ = new Line2D.Double(d18, d19, d8, d9);
        graphics2D.draw(double_);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

