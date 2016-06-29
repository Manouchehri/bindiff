/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import java.awt.AlphaComposite;
import java.awt.Composite;
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
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class AbstractCategoryItemRenderer
extends AbstractRenderer
implements Serializable,
Cloneable,
CategoryItemRenderer,
PublicCloneable {
    private static final long serialVersionUID = 1247553218442497391L;
    private CategoryPlot plot;
    private CategoryItemLabelGenerator itemLabelGenerator = null;
    private ObjectList itemLabelGeneratorList = new ObjectList();
    private CategoryItemLabelGenerator baseItemLabelGenerator;
    private CategoryToolTipGenerator toolTipGenerator = null;
    private ObjectList toolTipGeneratorList = new ObjectList();
    private CategoryToolTipGenerator baseToolTipGenerator;
    private CategoryURLGenerator itemURLGenerator = null;
    private ObjectList itemURLGeneratorList = new ObjectList();
    private CategoryURLGenerator baseItemURLGenerator;
    private CategorySeriesLabelGenerator legendItemLabelGenerator = new StandardCategorySeriesLabelGenerator();
    private CategorySeriesLabelGenerator legendItemToolTipGenerator;
    private CategorySeriesLabelGenerator legendItemURLGenerator;
    private transient int rowCount;
    private transient int columnCount;

    protected AbstractCategoryItemRenderer() {
    }

    @Override
    public int getPassCount() {
        return 1;
    }

    @Override
    public CategoryPlot getPlot() {
        return this.plot;
    }

    @Override
    public void setPlot(CategoryPlot categoryPlot) {
        if (categoryPlot == null) {
            throw new IllegalArgumentException("Null 'plot' argument.");
        }
        this.plot = categoryPlot;
    }

    @Override
    public CategoryItemLabelGenerator getItemLabelGenerator(int n2, int n3) {
        return this.getSeriesItemLabelGenerator(n2);
    }

    @Override
    public CategoryItemLabelGenerator getSeriesItemLabelGenerator(int n2) {
        if (this.itemLabelGenerator != null) {
            return this.itemLabelGenerator;
        }
        CategoryItemLabelGenerator categoryItemLabelGenerator = (CategoryItemLabelGenerator)this.itemLabelGeneratorList.get(n2);
        if (categoryItemLabelGenerator != null) return categoryItemLabelGenerator;
        return this.baseItemLabelGenerator;
    }

    @Override
    public void setItemLabelGenerator(CategoryItemLabelGenerator categoryItemLabelGenerator) {
        this.itemLabelGenerator = categoryItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void setSeriesItemLabelGenerator(int n2, CategoryItemLabelGenerator categoryItemLabelGenerator) {
        this.itemLabelGeneratorList.set(n2, categoryItemLabelGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public CategoryItemLabelGenerator getBaseItemLabelGenerator() {
        return this.baseItemLabelGenerator;
    }

    @Override
    public void setBaseItemLabelGenerator(CategoryItemLabelGenerator categoryItemLabelGenerator) {
        this.baseItemLabelGenerator = categoryItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public CategoryToolTipGenerator getToolTipGenerator(int n2, int n3) {
        CategoryToolTipGenerator categoryToolTipGenerator = null;
        if (this.toolTipGenerator != null) {
            return this.toolTipGenerator;
        }
        categoryToolTipGenerator = this.getSeriesToolTipGenerator(n2);
        if (categoryToolTipGenerator != null) return categoryToolTipGenerator;
        return this.baseToolTipGenerator;
    }

    @Override
    public CategoryToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }

    @Override
    public void setToolTipGenerator(CategoryToolTipGenerator categoryToolTipGenerator) {
        this.toolTipGenerator = categoryToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public CategoryToolTipGenerator getSeriesToolTipGenerator(int n2) {
        return (CategoryToolTipGenerator)this.toolTipGeneratorList.get(n2);
    }

    @Override
    public void setSeriesToolTipGenerator(int n2, CategoryToolTipGenerator categoryToolTipGenerator) {
        this.toolTipGeneratorList.set(n2, categoryToolTipGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public CategoryToolTipGenerator getBaseToolTipGenerator() {
        return this.baseToolTipGenerator;
    }

    @Override
    public void setBaseToolTipGenerator(CategoryToolTipGenerator categoryToolTipGenerator) {
        this.baseToolTipGenerator = categoryToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public CategoryURLGenerator getItemURLGenerator(int n2, int n3) {
        return this.getSeriesItemURLGenerator(n2);
    }

    @Override
    public CategoryURLGenerator getSeriesItemURLGenerator(int n2) {
        if (this.itemURLGenerator != null) {
            return this.itemURLGenerator;
        }
        CategoryURLGenerator categoryURLGenerator = (CategoryURLGenerator)this.itemURLGeneratorList.get(n2);
        if (categoryURLGenerator != null) return categoryURLGenerator;
        return this.baseItemURLGenerator;
    }

    @Override
    public void setItemURLGenerator(CategoryURLGenerator categoryURLGenerator) {
        this.itemURLGenerator = categoryURLGenerator;
    }

    @Override
    public void setSeriesItemURLGenerator(int n2, CategoryURLGenerator categoryURLGenerator) {
        this.itemURLGeneratorList.set(n2, categoryURLGenerator);
    }

    @Override
    public CategoryURLGenerator getBaseItemURLGenerator() {
        return this.baseItemURLGenerator;
    }

    @Override
    public void setBaseItemURLGenerator(CategoryURLGenerator categoryURLGenerator) {
        this.baseItemURLGenerator = categoryURLGenerator;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    protected CategoryItemRendererState createState(PlotRenderingInfo plotRenderingInfo) {
        return new CategoryItemRendererState(plotRenderingInfo);
    }

    @Override
    public CategoryItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, CategoryPlot categoryPlot, int n2, PlotRenderingInfo plotRenderingInfo) {
        this.setPlot(categoryPlot);
        CategoryDataset categoryDataset = categoryPlot.getDataset(n2);
        if (categoryDataset != null) {
            this.rowCount = categoryDataset.getRowCount();
            this.columnCount = categoryDataset.getColumnCount();
            return this.createState(plotRenderingInfo);
        }
        this.rowCount = 0;
        this.columnCount = 0;
        return this.createState(plotRenderingInfo);
    }

    @Override
    public Range findRangeBounds(CategoryDataset categoryDataset) {
        return DatasetUtilities.findRangeBounds(categoryDataset);
    }

    @Override
    public void drawBackground(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D) {
        categoryPlot.drawBackground(graphics2D, rectangle2D);
    }

    @Override
    public void drawOutline(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D) {
        categoryPlot.drawOutline(graphics2D, rectangle2D);
    }

    @Override
    public void drawDomainGridline(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D, double d2) {
        Line2D.Double double_ = null;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(rectangle2D.getMinX(), d2, rectangle2D.getMaxX(), d2);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(d2, rectangle2D.getMinY(), d2, rectangle2D.getMaxY());
        }
        Paint paint = categoryPlot.getDomainGridlinePaint();
        if (paint == null) {
            paint = CategoryPlot.DEFAULT_GRIDLINE_PAINT;
        }
        graphics2D.setPaint(paint);
        Stroke stroke = categoryPlot.getDomainGridlineStroke();
        if (stroke == null) {
            stroke = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
        }
        graphics2D.setStroke(stroke);
        graphics2D.draw(double_);
    }

    @Override
    public void drawRangeGridline(Graphics2D graphics2D, CategoryPlot categoryPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2) {
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, categoryPlot.getRangeAxisEdge());
        Line2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        }
        Paint paint = categoryPlot.getRangeGridlinePaint();
        if (paint == null) {
            paint = CategoryPlot.DEFAULT_GRIDLINE_PAINT;
        }
        graphics2D.setPaint(paint);
        Stroke stroke = categoryPlot.getRangeGridlineStroke();
        if (stroke == null) {
            stroke = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
        }
        graphics2D.setStroke(stroke);
        graphics2D.draw(double_);
    }

    @Override
    public void drawDomainMarker(Graphics2D graphics2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, CategoryMarker categoryMarker, Rectangle2D rectangle2D) {
        double d2;
        Comparable comparable = categoryMarker.getKey();
        CategoryDataset categoryDataset = categoryPlot.getDataset(categoryPlot.getIndexOf(this));
        int n2 = categoryDataset.getColumnIndex(comparable);
        if (n2 < 0) {
            return;
        }
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, categoryMarker.getAlpha()));
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        Rectangle2D rectangle2D2 = null;
        if (categoryMarker.getDrawAsLine()) {
            void var14_17;
            d2 = categoryAxis.getCategoryMiddle(n2, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            Object double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                Line2D.Double d3 = new Line2D.Double(rectangle2D.getMinX(), d2, rectangle2D.getMaxX(), d2);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                Line2D.Double double_2 = new Line2D.Double(d2, rectangle2D.getMinY(), d2, rectangle2D.getMaxY());
            }
            graphics2D.setPaint(categoryMarker.getPaint());
            graphics2D.setStroke(categoryMarker.getStroke());
            graphics2D.draw((Shape)var14_17);
            rectangle2D2 = var14_17.getBounds2D();
        } else {
            d2 = categoryAxis.getCategoryStart(n2, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            double d3 = categoryAxis.getCategoryEnd(n2, categoryDataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            Rectangle2D.Double double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Rectangle2D.Double(rectangle2D.getMinX(), d2, rectangle2D.getWidth(), d3 - d2);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Rectangle2D.Double(d2, rectangle2D.getMinY(), d3 - d2, rectangle2D.getHeight());
            }
            graphics2D.setPaint(categoryMarker.getPaint());
            graphics2D.fill(double_);
            rectangle2D2 = double_;
        }
        String string = categoryMarker.getLabel();
        RectangleAnchor rectangleAnchor = categoryMarker.getLabelAnchor();
        if (string != null) {
            Font font = categoryMarker.getLabelFont();
            graphics2D.setFont(font);
            graphics2D.setPaint(categoryMarker.getLabelPaint());
            Point2D point2D = this.calculateDomainMarkerTextAnchorPoint(graphics2D, plotOrientation, rectangle2D, rectangle2D2, categoryMarker.getLabelOffset(), categoryMarker.getLabelOffsetType(), rectangleAnchor);
            TextUtilities.drawAlignedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), categoryMarker.getLabelTextAnchor());
        }
        graphics2D.setComposite(composite);
    }

    @Override
    public void drawRangeMarker(Graphics2D graphics2D, CategoryPlot categoryPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        Object object;
        Object object2;
        if (marker instanceof ValueMarker) {
            ValueMarker valueMarker = (ValueMarker)marker;
            double d2 = valueMarker.getValue();
            Range range = valueAxis.getRange();
            if (!range.contains(d2)) {
                return;
            }
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
            PlotOrientation plotOrientation = categoryPlot.getOrientation();
            double d3 = valueAxis.valueToJava2D(d2, rectangle2D, categoryPlot.getRangeAxisEdge());
            Line2D.Double double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
            }
            graphics2D.setPaint(marker.getPaint());
            graphics2D.setStroke(marker.getStroke());
            graphics2D.draw(double_);
            String string = marker.getLabel();
            RectangleAnchor rectangleAnchor = marker.getLabelAnchor();
            if (string != null) {
                Font font = marker.getLabelFont();
                graphics2D.setFont(font);
                graphics2D.setPaint(marker.getLabelPaint());
                Point2D point2D = this.calculateRangeMarkerTextAnchorPoint(graphics2D, plotOrientation, rectangle2D, double_.getBounds2D(), marker.getLabelOffset(), LengthAdjustmentType.EXPAND, rectangleAnchor);
                TextUtilities.drawAlignedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), marker.getLabelTextAnchor());
            }
            graphics2D.setComposite(composite);
            return;
        }
        if (!(marker instanceof IntervalMarker)) return;
        IntervalMarker intervalMarker = (IntervalMarker)marker;
        double d4 = intervalMarker.getStartValue();
        double d5 = intervalMarker.getEndValue();
        Range range = valueAxis.getRange();
        if (!range.intersects(d4, d5)) {
            return;
        }
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
        double d6 = valueAxis.valueToJava2D(d4, rectangle2D, categoryPlot.getRangeAxisEdge());
        double d7 = valueAxis.valueToJava2D(d5, rectangle2D, categoryPlot.getRangeAxisEdge());
        double d8 = Math.min(d6, d7);
        double d9 = Math.max(d6, d7);
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        Rectangle2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d8 = Math.max(d8, rectangle2D.getMinX());
            d9 = Math.min(d9, rectangle2D.getMaxX());
            double_ = new Rectangle2D.Double(d8, rectangle2D.getMinY(), d9 - d8, rectangle2D.getHeight());
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d8 = Math.max(d8, rectangle2D.getMinY());
            d9 = Math.min(d9, rectangle2D.getMaxY());
            double_ = new Rectangle2D.Double(rectangle2D.getMinX(), d8, rectangle2D.getWidth(), d9 - d8);
        }
        Paint paint = marker.getPaint();
        if (paint instanceof GradientPaint) {
            object = (GradientPaint)paint;
            object2 = intervalMarker.getGradientPaintTransformer();
            if (object2 != null) {
                object = object2.transform((GradientPaint)object, double_);
            }
            graphics2D.setPaint((Paint)object);
        } else {
            graphics2D.setPaint(paint);
        }
        graphics2D.fill(double_);
        if (intervalMarker.getOutlinePaint() != null && intervalMarker.getOutlineStroke() != null) {
            double d10;
            if (plotOrientation == PlotOrientation.VERTICAL) {
                object = new Line2D.Double();
                double d11 = rectangle2D.getMinX();
                d10 = rectangle2D.getMaxX();
                graphics2D.setPaint(intervalMarker.getOutlinePaint());
                graphics2D.setStroke(intervalMarker.getOutlineStroke());
                if (range.contains(d4)) {
                    object.setLine(d11, d6, d10, d6);
                    graphics2D.draw((Shape)object);
                }
                if (range.contains(d5)) {
                    object.setLine(d11, d7, d10, d7);
                    graphics2D.draw((Shape)object);
                }
            } else {
                object = new Line2D.Double();
                double d12 = rectangle2D.getMinY();
                d10 = rectangle2D.getMaxY();
                graphics2D.setPaint(intervalMarker.getOutlinePaint());
                graphics2D.setStroke(intervalMarker.getOutlineStroke());
                if (range.contains(d4)) {
                    object.setLine(d6, d12, d6, d10);
                    graphics2D.draw((Shape)object);
                }
                if (range.contains(d5)) {
                    object.setLine(d7, d12, d7, d10);
                    graphics2D.draw((Shape)object);
                }
            }
        }
        object = marker.getLabel();
        object2 = marker.getLabelAnchor();
        if (object != null) {
            Font font = marker.getLabelFont();
            graphics2D.setFont(font);
            graphics2D.setPaint(marker.getLabelPaint());
            Point2D point2D = this.calculateRangeMarkerTextAnchorPoint(graphics2D, plotOrientation, rectangle2D, double_, marker.getLabelOffset(), marker.getLabelOffsetType(), (RectangleAnchor)object2);
            TextUtilities.drawAlignedString((String)object, graphics2D, (float)point2D.getX(), (float)point2D.getY(), marker.getLabelTextAnchor());
        }
        graphics2D.setComposite(composite);
    }

    protected Point2D calculateDomainMarkerTextAnchorPoint(Graphics2D graphics2D, PlotOrientation plotOrientation, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleInsets rectangleInsets, LengthAdjustmentType lengthAdjustmentType, RectangleAnchor rectangleAnchor) {
        Rectangle2D rectangle2D3 = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, LengthAdjustmentType.CONTRACT, lengthAdjustmentType);
            return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
        }
        if (plotOrientation != PlotOrientation.VERTICAL) return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
        rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, lengthAdjustmentType, LengthAdjustmentType.CONTRACT);
        return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
    }

    protected Point2D calculateRangeMarkerTextAnchorPoint(Graphics2D graphics2D, PlotOrientation plotOrientation, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleInsets rectangleInsets, LengthAdjustmentType lengthAdjustmentType, RectangleAnchor rectangleAnchor) {
        Rectangle2D rectangle2D3 = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, lengthAdjustmentType, LengthAdjustmentType.CONTRACT);
            return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
        }
        if (plotOrientation != PlotOrientation.VERTICAL) return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
        rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, LengthAdjustmentType.CONTRACT, lengthAdjustmentType);
        return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
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
        String string2 = string = this.legendItemLabelGenerator.generateLabel(categoryDataset, n3);
        String string3 = null;
        if (this.legendItemToolTipGenerator != null) {
            string3 = this.legendItemToolTipGenerator.generateLabel(categoryDataset, n3);
        }
        String string4 = null;
        if (this.legendItemURLGenerator != null) {
            string4 = this.legendItemURLGenerator.generateLabel(categoryDataset, n3);
        }
        Shape shape = this.getSeriesShape(n3);
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.getSeriesOutlinePaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        LegendItem legendItem = new LegendItem(string, string2, string3, string4, shape, paint, stroke, paint2);
        legendItem.setSeriesIndex(n3);
        legendItem.setDatasetIndex(n2);
        return legendItem;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractCategoryItemRenderer)) {
            return false;
        }
        AbstractCategoryItemRenderer abstractCategoryItemRenderer = (AbstractCategoryItemRenderer)object;
        if (!ObjectUtilities.equal(this.itemLabelGenerator, abstractCategoryItemRenderer.itemLabelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemLabelGeneratorList, abstractCategoryItemRenderer.itemLabelGeneratorList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseItemLabelGenerator, abstractCategoryItemRenderer.baseItemLabelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipGenerator, abstractCategoryItemRenderer.toolTipGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipGeneratorList, abstractCategoryItemRenderer.toolTipGeneratorList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseToolTipGenerator, abstractCategoryItemRenderer.baseToolTipGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemURLGenerator, abstractCategoryItemRenderer.itemURLGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.itemURLGeneratorList, abstractCategoryItemRenderer.itemURLGeneratorList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseItemURLGenerator, abstractCategoryItemRenderer.baseItemURLGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.legendItemLabelGenerator, abstractCategoryItemRenderer.legendItemLabelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.legendItemToolTipGenerator, abstractCategoryItemRenderer.legendItemToolTipGenerator)) {
            return false;
        }
        if (ObjectUtilities.equal(this.legendItemURLGenerator, abstractCategoryItemRenderer.legendItemURLGenerator)) return super.equals(object);
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        CategoryPlot categoryPlot = this.getPlot();
        if (categoryPlot == null) return drawingSupplier;
        return categoryPlot.getDrawingSupplier();
    }

    protected void drawItemLabel(Graphics2D graphics2D, PlotOrientation plotOrientation, CategoryDataset categoryDataset, int n2, int n3, double d2, double d3, boolean bl2) {
        CategoryItemLabelGenerator categoryItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (categoryItemLabelGenerator == null) return;
        Font font = this.getItemLabelFont(n2, n3);
        Paint paint = this.getItemLabelPaint(n2, n3);
        graphics2D.setFont(font);
        graphics2D.setPaint(paint);
        String string = categoryItemLabelGenerator.generateLabel(categoryDataset, n2, n3);
        ItemLabelPosition itemLabelPosition = null;
        itemLabelPosition = !bl2 ? this.getPositiveItemLabelPosition(n2, n3) : this.getNegativeItemLabelPosition(n2, n3);
        Point2D point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), d2, d3, plotOrientation);
        TextUtilities.drawRotatedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
    }

    @Override
    public Object clone() {
        PublicCloneable publicCloneable;
        AbstractCategoryItemRenderer abstractCategoryItemRenderer = (AbstractCategoryItemRenderer)super.clone();
        if (this.itemLabelGenerator != null) {
            if (!(this.itemLabelGenerator instanceof PublicCloneable)) throw new CloneNotSupportedException("ItemLabelGenerator not cloneable.");
            publicCloneable = (PublicCloneable)((Object)this.itemLabelGenerator);
            abstractCategoryItemRenderer.itemLabelGenerator = (CategoryItemLabelGenerator)publicCloneable.clone();
        }
        if (this.itemLabelGeneratorList != null) {
            abstractCategoryItemRenderer.itemLabelGeneratorList = (ObjectList)this.itemLabelGeneratorList.clone();
        }
        if (this.baseItemLabelGenerator != null) {
            if (!(this.baseItemLabelGenerator instanceof PublicCloneable)) throw new CloneNotSupportedException("ItemLabelGenerator not cloneable.");
            publicCloneable = (PublicCloneable)((Object)this.baseItemLabelGenerator);
            abstractCategoryItemRenderer.baseItemLabelGenerator = (CategoryItemLabelGenerator)publicCloneable.clone();
        }
        if (this.toolTipGenerator != null) {
            if (!(this.toolTipGenerator instanceof PublicCloneable)) throw new CloneNotSupportedException("Tool tip generator not cloneable.");
            publicCloneable = (PublicCloneable)((Object)this.toolTipGenerator);
            abstractCategoryItemRenderer.toolTipGenerator = (CategoryToolTipGenerator)publicCloneable.clone();
        }
        if (this.toolTipGeneratorList != null) {
            abstractCategoryItemRenderer.toolTipGeneratorList = (ObjectList)this.toolTipGeneratorList.clone();
        }
        if (this.baseToolTipGenerator != null) {
            if (!(this.baseToolTipGenerator instanceof PublicCloneable)) throw new CloneNotSupportedException("Base tool tip generator not cloneable.");
            publicCloneable = (PublicCloneable)((Object)this.baseToolTipGenerator);
            abstractCategoryItemRenderer.baseToolTipGenerator = (CategoryToolTipGenerator)publicCloneable.clone();
        }
        if (this.itemURLGenerator != null) {
            if (!(this.itemURLGenerator instanceof PublicCloneable)) throw new CloneNotSupportedException("Item URL generator not cloneable.");
            publicCloneable = (PublicCloneable)((Object)this.itemURLGenerator);
            abstractCategoryItemRenderer.itemURLGenerator = (CategoryURLGenerator)publicCloneable.clone();
        }
        if (this.itemURLGeneratorList != null) {
            abstractCategoryItemRenderer.itemURLGeneratorList = (ObjectList)this.itemURLGeneratorList.clone();
        }
        if (this.baseItemURLGenerator != null) {
            if (!(this.baseItemURLGenerator instanceof PublicCloneable)) throw new CloneNotSupportedException("Base item URL generator not cloneable.");
            publicCloneable = (PublicCloneable)((Object)this.baseItemURLGenerator);
            abstractCategoryItemRenderer.baseItemURLGenerator = (CategoryURLGenerator)publicCloneable.clone();
        }
        if (this.legendItemLabelGenerator instanceof PublicCloneable) {
            abstractCategoryItemRenderer.legendItemLabelGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
        }
        if (this.legendItemToolTipGenerator instanceof PublicCloneable) {
            abstractCategoryItemRenderer.legendItemToolTipGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
        }
        if (!(this.legendItemURLGenerator instanceof PublicCloneable)) return abstractCategoryItemRenderer;
        abstractCategoryItemRenderer.legendItemURLGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
        return abstractCategoryItemRenderer;
    }

    protected CategoryAxis getDomainAxis(CategoryPlot categoryPlot, int n2) {
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis(n2);
        if (categoryAxis != null) return categoryAxis;
        return categoryPlot.getDomainAxis();
    }

    protected ValueAxis getRangeAxis(CategoryPlot categoryPlot, int n2) {
        ValueAxis valueAxis = categoryPlot.getRangeAxis(n2);
        if (valueAxis != null) return valueAxis;
        return categoryPlot.getRangeAxis();
    }

    @Override
    public LegendItemCollection getLegendItems() {
        if (this.plot == null) {
            return new LegendItemCollection();
        }
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        int n2 = this.plot.getIndexOf(this);
        CategoryDataset categoryDataset = this.plot.getDataset(n2);
        if (categoryDataset == null) return legendItemCollection;
        int n3 = categoryDataset.getRowCount();
        int n4 = 0;
        while (n4 < n3) {
            LegendItem legendItem;
            if (this.isSeriesVisibleInLegend(n4) && (legendItem = this.getLegendItem(n2, n4)) != null) {
                legendItemCollection.add(legendItem);
            }
            ++n4;
        }
        return legendItemCollection;
    }

    public CategorySeriesLabelGenerator getLegendItemLabelGenerator() {
        return this.legendItemLabelGenerator;
    }

    public void setLegendItemLabelGenerator(CategorySeriesLabelGenerator categorySeriesLabelGenerator) {
        if (categorySeriesLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.legendItemLabelGenerator = categorySeriesLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public CategorySeriesLabelGenerator getLegendItemToolTipGenerator() {
        return this.legendItemToolTipGenerator;
    }

    public void setLegendItemToolTipGenerator(CategorySeriesLabelGenerator categorySeriesLabelGenerator) {
        this.legendItemToolTipGenerator = categorySeriesLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public CategorySeriesLabelGenerator getLegendItemURLGenerator() {
        return this.legendItemURLGenerator;
    }

    public void setLegendItemURLGenerator(CategorySeriesLabelGenerator categorySeriesLabelGenerator) {
        this.legendItemURLGenerator = categorySeriesLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    protected void addItemEntity(EntityCollection entityCollection, CategoryDataset categoryDataset, int n2, int n3, Shape shape) {
        String string = null;
        CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (categoryToolTipGenerator != null) {
            string = categoryToolTipGenerator.generateToolTip(categoryDataset, n2, n3);
        }
        String string2 = null;
        CategoryURLGenerator categoryURLGenerator = this.getItemURLGenerator(n2, n3);
        if (categoryURLGenerator != null) {
            string2 = categoryURLGenerator.generateURL(categoryDataset, n2, n3);
        }
        CategoryItemEntity categoryItemEntity = new CategoryItemEntity(shape, string, string2, categoryDataset, n2, categoryDataset.getColumnKey(n3), n3);
        entityCollection.add(categoryItemEntity);
    }
}

