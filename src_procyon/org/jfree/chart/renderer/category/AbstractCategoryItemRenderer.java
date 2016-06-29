package org.jfree.chart.renderer.category;

import org.jfree.chart.renderer.*;
import java.io.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.event.*;
import org.jfree.data.category.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.axis.*;
import org.jfree.text.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.*;
import org.jfree.chart.entity.*;

public abstract class AbstractCategoryItemRenderer extends AbstractRenderer implements Serializable, Cloneable, CategoryItemRenderer, PublicCloneable
{
    private static final long serialVersionUID = 1247553218442497391L;
    private CategoryPlot plot;
    private CategoryItemLabelGenerator itemLabelGenerator;
    private ObjectList itemLabelGeneratorList;
    private CategoryItemLabelGenerator baseItemLabelGenerator;
    private CategoryToolTipGenerator toolTipGenerator;
    private ObjectList toolTipGeneratorList;
    private CategoryToolTipGenerator baseToolTipGenerator;
    private CategoryURLGenerator itemURLGenerator;
    private ObjectList itemURLGeneratorList;
    private CategoryURLGenerator baseItemURLGenerator;
    private CategorySeriesLabelGenerator legendItemLabelGenerator;
    private CategorySeriesLabelGenerator legendItemToolTipGenerator;
    private CategorySeriesLabelGenerator legendItemURLGenerator;
    private transient int rowCount;
    private transient int columnCount;
    
    protected AbstractCategoryItemRenderer() {
        this.itemLabelGenerator = null;
        this.itemLabelGeneratorList = new ObjectList();
        this.toolTipGenerator = null;
        this.toolTipGeneratorList = new ObjectList();
        this.itemURLGenerator = null;
        this.itemURLGeneratorList = new ObjectList();
        this.legendItemLabelGenerator = new StandardCategorySeriesLabelGenerator();
    }
    
    public int getPassCount() {
        return 1;
    }
    
    public CategoryPlot getPlot() {
        return this.plot;
    }
    
    public void setPlot(final CategoryPlot plot) {
        if (plot == null) {
            throw new IllegalArgumentException("Null 'plot' argument.");
        }
        this.plot = plot;
    }
    
    public CategoryItemLabelGenerator getItemLabelGenerator(final int n, final int n2) {
        return this.getSeriesItemLabelGenerator(n);
    }
    
    public CategoryItemLabelGenerator getSeriesItemLabelGenerator(final int n) {
        if (this.itemLabelGenerator != null) {
            return this.itemLabelGenerator;
        }
        CategoryItemLabelGenerator baseItemLabelGenerator = (CategoryItemLabelGenerator)this.itemLabelGeneratorList.get(n);
        if (baseItemLabelGenerator == null) {
            baseItemLabelGenerator = this.baseItemLabelGenerator;
        }
        return baseItemLabelGenerator;
    }
    
