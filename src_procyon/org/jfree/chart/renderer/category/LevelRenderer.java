package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.event.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.chart.axis.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class LevelRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -8204856624355025117L;
    public static final double DEFAULT_ITEM_MARGIN = 0.2;
    private double itemMargin;
    private double maxItemWidth;
    
    public LevelRenderer() {
        this.itemMargin = 0.2;
        this.maxItemWidth = 1.0;
    }
    
    public double getItemMargin() {
        return this.itemMargin;
    }
    
    public void setItemMargin(final double itemMargin) {
        this.itemMargin = itemMargin;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getMaxItemWidth() {
        return this.maxItemWidth;
    }
    
    public void setMaxItemWidth(final double maxItemWidth) {
        this.maxItemWidth = maxItemWidth;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public double getMaximumItemWidth() {
        return this.getMaxItemWidth();
    }
    
    public void setMaximumItemWidth(final double maxItemWidth) {
        this.setMaxItemWidth(maxItemWidth);
    }
    
    public CategoryItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final CategoryItemRendererState initialise = super.initialise(graphics2D, rectangle2D, categoryPlot, n, plotRenderingInfo);
        this.calculateItemWidth(categoryPlot, rectangle2D, n, initialise);
        return initialise;
    }
    
    protected void calculateItemWidth(final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final int n, final CategoryItemRendererState categoryItemRendererState) {
        final CategoryAxis domainAxis = this.getDomainAxis(categoryPlot, n);
        final CategoryDataset dataset = categoryPlot.getDataset(n);
        if (dataset != null) {
            final int columnCount = dataset.getColumnCount();
            final int rowCount = dataset.getRowCount();
            double n2 = 0.0;
            final PlotOrientation orientation = categoryPlot.getOrientation();
            if (orientation == PlotOrientation.HORIZONTAL) {
                n2 = rectangle2D.getHeight();
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                n2 = rectangle2D.getWidth();
            }
            final double n3 = n2 * this.getMaxItemWidth();
            double categoryMargin = 0.0;
            double itemMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxis.getCategoryMargin();
            }
            if (rowCount > 1) {
                itemMargin = this.getItemMargin();
            }
            final double n4 = n2 * (1.0 - domainAxis.getLowerMargin() - domainAxis.getUpperMargin() - categoryMargin - itemMargin);
            if (rowCount * columnCount > 0) {
                categoryItemRendererState.setBarWidth(Math.min(n4 / (rowCount * columnCount), n3));
            }
            else {
                categoryItemRendererState.setBarWidth(Math.min(n4, n3));
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
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        double n5;
        if (rowCount > 1) {
            final double n4 = n3 * this.getItemMargin() / (columnCount * (rowCount - 1));
            final double calculateSeriesWidth = this.calculateSeriesWidth(n3, categoryAxis, columnCount, rowCount);
            n5 = categoryStart + n * (calculateSeriesWidth + n4) + calculateSeriesWidth / 2.0 - categoryItemRendererState.getBarWidth() / 2.0;
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
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double calculateBarW0 = this.calculateBarW0(categoryPlot, orientation, rectangle2D, categoryAxis, categoryItemRendererState, n, n2);
        final double valueToJava2D = valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge());
        double n4;
        double n5;
        Line2D.Double double1;
        if (orientation == PlotOrientation.HORIZONTAL) {
            n4 = valueToJava2D;
            n5 = calculateBarW0 + categoryItemRendererState.getBarWidth() / 2.0;
            double1 = new Line2D.Double(valueToJava2D, calculateBarW0, valueToJava2D, calculateBarW0 + categoryItemRendererState.getBarWidth());
        }
        else {
            n4 = calculateBarW0 + categoryItemRendererState.getBarWidth() / 2.0;
            n5 = valueToJava2D;
            double1 = new Line2D.Double(calculateBarW0, valueToJava2D, calculateBarW0 + categoryItemRendererState.getBarWidth(), valueToJava2D);
        }
        final Stroke itemStroke = this.getItemStroke(n, n2);
        final Paint itemPaint = this.getItemPaint(n, n2);
        graphics2D.setStroke(itemStroke);
        graphics2D.setPaint(itemPaint);
        graphics2D.draw(double1);
        if (this.getItemLabelGenerator(n, n2) != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, n4, n5, doubleValue < 0.0);
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
                entityCollection.add(new CategoryItemEntity(double1.getBounds(), generateToolTip, generateURL, categoryDataset, n, categoryDataset.getColumnKey(n2), n2));
            }
        }
    }
    
    protected double calculateSeriesWidth(final double n, final CategoryAxis categoryAxis, final int n2, final int n3) {
        double n4 = 1.0 - this.getItemMargin() - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin();
        if (n2 > 1) {
            n4 -= categoryAxis.getCategoryMargin();
        }
        return n * n4 / (n2 * n3);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LevelRenderer)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final LevelRenderer levelRenderer = (LevelRenderer)o;
        return this.itemMargin == levelRenderer.itemMargin && this.maxItemWidth == levelRenderer.maxItemWidth;
    }
}
