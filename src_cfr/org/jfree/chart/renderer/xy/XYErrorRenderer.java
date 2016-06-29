/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

public class XYErrorRenderer
extends XYLineAndShapeRenderer {
    private boolean drawXError = true;
    private boolean drawYError = true;
    private double capLength = 4.0;
    private transient Paint errorPaint = null;

    public XYErrorRenderer() {
        super(false, true);
    }

    public boolean getDrawXError() {
        return this.drawXError;
    }

    public void setDrawXError(boolean bl2) {
        if (this.drawXError == bl2) return;
        this.drawXError = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getDrawYError() {
        return this.drawYError;
    }

    public void setDrawYError(boolean bl2) {
        if (this.drawYError == bl2) return;
        this.drawYError = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getCapLength() {
        return this.capLength;
    }

    public void setCapLength(double d2) {
        this.capLength = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getErrorPaint() {
        return this.errorPaint;
    }

    public void setErrorPaint(Paint paint) {
        this.errorPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public Range findDomainBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        return DatasetUtilities.findDomainBounds(xYDataset, true);
    }

    @Override
    public Range findRangeBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        return DatasetUtilities.findRangeBounds(xYDataset, true);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        if (n4 == 0 && xYDataset instanceof IntervalXYDataset && this.getItemVisible(n2, n3)) {
            double d2;
            double d3;
            double d4;
            double d5;
            Line2D.Double double_;
            RectangleEdge rectangleEdge;
            Line2D.Double double_2;
            double d6;
            double d7;
            double d8;
            Line2D.Double double_3;
            IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
            PlotOrientation plotOrientation = xYPlot.getOrientation();
            if (this.drawXError) {
                d8 = intervalXYDataset.getStartXValue(n2, n3);
                d4 = intervalXYDataset.getEndXValue(n2, n3);
                d6 = intervalXYDataset.getYValue(n2, n3);
                rectangleEdge = xYPlot.getDomainAxisEdge();
                d5 = valueAxis.valueToJava2D(d8, rectangle2D, rectangleEdge);
                d7 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge);
                d3 = valueAxis2.valueToJava2D(d6, rectangle2D, xYPlot.getRangeAxisEdge());
                double_ = null;
                double_3 = null;
                d2 = this.capLength / 2.0;
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    double_2 = new Line2D.Double(d5, d3, d7, d3);
                    double_ = new Line2D.Double(d5, d3 - d2, d5, d3 + d2);
                    double_3 = new Line2D.Double(d7, d3 - d2, d7, d3 + d2);
                } else {
                    double_2 = new Line2D.Double(d3, d5, d3, d7);
                    double_ = new Line2D.Double(d3 - d2, d5, d3 + d2, d5);
                    double_3 = new Line2D.Double(d3 - d2, d7, d3 + d2, d7);
                }
                graphics2D.setStroke(new BasicStroke(1.0f));
                if (this.errorPaint != null) {
                    graphics2D.setPaint(this.errorPaint);
                } else {
                    graphics2D.setPaint(this.getItemPaint(n2, n3));
                }
                graphics2D.draw(double_2);
                graphics2D.draw(double_);
                graphics2D.draw(double_3);
            }
            if (this.drawYError) {
                d8 = intervalXYDataset.getStartYValue(n2, n3);
                d4 = intervalXYDataset.getEndYValue(n2, n3);
                d6 = intervalXYDataset.getXValue(n2, n3);
                rectangleEdge = xYPlot.getRangeAxisEdge();
                d5 = valueAxis2.valueToJava2D(d8, rectangle2D, rectangleEdge);
                d7 = valueAxis2.valueToJava2D(d4, rectangle2D, rectangleEdge);
                d3 = valueAxis.valueToJava2D(d6, rectangle2D, xYPlot.getDomainAxisEdge());
                double_ = null;
                double_3 = null;
                d2 = this.capLength / 2.0;
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    double_2 = new Line2D.Double(d3, d5, d3, d7);
                    double_ = new Line2D.Double(d3 - d2, d5, d3 + d2, d5);
                    double_3 = new Line2D.Double(d3 - d2, d7, d3 + d2, d7);
                } else {
                    double_2 = new Line2D.Double(d5, d3, d7, d3);
                    double_ = new Line2D.Double(d5, d3 - d2, d5, d3 + d2);
                    double_3 = new Line2D.Double(d7, d3 - d2, d7, d3 + d2);
                }
                graphics2D.setStroke(new BasicStroke(1.0f));
                if (this.errorPaint != null) {
                    graphics2D.setPaint(this.errorPaint);
                } else {
                    graphics2D.setPaint(this.getItemPaint(n2, n3));
                }
                graphics2D.draw(double_2);
                graphics2D.draw(double_);
                graphics2D.draw(double_3);
            }
        }
        super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState, n4);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYErrorRenderer)) {
            return false;
        }
        XYErrorRenderer xYErrorRenderer = (XYErrorRenderer)object;
        if (this.drawXError != xYErrorRenderer.drawXError) {
            return false;
        }
        if (this.drawYError != xYErrorRenderer.drawYError) {
            return false;
        }
        if (this.capLength != xYErrorRenderer.capLength) {
            return false;
        }
        if (PaintUtilities.equal(this.errorPaint, xYErrorRenderer.errorPaint)) return super.equals(object);
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.errorPaint = SerialUtilities.readPaint(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.errorPaint, objectOutputStream);
    }
}