    public void setItemLabelGenerator(final CategoryItemLabelGenerator itemLabelGenerator) {
        this.itemLabelGenerator = itemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setSeriesItemLabelGenerator(final int n, final CategoryItemLabelGenerator categoryItemLabelGenerator) {
        this.itemLabelGeneratorList.set(n, categoryItemLabelGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategoryItemLabelGenerator getBaseItemLabelGenerator() {
        return this.baseItemLabelGenerator;
    }
    
    public void setBaseItemLabelGenerator(final CategoryItemLabelGenerator baseItemLabelGenerator) {
        this.baseItemLabelGenerator = baseItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategoryToolTipGenerator getToolTipGenerator(final int n, final int n2) {
        CategoryToolTipGenerator categoryToolTipGenerator;
        if (this.toolTipGenerator != null) {
            categoryToolTipGenerator = this.toolTipGenerator;
        }
        else {
            categoryToolTipGenerator = this.getSeriesToolTipGenerator(n);
            if (categoryToolTipGenerator == null) {
                categoryToolTipGenerator = this.baseToolTipGenerator;
            }
        }
        return categoryToolTipGenerator;
    }
    
    public CategoryToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }
    
    public void setToolTipGenerator(final CategoryToolTipGenerator toolTipGenerator) {
        this.toolTipGenerator = toolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategoryToolTipGenerator getSeriesToolTipGenerator(final int n) {
        return (CategoryToolTipGenerator)this.toolTipGeneratorList.get(n);
    }
    
    public void setSeriesToolTipGenerator(final int n, final CategoryToolTipGenerator categoryToolTipGenerator) {
        this.toolTipGeneratorList.set(n, categoryToolTipGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategoryToolTipGenerator getBaseToolTipGenerator() {
        return this.baseToolTipGenerator;
    }
    
    public void setBaseToolTipGenerator(final CategoryToolTipGenerator baseToolTipGenerator) {
        this.baseToolTipGenerator = baseToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategoryURLGenerator getItemURLGenerator(final int n, final int n2) {
        return this.getSeriesItemURLGenerator(n);
    }
    
    public CategoryURLGenerator getSeriesItemURLGenerator(final int n) {
        if (this.itemURLGenerator != null) {
            return this.itemURLGenerator;
        }
        CategoryURLGenerator baseItemURLGenerator = (CategoryURLGenerator)this.itemURLGeneratorList.get(n);
        if (baseItemURLGenerator == null) {
            baseItemURLGenerator = this.baseItemURLGenerator;
        }
        return baseItemURLGenerator;
    }
    
    public void setItemURLGenerator(final CategoryURLGenerator itemURLGenerator) {
        this.itemURLGenerator = itemURLGenerator;
    }
    
    public void setSeriesItemURLGenerator(final int n, final CategoryURLGenerator categoryURLGenerator) {
        this.itemURLGeneratorList.set(n, categoryURLGenerator);
    }
    
    public CategoryURLGenerator getBaseItemURLGenerator() {
        return this.baseItemURLGenerator;
    }
    
    public void setBaseItemURLGenerator(final CategoryURLGenerator baseItemURLGenerator) {
        this.baseItemURLGenerator = baseItemURLGenerator;
    }
    
    public int getRowCount() {
        return this.rowCount;
    }
    
    public int getColumnCount() {
        return this.columnCount;
    }
    
    protected CategoryItemRendererState createState(final PlotRenderingInfo plotRenderingInfo) {
        return new CategoryItemRendererState(plotRenderingInfo);
    }
    
    public CategoryItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final CategoryPlot plot, final int n, final PlotRenderingInfo plotRenderingInfo) {
        this.setPlot(plot);
        final CategoryDataset dataset = plot.getDataset(n);
        if (dataset != null) {
            this.rowCount = dataset.getRowCount();
            this.columnCount = dataset.getColumnCount();
        }
        else {
            this.rowCount = 0;
            this.columnCount = 0;
        }
        return this.createState(plotRenderingInfo);
    }
    
    public Range findRangeBounds(final CategoryDataset categoryDataset) {
        return DatasetUtilities.findRangeBounds(categoryDataset);
    }
    
    public void drawBackground(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D) {
        categoryPlot.drawBackground(graphics2D, rectangle2D);
    }
    
    public void drawOutline(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D) {
        categoryPlot.drawOutline(graphics2D, rectangle2D);
    }
    
    public void drawDomainGridline(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final double n) {
        Shape shape = null;
        final PlotOrientation orientation = categoryPlot.getOrientation();
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new Line2D.Double(rectangle2D.getMinX(), n, rectangle2D.getMaxX(), n);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new Line2D.Double(n, rectangle2D.getMinY(), n, rectangle2D.getMaxY());
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
        graphics2D.draw(shape);
    }
    
    public void drawRangeGridline(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n) {
        if (!valueAxis.getRange().contains(n)) {
            return;
        }
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, categoryPlot.getRangeAxisEdge());
        Shape shape = null;
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
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
        graphics2D.draw(shape);
    }
    
    public void drawDomainMarker(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final CategoryAxis categoryAxis, final CategoryMarker categoryMarker, final Rectangle2D rectangle2D) {
        final Comparable key = categoryMarker.getKey();
        final CategoryDataset dataset = categoryPlot.getDataset(categoryPlot.getIndexOf(this));
        final int columnIndex = dataset.getColumnIndex(key);
        if (columnIndex < 0) {
            return;
        }
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, categoryMarker.getAlpha()));
        final PlotOrientation orientation = categoryPlot.getOrientation();
        Rectangle2D bounds2D;
        if (categoryMarker.getDrawAsLine()) {
            final double categoryMiddle = categoryAxis.getCategoryMiddle(columnIndex, dataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            Shape shape = null;
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape = new Line2D.Double(rectangle2D.getMinX(), categoryMiddle, rectangle2D.getMaxX(), categoryMiddle);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape = new Line2D.Double(categoryMiddle, rectangle2D.getMinY(), categoryMiddle, rectangle2D.getMaxY());
            }
            graphics2D.setPaint(categoryMarker.getPaint());
            graphics2D.setStroke(categoryMarker.getStroke());
            graphics2D.draw(shape);
            bounds2D = shape.getBounds2D();
        }
        else {
            final double categoryStart = categoryAxis.getCategoryStart(columnIndex, dataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            final double categoryEnd = categoryAxis.getCategoryEnd(columnIndex, dataset.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge());
            Rectangle2D rectangle2D2 = null;
            if (orientation == PlotOrientation.HORIZONTAL) {
                rectangle2D2 = new Rectangle2D.Double(rectangle2D.getMinX(), categoryStart, rectangle2D.getWidth(), categoryEnd - categoryStart);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                rectangle2D2 = new Rectangle2D.Double(categoryStart, rectangle2D.getMinY(), categoryEnd - categoryStart, rectangle2D.getHeight());
            }
            graphics2D.setPaint(categoryMarker.getPaint());
            graphics2D.fill(rectangle2D2);
            bounds2D = rectangle2D2;
        }
        final String label = categoryMarker.getLabel();
        final RectangleAnchor labelAnchor = categoryMarker.getLabelAnchor();
        if (label != null) {
            graphics2D.setFont(categoryMarker.getLabelFont());
            graphics2D.setPaint(categoryMarker.getLabelPaint());
            final Point2D calculateDomainMarkerTextAnchorPoint = this.calculateDomainMarkerTextAnchorPoint(graphics2D, orientation, rectangle2D, bounds2D, categoryMarker.getLabelOffset(), categoryMarker.getLabelOffsetType(), labelAnchor);
            TextUtilities.drawAlignedString(label, graphics2D, (float)calculateDomainMarkerTextAnchorPoint.getX(), (float)calculateDomainMarkerTextAnchorPoint.getY(), categoryMarker.getLabelTextAnchor());
        }
        graphics2D.setComposite(composite);
    }
    
    public void drawRangeMarker(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final ValueAxis valueAxis, final Marker marker, final Rectangle2D rectangle2D) {
        if (marker instanceof ValueMarker) {
            final double value = ((ValueMarker)marker).getValue();
            if (!valueAxis.getRange().contains(value)) {
                return;
            }
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
            final PlotOrientation orientation = categoryPlot.getOrientation();
            final double valueToJava2D = valueAxis.valueToJava2D(value, rectangle2D, categoryPlot.getRangeAxisEdge());
            Shape shape = null;
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
            }
            graphics2D.setPaint(marker.getPaint());
            graphics2D.setStroke(marker.getStroke());
            graphics2D.draw(shape);
            final String label = marker.getLabel();
            final RectangleAnchor labelAnchor = marker.getLabelAnchor();
            if (label != null) {
                graphics2D.setFont(marker.getLabelFont());
                graphics2D.setPaint(marker.getLabelPaint());
                final Point2D calculateRangeMarkerTextAnchorPoint = this.calculateRangeMarkerTextAnchorPoint(graphics2D, orientation, rectangle2D, shape.getBounds2D(), marker.getLabelOffset(), LengthAdjustmentType.EXPAND, labelAnchor);
                TextUtilities.drawAlignedString(label, graphics2D, (float)calculateRangeMarkerTextAnchorPoint.getX(), (float)calculateRangeMarkerTextAnchorPoint.getY(), marker.getLabelTextAnchor());
            }
            graphics2D.setComposite(composite);
        }
        else if (marker instanceof IntervalMarker) {
            final IntervalMarker intervalMarker = (IntervalMarker)marker;
            final double startValue = intervalMarker.getStartValue();
            final double endValue = intervalMarker.getEndValue();
            final Range range = valueAxis.getRange();
            if (!range.intersects(startValue, endValue)) {
                return;
            }
            final Composite composite2 = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
            final double valueToJava2D2 = valueAxis.valueToJava2D(startValue, rectangle2D, categoryPlot.getRangeAxisEdge());
            final double valueToJava2D3 = valueAxis.valueToJava2D(endValue, rectangle2D, categoryPlot.getRangeAxisEdge());
            final double min = Math.min(valueToJava2D2, valueToJava2D3);
            final double max = Math.max(valueToJava2D2, valueToJava2D3);
            final PlotOrientation orientation2 = categoryPlot.getOrientation();
            Rectangle2D rectangle2D2 = null;
            if (orientation2 == PlotOrientation.HORIZONTAL) {
                final double max2 = Math.max(min, rectangle2D.getMinX());
                rectangle2D2 = new Rectangle2D.Double(max2, rectangle2D.getMinY(), Math.min(max, rectangle2D.getMaxX()) - max2, rectangle2D.getHeight());
            }
            else if (orientation2 == PlotOrientation.VERTICAL) {
                final double max3 = Math.max(min, rectangle2D.getMinY());
                rectangle2D2 = new Rectangle2D.Double(rectangle2D.getMinX(), max3, rectangle2D.getWidth(), Math.min(max, rectangle2D.getMaxY()) - max3);
            }
            final Paint paint = marker.getPaint();
            if (paint instanceof GradientPaint) {
                GradientPaint transform = (GradientPaint)paint;
                final GradientPaintTransformer gradientPaintTransformer = intervalMarker.getGradientPaintTransformer();
                if (gradientPaintTransformer != null) {
                    transform = gradientPaintTransformer.transform(transform, rectangle2D2);
                }
                graphics2D.setPaint(transform);
            }
            else {
                graphics2D.setPaint(paint);
            }
            graphics2D.fill(rectangle2D2);
            if (intervalMarker.getOutlinePaint() != null && intervalMarker.getOutlineStroke() != null) {
                if (orientation2 == PlotOrientation.VERTICAL) {
                    final Line2D.Double double1 = new Line2D.Double();
                    final double minX = rectangle2D.getMinX();
                    final double maxX = rectangle2D.getMaxX();
                    graphics2D.setPaint(intervalMarker.getOutlinePaint());
                    graphics2D.setStroke(intervalMarker.getOutlineStroke());
                    if (range.contains(startValue)) {
                        double1.setLine(minX, valueToJava2D2, maxX, valueToJava2D2);
                        graphics2D.draw(double1);
                    }
                    if (range.contains(endValue)) {
                        double1.setLine(minX, valueToJava2D3, maxX, valueToJava2D3);
                        graphics2D.draw(double1);
                    }
                }
                else {
                    final Line2D.Double double2 = new Line2D.Double();
                    final double minY = rectangle2D.getMinY();
                    final double maxY = rectangle2D.getMaxY();
                    graphics2D.setPaint(intervalMarker.getOutlinePaint());
                    graphics2D.setStroke(intervalMarker.getOutlineStroke());
                    if (range.contains(startValue)) {
                        double2.setLine(valueToJava2D2, minY, valueToJava2D2, maxY);
                        graphics2D.draw(double2);
                    }
                    if (range.contains(endValue)) {
                        double2.setLine(valueToJava2D3, minY, valueToJava2D3, maxY);
                        graphics2D.draw(double2);
                    }
                }
            }
            final String label2 = marker.getLabel();
            final RectangleAnchor labelAnchor2 = marker.getLabelAnchor();
            if (label2 != null) {
                graphics2D.setFont(marker.getLabelFont());
                graphics2D.setPaint(marker.getLabelPaint());
                final Point2D calculateRangeMarkerTextAnchorPoint2 = this.calculateRangeMarkerTextAnchorPoint(graphics2D, orientation2, rectangle2D, rectangle2D2, marker.getLabelOffset(), marker.getLabelOffsetType(), labelAnchor2);
                TextUtilities.drawAlignedString(label2, graphics2D, (float)calculateRangeMarkerTextAnchorPoint2.getX(), (float)calculateRangeMarkerTextAnchorPoint2.getY(), marker.getLabelTextAnchor());
            }
            graphics2D.setComposite(composite2);
        }
    }
    
    protected Point2D calculateDomainMarkerTextAnchorPoint(final Graphics2D graphics2D, final PlotOrientation plotOrientation, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleInsets rectangleInsets, final LengthAdjustmentType lengthAdjustmentType, final RectangleAnchor rectangleAnchor) {
        Rectangle2D rectangle2D3 = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, LengthAdjustmentType.CONTRACT, lengthAdjustmentType);
        }
        else if (plotOrientation == PlotOrientation.VERTICAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, lengthAdjustmentType, LengthAdjustmentType.CONTRACT);
        }
        return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
    }
    
