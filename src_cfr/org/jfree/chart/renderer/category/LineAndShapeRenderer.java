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
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class LineAndShapeRenderer
extends AbstractCategoryItemRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -197749519869226398L;
    private Boolean linesVisible = null;
    private BooleanList seriesLinesVisible = new BooleanList();
    private boolean baseLinesVisible;
    private Boolean shapesVisible;
    private BooleanList seriesShapesVisible;
    private boolean baseShapesVisible;
    private Boolean shapesFilled;
    private BooleanList seriesShapesFilled;
    private boolean baseShapesFilled;
    private boolean useFillPaint;
    private boolean drawOutlines;
    private boolean useOutlinePaint;

    public LineAndShapeRenderer() {
        this(true, true);
    }

    public LineAndShapeRenderer(boolean bl2, boolean bl3) {
        this.baseLinesVisible = bl2;
        this.shapesVisible = null;
        this.seriesShapesVisible = new BooleanList();
        this.baseShapesVisible = bl3;
        this.shapesFilled = null;
        this.seriesShapesFilled = new BooleanList();
        this.baseShapesFilled = true;
        this.useFillPaint = false;
        this.drawOutlines = true;
        this.useOutlinePaint = false;
    }

    public boolean getItemLineVisible(int n2, int n3) {
        Boolean bl2 = this.linesVisible;
        if (bl2 == null) {
            bl2 = this.getSeriesLinesVisible(n2);
        }
        if (bl2 == null) return this.baseLinesVisible;
        return bl2;
    }

    public Boolean getLinesVisible() {
        return this.linesVisible;
    }

    public void setLinesVisible(Boolean bl2) {
        this.linesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setLinesVisible(boolean bl2) {
        this.setLinesVisible(BooleanUtilities.valueOf(bl2));
    }

    public Boolean getSeriesLinesVisible(int n2) {
        return this.seriesLinesVisible.getBoolean(n2);
    }

    public void setSeriesLinesVisible(int n2, Boolean bl2) {
        this.seriesLinesVisible.setBoolean(n2, bl2);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setSeriesLinesVisible(int n2, boolean bl2) {
        this.setSeriesLinesVisible(n2, BooleanUtilities.valueOf(bl2));
    }

    public boolean getBaseLinesVisible() {
        return this.baseLinesVisible;
    }

    public void setBaseLinesVisible(boolean bl2) {
        this.baseLinesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getItemShapeVisible(int n2, int n3) {
        Boolean bl2 = this.shapesVisible;
        if (bl2 == null) {
            bl2 = this.getSeriesShapesVisible(n2);
        }
        if (bl2 == null) return this.baseShapesVisible;
        return bl2;
    }

    public Boolean getShapesVisible() {
        return this.shapesVisible;
    }

    public void setShapesVisible(Boolean bl2) {
        this.shapesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public void setShapesVisible(boolean bl2) {
        this.setShapesVisible(BooleanUtilities.valueOf(bl2));
    }

    public Boolean getSeriesShapesVisible(int n2) {
        return this.seriesShapesVisible.getBoolean(n2);
    }

    public void setSeriesShapesVisible(int n2, boolean bl2) {
        this.setSeriesShapesVisible(n2, BooleanUtilities.valueOf(bl2));
    }

    public void setSeriesShapesVisible(int n2, Boolean bl2) {
        this.seriesShapesVisible.setBoolean(n2, bl2);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getBaseShapesVisible() {
        return this.baseShapesVisible;
    }

    public void setBaseShapesVisible(boolean bl2) {
        this.baseShapesVisible = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getDrawOutlines() {
        return this.drawOutlines;
    }

    public void setDrawOutlines(boolean bl2) {
        this.drawOutlines = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getUseOutlinePaint() {
        return this.useOutlinePaint;
    }

    public void setUseOutlinePaint(boolean bl2) {
        this.useOutlinePaint = bl2;
    }

    public boolean getItemShapeFilled(int n2, int n3) {
        return this.getSeriesShapesFilled(n2);
    }

    public boolean getSeriesShapesFilled(int n2) {
        if (this.shapesFilled != null) {
            return this.shapesFilled;
        }
        Boolean bl2 = this.seriesShapesFilled.getBoolean(n2);
        if (bl2 == null) return this.baseShapesFilled;
        return bl2;
    }

    public Boolean getShapesFilled() {
        return this.shapesFilled;
    }

    public void setShapesFilled(boolean bl2) {
        if (bl2) {
            this.setShapesFilled(Boolean.TRUE);
            return;
        }
        this.setShapesFilled(Boolean.FALSE);
    }

    public void setShapesFilled(Boolean bl2) {
        this.shapesFilled = bl2;
    }

    public void setSeriesShapesFilled(int n2, Boolean bl2) {
        this.seriesShapesFilled.setBoolean(n2, bl2);
    }

    public void setSeriesShapesFilled(int n2, boolean bl2) {
        this.seriesShapesFilled.setBoolean(n2, BooleanUtilities.valueOf(bl2));
    }

    public boolean getBaseShapesFilled() {
        return this.baseShapesFilled;
    }

    public void setBaseShapesFilled(boolean bl2) {
        this.baseShapesFilled = bl2;
    }

    public boolean getUseFillPaint() {
        return this.useFillPaint;
    }

    public void setUseFillPaint(boolean bl2) {
        this.useFillPaint = bl2;
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
        if (!this.isSeriesVisibleInLegend(n3)) return null;
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
        Shape shape = this.getSeriesShape(n3);
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.useFillPaint ? this.getItemFillPaint(n3, 0) : paint;
        boolean bl2 = this.drawOutlines;
        Paint paint3 = this.useOutlinePaint ? this.getItemOutlinePaint(n3, 0) : paint;
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        boolean bl3 = this.getItemLineVisible(n3, 0);
        boolean bl4 = this.getItemShapeVisible(n3, 0);
        return new LegendItem(string, string2, string3, string4, bl4, shape, this.getItemShapeFilled(n3, 0), paint2, bl2, paint3, stroke, bl3, (Shape)new Line2D.Double(-7.0, 0.0, 7.0, 0.0), this.getItemStroke(n3, 0), this.getItemPaint(n3, 0));
    }

    @Override
    public int getPassCount() {
        return 2;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        EntityCollection entityCollection;
        Object object;
        if (!this.getItemVisible(n2, n3)) {
            return;
        }
        if (!this.getItemLineVisible(n2, n3) && !this.getItemShapeVisible(n2, n3)) {
            return;
        }
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        double d3 = number.doubleValue();
        double d4 = valueAxis.valueToJava2D(d3, rectangle2D, categoryPlot.getRangeAxisEdge());
        if (n4 == 0 && this.getItemLineVisible(n2, n3) && n3 != 0 && (object = categoryDataset.getValue(n2, n3 - 1)) != null) {
            double d5 = object.doubleValue();
            double d6 = categoryAxis.getCategoryMiddle(n3 - 1, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            double d7 = valueAxis.valueToJava2D(d5, rectangle2D, categoryPlot.getRangeAxisEdge());
            Line2D.Double double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Line2D.Double(d7, d6, d4, d2);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Line2D.Double(d6, d7, d2, d4);
            }
            graphics2D.setPaint(this.getItemPaint(n2, n3));
            graphics2D.setStroke(this.getItemStroke(n2, n3));
            graphics2D.draw(double_);
        }
        if (n4 != 1) return;
        object = this.getItemShape(n2, n3);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            object = ShapeUtilities.createTranslatedShape((Shape)object, d4, d2);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            object = ShapeUtilities.createTranslatedShape((Shape)object, d2, d4);
        }
        if (this.getItemShapeVisible(n2, n3)) {
            if (this.getItemShapeFilled(n2, n3)) {
                if (this.useFillPaint) {
                    graphics2D.setPaint(this.getItemFillPaint(n2, n3));
                } else {
                    graphics2D.setPaint(this.getItemPaint(n2, n3));
                }
                graphics2D.fill((Shape)object);
            }
            if (this.drawOutlines) {
                if (this.useOutlinePaint) {
                    graphics2D.setPaint(this.getItemOutlinePaint(n2, n3));
                } else {
                    graphics2D.setPaint(this.getItemPaint(n2, n3));
                }
                graphics2D.setStroke(this.getItemOutlineStroke(n2, n3));
                graphics2D.draw((Shape)object);
            }
        }
        if (this.isItemLabelVisible(n2, n3)) {
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d4, d2, d3 < 0.0);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                this.drawItemLabel(graphics2D, plotOrientation, categoryDataset, n2, n3, d2, d4, d3 < 0.0);
            }
        }
        if ((entityCollection = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity(entityCollection, categoryDataset, n2, n3, (Shape)object);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LineAndShapeRenderer)) {
            return false;
        }
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)object;
        if (this.baseLinesVisible != lineAndShapeRenderer.baseLinesVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesLinesVisible, lineAndShapeRenderer.seriesLinesVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.linesVisible, lineAndShapeRenderer.linesVisible)) {
            return false;
        }
        if (this.baseShapesVisible != lineAndShapeRenderer.baseShapesVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesShapesVisible, lineAndShapeRenderer.seriesShapesVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shapesVisible, lineAndShapeRenderer.shapesVisible)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.shapesFilled, lineAndShapeRenderer.shapesFilled)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesShapesFilled, lineAndShapeRenderer.seriesShapesFilled)) {
            return false;
        }
        if (this.baseShapesFilled != lineAndShapeRenderer.baseShapesFilled) {
            return false;
        }
        if (this.useOutlinePaint != lineAndShapeRenderer.useOutlinePaint) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    @Override
    public Object clone() {
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)super.clone();
        lineAndShapeRenderer.seriesLinesVisible = (BooleanList)this.seriesLinesVisible.clone();
        lineAndShapeRenderer.seriesShapesVisible = (BooleanList)this.seriesLinesVisible.clone();
        lineAndShapeRenderer.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
        return lineAndShapeRenderer;
    }
}

