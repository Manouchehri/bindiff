package org.jfree.chart.renderer.xy;

import org.jfree.chart.event.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYErrorRenderer extends XYLineAndShapeRenderer
{
    private boolean drawXError;
    private boolean drawYError;
    private double capLength;
    private transient Paint errorPaint;
    
    public XYErrorRenderer() {
        super(false, true);
        this.drawXError = true;
        this.drawYError = true;
        this.errorPaint = null;
        this.capLength = 4.0;
    }
    
    public boolean getDrawXError() {
        return this.drawXError;
    }
    
    public void setDrawXError(final boolean drawXError) {
        if (this.drawXError != drawXError) {
            this.drawXError = drawXError;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public boolean getDrawYError() {
        return this.drawYError;
    }
    
    public void setDrawYError(final boolean drawYError) {
        if (this.drawYError != drawYError) {
            this.drawYError = drawYError;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public double getCapLength() {
        return this.capLength;
    }
    
    public void setCapLength(final double capLength) {
        this.capLength = capLength;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getErrorPaint() {
        return this.errorPaint;
    }
    
    public void setErrorPaint(final Paint errorPaint) {
        this.errorPaint = errorPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Range findDomainBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            return DatasetUtilities.findDomainBounds(xyDataset, true);
        }
        return null;
    }
    
    public Range findRangeBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            return DatasetUtilities.findRangeBounds(xyDataset, true);
        }
        return null;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (n3 == 0 && xyDataset instanceof IntervalXYDataset && this.getItemVisible(n, n2)) {
            final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
            final PlotOrientation orientation = xyPlot.getOrientation();
            if (this.drawXError) {
                final double startXValue = intervalXYDataset.getStartXValue(n, n2);
                final double endXValue = intervalXYDataset.getEndXValue(n, n2);
                final double yValue = intervalXYDataset.getYValue(n, n2);
                final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
                final double valueToJava2D = valueAxis.valueToJava2D(startXValue, rectangle2D, domainAxisEdge);
                final double valueToJava2D2 = valueAxis.valueToJava2D(endXValue, rectangle2D, domainAxisEdge);
                final double valueToJava2D3 = valueAxis2.valueToJava2D(yValue, rectangle2D, xyPlot.getRangeAxisEdge());
                final double n4 = this.capLength / 2.0;
                Line2D.Double double1;
                Line2D.Double double2;
                Line2D.Double double3;
                if (orientation == PlotOrientation.VERTICAL) {
                    double1 = new Line2D.Double(valueToJava2D, valueToJava2D3, valueToJava2D2, valueToJava2D3);
                    double2 = new Line2D.Double(valueToJava2D, valueToJava2D3 - n4, valueToJava2D, valueToJava2D3 + n4);
                    double3 = new Line2D.Double(valueToJava2D2, valueToJava2D3 - n4, valueToJava2D2, valueToJava2D3 + n4);
                }
                else {
                    double1 = new Line2D.Double(valueToJava2D3, valueToJava2D, valueToJava2D3, valueToJava2D2);
                    double2 = new Line2D.Double(valueToJava2D3 - n4, valueToJava2D, valueToJava2D3 + n4, valueToJava2D);
                    double3 = new Line2D.Double(valueToJava2D3 - n4, valueToJava2D2, valueToJava2D3 + n4, valueToJava2D2);
                }
                graphics2D.setStroke(new BasicStroke(1.0f));
                if (this.errorPaint != null) {
                    graphics2D.setPaint(this.errorPaint);
                }
                else {
                    graphics2D.setPaint(this.getItemPaint(n, n2));
                }
                graphics2D.draw(double1);
                graphics2D.draw(double2);
                graphics2D.draw(double3);
            }
            if (this.drawYError) {
                final double startYValue = intervalXYDataset.getStartYValue(n, n2);
                final double endYValue = intervalXYDataset.getEndYValue(n, n2);
                final double xValue = intervalXYDataset.getXValue(n, n2);
                final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
                final double valueToJava2D4 = valueAxis2.valueToJava2D(startYValue, rectangle2D, rangeAxisEdge);
                final double valueToJava2D5 = valueAxis2.valueToJava2D(endYValue, rectangle2D, rangeAxisEdge);
                final double valueToJava2D6 = valueAxis.valueToJava2D(xValue, rectangle2D, xyPlot.getDomainAxisEdge());
                final double n5 = this.capLength / 2.0;
                Line2D.Double double4;
                Line2D.Double double5;
                Line2D.Double double6;
                if (orientation == PlotOrientation.VERTICAL) {
                    double4 = new Line2D.Double(valueToJava2D6, valueToJava2D4, valueToJava2D6, valueToJava2D5);
                    double5 = new Line2D.Double(valueToJava2D6 - n5, valueToJava2D4, valueToJava2D6 + n5, valueToJava2D4);
                    double6 = new Line2D.Double(valueToJava2D6 - n5, valueToJava2D5, valueToJava2D6 + n5, valueToJava2D5);
                }
                else {
                    double4 = new Line2D.Double(valueToJava2D4, valueToJava2D6, valueToJava2D5, valueToJava2D6);
                    double5 = new Line2D.Double(valueToJava2D4, valueToJava2D6 - n5, valueToJava2D4, valueToJava2D6 + n5);
                    double6 = new Line2D.Double(valueToJava2D5, valueToJava2D6 - n5, valueToJava2D5, valueToJava2D6 + n5);
                }
                graphics2D.setStroke(new BasicStroke(1.0f));
                if (this.errorPaint != null) {
                    graphics2D.setPaint(this.errorPaint);
                }
                else {
                    graphics2D.setPaint(this.getItemPaint(n, n2));
                }
                graphics2D.draw(double4);
                graphics2D.draw(double5);
                graphics2D.draw(double6);
            }
        }
        super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState, n3);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYErrorRenderer)) {
            return false;
        }
        final XYErrorRenderer xyErrorRenderer = (XYErrorRenderer)o;
        return this.drawXError == xyErrorRenderer.drawXError && this.drawYError == xyErrorRenderer.drawYError && this.capLength == xyErrorRenderer.capLength && PaintUtilities.equal(this.errorPaint, xyErrorRenderer.errorPaint) && super.equals(o);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.errorPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.errorPaint, objectOutputStream);
    }
}
