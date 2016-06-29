package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.event.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.data.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class StackedBarRenderer extends BarRenderer implements Serializable, Cloneable, PublicCloneable
{
    static final long serialVersionUID = 6402943811500067531L;
    private boolean renderAsPercentages;
    
    public StackedBarRenderer() {
        this(false);
    }
    
    public StackedBarRenderer(final boolean renderAsPercentages) {
        this.renderAsPercentages = renderAsPercentages;
        final ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        this.setBasePositiveItemLabelPosition(itemLabelPosition);
        this.setBaseNegativeItemLabelPosition(itemLabelPosition);
        this.setPositiveItemLabelPositionFallback(null);
        this.setNegativeItemLabelPositionFallback(null);
    }
    
    public boolean getRenderAsPercentages() {
        return this.renderAsPercentages;
    }
    
    public void setRenderAsPercentages(final boolean renderAsPercentages) {
        this.renderAsPercentages = renderAsPercentages;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public int getPassCount() {
        return 2;
    }
    
    public Range findRangeBounds(final CategoryDataset categoryDataset) {
        if (this.renderAsPercentages) {
            return new Range(0.0, 1.0);
        }
        return DatasetUtilities.findStackedRangeBounds(categoryDataset, this.getBase());
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
            final int columnCount = dataset.getColumnCount();
            double categoryMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxisForDataset.getCategoryMargin();
            }
            final double n4 = n2 * (1.0 - domainAxisForDataset.getLowerMargin() - domainAxisForDataset.getUpperMargin() - categoryMargin);
            if (columnCount > 0) {
                categoryItemRendererState.setBarWidth(Math.min(n4 / columnCount, n3));
            }
            else {
                categoryItemRendererState.setBarWidth(Math.min(n4, n3));
            }
        }
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        double doubleValue = value.doubleValue();
        double calculateColumnTotal = 0.0;
        if (this.renderAsPercentages) {
            calculateColumnTotal = DataUtilities.calculateColumnTotal(categoryDataset, n2);
            doubleValue /= calculateColumnTotal;
        }
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double n4 = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double base;
        double n5 = base = this.getBase();
        for (int i = 0; i < n; ++i) {
            final Number value2 = categoryDataset.getValue(i, n2);
            if (value2 != null) {
                double doubleValue2 = value2.doubleValue();
                if (this.renderAsPercentages) {
                    doubleValue2 /= calculateColumnTotal;
                }
                if (doubleValue2 > 0.0) {
                    n5 += doubleValue2;
                }
                else {
                    base += doubleValue2;
                }
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        double n6;
        double n7;
        if (doubleValue >= 0.0) {
            n6 = valueAxis.valueToJava2D(n5, rectangle2D, rangeAxisEdge);
            n7 = valueAxis.valueToJava2D(n5 + doubleValue, rectangle2D, rangeAxisEdge);
        }
        else {
            n6 = valueAxis.valueToJava2D(base, rectangle2D, rangeAxisEdge);
            n7 = valueAxis.valueToJava2D(base + doubleValue, rectangle2D, rangeAxisEdge);
        }
        final double min = Math.min(n6, n7);
        final double max = Math.max(Math.abs(n7 - n6), this.getMinimumBarLength());
        Rectangle2D.Double double1;
        if (orientation == PlotOrientation.HORIZONTAL) {
            double1 = new Rectangle2D.Double(min, n4, max, categoryItemRendererState.getBarWidth());
        }
        else {
            double1 = new Rectangle2D.Double(n4, min, categoryItemRendererState.getBarWidth(), max);
        }
        if (n3 == 0) {
            Paint paint = this.getItemPaint(n, n2);
            final GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
            if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
                paint = gradientPaintTransformer.transform((GradientPaint)paint, double1);
            }
            graphics2D.setPaint(paint);
            graphics2D.fill(double1);
            if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
                graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
                graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
                graphics2D.draw(double1);
            }
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                this.addItemEntity(entityCollection, categoryDataset, n, n2, double1);
            }
        }
        else if (n3 == 1) {
            final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
            if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
                this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, doubleValue < 0.0);
            }
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StackedBarRenderer && this.renderAsPercentages == ((StackedBarRenderer)o).renderAsPercentages && super.equals(o));
    }
}
