/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
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
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYStepAreaRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -7311560779702649635L;
    public static final int SHAPES = 1;
    public static final int AREA = 2;
    public static final int AREA_AND_SHAPES = 3;
    private boolean shapesVisible;
    private boolean shapesFilled;
    private boolean plotArea;
    private boolean showOutline;
    protected transient Polygon pArea = null;
    private double rangeBase;

    public XYStepAreaRenderer() {
        this(2);
    }

    public XYStepAreaRenderer(int n2) {
        this(n2, null, null);
    }

    public XYStepAreaRenderer(int n2, XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        this.setBaseToolTipGenerator(xYToolTipGenerator);
        this.setURLGenerator(xYURLGenerator);
        if (n2 == 2) {
            this.plotArea = true;
        } else if (n2 == 1) {
            this.shapesVisible = true;
        } else if (n2 == 3) {
            this.plotArea = true;
            this.shapesVisible = true;
        }
        this.showOutline = false;
    }

    public boolean isOutline() {
        return this.showOutline;
    }

    public void setOutline(boolean bl2) {
        this.showOutline = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getShapesVisible() {
        return this.shapesVisible;
    }

    public void setShapesVisible(boolean bl2) {
        this.shapesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean isShapesFilled() {
        return this.shapesFilled;
    }

    public void setShapesFilled(boolean bl2) {
        this.shapesFilled = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getPlotArea() {
        return this.plotArea;
    }

    public void setPlotArea(boolean bl2) {
        this.plotArea = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getRangeBase() {
        return this.rangeBase;
    }

    public void setRangeBase(double d2) {
        this.rangeBase = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        return super.initialise(graphics2D, rectangle2D, xYPlot, xYDataset, plotRenderingInfo);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double d2;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        int n5 = xYDataset.getItemCount(n2);
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        double d3 = xYDataset.getXValue(n2, n3);
        double d4 = xYDataset.getYValue(n2, n3);
        double d5 = d3;
        double d6 = Double.isNaN(d4) ? this.getRangeBase() : d4;
        double d7 = valueAxis.valueToJava2D(d5, rectangle2D, xYPlot.getDomainAxisEdge());
        double d8 = valueAxis2.valueToJava2D(d6, rectangle2D, xYPlot.getRangeAxisEdge());
        d8 = XYStepAreaRenderer.restrictValueToDataArea(d8, xYPlot, rectangle2D);
        if (this.pArea == null && !Double.isNaN(d4)) {
            this.pArea = new Polygon();
            d2 = valueAxis2.valueToJava2D(this.getRangeBase(), rectangle2D, xYPlot.getRangeAxisEdge());
            d2 = XYStepAreaRenderer.restrictValueToDataArea(d2, xYPlot, rectangle2D);
            if (plotOrientation == PlotOrientation.VERTICAL) {
                this.pArea.addPoint((int)d7, (int)d2);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                this.pArea.addPoint((int)d2, (int)d7);
            }
        }
        d2 = 0.0;
        double d9 = XYStepAreaRenderer.restrictValueToDataArea(this.getRangeBase(), xYPlot, rectangle2D);
        if (n3 > 0) {
            double d10 = xYDataset.getXValue(n2, n3 - 1);
            double d11 = Double.isNaN(d4) ? d4 : xYDataset.getYValue(n2, n3 - 1);
            d5 = d10;
            d6 = Double.isNaN(d11) ? this.getRangeBase() : d11;
            d2 = valueAxis.valueToJava2D(d5, rectangle2D, xYPlot.getDomainAxisEdge());
            d9 = valueAxis2.valueToJava2D(d6, rectangle2D, xYPlot.getRangeAxisEdge());
            d9 = XYStepAreaRenderer.restrictValueToDataArea(d9, xYPlot, rectangle2D);
            if (Double.isNaN(d4)) {
                d7 = d2;
                d9 = d8;
            }
            if (d9 != d8) {
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    this.pArea.addPoint((int)d7, (int)d9);
                } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    this.pArea.addPoint((int)d9, (int)d7);
                }
            }
        }
        Shape shape = null;
        if (!Double.isNaN(d4)) {
            if (plotOrientation == PlotOrientation.VERTICAL) {
                this.pArea.addPoint((int)d7, (int)d8);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                this.pArea.addPoint((int)d8, (int)d7);
            }
            if (this.getShapesVisible()) {
                shape = this.getItemShape(n2, n3);
                if (plotOrientation == PlotOrientation.VERTICAL) {
                    shape = ShapeUtilities.createTranslatedShape(shape, d7, d8);
                } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    shape = ShapeUtilities.createTranslatedShape(shape, d8, d7);
                }
                if (this.isShapesFilled()) {
                    graphics2D.fill(shape);
                } else {
                    graphics2D.draw(shape);
                }
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                shape = new Rectangle2D.Double(d7 - 2.0, d8 - 2.0, 4.0, 4.0);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                shape = new Rectangle2D.Double(d8 - 2.0, d7 - 2.0, 4.0, 4.0);
            }
        }
        if (this.getPlotArea() && n3 > 0 && this.pArea != null && (n3 == n5 - 1 || Double.isNaN(d4))) {
            double d12 = valueAxis2.valueToJava2D(this.getRangeBase(), rectangle2D, xYPlot.getRangeAxisEdge());
            d12 = XYStepAreaRenderer.restrictValueToDataArea(d12, xYPlot, rectangle2D);
            if (plotOrientation == PlotOrientation.VERTICAL) {
                this.pArea.addPoint((int)d7, (int)d12);
            } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
                this.pArea.addPoint((int)d12, (int)d7);
            }
            graphics2D.fill(this.pArea);
            if (this.isOutline()) {
                graphics2D.setStroke(xYPlot.getOutlineStroke());
                graphics2D.setPaint(xYPlot.getOutlinePaint());
                graphics2D.draw(this.pArea);
            }
            this.pArea = null;
        }
        if (!Double.isNaN(d4)) {
            int n6 = xYPlot.getDomainAxisIndex(valueAxis);
            int n7 = xYPlot.getRangeAxisIndex(valueAxis2);
            this.updateCrosshairValues(crosshairState, d3, d4, n6, n7, d7, d8, plotOrientation);
        }
        if (xYItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = xYItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        if (shape == null) return;
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string2 = null;
        if (this.getURLGenerator() != null) {
            string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(shape, xYDataset, n2, n3, string, string2);
        entityCollection.add(xYItemEntity);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYStepAreaRenderer)) {
            return false;
        }
        XYStepAreaRenderer xYStepAreaRenderer = (XYStepAreaRenderer)object;
        if (this.showOutline != xYStepAreaRenderer.showOutline) {
            return false;
        }
        if (this.shapesVisible != xYStepAreaRenderer.shapesVisible) {
            return false;
        }
        if (this.shapesFilled != xYStepAreaRenderer.shapesFilled) {
            return false;
        }
        if (this.plotArea != xYStepAreaRenderer.plotArea) {
            return false;
        }
        if (this.rangeBase == xYStepAreaRenderer.rangeBase) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    protected static double restrictValueToDataArea(double d2, XYPlot xYPlot, Rectangle2D rectangle2D) {
        double d3 = 0.0;
        double d4 = 0.0;
        if (xYPlot.getOrientation() == PlotOrientation.VERTICAL) {
            d3 = rectangle2D.getMinY();
            d4 = rectangle2D.getMaxY();
        } else if (xYPlot.getOrientation() == PlotOrientation.HORIZONTAL) {
            d3 = rectangle2D.getMinX();
            d4 = rectangle2D.getMaxX();
        }
        if (d2 < d3) {
            return d3;
        }
        if (d2 <= d4) return d2;
        return d4;
    }
}

