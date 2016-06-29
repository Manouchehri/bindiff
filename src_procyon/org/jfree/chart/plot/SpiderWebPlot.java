package org.jfree.chart.plot;

import org.jfree.data.category.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import java.util.*;
import org.jfree.data.general.*;
import java.awt.*;
import org.jfree.chart.entity.*;
import java.awt.font.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class SpiderWebPlot extends Plot implements Serializable, Cloneable
{
    private static final long serialVersionUID = -5376340422031599463L;
    public static final double DEFAULT_HEAD = 0.01;
    public static final double DEFAULT_AXIS_LABEL_GAP = 0.1;
    public static final double DEFAULT_INTERIOR_GAP = 0.25;
    public static final double MAX_INTERIOR_GAP = 0.4;
    public static final double DEFAULT_START_ANGLE = 90.0;
    public static final Font DEFAULT_LABEL_FONT;
    public static final Paint DEFAULT_LABEL_PAINT;
    public static final Paint DEFAULT_LABEL_BACKGROUND_PAINT;
    public static final Paint DEFAULT_LABEL_OUTLINE_PAINT;
    public static final Stroke DEFAULT_LABEL_OUTLINE_STROKE;
    public static final Paint DEFAULT_LABEL_SHADOW_PAINT;
    public static final double DEFAULT_MAX_VALUE = -1.0;
    protected double headPercent;
    private double interiorGap;
    private double axisLabelGap;
    private transient Paint axisLinePaint;
    private transient Stroke axisLineStroke;
    private CategoryDataset dataset;
    private double maxValue;
    private TableOrder dataExtractOrder;
    private double startAngle;
    private Rotation direction;
    private transient Shape legendItemShape;
    private transient Paint seriesPaint;
    private PaintList seriesPaintList;
    private transient Paint baseSeriesPaint;
    private transient Paint seriesOutlinePaint;
    private PaintList seriesOutlinePaintList;
    private transient Paint baseSeriesOutlinePaint;
    private transient Stroke seriesOutlineStroke;
    private StrokeList seriesOutlineStrokeList;
    private transient Stroke baseSeriesOutlineStroke;
    private Font labelFont;
    private transient Paint labelPaint;
    private CategoryItemLabelGenerator labelGenerator;
    private boolean webFilled;
    private CategoryToolTipGenerator toolTipGenerator;
    private CategoryURLGenerator urlGenerator;
    
    public SpiderWebPlot() {
        this(null);
    }
    
    public SpiderWebPlot(final CategoryDataset categoryDataset) {
        this(categoryDataset, TableOrder.BY_ROW);
    }
    
    public SpiderWebPlot(final CategoryDataset dataset, final TableOrder dataExtractOrder) {
        this.webFilled = true;
        if (dataExtractOrder == null) {
            throw new IllegalArgumentException("Null 'extract' argument.");
        }
        if ((this.dataset = dataset) != null) {
            dataset.addChangeListener(this);
        }
        this.dataExtractOrder = dataExtractOrder;
        this.headPercent = 0.01;
        this.axisLabelGap = 0.1;
        this.axisLinePaint = Color.black;
        this.axisLineStroke = new BasicStroke(1.0f);
        this.interiorGap = 0.25;
        this.startAngle = 90.0;
        this.direction = Rotation.CLOCKWISE;
        this.maxValue = -1.0;
        this.seriesPaint = null;
        this.seriesPaintList = new PaintList();
        this.baseSeriesPaint = null;
        this.seriesOutlinePaint = null;
        this.seriesOutlinePaintList = new PaintList();
        this.baseSeriesOutlinePaint = SpiderWebPlot.DEFAULT_OUTLINE_PAINT;
        this.seriesOutlineStroke = null;
        this.seriesOutlineStrokeList = new StrokeList();
        this.baseSeriesOutlineStroke = SpiderWebPlot.DEFAULT_OUTLINE_STROKE;
        this.labelFont = SpiderWebPlot.DEFAULT_LABEL_FONT;
        this.labelPaint = SpiderWebPlot.DEFAULT_LABEL_PAINT;
        this.labelGenerator = new StandardCategoryItemLabelGenerator();
        this.legendItemShape = SpiderWebPlot.DEFAULT_LEGEND_ITEM_CIRCLE;
    }
    
    public String getPlotType() {
        return "Spider Web Plot";
    }
    
    public CategoryDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final CategoryDataset dataset) {
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }
        if ((this.dataset = dataset) != null) {
            this.setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, dataset));
    }
    
    public boolean isWebFilled() {
        return this.webFilled;
    }
    
    public void setWebFilled(final boolean webFilled) {
        this.webFilled = webFilled;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public TableOrder getDataExtractOrder() {
        return this.dataExtractOrder;
    }
    
    public void setDataExtractOrder(final TableOrder dataExtractOrder) {
        if (dataExtractOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument");
        }
        this.dataExtractOrder = dataExtractOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getHeadPercent() {
        return this.headPercent;
    }
    
    public void setHeadPercent(final double headPercent) {
        this.headPercent = headPercent;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getStartAngle() {
        return this.startAngle;
    }
    
    public void setStartAngle(final double startAngle) {
        this.startAngle = startAngle;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getMaxValue() {
        return this.maxValue;
    }
    
    public void setMaxValue(final double maxValue) {
        this.maxValue = maxValue;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Rotation getDirection() {
        return this.direction;
    }
    
    public void setDirection(final Rotation direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Null 'direction' argument.");
        }
        this.direction = direction;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getInteriorGap() {
        return this.interiorGap;
    }
    
    public void setInteriorGap(final double interiorGap) {
        if (interiorGap < 0.0 || interiorGap > 0.4) {
            throw new IllegalArgumentException("Percentage outside valid range.");
        }
        if (this.interiorGap != interiorGap) {
            this.interiorGap = interiorGap;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public double getAxisLabelGap() {
        return this.axisLabelGap;
    }
    
    public void setAxisLabelGap(final double axisLabelGap) {
        this.axisLabelGap = axisLabelGap;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getAxisLinePaint() {
        return this.axisLinePaint;
    }
    
    public void setAxisLinePaint(final Paint axisLinePaint) {
        if (axisLinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.axisLinePaint = axisLinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getAxisLineStroke() {
        return this.axisLineStroke;
    }
    
    public void setAxisLineStroke(final Stroke axisLineStroke) {
        if (axisLineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.axisLineStroke = axisLineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getSeriesPaint() {
        return this.seriesPaint;
    }
    
    public void setSeriesPaint(final Paint seriesPaint) {
        this.seriesPaint = seriesPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getSeriesPaint(final int n) {
        if (this.seriesPaint != null) {
            return this.seriesPaint;
        }
        Paint paint = this.seriesPaintList.getPaint(n);
        if (paint == null) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                final Paint nextPaint = drawingSupplier.getNextPaint();
                this.seriesPaintList.setPaint(n, nextPaint);
                paint = nextPaint;
            }
            else {
                paint = this.baseSeriesPaint;
            }
        }
        return paint;
    }
    
    public void setSeriesPaint(final int n, final Paint paint) {
        this.seriesPaintList.setPaint(n, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getBaseSeriesPaint() {
        return this.baseSeriesPaint;
    }
    
    public void setBaseSeriesPaint(final Paint baseSeriesPaint) {
        if (baseSeriesPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSeriesPaint = baseSeriesPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getSeriesOutlinePaint() {
        return this.seriesOutlinePaint;
    }
    
    public void setSeriesOutlinePaint(final Paint seriesOutlinePaint) {
        this.seriesOutlinePaint = seriesOutlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getSeriesOutlinePaint(final int n) {
        if (this.seriesOutlinePaint != null) {
            return this.seriesOutlinePaint;
        }
        Paint paint = this.seriesOutlinePaintList.getPaint(n);
        if (paint == null) {
            paint = this.baseSeriesOutlinePaint;
        }
        return paint;
    }
    
    public void setSeriesOutlinePaint(final int n, final Paint paint) {
        this.seriesOutlinePaintList.setPaint(n, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getBaseSeriesOutlinePaint() {
        return this.baseSeriesOutlinePaint;
    }
    
    public void setBaseSeriesOutlinePaint(final Paint baseSeriesOutlinePaint) {
        if (baseSeriesOutlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSeriesOutlinePaint = baseSeriesOutlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getSeriesOutlineStroke() {
        return this.seriesOutlineStroke;
    }
    
    public void setSeriesOutlineStroke(final Stroke seriesOutlineStroke) {
        this.seriesOutlineStroke = seriesOutlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getSeriesOutlineStroke(final int n) {
        if (this.seriesOutlineStroke != null) {
            return this.seriesOutlineStroke;
        }
        Stroke stroke = this.seriesOutlineStrokeList.getStroke(n);
        if (stroke == null) {
            stroke = this.baseSeriesOutlineStroke;
        }
        return stroke;
    }
    
    public void setSeriesOutlineStroke(final int n, final Stroke stroke) {
        this.seriesOutlineStrokeList.setStroke(n, stroke);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getBaseSeriesOutlineStroke() {
        return this.baseSeriesOutlineStroke;
    }
    
    public void setBaseSeriesOutlineStroke(final Stroke baseSeriesOutlineStroke) {
        if (baseSeriesOutlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseSeriesOutlineStroke = baseSeriesOutlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Shape getLegendItemShape() {
        return this.legendItemShape;
    }
    
    public void setLegendItemShape(final Shape legendItemShape) {
        if (legendItemShape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.legendItemShape = legendItemShape;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Font getLabelFont() {
        return this.labelFont;
    }
    
    public void setLabelFont(final Font labelFont) {
        if (labelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.labelFont = labelFont;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getLabelPaint() {
        return this.labelPaint;
    }
    
    public void setLabelPaint(final Paint labelPaint) {
        if (labelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelPaint = labelPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public CategoryItemLabelGenerator getLabelGenerator() {
        return this.labelGenerator;
    }
    
    public void setLabelGenerator(final CategoryItemLabelGenerator labelGenerator) {
        if (labelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.labelGenerator = labelGenerator;
    }
    
    public CategoryToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }
    
    public void setToolTipGenerator(final CategoryToolTipGenerator toolTipGenerator) {
        this.toolTipGenerator = toolTipGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public CategoryURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }
    
    public void setURLGenerator(final CategoryURLGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public LegendItemCollection getLegendItems() {
        final LegendItemCollection collection = new LegendItemCollection();
        List<Object> list = null;
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            list = (List<Object>)this.dataset.getRowKeys();
        }
        else if (this.dataExtractOrder == TableOrder.BY_COLUMN) {
            list = (List<Object>)this.dataset.getColumnKeys();
        }
        if (list != null) {
            int n = 0;
            final Iterator<Object> iterator = list.iterator();
            final Shape legendItemShape = this.getLegendItemShape();
            while (iterator.hasNext()) {
                final String string = iterator.next().toString();
                collection.add(new LegendItem(string, string, null, null, legendItemShape, this.getSeriesPaint(n), this.getSeriesOutlineStroke(n), this.getSeriesOutlinePaint(n)));
                ++n;
            }
        }
        return collection;
    }
    
    protected Point2D getWebPoint(final Rectangle2D rectangle2D, final double n, final double n2) {
        final double radians = Math.toRadians(n);
        return new Point2D.Double(rectangle2D.getX() + Math.cos(radians) * n2 * rectangle2D.getWidth() / 2.0 + rectangle2D.getWidth() / 2.0, rectangle2D.getY() + -Math.sin(radians) * n2 * rectangle2D.getHeight() / 2.0 + rectangle2D.getHeight() / 2.0);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        this.getInsets().trim(rectangle2D);
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
            plotRenderingInfo.setDataArea(rectangle2D);
        }
        this.drawBackground(graphics2D, rectangle2D);
        this.drawOutline(graphics2D, rectangle2D);
        final Shape clip = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        if (!DatasetUtilities.isEmptyOrNull(this.dataset)) {
            int n;
            int n2;
            if (this.dataExtractOrder == TableOrder.BY_ROW) {
                n = this.dataset.getRowCount();
                n2 = this.dataset.getColumnCount();
            }
            else {
                n = this.dataset.getColumnCount();
                n2 = this.dataset.getRowCount();
            }
            if (this.maxValue == -1.0) {
                this.calculateMaxValue(n, n2);
            }
            final double n3 = rectangle2D.getWidth() * this.getInteriorGap();
            final double n4 = rectangle2D.getHeight() * this.getInteriorGap();
            final double n5 = rectangle2D.getX() + n3 / 2.0;
            final double n6 = rectangle2D.getY() + n4 / 2.0;
            final double n7 = rectangle2D.getWidth() - n3;
            final double n8 = rectangle2D.getHeight() - n4;
            final double n9 = rectangle2D.getWidth() * this.headPercent;
            final double n10 = rectangle2D.getHeight() * this.headPercent;
            final double n11 = Math.min(n7, n8) / 2.0;
            final double n12 = (n5 + n5 + n7) / 2.0 - n11;
            final double n13 = (n6 + n6 + n8) / 2.0 - n11;
            final double n14 = 2.0 * n11;
            final double n15 = 2.0 * n11;
            final Point2D.Double double1 = new Point2D.Double(n12 + n14 / 2.0, n13 + n15 / 2.0);
            final Rectangle2D.Double double2 = new Rectangle2D.Double(n12, n13, n14, n15);
            for (int i = 0; i < n2; ++i) {
                final double n16 = this.getStartAngle() + this.getDirection().getFactor() * i * 360.0 / n2;
                final Line2D.Double double3 = new Line2D.Double(double1, this.getWebPoint(double2, n16, 1.0));
                graphics2D.setPaint(this.axisLinePaint);
                graphics2D.setStroke(this.axisLineStroke);
                graphics2D.draw(double3);
                this.drawLabel(graphics2D, double2, 0.0, i, n16, 360.0 / n2);
            }
            for (int j = 0; j < n; ++j) {
                this.drawRadarPoly(graphics2D, double2, double1, plotRenderingInfo, j, n2, n10, n9);
            }
        }
        else {
            this.drawNoDataMessage(graphics2D, rectangle2D);
        }
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D);
    }
    
    private void calculateMaxValue(final int n, final int n2) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                final Number plotValue = this.getPlotValue(i, j);
                if (plotValue != null) {
                    final double doubleValue = plotValue.doubleValue();
                    if (doubleValue > this.maxValue) {
                        this.maxValue = doubleValue;
                    }
                }
            }
        }
    }
    
    protected void drawRadarPoly(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final PlotRenderingInfo plotRenderingInfo, final int n, final int n2, final double n3, final double n4) {
        final Polygon polygon = new Polygon();
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        for (int i = 0; i < n2; ++i) {
            final Number plotValue = this.getPlotValue(n, i);
            if (plotValue != null) {
                final double doubleValue = plotValue.doubleValue();
                if (doubleValue >= 0.0) {
                    final Point2D webPoint = this.getWebPoint(rectangle2D, this.getStartAngle() + this.getDirection().getFactor() * i * 360.0 / n2, doubleValue / this.maxValue);
                    polygon.addPoint((int)webPoint.getX(), (int)webPoint.getY());
                    final Paint seriesPaint = this.getSeriesPaint(n);
                    final Paint seriesOutlinePaint = this.getSeriesOutlinePaint(n);
                    final Stroke seriesOutlineStroke = this.getSeriesOutlineStroke(n);
                    final Ellipse2D.Double double1 = new Ellipse2D.Double(webPoint.getX() - n4 / 2.0, webPoint.getY() - n3 / 2.0, n4, n3);
                    graphics2D.setPaint(seriesPaint);
                    graphics2D.fill(double1);
                    graphics2D.setStroke(seriesOutlineStroke);
                    graphics2D.setPaint(seriesOutlinePaint);
                    graphics2D.draw(double1);
                    if (entityCollection != null) {
                        String generateToolTip = null;
                        if (this.toolTipGenerator != null) {
                            generateToolTip = this.toolTipGenerator.generateToolTip(this.dataset, n, i);
                        }
                        String generateURL = null;
                        if (this.urlGenerator != null) {
                            generateURL = this.urlGenerator.generateURL(this.dataset, n, i);
                        }
                        entityCollection.add(new CategoryItemEntity(new Rectangle((int)(webPoint.getX() - n4), (int)(webPoint.getY() - n3), (int)(n4 * 2.0), (int)(n3 * 2.0)), generateToolTip, generateURL, this.dataset, n, this.dataset.getColumnKey(i), i));
                    }
                }
            }
        }
        graphics2D.setPaint(this.getSeriesPaint(n));
        graphics2D.setStroke(this.getSeriesOutlineStroke(n));
        graphics2D.draw(polygon);
        if (this.webFilled) {
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.1f));
            graphics2D.fill(polygon);
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        }
    }
    
    protected Number getPlotValue(final int n, final int n2) {
        Number n3 = null;
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            n3 = this.dataset.getValue(n, n2);
        }
        else if (this.dataExtractOrder == TableOrder.BY_COLUMN) {
            n3 = this.dataset.getValue(n2, n);
        }
        return n3;
    }
    
    protected void drawLabel(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final int n2, final double n3, final double n4) {
        final FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        String s;
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            s = this.labelGenerator.generateColumnLabel(this.dataset, n2);
        }
        else {
            s = this.labelGenerator.generateRowLabel(this.dataset, n2);
        }
        final Point2D calculateLabelLocation = this.calculateLabelLocation(this.getLabelFont().getStringBounds(s, fontRenderContext), this.getLabelFont().getLineMetrics(s, fontRenderContext).getAscent(), rectangle2D, n3);
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setPaint(this.getLabelPaint());
        graphics2D.setFont(this.getLabelFont());
        graphics2D.drawString(s, (float)calculateLabelLocation.getX(), (float)calculateLabelLocation.getY());
        graphics2D.setComposite(composite);
    }
    
    protected Point2D calculateLabelLocation(final Rectangle2D rectangle2D, final double n, final Rectangle2D rectangle2D2, final double n2) {
        final Point2D endPoint = new Arc2D.Double(rectangle2D2, n2, 0.0, 0).getEndPoint();
        final double n3 = -(endPoint.getX() - rectangle2D2.getCenterX()) * this.axisLabelGap;
        final double n4 = -(endPoint.getY() - rectangle2D2.getCenterY()) * this.axisLabelGap;
        double n5 = endPoint.getX() - n3;
        double n6 = endPoint.getY() - n4;
        if (n5 < rectangle2D2.getCenterX()) {
            n5 -= rectangle2D.getWidth();
        }
        if (n5 == rectangle2D2.getCenterX()) {
            n5 -= rectangle2D.getWidth() / 2.0;
        }
        if (n6 > rectangle2D2.getCenterY()) {
            n6 += n;
        }
        return new Point2D.Double(n5, n6);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SpiderWebPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final SpiderWebPlot spiderWebPlot = (SpiderWebPlot)o;
        return this.dataExtractOrder.equals(spiderWebPlot.dataExtractOrder) && this.headPercent == spiderWebPlot.headPercent && this.interiorGap == spiderWebPlot.interiorGap && this.startAngle == spiderWebPlot.startAngle && this.direction.equals(spiderWebPlot.direction) && this.maxValue == spiderWebPlot.maxValue && this.webFilled == spiderWebPlot.webFilled && this.axisLabelGap == spiderWebPlot.axisLabelGap && PaintUtilities.equal(this.axisLinePaint, spiderWebPlot.axisLinePaint) && this.axisLineStroke.equals(spiderWebPlot.axisLineStroke) && ShapeUtilities.equal(this.legendItemShape, spiderWebPlot.legendItemShape) && PaintUtilities.equal(this.seriesPaint, spiderWebPlot.seriesPaint) && this.seriesPaintList.equals(spiderWebPlot.seriesPaintList) && PaintUtilities.equal(this.baseSeriesPaint, spiderWebPlot.baseSeriesPaint) && PaintUtilities.equal(this.seriesOutlinePaint, spiderWebPlot.seriesOutlinePaint) && this.seriesOutlinePaintList.equals(spiderWebPlot.seriesOutlinePaintList) && PaintUtilities.equal(this.baseSeriesOutlinePaint, spiderWebPlot.baseSeriesOutlinePaint) && ObjectUtilities.equal(this.seriesOutlineStroke, spiderWebPlot.seriesOutlineStroke) && this.seriesOutlineStrokeList.equals(spiderWebPlot.seriesOutlineStrokeList) && this.baseSeriesOutlineStroke.equals(spiderWebPlot.baseSeriesOutlineStroke) && this.labelFont.equals(spiderWebPlot.labelFont) && PaintUtilities.equal(this.labelPaint, spiderWebPlot.labelPaint) && this.labelGenerator.equals(spiderWebPlot.labelGenerator) && ObjectUtilities.equal(this.toolTipGenerator, spiderWebPlot.toolTipGenerator) && ObjectUtilities.equal(this.urlGenerator, spiderWebPlot.urlGenerator);
    }
    
    public Object clone() {
        final SpiderWebPlot spiderWebPlot = (SpiderWebPlot)super.clone();
        spiderWebPlot.legendItemShape = ShapeUtilities.clone(this.legendItemShape);
        spiderWebPlot.seriesPaintList = (PaintList)this.seriesPaintList.clone();
        spiderWebPlot.seriesOutlinePaintList = (PaintList)this.seriesOutlinePaintList.clone();
        spiderWebPlot.seriesOutlineStrokeList = (StrokeList)this.seriesOutlineStrokeList.clone();
        return spiderWebPlot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.legendItemShape, objectOutputStream);
        SerialUtilities.writePaint(this.seriesPaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseSeriesPaint, objectOutputStream);
        SerialUtilities.writePaint(this.seriesOutlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseSeriesOutlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.seriesOutlineStroke, objectOutputStream);
        SerialUtilities.writeStroke(this.baseSeriesOutlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
        SerialUtilities.writePaint(this.axisLinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.axisLineStroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.legendItemShape = SerialUtilities.readShape(objectInputStream);
        this.seriesPaint = SerialUtilities.readPaint(objectInputStream);
        this.baseSeriesPaint = SerialUtilities.readPaint(objectInputStream);
        this.seriesOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.baseSeriesOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.seriesOutlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.baseSeriesOutlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
        this.axisLinePaint = SerialUtilities.readPaint(objectInputStream);
        this.axisLineStroke = SerialUtilities.readStroke(objectInputStream);
        if (this.dataset != null) {
            this.dataset.addChangeListener(this);
        }
    }
    
    static {
        DEFAULT_LABEL_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_LABEL_PAINT = Color.black;
        DEFAULT_LABEL_BACKGROUND_PAINT = new Color(255, 255, 192);
        DEFAULT_LABEL_OUTLINE_PAINT = Color.black;
        DEFAULT_LABEL_OUTLINE_STROKE = new BasicStroke(0.5f);
        DEFAULT_LABEL_SHADOW_PAINT = Color.lightGray;
    }
}
