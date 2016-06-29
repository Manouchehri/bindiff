/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Color;
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
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYDifferenceRenderer
extends AbstractXYItemRenderer
implements Serializable,
Cloneable,
XYItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -8447915602375584857L;
    private transient Paint positivePaint;
    private transient Paint negativePaint;
    private boolean shapesVisible;
    private transient Shape legendLine;
    private boolean roundXCoordinates;

    public XYDifferenceRenderer() {
        this(Color.green, Color.red, false);
    }

    public XYDifferenceRenderer(Paint paint, Paint paint2, boolean bl2) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'positivePaint' argument.");
        }
        if (paint2 == null) {
            throw new IllegalArgumentException("Null 'negativePaint' argument.");
        }
        this.positivePaint = paint;
        this.negativePaint = paint2;
        this.shapesVisible = bl2;
        this.legendLine = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        this.roundXCoordinates = false;
    }

    public Paint getPositivePaint() {
        return this.positivePaint;
    }

    public void setPositivePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.positivePaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public Paint getNegativePaint() {
        return this.negativePaint;
    }

    public void setNegativePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.negativePaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getShapesVisible() {
        return this.shapesVisible;
    }

    public void setShapesVisible(boolean bl2) {
        this.shapesVisible = bl2;
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

    public boolean getRoundXCoordinates() {
        return this.roundXCoordinates;
    }

    public void setRoundXCoordinates(boolean bl2) {
        this.roundXCoordinates = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        return super.initialise(graphics2D, rectangle2D, xYPlot, xYDataset, plotRenderingInfo);
    }

    @Override
    public int getPassCount() {
        return 2;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        if (n4 == 0) {
            this.drawItemPass0(graphics2D, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState);
            return;
        }
        if (n4 != 1) return;
        this.drawItemPass1(graphics2D, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState);
    }

    protected void drawItemPass0(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState) {
        Shape shape;
        double d2;
        Shape shape2;
        double d3;
        if (n2 != 0) return;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d4 = xYDataset.getYValue(0, n3);
        double d5 = xYDataset.getXValue(1, n3);
        double d6 = xYDataset.getYValue(1, n3);
        double d7 = valueAxis2.valueToJava2D(d4, rectangle2D, rectangleEdge2);
        double d8 = valueAxis.valueToJava2D(d5, rectangle2D, rectangleEdge);
        if (this.roundXCoordinates) {
            d8 = Math.rint(d8);
        }
        double d9 = valueAxis2.valueToJava2D(d6, rectangle2D, rectangleEdge2);
        if (n3 <= 0) return;
        double d10 = xYDataset.getXValue(0, n3 - 1);
        double d11 = xYDataset.getYValue(0, n3 - 1);
        double d12 = xYDataset.getYValue(1, n3 - 1);
        double d13 = valueAxis.valueToJava2D(d10, rectangle2D, rectangleEdge);
        if (this.roundXCoordinates) {
            d13 = Math.rint(d13);
        }
        if ((shape2 = this.getPositiveArea((float)d13, (float)(d2 = valueAxis2.valueToJava2D(d11, rectangle2D, rectangleEdge2)), (float)(d3 = valueAxis2.valueToJava2D(d12, rectangle2D, rectangleEdge2)), (float)d8, (float)d7, (float)d9, plotOrientation)) != null) {
            graphics2D.setPaint(this.getPositivePaint());
            graphics2D.fill(shape2);
        }
        if ((shape = this.getNegativeArea((float)d13, (float)d2, (float)d3, (float)d8, (float)d7, (float)d9, plotOrientation)) == null) return;
        graphics2D.setPaint(this.getNegativePaint());
        graphics2D.fill(shape);
    }

    protected void drawItemPass1(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState) {
        Object object;
        Shape shape = null;
        Object object2 = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        Paint paint = this.getItemPaint(n2, n3);
        Stroke stroke = this.getItemStroke(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        if (n2 != 0) return;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d2 = xYDataset.getXValue(0, n3);
        double d3 = xYDataset.getYValue(0, n3);
        double d4 = xYDataset.getXValue(1, n3);
        double d5 = xYDataset.getYValue(1, n3);
        double d6 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d7 = valueAxis2.valueToJava2D(d3, rectangle2D, rectangleEdge2);
        double d8 = valueAxis.valueToJava2D(d4, rectangle2D, rectangleEdge);
        double d9 = valueAxis2.valueToJava2D(d5, rectangle2D, rectangleEdge2);
        if (n3 > 0) {
            double d10 = xYDataset.getXValue(0, n3 - 1);
            double d11 = xYDataset.getYValue(0, n3 - 1);
            double d12 = xYDataset.getXValue(1, n3 - 1);
            double d13 = xYDataset.getYValue(1, n3 - 1);
            double d14 = valueAxis.valueToJava2D(d10, rectangle2D, rectangleEdge);
            double d15 = valueAxis2.valueToJava2D(d11, rectangle2D, rectangleEdge2);
            double d16 = valueAxis.valueToJava2D(d12, rectangle2D, rectangleEdge);
            double d17 = valueAxis2.valueToJava2D(d13, rectangle2D, rectangleEdge2);
            Line2D.Double double_ = null;
            Line2D line2D = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Line2D.Double(d7, d6, d15, d14);
                line2D = new Line2D.Double(d9, d8, d17, d16);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Line2D.Double(d6, d7, d14, d15);
                line2D = new Line2D.Double(d8, d9, d16, d17);
            }
            if (double_ != null && double_.intersects(rectangle2D)) {
                graphics2D.setPaint(this.getItemPaint(n2, n3));
                graphics2D.setStroke(this.getItemStroke(n2, n3));
                graphics2D.draw(double_);
            }
            if (line2D != null && line2D.intersects(rectangle2D)) {
                graphics2D.setPaint(this.getItemPaint(1, n3));
                graphics2D.setStroke(this.getItemStroke(1, n3));
                graphics2D.draw(line2D);
            }
        }
        if (this.getShapesVisible()) {
            Shape shape2 = this.getItemShape(n2, n3);
            shape2 = plotOrientation == PlotOrientation.HORIZONTAL ? ShapeUtilities.createTranslatedShape(shape2, d7, d6) : ShapeUtilities.createTranslatedShape(shape2, d6, d7);
            if (shape2.intersects(rectangle2D)) {
                graphics2D.setPaint(this.getItemPaint(n2, n3));
                graphics2D.fill(shape2);
            }
            shape = shape2;
            object = this.getItemShape(n2 + 1, n3);
            object = plotOrientation == PlotOrientation.HORIZONTAL ? ShapeUtilities.createTranslatedShape((Shape)object, d9, d8) : ShapeUtilities.createTranslatedShape((Shape)object, d8, d9);
            if (object.intersects(rectangle2D)) {
                graphics2D.setPaint(this.getItemPaint(n2 + 1, n3));
                graphics2D.fill((Shape)object);
            }
            object2 = object;
        }
        if (entityCollection != null) {
            if (shape == null) {
                shape = new Rectangle2D.Double(d6 - 2.0, d7 - 2.0, 4.0, 4.0);
            }
            String string = null;
            object = this.getToolTipGenerator(n2, n3);
            if (object != null) {
                string = object.generateToolTip(xYDataset, n2, n3);
            }
            String string2 = null;
            if (this.getURLGenerator() != null) {
                string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
            }
            XYItemEntity xYItemEntity = new XYItemEntity(shape, xYDataset, n2, n3, string, string2);
            entityCollection.add(xYItemEntity);
            if (object2 == null) {
                object2 = new Rectangle2D.Double(d8 - 2.0, d9 - 2.0, 4.0, 4.0);
            }
            string = null;
            object = this.getToolTipGenerator(n2, n3);
            if (object != null) {
                string = object.generateToolTip(xYDataset, n2 + 1, n3);
            }
            string2 = null;
            if (this.getURLGenerator() != null) {
                string2 = this.getURLGenerator().generateURL(xYDataset, n2 + 1, n3);
            }
            xYItemEntity = new XYItemEntity((Shape)object2, xYDataset, n2 + 1, n3, string, string2);
            entityCollection.add(xYItemEntity);
        }
        int n4 = xYPlot.getDomainAxisIndex(valueAxis);
        int n5 = xYPlot.getRangeAxisIndex(valueAxis2);
        this.updateCrosshairValues(crosshairState, d4, d5, n4, n5, d8, d9, plotOrientation);
        this.updateCrosshairValues(crosshairState, d2, d3, n4, n5, d6, d7, plotOrientation);
    }

    protected Shape getPositiveArea(float f2, float f3, float f4, float f5, float f6, float f7, PlotOrientation plotOrientation) {
        boolean bl2;
        GeneralPath generalPath = null;
        boolean bl3 = f3 >= f4;
        boolean bl4 = bl2 = f6 >= f7;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            bl3 = f4 >= f3;
            boolean bl5 = bl2 = f7 >= f6;
        }
        if (bl3) {
            if (bl2) {
                return null;
            }
            float[] arrf = this.getIntersection(f2, f3, f5, f6, f2, f4, f5, f7);
            GeneralPath generalPath2 = new GeneralPath();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                generalPath2.moveTo(f6, f5);
                generalPath2.lineTo(arrf[1], arrf[0]);
                generalPath2.lineTo(f7, f5);
                generalPath2.closePath();
                return generalPath2;
            } else {
                if (plotOrientation != PlotOrientation.VERTICAL) return generalPath2;
                generalPath2.moveTo(f5, f6);
                generalPath2.lineTo(arrf[0], arrf[1]);
                generalPath2.lineTo(f5, f7);
                generalPath2.closePath();
            }
            return generalPath2;
        }
        float[] arrf = this.getIntersection(f2, f3, f5, f6, f2, f4, f5, f7);
        GeneralPath generalPath3 = new GeneralPath();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            generalPath3.moveTo(f3, f2);
            generalPath3.lineTo(arrf[1], arrf[0]);
            generalPath3.lineTo(f4, f2);
            generalPath3.closePath();
            return generalPath3;
        } else {
            if (plotOrientation != PlotOrientation.VERTICAL) return generalPath3;
            generalPath3.moveTo(f2, f3);
            generalPath3.lineTo(arrf[0], arrf[1]);
            generalPath3.lineTo(f2, f4);
            generalPath3.closePath();
        }
        return generalPath3;
    }

    protected Shape getNegativeArea(float f2, float f3, float f4, float f5, float f6, float f7, PlotOrientation plotOrientation) {
        boolean bl2;
        GeneralPath generalPath = null;
        boolean bl3 = f3 >= f4;
        boolean bl4 = bl2 = f6 >= f7;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            bl3 = f4 >= f3;
            if (f7 < f6) return generalPath;
            boolean bl5 = bl2 = true;
        }
        if (bl3) {
            if (bl2) {
                GeneralPath generalPath2 = new GeneralPath();
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    generalPath2.moveTo(f3, f2);
                    generalPath2.lineTo(f6, f5);
                    generalPath2.lineTo(f7, f5);
                    generalPath2.lineTo(f4, f2);
                    generalPath2.closePath();
                    return generalPath2;
                } else {
                    if (plotOrientation != PlotOrientation.VERTICAL) return generalPath2;
                    generalPath2.moveTo(f2, f3);
                    generalPath2.lineTo(f5, f6);
                    generalPath2.lineTo(f5, f7);
                    generalPath2.lineTo(f2, f4);
                    generalPath2.closePath();
                }
                return generalPath2;
            }
            float[] arrf = this.getIntersection(f2, f3, f5, f6, f2, f4, f5, f7);
            GeneralPath generalPath3 = new GeneralPath();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                generalPath3.moveTo(f3, f2);
                generalPath3.lineTo(arrf[1], arrf[0]);
                generalPath3.lineTo(f4, f2);
                generalPath3.closePath();
                return generalPath3;
            } else {
                if (plotOrientation != PlotOrientation.VERTICAL) return generalPath3;
                generalPath3.moveTo(f2, f3);
                generalPath3.lineTo(arrf[0], arrf[1]);
                generalPath3.lineTo(f2, f4);
                generalPath3.closePath();
            }
            return generalPath3;
        }
        float[] arrf = this.getIntersection(f2, f3, f5, f6, f2, f4, f5, f7);
        GeneralPath generalPath4 = new GeneralPath();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            generalPath4.moveTo(f6, f5);
            generalPath4.lineTo(arrf[1], arrf[0]);
            generalPath4.lineTo(f7, f5);
            generalPath4.closePath();
            return generalPath4;
        } else {
            if (plotOrientation != PlotOrientation.VERTICAL) return generalPath4;
            generalPath4.moveTo(f5, f6);
            generalPath4.lineTo(arrf[0], arrf[1]);
            generalPath4.lineTo(f5, f7);
            generalPath4.closePath();
        }
        return generalPath4;
    }

    private float[] getIntersection(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = (f8 - f6) * (f3 - f7) - (f9 - f7) * (f2 - f6);
        float f11 = (f9 - f7) * (f4 - f2) - (f8 - f6) * (f5 - f3);
        float f12 = f10 / f11;
        float[] arrf = new float[]{f2 + f12 * (f4 - f2), f3 + f12 * (f5 - f3)};
        return arrf;
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        LegendItem legendItem = null;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) return legendItem;
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
        Paint paint = this.getSeriesPaint(n3);
        Stroke stroke = this.getSeriesStroke(n3);
        Line2D.Double double_ = new Line2D.Double(-7.0, 0.0, 7.0, 0.0);
        return new LegendItem(string, string2, string3, string4, (Shape)double_, stroke, paint);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYDifferenceRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYDifferenceRenderer xYDifferenceRenderer = (XYDifferenceRenderer)object;
        if (!PaintUtilities.equal(this.positivePaint, xYDifferenceRenderer.positivePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.negativePaint, xYDifferenceRenderer.negativePaint)) {
            return false;
        }
        if (this.shapesVisible != xYDifferenceRenderer.shapesVisible) {
            return false;
        }
        if (!ShapeUtilities.equal(this.legendLine, xYDifferenceRenderer.legendLine)) {
            return false;
        }
        if (this.roundXCoordinates == xYDifferenceRenderer.roundXCoordinates) return true;
        return false;
    }

    @Override
    public Object clone() {
        XYDifferenceRenderer xYDifferenceRenderer = (XYDifferenceRenderer)super.clone();
        xYDifferenceRenderer.legendLine = ShapeUtilities.clone(this.legendLine);
        return xYDifferenceRenderer;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.positivePaint, objectOutputStream);
        SerialUtilities.writePaint(this.negativePaint, objectOutputStream);
        SerialUtilities.writeShape(this.legendLine, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.positivePaint = SerialUtilities.readPaint(objectInputStream);
        this.negativePaint = SerialUtilities.readPaint(objectInputStream);
        this.legendLine = SerialUtilities.readShape(objectInputStream);
    }
}

