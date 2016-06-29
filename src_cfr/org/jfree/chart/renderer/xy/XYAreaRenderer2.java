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
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYAreaRenderer2
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -7378069681579984133L;
    private boolean showOutline = false;
    private transient Shape legendArea;

    public XYAreaRenderer2() {
        this(null, null);
    }

    public XYAreaRenderer2(XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        this.setBaseToolTipGenerator(xYToolTipGenerator);
        this.setURLGenerator(xYURLGenerator);
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(0.0f, -4.0f);
        generalPath.lineTo(3.0f, -2.0f);
        generalPath.lineTo(4.0f, 4.0f);
        generalPath.lineTo(-4.0f, 4.0f);
        generalPath.lineTo(-3.0f, -2.0f);
        generalPath.closePath();
        this.legendArea = generalPath;
    }

    public boolean isOutline() {
        return this.showOutline;
    }

    public void setOutline(boolean bl2) {
        this.showOutline = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getPlotLines() {
        return false;
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
        double d2 = xYDataset.getXValue(n2, n3);
        double d3 = xYDataset.getYValue(n2, n3);
        if (Double.isNaN(d3)) {
            d3 = 0.0;
        }
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        double d5 = valueAxis2.valueToJava2D(d3, rectangle2D, xYPlot.getRangeAxisEdge());
        double d6 = xYDataset.getXValue(n2, Math.max(n3 - 1, 0));
        double d7 = xYDataset.getYValue(n2, Math.max(n3 - 1, 0));
        if (Double.isNaN(d7)) {
            d7 = 0.0;
        }
        double d8 = valueAxis.valueToJava2D(d6, rectangle2D, xYPlot.getDomainAxisEdge());
        double d9 = valueAxis2.valueToJava2D(d7, rectangle2D, xYPlot.getRangeAxisEdge());
        int n5 = xYDataset.getItemCount(n2);
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
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        if (this.getPlotLines() && n3 > 0) {
            if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
                xYItemRendererState.workingLine.setLine(d8, d9, d4, d5);
            } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
                xYItemRendererState.workingLine.setLine(d9, d8, d5, d4);
            }
            graphics2D.draw(xYItemRendererState.workingLine);
        }
        graphics2D.fill(polygon);
        if (this.isOutline()) {
            graphics2D.setStroke(this.getSeriesOutlineStroke(n2));
            graphics2D.setPaint(this.getSeriesOutlinePaint(n2));
            graphics2D.draw(polygon);
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
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYAreaRenderer2)) {
            return false;
        }
        XYAreaRenderer2 xYAreaRenderer2 = (XYAreaRenderer2)object;
        if (this.showOutline != xYAreaRenderer2.showOutline) {
            return false;
        }
        if (ShapeUtilities.equal(this.legendArea, xYAreaRenderer2.legendArea)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        XYAreaRenderer2 xYAreaRenderer2 = (XYAreaRenderer2)super.clone();
        xYAreaRenderer2.legendArea = ShapeUtilities.clone(this.legendArea);
        return xYAreaRenderer2;
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

