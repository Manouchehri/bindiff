/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.CategoryStepRenderer$State;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class CategoryStepRenderer
extends AbstractCategoryItemRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -5121079703118261470L;
    public static final int STAGGER_WIDTH = 5;
    private boolean stagger = false;

    public CategoryStepRenderer() {
        this(false);
    }

    public CategoryStepRenderer(boolean bl2) {
        this.stagger = bl2;
    }

    public boolean getStagger() {
        return this.stagger;
    }

    public void setStagger(boolean bl2) {
        this.stagger = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        CategoryPlot categoryPlot = this.getPlot();
        if (categoryPlot == null) {
            return null;
        }
        if (!this.isSeriesVisible(n3)) return null;
        if (!this.isSeriesVisibleInLegend(n3)) {
            return null;
        }
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        String string2 = string = this.getLegendItemLabelGenerator().generateLabel(categoryDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(categoryDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(categoryDataset, n3);
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(-4.0, -3.0, 8.0, 6.0);
        Paint paint = this.getSeriesPaint(n3);
        LegendItem legendItem = new LegendItem(string, string2, string3, string4, (Shape)double_, paint);
        legendItem.setSeriesIndex(n3);
        legendItem.setDatasetIndex(n2);
        return legendItem;
    }

    @Override
    protected CategoryItemRendererState createState(PlotRenderingInfo plotRenderingInfo) {
        return new CategoryStepRenderer$State(plotRenderingInfo);
    }

    protected void drawLine(Graphics2D graphics2D, CategoryStepRenderer$State categoryStepRenderer$State, PlotOrientation plotOrientation, double d2, double d3, double d4, double d5) {
        if (plotOrientation == PlotOrientation.VERTICAL) {
            categoryStepRenderer$State.line.setLine(d2, d3, d4, d5);
            graphics2D.draw(categoryStepRenderer$State.line);
            return;
        }
        if (plotOrientation != PlotOrientation.HORIZONTAL) return;
        categoryStepRenderer$State.line.setLine(d3, d2, d5, d4);
        graphics2D.draw(categoryStepRenderer$State.line);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Object object;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d3 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d4 = 2.0 * d3 - d2;
        double d5 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, categoryPlot.getRangeAxisEdge());
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        graphics2D.setStroke(this.getItemStroke(n2, n3));
        if (n3 != 0 && (object = categoryDataset.getValue(n2, n3 - 1)) != null) {
            double d6 = object.doubleValue();
            double d7 = categoryAxis.getCategoryStart(n3 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            double d8 = categoryAxis.getCategoryMiddle(n3 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            double d9 = 2.0 * d8 - d7;
            double d10 = valueAxis.valueToJava2D(d6, rectangle2D, categoryPlot.getRangeAxisEdge());
            if (this.getStagger()) {
                int n5 = n2 * 5;
                if ((double)n5 > d2 - d9) {
                    n5 = (int)(d2 - d9);
                }
                d2 = d9 + (double)n5;
            }
            this.drawLine(graphics2D, (CategoryStepRenderer$State)categoryItemRendererState, plotOrientation, d9, d10, d2, d10);
            this.drawLine(graphics2D, (CategoryStepRenderer$State)categoryItemRendererState, plotOrientation, d2, d10, d2, d5);
        }
        this.drawLine(graphics2D, (CategoryStepRenderer$State)categoryItemRendererState, plotOrientation, d2, d5, d4, d5);
        if (this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d3, d5, number.doubleValue() < 0.0);
        }
        if ((object = categoryItemRendererState.getEntityCollection()) == null) return;
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        if (plotOrientation == PlotOrientation.VERTICAL) {
            double_.setRect(d2, d5, d4 - d2, 4.0);
        } else {
            double_.setRect(d5 - 2.0, d2, 4.0, d4 - d2);
        }
        this.addItemEntity((EntityCollection)object, categoryDataset, n2, n3, double_);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryStepRenderer)) {
            return false;
        }
        CategoryStepRenderer categoryStepRenderer = (CategoryStepRenderer)object;
        if (this.stagger == categoryStepRenderer.stagger) return super.equals(object);
        return false;
    }
}

