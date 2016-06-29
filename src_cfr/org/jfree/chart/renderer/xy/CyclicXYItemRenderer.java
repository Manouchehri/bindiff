/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CyclicNumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CyclicXYItemRenderer$OverwriteDataSet;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

public class CyclicXYItemRenderer
extends StandardXYItemRenderer
implements Serializable {
    private static final long serialVersionUID = 4035912243303764892L;

    public CyclicXYItemRenderer() {
    }

    public CyclicXYItemRenderer(int n2) {
        super(n2);
    }

    public CyclicXYItemRenderer(int n2, XYToolTipGenerator xYToolTipGenerator) {
        super(n2, xYToolTipGenerator);
    }

    public CyclicXYItemRenderer(int n2, XYToolTipGenerator xYToolTipGenerator, XYURLGenerator xYURLGenerator) {
        super(n2, xYToolTipGenerator, xYURLGenerator);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, XYItemRendererState xYItemRendererState, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo, XYPlot xYPlot, ValueAxis valueAxis, ValueAxis valueAxis2, XYDataset xYDataset, int n2, int n3, CrosshairState crosshairState, int n4) {
        double[] arrd;
        double[] arrd2;
        if (!this.getPlotLines() || !(valueAxis instanceof CyclicNumberAxis) && !(valueAxis2 instanceof CyclicNumberAxis) || n3 <= 0) {
            super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState, n4);
            return;
        }
        double d2 = xYDataset.getXValue(n2, n3 - 1);
        double d3 = xYDataset.getYValue(n2, n3 - 1);
        if (Double.isNaN(d3)) {
            super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState, n4);
            return;
        }
        double[] arrd3 = new double[2];
        double[] arrd4 = new double[2];
        arrd3[0] = d2;
        arrd4[0] = d3;
        d2 = xYDataset.getXValue(n2, n3);
        d3 = xYDataset.getYValue(n2, n3);
        if (Double.isNaN(d3)) {
            return;
        }
        arrd3[1] = d2;
        arrd4[1] = d3;
        double d4 = Double.NaN;
        double d5 = Double.NaN;
        boolean bl2 = false;
        boolean bl3 = false;
        CyclicNumberAxis cyclicNumberAxis = null;
        CyclicNumberAxis cyclicNumberAxis2 = null;
        if (valueAxis instanceof CyclicNumberAxis) {
            cyclicNumberAxis = (CyclicNumberAxis)valueAxis;
            d4 = cyclicNumberAxis.getCycleBound();
            bl2 = cyclicNumberAxis.isBoundMappedToLastCycle();
            if (arrd3[0] != arrd3[1] && (d4 >= arrd3[0] && d4 <= arrd3[1] || d4 >= arrd3[1] && d4 <= arrd3[0])) {
                arrd = new double[3];
                arrd2 = new double[3];
                arrd[0] = arrd3[0];
                arrd[2] = arrd3[1];
                arrd2[0] = arrd4[0];
                arrd2[2] = arrd4[1];
                arrd[1] = d4;
                arrd2[1] = (arrd4[1] - arrd4[0]) * (d4 - arrd3[0]) / (arrd3[1] - arrd3[0]) + arrd4[0];
                arrd3 = arrd;
                arrd4 = arrd2;
            }
        }
        if (valueAxis2 instanceof CyclicNumberAxis) {
            cyclicNumberAxis2 = (CyclicNumberAxis)valueAxis2;
            d5 = cyclicNumberAxis2.getCycleBound();
            bl3 = cyclicNumberAxis2.isBoundMappedToLastCycle();
            if (arrd4[0] != arrd4[1] && (d5 >= arrd4[0] && d5 <= arrd4[1] || d5 >= arrd4[1] && d5 <= arrd4[0])) {
                arrd = new double[arrd3.length + 1];
                arrd2 = new double[arrd4.length + 1];
                arrd[0] = arrd3[0];
                arrd[2] = arrd3[1];
                arrd2[0] = arrd4[0];
                arrd2[2] = arrd4[1];
                arrd2[1] = d5;
                arrd[1] = (arrd3[1] - arrd3[0]) * (d5 - arrd4[0]) / (arrd4[1] - arrd4[0]) + arrd3[0];
                if (arrd3.length == 3) {
                    arrd[3] = arrd3[2];
                    arrd2[3] = arrd4[2];
                }
                arrd3 = arrd;
                arrd4 = arrd2;
            } else if (arrd3.length == 3 && arrd4[1] != arrd4[2] && (d5 >= arrd4[1] && d5 <= arrd4[2] || d5 >= arrd4[2] && d5 <= arrd4[1])) {
                arrd = new double[4];
                arrd2 = new double[4];
                arrd[0] = arrd3[0];
                arrd[1] = arrd3[1];
                arrd[3] = arrd3[2];
                arrd2[0] = arrd4[0];
                arrd2[1] = arrd4[1];
                arrd2[3] = arrd4[2];
                arrd2[2] = d5;
                arrd[2] = (arrd3[2] - arrd3[1]) * (d5 - arrd4[1]) / (arrd4[2] - arrd4[1]) + arrd3[1];
                arrd3 = arrd;
                arrd4 = arrd2;
            }
        }
        if (arrd3.length == 2) {
            super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, xYDataset, n2, n3, crosshairState, n4);
            return;
        }
        arrd = new double[](arrd3, arrd4, xYDataset);
        if (cyclicNumberAxis != null) {
            if (d4 == arrd3[0]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(arrd3[1] <= d4);
            }
            if (d4 == arrd3[1]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(arrd3[0] <= d4);
            }
        }
        if (cyclicNumberAxis2 != null) {
            if (d5 == arrd4[0]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(arrd4[1] <= d5);
            }
            if (d5 == arrd4[1]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(arrd4[0] <= d5);
            }
        }
        super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, (XYDataset)arrd, n2, 1, crosshairState, n4);
        if (cyclicNumberAxis != null) {
            if (d4 == arrd3[1]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(arrd3[2] <= d4);
            }
            if (d4 == arrd3[2]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(arrd3[1] <= d4);
            }
        }
        if (cyclicNumberAxis2 != null) {
            if (d5 == arrd4[1]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(arrd4[2] <= d5);
            }
            if (d5 == arrd4[2]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(arrd4[1] <= d5);
            }
        }
        super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, (XYDataset)arrd, n2, 2, crosshairState, n4);
        if (arrd3.length == 4) {
            if (cyclicNumberAxis != null) {
                if (d4 == arrd3[2]) {
                    cyclicNumberAxis.setBoundMappedToLastCycle(arrd3[3] <= d4);
                }
                if (d4 == arrd3[3]) {
                    cyclicNumberAxis.setBoundMappedToLastCycle(arrd3[2] <= d4);
                }
            }
            if (cyclicNumberAxis2 != null) {
                if (d5 == arrd4[2]) {
                    cyclicNumberAxis2.setBoundMappedToLastCycle(arrd4[3] <= d5);
                }
                if (d5 == arrd4[3]) {
                    cyclicNumberAxis2.setBoundMappedToLastCycle(arrd4[2] <= d5);
                }
            }
            super.drawItem(graphics2D, xYItemRendererState, rectangle2D, plotRenderingInfo, xYPlot, valueAxis, valueAxis2, (XYDataset)arrd, n2, 3, crosshairState, n4);
        }
        if (cyclicNumberAxis != null) {
            cyclicNumberAxis.setBoundMappedToLastCycle(bl2);
        }
        if (cyclicNumberAxis2 == null) return;
        cyclicNumberAxis2.setBoundMappedToLastCycle(bl3);
    }
}

