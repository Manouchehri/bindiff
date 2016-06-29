package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.event.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;

public class StackedAreaRenderer extends AreaRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -3595635038460823663L;
    private boolean renderAsPercentages;
    
    public StackedAreaRenderer() {
        this(false);
    }
    
    public StackedAreaRenderer(final boolean renderAsPercentages) {
        this.renderAsPercentages = renderAsPercentages;
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
        return DatasetUtilities.findStackedRangeBounds(categoryDataset);
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        double doubleValue = value.doubleValue();
        if (this.renderAsPercentages) {
            doubleValue /= DataUtilities.calculateColumnTotal(categoryDataset, n2);
        }
        final double categoryMiddle = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double previousHeight = this.getPreviousHeight(categoryDataset, n, n2);
        final double n4 = doubleValue + previousHeight;
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(n4, rectangle2D, rangeAxisEdge);
        graphics2D.setPaint(this.getItemPaint(n, n2));
        graphics2D.setStroke(this.getItemStroke(n, n2));
        if (n2 == 0) {
            if (n3 == 1 && this.isItemLabelVisible(n, n2)) {
                this.drawItemLabel(graphics2D, categoryPlot.getOrientation(), categoryDataset, n, n2, categoryMiddle, valueToJava2D, n4 < 0.0);
            }
        }
        else {
            final Number value2 = categoryDataset.getValue(n, n2 - 1);
            if (value2 != null) {
                final double categoryMiddle2 = categoryAxis.getCategoryMiddle(n2 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
                double doubleValue2 = value2.doubleValue();
                if (this.renderAsPercentages) {
                    doubleValue2 /= DataUtilities.calculateColumnTotal(categoryDataset, n2 - 1);
                }
                final double previousHeight2 = this.getPreviousHeight(categoryDataset, n, n2 - 1);
                final double n5 = doubleValue2 + previousHeight2;
                final double valueToJava2D2 = valueAxis.valueToJava2D(previousHeight2, rectangle2D, rangeAxisEdge);
                final double valueToJava2D3 = valueAxis.valueToJava2D(previousHeight, rectangle2D, rangeAxisEdge);
                final double valueToJava2D4 = valueAxis.valueToJava2D(n5, rectangle2D, rangeAxisEdge);
                if (n3 == 0) {
                    Polygon polygon = null;
                    final PlotOrientation orientation = categoryPlot.getOrientation();
                    if (orientation == PlotOrientation.HORIZONTAL) {
                        polygon = new Polygon();
                        polygon.addPoint((int)valueToJava2D4, (int)categoryMiddle2);
                        polygon.addPoint((int)valueToJava2D, (int)categoryMiddle);
                        polygon.addPoint((int)valueToJava2D3, (int)categoryMiddle);
                        polygon.addPoint((int)valueToJava2D2, (int)categoryMiddle2);
                    }
                    else if (orientation == PlotOrientation.VERTICAL) {
                        polygon = new Polygon();
                        polygon.addPoint((int)categoryMiddle2, (int)valueToJava2D4);
                        polygon.addPoint((int)categoryMiddle, (int)valueToJava2D);
                        polygon.addPoint((int)categoryMiddle, (int)valueToJava2D3);
                        polygon.addPoint((int)categoryMiddle2, (int)valueToJava2D2);
                    }
                    graphics2D.setPaint(this.getItemPaint(n, n2));
                    graphics2D.setStroke(this.getItemStroke(n, n2));
                    graphics2D.fill(polygon);
                }
                else if (this.isItemLabelVisible(n, n2)) {
                    this.drawItemLabel(graphics2D, categoryPlot.getOrientation(), categoryDataset, n, n2, categoryMiddle, valueToJava2D, n4 < 0.0);
                }
            }
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            this.addItemEntity(entityCollection, categoryDataset, n, n2, new Rectangle2D.Double(categoryMiddle - 3.0, valueToJava2D - 3.0, 6.0, 6.0));
        }
    }
    
    protected double getPreviousHeight(final CategoryDataset categoryDataset, final int n, final int n2) {
        double n3 = 0.0;
        double calculateColumnTotal = 0.0;
        if (this.renderAsPercentages) {
            calculateColumnTotal = DataUtilities.calculateColumnTotal(categoryDataset, n2);
        }
        for (int i = 0; i < n; ++i) {
            final Number value = categoryDataset.getValue(i, n2);
            if (value != null) {
                double doubleValue = value.doubleValue();
                if (this.renderAsPercentages) {
                    doubleValue /= calculateColumnTotal;
                }
                n3 += doubleValue;
            }
        }
        return n3;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StackedAreaRenderer && this.renderAsPercentages == ((StackedAreaRenderer)o).renderAsPercentages && super.equals(o));
    }
}
