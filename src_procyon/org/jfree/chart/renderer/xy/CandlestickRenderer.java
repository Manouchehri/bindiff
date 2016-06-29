package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.event.*;
import org.jfree.chart.axis.*;
import org.jfree.ui.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class CandlestickRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = 50390395841817121L;
    public static final int WIDTHMETHOD_AVERAGE = 0;
    public static final int WIDTHMETHOD_SMALLEST = 1;
    public static final int WIDTHMETHOD_INTERVALDATA = 2;
    private int autoWidthMethod;
    private double autoWidthFactor;
    private double autoWidthGap;
    private double candleWidth;
    private double maxCandleWidthInMilliseconds;
    private double maxCandleWidth;
    private transient Paint upPaint;
    private transient Paint downPaint;
    private boolean drawVolume;
    private transient double maxVolume;
    private boolean useOutlinePaint;
    
    public CandlestickRenderer() {
        this(-1.0);
    }
    
    public CandlestickRenderer(final double n) {
        this(n, true, new HighLowItemLabelGenerator());
    }
    
    public CandlestickRenderer(final double candleWidth, final boolean drawVolume, final XYToolTipGenerator toolTipGenerator) {
        this.autoWidthMethod = 0;
        this.autoWidthFactor = 0.6428571428571429;
        this.autoWidthGap = 0.0;
        this.maxCandleWidthInMilliseconds = 7.2E7;
        this.setToolTipGenerator(toolTipGenerator);
        this.candleWidth = candleWidth;
        this.drawVolume = drawVolume;
        this.upPaint = Color.green;
        this.downPaint = Color.red;
        this.useOutlinePaint = false;
    }
    
    public double getCandleWidth() {
        return this.candleWidth;
    }
    
    public void setCandleWidth(final double candleWidth) {
        if (candleWidth != this.candleWidth) {
            this.candleWidth = candleWidth;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public double getMaxCandleWidthInMilliseconds() {
        return this.maxCandleWidthInMilliseconds;
    }
    
    public void setMaxCandleWidthInMilliseconds(final double maxCandleWidthInMilliseconds) {
        this.maxCandleWidthInMilliseconds = maxCandleWidthInMilliseconds;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public int getAutoWidthMethod() {
        return this.autoWidthMethod;
    }
    
    public void setAutoWidthMethod(final int autoWidthMethod) {
        if (this.autoWidthMethod != autoWidthMethod) {
            this.autoWidthMethod = autoWidthMethod;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public double getAutoWidthFactor() {
        return this.autoWidthFactor;
    }
    
    public void setAutoWidthFactor(final double autoWidthFactor) {
        if (this.autoWidthFactor != autoWidthFactor) {
            this.autoWidthFactor = autoWidthFactor;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public double getAutoWidthGap() {
        return this.autoWidthGap;
    }
    
    public void setAutoWidthGap(final double autoWidthGap) {
        if (this.autoWidthGap != autoWidthGap) {
            this.autoWidthGap = autoWidthGap;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public Paint getUpPaint() {
        return this.upPaint;
    }
    
    public void setUpPaint(final Paint upPaint) {
        this.upPaint = upPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Paint getDownPaint() {
        return this.downPaint;
    }
    
    public void setDownPaint(final Paint downPaint) {
        this.downPaint = downPaint;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean drawVolume() {
        return this.drawVolume;
    }
    
    public boolean getDrawVolume() {
        return this.drawVolume;
    }
    
    public void setDrawVolume(final boolean drawVolume) {
        if (this.drawVolume != drawVolume) {
            this.drawVolume = drawVolume;
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public boolean getUseOutlinePaint() {
        return this.useOutlinePaint;
    }
    
    public void setUseOutlinePaint(final boolean useOutlinePaint) {
        if (this.useOutlinePaint != useOutlinePaint) {
            this.useOutlinePaint = useOutlinePaint;
            this.fireChangeEvent();
        }
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        final ValueAxis domainAxis = xyPlot.getDomainAxis();
        final double lowerBound = domainAxis.getLowerBound();
        final double n = lowerBound + this.maxCandleWidthInMilliseconds;
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        this.maxCandleWidth = Math.abs(domainAxis.valueToJava2D(n, rectangle2D, domainAxisEdge) - domainAxis.valueToJava2D(lowerBound, rectangle2D, domainAxisEdge));
        if (this.drawVolume) {
            final OHLCDataset ohlcDataset = (OHLCDataset)xyDataset;
            this.maxVolume = 0.0;
            for (int i = 0; i < ohlcDataset.getSeriesCount(); ++i) {
                for (int j = 0; j < ohlcDataset.getItemCount(i); ++j) {
                    final double volumeValue = ohlcDataset.getVolumeValue(i, j);
                    if (volumeValue > this.maxVolume) {
                        this.maxVolume = volumeValue;
                    }
                }
            }
        }
        return new XYItemRendererState(plotRenderingInfo);
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        boolean b;
        if (orientation == PlotOrientation.HORIZONTAL) {
            b = true;
        }
        else {
            if (orientation != PlotOrientation.VERTICAL) {
                return;
            }
            b = false;
        }
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final OHLCDataset ohlcDataset = (OHLCDataset)xyDataset;
        final double xValue = ohlcDataset.getXValue(n, n2);
        final double highValue = ohlcDataset.getHighValue(n, n2);
        final double lowValue = ohlcDataset.getLowValue(n, n2);
        final double openValue = ohlcDataset.getOpenValue(n, n2);
        final double closeValue = ohlcDataset.getCloseValue(n, n2);
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final double valueToJava2D2 = valueAxis2.valueToJava2D(highValue, rectangle2D, rangeAxisEdge);
        final double valueToJava2D3 = valueAxis2.valueToJava2D(lowValue, rectangle2D, rangeAxisEdge);
        final double valueToJava2D4 = valueAxis2.valueToJava2D(openValue, rectangle2D, rangeAxisEdge);
        final double valueToJava2D5 = valueAxis2.valueToJava2D(closeValue, rectangle2D, rangeAxisEdge);
        double n4;
        double n5;
        if (this.candleWidth > 0.0) {
            n4 = this.candleWidth;
            n5 = this.candleWidth;
        }
        else {
            double n6 = 0.0;
            switch (this.autoWidthMethod) {
                case 0: {
                    final int itemCount = ohlcDataset.getItemCount(n);
                    if (b) {
                        n6 = rectangle2D.getHeight() / itemCount;
                        break;
                    }
                    n6 = rectangle2D.getWidth() / itemCount;
                    break;
                }
                case 1: {
                    final int itemCount2 = ohlcDataset.getItemCount(n);
                    double n7 = -1.0;
                    n6 = rectangle2D.getWidth();
                    for (int i = 0; i < itemCount2; ++i) {
                        final double valueToJava2D6 = valueAxis.valueToJava2D(ohlcDataset.getXValue(n, i), rectangle2D, domainAxisEdge);
                        if (n7 != -1.0) {
                            n6 = Math.min(n6, Math.abs(valueToJava2D6 - n7));
                        }
                        n7 = valueToJava2D6;
                    }
                    break;
                }
                case 2: {
                    final IntervalXYDataset intervalXYDataset = (IntervalXYDataset)xyDataset;
                    n6 = Math.abs(valueAxis.valueToJava2D(intervalXYDataset.getEndXValue(n, n2), rectangle2D, xyPlot.getDomainAxisEdge()) - valueAxis.valueToJava2D(intervalXYDataset.getStartXValue(n, n2), rectangle2D, xyPlot.getDomainAxisEdge()));
                    break;
                }
            }
            final double min = Math.min((n6 - 2.0 * this.autoWidthGap) * this.autoWidthFactor, this.maxCandleWidth);
            n4 = Math.max(Math.min(1.0, this.maxCandleWidth), min);
            n5 = Math.max(Math.min(3.0, this.maxCandleWidth), min);
        }
        final Paint itemPaint = this.getItemPaint(n, n2);
        Paint itemOutlinePaint = null;
        if (this.useOutlinePaint) {
            itemOutlinePaint = this.getItemOutlinePaint(n, n2);
        }
        graphics2D.setStroke(this.getItemStroke(n, n2));
        if (this.drawVolume) {
            final double n8 = (int)ohlcDataset.getVolumeValue(n, n2) / this.maxVolume;
            double n9;
            double n10;
            if (b) {
                n9 = rectangle2D.getMinX();
                n10 = rectangle2D.getMaxX();
            }
            else {
                n9 = rectangle2D.getMinY();
                n10 = rectangle2D.getMaxY();
            }
            final double n11 = n8 * (n10 - n9);
            graphics2D.setPaint(Color.gray);
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.3f));
            if (b) {
                graphics2D.fill(new Rectangle2D.Double(n9, valueToJava2D - n4 / 2.0, n11, n4));
            }
            else {
                graphics2D.fill(new Rectangle2D.Double(valueToJava2D - n4 / 2.0, n10 - n11, n4, n11));
            }
            graphics2D.setComposite(composite);
        }
        if (this.useOutlinePaint) {
            graphics2D.setPaint(itemOutlinePaint);
        }
        else {
            graphics2D.setPaint(itemPaint);
        }
        final double max = Math.max(valueToJava2D4, valueToJava2D5);
        final double min2 = Math.min(valueToJava2D4, valueToJava2D5);
        final double max2 = Math.max(openValue, closeValue);
        final double min3 = Math.min(openValue, closeValue);
        if (highValue > max2) {
            if (b) {
                graphics2D.draw(new Line2D.Double(valueToJava2D2, valueToJava2D, max, valueToJava2D));
            }
            else {
                graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D2, valueToJava2D, max));
            }
        }
        if (lowValue < min3) {
            if (b) {
                graphics2D.draw(new Line2D.Double(valueToJava2D3, valueToJava2D, min2, valueToJava2D));
            }
            else {
                graphics2D.draw(new Line2D.Double(valueToJava2D, valueToJava2D3, valueToJava2D, min2));
            }
        }
        Rectangle2D.Double double1;
        if (b) {
            double1 = new Rectangle2D.Double(min2, valueToJava2D - n5 / 2.0, max - min2, n5);
        }
        else {
            double1 = new Rectangle2D.Double(valueToJava2D - n5 / 2.0, min2, n5, max - min2);
        }
        if (closeValue > openValue) {
            if (this.upPaint != null) {
                graphics2D.setPaint(this.upPaint);
            }
            else {
                graphics2D.setPaint(itemPaint);
            }
            graphics2D.fill(double1);
        }
        else {
            if (this.downPaint != null) {
                graphics2D.setPaint(this.downPaint);
            }
            else {
                graphics2D.setPaint(itemPaint);
            }
            graphics2D.fill(double1);
        }
        if (this.useOutlinePaint) {
            graphics2D.setPaint(itemOutlinePaint);
        }
        else {
            graphics2D.setPaint(itemPaint);
        }
        graphics2D.draw(double1);
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
            entityCollection.add(new XYItemEntity(double1, xyDataset, n, n2, generateToolTip, generateURL));
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CandlestickRenderer)) {
            return false;
        }
        final CandlestickRenderer candlestickRenderer = (CandlestickRenderer)o;
        return this.candleWidth == candlestickRenderer.candleWidth && PaintUtilities.equal(this.upPaint, candlestickRenderer.upPaint) && PaintUtilities.equal(this.downPaint, candlestickRenderer.downPaint) && this.drawVolume == candlestickRenderer.drawVolume && this.maxCandleWidthInMilliseconds == candlestickRenderer.maxCandleWidthInMilliseconds && this.autoWidthMethod == candlestickRenderer.autoWidthMethod && this.autoWidthFactor == candlestickRenderer.autoWidthFactor && this.autoWidthGap == candlestickRenderer.autoWidthGap && this.useOutlinePaint == candlestickRenderer.useOutlinePaint && super.equals(o);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.upPaint, objectOutputStream);
        SerialUtilities.writePaint(this.downPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.upPaint = SerialUtilities.readPaint(objectInputStream);
        this.downPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