    protected Point2D calculateRangeMarkerTextAnchorPoint(final Graphics2D graphics2D, final PlotOrientation plotOrientation, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleInsets rectangleInsets, final LengthAdjustmentType lengthAdjustmentType, final RectangleAnchor rectangleAnchor) {
        Rectangle2D rectangle2D3 = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, lengthAdjustmentType, LengthAdjustmentType.CONTRACT);
        }
        else if (plotOrientation == PlotOrientation.VERTICAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, LengthAdjustmentType.CONTRACT, lengthAdjustmentType);
        }
        return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
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
        final String generateLabel = this.legendItemLabelGenerator.generateLabel(dataset, seriesIndex);
        String generateLabel2 = null;
        if (this.legendItemToolTipGenerator != null) {
            generateLabel2 = this.legendItemToolTipGenerator.generateLabel(dataset, seriesIndex);
        }
        String generateLabel3 = null;
        if (this.legendItemURLGenerator != null) {
            generateLabel3 = this.legendItemURLGenerator.generateLabel(dataset, seriesIndex);
        }
        final LegendItem legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, this.getSeriesShape(seriesIndex), this.getSeriesPaint(seriesIndex), this.getSeriesOutlineStroke(seriesIndex), this.getSeriesOutlinePaint(seriesIndex));
        legendItem.setSeriesIndex(seriesIndex);
        legendItem.setDatasetIndex(datasetIndex);
        return legendItem;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractCategoryItemRenderer)) {
            return false;
        }
        final AbstractCategoryItemRenderer abstractCategoryItemRenderer = (AbstractCategoryItemRenderer)o;
        return ObjectUtilities.equal(this.itemLabelGenerator, abstractCategoryItemRenderer.itemLabelGenerator) && ObjectUtilities.equal(this.itemLabelGeneratorList, abstractCategoryItemRenderer.itemLabelGeneratorList) && ObjectUtilities.equal(this.baseItemLabelGenerator, abstractCategoryItemRenderer.baseItemLabelGenerator) && ObjectUtilities.equal(this.toolTipGenerator, abstractCategoryItemRenderer.toolTipGenerator) && ObjectUtilities.equal(this.toolTipGeneratorList, abstractCategoryItemRenderer.toolTipGeneratorList) && ObjectUtilities.equal(this.baseToolTipGenerator, abstractCategoryItemRenderer.baseToolTipGenerator) && ObjectUtilities.equal(this.itemURLGenerator, abstractCategoryItemRenderer.itemURLGenerator) && ObjectUtilities.equal(this.itemURLGeneratorList, abstractCategoryItemRenderer.itemURLGeneratorList) && ObjectUtilities.equal(this.baseItemURLGenerator, abstractCategoryItemRenderer.baseItemURLGenerator) && ObjectUtilities.equal(this.legendItemLabelGenerator, abstractCategoryItemRenderer.legendItemLabelGenerator) && ObjectUtilities.equal(this.legendItemToolTipGenerator, abstractCategoryItemRenderer.legendItemToolTipGenerator) && ObjectUtilities.equal(this.legendItemURLGenerator, abstractCategoryItemRenderer.legendItemURLGenerator) && super.equals(o);
    }
    
    public int hashCode() {
        return super.hashCode();
    }
    
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        final CategoryPlot plot = this.getPlot();
        if (plot != null) {
            drawingSupplier = plot.getDrawingSupplier();
        }
        return drawingSupplier;
    }
    
    protected void drawItemLabel(final Graphics2D graphics2D, final PlotOrientation plotOrientation, final CategoryDataset categoryDataset, final int n, final int n2, final double n3, final double n4, final boolean b) {
        final CategoryItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null) {
            final Font itemLabelFont = this.getItemLabelFont(n, n2);
            final Paint itemLabelPaint = this.getItemLabelPaint(n, n2);
            graphics2D.setFont(itemLabelFont);
            graphics2D.setPaint(itemLabelPaint);
            final String generateLabel = itemLabelGenerator.generateLabel(categoryDataset, n, n2);
            ItemLabelPosition itemLabelPosition;
            if (!b) {
                itemLabelPosition = this.getPositiveItemLabelPosition(n, n2);
            }
            else {
                itemLabelPosition = this.getNegativeItemLabelPosition(n, n2);
            }
            final Point2D calculateLabelAnchorPoint = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), n3, n4, plotOrientation);
            TextUtilities.drawRotatedString(generateLabel, graphics2D, (float)calculateLabelAnchorPoint.getX(), (float)calculateLabelAnchorPoint.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
        }
    }
    
    public Object clone() {
        final AbstractCategoryItemRenderer abstractCategoryItemRenderer = (AbstractCategoryItemRenderer)super.clone();
        if (this.itemLabelGenerator != null) {
            if (!(this.itemLabelGenerator instanceof PublicCloneable)) {
                throw new CloneNotSupportedException("ItemLabelGenerator not cloneable.");
            }
            abstractCategoryItemRenderer.itemLabelGenerator = (CategoryItemLabelGenerator)((PublicCloneable)this.itemLabelGenerator).clone();
        }
        if (this.itemLabelGeneratorList != null) {
            abstractCategoryItemRenderer.itemLabelGeneratorList = (ObjectList)this.itemLabelGeneratorList.clone();
        }
        if (this.baseItemLabelGenerator != null) {
            if (!(this.baseItemLabelGenerator instanceof PublicCloneable)) {
                throw new CloneNotSupportedException("ItemLabelGenerator not cloneable.");
            }
            abstractCategoryItemRenderer.baseItemLabelGenerator = (CategoryItemLabelGenerator)((PublicCloneable)this.baseItemLabelGenerator).clone();
        }
        if (this.toolTipGenerator != null) {
            if (!(this.toolTipGenerator instanceof PublicCloneable)) {
                throw new CloneNotSupportedException("Tool tip generator not cloneable.");
            }
            abstractCategoryItemRenderer.toolTipGenerator = (CategoryToolTipGenerator)((PublicCloneable)this.toolTipGenerator).clone();
        }
        if (this.toolTipGeneratorList != null) {
            abstractCategoryItemRenderer.toolTipGeneratorList = (ObjectList)this.toolTipGeneratorList.clone();
        }
        if (this.baseToolTipGenerator != null) {
            if (!(this.baseToolTipGenerator instanceof PublicCloneable)) {
                throw new CloneNotSupportedException("Base tool tip generator not cloneable.");
            }
            abstractCategoryItemRenderer.baseToolTipGenerator = (CategoryToolTipGenerator)((PublicCloneable)this.baseToolTipGenerator).clone();
        }
        if (this.itemURLGenerator != null) {
            if (!(this.itemURLGenerator instanceof PublicCloneable)) {
                throw new CloneNotSupportedException("Item URL generator not cloneable.");
            }
            abstractCategoryItemRenderer.itemURLGenerator = (CategoryURLGenerator)((PublicCloneable)this.itemURLGenerator).clone();
        }
        if (this.itemURLGeneratorList != null) {
            abstractCategoryItemRenderer.itemURLGeneratorList = (ObjectList)this.itemURLGeneratorList.clone();
        }
        if (this.baseItemURLGenerator != null) {
            if (!(this.baseItemURLGenerator instanceof PublicCloneable)) {
                throw new CloneNotSupportedException("Base item URL generator not cloneable.");
            }
            abstractCategoryItemRenderer.baseItemURLGenerator = (CategoryURLGenerator)((PublicCloneable)this.baseItemURLGenerator).clone();
        }
        if (this.legendItemLabelGenerator instanceof PublicCloneable) {
            abstractCategoryItemRenderer.legendItemLabelGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
        }
        if (this.legendItemToolTipGenerator instanceof PublicCloneable) {
            abstractCategoryItemRenderer.legendItemToolTipGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
        }
        if (this.legendItemURLGenerator instanceof PublicCloneable) {
            abstractCategoryItemRenderer.legendItemURLGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
        }
        return abstractCategoryItemRenderer;
    }
    
    protected CategoryAxis getDomainAxis(final CategoryPlot categoryPlot, final int n) {
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis(n);
        if (categoryAxis == null) {
            categoryAxis = categoryPlot.getDomainAxis();
        }
        return categoryAxis;
    }
    
    protected ValueAxis getRangeAxis(final CategoryPlot categoryPlot, final int n) {
        ValueAxis valueAxis = categoryPlot.getRangeAxis(n);
        if (valueAxis == null) {
            valueAxis = categoryPlot.getRangeAxis();
        }
        return valueAxis;
    }
    
    public LegendItemCollection getLegendItems() {
        if (this.plot == null) {
            return new LegendItemCollection();
        }
        final LegendItemCollection collection = new LegendItemCollection();
        final int index = this.plot.getIndexOf(this);
        final CategoryDataset dataset = this.plot.getDataset(index);
        if (dataset != null) {
            for (int rowCount = dataset.getRowCount(), i = 0; i < rowCount; ++i) {
                if (this.isSeriesVisibleInLegend(i)) {
                    final LegendItem legendItem = this.getLegendItem(index, i);
                    if (legendItem != null) {
                        collection.add(legendItem);
                    }
                }
            }
        }
        return collection;
    }
    
    public CategorySeriesLabelGenerator getLegendItemLabelGenerator() {
        return this.legendItemLabelGenerator;
    }
    
    public void setLegendItemLabelGenerator(final CategorySeriesLabelGenerator legendItemLabelGenerator) {
        if (legendItemLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.legendItemLabelGenerator = legendItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategorySeriesLabelGenerator getLegendItemToolTipGenerator() {
        return this.legendItemToolTipGenerator;
    }
    
    public void setLegendItemToolTipGenerator(final CategorySeriesLabelGenerator legendItemToolTipGenerator) {
        this.legendItemToolTipGenerator = legendItemToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public CategorySeriesLabelGenerator getLegendItemURLGenerator() {
        return this.legendItemURLGenerator;
    }
    
    public void setLegendItemURLGenerator(final CategorySeriesLabelGenerator legendItemURLGenerator) {
        this.legendItemURLGenerator = legendItemURLGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    protected void addItemEntity(final EntityCollection collection, final CategoryDataset categoryDataset, final int n, final int n2, final Shape shape) {
        String generateToolTip = null;
        final CategoryToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
        if (toolTipGenerator != null) {
            generateToolTip = toolTipGenerator.generateToolTip(categoryDataset, n, n2);
        }
        String generateURL = null;
        final CategoryURLGenerator itemURLGenerator = this.getItemURLGenerator(n, n2);
        if (itemURLGenerator != null) {
            generateURL = itemURLGenerator.generateURL(categoryDataset, n, n2);
        }
        collection.add(new CategoryItemEntity(shape, generateToolTip, generateURL, categoryDataset, n, categoryDataset.getColumnKey(n2), n2));
    }
}
