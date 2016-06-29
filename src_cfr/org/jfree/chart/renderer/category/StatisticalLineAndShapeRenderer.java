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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class StatisticalLineAndShapeRenderer
extends LineAndShapeRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -3557517173697777579L;
    private transient Paint errorIndicatorPaint = null;

    public StatisticalLineAndShapeRenderer() {
        this(true, true);
    }

    public StatisticalLineAndShapeRenderer(boolean bl2, boolean bl3) {
        super(bl2, bl3);
    }

    public Paint getErrorIndicatorPaint() {
        return this.errorIndicatorPaint;
    }

    public void setErrorIndicatorPaint(Paint paint) {
        this.errorIndicatorPaint = paint;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Serializable serializable;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        StatisticalCategoryDataset statisticalCategoryDataset = (StatisticalCategoryDataset)categoryDataset;
        Number number2 = statisticalCategoryDataset.getMeanValue(n2, n3);
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d3 = valueAxis.valueToJava2D(number2.doubleValue(), rectangle2D, categoryPlot.getRangeAxisEdge());
        Shape shape = this.getItemShape(n2, n3);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, d3, d2);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            shape = ShapeUtilities.createTranslatedShape(shape, d2, d3);
        }
        if (this.getItemShapeVisible(n2, n3)) {
            if (this.getItemShapeFilled(n2, n3)) {
                graphics2D.setPaint(this.getItemPaint(n2, n3));
                graphics2D.fill(shape);
            } else {
                if (this.getUseOutlinePaint()) {
                    graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                } else {
                    graphics2D.setPaint(this.getItemPaint(n2, n3));
                }
                graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
                graphics2D.draw(shape);
            }
        }
        if (this.getItemLineVisible(n2, n3) && n3 != 0 && (serializable = statisticalCategoryDataset.getValue(n2, n3 - 1)) != null) {
            double d4 = serializable.doubleValue();
            double d5 = categoryAxis.getCategoryMiddle(n3 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            double d6 = valueAxis.valueToJava2D(d4, rectangle2D, categoryPlot.getRangeAxisEdge());
            Line2D.Double double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Line2D.Double(d6, d5, d3, d2);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Line2D.Double(d5, d6, d2, d3);
            }
            graphics2D.setPaint(this.getItemPaint(n2, n3));
            graphics2D.setStroke(this.getItemStroke(n2, n3));
            graphics2D.draw(double_);
        }
        serializable = categoryPlot.getRangeAxisEdge();
        RectangleEdge rectangleEdge = categoryPlot.getDomainAxisEdge();
        double d7 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, rectangleEdge);
        d7 += (double)n2 * categoryItemRendererState.getBarWidth();
        graphics2D.setPaint(this.getItemPaint(n2, n3));
        double d8 = statisticalCategoryDataset.getStdDevValue(n2, n3).doubleValue();
        double d9 = number2.doubleValue() + d8 > valueAxis.getRange().getUpperBound() ? valueAxis.valueToJava2D(valueAxis.getRange().getUpperBound(), rectangle2D, (RectangleEdge)serializable) : valueAxis.valueToJava2D(number2.doubleValue() + d8, rectangle2D, (RectangleEdge)serializable);
        double d10 = number2.doubleValue() + d8 < valueAxis.getRange().getLowerBound() ? valueAxis.valueToJava2D(valueAxis.getRange().getLowerBound(), rectangle2D, (RectangleEdge)serializable) : valueAxis.valueToJava2D(number2.doubleValue() - d8, rectangle2D, (RectangleEdge)serializable);
        if (this.errorIndicatorPaint != null) {
            graphics2D.setPaint(this.errorIndicatorPaint);
        } else {
            graphics2D.setPaint(this.getItemPaint(n2, n3));
        }
        Line2D.Double double_ = new Line2D.Double();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_.setLine(d10, d2, d9, d2);
            graphics2D.draw(double_);
            double_.setLine(d10, d2 - 5.0, d10, d2 + 5.0);
            graphics2D.draw(double_);
            double_.setLine(d9, d2 - 5.0, d9, d2 + 5.0);
            graphics2D.draw(double_);
        } else {
            double_.setLine(d2, d10, d2, d9);
            graphics2D.draw(double_);
            double_.setLine(d2 - 5.0, d9, d2 + 5.0, d9);
            graphics2D.draw(double_);
            double_.setLine(d2 - 5.0, d10, d2 + 5.0, d10);
            graphics2D.draw(double_);
        }
        if (this.isItemLabelVisible(n2, n3)) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d3, d2, number2.doubleValue() < 0.0);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d2, d3, number2.doubleValue() < 0.0);
            }
        }
        if (categoryItemRendererState.getInfo() == null) return;
        EntityCollection entityCollection = categoryItemRendererState.getEntityCollection();
        if (entityCollection == null) return;
        if (shape == null) return;
        String string = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            string = categoryToolTipGenerator.generateToolTip(categoryDataset, n2, n3);
        }
        String string2 = null;
        if (this.getItemURLGenerator(n2, n3) != null) {
            string2 = this.getItemURLGenerator(n2, n3).generateURL(categoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(shape, string, string2, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        entityCollection.add(categoryItemEntity);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StatisticalLineAndShapeRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        StatisticalLineAndShapeRenderer statisticalLineAndShapeRenderer = (StatisticalLineAndShapeRenderer)object;
        if (PaintUtilities.equal(this.errorIndicatorPaint, statisticalLineAndShapeRenderer.errorIndicatorPaint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.errorIndicatorPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.errorIndicatorPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

