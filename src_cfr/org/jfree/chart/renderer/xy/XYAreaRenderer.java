/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer$XYAreaRendererState;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYAreaRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
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

    public XYAreaRenderer(int n2) {
        this(n2, null, null);
    }

    public XYAreaRenderer(int n2, XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        this.setBaseToolTipGenerator(xYToolTipGenerator);
        this.setURLGenerator(xYURLGenerator);
        if (n2 == 1) {
            this.plotShapes = true;
        }
        if (n2 == 2) {
            this.plotLines = true;
        }
        if (n2 == 3) {
            this.plotShapes = true;
            this.plotLines = true;
        }
        if (n2 == 4) {
            this.plotArea = true;
        }
        if (n2 == 5) {
            this.plotArea = true;
            this.plotShapes = true;
        }
        this.showOutline = false;
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, -4.0f);
        generalPath.lineTo(3.0f, -2.0f);
        generalPath.lineTo(4.0f, 4.0f);
        generalPath.lineTo(-4.0f, 4.0f);
        generalPath.lineTo(-3.0f, -2.0f);
        generalPath.closePath();
        this.legendArea = generalPath;
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

    public void setOutline(boolean bl2) {
        this.showOutline = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Shape getLegendArea() {
        return this.legendArea;
    }

    public void setLegendArea(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'area' argument.");
        }
        this.legendArea = shape;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        return new XYAreaRenderer$XYAreaRendererState(plotRenderingInfo);
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        LegendItem legendItem = null;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) return legendItem;
        XYDataset xYDataset = xYPlot.getDataset(n2);
        if (xYDataset == null) return legendItem;
        XYSeriesLabelGenerator xYSeriesLabelGenerator = this.getLegendItemLabelGenerator();
        String string2 = string = xYSeriesLabelGenerator.generateLabel(xYDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(xYDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(xYDataset, n3);
        }
        Paint paint = this.getSeriesPaint(n3);
        return new LegendItem(string, string2, string3, string4, this.legendArea, paint);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        XYAreaRenderer$XYAreaRendererState xYAreaRenderer$XYAreaRendererState = (XYAreaRenderer$XYAreaRendererState)xYItemRendererState;
        double d2 = xYDataset.getXValue(n2, n3);
        double d3 = xYDataset.getYValue(n2, n3);
        if (Double.isNaN(d3)) {
            d3 = 0.0;
        }
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        double d5 = valueAxis2.valueToJava2D(d3, rectangle2D, xYPlot.getRangeAxisEdge());
        int n5 = xYDataset.getItemCount(n2);
        double d6 = xYDataset.getXValue(n2, Math.max(n3 - 1, 0));
        double d7 = xYDataset.getYValue(n2, Math.max(n3 - 1, 0));
        if (Double.isNaN(d7)) {
            d7 = 0.0;
        }
        double d8 = valueAxis.valueToJava2D(d6, rectangle2D, xYPlot.getDomainAxisEdge());
        double d9 = valueAxis2.valueToJava2D(d7, rectangle2D, xYPlot.getRangeAxisEdge());
        double d10 = xYDataset.getXValue(n2, Math.min(n3 + 1, n5 - 1));
        double d11 = xYDataset.getYValue(n2, Math.min(n3 + 1, n5 - 1));
        if (Double.isNaN(d11)) {
            d11 = 0.0;
        }
        double d12 = valueAxis.valueToJava2D(d10, rectangle2D, xYPlot.getDomainAxisEdge());
        double d13 = valueAxis2.valueToJava2D(d11, rectangle2D, xYPlot.getRangeAxisEdge());
        double d14 = valueAxis2.valueToJava2D(0.0, rectangle2D, xYPlot.getRangeAxisEdge());
        Polygon polygon = null;
        if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            polygon = new Polygon();
            polygon.addPoint((int)d14, (int)((d8 + d4) / 2.0));
            polygon.addPoint((int)((d9 + d5) / 2.0), (int)((d8 + d4) / 2.0));
            polygon.addPoint((int)d5, (int)d4);
            polygon.addPoint((int)((d5 + d13) / 2.0), (int)((d4 + d12) / 2.0));
            polygon.addPoint((int)d14, (int)((d4 + d12) / 2.0));
        } else {
            polygon = new Polygon();
            polygon.addPoint((int)((d8 + d4) / 2.0), (int)d14);
            polygon.addPoint((int)((d8 + d4) / 2.0), (int)((d9 + d5) / 2.0));
            polygon.addPoint((int)d4, (int)d5);
            polygon.addPoint((int)((d4 + d12) / 2.0), (int)((d5 + d13) / 2.0));
            polygon.addPoint((int)((d4 + d12) / 2.0), (int)d14);
        }
        if (n3 == 0) {
            xYAreaRenderer$XYAreaRendererState.area = new Polygon();
            double d15 = valueAxis2.valueToJava2D(0.0, rectangle2D, xYPlot.getRangeAxisEdge());
            if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
                xYAreaRenderer$XYAreaRendererState.area.addPoint((int)d4, (int)d15);
            } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                xYAreaRenderer$XYAreaRendererState.area.addPoint((int)d15, (int)d4);
            }
        }
        if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
            xYAreaRenderer$XYAreaRendererState.area.addPoint((int)d4, (int)d5);
        } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            xYAreaRenderer$XYAreaRendererState.area.addPoint((int)d5, (int)d4);
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        Shape shape = null;
        if (this.getPlotShapes()) {
            shape = this.getItemShape(n2, n3);
            if (plotOrientation == PlotOrientation.VERTICAL) {
                shape = ShapeUtilities.createTranslatedShape(shape, d4, d5);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                shape = ShapeUtilities.createTranslatedShape(shape, d5, d4);
            }
            graphics2D.draw(shape);
        }
        if (this.getPlotLines() && n3 > 0) {
            if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
                xYAreaRenderer$XYAreaRendererState.line.setLine(d8, d9, d4, d5);
            } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                xYAreaRenderer$XYAreaRendererState.line.setLine(d9, d8, d5, d4);
            }
            graphics2D.draw(xYAreaRenderer$XYAreaRendererState.line);
        }
        if (this.getPlotArea() && n3 > 0 && n3 == n5 - 1) {
            if (plotOrientation == PlotOrientation.VERTICAL) {
                xYAreaRenderer$XYAreaRendererState.area.addPoint((int)d4, (int)d14);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                xYAreaRenderer$XYAreaRendererState.area.addPoint((int)d14, (int)d4);
            }
            graphics2D.fill(xYAreaRenderer$XYAreaRendererState.area);
            if (this.isOutline()) {
                graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
                graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                graphics2D.draw(xYAreaRenderer$XYAreaRendererState.area);
            }
        }
        int n6 = xYPlot.getDomainAxisIndex(valueAxis);
        int n7 = xYPlot.getRangeAxisIndex(valueAxis2);
        this.updateCrosshairValues(crosshairState, d2, d3, n6, n7, d4, d5, plotOrientation);
        if (xYItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = xYItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        if (polygon == null) return;
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string2 = null;
        if (this.getURLGenerator() != null) {
            string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(polygon, xYDataset, n2, n3, string, string2);
        entityCollection.add(xYItemEntity);
    }

    @Override
    public Object clone() {
        XYAreaRenderer xYAreaRenderer = (XYAreaRenderer)super.clone();
        xYAreaRenderer.legendArea = ShapeUtilities.clone(this.legendArea);
        return xYAreaRenderer;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYAreaRenderer)) {
            return false;
        }
        XYAreaRenderer xYAreaRenderer = (XYAreaRenderer)object;
        if (this.plotArea != xYAreaRenderer.plotArea) {
            return false;
        }
        if (this.plotLines != xYAreaRenderer.plotLines) {
            return false;
        }
        if (this.plotShapes != xYAreaRenderer.plotShapes) {
            return false;
        }
        if (this.showOutline != xYAreaRenderer.showOutline) {
            return false;
        }
        if (ShapeUtilities.equal(this.legendArea, xYAreaRenderer.legendArea)) return true;
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendArea = SerialUtilities.readShape(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendArea, objectOutputStream);
    }
}

