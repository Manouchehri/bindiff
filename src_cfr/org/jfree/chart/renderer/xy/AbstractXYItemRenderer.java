/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class AbstractXYItemRenderer
extends AbstractRenderer
implements Serializable,
Cloneable,
XYItemRenderer {
    private static final long serialVersionUID = 8019124836026607990L;
    private XYPlot plot;
    private XYItemLabelGenerator itemLabelGenerator = null;
    private ObjectList itemLabelGeneratorList = new ObjectList();
    private XYItemLabelGenerator baseItemLabelGenerator;
    private XYToolTipGenerator toolTipGenerator = null;
    private ObjectList toolTipGeneratorList = new ObjectList();
    private XYToolTipGenerator baseToolTipGenerator;
    private XYURLGenerator urlGenerator = null;
    private List backgroundAnnotations = new ArrayList();
    private List foregroundAnnotations = new ArrayList();
    private int defaultEntityRadius = 3;
    private XYSeriesLabelGenerator legendItemLabelGenerator = new StandardXYSeriesLabelGenerator("{0}");
    private XYSeriesLabelGenerator legendItemToolTipGenerator;
    private XYSeriesLabelGenerator legendItemURLGenerator;

    protected AbstractXYItemRenderer() {
    }

    @Override
    public int getPassCount() {
        return 1;
    }

    @Override
    public XYPlot getPlot() {
        return this.plot;
    }

    @Override
    public void setPlot(XYPlot xYPlot) {
        this.plot = xYPlot;
    }

    @Override
    public XYItemRendererState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, XYPlot xYPlot, XYDataset xYDataset, PlotRenderingInfo plotRenderingInfo) {
        return new XYItemRendererState(plotRenderingInfo);
    }

    @Override
    public XYItemLabelGenerator getItemLabelGenerator(int n2, int n3) {
        if (this.itemLabelGenerator != null) {
            return this.itemLabelGenerator;
        }
        XYItemLabelGenerator xYItemLabelGenerator = (XYItemLabelGenerator)this.itemLabelGeneratorList.get(n2);
        if (xYItemLabelGenerator != null) return xYItemLabelGenerator;
        return this.baseItemLabelGenerator;
    }

    @Override
    public XYItemLabelGenerator getSeriesItemLabelGenerator(int n2) {
        return (XYItemLabelGenerator)this.itemLabelGeneratorList.get(n2);
    }

    public XYItemLabelGenerator getItemLabelGenerator() {
        return this.itemLabelGenerator;
    }

    @Override
    public void setItemLabelGenerator(XYItemLabelGenerator xYItemLabelGenerator) {
        this.itemLabelGenerator = xYItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void setSeriesItemLabelGenerator(int n2, XYItemLabelGenerator xYItemLabelGenerator) {
        this.itemLabelGeneratorList.set(n2, xYItemLabelGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYItemLabelGenerator getBaseItemLabelGenerator() {
        return this.baseItemLabelGenerator;
    }

    @Override
    public void setBaseItemLabelGenerator(XYItemLabelGenerator xYItemLabelGenerator) {
        this.baseItemLabelGenerator = xYItemLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYToolTipGenerator getToolTipGenerator(int n2, int n3) {
        if (this.toolTipGenerator != null) {
            return this.toolTipGenerator;
        }
        XYToolTipGenerator xYToolTipGenerator = (XYToolTipGenerator)this.toolTipGeneratorList.get(n2);
        if (xYToolTipGenerator != null) return xYToolTipGenerator;
        return this.baseToolTipGenerator;
    }

    public XYToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }

    @Override
    public void setToolTipGenerator(XYToolTipGenerator xYToolTipGenerator) {
        this.toolTipGenerator = xYToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYToolTipGenerator getSeriesToolTipGenerator(int n2) {
        return (XYToolTipGenerator)this.toolTipGeneratorList.get(n2);
    }

    @Override
    public void setSeriesToolTipGenerator(int n2, XYToolTipGenerator xYToolTipGenerator) {
        this.toolTipGeneratorList.set(n2, xYToolTipGenerator);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYToolTipGenerator getBaseToolTipGenerator() {
        return this.baseToolTipGenerator;
    }

    @Override
    public void setBaseToolTipGenerator(XYToolTipGenerator xYToolTipGenerator) {
        this.baseToolTipGenerator = xYToolTipGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public XYURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }

    @Override
    public void setURLGenerator(XYURLGenerator xYURLGenerator) {
        this.urlGenerator = xYURLGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public void addAnnotation(XYAnnotation xYAnnotation) {
        this.addAnnotation(xYAnnotation, Layer.FOREGROUND);
    }

    @Override
    public void addAnnotation(XYAnnotation xYAnnotation, Layer layer) {
        if (xYAnnotation == null) {
            throw new IllegalArgumentException("Null 'annotation' argument.");
        }
        if (layer.equals(Layer.FOREGROUND)) {
            this.foregroundAnnotations.add(xYAnnotation);
            this.notifyListeners(new RendererChangeEvent(this));
            return;
        }
        if (!layer.equals(Layer.BACKGROUND)) throw new RuntimeException("Unknown layer.");
        this.backgroundAnnotations.add(xYAnnotation);
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public boolean removeAnnotation(XYAnnotation xYAnnotation) {
        boolean bl2 = this.foregroundAnnotations.remove(xYAnnotation);
        this.notifyListeners(new RendererChangeEvent(this));
        return bl2 &= this.backgroundAnnotations.remove(xYAnnotation);
    }

    @Override
    public void removeAnnotations() {
        this.foregroundAnnotations.clear();
        this.backgroundAnnotations.clear();
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public int getDefaultEntityRadius() {
        return this.defaultEntityRadius;
    }

    public void setDefaultEntityRadius(int n2) {
        this.defaultEntityRadius = n2;
    }

    @Override
    public XYSeriesLabelGenerator getLegendItemLabelGenerator() {
        return this.legendItemLabelGenerator;
    }

    @Override
    public void setLegendItemLabelGenerator(XYSeriesLabelGenerator xYSeriesLabelGenerator) {
        if (xYSeriesLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.legendItemLabelGenerator = xYSeriesLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public XYSeriesLabelGenerator getLegendItemToolTipGenerator() {
        return this.legendItemToolTipGenerator;
    }

    public void setLegendItemToolTipGenerator(XYSeriesLabelGenerator xYSeriesLabelGenerator) {
        this.legendItemToolTipGenerator = xYSeriesLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    public XYSeriesLabelGenerator getLegendItemURLGenerator() {
        return this.legendItemURLGenerator;
    }

    public void setLegendItemURLGenerator(XYSeriesLabelGenerator xYSeriesLabelGenerator) {
        this.legendItemURLGenerator = xYSeriesLabelGenerator;
        this.notifyListeners(new RendererChangeEvent(this));
    }

    @Override
    public Range findDomainBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        return DatasetUtilities.findDomainBounds(xYDataset, false);
    }

    @Override
    public Range findRangeBounds(XYDataset xYDataset) {
        if (xYDataset == null) return null;
        return DatasetUtilities.findRangeBounds(xYDataset, false);
    }

    @Override
    public LegendItemCollection getLegendItems() {
        if (this.plot == null) {
            return new LegendItemCollection();
        }
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        int n2 = this.plot.getIndexOf(this);
        XYDataset xYDataset = this.plot.getDataset(n2);
        if (xYDataset == null) return legendItemCollection;
        int n3 = xYDataset.getSeriesCount();
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

    @Override
    public LegendItem getLegendItem(int n2, int n3) {
        String string;
        LegendItem legendItem = null;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) return legendItem;
        XYDataset xYDataset = xYPlot.getDataset(n2);
        if (xYDataset == null) return legendItem;
        String string2 = string = this.legendItemLabelGenerator.generateLabel(xYDataset, n3);
        String string3 = null;
        if (this.getLegendItemToolTipGenerator() != null) {
            string3 = this.getLegendItemToolTipGenerator().generateLabel(xYDataset, n3);
        }
        String string4 = null;
        if (this.getLegendItemURLGenerator() != null) {
            string4 = this.getLegendItemURLGenerator().generateLabel(xYDataset, n3);
        }
        Shape shape = this.getSeriesShape(n3);
        Paint paint = this.getSeriesPaint(n3);
        Paint paint2 = this.getSeriesOutlinePaint(n3);
        Stroke stroke = this.getSeriesOutlineStroke(n3);
        legendItem = new LegendItem(string, string2, string3, string4, shape, paint, stroke, paint2);
        legendItem.setSeriesIndex(n3);
        legendItem.setDatasetIndex(n2);
        return legendItem;
    }

    @Override
    public void fillDomainGridBand(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2, double d3) {
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        double d5 = valueAxis.valueToJava2D(d3, rectangle2D, xYPlot.getDomainAxisEdge());
        Rectangle2D.Double double_ = new Rectangle2D.Double(d4, rectangle2D.getMinY(), d5 - d4, rectangle2D.getMaxY() - rectangle2D.getMinY());
        Paint paint = xYPlot.getDomainTickBandPaint();
        if (paint == null) return;
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
    }

    @Override
    public void fillRangeGridBand(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2, double d3) {
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getRangeAxisEdge());
        double d5 = valueAxis.valueToJava2D(d3, rectangle2D, xYPlot.getRangeAxisEdge());
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getMinX(), d5, rectangle2D.getWidth(), d4 - d5);
        Paint paint = xYPlot.getRangeTickBandPaint();
        if (paint == null) return;
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
    }

    @Override
    public void drawDomainGridLine(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2) {
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        Line2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        }
        Paint paint = xYPlot.getDomainGridlinePaint();
        Stroke stroke = xYPlot.getDomainGridlineStroke();
        graphics2D.setPaint(paint != null ? paint : Plot.DEFAULT_OUTLINE_PAINT);
        graphics2D.setStroke(stroke != null ? stroke : Plot.DEFAULT_OUTLINE_STROKE);
        graphics2D.draw(double_);
    }

    public void drawDomainLine(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2, Paint paint, Stroke stroke) {
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Line2D.Double double_ = null;
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        }
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        graphics2D.draw(double_);
    }

    @Override
    public void drawRangeLine(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Rectangle2D rectangle2D, double d2, Paint paint, Stroke stroke) {
        Range range = valueAxis.getRange();
        if (!range.contains(d2)) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Line2D.Double double_ = null;
        double d3 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getRangeAxisEdge());
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
        }
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        graphics2D.draw(double_);
    }

    @Override
    public void drawDomainMarker(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        Object object;
        Object object2;
        if (marker instanceof ValueMarker) {
            ValueMarker valueMarker = (ValueMarker)marker;
            double d2 = valueMarker.getValue();
            Range range = valueAxis.getRange();
            if (!range.contains(d2)) {
                return;
            }
            double d3 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getDomainAxisEdge());
            PlotOrientation plotOrientation = xYPlot.getOrientation();
            Line2D.Double double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
            }
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
            graphics2D.setPaint(marker.getPaint());
            graphics2D.setStroke(marker.getStroke());
            graphics2D.draw(double_);
            String string = marker.getLabel();
            RectangleAnchor rectangleAnchor = marker.getLabelAnchor();
            if (string != null) {
                Font font = marker.getLabelFont();
                graphics2D.setFont(font);
                graphics2D.setPaint(marker.getLabelPaint());
                Point2D point2D = this.calculateDomainMarkerTextAnchorPoint(graphics2D, plotOrientation, rectangle2D, double_.getBounds2D(), marker.getLabelOffset(), LengthAdjustmentType.EXPAND, rectangleAnchor);
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
        double d6 = valueAxis.valueToJava2D(d4, rectangle2D, xYPlot.getDomainAxisEdge());
        double d7 = valueAxis.valueToJava2D(d5, rectangle2D, xYPlot.getDomainAxisEdge());
        double d8 = Math.min(d6, d7);
        double d9 = Math.max(d6, d7);
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        Rectangle2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d8 = Math.max(d8, rectangle2D.getMinY());
            d9 = Math.min(d9, rectangle2D.getMaxY());
            double_ = new Rectangle2D.Double(rectangle2D.getMinX(), d8, rectangle2D.getWidth(), d9 - d8);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d8 = Math.max(d8, rectangle2D.getMinX());
            d9 = Math.min(d9, rectangle2D.getMaxX());
            double_ = new Rectangle2D.Double(d8, rectangle2D.getMinY(), d9 - d8, rectangle2D.getHeight());
        }
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
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
                double d11 = rectangle2D.getMinY();
                d10 = rectangle2D.getMaxY();
                graphics2D.setPaint(intervalMarker.getOutlinePaint());
                graphics2D.setStroke(intervalMarker.getOutlineStroke());
                if (range.contains(d4)) {
                    object.setLine(d6, d11, d6, d10);
                    graphics2D.draw((Shape)object);
                }
                if (range.contains(d5)) {
                    object.setLine(d7, d11, d7, d10);
                    graphics2D.draw((Shape)object);
                }
            } else {
                object = new Line2D.Double();
                double d12 = rectangle2D.getMinX();
                d10 = rectangle2D.getMaxX();
                graphics2D.setPaint(intervalMarker.getOutlinePaint());
                graphics2D.setStroke(intervalMarker.getOutlineStroke());
                if (range.contains(d4)) {
                    object.setLine(d12, d6, d10, d6);
                    graphics2D.draw((Shape)object);
                }
                if (range.contains(d5)) {
                    object.setLine(d12, d7, d10, d7);
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
            Point2D point2D = this.calculateDomainMarkerTextAnchorPoint(graphics2D, plotOrientation, rectangle2D, double_, marker.getLabelOffset(), marker.getLabelOffsetType(), (RectangleAnchor)object2);
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

    @Override
    public void drawRangeMarker(Graphics2D graphics2D, XYPlot xYPlot, ValueAxis valueAxis, Marker marker, Rectangle2D rectangle2D) {
        Object object;
        Object object2;
        if (marker instanceof ValueMarker) {
            ValueMarker valueMarker = (ValueMarker)marker;
            double d2 = valueMarker.getValue();
            Range range = valueAxis.getRange();
            if (!range.contains(d2)) {
                return;
            }
            double d3 = valueAxis.valueToJava2D(d2, rectangle2D, xYPlot.getRangeAxisEdge());
            PlotOrientation plotOrientation = xYPlot.getOrientation();
            Line2D.Double double_ = null;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double_ = new Line2D.Double(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
            } else if (plotOrientation == PlotOrientation.VERTICAL) {
                double_ = new Line2D.Double(rectangle2D.getMinX(), d3, rectangle2D.getMaxX(), d3);
            }
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
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
        double d6 = valueAxis.valueToJava2D(d4, rectangle2D, xYPlot.getRangeAxisEdge());
        double d7 = valueAxis.valueToJava2D(d5, rectangle2D, xYPlot.getRangeAxisEdge());
        double d8 = Math.min(d6, d7);
        double d9 = Math.max(d6, d7);
        PlotOrientation plotOrientation = xYPlot.getOrientation();
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
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, marker.getAlpha()));
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

    private Point2D calculateRangeMarkerTextAnchorPoint(Graphics2D graphics2D, PlotOrientation plotOrientation, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleInsets rectangleInsets, LengthAdjustmentType lengthAdjustmentType, RectangleAnchor rectangleAnchor) {
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
    protected Object clone() {
        PublicCloneable publicCloneable;
        AbstractXYItemRenderer abstractXYItemRenderer = (AbstractXYItemRenderer)super.clone();
        if (this.itemLabelGenerator != null && this.itemLabelGenerator instanceof PublicCloneable) {
            publicCloneable = (PublicCloneable)((Object)this.itemLabelGenerator);
            abstractXYItemRenderer.itemLabelGenerator = (XYItemLabelGenerator)publicCloneable.clone();
        }
        abstractXYItemRenderer.itemLabelGeneratorList = (ObjectList)this.itemLabelGeneratorList.clone();
        if (this.baseItemLabelGenerator != null && this.baseItemLabelGenerator instanceof PublicCloneable) {
            publicCloneable = (PublicCloneable)((Object)this.baseItemLabelGenerator);
            abstractXYItemRenderer.baseItemLabelGenerator = (XYItemLabelGenerator)publicCloneable.clone();
        }
        if (this.toolTipGenerator != null && this.toolTipGenerator instanceof PublicCloneable) {
            publicCloneable = (PublicCloneable)((Object)this.toolTipGenerator);
            abstractXYItemRenderer.toolTipGenerator = (XYToolTipGenerator)publicCloneable.clone();
        }
        abstractXYItemRenderer.toolTipGeneratorList = (ObjectList)this.toolTipGeneratorList.clone();
        if (this.baseToolTipGenerator != null && this.baseToolTipGenerator instanceof PublicCloneable) {
            publicCloneable = (PublicCloneable)((Object)this.baseToolTipGenerator);
            abstractXYItemRenderer.baseToolTipGenerator = (XYToolTipGenerator)publicCloneable.clone();
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
        if (!(abstractXYItemRenderer.legendItemURLGenerator instanceof PublicCloneable)) return abstractXYItemRenderer;
        abstractXYItemRenderer.legendItemURLGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
        return abstractXYItemRenderer;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AbstractXYItemRenderer)) {
            return false;
        }
        AbstractXYItemRenderer abstractXYItemRenderer = (AbstractXYItemRenderer)object;
        if (!ObjectUtilities.equal(this.itemLabelGenerator, abstractXYItemRenderer.itemLabelGenerator)) {
            return false;
        }
        if (!this.itemLabelGeneratorList.equals(abstractXYItemRenderer.itemLabelGeneratorList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseItemLabelGenerator, abstractXYItemRenderer.baseItemLabelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipGenerator, abstractXYItemRenderer.toolTipGenerator)) {
            return false;
        }
        if (!this.toolTipGeneratorList.equals(abstractXYItemRenderer.toolTipGeneratorList)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseToolTipGenerator, abstractXYItemRenderer.baseToolTipGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.urlGenerator, abstractXYItemRenderer.urlGenerator)) {
            return false;
        }
        if (!this.foregroundAnnotations.equals(abstractXYItemRenderer.foregroundAnnotations)) {
            return false;
        }
        if (!this.backgroundAnnotations.equals(abstractXYItemRenderer.backgroundAnnotations)) {
            return false;
        }
        if (this.defaultEntityRadius != abstractXYItemRenderer.defaultEntityRadius) {
            return false;
        }
        if (!ObjectUtilities.equal(this.legendItemLabelGenerator, abstractXYItemRenderer.legendItemLabelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.legendItemToolTipGenerator, abstractXYItemRenderer.legendItemToolTipGenerator)) {
            return false;
        }
        if (ObjectUtilities.equal(this.legendItemURLGenerator, abstractXYItemRenderer.legendItemURLGenerator)) return super.equals(object);
        return false;
    }

    @Override
    public DrawingSupplier getDrawingSupplier() {
        DrawingSupplier drawingSupplier = null;
        XYPlot xYPlot = this.getPlot();
        if (xYPlot == null) return drawingSupplier;
        return xYPlot.getDrawingSupplier();
    }

    protected void updateCrosshairValues(CrosshairState crosshairState, double d2, double d3, double d4, double d5, PlotOrientation plotOrientation) {
        this.updateCrosshairValues(crosshairState, d2, d3, 0, 0, d4, d5, plotOrientation);
    }

    protected void updateCrosshairValues(CrosshairState crosshairState, double d2, double d3, int n2, int n3, double d4, double d5, PlotOrientation plotOrientation) {
        if (plotOrientation == null) {
            throw new IllegalArgumentException("Null 'orientation' argument.");
        }
        if (crosshairState == null) return;
        if (!this.plot.isDomainCrosshairLockedOnData()) {
            if (!this.plot.isRangeCrosshairLockedOnData()) return;
            crosshairState.updateCrosshairY(d3, n3);
            return;
        }
        if (this.plot.isRangeCrosshairLockedOnData()) {
            crosshairState.updateCrosshairPoint(d2, d3, n2, n3, d4, d5, plotOrientation);
            return;
        }
        crosshairState.updateCrosshairX(d2, n2);
    }

    protected void drawItemLabel(Graphics2D graphics2D, PlotOrientation plotOrientation, XYDataset xYDataset, int n2, int n3, double d2, double d3, boolean bl2) {
        XYItemLabelGenerator xYItemLabelGenerator = this.getItemLabelGenerator(n2, n3);
        if (xYItemLabelGenerator == null) return;
        Font font = this.getItemLabelFont(n2, n3);
        Paint paint = this.getItemLabelPaint(n2, n3);
        graphics2D.setFont(font);
        graphics2D.setPaint(paint);
        String string = xYItemLabelGenerator.generateLabel(xYDataset, n2, n3);
        ItemLabelPosition itemLabelPosition = null;
        itemLabelPosition = !bl2 ? this.getPositiveItemLabelPosition(n2, n3) : this.getNegativeItemLabelPosition(n2, n3);
        Point2D point2D = this.calculateLabelAnchorPoint(itemLabelPosition.getItemLabelAnchor(), d2, d3, plotOrientation);
        TextUtilities.drawRotatedString(string, graphics2D, (float)point2D.getX(), (float)point2D.getY(), itemLabelPosition.getTextAnchor(), itemLabelPosition.getAngle(), itemLabelPosition.getRotationAnchor());
    }

    @Override
    public void drawAnnotations(Graphics2D graphics2D, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, Layer layer, PlotRenderingInfo plotRenderingInfo) {
        Iterator iterator = null;
        if (layer.equals(Layer.FOREGROUND)) {
            iterator = this.foregroundAnnotations.iterator();
        } else {
            if (!layer.equals(Layer.BACKGROUND)) throw new RuntimeException("Unknown layer.");
            iterator = this.backgroundAnnotations.iterator();
        }
        while (iterator.hasNext()) {
            XYAnnotation xYAnnotation = (XYAnnotation)iterator.next();
            xYAnnotation.draw(graphics2D, this.plot, rectangle2D, valueAxis, valueAxis2, 0, plotRenderingInfo);
        }
    }

    protected void addEntity(EntityCollection entityCollection, Shape shape, XYDataset xYDataset, int n2, int n3, double d2, double d3) {
        if (!this.getItemCreateEntity(n2, n3)) {
            return;
        }
        if (shape == null) {
            shape = new Ellipse2D.Double(d2 - (double)this.defaultEntityRadius, d3 - (double)this.defaultEntityRadius, this.defaultEntityRadius * 2, this.defaultEntityRadius * 2);
        }
        String string = null;
        XYToolTipGenerator xYToolTipGenerator = this.getToolTipGenerator(n2, n3);
        if (xYToolTipGenerator != null) {
            string = xYToolTipGenerator.generateToolTip(xYDataset, n2, n3);
        }
        String string2 = null;
        if (this.getURLGenerator() != null) {
            string2 = this.getURLGenerator().generateURL(xYDataset, n2, n3);
        }
        XYItemEntity xYItemEntity = new XYItemEntity(shape, xYDataset, n2, n3, string, string2);
        entityCollection.add(xYItemEntity);
    }
}

