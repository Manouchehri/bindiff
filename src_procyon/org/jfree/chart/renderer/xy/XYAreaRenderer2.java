package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYAreaRenderer2 extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -7378069681579984133L;
    private boolean showOutline;
    private transient Shape legendArea;
    
    public XYAreaRenderer2() {
        this(null, null);
    }
    
    public XYAreaRenderer2(final XYToolTipGenerator baseToolTipGenerator, final XYURLGenerator urlGenerator) {
        this.showOutline = false;
        this.setBaseToolTipGenerator(baseToolTipGenerator);
        this.setURLGenerator(urlGenerator);
        final GeneralPath legendArea = new GeneralPath();
        legendArea.moveTo(0.0f, -4.0f);
        legendArea.lineTo(3.0f, -2.0f);
        legendArea.lineTo(4.0f, 4.0f);
        legendArea.lineTo(-4.0f, 4.0f);
        legendArea.lineTo(-3.0f, -2.0f);
        legendArea.closePath();
        this.legendArea = legendArea;
    }
    
    public boolean isOutline() {
        return this.showOutline;
    }
    
    public void setOutline(final boolean showOutline) {
        this.showOutline = showOutline;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public boolean getPlotLines() {
        return false;
    }
    
    public Shape getLegendArea() {
        return this.legendArea;
    }
    
    public void setLegendArea(final Shape legendArea) {
        if (legendArea == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        this.legendArea = legendArea;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        LegendItem legendItem = null;
        final XYPlot plot = this.getPlot();
        if (plot != null) {
            final XYDataset dataset = plot.getDataset(n);
            if (dataset != null) {
                final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, n2);
                String generateLabel2 = null;
                if (this.getLegendItemToolTipGenerator() != null) {
                    generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, n2);
                }
                String generateLabel3 = null;
                if (this.getLegendItemURLGenerator() != null) {
                    generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, n2);
                }
                legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, this.legendArea, this.getSeriesPaint(n2));
            }
        }
        return legendItem;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        final double xValue = xyDataset.getXValue(n, n2);
        double yValue = xyDataset.getYValue(n, n2);
        if (Double.isNaN(yValue)) {
            yValue = 0.0;
        }
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, xyPlot.getRangeAxisEdge());
        final double xValue2 = xyDataset.getXValue(n, Math.max(n2 - 1, 0));
        double yValue2 = xyDataset.getYValue(n, Math.max(n2 - 1, 0));
        if (Double.isNaN(yValue2)) {
            yValue2 = 0.0;
        }
        final double valueToJava2D3 = valueAxis.valueToJava2D(xValue2, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue2, rectangle2D, xyPlot.getRangeAxisEdge());
        final int itemCount = xyDataset.getItemCount(n);
        final double xValue3 = xyDataset.getXValue(n, Math.min(n2 + 1, itemCount - 1));
        double yValue3 = xyDataset.getYValue(n, Math.min(n2 + 1, itemCount - 1));
        if (Double.isNaN(yValue3)) {
            yValue3 = 0.0;
        }
        final double valueToJava2D5 = valueAxis.valueToJava2D(xValue3, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D6 = valueAxis2.valueToJava2D(yValue3, rectangle2D, xyPlot.getRangeAxisEdge());
        final double valueToJava2D7 = valueAxis2.valueToJava2D(0.0, rectangle2D, xyPlot.getRangeAxisEdge());
        Polygon polygon;
        if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            polygon = new Polygon();
            polygon.addPoint((int)valueToJava2D7, (int)((valueToJava2D3 + valueToJava2D) / 2.0));
            polygon.addPoint((int)((valueToJava2D4 + valueToJava2D2) / 2.0), (int)((valueToJava2D3 + valueToJava2D) / 2.0));
            polygon.addPoint((int)valueToJava2D2, (int)valueToJava2D);
            polygon.addPoint((int)((valueToJava2D2 + valueToJava2D6) / 2.0), (int)((valueToJava2D + valueToJava2D5) / 2.0));
            polygon.addPoint((int)valueToJava2D7, (int)((valueToJava2D + valueToJava2D5) / 2.0));
        }
        else {
            polygon = new Polygon();
            polygon.addPoint((int)((valueToJava2D3 + valueToJava2D) / 2.0), (int)valueToJava2D7);
            polygon.addPoint((int)((valueToJava2D3 + valueToJava2D) / 2.0), (int)((valueToJava2D4 + valueToJava2D2) / 2.0));
            polygon.addPoint((int)valueToJava2D, (int)valueToJava2D2);
            polygon.addPoint((int)((valueToJava2D + valueToJava2D5) / 2.0), (int)((valueToJava2D2 + valueToJava2D6) / 2.0));
            polygon.addPoint((int)((valueToJava2D + valueToJava2D5) / 2.0), (int)valueToJava2D7);
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        if (this.getPlotLines() && n2 > 0) {
            if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
                xyItemRendererState.workingLine.setLine(valueToJava2D3, valueToJava2D4, valueToJava2D, valueToJava2D2);
            }
            else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                xyItemRendererState.workingLine.setLine(valueToJava2D4, valueToJava2D3, valueToJava2D2, valueToJava2D);
            }
            graphics2D.draw(xyItemRendererState.workingLine);
        }
        graphics2D.fill(polygon);
        if (this.isOutline()) {
            graphics2D.setStroke(this.getSeriesOutlineStroke(n));
            graphics2D.setPaint(this.getSeriesOutlinePaint(n));
            graphics2D.draw(polygon);
        }
        this.updateCrosshairValues(crosshairState, xValue, yValue, xyPlot.getDomainAxisIndex(valueAxis), xyPlot.getRangeAxisIndex(valueAxis2), valueToJava2D, valueToJava2D2, orientation);
        if (xyItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = xyItemRendererState.getEntityCollection();
            if (entityCollection != null && polygon != null) {
                String generateToolTip = null;
                final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
                }
                String generateURL = null;
                if (this.getURLGenerator() != null) {
                    generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
                }
                entityCollection.add(new XYItemEntity(polygon, xyDataset, n, n2, generateToolTip, generateURL));
            }
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYAreaRenderer2)) {
            return false;
        }
        final XYAreaRenderer2 xyAreaRenderer2 = (XYAreaRenderer2)o;
        return this.showOutline == xyAreaRenderer2.showOutline && ShapeUtilities.equal(this.legendArea, xyAreaRenderer2.legendArea) && super.equals(o);
    }
    
    public Object clone() {
        final XYAreaRenderer2 xyAreaRenderer2 = (XYAreaRenderer2)super.clone();
        xyAreaRenderer2.legendArea = ShapeUtilities.clone(this.legendArea);
        return xyAreaRenderer2;
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendArea = SerialUtilities.readShape(objectInputStream);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendArea, objectOutputStream);
    }
}
