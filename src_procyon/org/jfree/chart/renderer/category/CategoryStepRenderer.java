package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import java.awt.geom.*;
import org.jfree.data.category.*;
import java.awt.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.*;

public class CategoryStepRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -5121079703118261470L;
    public static final int STAGGER_WIDTH = 5;
    private boolean stagger;
    
    public CategoryStepRenderer() {
        this(false);
    }
    
    public CategoryStepRenderer(final boolean stagger) {
        this.stagger = false;
        this.stagger = stagger;
    }
    
    public boolean getStagger() {
        return this.stagger;
    }
    
    public void setStagger(final boolean stagger) {
        this.stagger = stagger;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public LegendItem getLegendItem(final int datasetIndex, final int seriesIndex) {
        final CategoryPlot plot = this.getPlot();
        if (plot == null) {
            return null;
        }
        if (!this.isSeriesVisible(seriesIndex) || !this.isSeriesVisibleInLegend(seriesIndex)) {
            return null;
        }
        final CategoryDataset dataset = plot.getDataset(datasetIndex);
        final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, seriesIndex);
        String generateLabel2 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, seriesIndex);
        }
        String generateLabel3 = null;
        if (this.getLegendItemURLGenerator() != null) {
            generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, seriesIndex);
        }
        final LegendItem legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, new Rectangle2D.Double(-4.0, -3.0, 8.0, 6.0), this.getSeriesPaint(seriesIndex));
        legendItem.setSeriesIndex(seriesIndex);
        legendItem.setDatasetIndex(datasetIndex);
        return legendItem;
    }
    
    protected CategoryItemRendererState createState(final PlotRenderingInfo plotRenderingInfo) {
        return new CategoryStepRenderer$State(plotRenderingInfo);
    }
    
    protected void drawLine(final Graphics2D graphics2D, final CategoryStepRenderer$State categoryStepRenderer$State, final PlotOrientation plotOrientation, final double n, final double n2, final double n3, final double n4) {
        if (plotOrientation == PlotOrientation.VERTICAL) {
            categoryStepRenderer$State.line.setLine(n, n2, n3, n4);
            graphics2D.draw(categoryStepRenderer$State.line);
        }
        else if (plotOrientation == PlotOrientation.HORIZONTAL) {
            categoryStepRenderer$State.line.setLine(n2, n, n4, n3);
            graphics2D.draw(categoryStepRenderer$State.line);
        }
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        final Number value = categoryDataset.getValue(n, n2);
        if (value == null) {
            return;
        }
        final PlotOrientation orientation = categoryPlot.getOrientation();
        double categoryStart = categoryAxis.getCategoryStart(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double categoryMiddle = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        final double n4 = 2.0 * categoryMiddle - categoryStart;
        final double valueToJava2D = valueAxis.valueToJava2D(value.doubleValue(), rectangle2D, categoryPlot.getRangeAxisEdge());
        graphics2D.setPaint(this.getItemPaint(n, n2));
        graphics2D.setStroke(this.getItemStroke(n, n2));
        if (n2 != 0) {
            final Number value2 = categoryDataset.getValue(n, n2 - 1);
            if (value2 != null) {
                final double doubleValue = value2.doubleValue();
                final double n5 = 2.0 * categoryAxis.getCategoryMiddle(n2 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryAxis.getCategoryStart(n2 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
                final double valueToJava2D2 = valueAxis.valueToJava2D(doubleValue, rectangle2D, categoryPlot.getRangeAxisEdge());
                if (this.getStagger()) {
                    int n6 = n * 5;
                    if (n6 > categoryStart - n5) {
                        n6 = (int)(categoryStart - n5);
                    }
                    categoryStart = n5 + n6;
                }
                this.drawLine(graphics2D, (CategoryStepRenderer$State)categoryItemRendererState, orientation, n5, valueToJava2D2, categoryStart, valueToJava2D2);
                this.drawLine(graphics2D, (CategoryStepRenderer$State)categoryItemRendererState, orientation, categoryStart, valueToJava2D2, categoryStart, valueToJava2D);
            }
        }
        this.drawLine(graphics2D, (CategoryStepRenderer$State)categoryItemRendererState, orientation, categoryStart, valueToJava2D, n4, valueToJava2D);
        if (this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, categoryMiddle, valueToJava2D, value.doubleValue() < 0.0);
        }
        final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection != null) {
            final Rectangle2D.Double double1 = new Rectangle2D.Double();
            if (orientation == PlotOrientation.VERTICAL) {
                double1.setRect(categoryStart, valueToJava2D, n4 - categoryStart, 4.0);
            }
            else {
                double1.setRect(valueToJava2D - 2.0, categoryStart, 4.0, n4 - categoryStart);
            }
            this.addItemEntity(entityCollection, categoryDataset, n, n2, double1);
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof CategoryStepRenderer && this.stagger == ((CategoryStepRenderer)o).stagger && super.equals(o));
    }
}
