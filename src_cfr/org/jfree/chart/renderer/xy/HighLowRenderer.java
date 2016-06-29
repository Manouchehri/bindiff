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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class HighLowRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -8135673815876552516L;
    private boolean drawOpenTicks = true;
    private boolean drawCloseTicks = true;
    private transient Paint openTickPaint;
    private transient Paint closeTickPaint;

    public boolean getDrawOpenTicks() {
        return this.drawOpenTicks;
    }

    public void setDrawOpenTicks(boolean bl2) {
        this.drawOpenTicks = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getDrawCloseTicks() {
        return this.drawCloseTicks;
    }

    public void setDrawCloseTicks(boolean bl2) {
        this.drawCloseTicks = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getOpenTickPaint() {
        return this.openTickPaint;
    }

    public void setOpenTickPaint(Paint paint) {
        this.openTickPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getCloseTickPaint() {
        return this.closeTickPaint;
    }

    public void setCloseTickPaint(Paint paint) {
        this.closeTickPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        Object object;
        double d2 = xYDataset.getXValue(n2, n3);
        if (!valueAxis.getRange().contains(d2)) {
            return;
        }
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        Rectangle2D.Double double_ = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = xYPlot.getRangeAxisEdge();
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        if (xYDataset instanceof OHLCDataset) {
            double d4;
            double d5;
            double d6;
            object = (OHLCDataset)xYDataset;
            double d7 = object.getHighValue(n2, n3);
            double d8 = object.getLowValue(n2, n3);
            if (!Double.isNaN(d7) && !Double.isNaN(d8)) {
                d5 = valueAxis2.valueToJava2D(d7, rectangle2D, rectangleEdge);
                d6 = valueAxis2.valueToJava2D(d8, rectangle2D, rectangleEdge);
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    graphics2D.draw(new Line2D.Double(d6, d3, d5, d3));
                    double_ = new Rectangle2D.Double(Math.min(d6, d5), d3 - 1.0, Math.abs(d5 - d6), 2.0);
                } else if (plotOrientation == PlotOrientation.VERTICAL) {
                    graphics2D.draw(new Line2D.Double(d3, d6, d3, d5));
                    double_ = new Rectangle2D.Double(d3 - 1.0, Math.min(d6, d5), 2.0, Math.abs(d5 - d6));
                }
            }
            d5 = 2.0;
            if (valueAxis.isInverted()) {
                d5 = - d5;
            }
            if (this.getDrawOpenTicks() && !Double.isNaN(d6 = object.getOpenValue(n2, n3))) {
                d4 = valueAxis2.valueToJava2D(d6, rectangle2D, rectangleEdge);
                if (this.openTickPaint != null) {
                    graphics2D.setPaint(this.openTickPaint);
                } else {
                    graphics2D.setPaint(paint);
                }
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    graphics2D.draw(new Line2D.Double(d4, d3 + d5, d4, d3));
                } else if (plotOrientation == PlotOrientation.VERTICAL) {
                    graphics2D.draw(new Line2D.Double(d3 - d5, d4, d3, d4));
                }
            }
            if (this.getDrawCloseTicks() && !Double.isNaN(d6 = object.getCloseValue(n2, n3))) {
                d4 = valueAxis2.valueToJava2D(d6, rectangle2D, rectangleEdge);
                if (this.closeTickPaint != null) {
                    graphics2D.setPaint(this.closeTickPaint);
                } else {
                    graphics2D.setPaint(paint);
                }
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    graphics2D.draw(new Line2D.Double(d4, d3, d4, d3 - d5));
                } else if (plotOrientation == PlotOrientation.VERTICAL) {
                    graphics2D.draw(new Line2D.Double(d3, d4, d3 + d5, d4));
                }
            }
        } else if (n3 > 0) {
            double d9 = xYDataset.getXValue(n2, n3 - 1);
            double d10 = xYDataset.getYValue(n2, n3 - 1);
            double d11 = xYDataset.getYValue(n2, n3);
            if (Double.isNaN(d9)) return;
            if (Double.isNaN(d10)) return;
            if (Double.isNaN(d11)) {
                return;
            }
            double d12 = valueAxis.valueToJava2D(d9, rectangle2D, xYPlot.getDomainAxisEdge());
            double d13 = valueAxis2.valueToJava2D(d10, rectangle2D, rectangleEdge);
            double d14 = valueAxis2.valueToJava2D(d11, rectangle2D, rectangleEdge);
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                graphics2D.draw(new Line2D.Double(d13, d12, d14, d3));
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                graphics2D.draw(new Line2D.Double(d12, d13, d3, d14));
            }
        }
        if (entityCollection == null) return;
        object = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            object = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string = null;
        if (this.getURLGenerator() != null) {
            string = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(double_, xYDataset, n2, n3, (String)object, string);
        entityCollection.add(xYItemEntity);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof HighLowRenderer)) {
            return false;
        }
        HighLowRenderer highLowRenderer = (HighLowRenderer)object;
        if (this.drawOpenTicks != highLowRenderer.drawOpenTicks) {
            return false;
        }
        if (this.drawCloseTicks != highLowRenderer.drawCloseTicks) {
            return false;
        }
        if (!PaintUtilities.equal(this.openTickPaint, highLowRenderer.openTickPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.closeTickPaint, highLowRenderer.closeTickPaint)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.openTickPaint = SerialUtilities.readPaint(objectInputStream);
        this.closeTickPaint = SerialUtilities.readPaint(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.openTickPaint, objectOutputStream);
        SerialUtilities.writePaint(this.closeTickPaint, objectOutputStream);
    }
}

