/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
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
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class AreaRenderer
extends AbstractCategoryItemRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -4231878281385812757L;
    private AreaRendererEndType endType = AreaRendererEndType.TAPER;

    public AreaRendererEndType getEndType() {
        return this.endType;
    }

    public void setEndType(AreaRendererEndType areaRendererEndType) {
        if (areaRendererEndType == null) {
            throw new IllegalArgumentException("Null 'type' argument.");
        }
        this.endType = areaRendererEndType;
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
        Rectangle2D.Double double_ = new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0);
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.getSeriesOutlinePaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        return new LegendItem(string, string2, string3, string4, (Shape)double_, paint, stroke, paint2);
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        EntityCollection entityCollection;
        Serializable serializable;
        Number number;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        Number number2 = categoryDataset.getValue(n2, n3);
        if (number2 == null) return;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        RectangleEdge rectangleEdge = categoryPlot.getDomainAxisEdge();
        int n5 = categoryDataset.getColumnCount();
        float f2 = (float)categoryAxis.getCategoryStart(n3, n5, rectangle2D, rectangleEdge);
        float f3 = (float)categoryAxis.getCategoryMiddle(n3, n5, rectangle2D, rectangleEdge);
        float f4 = (float)categoryAxis.getCategoryEnd(n3, n5, rectangle2D, rectangleEdge);
        f2 = Math.round(f2);
        f3 = Math.round(f3);
        f4 = Math.round(f4);
        if (this.endType == AreaRendererEndType.TRUNCATE) {
            if (n3 == 0) {
                f2 = f3;
            } else if (n3 == this.getColumnCount() - 1) {
                f4 = f3;
            }
        }
        double d2 = number2.doubleValue();
        double d3 = 0.0;
        if (n3 > 0 && (number = categoryDataset.getValue(n2, n3 - 1)) != null) {
            d3 = (number.doubleValue() + d2) / 2.0;
        }
        double d4 = 0.0;
        if (n3 < categoryDataset.getColumnCount() - 1 && (serializable = categoryDataset.getValue(n2, n3 + 1)) != null) {
            d4 = (serializable.doubleValue() + d2) / 2.0;
        }
        serializable = categoryPlot.getRangeAxisEdge();
        float f5 = (float)valueAxis.valueToJava2D(d3, rectangle2D, (RectangleEdge)serializable);
        float f6 = (float)valueAxis.valueToJava2D(d2, rectangle2D, (RectangleEdge)serializable);
        float f7 = (float)valueAxis.valueToJava2D(d4, rectangle2D, (RectangleEdge)serializable);
        float f8 = (float)valueAxis.valueToJava2D(0.0, rectangle2D, (RectangleEdge)serializable);
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        graphics2D.setStroke(this.getItemStroke(n2, n3));
        GeneralPath generalPath = new GeneralPath();
        if (plotOrientation == PlotOrientation.VERTICAL) {
            generalPath.moveTo(f2, f8);
            generalPath.lineTo(f2, f5);
            generalPath.lineTo(f3, f6);
            generalPath.lineTo(f4, f7);
            generalPath.lineTo(f4, f8);
        } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
            generalPath.moveTo(f8, f2);
            generalPath.lineTo(f5, f2);
            generalPath.lineTo(f6, f3);
            generalPath.lineTo(f7, f4);
            generalPath.lineTo(f8, f4);
        }
        generalPath.closePath();
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        graphics2D.fill(generalPath);
        if (this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, f3, f6, number2.doubleValue() < 0.0);
        }
        if ((entityCollection = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity(entityCollection, categoryDataset, n2, n3, generalPath);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AreaRenderer)) {
            return false;
        }
        AreaRenderer areaRenderer = (AreaRenderer)object;
        if (this.endType.equals(areaRenderer.endType)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

