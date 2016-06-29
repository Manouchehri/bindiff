package org.jfree.chart.renderer.xy;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.event.*;
import org.jfree.data.*;
import org.jfree.data.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.chart.entity.*;
import org.jfree.ui.*;
import java.awt.*;

public class StackedXYAreaRenderer2 extends XYAreaRenderer2 implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 7752676509764539182L;
    private boolean roundXCoordinates;
    
    public StackedXYAreaRenderer2() {
        this(null, null);
    }
    
    public StackedXYAreaRenderer2(final XYToolTipGenerator xyToolTipGenerator, final XYURLGenerator xyurlGenerator) {
        super(xyToolTipGenerator, xyurlGenerator);
        this.roundXCoordinates = true;
    }
    
    public boolean getRoundXCoordinates() {
        return this.roundXCoordinates;
    }
    
    public void setRoundXCoordinates(final boolean roundXCoordinates) {
        this.roundXCoordinates = roundXCoordinates;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Range findRangeBounds(final XYDataset xyDataset) {
        if (xyDataset == null) {
            return null;
        }
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        final TableXYDataset tableXYDataset = (TableXYDataset)xyDataset;
        for (int itemCount = tableXYDataset.getItemCount(), i = 0; i < itemCount; ++i) {
            final double[] stackValues = this.getStackValues((TableXYDataset)xyDataset, tableXYDataset.getSeriesCount(), i);
            min = Math.min(min, stackValues[0]);
            max = Math.max(max, stackValues[1]);
        }
        if (min == Double.POSITIVE_INFINITY) {
            return null;
        }
        return new Range(min, max);
    }
    
    public int getPassCount() {
        return 1;
    }
    
    public void drawItem(final Graphics2D graphics2D, final XYItemRendererState xyItemRendererState, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo, final XYPlot xyPlot, final ValueAxis valueAxis, final ValueAxis valueAxis2, final XYDataset xyDataset, final int n, final int n2, final CrosshairState crosshairState, final int n3) {
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        final TableXYDataset tableXYDataset = (TableXYDataset)xyDataset;
        final double xValue = xyDataset.getXValue(n, n2);
        double yValue = xyDataset.getYValue(n, n2);
        if (Double.isNaN(yValue)) {
            yValue = 0.0;
        }
        final double[] stackValues = this.getStackValues(tableXYDataset, n, n2);
        final double xValue2 = xyDataset.getXValue(n, Math.max(n2 - 1, 0));
        double yValue2 = xyDataset.getYValue(n, Math.max(n2 - 1, 0));
        if (Double.isNaN(yValue2)) {
            yValue2 = 0.0;
        }
        final double[] stackValues2 = this.getStackValues(tableXYDataset, n, Math.max(n2 - 1, 0));
        final int itemCount = xyDataset.getItemCount(n);
        final double xValue3 = xyDataset.getXValue(n, Math.min(n2 + 1, itemCount - 1));
        double yValue3 = xyDataset.getYValue(n, Math.min(n2 + 1, itemCount - 1));
        if (Double.isNaN(yValue3)) {
            yValue3 = 0.0;
        }
        final double[] stackValues3 = this.getStackValues(tableXYDataset, n, Math.min(n2 + 1, itemCount - 1));
        final double n4 = (xValue2 + xValue) / 2.0;
        final double n5 = (xValue + xValue3) / 2.0;
        final double[] averageStackValues = this.averageStackValues(stackValues2, stackValues);
        final double[] averageStackValues2 = this.averageStackValues(stackValues, stackValues3);
        final double[] adjustedStackValues = this.adjustedStackValues(stackValues2, stackValues);
        final double[] adjustedStackValues2 = this.adjustedStackValues(stackValues, stackValues3);
        final RectangleEdge domainAxisEdge = xyPlot.getDomainAxisEdge();
        float n6 = (float)valueAxis.valueToJava2D(xValue, rectangle2D, domainAxisEdge);
        float n7 = (float)valueAxis.valueToJava2D(n4, rectangle2D, domainAxisEdge);
        float n8 = (float)valueAxis.valueToJava2D(n5, rectangle2D, domainAxisEdge);
        if (this.roundXCoordinates) {
            n6 = Math.round(n6);
            n7 = Math.round(n7);
            n8 = Math.round(n8);
        }
        final RectangleEdge rangeAxisEdge = xyPlot.getRangeAxisEdge();
        final GeneralPath generalPath = new GeneralPath();
        final GeneralPath generalPath2 = new GeneralPath();
        float n9;
        if (yValue >= 0.0) {
            n9 = (float)valueAxis2.valueToJava2D(yValue + stackValues[1], rectangle2D, rangeAxisEdge);
            final float n10 = (float)valueAxis2.valueToJava2D(stackValues[1], rectangle2D, rangeAxisEdge);
            final float n11 = (float)valueAxis2.valueToJava2D(adjustedStackValues[1], rectangle2D, rangeAxisEdge);
            if (yValue2 >= 0.0) {
                final float n12 = (float)valueAxis2.valueToJava2D((yValue2 + yValue) / 2.0 + averageStackValues[1], rectangle2D, rangeAxisEdge);
                generalPath.moveTo(n6, n9);
                generalPath.lineTo(n6, n10);
                generalPath.lineTo(n7, n11);
                generalPath.lineTo(n7, n12);
                generalPath.closePath();
            }
            else {
                generalPath.moveTo(n6, n10);
                generalPath.lineTo(n6, n9);
                generalPath.lineTo(n7, n11);
                generalPath.closePath();
            }
            final float n13 = (float)valueAxis2.valueToJava2D(adjustedStackValues2[1], rectangle2D, rangeAxisEdge);
            if (yValue3 >= 0.0) {
                final float n14 = (float)valueAxis2.valueToJava2D((yValue + yValue3) / 2.0 + averageStackValues2[1], rectangle2D, rangeAxisEdge);
                generalPath2.moveTo(n6, n10);
                generalPath2.lineTo(n6, n9);
                generalPath2.lineTo(n8, n14);
                generalPath2.lineTo(n8, n13);
                generalPath2.closePath();
            }
            else {
                generalPath2.moveTo(n6, n10);
                generalPath2.lineTo(n6, n9);
                generalPath2.lineTo(n8, n13);
                generalPath2.closePath();
            }
        }
        else {
            n9 = (float)valueAxis2.valueToJava2D(yValue + stackValues[0], rectangle2D, rangeAxisEdge);
            final float n15 = (float)valueAxis2.valueToJava2D(stackValues[0], rectangle2D, rangeAxisEdge);
            final float n16 = (float)valueAxis2.valueToJava2D(adjustedStackValues[0], rectangle2D, rangeAxisEdge);
            if (yValue2 >= 0.0) {
                generalPath.moveTo(n6, n15);
                generalPath.lineTo(n6, n9);
                generalPath.lineTo(n7, n16);
                generalPath.clone();
            }
            else {
                final float n17 = (float)valueAxis2.valueToJava2D((yValue2 + yValue) / 2.0 + averageStackValues[0], rectangle2D, rangeAxisEdge);
                generalPath.moveTo(n6, n9);
                generalPath.lineTo(n6, n15);
                generalPath.lineTo(n7, n16);
                generalPath.lineTo(n7, n17);
                generalPath.closePath();
            }
            final float n18 = (float)valueAxis2.valueToJava2D(adjustedStackValues2[0], rectangle2D, rangeAxisEdge);
            if (yValue3 >= 0.0) {
                generalPath2.moveTo(n6, n15);
                generalPath2.lineTo(n6, n9);
                generalPath2.lineTo(n8, n18);
                generalPath2.closePath();
            }
            else {
                final float n19 = (float)valueAxis2.valueToJava2D((yValue + yValue3) / 2.0 + averageStackValues2[0], rectangle2D, rangeAxisEdge);
                generalPath2.moveTo(n6, n15);
                generalPath2.lineTo(n6, n9);
                generalPath2.lineTo(n8, n19);
                generalPath2.lineTo(n8, n18);
                generalPath2.closePath();
            }
        }
        final Paint itemPaint = this.getItemPaint(n, n2);
        if (n3 == 0) {
            graphics2D.setPaint(itemPaint);
            graphics2D.fill(generalPath);
            graphics2D.fill(generalPath2);
        }
        if (entityCollection != null) {
            final GeneralPath generalPath3 = new GeneralPath(generalPath);
            generalPath3.append(generalPath2, false);
            this.addEntity(entityCollection, generalPath3, xyDataset, n, n2, n6, n9);
        }
    }
    
    private double[] getStackValues(final TableXYDataset tableXYDataset, final int n, final int n2) {
        final double[] array = new double[2];
        for (int i = 0; i < n; ++i) {
            final double yValue = tableXYDataset.getYValue(i, n2);
            if (!Double.isNaN(yValue)) {
                if (yValue >= 0.0) {
                    final double[] array2 = array;
                    final int n3 = 1;
                    array2[n3] += yValue;
                }
                else {
                    final double[] array3 = array;
                    final int n4 = 0;
                    array3[n4] += yValue;
                }
            }
        }
        return array;
    }
    
    private double[] averageStackValues(final double[] array, final double[] array2) {
        return new double[] { (array[0] + array2[0]) / 2.0, (array[1] + array2[1]) / 2.0 };
    }
    
    private double[] adjustedStackValues(final double[] array, final double[] array2) {
        final double[] array3 = new double[2];
        if (array[0] == 0.0 || array2[0] == 0.0) {
            array3[0] = 0.0;
        }
        else {
            array3[0] = (array[0] + array2[0]) / 2.0;
        }
        if (array[1] == 0.0 || array2[1] == 0.0) {
            array3[1] = 0.0;
        }
        else {
            array3[1] = (array[1] + array2[1]) / 2.0;
        }
        return array3;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StackedXYAreaRenderer2 && this.roundXCoordinates == ((StackedXYAreaRenderer2)o).roundXCoordinates && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
