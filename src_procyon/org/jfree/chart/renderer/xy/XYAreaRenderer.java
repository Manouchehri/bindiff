package org.jfree.chart.renderer.xy;

import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.data.xy.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.util.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.io.*;
import java.io.*;

public class XYAreaRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -4481971353973876747L;
    public static final int SHAPES = 1;
    public static final int LINES = 2;
    public static final int SHAPES_AND_LINES = 3;
    public static final int AREA = 4;
    public static final int AREA_AND_SHAPES = 5;
    private boolean plotShapes;
    private boolean plotLines;
    private boolean plotArea;
    private boolean showOutline;
    private transient Shape legendArea;
    
    public XYAreaRenderer() {
        this(4);
    }
    
    public XYAreaRenderer(final int n) {
        this(n, null, null);
    }
    
    public XYAreaRenderer(final int n, final XYToolTipGenerator baseToolTipGenerator, final XYURLGenerator urlGenerator) {
        this.setBaseToolTipGenerator(baseToolTipGenerator);
        this.setURLGenerator(urlGenerator);
        if (n == 1) {
            this.plotShapes = true;
        }
        if (n == 2) {
            this.plotLines = true;
        }
        if (n == 3) {
            this.plotShapes = true;
            this.plotLines = true;
        }
        if (n == 4) {
            this.plotArea = true;
        }
        if (n == 5) {
            this.plotArea = true;
            this.plotShapes = true;
        }
        this.showOutline = false;
        final GeneralPath legendArea = new GeneralPath();
        legendArea.moveTo(0.0f, -4.0f);
        legendArea.lineTo(3.0f, -2.0f);
        legendArea.lineTo(4.0f, 4.0f);
        legendArea.lineTo(-4.0f, 4.0f);
        legendArea.lineTo(-3.0f, -2.0f);
        legendArea.closePath();
        this.legendArea = legendArea;
    }
    
    public boolean getPlotShapes() {
        return this.plotShapes;
    }
    
    public boolean getPlotLines() {
        return this.plotLines;
    }
    
    public boolean getPlotArea() {
        return this.plotArea;
    }
    
    public boolean isOutline() {
        return this.showOutline;
    }
    
    public void setOutline(final boolean showOutline) {
        this.showOutline = showOutline;
        this.notifyListeners(new RendererChangeEvent(this));
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
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        return new XYAreaRenderer$XYAreaRendererState(plotRenderingInfo);
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
        final XYAreaRenderer$XYAreaRendererState xyAreaRenderer$XYAreaRendererState = (XYAreaRenderer$XYAreaRendererState)xyItemRendererState;
        final double xValue = xyDataset.getXValue(n, n2);
        double yValue = xyDataset.getYValue(n, n2);
        if (Double.isNaN(yValue)) {
            yValue = 0.0;
        }
        final double valueToJava2D = valueAxis.valueToJava2D(xValue, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D2 = valueAxis2.valueToJava2D(yValue, rectangle2D, xyPlot.getRangeAxisEdge());
        final int itemCount = xyDataset.getItemCount(n);
        final double xValue2 = xyDataset.getXValue(n, Math.max(n2 - 1, 0));
        double yValue2 = xyDataset.getYValue(n, Math.max(n2 - 1, 0));
        if (Double.isNaN(yValue2)) {
            yValue2 = 0.0;
        }
        final double valueToJava2D3 = valueAxis.valueToJava2D(xValue2, rectangle2D, xyPlot.getDomainAxisEdge());
        final double valueToJava2D4 = valueAxis2.valueToJava2D(yValue2, rectangle2D, xyPlot.getRangeAxisEdge());
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
        if (n2 == 0) {
            xyAreaRenderer$XYAreaRendererState.area = new Polygon();
            final double valueToJava2D8 = valueAxis2.valueToJava2D(0.0, rectangle2D, xyPlot.getRangeAxisEdge());
            if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
                xyAreaRenderer$XYAreaRendererState.area.addPoint((int)valueToJava2D, (int)valueToJava2D8);
            }
            else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                xyAreaRenderer$XYAreaRendererState.area.addPoint((int)valueToJava2D8, (int)valueToJava2D);
            }
        }
        if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
            xyAreaRenderer$XYAreaRendererState.area.addPoint((int)valueToJava2D, (int)valueToJava2D2);
        }
        else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            xyAreaRenderer$XYAreaRendererState.area.addPoint((int)valueToJava2D2, (int)valueToJava2D);
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final Paint itemPaint = this.getItemPaint(n, n2);
        final Stroke itemStroke = this.getItemStroke(n, n2);
        graphics2D.setPaint(itemPaint);
        graphics2D.setStroke(itemStroke);
        if (this.getPlotShapes()) {
            Shape shape = this.getItemShape(n, n2);
            if (orientation == PlotOrientation.VERTICAL) {
                shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D, valueToJava2D2);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                shape = ShapeUtilities.createTranslatedShape(shape, valueToJava2D2, valueToJava2D);
            }
            graphics2D.draw(shape);
        }
        if (this.getPlotLines() && n2 > 0) {
            if (xyPlot.getOrientation() == PlotOrientation.VERTICAL) {
                xyAreaRenderer$XYAreaRendererState.line.setLine(valueToJava2D3, valueToJava2D4, valueToJava2D, valueToJava2D2);
            }
            else if (xyPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                xyAreaRenderer$XYAreaRendererState.line.setLine(valueToJava2D4, valueToJava2D3, valueToJava2D2, valueToJava2D);
            }
            graphics2D.draw(xyAreaRenderer$XYAreaRendererState.line);
        }
        if (this.getPlotArea() && n2 > 0 && n2 == itemCount - 1) {
            if (orientation == PlotOrientation.VERTICAL) {
                xyAreaRenderer$XYAreaRendererState.area.addPoint((int)valueToJava2D, (int)valueToJava2D7);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                xyAreaRenderer$XYAreaRendererState.area.addPoint((int)valueToJava2D7, (int)valueToJava2D);
            }
            graphics2D.fill(xyAreaRenderer$XYAreaRendererState.area);
            if (this.isOutline()) {
                graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
                graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                graphics2D.draw(xyAreaRenderer$XYAreaRendererState.area);
            }
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
    
    public Object clone() {
        final XYAreaRenderer xyAreaRenderer = (XYAreaRenderer)super.clone();
        xyAreaRenderer.legendArea = ShapeUtilities.clone(this.legendArea);
        return xyAreaRenderer;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYAreaRenderer)) {
            return false;
        }
        final XYAreaRenderer xyAreaRenderer = (XYAreaRenderer)o;
        return this.plotArea == xyAreaRenderer.plotArea && this.plotLines == xyAreaRenderer.plotLines && this.plotShapes == xyAreaRenderer.plotShapes && this.showOutline == xyAreaRenderer.showOutline && ShapeUtilities.equal(this.legendArea, xyAreaRenderer.legendArea);
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
