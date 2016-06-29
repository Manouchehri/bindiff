package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.labels.*;

public class IntervalBarRenderer extends BarRenderer implements Serializable, Cloneable, CategoryItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = -5068857361615528725L;
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (categoryDataset instanceof IntervalCategoryDataset) {
            this.drawInterval(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, (IntervalCategoryDataset)categoryDataset, n, n2);
        }
        else {
            super.drawItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n, n2, n3);
        }
    }
    
    protected void drawInterval(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final IntervalCategoryDataset intervalCategoryDataset, final int n, final int n2) {
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        final PlotOrientation orientation = categoryPlot.getOrientation();
        double n3 = 0.0;
        double n4 = 0.0;
        final RectangleEdge domainAxisEdge = categoryPlot.getDomainAxisEdge();
        final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
        final Number endValue = intervalCategoryDataset.getEndValue(n, n2);
        if (endValue == null) {
            return;
        }
        double valueToJava2D = valueAxis.valueToJava2D(endValue.doubleValue(), rectangle2D, rangeAxisEdge);
        final Number startValue = intervalCategoryDataset.getStartValue(n, n2);
        if (startValue == null) {
            return;
        }
        double valueToJava2D2 = valueAxis.valueToJava2D(startValue.doubleValue(), rectangle2D, rangeAxisEdge);
        if (valueToJava2D2 < valueToJava2D) {
            final double n5 = valueToJava2D2;
            valueToJava2D2 = valueToJava2D;
            valueToJava2D = n5;
        }
        double n6 = categoryItemRendererState.getBarWidth();
        double n7 = Math.abs(valueToJava2D2 - valueToJava2D);
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, domainAxisEdge);
            if (rowCount > 1) {
                n4 = categoryStart + n * (categoryItemRendererState.getBarWidth() + rectangle2D.getHeight() * this.getItemMargin() / (columnCount * (rowCount - 1)));
            }
            else {
                n4 = categoryStart + n * categoryItemRendererState.getBarWidth();
            }
            n3 = valueToJava2D;
            n7 = categoryItemRendererState.getBarWidth();
            n6 = Math.abs(valueToJava2D2 - valueToJava2D);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            final double categoryStart2 = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, domainAxisEdge);
            if (rowCount > 1) {
                n3 = categoryStart2 + n * (categoryItemRendererState.getBarWidth() + rectangle2D.getWidth() * this.getItemMargin() / (columnCount * (rowCount - 1)));
            }
            else {
                n3 = categoryStart2 + n * categoryItemRendererState.getBarWidth();
            }
            n4 = valueToJava2D;
        }
        final Rectangle2D.Double double1 = new Rectangle2D.Double(n3, n4, n6, n7);
        graphics2D.setPaint(this.getItemPaint(n, n2));
        graphics2D.fill(double1);
        if (categoryItemRendererState.getBarWidth() > 3.0) {
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
            this.drawItemLabel(graphics2D, intervalCategoryDataset, n, n2, categoryPlot, itemLabelGenerator, double1, false);
        }
        if (categoryItemRendererState.getInfo() != null) {
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                String generateToolTip = null;
                final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
                if (toolTipGenerator != null) {
                    generateToolTip = toolTipGenerator.generateToolTip(intervalCategoryDataset, n, n2);
                }
                String generateURL = null;
                if (this.getItemURLGenerator(n, n2) != null) {
                    generateURL = this.getItemURLGenerator(n, n2).generateURL(intervalCategoryDataset, n, n2);
                }
                entityCollection.add(new CategoryItemEntity(double1, generateToolTip, generateURL, intervalCategoryDataset, n, intervalCategoryDataset.getColumnKey(n2), n2));
            }
        }
    }
}
