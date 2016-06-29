package org.jfree.chart.renderer.xy;

import org.jfree.chart.event.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.chart.entity.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class HighLowRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -8135673815876552516L;
    private boolean drawOpenTicks;
    private boolean drawCloseTicks;
    private transient Paint openTickPaint;
    private transient Paint closeTickPaint;
    
    public HighLowRenderer() {
        this.drawOpenTicks = true;
        this.drawCloseTicks = true;
    }
    
    public boolean getDrawOpenTicks() {
        return this.drawOpenTicks;
    }
    
    public void setDrawOpenTicks(final boolean drawOpenTicks) {
        this.drawOpenTicks = drawOpenTicks;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getDrawCloseTicks() {
        return this.drawCloseTicks;
    }
    
    public void setDrawCloseTicks(final boolean drawCloseTicks) {
        this.drawCloseTicks = drawCloseTicks;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getOpenTickPaint() {
        return this.openTickPaint;
    }
    
    public void setOpenTickPaint(final Paint openTickPaint) {
        this.openTickPaint = openTickPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getCloseTickPaint() {
        return this.closeTickPaint;
    }
    
    public void setCloseTickPaint(final Paint closeTickPaint) {
        this.closeTickPaint = closeTickPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final double xValue = xyDataset.getXValue(n, n2);
        if (!valueAxis.getRange().contains(xValue)) {
            return;
        }
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, xyPlot.getDomainAxisEdge());
        Shape shape = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        if (xyDataset instanceof OHLCDataset) {
            final OHLCDataset ohlcDataset = (OHLCDataset)xyDataset;
            final double highValue = ohlcDataset.getHighValue(n, n2);
            final double lowValue = ohlcDataset.getLowValue(n, n2);
            if (!Double.isNaN(highValue) && !Double.isNaN(lowValue)) {
                final double valueToJava2D2 = valueAxis2.valueToJava2D(highValue, rectangle2D, rangeAxisEdge);
                final double valueToJava2D3 = valueAxis2.valueToJava2D(lowValue, rectangle2D, rangeAxisEdge);
                if (orientation == PlotOrientation.HORIZONTAL) {
                    graphics2D.draw(new Line2D.Double(valueToJava2D3, valueToJava2D, valueToJava2D2, valueToJava2D));
                    shape = new Rectangle2D.Double(Math.min(valueToJava2D3, valueToJava2D2), valueToJava2D - 1.0, Math.abs(valueToJava2D2 - valueToJava2D3), 2.0);
                }
                else if (orientation == PlotOrientation.VERTICAL) {
                    graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D3, valueToJava2D, valueToJava2D2));
                    shape = new Rectangle2D.Double(valueToJava2D - 1.0, Math.min(valueToJava2D3, valueToJava2D2), 2.0, Math.abs(valueToJava2D2 - valueToJava2D3));
                }
            }
            double n4 = 2.0;
            if (valueAxis.isInverted()) {
                n4 = -n4;
            }
            if (this.getDrawOpenTicks()) {
                final double openValue = ohlcDataset.getOpenValue(n, n2);
                if (!Double.isNaN(openValue)) {
                    final double valueToJava2D4 = valueAxis2.valueToJava2D(openValue, rectangle2D, rangeAxisEdge);
                    if (this.openTickPaint != null) {
                        graphics2D.setPaint(this.openTickPaint);
                    }
                    else {
                        graphics2D.setPaint(itemPaint);
                    }
                    if (orientation == PlotOrientation.HORIZONTAL) {
                        graphics2D.draw(new Line2D.Double(valueToJava2D4, valueToJava2D + n4, valueToJava2D4, valueToJava2D));
                    }
                    else if (orientation == PlotOrientation.VERTICAL) {
                        graphics2D.draw(new Line2D.Double(valueToJava2D - n4, valueToJava2D4, valueToJava2D, valueToJava2D4));
                    }
                }
            }
            if (this.getDrawCloseTicks()) {
                final double closeValue = ohlcDataset.getCloseValue(n, n2);
                if (!Double.isNaN(closeValue)) {
                    final double valueToJava2D5 = valueAxis2.valueToJava2D(closeValue, rectangle2D, rangeAxisEdge);
                    if (this.closeTickPaint != null) {
                        graphics2D.setPaint(this.closeTickPaint);
                    }
                    else {
                        graphics2D.setPaint(itemPaint);
                    }
                    if (orientation == PlotOrientation.HORIZONTAL) {
                        graphics2D.draw(new Line2D.Double(valueToJava2D5, valueToJava2D, valueToJava2D5, valueToJava2D - n4));
                    }
                    else if (orientation == PlotOrientation.VERTICAL) {
                        graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D5, valueToJava2D + n4, valueToJava2D5));
                    }
                }
            }
        }
        else if (n2 > 0) {
            final double xValue2 = xyDataset.getXValue(n, n2 - 1);
            final double yValue = xyDataset.getYValue(n, n2 - 1);
            final double yValue2 = xyDataset.getYValue(n, n2);
            if (Double.isNaN(xValue2) || Double.isNaN(yValue) || Double.isNaN(yValue2)) {
                return;
            }
            final double valueToJava2D6 = valueAxis.valueToJava2D(xValue2, rectangle2D, xyPlot.getDomainAxisEdge());
            final double valueToJava2D7 = valueAxis2.valueToJava2D(yValue, rectangle2D, rangeAxisEdge);
            final double valueToJava2D8 = valueAxis2.valueToJava2D(yValue2, rectangle2D, rangeAxisEdge);
            if (orientation == PlotOrientation.HORIZONTAL) {
                graphics2D.draw(new Line2D.Double(valueToJava2D7, valueToJava2D6, valueToJava2D8, valueToJava2D));
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                graphics2D.draw(new Line2D.Double(valueToJava2D6, valueToJava2D7, valueToJava2D, valueToJava2D8));
            }
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
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HighLowRenderer)) {
            return false;
        }
        final HighLowRenderer highLowRenderer = (HighLowRenderer)o;
        return this.drawOpenTicks == highLowRenderer.drawOpenTicks && this.drawCloseTicks == highLowRenderer.drawCloseTicks && PaintUtilities.equal(this.openTickPaint, highLowRenderer.openTickPaint) && PaintUtilities.equal(this.closeTickPaint, highLowRenderer.closeTickPaint) && super.equals(o);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.openTickPaint = SerialUtilities.readPaint(objectInputStream);
        this.closeTickPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.openTickPaint, objectOutputStream);
        SerialUtilities.writePaint(this.closeTickPaint, objectOutputStream);
    }
}
