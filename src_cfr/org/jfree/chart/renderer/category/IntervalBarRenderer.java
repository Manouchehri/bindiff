/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class IntervalBarRenderer
extends BarRenderer
implements Serializable,
Cloneable,
CategoryItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = -5068857361615528725L;

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        if (categoryDataset instanceof IntervalCategoryDataset) {
            IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
            this.drawInterval(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, intervalCategoryDataset, n2, n3);
            return;
        }
        super.drawItem(graphics2D, categoryItemRendererState, rectangle2D, categoryPlot, categoryAxis, valueAxis, categoryDataset, n2, n3, n4);
    }

    protected void drawInterval(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, IntervalCategoryDataset intervalCategoryDataset, int n2, int n3) {
        Object object;
        Object object2;
        double d2;
        double d3;
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d4 = 0.0;
        double d5 = 0.0;
        RectangleEdge rectangleEdge = categoryPlot.getDomainAxisEdge();
        RectangleEdge rectangleEdge2 = categoryPlot.getRangeAxisEdge();
        Number number = intervalCategoryDataset.getEndValue(n2, n3);
        if (number == null) {
            return;
        }
        double d6 = valueAxis.valueToJava2D(number.doubleValue(), rectangle2D, rectangleEdge2);
        Number number2 = intervalCategoryDataset.getStartValue(n2, n3);
        if (number2 == null) {
            return;
        }
        double d7 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, rectangleEdge2);
        if (d7 < d6) {
            d3 = d7;
            d7 = d6;
            d6 = d3;
            Number number3 = number2;
            number2 = number;
            number = number3;
        }
        d3 = categoryItemRendererState.getBarWidth();
        double d8 = Math.abs(d7 - d6);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d5 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
            if (n4 > 1) {
                d2 = rectangle2D.getHeight() * this.getItemMargin() / (double)(n5 * (n4 - 1));
                d5 += (double)n2 * (categoryItemRendererState.getBarWidth() + d2);
            } else {
                d5 += (double)n2 * categoryItemRendererState.getBarWidth();
            }
            d4 = d6;
            d8 = categoryItemRendererState.getBarWidth();
            d3 = Math.abs(d7 - d6);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d4 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
            if (n4 > 1) {
                d2 = rectangle2D.getWidth() * this.getItemMargin() / (double)(n5 * (n4 - 1));
                d4 += (double)n2 * (categoryItemRendererState.getBarWidth() + d2);
            } else {
                d4 += (double)n2 * categoryItemRendererState.getBarWidth();
            }
            d5 = d6;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(d4, d5, d3, d8);
        Paint paint = this.getItemPaint(n2, n3);
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (categoryItemRendererState.getBarWidth() > 3.0) {
            object2 = this.getItemOutlineStroke(n2, n3);
            object = this.getItemOutlinePaint(n2, n3);
            if (object2 != null && object != null) {
                graphics2D.setStroke((Stroke)object2);
                graphics2D.setPaint((Paint)object);
                graphics2D.draw(double_);
            }
        }
        if ((object2 = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, intervalCategoryDataset, n2, n3, categoryPlot, (CategoryItemLabelGenerator)object2, double_, false);
        }
        if (categoryItemRendererState.getInfo() == null) return;
        object = categoryItemRendererState.getEntityCollection();
        if (object == null) return;
        String string = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            string = categoryToolTipGenerator.generateToolTip(intervalCategoryDataset, n2, n3);
        }
        String string2 = null;
        if (this.getItemURLGenerator(n2, n3) != null) {
            string2 = this.getItemURLGenerator(n2, n3).generateURL(intervalCategoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(double_, string, string2, intervalCategoryDataset, n2, intervalCategoryDataset.getColumnKey(n3), n3);
        object.add(categoryItemEntity);
    }
}

