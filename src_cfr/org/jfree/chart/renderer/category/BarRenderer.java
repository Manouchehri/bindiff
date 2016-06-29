/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class BarRenderer
extends AbstractCategoryItemRenderer
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 6000649414965887481L;
    public static final double DEFAULT_ITEM_MARGIN = 0.2;
    public static final double BAR_OUTLINE_WIDTH_THRESHOLD = 3.0;
    private double itemMargin = 0.2;
    private boolean drawBarOutline = true;
    private double maximumBarWidth = 1.0;
    private double minimumBarLength = 0.0;
    private GradientPaintTransformer gradientPaintTransformer = new StandardGradientPaintTransformer();
    private ItemLabelPosition positiveItemLabelPositionFallback = null;
    private ItemLabelPosition negativeItemLabelPositionFallback = null;
    private double upperClip;
    private double lowerClip;
    private double base = 0.0;
    private boolean includeBaseInRange = true;

    public double getBase() {
        return this.base;
    }

    public void setBase(double d2) {
        this.base = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getItemMargin() {
        return this.itemMargin;
    }

    public void setItemMargin(double d2) {
        this.itemMargin = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean isDrawBarOutline() {
        return this.drawBarOutline;
    }

    public void setDrawBarOutline(boolean bl2) {
        this.drawBarOutline = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getMaximumBarWidth() {
        return this.maximumBarWidth;
    }

    public void setMaximumBarWidth(double d2) {
        this.maximumBarWidth = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getMinimumBarLength() {
        return this.minimumBarLength;
    }

    public void setMinimumBarLength(double d2) {
        this.minimumBarLength = d2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public GradientPaintTransformer getGradientPaintTransformer() {
        return this.gradientPaintTransformer;
    }

    public void setGradientPaintTransformer(GradientPaintTransformer gradientPaintTransformer) {
        this.gradientPaintTransformer = gradientPaintTransformer;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public ItemLabelPosition getPositiveItemLabelPositionFallback() {
        return this.positiveItemLabelPositionFallback;
    }

    public void setPositiveItemLabelPositionFallback(ItemLabelPosition itemLabelPosition) {
        this.positiveItemLabelPositionFallback = itemLabelPosition;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public ItemLabelPosition getNegativeItemLabelPositionFallback() {
        return this.negativeItemLabelPositionFallback;
    }

    public void setNegativeItemLabelPositionFallback(ItemLabelPosition itemLabelPosition) {
        this.negativeItemLabelPositionFallback = itemLabelPosition;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public boolean getIncludeBaseInRange() {
        return this.includeBaseInRange;
    }

    public void setIncludeBaseInRange(boolean bl2) {
        if (this.includeBaseInRange == bl2) return;
        this.includeBaseInRange = bl2;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public double getLowerClip() {
        return this.lowerClip;
    }

    public double getUpperClip() {
        return this.upperClip;
    }

    @Override
    public CategoryItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, CategoryPlot categoryPlot, int n2, PlotRenderingInfo plotRenderingInfo) {
        CategoryItemRendererState categoryItemRendererState = super.initialise(graphics2D, rectangle2D, categoryPlot, n2, plotRenderingInfo);
        ValueAxis valueAxis = categoryPlot.getRangeAxisForDataset(n2);
        this.lowerClip = valueAxis.getRange().getLowerBound();
        this.upperClip = valueAxis.getRange().getUpperBound();
        this.calculateBarWidth(categoryPlot, rectangle2D, n2, categoryItemRendererState);
        return categoryItemRendererState;
    }

    protected void calculateBarWidth(CategoryPlot categoryPlot, Rectangle2D rectangle2D, int n2, CategoryItemRendererState categoryItemRendererState) {
        CategoryAxis categoryAxis = this.getDomainAxis(categoryPlot, n2);
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        if (categoryDataset == null) return;
        int n3 = categoryDataset.getColumnCount();
        int n4 = categoryDataset.getRowCount();
        double d2 = 0.0;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d2 = rectangle2D.getHeight();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d2 = rectangle2D.getWidth();
        }
        double d3 = d2 * this.getMaximumBarWidth();
        double d4 = 0.0;
        double d5 = 0.0;
        if (n3 > 1) {
            d4 = categoryAxis.getCategoryMargin();
        }
        if (n4 > 1) {
            d5 = this.getItemMargin();
        }
        double d6 = d2 * (1.0 - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin() - d4 - d5);
        if (n4 * n3 > 0) {
            categoryItemRendererState.setBarWidth(Math.min(d6 / (double)(n4 * n3), d3));
            return;
        }
        categoryItemRendererState.setBarWidth(Math.min(d6, d3));
    }

    protected double calculateBarW0(CategoryPlot categoryPlot, PlotOrientation plotOrientation, Rectangle2D rectangle2D, CategoryAxis categoryAxis, CategoryItemRendererState categoryItemRendererState, int n2, int n3) {
        double d2 = 0.0;
        d2 = plotOrientation == PlotOrientation.HORIZONTAL ? rectangle2D.getHeight() : rectangle2D.getWidth();
        double d3 = categoryAxis.getCategoryStart(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
        int n4 = this.getRowCount();
        int n5 = this.getColumnCount();
        if (n4 <= 1) return categoryAxis.getCategoryMiddle(n3, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d4 = d2 * this.getItemMargin() / (double)(n5 * (n4 - 1));
        double d5 = this.calculateSeriesWidth(d2, categoryAxis, n5, n4);
        return d3 + (double)n2 * (d5 + d4) + d5 / 2.0 - categoryItemRendererState.getBarWidth() / 2.0;
    }

    protected double[] calculateBarL0L1(double d2) {
        double d3 = this.getLowerClip();
        double d4 = this.getUpperClip();
        double d5 = Math.min(this.base, d2);
        double d6 = Math.max(this.base, d2);
        if (d6 < d3) {
            return null;
        }
        if (d5 > d4) {
            return null;
        }
        d5 = Math.max(d5, d3);
        d6 = Math.min(d6, d4);
        return new double[]{d5, d6};
    }

    @Override
    public Range findRangeBounds(CategoryDataset categoryDataset) {
        Range range = DatasetUtilities.findRangeBounds(categoryDataset);
        if (range == null) return range;
        if (!this.includeBaseInRange) return range;
        return Range.expandToInclude(range, this.base);
    }

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        CategoryPlot categoryPlot = this.getPlot();
        if (categoryPlot == null) {
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
        LegendItem legendItem = new LegendItem(string, string2, string3, string4, true, (Shape)double_, true, paint, this.isDrawBarOutline(), paint2, stroke, false, (Shape)new Line2D.Float(), (Stroke)new BasicStroke(1.0f), (Paint)Color.black);
        if (this.gradientPaintTransformer == null) return legendItem;
        legendItem.setFillPaintTransformer(this.gradientPaintTransformer);
        return legendItem;
    }

    @Override
    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n2, int n3, int n4) {
        Object object;
        Object object2;
        Number number = categoryDataset.getValue(n2, n3);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d3 = this.calculateBarW0(categoryPlot, plotOrientation, rectangle2D, categoryAxis, categoryItemRendererState, n2, n3);
        double[] arrd = this.calculateBarL0L1(d2);
        if (arrd == null) {
            return;
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        double d4 = valueAxis.valueToJava2D(arrd[0], rectangle2D, rectangleEdge);
        double d5 = valueAxis.valueToJava2D(arrd[1], rectangle2D, rectangleEdge);
        double d6 = Math.min(d4, d5);
        double d7 = Math.max(Math.abs(d5 - d4), this.getMinimumBarLength());
        Rectangle2D.Double double_ = null;
        double_ = plotOrientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(d6, d3, d7, categoryItemRendererState.getBarWidth()) : new Rectangle2D.Double(d3, d6, categoryItemRendererState.getBarWidth(), d7);
        Paint paint = this.getItemPaint(n2, n3);
        GradientPaintTransformer gradientPaintTransformer = this.getGradientPaintTransformer();
        if (gradientPaintTransformer != null && paint instanceof GradientPaint) {
            paint = gradientPaintTransformer.transform((GradientPaint)paint, double_);
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            object2 = this.getItemOutlineStroke(n2, n3);
            object = this.getItemOutlinePaint(n2, n3);
            if (object2 != null && object != null) {
                graphics2D.setStroke((Stroke)object2);
                graphics2D.setPaint((Paint)object);
                graphics2D.draw(double_);
            }
        }
        if ((object2 = this.getItemLabelGenerator(n2, n3)) != null && this.isItemLabelVisible(n2, n3)) {
            this.drawItemLabel(graphics2D, categoryDataset, n2, n3, categoryPlot, (CategoryItemLabelGenerator)object2, double_, d2 < 0.0);
        }
        if ((object = categoryItemRendererState.getEntityCollection()) == null) return;
        this.addItemEntity((EntityCollection)object, categoryDataset, n2, n3, double_);
    }

    protected double calculateSeriesWidth(double d2, CategoryAxis categoryAxis, int n2, int n3) {
        double d3 = 1.0 - this.getItemMargin() - categoryAxis.getLowerMargin() - categoryAxis.getUpperMargin();
        if (n2 <= 1) return d2 * d3 / (double)(n2 * n3);
        d3 -= categoryAxis.getCategoryMargin();
        return d2 * d3 / (double)(n2 * n3);
    }

    protected void drawItemLabel(Graphics2D graphics2D, CategoryDataset categoryDataset, int n2, int n3, CategoryPlot categoryPlot, CategoryItemLabelGenerator categoryItemLabelGenerator, Rectangle2D rectangle2D, boolean bl2) {
        Shape shape;
        String string = categoryItemLabelGenerator.generateLabel(categoryDataset, n2, n3);
        if (string == null) {
            return;
        }
        Font font = this.getItemLabelFont(n2, n3);
        graphics2D.setFont(font);
        Paint paint = this.getItemLabelPaint(n2, n3);
        graphics2D.setPaint(paint);
        ItemLabelPosition itemLabelPosition = null;
        itemLabelPosition = !bl2 ? this.getPositiveItemLabelPosition(n2, n3) : this.getNegativeItemLabelPosition(n2, n3);
        Point2D point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, categoryPlot.getOrientation());
        if (this.isInternalAnchor(itemLabelPosition.getItemLabelAnchor()) && (shape = TextUtilities.calculateRotatedStringBounds(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor())) != null && !rectangle2D.contains(shape.getBounds2D())) {
            itemLabelPosition = !bl2 ? this.getPositiveItemLabelPositionFallback() : this.getNegativeItemLabelPositionFallback();
            if (itemLabelPosition != null) {
                point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), rectangle2D, categoryPlot.getOrientation());
            }
        }
        if (itemLabelPosition == null) return;
        TextUtilities.drawRotatedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
    }

    private Point2D calculateLabelAnchorPoint(ItemLabelAnchor itemLabelAnchor, Rectangle2D rectangle2D, PlotOrientation plotOrientation) {
        Point2D.Double double_ = null;
        double d2 = this.getItemLabelAnchorOffset();
        double d3 = rectangle2D.getX() - d2;
        double d4 = rectangle2D.getX();
        double d5 = rectangle2D.getX() + d2;
        double d6 = rectangle2D.getCenterX();
        double d7 = rectangle2D.getMaxX() - d2;
        double d8 = rectangle2D.getMaxX();
        double d9 = rectangle2D.getMaxX() + d2;
        double d10 = rectangle2D.getMaxY() + d2;
        double d11 = rectangle2D.getMaxY();
        double d12 = rectangle2D.getMaxY() - d2;
        double d13 = rectangle2D.getCenterY();
        double d14 = rectangle2D.getMinY() + d2;
        double d15 = rectangle2D.getMinY();
        double d16 = rectangle2D.getMinY() - d2;
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) {
            return new Point2D.Double(d6, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) {
            return new Point2D.Double(d7, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) {
            return new Point2D.Double(d7, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) {
            return new Point2D.Double(d7, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) {
            return new Point2D.Double(d7, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) {
            return new Point2D.Double(d7, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) {
            return new Point2D.Double(d6, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) {
            return new Point2D.Double(d5, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) {
            return new Point2D.Double(d5, d12);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) {
            return new Point2D.Double(d5, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) {
            return new Point2D.Double(d5, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) {
            return new Point2D.Double(d5, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) {
            return new Point2D.Double(d6, d14);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE1) {
            return new Point2D.Double(d8, d16);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE2) {
            return new Point2D.Double(d9, d15);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE3) {
            return new Point2D.Double(d9, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE4) {
            return new Point2D.Double(d9, d11);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE5) {
            return new Point2D.Double(d8, d10);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE6) {
            return new Point2D.Double(d6, d10);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE7) {
            return new Point2D.Double(d4, d10);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE8) {
            return new Point2D.Double(d3, d11);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE9) {
            return new Point2D.Double(d3, d13);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE10) {
            return new Point2D.Double(d3, d15);
        }
        if (itemLabelAnchor == ItemLabelAnchor.OUTSIDE11) {
            return new Point2D.Double(d4, d16);
        }
        if (itemLabelAnchor != ItemLabelAnchor.OUTSIDE12) return double_;
        return new Point2D.Double(d6, d16);
    }

    private boolean isInternalAnchor(ItemLabelAnchor itemLabelAnchor) {
        if (itemLabelAnchor == ItemLabelAnchor.CENTER) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE1) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE2) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE3) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE4) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE5) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE6) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE7) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE8) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE9) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE10) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE11) return true;
        if (itemLabelAnchor == ItemLabelAnchor.INSIDE12) return true;
        return false;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BarRenderer)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        BarRenderer barRenderer = (BarRenderer)object;
        if (this.base != barRenderer.base) {
            return false;
        }
        if (this.itemMargin != barRenderer.itemMargin) {
            return false;
        }
        if (this.drawBarOutline != barRenderer.drawBarOutline) {
            return false;
        }
        if (this.maximumBarWidth != barRenderer.maximumBarWidth) {
            return false;
        }
        if (this.minimumBarLength != barRenderer.minimumBarLength) {
            return false;
        }
        if (!ObjectUtilities.equal(this.gradientPaintTransformer, barRenderer.gradientPaintTransformer)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.positiveItemLabelPositionFallback, barRenderer.positiveItemLabelPositionFallback)) {
            return false;
        }
        if (ObjectUtilities.equal(this.negativeItemLabelPositionFallback, barRenderer.negativeItemLabelPositionFallback)) return true;
        return false;
    }
}

