package org.jfree.chart.renderer.xy;

import org.jfree.chart.renderer.*;
import java.io.*;
import org.jfree.chart.urls.*;
import org.jfree.data.xy.*;
import org.jfree.chart.event.*;
import org.jfree.chart.annotations.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import java.util.*;
import java.awt.geom.*;
import org.jfree.chart.entity.*;

public abstract class AbstractXYItemRenderer extends AbstractRenderer implements Serializable, Cloneable, XYItemRenderer
{
    private static final long serialVersionUID = 8019124836026607990L;
    private XYPlot plot;
    private XYItemLabelGenerator itemLabelGenerator;
    private ObjectList itemLabelGeneratorList;
    private XYItemLabelGenerator baseItemLabelGenerator;
    private XYToolTipGenerator toolTipGenerator;
    private ObjectList toolTipGeneratorList;
    private XYToolTipGenerator baseToolTipGenerator;
    private XYURLGenerator urlGenerator;
    private List backgroundAnnotations;
    private List foregroundAnnotations;
    private int defaultEntityRadius;
    private XYSeriesLabelGenerator legendItemLabelGenerator;
    private XYSeriesLabelGenerator legendItemToolTipGenerator;
    private XYSeriesLabelGenerator legendItemURLGenerator;
    
    protected AbstractXYItemRenderer() {
        this.itemLabelGenerator = null;
        this.itemLabelGeneratorList = new ObjectList();
        this.toolTipGenerator = null;
        this.toolTipGeneratorList = new ObjectList();
        this.urlGenerator = null;
        this.backgroundAnnotations = new ArrayList();
        this.foregroundAnnotations = new ArrayList();
        this.defaultEntityRadius = 3;
        this.legendItemLabelGenerator = new StandardXYSeriesLabelGenerator("{0}");
    }
    
    public int getPassCount() {
        return 1;
    }
    
    public XYPlot getPlot() {
        return this.plot;
    }
    
    public void setPlot(final XYPlot plot) {
        this.plot = plot;
    }
    
