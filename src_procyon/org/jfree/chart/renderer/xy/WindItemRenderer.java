package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.ui.*;

public class WindItemRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = 8078914101916976844L;
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final WindDataset windDataset = (WindDataset)xyDataset;
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        final Number x = windDataset.getX(n, n2);
        final Number windDirection = windDataset.getWindDirection(n, n2);
        final Number windForce = windDataset.getWindForce(n, n2);
        final double doubleValue = windForce.doubleValue();
        final double radians = Math.toRadians(windDirection.doubleValue() * -30.0 - 90.0);
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(x.doubleValue(), rectangle2D, domainAxisEdge);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(0.0, rectangle2D, rangeAxisEdge);
        final double n4 = x.doubleValue() + doubleValue * Math.cos(radians) * 8000000.0;
        final double n5 = doubleValue * Math.sin(radians);
        final double valueToJava2D3 = valueAxis.valueToJava2D(n4, rectangle2D, domainAxisEdge);
        final double valueToJava2D4 = valueAxis2.valueToJava2D(n5, rectangle2D, rangeAxisEdge);
        final String string = windDirection.intValue() + "-" + windForce.intValue();
        graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D2, valueToJava2D3, valueToJava2D4));
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(new Font("foo", 1, 9));
        graphics2D.drawString(string, (float)valueToJava2D, (float)valueToJava2D2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        final double radians2 = Math.toRadians(windDirection.doubleValue() * -30.0 - 90.0 - 5.0);
        graphics2D.draw(new Line2D.Double(valueAxis.valueToJava2D(windForce.doubleValue() * Math.cos(radians2) * 8000000.0 * 0.8 + x.doubleValue(), rectangle2D, domainAxisEdge), valueAxis2.valueToJava2D(windForce.doubleValue() * Math.sin(radians2) * 0.8, rectangle2D, rangeAxisEdge), valueToJava2D3, valueToJava2D4));
        final double radians3 = Math.toRadians(windDirection.doubleValue() * -30.0 - 90.0 + 5.0);
        graphics2D.draw(new Line2D.Double(valueAxis.valueToJava2D(windForce.doubleValue() * Math.cos(radians3) * 8000000.0 * 0.8 + x.doubleValue(), rectangle2D, domainAxisEdge), valueAxis2.valueToJava2D(windForce.doubleValue() * Math.sin(radians3) * 0.8, rectangle2D, rangeAxisEdge), valueToJava2D3, valueToJava2D4));
    }
    
    public Object clone() {
        return super.clone();
    }
}
