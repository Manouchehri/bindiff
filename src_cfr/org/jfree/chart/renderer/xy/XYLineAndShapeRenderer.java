/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer$State;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYLineAndShapeRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -7435246895986425885L;
    private Boolean linesVisible = null;
    private BooleanList seriesLinesVisible = new BooleanList();
    private boolean baseLinesVisible;
    private transient Shape legendLine;
    private Boolean shapesVisible;
    private BooleanList seriesShapesVisible;
    private boolean baseShapesVisible;
    private Boolean shapesFilled;
    private BooleanList seriesShapesFilled;
    private boolean baseShapesFilled;
    private boolean drawOutlines;
    private boolean useFillPaint;
    private boolean useOutlinePaint;
    private boolean drawSeriesLineAsPath;

    public XYLineAndShapeRenderer() {
        this(true, true);
    }

    public XYLineAndShapeRenderer(boolean bl2, boolean bl3) {
        this.baseLinesVisible = bl2;
        this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        this.shapesVisible = null;
        this.seriesShapesVisible = new BooleanList();
        this.baseShapesVisible = bl3;
        this.shapesFilled = null;
        this.useFillPaint = false;
        this.seriesShapesFilled = new BooleanList();
        this.baseShapesFilled = true;
        this.drawOutlines = true;
        this.useOutlinePaint = false;
        this.drawSeriesLineAsPath = false;
    }

    public boolean getDrawSeriesLineAsPath() {
        return this.drawSeriesLineAsPath;
    }

    public void setDrawSeriesLineAsPath(boolean bl2) {
        if (this.drawSeriesLineAsPath == bl2) return;
        this.drawSeriesLineAsPath = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public int getPassCount() {
        return 2;
    }

    public boolean getItemLineVisible(int n2, int n3) {
        Boolean bl2 = this.linesVisible;
        if (bl2 == null) {
            bl2 = this.getSeriesLinesVisible(n2);
        }
        if (bl2 == null) return this.baseLinesVisible;
        return bl2;
    }

    public Boolean getLinesVisible() {
        return this.linesVisible;
    }

    public void setLinesVisible(Boolean bl2) {
        this.linesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setLinesVisible(boolean bl2) {
        this.setLinesVisible(BooleanUtilities.valueOf(bl2));
    }

    public Boolean getSeriesLinesVisible(int n2) {
        return this.seriesLinesVisible.getBoolean(n2);
    }

    public void setSeriesLinesVisible(int n2, Boolean bl2) {
        this.seriesLinesVisible.setBoolean(n2, bl2);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setSeriesLinesVisible(int n2, boolean bl2) {
        this.setSeriesLinesVisible(n2, BooleanUtilities.valueOf(bl2));
    }

    public boolean getBaseLinesVisible() {
        return this.baseLinesVisible;
    }

    public void setBaseLinesVisible(boolean bl2) {
        this.baseLinesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Shape getLegendLine() {
        return this.legendLine;
    }

    public void setLegendLine(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'line' argument.");
        }
        this.legendLine = shape;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getItemShapeVisible(int n2, int n3) {
        Boolean bl2 = this.shapesVisible;
        if (bl2 == null) {
            bl2 = this.getSeriesShapesVisible(n2);
        }
        if (bl2 == null) return this.baseShapesVisible;
        return bl2;
    }

    public Boolean getShapesVisible() {
        return this.shapesVisible;
    }

    public void setShapesVisible(Boolean bl2) {
        this.shapesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setShapesVisible(boolean bl2) {
        this.setShapesVisible(BooleanUtilities.valueOf(bl2));
    }

    public Boolean getSeriesShapesVisible(int n2) {
        return this.seriesShapesVisible.getBoolean(n2);
    }

    public void setSeriesShapesVisible(int n2, boolean bl2) {
        this.setSeriesShapesVisible(n2, BooleanUtilities.valueOf(bl2));
    }

    public void setSeriesShapesVisible(int n2, Boolean bl2) {
        this.seriesShapesVisible.setBoolean(n2, bl2);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getBaseShapesVisible() {
        return this.baseShapesVisible;
    }

    public void setBaseShapesVisible(boolean bl2) {
        this.baseShapesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getItemShapeFilled(int n2, int n3) {
        Boolean bl2 = this.shapesFilled;
        if (bl2 == null) {
            bl2 = this.getSeriesShapesFilled(n2);
        }
        if (bl2 == null) return this.baseShapesFilled;
        return bl2;
    }

    public void setShapesFilled(boolean bl2) {
        this.setShapesFilled(BooleanUtilities.valueOf(bl2));
    }

    public void setShapesFilled(Boolean bl2) {
        this.shapesFilled = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Boolean getSeriesShapesFilled(int n2) {
        return this.seriesShapesFilled.getBoolean(n2);
    }

    public void setSeriesShapesFilled(int n2, boolean bl2) {
        this.setSeriesShapesFilled(n2, BooleanUtilities.valueOf(bl2));
    }

    public void setSeriesShapesFilled(int n2, Boolean bl2) {
        this.seriesShapesFilled.setBoolean(n2, bl2);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getBaseShapesFilled() {
        return this.baseShapesFilled;
    }

    public void setBaseShapesFilled(boolean bl2) {
        this.baseShapesFilled = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getDrawOutlines() {
        return this.drawOutlines;
    }

    public void setDrawOutlines(boolean bl2) {
        this.drawOutlines = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getUseFillPaint() {
        return this.useFillPaint;
    }

    public void setUseFillPaint(boolean bl2) {
        this.useFillPaint = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getUseOutlinePaint() {
        return this.useOutlinePaint;
    }

    public void setUseOutlinePaint(boolean bl2) {
        this.useOutlinePaint = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        XYLineAndShapeRenderer$State xYLineAndShapeRenderer$State = new XYLineAndShapeRenderer$State(plotRenderingInfo);
        xYLineAndShapeRenderer$State.seriesPath = new GeneralPath();
        return xYLineAndShapeRenderer$State;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        if (this.isLinePass(n4)) {
            if (n3 == 0 && this.drawSeriesLineAsPath) {
                XYLineAndShapeRenderer$State xYLineAndShapeRenderer$State = (XYLineAndShapeRenderer$State)xYItemRendererState;
                xYLineAndShapeRenderer$State.seriesPath.reset();
                XYLineAndShapeRenderer$State.access$002(xYLineAndShapeRenderer$State, false);
            }
            if (!this.getItemLineVisible(n2, n3)) return;
            if (this.drawSeriesLineAsPath) {
                this.drawPrimaryLineAsPath(xYItemRendererState, graphics2D, xYPlot, xYDataset, n4, n2, n3, valueAxis, valueAxis2, rectangle2D);
                return;
            }
            this.drawPrimaryLine(xYItemRendererState, graphics2D, xYPlot, xYDataset, n4, n2, n3, valueAxis, valueAxis2, rectangle2D);
            return;
        }
        if (!this.isItemPass(n4)) return;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        this.drawSecondaryPass(graphics2D, xYPlot, xYDataset, n4, n2, n3, valueAxis, rectangle2D, valueAxis2, crosshairState, entityCollection);
    }

    protected boolean isLinePass(int n2) {
        if (n2 != 0) return false;
        return true;
    }

    protected boolean isItemPass(int n2) {
        if (n2 != 1) return false;
        return true;
    }

    protected void drawPrimaryLine(XYItemRendererState xYItemRendererState, Graphics2D graphics2D, XYPlot xYPlot, XYDataset xYDataset, int n2, int n3, int n4, ValueAxis valueAxis, ValueAxis valueAxis2, Rectangle2D rectangle2D) {
        if (n4 == 0) {
            return;
        }
        double d2 = xYDataset.getXValue(n3, n4);
        double d3 = xYDataset.getYValue(n3, n4);
        if (Double.isNaN(d3)) return;
        if (Double.isNaN(d2)) {
            return;
        }
        double d4 = xYDataset.getXValue(n3, n4 - 1);
        double d5 = xYDataset.getYValue(n3, n4 - 1);
        if (Double.isNaN(d5)) return;
        if (Double.isNaN(d4)) {
            return;
        }
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d6 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge);
        double d7 = valueAxis2.valueToJava2D(d5, rectangle2D, rectangleEdge2);
        double d8 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d9 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2);
        if (Double.isNaN(d6)) return;
        if (Double.isNaN(d7)) return;
        if (Double.isNaN(d8)) return;
        if (Double.isNaN(d9)) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            xYItemRendererState.workingLine.setLine(d7, d6, d9, d8);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            xYItemRendererState.workingLine.setLine(d6, d7, d8, d9);
        }
        if (!xYItemRendererState.workingLine.intersects(rectangle2D)) return;
        this.drawFirstPassShape(graphics2D, n2, n3, n4, xYItemRendererState.workingLine);
    }

    protected void drawFirstPassShape(Graphics2D graphics2D, int n2, int n3, int n4, Shape shape) {
        graphics2D.setStroke(this.getItemStroke(n3, n4));
        graphics2D.setPaint(this.getItemPaint(n3, n4));
        graphics2D.draw(shape);
    }

    protected void drawPrimaryLineAsPath(XYItemRendererState xYItemRendererState, Graphics2D graphics2D, XYPlot xYPlot, XYDataset xYDataset, int n2, int n3, int n4, ValueAxis valueAxis, ValueAxis valueAxis2, Rectangle2D rectangle2D) {
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d2 = xYDataset.getXValue(n3, n4);
        double d3 = xYDataset.getYValue(n3, n4);
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d5 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2);
        XYLineAndShapeRenderer$State xYLineAndShapeRenderer$State = (XYLineAndShapeRenderer$State)xYItemRendererState;
        if (!Double.isNaN(d4) && !Double.isNaN(d5)) {
            float f2 = (float)d4;
            float f3 = (float)d5;
            PlotOrientation plotOrientation = xYPlot.getOrientation();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                f2 = (float)d5;
                f3 = (float)d4;
            }
            if (xYLineAndShapeRenderer$State.isLastPointGood()) {
                xYLineAndShapeRenderer$State.seriesPath.lineTo(f2, f3);
            } else {
                xYLineAndShapeRenderer$State.seriesPath.moveTo(f2, f3);
            }
            xYLineAndShapeRenderer$State.setLastPointGood(true);
        } else {
            xYLineAndShapeRenderer$State.setLastPointGood(false);
        }
        if (n4 != xYDataset.getItemCount(n3) - 1) return;
        this.drawFirstPassShape(graphics2D, n2, n3, n4, xYLineAndShapeRenderer$State.seriesPath);
    }

    protected void drawSecondaryPass(Graphics2D graphics2D, XYPlot xYPlot, XYDataset xYDataset, int n2, int n3, int n4, ValueAxis valueAxis, Rectangle2D rectangle2D, ValueAxis valueAxis2, CrosshairState crosshairState, EntityCollection entityCollection) {
        Shape shape = null;
        double d2 = xYDataset.getXValue(n3, n4);
        double d3 = xYDataset.getYValue(n3, n4);
        if (Double.isNaN(d3)) return;
        if (Double.isNaN(d2)) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d5 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2);
        if (this.getItemShapeVisible(n3, n4)) {
            Shape shape2 = this.getItemShape(n3, n4);
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, d5, d4);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                shape2 = ShapeUtilities.createTranslatedShape(shape2, d4, d5);
            }
            shape = shape2;
            if (shape2.intersects(rectangle2D)) {
                if (this.getItemShapeFilled(n3, n4)) {
                    if (this.useFillPaint) {
                        graphics2D.setPaint(this.getItemFillPaint(n3, n4));
                    } else {
                        graphics2D.setPaint(this.getItemPaint(n3, n4));
                    }
                    graphics2D.fill(shape2);
                }
                if (this.drawOutlines) {
                    if (this.getUseOutlinePaint()) {
                        graphics2D.setPaint(this.getItemOutlinePaint(n3, n4));
                    } else {
                        graphics2D.setPaint(this.getItemPaint(n3, n4));
                    }
                    graphics2D.setStroke(this.getItemOutlineStroke(n3, n4));
                    graphics2D.draw(shape2);
                }
            }
        }
        if (this.isItemLabelVisible(n3, n4)) {
            double d6 = d4;
            double d7 = d5;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                d6 = d5;
                d7 = d4;
            }
            this.drawItemLabel(graphics2D, plotOrientation, xYDataset, n3, n4, d6, d7, d3 < 0.0);
        }
        int n5 = xYPlot.getDomainAxisIndex(valueAxis);
        int n6 = xYPlot.getRangeAxisIndex(valueAxis2);
        this.updateCrosshairValues(crosshairState, d2, d3, n5, n6, d4, d5, xYPlot.getOrientation());
        if (entityCollection == null) return;
        this.addEntity(entityCollection, shape, xYDataset, n3, n4, d4, d5);
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) {
            return null;
        }
        LegendItem legendItem = null;
        XYDataset xYDataset = xYPlot.getDataset(n2);
        if (xYDataset == null) return legendItem;
        if (!this.getItemVisible(n3, 0)) return legendItem;
        String string2 = string = this.getLegendItemLabelGenerator().generateLabel(xYDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(xYDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(xYDataset, n3);
        }
        boolean bl2 = this.getItemShapeVisible(n3, 0);
        Shape shape = this.getSeriesShape(n3);
        boolean bl3 = this.getItemShapeFilled(n3, 0);
        Paint paint = this.useFillPaint ? this.getSeriesFillPaint(n3) : this.getSeriesPaint(n3);
        boolean bl4 = this.drawOutlines;
        Paint paint2 = this.useOutlinePaint ? this.getSeriesOutlinePaint(n3) : this.getSeriesPaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        boolean bl5 = this.getItemLineVisible(n3, 0);
        Stroke stroke2 = this.getSeriesStroke(n3);
        Paint paint3 = this.getSeriesPaint(n3);
        legendItem = new LegendItem(string, string2, string3, string4, bl2, shape, bl3, paint, bl4, paint2, stroke, bl5, this.legendLine, stroke2, paint3);
        legendItem.setSeriesIndex(n3);
        legendItem.setDatasetIndex(n2);
        return legendItem;
    }

    @Override
    public Object clone() {
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)super.clone();
        xYLineAndShapeRenderer.seriesLinesVisible = (BooleanList)this.seriesLinesVisible.clone();
        if (this.legendLine != null) {
            xYLineAndShapeRenderer.legendLine = ShapeUtilities.clone(this.legendLine);
        }
        xYLineAndShapeRenderer.seriesShapesVisible = (BooleanList)this.seriesShapesVisible.clone();
        xYLineAndShapeRenderer.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
        return xYLineAndShapeRenderer;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYLineAndShapeRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)object;
        if (!ObjectUtilities.equal(this.linesVisible, xYLineAndShapeRenderer.linesVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesLinesVisible, xYLineAndShapeRenderer.seriesLinesVisible)) {
            return false;
        }
        if (this.baseLinesVisible != xYLineAndShapeRenderer.baseLinesVisible) {
            return false;
        }
        if (!ShapeUtilities.equal(this.legendLine, xYLineAndShapeRenderer.legendLine)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shapesVisible, xYLineAndShapeRenderer.shapesVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesShapesVisible, xYLineAndShapeRenderer.seriesShapesVisible)) {
            return false;
        }
        if (this.baseShapesVisible != xYLineAndShapeRenderer.baseShapesVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shapesFilled, xYLineAndShapeRenderer.shapesFilled)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesShapesFilled, xYLineAndShapeRenderer.seriesShapesFilled)) {
            return false;
        }
        if (this.baseShapesFilled != xYLineAndShapeRenderer.baseShapesFilled) {
            return false;
        }
        if (this.drawOutlines != xYLineAndShapeRenderer.drawOutlines) {
            return false;
        }
        if (this.useOutlinePaint != xYLineAndShapeRenderer.useOutlinePaint) {
            return false;
        }
        if (this.useFillPaint != xYLineAndShapeRenderer.useFillPaint) {
            return false;
        }
        if (this.drawSeriesLineAsPath == xYLineAndShapeRenderer.drawSeriesLineAsPath) return true;
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendLine = SerialUtilities.readShape(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendLine, objectOutputStream);
    }
}

