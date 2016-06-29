package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.chart.axis.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class LayeredBarRenderer extends BarRenderer implements Serializable
{
    private static final long serialVersionUID = -8716572894780469487L;
    protected ObjectList seriesBarWidthList;
    
    public LayeredBarRenderer() {
        this.seriesBarWidthList = new ObjectList();
    }
    
    public double getSeriesBarWidth(final int n) {
        double doubleValue = Double.NaN;
        final Number n2 = (Number)this.seriesBarWidthList.get(n);
        if (n2 != null) {
            doubleValue = n2.doubleValue();
        }
        return doubleValue;
    }
    
    public void setSeriesBarWidth(final int n, final double n2) {
        this.seriesBarWidthList.set(n, new Double(n2));
    }
    
    protected void calculateBarWidth(final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final int n, final CategoryItemRendererState categoryItemRendererState) {
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
            final double n3 = n2 * this.getMaximumBarWidth();
            double categoryMargin = 0.0;
            if (columnCount > 1) {
                categoryMargin = domainAxis.getCategoryMargin();
            }
            final double n4 = n2 * (1.0 - domainAxis.getLowerMargin() - domainAxis.getUpperMargin() - categoryMargin);
            if (rowCount * columnCount > 0) {
                categoryItemRendererState.setBarWidth(Math.min(n4 / dataset.getColumnCount(), n3));
            }
            else {
                categoryItemRendererState.setBarWidth(Math.min(n4, n3));
            }
        }
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        final PlotOrientation orientation = categoryPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n, n2);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            this.drawVerticalItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n, n2);
        }
    }
    
    protected void drawHorizontalItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        double doubleValue = value.doubleValue();
        double n3 = 0.0;
        final double lowerClip = this.getLowerClip();
        final double upperClip = this.getUpperClip();
        if (upperClip <= 0.0) {
            if (doubleValue >= upperClip) {
                return;
            }
            n3 = upperClip;
            if (doubleValue <= lowerClip) {
                doubleValue = lowerClip;
            }
        }
        else if (lowerClip <= 0.0) {
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
            else if (doubleValue <= lowerClip) {
                doubleValue = lowerClip;
            }
        }
        else {
            if (doubleValue <= lowerClip) {
                return;
            }
            n3 = lowerClip;
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(n3, rectangle2D, rangeAxisEdge);
        final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge);
        final double min = Math.min(valueToJava2D, valueToJava2D2);
        final double abs = Math.abs(valueToJava2D2 - valueToJava2D);
        final double n4 = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        final int rowCount = this.getRowCount();
        double n5 = 0.0;
        double n6 = 1.0;
        final double seriesBarWidth = this.getSeriesBarWidth(n);
        if (!Double.isNaN(seriesBarWidth)) {
            n6 = seriesBarWidth;
        }
        final double n7 = n6 * categoryItemRendererState.getBarWidth();
        final double n8 = n4 + (1.0 - n6) * categoryItemRendererState.getBarWidth() / 2.0;
        if (rowCount > 1) {
            n5 = n7 * 0.2 / (rowCount - 1);
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(min, n8 + (rowCount - 1 - n) * n5, abs, n7 - (rowCount - 1 - n) * n5 * 2.0);
        Paint paint = this.getItemPaint(n, n2);
        final GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
        if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
            paint = gradientPaintTransformer.transform((GradientPaint)paint, double1);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double1);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            final Stroke itemOutlineStroke = this.getItemOutlineStroke(n, n2);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(n, n2);
            if (itemOutlineStroke != null && itemOutlinePaint != null) {
                graphics2D.setStroke(itemOutlineStroke);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(double1);
            }
        }
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, valueToJava2D > valueToJava2D2);
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
    
    protected void drawVerticalItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2) {
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final double n3 = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        final int rowCount = this.getRowCount();
        double doubleValue = value.doubleValue();
        double lowerClip = 0.0;
        final double lowerClip2 = this.getLowerClip();
        final double upperClip = this.getUpperClip();
        if (upperClip <= 0.0) {
            if (doubleValue >= upperClip) {
                return;
            }
            lowerClip = upperClip;
            if (doubleValue <= lowerClip2) {
                doubleValue = lowerClip2;
            }
        }
        else if (lowerClip2 <= 0.0) {
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
            else if (doubleValue <= lowerClip2) {
                doubleValue = lowerClip2;
            }
        }
        else {
            if (doubleValue <= lowerClip2) {
                return;
            }
            lowerClip = this.getLowerClip();
            if (doubleValue >= upperClip) {
                doubleValue = upperClip;
            }
        }
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final double valueToJava2D = valueAxis.valueToJava2D(lowerClip, rectangle2D, rangeAxisEdge);
        final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge);
        final double min = Math.min(valueToJava2D2, valueToJava2D);
        categoryItemRendererState.getBarWidth();
        final double abs = Math.abs(valueToJava2D2 - valueToJava2D);
        double n4 = 0.0;
        double n5 = 1.0;
        final double seriesBarWidth = this.getSeriesBarWidth(n);
        if (!Double.isNaN(seriesBarWidth)) {
            n5 = seriesBarWidth;
        }
        final double n6 = n5 * categoryItemRendererState.getBarWidth();
        final double n7 = n3 + (1.0 - n5) * categoryItemRendererState.getBarWidth() / 2.0;
        if (rowCount > 1) {
            n4 = n6 * 0.2 / (rowCount - 1);
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(n7 + (rowCount - 1 - n) * n4, min, n6 - (rowCount - 1 - n) * n4 * 2.0, abs);
        Paint paint = this.getItemPaint(n, n2);
        final GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
        if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
            paint = gradientPaintTransformer.transform((GradientPaint)paint, double1);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double1);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            final Stroke itemOutlineStroke = this.getItemOutlineStroke(n, n2);
            final Paint itemOutlinePaint = this.getItemOutlinePaint(n, n2);
            if (itemOutlineStroke != null && itemOutlinePaint != null) {
                graphics2D.setStroke(itemOutlineStroke);
                graphics2D.setPaint(itemOutlinePaint);
                graphics2D.draw(double1);
            }
        }
        final double valueToJava2D3 = valueAxis.valueToJava2D(lowerClip, rectangle2D, rangeAxisEdge);
        final double valueToJava2D4 = valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge);
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, valueToJava2D3 > valueToJava2D4);
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
}
