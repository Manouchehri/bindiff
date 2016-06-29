package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.event.*;
import org.jfree.data.category.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class GroupedStackedBarRenderer extends StackedBarRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -2725921399005922939L;
    private KeyToGroupMap seriesToGroupMap;
    
    public GroupedStackedBarRenderer() {
        this.seriesToGroupMap = new KeyToGroupMap();
    }
    
    public void setSeriesToGroupMap(final KeyToGroupMap seriesToGroupMap) {
        if (seriesToGroupMap == null) {
            throw new IllegalArgumentException("Null 'map' argument.");
        }
        this.seriesToGroupMap = seriesToGroupMap;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Range findRangeBounds(final CategoryDataset categoryDataset) {
        return DatasetUtilities.findStackedRangeBounds(categoryDataset, this.seriesToGroupMap);
    }
    
    protected void calculateBarWidth(final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final int n, final CategoryItemRendererState categoryItemRendererState) {
        final CategoryAxis domainAxisForDataset = categoryPlot.getDomainAxisForDataset(n);
        final CategoryDataset dataset = categoryPlot.getDataset(n);
        if (dataset != null) {
            final PlotOrientation orientation = categoryPlot.getOrientation();
            double n2 = 0.0;
            if (orientation == PlotOrientation.HORIZONTAL) {
                n2 = rectangle2D.getHeight();
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                n2 = rectangle2D.getWidth();
            }
            final double n3 = n2 * this.getMaximumBarWidth();
            final int groupCount = this.seriesToGroupMap.getGroupCount();
            final int columnCount = dataset.getColumnCount();
            final int n4 = groupCount * columnCount;
            double categoryMargin = 0.0;
            double itemMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxisForDataset.getCategoryMargin();
            }
            if (groupCount > 1) {
                itemMargin = this.getItemMargin();
            }
            final double n5 = n2 * (1.0 - domainAxisForDataset.getLowerMargin() - domainAxisForDataset.getUpperMargin() - categoryMargin - itemMargin);
            if (n4 > 0) {
                categoryItemRendererState.setBarWidth(Math.min(n5 / n4, n3));
            }
            else {
                categoryItemRendererState.setBarWidth(Math.min(n5, n3));
            }
        }
    }
    
    protected double calculateBarW0(final CategoryPlot categoryPlot, final PlotOrientation plotOrientation, final Rectangle2D rectangle2D, final CategoryAxis categoryAxis, final CategoryItemRendererState categoryItemRendererState, final int n, final int n2) {
        double n3;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            n3 = rectangle2D.getHeight();
        }
        else {
            n3 = rectangle2D.getWidth();
        }
        final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final int groupCount = this.seriesToGroupMap.getGroupCount();
        final int groupIndex = this.seriesToGroupMap.getGroupIndex(this.seriesToGroupMap.getGroup(categoryPlot.getDataset().getRowKey(n)));
        final int columnCount = this.getColumnCount();
        double n5;
        if (groupCount > 1) {
            final double n4 = n3 * this.getItemMargin() / (columnCount * (groupCount - 1));
            final double calculateSeriesWidth = this.calculateSeriesWidth(n3, categoryAxis, columnCount, groupCount);
            n5 = categoryStart + groupIndex * (calculateSeriesWidth + n4) + calculateSeriesWidth / 2.0 - categoryItemRendererState.getBarWidth() / 2.0;
        }
        else {
            n5 = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        }
        return n5;
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final double doubleValue = value.doubleValue();
        final Comparable group = this.seriesToGroupMap.getGroup(categoryDataset.getRowKey(n));
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double calculateBarW0 = this.calculateBarW0(categoryPlot, orientation, rectangle2D, categoryAxis, categoryItemRendererState, n, n2);
        double n4 = 0.0;
        double n5 = 0.0;
        for (int i = 0; i < n; ++i) {
            if (group.equals(this.seriesToGroupMap.getGroup(categoryDataset.getRowKey(i)))) {
                final Number value2 = categoryDataset.getValue(i, n2);
                if (value2 != null) {
                    final double doubleValue2 = value2.doubleValue();
                    if (doubleValue2 > 0.0) {
                        n4 += doubleValue2;
                    }
                    else {
                        n5 += doubleValue2;
                    }
                }
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        double n6;
        double n7;
        if (doubleValue > 0.0) {
            n6 = valueAxis.valueToJava2D(n4, rectangle2D, rangeAxisEdge);
            n7 = valueAxis.valueToJava2D(n4 + doubleValue, rectangle2D, rangeAxisEdge);
        }
        else {
            n6 = valueAxis.valueToJava2D(n5, rectangle2D, rangeAxisEdge);
            n7 = valueAxis.valueToJava2D(n5 + doubleValue, rectangle2D, rangeAxisEdge);
        }
        final double min = Math.min(n6, n7);
        final double max = Math.max(Math.abs(n7 - n6), this.getMinimumBarLength());
        Rectangle2D.Double double1;
        if (orientation == PlotOrientation.HORIZONTAL) {
            double1 = new Rectangle2D.Double(min, calculateBarW0, max, categoryItemRendererState.getBarWidth());
        }
        else {
            double1 = new Rectangle2D.Double(calculateBarW0, min, categoryItemRendererState.getBarWidth(), max);
        }
        Paint paint = this.getItemPaint(n, n2);
        if (this.getGradientPaintTransformer() != null && paint instanceof GradientPaint) {
            paint = this.getGradientPaintTransformer().transform((GradientPaint)paint, double1);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double1);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(double1);
        }
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, doubleValue < 0.0);
        }
        if (categoryItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                String generateToolTip = null;
                final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(categoryDataset, n, n2);
                }
                String generateURL = null;
                if (this.getItemURLGenerator(n, n2) != null) {
                    generateURL = this.getItemURLGenerator(n, n2).generateURL(categoryDataset, n, n2);
                }
                entityCollection.add(new CategoryItemEntity(double1, generateToolTip, generateURL, categoryDataset, n, categoryDataset.getColumnKey(n2), n2));
            }
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof GroupedStackedBarRenderer && super.equals(o) && ((GroupedStackedBarRenderer)o).seriesToGroupMap.equals(this.seriesToGroupMap));
    }
}
