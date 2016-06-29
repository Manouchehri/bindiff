package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;

public class CyclicXYItemRenderer extends StandardXYItemRenderer implements Serializable
{
    private static final long serialVersionUID = 4035912243303764892L;
    
    public CyclicXYItemRenderer() {
    }
    
    public CyclicXYItemRenderer(final int n) {
        super(n);
    }
    
    public CyclicXYItemRenderer(final int n, final XYToolTipGenerator xyToolTipGenerator) {
        super(n, xyToolTipGenerator);
    }
    
    public CyclicXYItemRenderer(final int n, final XYToolTipGenerator xyToolTipGenerator, final XYURLGenerator xyurlGenerator) {
        super(n, xyToolTipGenerator, xyurlGenerator);
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        if (!this.getPlotLines() || (!(valueAxis instanceof CyclicNumberAxis) && !(valueAxis2 instanceof CyclicNumberAxis)) || n2 <= 0) {
            super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState, n3);
            return;
        }
        final double xValue = xyDataset.getXValue(n, n2 - 1);
        final double yValue = xyDataset.getYValue(n, n2 - 1);
        if (Double.isNaN(yValue)) {
            super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState, n3);
            return;
        }
        double[] array = new double[2];
        double[] array2 = new double[2];
        array[0] = xValue;
        array2[0] = yValue;
        final double xValue2 = xyDataset.getXValue(n, n2);
        final double yValue2 = xyDataset.getYValue(n, n2);
        if (Double.isNaN(yValue2)) {
            return;
        }
        array[1] = xValue2;
        array2[1] = yValue2;
        double cycleBound = Double.NaN;
        double cycleBound2 = Double.NaN;
        boolean boundMappedToLastCycle = false;
        boolean boundMappedToLastCycle2 = false;
        CyclicNumberAxis cyclicNumberAxis = null;
        CyclicNumberAxis cyclicNumberAxis2 = null;
        if (valueAxis instanceof CyclicNumberAxis) {
            cyclicNumberAxis = (CyclicNumberAxis)valueAxis;
            cycleBound = cyclicNumberAxis.getCycleBound();
            boundMappedToLastCycle = cyclicNumberAxis.isBoundMappedToLastCycle();
            if (array[0] != array[1] && ((cycleBound >= array[0] && cycleBound <= array[1]) || (cycleBound >= array[1] && cycleBound <= array[0]))) {
                final double[] array3 = new double[3];
                final double[] array4 = new double[3];
                array3[0] = array[0];
                array3[2] = array[1];
                array4[0] = array2[0];
                array4[2] = array2[1];
                array3[1] = cycleBound;
                array4[1] = (array2[1] - array2[0]) * (cycleBound - array[0]) / (array[1] - array[0]) + array2[0];
                array = array3;
                array2 = array4;
            }
        }
        if (valueAxis2 instanceof CyclicNumberAxis) {
            cyclicNumberAxis2 = (CyclicNumberAxis)valueAxis2;
            cycleBound2 = cyclicNumberAxis2.getCycleBound();
            boundMappedToLastCycle2 = cyclicNumberAxis2.isBoundMappedToLastCycle();
            if (array2[0] != array2[1] && ((cycleBound2 >= array2[0] && cycleBound2 <= array2[1]) || (cycleBound2 >= array2[1] && cycleBound2 <= array2[0]))) {
                final double[] array5 = new double[array.length + 1];
                final double[] array6 = new double[array2.length + 1];
                array5[0] = array[0];
                array5[2] = array[1];
                array6[0] = array2[0];
                array6[2] = array2[1];
                array6[1] = cycleBound2;
                array5[1] = (array[1] - array[0]) * (cycleBound2 - array2[0]) / (array2[1] - array2[0]) + array[0];
                if (array.length == 3) {
                    array5[3] = array[2];
                    array6[3] = array2[2];
                }
                array = array5;
                array2 = array6;
            }
            else if (array.length == 3 && array2[1] != array2[2] && ((cycleBound2 >= array2[1] && cycleBound2 <= array2[2]) || (cycleBound2 >= array2[2] && cycleBound2 <= array2[1]))) {
                final double[] array7 = new double[4];
                final double[] array8 = new double[4];
                array7[0] = array[0];
                array7[1] = array[1];
                array7[3] = array[2];
                array8[0] = array2[0];
                array8[1] = array2[1];
                array8[3] = array2[2];
                array8[2] = cycleBound2;
                array7[2] = (array[2] - array[1]) * (cycleBound2 - array2[1]) / (array2[2] - array2[1]) + array[1];
                array = array7;
                array2 = array8;
            }
        }
        if (array.length == 2) {
            super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, xyDataset, n, n2, crosshairState, n3);
            return;
        }
        final CyclicXYItemRenderer$OverwriteDataSet set = new CyclicXYItemRenderer$OverwriteDataSet(array, array2, xyDataset);
        if (cyclicNumberAxis != null) {
            if (cycleBound == array[0]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(array[1] <= cycleBound);
            }
            if (cycleBound == array[1]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(array[0] <= cycleBound);
            }
        }
        if (cyclicNumberAxis2 != null) {
            if (cycleBound2 == array2[0]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(array2[1] <= cycleBound2);
            }
            if (cycleBound2 == array2[1]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(array2[0] <= cycleBound2);
            }
        }
        super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, set, n, 1, crosshairState, n3);
        if (cyclicNumberAxis != null) {
            if (cycleBound == array[1]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(array[2] <= cycleBound);
            }
            if (cycleBound == array[2]) {
                cyclicNumberAxis.setBoundMappedToLastCycle(array[1] <= cycleBound);
            }
        }
        if (cyclicNumberAxis2 != null) {
            if (cycleBound2 == array2[1]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(array2[2] <= cycleBound2);
            }
            if (cycleBound2 == array2[2]) {
                cyclicNumberAxis2.setBoundMappedToLastCycle(array2[1] <= cycleBound2);
            }
        }
        super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, set, n, 2, crosshairState, n3);
        if (array.length == 4) {
            if (cyclicNumberAxis != null) {
                if (cycleBound == array[2]) {
                    cyclicNumberAxis.setBoundMappedToLastCycle(array[3] <= cycleBound);
                }
                if (cycleBound == array[3]) {
                    cyclicNumberAxis.setBoundMappedToLastCycle(array[2] <= cycleBound);
                }
            }
            if (cyclicNumberAxis2 != null) {
                if (cycleBound2 == array2[2]) {
                    cyclicNumberAxis2.setBoundMappedToLastCycle(array2[3] <= cycleBound2);
                }
                if (cycleBound2 == array2[3]) {
                    cyclicNumberAxis2.setBoundMappedToLastCycle(array2[2] <= cycleBound2);
                }
            }
            super.drawItem(graphics2D, xyItemRendererState, rectangle2D, plotRenderingInfo, xyPlot, valueAxis, valueAxis2, set, n, 3, crosshairState, n3);
        }
        if (cyclicNumberAxis != null) {
            cyclicNumberAxis.setBoundMappedToLastCycle(boundMappedToLastCycle);
        }
        if (cyclicNumberAxis2 != null) {
            cyclicNumberAxis2.setBoundMappedToLastCycle(boundMappedToLastCycle2);
        }
    }
}
