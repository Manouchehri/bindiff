package org.jfree.chart.renderer.category;

import java.io.*;
import org.jfree.util.*;
import org.jfree.chart.renderer.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import java.awt.*;
import org.jfree.chart.axis.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import org.jfree.chart.entity.*;

public class AreaRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -4231878281385812757L;
    private AreaRendererEndType endType;
    
    public AreaRenderer() {
        this.endType = AreaRendererEndType.TAPER;
    }
    
    public AreaRendererEndType getEndType() {
        return this.endType;
    }
    
    public void setEndType(final AreaRendererEndType endType) {
        if (endType == null) {
            throw new IllegalArgumentException("Null 'type' argument.");
        }
        this.endType = endType;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public LegendItem getLegendItem(final int n, final int n2) {
        final CategoryPlot plot = this.getPlot();
        if (plot == null) {
            return null;
        }
        if (!this.isSeriesVisible(n2) || !this.isSeriesVisibleInLegend(n2)) {
            return null;
        }
        final CategoryDataset dataset = plot.getDataset(n);
        final String generateLabel = this.getLegendItemLabelGenerator().generateLabel(dataset, n2);
        String generateLabel2 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, n2);
        }
        String generateLabel3 = null;
        if (this.getLegendItemURLGenerator() != null) {
            generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, n2);
        }
        return new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0), this.getSeriesPaint(n2), this.getSeriesOutlineStroke(n2), this.getSeriesOutlinePaint(n2));
    }
    
    public void drawItem(final Graphics2D graphics2D, final CategoryItemRendererState categoryItemRendererState, final Rectangle2D rectangle2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final ValueAxis valueAxis, final CategoryDataset categoryDataset, final int n, final int n2, final int n3) {
        if (!this.getItemVisible(n, n2)) {
            return;
        }
        final Number value = categoryDataset.getValue(n, n2);
        if (value != null) {
            final PlotOrientation orientation = categoryPlot.getOrientation();
            final RectangleEdge domainAxisEdge = categoryPlot.getDomainAxisEdge();
            final int columnCount = categoryDataset.getColumnCount();
            final float n4 = (float)categoryAxis.getCategoryStart(n2, columnCount, rectangle2D, domainAxisEdge);
            final float n5 = (float)categoryAxis.getCategoryMiddle(n2, columnCount, rectangle2D, domainAxisEdge);
            final float n6 = (float)categoryAxis.getCategoryEnd(n2, columnCount, rectangle2D, domainAxisEdge);
            float n7 = Math.round(n4);
            final float n8 = Math.round(n5);
            float n9 = Math.round(n6);
            if (this.endType == AreaRendererEndType.TRUNCATE) {
                if (n2 == 0) {
                    n7 = n8;
                }
                else if (n2 == this.getColumnCount() - 1) {
                    n9 = n8;
                }
            }
            final double doubleValue = value.doubleValue();
            double n10 = 0.0;
            if (n2 > 0) {
                final Number value2 = categoryDataset.getValue(n, n2 - 1);
                if (value2 != null) {
                    n10 = (value2.doubleValue() + doubleValue) / 2.0;
                }
            }
            double n11 = 0.0;
            if (n2 < categoryDataset.getColumnCount() - 1) {
                final Number value3 = categoryDataset.getValue(n, n2 + 1);
                if (value3 != null) {
                    n11 = (value3.doubleValue() + doubleValue) / 2.0;
                }
            }
            final RectangleEdge rangeAxisEdge = categoryPlot.getRangeAxisEdge();
            final float n12 = (float)valueAxis.valueToJava2D(n10, rectangle2D, rangeAxisEdge);
            final float n13 = (float)valueAxis.valueToJava2D(doubleValue, rectangle2D, rangeAxisEdge);
            final float n14 = (float)valueAxis.valueToJava2D(n11, rectangle2D, rangeAxisEdge);
            final float n15 = (float)valueAxis.valueToJava2D(0.0, rectangle2D, rangeAxisEdge);
            graphics2D.setPaint(this.getItemPaint(n, n2));
            graphics2D.setStroke(this.getItemStroke(n, n2));
            final GeneralPath generalPath = new GeneralPath();
            if (orientation == PlotOrientation.VERTICAL) {
                generalPath.moveTo(n7, n15);
                generalPath.lineTo(n7, n12);
                generalPath.lineTo(n8, n13);
                generalPath.lineTo(n9, n14);
                generalPath.lineTo(n9, n15);
            }
            else if (orientation == PlotOrientation.HORIZONTAL) {
                generalPath.moveTo(n15, n7);
                generalPath.lineTo(n12, n7);
                generalPath.lineTo(n13, n8);
                generalPath.lineTo(n14, n9);
                generalPath.lineTo(n15, n9);
            }
            generalPath.closePath();
            graphics2D.setPaint(this.getItemPaint(n, n2));
            graphics2D.fill(generalPath);
            if (this.isItemLabelVisible(n, n2)) {
                this.drawItemLabel(graphics2D, orientation, categoryDataset, n, n2, n8, n13, value.doubleValue() < 0.0);
            }
            final EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
            if (entityCollection != null) {
                this.addItemEntity(entityCollection, categoryDataset, n, n2, generalPath);
            }
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof AreaRenderer && this.endType.equals(((AreaRenderer)o).endType) && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
