/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
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
import org.jfree.chart.labels.HighLowItemLabelGenerator;
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
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class CandlestickRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = 50390395841817121L;
    public static final int WIDTHMETHOD_AVERAGE = 0;
    public static final int WIDTHMETHOD_SMALLEST = 1;
    public static final int WIDTHMETHOD_INTERVALDATA = 2;
    private int autoWidthMethod = 0;
    private double autoWidthFactor = 0.6428571428571429;
    private double autoWidthGap = 0.0;
    private double candleWidth;
    private double maxCandleWidthInMilliseconds = 7.2E7;
    private double maxCandleWidth;
    private transient Paint upPaint;
    private transient Paint downPaint;
    private boolean drawVolume;
    private transient double maxVolume;
    private boolean useOutlinePaint;

    public CandlestickRenderer() {
        this(-1.0);
    }

    public CandlestickRenderer(double d2) {
        this(d2, true, new HighLowItemLabelGenerator());
    }

    public CandlestickRenderer(double d2, boolean bl2, XYToolTipGenerator xYToolTipGenerator) {
        this.setToolTipGenerator(xYToolTipGenerator);
        this.candleWidth = d2;
        this.drawVolume = bl2;
        this.upPaint = Color.green;
        this.downPaint = Color.red;
        this.useOutlinePaint = false;
    }

    public double getCandleWidth() {
        return this.candleWidth;
    }

    public void setCandleWidth(double d2) {
        if (d2 == this.candleWidth) return;
        this.candleWidth = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getMaxCandleWidthInMilliseconds() {
        return this.maxCandleWidthInMilliseconds;
    }

    public void setMaxCandleWidthInMilliseconds(double d2) {
        this.maxCandleWidthInMilliseconds = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public int getAutoWidthMethod() {
        return this.autoWidthMethod;
    }

    public void setAutoWidthMethod(int n2) {
        if (this.autoWidthMethod == n2) return;
        this.autoWidthMethod = n2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getAutoWidthFactor() {
        return this.autoWidthFactor;
    }

    public void setAutoWidthFactor(double d2) {
        if (this.autoWidthFactor == d2) return;
        this.autoWidthFactor = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getAutoWidthGap() {
        return this.autoWidthGap;
    }

    public void setAutoWidthGap(double d2) {
        if (this.autoWidthGap == d2) return;
        this.autoWidthGap = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getUpPaint() {
        return this.upPaint;
    }

    public void setUpPaint(Paint paint) {
        this.upPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getDownPaint() {
        return this.downPaint;
    }

    public void setDownPaint(Paint paint) {
        this.downPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean drawVolume() {
        return this.drawVolume;
    }

    public boolean getDrawVolume() {
        return this.drawVolume;
    }

    public void setDrawVolume(boolean bl2) {
        if (this.drawVolume == bl2) return;
        this.drawVolume = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getUseOutlinePaint() {
        return this.useOutlinePaint;
    }

    public void setUseOutlinePaint(boolean bl2) {
        if (this.useOutlinePaint == bl2) return;
        this.useOutlinePaint = bl2;
        this.fireChangeEvent();
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double d2 = valueAxis.getLowerBound();
        double d3 = d2 + this.maxCandleWidthInMilliseconds;
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d5 = valueAxis.valueToJava2D(d3, rectangle2D, rectangleEdge);
        this.maxCandleWidth = Math.abs(d5 - d4);
        if (!this.drawVolume) return new XYItemRendererState(plotRenderingInfo);
        OHLCDataset oHLCDataset = (OHLCDataset)xYDataset;
        this.maxVolume = 0.0;
        int n2 = 0;
        while (n2 < oHLCDataset.getSeriesCount()) {
            for (int i2 = 0; i2 < oHLCDataset.getItemCount(n2); ++i2) {
                double d6 = oHLCDataset.getVolumeValue(n2, i2);
                if (d6 <= this.maxVolume) continue;
                this.maxVolume = d6;
            }
            ++n2;
        }
        return new XYItemRendererState(plotRenderingInfo);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2;
        double d3;
        boolean bl2;
        double d4;
        double d5;
        Object object;
        double d6;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            bl2 = true;
        } else {
            if (plotOrientation != PlotOrientation.VERTICAL) return;
            bl2 = false;
        }
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        OHLCDataset oHLCDataset = (OHLCDataset)xYDataset;
        double d7 = oHLCDataset.getXValue(n2, n3);
        double d8 = oHLCDataset.getHighValue(n2, n3);
        double d9 = oHLCDataset.getLowValue(n2, n3);
        double d10 = oHLCDataset.getOpenValue(n2, n3);
        double d11 = oHLCDataset.getCloseValue(n2, n3);
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        double d12 = valueAxis.valueToJava2D(d7, rectangle2D, rectangleEdge);
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d13 = valueAxis2.valueToJava2D(d8, rectangle2D, rectangleEdge2);
        double d14 = valueAxis2.valueToJava2D(d9, rectangle2D, rectangleEdge2);
        double d15 = valueAxis2.valueToJava2D(d10, rectangle2D, rectangleEdge2);
        double d16 = valueAxis2.valueToJava2D(d11, rectangle2D, rectangleEdge2);
        if (this.candleWidth > 0.0) {
            d4 = this.candleWidth;
            d2 = this.candleWidth;
        } else {
            double d17 = 0.0;
            switch (this.autoWidthMethod) {
                int n5;
                case 0: {
                    n5 = oHLCDataset.getItemCount(n2);
                    if (bl2) {
                        d17 = rectangle2D.getHeight() / (double)n5;
                        break;
                    }
                    d17 = rectangle2D.getWidth() / (double)n5;
                    break;
                }
                case 1: {
                    n5 = oHLCDataset.getItemCount(n2);
                    d6 = -1.0;
                    d17 = rectangle2D.getWidth();
                    for (int i2 = 0; i2 < n5; ++i2) {
                        d3 = valueAxis.valueToJava2D(oHLCDataset.getXValue(n2, i2), rectangle2D, rectangleEdge);
                        if (d6 != -1.0) {
                            d17 = Math.min(d17, Math.abs(d3 - d6));
                        }
                        d6 = d3;
                    }
                    break;
                }
                case 2: {
                    IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xYDataset;
                    d3 = valueAxis.valueToJava2D(intervalXYDataset.getStartXValue(n2, n3), rectangle2D, xYPlot.getDomainAxisEdge());
                    d5 = valueAxis.valueToJava2D(intervalXYDataset.getEndXValue(n2, n3), rectangle2D, xYPlot.getDomainAxisEdge());
                    d17 = Math.abs(d5 - d3);
                }
            }
            d17 -= 2.0 * this.autoWidthGap;
            d17 *= this.autoWidthFactor;
            d17 = Math.min(d17, this.maxCandleWidth);
            d4 = Math.max(Math.min(1.0, this.maxCandleWidth), d17);
            d2 = Math.max(Math.min(3.0, this.maxCandleWidth), d17);
        }
        Paint paint = this.getItemPaint(n2, n3);
        Paint paint2 = null;
        if (this.useOutlinePaint) {
            paint2 = this.getItemOutlinePaint(n2, n3);
        }
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setStroke(stroke);
        if (this.drawVolume) {
            int n6 = (int)oHLCDataset.getVolumeValue(n2, n3);
            double d18 = (double)n6 / this.maxVolume;
            if (bl2) {
                d3 = rectangle2D.getMinX();
                d5 = rectangle2D.getMaxX();
            } else {
                d3 = rectangle2D.getMinY();
                d5 = rectangle2D.getMaxY();
            }
            double d19 = d18 * (d5 - d3);
            graphics2D.setPaint(Color.gray);
            object = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.3f));
            if (bl2) {
                graphics2D.fill(new Rectangle2D.Double(d3, d12 - d4 / 2.0, d19, d4));
            } else {
                graphics2D.fill(new Rectangle2D.Double(d12 - d4 / 2.0, d5 - d19, d4, d19));
            }
            graphics2D.setComposite((Composite)object);
        }
        if (this.useOutlinePaint) {
            graphics2D.setPaint(paint2);
        } else {
            graphics2D.setPaint(paint);
        }
        d6 = Math.max(d15, d16);
        double d20 = Math.min(d15, d16);
        double d21 = Math.max(d10, d11);
        double d22 = Math.min(d10, d11);
        if (d8 > d21) {
            if (bl2) {
                graphics2D.draw(new Line2D.Double(d13, d12, d6, d12));
            } else {
                graphics2D.draw(new Line2D.Double(d12, d13, d12, d6));
            }
        }
        if (d9 < d22) {
            if (bl2) {
                graphics2D.draw(new Line2D.Double(d14, d12, d20, d12));
            } else {
                graphics2D.draw(new Line2D.Double(d12, d14, d12, d20));
            }
        }
        Rectangle2D.Double double_ = null;
        double_ = bl2 ? new Rectangle2D.Double(d20, d12 - d2 / 2.0, d6 - d20, d2) : new Rectangle2D.Double(d12 - d2 / 2.0, d20, d2, d6 - d20);
        if (d11 > d10) {
            if (this.upPaint != null) {
                graphics2D.setPaint(this.upPaint);
            } else {
                graphics2D.setPaint(paint);
            }
            graphics2D.fill(double_);
        } else {
            if (this.downPaint != null) {
                graphics2D.setPaint(this.downPaint);
            } else {
                graphics2D.setPaint(paint);
            }
            graphics2D.fill(double_);
        }
        if (this.useOutlinePaint) {
            graphics2D.setPaint(paint2);
        } else {
            graphics2D.setPaint(paint);
        }
        graphics2D.draw(double_);
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
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CandlestickRenderer)) {
            return false;
        }
        CandlestickRenderer candlestickRenderer = (CandlestickRenderer)object;
        if (this.candleWidth != candlestickRenderer.candleWidth) {
            return false;
        }
        if (!PaintUtilities.equal(this.upPaint, candlestickRenderer.upPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.downPaint, candlestickRenderer.downPaint)) {
            return false;
        }
        if (this.drawVolume != candlestickRenderer.drawVolume) {
            return false;
        }
        if (this.maxCandleWidthInMilliseconds != candlestickRenderer.maxCandleWidthInMilliseconds) {
            return false;
        }
        if (this.autoWidthMethod != candlestickRenderer.autoWidthMethod) {
            return false;
        }
        if (this.autoWidthFactor != candlestickRenderer.autoWidthFactor) {
            return false;
        }
        if (this.autoWidthGap != candlestickRenderer.autoWidthGap) {
            return false;
        }
        if (this.useOutlinePaint == candlestickRenderer.useOutlinePaint) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.upPaint, objectOutputStream);
        SerialUtilities.writePaint(this.downPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.upPaint = SerialUtilities.readPaint(objectInputStream);
        this.downPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

