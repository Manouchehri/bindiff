/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer2;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class StackedXYAreaRenderer2
extends XYAreaRenderer2
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 7752676509764539182L;
    private boolean roundXCoordinates = true;

    public StackedXYAreaRenderer2() {
        this(null, null);
    }

    public StackedXYAreaRenderer2(XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        super(xYToolTipGenerator, xYURLGenerator);
    }

    public boolean getRoundXCoordinates() {
        return this.roundXCoordinates;
    }

    public void setRoundXCoordinates(boolean bl2) {
        this.roundXCoordinates = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public Range findRangeBounds(XYDataset xYDataset) {
        if (xYDataset == null) {
            return null;
        }
        double d2 = Double.POSITIVE_INFINITY;
        double d3 = Double.NEGATIVE_INFINITY;
        TableXYDataset tableXYDataset = (TableXYDataset)xYDataset;
        int n2 = tableXYDataset.getItemCount();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                if (d2 != Double.POSITIVE_INFINITY) return new Range(d2, d3);
                return null;
            }
            double[] arrd = this.getStackValues((TableXYDataset)xYDataset, tableXYDataset.getSeriesCount(), n3);
            d2 = Math.min(d2, arrd[0]);
            d3 = Math.max(d3, arrd[1]);
            ++n3;
        } while (true);
    }

    @Override
    public int getPassCount() {
        return 1;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        float f2;
        float f3;
        float f4;
        GeneralPath generalPath = null;
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        TableXYDataset tableXYDataset = (TableXYDataset)xYDataset;
        double d2 = xYDataset.getXValue(n2, n3);
        double d3 = xYDataset.getYValue(n2, n3);
        if (Double.isNaN(d3)) {
            d3 = 0.0;
        }
        double[] arrd = this.getStackValues(tableXYDataset, n2, n3);
        double d4 = xYDataset.getXValue(n2, Math.max(n3 - 1, 0));
        double d5 = xYDataset.getYValue(n2, Math.max(n3 - 1, 0));
        if (Double.isNaN(d5)) {
            d5 = 0.0;
        }
        double[] arrd2 = this.getStackValues(tableXYDataset, n2, Math.max(n3 - 1, 0));
        int n5 = xYDataset.getItemCount(n2);
        double d6 = xYDataset.getXValue(n2, Math.min(n3 + 1, n5 - 1));
        double d7 = xYDataset.getYValue(n2, Math.min(n3 + 1, n5 - 1));
        if (Double.isNaN(d7)) {
            d7 = 0.0;
        }
        double[] arrd3 = this.getStackValues(tableXYDataset, n2, Math.min(n3 + 1, n5 - 1));
        double d8 = (d4 + d2) / 2.0;
        double d9 = (d2 + d6) / 2.0;
        double[] arrd4 = this.averageStackValues(arrd2, arrd);
        double[] arrd5 = this.averageStackValues(arrd, arrd3);
        double[] arrd6 = this.adjustedStackValues(arrd2, arrd);
        double[] arrd7 = this.adjustedStackValues(arrd, arrd3);
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        float f5 = (float)valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        float f6 = (float)valueAxis.valueToJava2D(d8, rectangle2D, rectangleEdge);
        float f7 = (float)valueAxis.valueToJava2D(d9, rectangle2D, rectangleEdge);
        if (this.roundXCoordinates) {
            f5 = Math.round(f5);
            f6 = Math.round(f6);
            f7 = Math.round(f7);
        }
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        GeneralPath generalPath2 = new GeneralPath();
        GeneralPath generalPath3 = new GeneralPath();
        if (d3 >= 0.0) {
            f3 = (float)valueAxis2.valueToJava2D(d3 + arrd[1], rectangle2D, rectangleEdge2);
            f4 = (float)valueAxis2.valueToJava2D(arrd[1], rectangle2D, rectangleEdge2);
            f2 = (float)valueAxis2.valueToJava2D(arrd6[1], rectangle2D, rectangleEdge2);
            if (d5 >= 0.0) {
                double d10 = (d5 + d3) / 2.0 + arrd4[1];
                float f8 = (float)valueAxis2.valueToJava2D(d10, rectangle2D, rectangleEdge2);
                generalPath2.moveTo(f5, f3);
                generalPath2.lineTo(f5, f4);
                generalPath2.lineTo(f6, f2);
                generalPath2.lineTo(f6, f8);
                generalPath2.closePath();
            } else {
                generalPath2.moveTo(f5, f4);
                generalPath2.lineTo(f5, f3);
                generalPath2.lineTo(f6, f2);
                generalPath2.closePath();
            }
            float f9 = (float)valueAxis2.valueToJava2D(arrd7[1], rectangle2D, rectangleEdge2);
            if (d7 >= 0.0) {
                double d11 = (d3 + d7) / 2.0 + arrd5[1];
                float f10 = (float)valueAxis2.valueToJava2D(d11, rectangle2D, rectangleEdge2);
                generalPath3.moveTo(f5, f4);
                generalPath3.lineTo(f5, f3);
                generalPath3.lineTo(f7, f10);
                generalPath3.lineTo(f7, f9);
                generalPath3.closePath();
            } else {
                generalPath3.moveTo(f5, f4);
                generalPath3.lineTo(f5, f3);
                generalPath3.lineTo(f7, f9);
                generalPath3.closePath();
            }
        } else {
            f3 = (float)valueAxis2.valueToJava2D(d3 + arrd[0], rectangle2D, rectangleEdge2);
            f4 = (float)valueAxis2.valueToJava2D(arrd[0], rectangle2D, rectangleEdge2);
            f2 = (float)valueAxis2.valueToJava2D(arrd6[0], rectangle2D, rectangleEdge2);
            if (d5 >= 0.0) {
                generalPath2.moveTo(f5, f4);
                generalPath2.lineTo(f5, f3);
                generalPath2.lineTo(f6, f2);
                generalPath2.clone();
            } else {
                double d12 = (d5 + d3) / 2.0 + arrd4[0];
                float f11 = (float)valueAxis2.valueToJava2D(d12, rectangle2D, rectangleEdge2);
                generalPath2.moveTo(f5, f3);
                generalPath2.lineTo(f5, f4);
                generalPath2.lineTo(f6, f2);
                generalPath2.lineTo(f6, f11);
                generalPath2.closePath();
            }
            float f12 = (float)valueAxis2.valueToJava2D(arrd7[0], rectangle2D, rectangleEdge2);
            if (d7 >= 0.0) {
                generalPath3.moveTo(f5, f4);
                generalPath3.lineTo(f5, f3);
                generalPath3.lineTo(f7, f12);
                generalPath3.closePath();
            } else {
                double d13 = (d3 + d7) / 2.0 + arrd5[0];
                float f13 = (float)valueAxis2.valueToJava2D(d13, rectangle2D, rectangleEdge2);
                generalPath3.moveTo(f5, f4);
                generalPath3.lineTo(f5, f3);
                generalPath3.lineTo(f7, f13);
                generalPath3.lineTo(f7, f12);
                generalPath3.closePath();
            }
        }
        Paint paint = this.getItemPaint(n2, n3);
        if (n4 == 0) {
            graphics2D.setPaint(paint);
            graphics2D.fill(generalPath2);
            graphics2D.fill(generalPath3);
        }
        if (entityCollection == null) return;
        GeneralPath generalPath4 = new GeneralPath(generalPath2);
        generalPath4.append(generalPath3, false);
        generalPath = generalPath4;
        this.addEntity(entityCollection, generalPath, xYDataset, n2, n3, f5, f3);
    }

    private double[] getStackValues(TableXYDataset tableXYDataset, int n2, int n3) {
        double[] arrd = new double[2];
        int n4 = 0;
        while (n4 < n2) {
            double d2 = tableXYDataset.getYValue(n4, n3);
            if (!Double.isNaN(d2)) {
                if (d2 >= 0.0) {
                    double[] arrd2 = arrd;
                    arrd2[1] = arrd2[1] + d2;
                } else {
                    double[] arrd3 = arrd;
                    arrd3[0] = arrd3[0] + d2;
                }
            }
            ++n4;
        }
        return arrd;
    }

    private double[] averageStackValues(double[] arrd, double[] arrd2) {
        double[] arrd3 = new double[]{(arrd[0] + arrd2[0]) / 2.0, (arrd[1] + arrd2[1]) / 2.0};
        return arrd3;
    }

    private double[] adjustedStackValues(double[] arrd, double[] arrd2) {
        double[] arrd3 = new double[2];
        arrd3[0] = arrd[0] == 0.0 || arrd2[0] == 0.0 ? 0.0 : (arrd[0] + arrd2[0]) / 2.0;
        if (arrd[1] != 0.0 && arrd2[1] != 0.0) {
            arrd3[1] = (arrd[1] + arrd2[1]) / 2.0;
            return arrd3;
        }
        arrd3[1] = 0.0;
        return arrd3;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StackedXYAreaRenderer2)) {
            return false;
        }
        StackedXYAreaRenderer2 stackedXYAreaRenderer2 = (StackedXYAreaRenderer2)object;
        if (this.roundXCoordinates == stackedXYAreaRenderer2.roundXCoordinates) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