    public XYItemRendererState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final XYPlot xyPlot, final XYDataset xyDataset, final PlotRenderingInfo plotRenderingInfo) {
        return new XYItemRendererState(plotRenderingInfo);
    }
    
    public XYItemLabelGenerator getItemLabelGenerator(final int n, final int n2) {
        if (this.itemLabelGenerator != null) {
            return this.itemLabelGenerator;
        }
        XYItemLabelGenerator baseItemLabelGenerator = (XYItemLabelGenerator)this.itemLabelGeneratorList.get(n);
        if (baseItemLabelGenerator == null) {
            baseItemLabelGenerator = this.baseItemLabelGenerator;
        }
        return baseItemLabelGenerator;
    }
    
    public XYItemLabelGenerator getSeriesItemLabelGenerator(final int n) {
        return (XYItemLabelGenerator)this.itemLabelGeneratorList.get(n);
    }
    
    public XYItemLabelGenerator getItemLabelGenerator() {
        return this.itemLabelGenerator;
    }
    
    public void setItemLabelGenerator(final XYItemLabelGenerator itemLabelGenerator) {
        this.itemLabelGenerator = itemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void setSeriesItemLabelGenerator(final int n, final XYItemLabelGenerator xyItemLabelGenerator) {
        this.itemLabelGeneratorList.set(n, xyItemLabelGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYItemLabelGenerator getBaseItemLabelGenerator() {
        return this.baseItemLabelGenerator;
    }
    
    public void setBaseItemLabelGenerator(final XYItemLabelGenerator baseItemLabelGenerator) {
        this.baseItemLabelGenerator = baseItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYToolTipGenerator getToolTipGenerator(final int n, final int n2) {
        if (this.toolTipGenerator != null) {
            return this.toolTipGenerator;
        }
        XYToolTipGenerator baseToolTipGenerator = (XYToolTipGenerator)this.toolTipGeneratorList.get(n);
        if (baseToolTipGenerator == null) {
            baseToolTipGenerator = this.baseToolTipGenerator;
        }
        return baseToolTipGenerator;
    }
    
    public XYToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }
    
    public void setToolTipGenerator(final XYToolTipGenerator toolTipGenerator) {
        this.toolTipGenerator = toolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYToolTipGenerator getSeriesToolTipGenerator(final int n) {
        return (XYToolTipGenerator)this.toolTipGeneratorList.get(n);
    }
    
    public void setSeriesToolTipGenerator(final int n, final XYToolTipGenerator xyToolTipGenerator) {
        this.toolTipGeneratorList.set(n, xyToolTipGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYToolTipGenerator getBaseToolTipGenerator() {
        return this.baseToolTipGenerator;
    }
    
    public void setBaseToolTipGenerator(final XYToolTipGenerator baseToolTipGenerator) {
        this.baseToolTipGenerator = baseToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }
    
    public void setURLGenerator(final XYURLGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public void addAnnotation(final XYAnnotation xyAnnotation) {
        this.addAnnotation(xyAnnotation, Layer.FOREGROUND);
    }
    
    public void addAnnotation(final XYAnnotation xyAnnotation, final Layer layer) {
        if (xyAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        if (layer.equals(Layer.FOREGROUND)) {
            this.foregroundAnnotations.add(xyAnnotation);
            this.notifyListeners(new RendererChangeEvent(this));
        }
        else {
            if (!layer.equals(Layer.BACKGROUND)) {
                throw new RuntimeException("Unknown layer.");
            }
            this.backgroundAnnotations.add(xyAnnotation);
            this.notifyListeners(new RendererChangeEvent(this));
        }
    }
    
    public boolean removeAnnotation(final XYAnnotation xyAnnotation) {
        final boolean b = this.foregroundAnnotations.remove(xyAnnotation) & this.backgroundAnnotations.remove(xyAnnotation);
        this.notifyListeners(new RendererChangeEvent(this));
        return b;
    }
    
    public void removeAnnotations() {
        this.foregroundAnnotations.clear();
        this.backgroundAnnotations.clear();
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public int getDefaultEntityRadius() {
        return this.defaultEntityRadius;
    }
    
    public void setDefaultEntityRadius(final int defaultEntityRadius) {
        this.defaultEntityRadius = defaultEntityRadius;
    }
    
    public XYSeriesLabelGenerator getLegendItemLabelGenerator() {
        return this.legendItemLabelGenerator;
    }
    
    public void setLegendItemLabelGenerator(final XYSeriesLabelGenerator legendItemLabelGenerator) {
        if (legendItemLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.legendItemLabelGenerator = legendItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYSeriesLabelGenerator getLegendItemToolTipGenerator() {
        return this.legendItemToolTipGenerator;
    }
    
    public void setLegendItemToolTipGenerator(final XYSeriesLabelGenerator legendItemToolTipGenerator) {
        this.legendItemToolTipGenerator = legendItemToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public XYSeriesLabelGenerator getLegendItemURLGenerator() {
        return this.legendItemURLGenerator;
    }
    
    public void setLegendItemURLGenerator(final XYSeriesLabelGenerator legendItemURLGenerator) {
        this.legendItemURLGenerator = legendItemURLGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }
    
    public Range findDomainBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            return DatasetUtilities.findDomainBounds(xyDataset, false);
        }
        return null;
    }
    
    public Range findRangeBounds(final XYDataset xyDataset) {
        if (xyDataset != null) {
            return DatasetUtilities.findRangeBounds(xyDataset, false);
        }
        return null;
    }
    
    public LegendItemCollection getLegendItems() {
        if (this.plot == null) {
            return new LegendItemCollection();
        }
        final LegendItemCollection collection = new LegendItemCollection();
        final int index = this.plot.getIndexOf(this);
        final XYDataset dataset = this.plot.getDataset(index);
        if (dataset != null) {
            for (int seriesCount = dataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
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
    
    public LegendItem getLegendItem(final int datasetIndex, final int seriesIndex) {
        LegendItem legendItem = null;
        final XYPlot plot = this.getPlot();
        if (plot != null) {
            final XYDataset dataset = plot.getDataset(datasetIndex);
            if (dataset != null) {
                final String generateLabel = this.legendItemLabelGenerator.generateLabel(dataset, seriesIndex);
                String generateLabel2 = null;
                if (this.getLegendItemToolTipGenerator() != null) {
                    generateLabel2 = this.getLegendItemToolTipGenerator().generateLabel(dataset, seriesIndex);
                }
                String generateLabel3 = null;
                if (this.getLegendItemURLGenerator() != null) {
                    generateLabel3 = this.getLegendItemURLGenerator().generateLabel(dataset, seriesIndex);
                }
                legendItem = new LegendItem(generateLabel, generateLabel, generateLabel2, generateLabel3, this.getSeriesShape(seriesIndex), this.getSeriesPaint(seriesIndex), this.getSeriesOutlineStroke(seriesIndex), this.getSeriesOutlinePaint(seriesIndex));
                legendItem.setSeriesIndex(seriesIndex);
                legendItem.setDatasetIndex(datasetIndex);
            }
        }
        return legendItem;
    }
    
    public void fillDomainGridBand(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n, final double n2) {
        final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, xyPlot.getDomainAxisEdge());
        final Rectangle2D.Double double1 = new Rectangle2D.Double(valueToJava2D, rectangle2D.getMinY(), valueAxis.valueToJava2D(n2, rectangle2D, xyPlot.getDomainAxisEdge()) - valueToJava2D, rectangle2D.getMaxY() - rectangle2D.getMinY());
        final Paint domainTickBandPaint = xyPlot.getDomainTickBandPaint();
        if (domainTickBandPaint != null) {
            graphics2D.setPaint(domainTickBandPaint);
            graphics2D.fill(double1);
        }
    }
    
    public void fillRangeGridBand(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n, final double n2) {
        final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, xyPlot.getRangeAxisEdge());
        final double valueToJava2D2 = valueAxis.valueToJava2D(n2, rectangle2D, xyPlot.getRangeAxisEdge());
        final Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2D.getMinX(), valueToJava2D2, rectangle2D.getWidth(), valueToJava2D - valueToJava2D2);
        final Paint rangeTickBandPaint = xyPlot.getRangeTickBandPaint();
        if (rangeTickBandPaint != null) {
            graphics2D.setPaint(rangeTickBandPaint);
            graphics2D.fill(double1);
        }
    }
    
    public void drawDomainGridLine(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n) {
        if (!valueAxis.getRange().contains(n)) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, xyPlot.getDomainAxisEdge());
        Shape shape = null;
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
        }
        final Paint domainGridlinePaint = xyPlot.getDomainGridlinePaint();
        final Stroke domainGridlineStroke = xyPlot.getDomainGridlineStroke();
        graphics2D.setPaint((domainGridlinePaint != null) ? domainGridlinePaint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke((domainGridlineStroke != null) ? domainGridlineStroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(shape);
    }
    
    public void drawDomainLine(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n, final Paint paint, final Stroke stroke) {
        if (!valueAxis.getRange().contains(n)) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        Shape shape = null;
        final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, xyPlot.getDomainAxisEdge());
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
        }
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        graphics2D.draw(shape);
    }
    
    public void drawRangeLine(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Rectangle2D rectangle2D, final double n, final Paint paint, final Stroke stroke) {
        if (!valueAxis.getRange().contains(n)) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        Shape shape = null;
        final double valueToJava2D = valueAxis.valueToJava2D(n, rectangle2D, xyPlot.getRangeAxisEdge());
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
        }
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        graphics2D.draw(shape);
    }
    
    public void drawDomainMarker(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Marker marker, final Rectangle2D rectangle2D) {
        if (marker instanceof ValueMarker) {
            final double value = ((ValueMarker)marker).getValue();
            if (!valueAxis.getRange().contains(value)) {
                return;
            }
            final double valueToJava2D = valueAxis.valueToJava2D(value, rectangle2D, xyPlot.getDomainAxisEdge());
            final PlotOrientation orientation = xyPlot.getOrientation();
            Shape shape = null;
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            }
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
            graphics2D.setPaint(marker.getPaint());
            graphics2D.setStroke(marker.getStroke());
            graphics2D.draw(shape);
            final String label = marker.getLabel();
            final RectangleAnchor labelAnchor = marker.getLabelAnchor();
            if (label != null) {
                graphics2D.setFont(marker.getLabelFont());
                graphics2D.setPaint(marker.getLabelPaint());
                final Point2D calculateDomainMarkerTextAnchorPoint = this.calculateDomainMarkerTextAnchorPoint(graphics2D, orientation, rectangle2D, shape.getBounds2D(), marker.getLabelOffset(), LengthAdjustmentType.EXPAND, labelAnchor);
                TextUtilities.drawAlignedString(label, graphics2D, (float)calculateDomainMarkerTextAnchorPoint.getX(), (float)calculateDomainMarkerTextAnchorPoint.getY(), marker.getLabelTextAnchor());
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
            final double valueToJava2D2 = valueAxis.valueToJava2D(startValue, rectangle2D, xyPlot.getDomainAxisEdge());
            final double valueToJava2D3 = valueAxis.valueToJava2D(endValue, rectangle2D, xyPlot.getDomainAxisEdge());
            final double min = Math.min(valueToJava2D2, valueToJava2D3);
            final double max = Math.max(valueToJava2D2, valueToJava2D3);
            final PlotOrientation orientation2 = xyPlot.getOrientation();
            Rectangle2D rectangle2D2 = null;
            if (orientation2 == PlotOrientation.HORIZONTAL) {
                final double max2 = Math.max(min, rectangle2D.getMinY());
                rectangle2D2 = new Rectangle2D.Double(rectangle2D.getMinX(), max2, rectangle2D.getWidth(), Math.min(max, rectangle2D.getMaxY()) - max2);
            }
            else if (orientation2 == PlotOrientation.VERTICAL) {
                final double max3 = Math.max(min, rectangle2D.getMinX());
                rectangle2D2 = new Rectangle2D.Double(max3, rectangle2D.getMinY(), Math.min(max, rectangle2D.getMaxX()) - max3, rectangle2D.getHeight());
            }
            final Composite composite2 = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
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
                    final double minY = rectangle2D.getMinY();
                    final double maxY = rectangle2D.getMaxY();
                    graphics2D.setPaint(intervalMarker.getOutlinePaint());
                    graphics2D.setStroke(intervalMarker.getOutlineStroke());
                    if (range.contains(startValue)) {
                        double1.setLine(valueToJava2D2, minY, valueToJava2D2, maxY);
                        graphics2D.draw(double1);
                    }
                    if (range.contains(endValue)) {
                        double1.setLine(valueToJava2D3, minY, valueToJava2D3, maxY);
                        graphics2D.draw(double1);
                    }
                }
                else {
                    final Line2D.Double double2 = new Line2D.Double();
                    final double minX = rectangle2D.getMinX();
                    final double maxX = rectangle2D.getMaxX();
                    graphics2D.setPaint(intervalMarker.getOutlinePaint());
                    graphics2D.setStroke(intervalMarker.getOutlineStroke());
                    if (range.contains(startValue)) {
                        double2.setLine(minX, valueToJava2D2, maxX, valueToJava2D2);
                        graphics2D.draw(double2);
                    }
                    if (range.contains(endValue)) {
                        double2.setLine(minX, valueToJava2D3, maxX, valueToJava2D3);
                        graphics2D.draw(double2);
                    }
                }
            }
            final String label2 = marker.getLabel();
            final RectangleAnchor labelAnchor2 = marker.getLabelAnchor();
            if (label2 != null) {
                graphics2D.setFont(marker.getLabelFont());
                graphics2D.setPaint(marker.getLabelPaint());
                final Point2D calculateDomainMarkerTextAnchorPoint2 = this.calculateDomainMarkerTextAnchorPoint(graphics2D, orientation2, rectangle2D, rectangle2D2, marker.getLabelOffset(), marker.getLabelOffsetType(), labelAnchor2);
                TextUtilities.drawAlignedString(label2, graphics2D, (float)calculateDomainMarkerTextAnchorPoint2.getX(), (float)calculateDomainMarkerTextAnchorPoint2.getY(), marker.getLabelTextAnchor());
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
    
    public void drawRangeMarker(final Graphics2D graphics2D, final XYPlot xyPlot, final ValueAxis valueAxis, final Marker marker, final Rectangle2D rectangle2D) {
        if (marker instanceof ValueMarker) {
            final double value = ((ValueMarker)marker).getValue();
            if (!valueAxis.getRange().contains(value)) {
                return;
            }
            final double valueToJava2D = valueAxis.valueToJava2D(value, rectangle2D, xyPlot.getRangeAxisEdge());
            final PlotOrientation orientation = xyPlot.getOrientation();
            Shape shape = null;
            if (orientation == PlotOrientation.HORIZONTAL) {
                shape = new Line2D.Double(valueToJava2D, rectangle2D.getMinY(), valueToJava2D, rectangle2D.getMaxY());
            }
            else if (orientation == PlotOrientation.VERTICAL) {
                shape = new Line2D.Double(rectangle2D.getMinX(), valueToJava2D, rectangle2D.getMaxX(), valueToJava2D);
            }
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
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
            final double valueToJava2D2 = valueAxis.valueToJava2D(startValue, rectangle2D, xyPlot.getRangeAxisEdge());
            final double valueToJava2D3 = valueAxis.valueToJava2D(endValue, rectangle2D, xyPlot.getRangeAxisEdge());
            final double min = Math.min(valueToJava2D2, valueToJava2D3);
            final double max = Math.max(valueToJava2D2, valueToJava2D3);
            final PlotOrientation orientation2 = xyPlot.getOrientation();
            Rectangle2D rectangle2D2 = null;
            if (orientation2 == PlotOrientation.HORIZONTAL) {
                final double max2 = Math.max(min, rectangle2D.getMinX());
                rectangle2D2 = new Rectangle2D.Double(max2, rectangle2D.getMinY(), Math.min(max, rectangle2D.getMaxX()) - max2, rectangle2D.getHeight());
            }
            else if (orientation2 == PlotOrientation.VERTICAL) {
                final double max3 = Math.max(min, rectangle2D.getMinY());
                rectangle2D2 = new Rectangle2D.Double(rectangle2D.getMinX(), max3, rectangle2D.getWidth(), Math.min(max, rectangle2D.getMaxY()) - max3);
            }
            final Composite composite2 = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
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
    
    private Point2D calculateRangeMarkerTextAnchorPoint(final Graphics2D graphics2D, final PlotOrientation plotOrientation, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleInsets rectangleInsets, final LengthAdjustmentType lengthAdjustmentType, final RectangleAnchor rectangleAnchor) {
        Rectangle2D rectangle2D3 = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, lengthAdjustmentType, LengthAdjustmentType.CONTRACT);
        }
        else if (plotOrientation == PlotOrientation.VERTICAL) {
            rectangle2D3 = rectangleInsets.createAdjustedRectangle(rectangle2D2, LengthAdjustmentType.CONTRACT, lengthAdjustmentType);
        }
        return RectangleAnchor.coordinates(rectangle2D3, rectangleAnchor);
    }
    
    protected Object clone() {
        final AbstractXYItemRenderer abstractXYItemRenderer = (AbstractXYItemRenderer)super.clone();
        if (this.itemLabelGenerator != null && this.itemLabelGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.itemLabelGenerator = (XYItemLabelGenerator)((PublicCloneable)this.itemLabelGenerator).clone();
        }
        abstractXYItemRenderer.itemLabelGeneratorList = (ObjectList)this.itemLabelGeneratorList.clone();
        if (this.baseItemLabelGenerator != null && this.baseItemLabelGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.baseItemLabelGenerator = (XYItemLabelGenerator)((PublicCloneable)this.baseItemLabelGenerator).clone();
        }
        if (this.toolTipGenerator != null && this.toolTipGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.toolTipGenerator = (XYToolTipGenerator)((PublicCloneable)this.toolTipGenerator).clone();
        }
        abstractXYItemRenderer.toolTipGeneratorList = (ObjectList)this.toolTipGeneratorList.clone();
        if (this.baseToolTipGenerator != null && this.baseToolTipGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.baseToolTipGenerator = (XYToolTipGenerator)((PublicCloneable)this.baseToolTipGenerator).clone();
        }
        if (abstractXYItemRenderer.legendItemLabelGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.legendItemLabelGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
        }
        if (abstractXYItemRenderer.legendItemToolTipGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.legendItemToolTipGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
        }
        if (abstractXYItemRenderer.legendItemURLGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.legendItemURLGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
        }
        abstractXYItemRenderer.foregroundAnnotations = (List)ObjectUtilities.deepClone(this.foregroundAnnotations);
        abstractXYItemRenderer.backgroundAnnotations = (List)ObjectUtilities.deepClone(this.backgroundAnnotations);
        if (abstractXYItemRenderer.legendItemLabelGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.legendItemLabelGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
        }
        if (abstractXYItemRenderer.legendItemToolTipGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.legendItemToolTipGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
        }
        if (abstractXYItemRenderer.legendItemURLGenerator instanceof PublicCloneable) {
            abstractXYItemRenderer.legendItemURLGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
        }
        return abstractXYItemRenderer;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AbstractXYItemRenderer)) {
            return false;
        }
        final AbstractXYItemRenderer abstractXYItemRenderer = (AbstractXYItemRenderer)o;
        return ObjectUtilities.equal(this.itemLabelGenerator, abstractXYItemRenderer.itemLabelGenerator) && this.itemLabelGeneratorList.equals(abstractXYItemRenderer.itemLabelGeneratorList) && ObjectUtilities.equal(this.baseItemLabelGenerator, abstractXYItemRenderer.baseItemLabelGenerator) && ObjectUtilities.equal(this.toolTipGenerator, abstractXYItemRenderer.toolTipGenerator) && this.toolTipGeneratorList.equals(abstractXYItemRenderer.toolTipGeneratorList) && ObjectUtilities.equal(this.baseToolTipGenerator, abstractXYItemRenderer.baseToolTipGenerator) && ObjectUtilities.equal(this.urlGenerator, abstractXYItemRenderer.urlGenerator) && this.foregroundAnnotations.equals(abstractXYItemRenderer.foregroundAnnotations) && this.backgroundAnnotations.equals(abstractXYItemRenderer.backgroundAnnotations) && this.defaultEntityRadius == abstractXYItemRenderer.defaultEntityRadius && ObjectUtilities.equal(this.legendItemLabelGenerator, abstractXYItemRenderer.legendItemLabelGenerator) && ObjectUtilities.equal(this.legendItemToolTipGenerator, abstractXYItemRenderer.legendItemToolTipGenerator) && ObjectUtilities.equal(this.legendItemURLGenerator, abstractXYItemRenderer.legendItemURLGenerator) && super.equals(o);
    }
    
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        final XYPlot plot = this.getPlot();
        if (plot != null) {
            drawingSupplier = plot.getDrawingSupplier();
        }
        return drawingSupplier;
    }
    
    protected void updateCrosshairValues(final CrosshairState crosshairState, final double n, final double n2, final double n3, final double n4, final PlotOrientation plotOrientation) {
        this.updateCrosshairValues(crosshairState, n, n2, 0, 0, n3, n4, plotOrientation);
    }
    
    protected void updateCrosshairValues(final CrosshairState crosshairState, final double n, final double n2, final int n3, final int n4, final double n5, final double n6, final PlotOrientation plotOrientation) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        if (crosshairState != null) {
            if (this.plot.isDomainCrosshairLockedOnData()) {
                if (this.plot.isRangeCrosshairLockedOnData()) {
                    crosshairState.updateCrosshairPoint(n, n2, n3, n4, n5, n6, plotOrientation);
                }
                else {
                    crosshairState.updateCrosshairX(n, n3);
                }
            }
            else if (this.plot.isRangeCrosshairLockedOnData()) {
                crosshairState.updateCrosshairY(n2, n4);
            }
        }
    }
    
    protected void drawItemLabel(final Graphics2D graphics2D, final PlotOrientation plotOrientation, final XYDataset xyDataset, final int n, final int n2, final double n3, final double n4, final boolean b) {
        final XYItemLabelGenerator itemLabelGenerator = this.getItemLabelGenerator(n, n2);
        if (itemLabelGenerator != null) {
            final Font itemLabelFont = this.getItemLabelFont(n, n2);
            final Paint itemLabelPaint = this.getItemLabelPaint(n, n2);
            graphics2D.setFont(itemLabelFont);
            graphics2D.setPaint(itemLabelPaint);
            final String generateLabel = itemLabelGenerator.generateLabel(xyDataset, n, n2);
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
    
    public void drawAnnotations(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final Layer layer, final PlotRenderingInfo plotRenderingInfo) {
        Iterator<XYAnnotation> iterator;
        if (layer.equals(Layer.FOREGROUND)) {
            iterator = this.foregroundAnnotations.iterator();
        }
        else {
            if (!layer.equals(Layer.BACKGROUND)) {
                throw new RuntimeException("Unknown layer.");
            }
            iterator = this.backgroundAnnotations.iterator();
        }
        while (iterator.hasNext()) {
            iterator.next().draw(graphics2D, this.plot, rectangle2D, valueAxis, valueAxis2, 0, plotRenderingInfo);
        }
    }
    
    protected void addEntity(final EntityCollection collection, Shape shape, final XYDataset xyDataset, final int n, final int n2, final double n3, final double n4) {
        if (!this.getItemCreateEntity(n, n2)) {
            return;
        }
        if (shape == null) {
            shape = new Ellipse2D.Double(n3 - this.defaultEntityRadius, n4 - this.defaultEntityRadius, this.defaultEntityRadius * 2, this.defaultEntityRadius * 2);
        }
        String generateToolTip = null;
        final XYToolTipGenerator toolTipGenerator = this.getToolTipGenerator(n, n2);
        if (toolTipGenerator != null) {
            generateToolTip = toolTipGenerator.generateToolTip(xyDataset, n, n2);
        }
        String generateURL = null;
        if (this.getURLGenerator() != null) {
            generateURL = this.getURLGenerator().generateURL(xyDataset, n, n2);
        }
        collection.add(new XYItemEntity(shape, xyDataset, n, n2, generateToolTip, generateURL));
    }
}
