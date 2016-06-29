/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintList;
import org.jfree.util.PaintUtilities;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.StrokeList;
import org.jfree.util.TableOrder;

public class SpiderWebPlot
extends Plot
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -5376340422031599463L;
    public static final double DEFAULT_HEAD = 0.01;
    public static final double DEFAULT_AXIS_LABEL_GAP = 0.1;
    public static final double DEFAULT_INTERIOR_GAP = 0.25;
    public static final double MAX_INTERIOR_GAP = 0.4;
    public static final double DEFAULT_START_ANGLE = 90.0;
    public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_LABEL_PAINT = Color.black;
    public static final Paint DEFAULT_LABEL_BACKGROUND_PAINT = new Color(255, 255, 192);
    public static final Paint DEFAULT_LABEL_OUTLINE_PAINT = Color.black;
    public static final Stroke DEFAULT_LABEL_OUTLINE_STROKE = new BasicStroke(0.5f);
    public static final Paint DEFAULT_LABEL_SHADOW_PAINT = Color.lightGray;
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
    private boolean webFilled = true;
    private CategoryToolTipGenerator toolTipGenerator;
    private CategoryURLGenerator urlGenerator;

    public SpiderWebPlot() {
        this(null);
    }

    public SpiderWebPlot(CategoryDataset categoryDataset) {
        this(categoryDataset, TableOrder.BY_ROW);
    }

    public SpiderWebPlot(CategoryDataset categoryDataset, TableOrder tableOrder) {
        if (tableOrder == null) {
            throw new IllegalArgumentException("Null 'extract' argument.");
        }
        this.dataset = categoryDataset;
        if (categoryDataset != null) {
            categoryDataset.addChangeListener(this);
        }
        this.dataExtractOrder = tableOrder;
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
        this.baseSeriesOutlinePaint = DEFAULT_OUTLINE_PAINT;
        this.seriesOutlineStroke = null;
        this.seriesOutlineStrokeList = new StrokeList();
        this.baseSeriesOutlineStroke = DEFAULT_OUTLINE_STROKE;
        this.labelFont = DEFAULT_LABEL_FONT;
        this.labelPaint = DEFAULT_LABEL_PAINT;
        this.labelGenerator = new StandardCategoryItemLabelGenerator();
        this.legendItemShape = DEFAULT_LEGEND_ITEM_CIRCLE;
    }

    @Override
    public String getPlotType() {
        return "Spider Web Plot";
    }

    public CategoryDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(CategoryDataset categoryDataset) {
        if (this.dataset != null) {
            this.dataset.removeChangeListener(this);
        }
        this.dataset = categoryDataset;
        if (categoryDataset != null) {
            this.setDatasetGroup(categoryDataset.getGroup());
            categoryDataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, categoryDataset));
    }

    public boolean isWebFilled() {
        return this.webFilled;
    }

    public void setWebFilled(boolean bl2) {
        this.webFilled = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public TableOrder getDataExtractOrder() {
        return this.dataExtractOrder;
    }

    public void setDataExtractOrder(TableOrder tableOrder) {
        if (tableOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument");
        }
        this.dataExtractOrder = tableOrder;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getHeadPercent() {
        return this.headPercent;
    }

    public void setHeadPercent(double d2) {
        this.headPercent = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getStartAngle() {
        return this.startAngle;
    }

    public void setStartAngle(double d2) {
        this.startAngle = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(double d2) {
        this.maxValue = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Rotation getDirection() {
        return this.direction;
    }

    public void setDirection(Rotation rotation) {
        if (rotation == null) {
            throw new IllegalArgumentException("Null 'direction' argument.");
        }
        this.direction = rotation;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getInteriorGap() {
        return this.interiorGap;
    }

    public void setInteriorGap(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException("Percentage outside valid range.");
        if (d2 > 0.4) {
            throw new IllegalArgumentException("Percentage outside valid range.");
        }
        if (this.interiorGap == d2) return;
        this.interiorGap = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getAxisLabelGap() {
        return this.axisLabelGap;
    }

    public void setAxisLabelGap(double d2) {
        this.axisLabelGap = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getAxisLinePaint() {
        return this.axisLinePaint;
    }

    public void setAxisLinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.axisLinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getAxisLineStroke() {
        return this.axisLineStroke;
    }

    public void setAxisLineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.axisLineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getSeriesPaint() {
        return this.seriesPaint;
    }

    public void setSeriesPaint(Paint paint) {
        this.seriesPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getSeriesPaint(int n2) {
        if (this.seriesPaint != null) {
            return this.seriesPaint;
        }
        Paint paint = this.seriesPaintList.getPaint(n2);
        if (paint != null) return paint;
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseSeriesPaint;
        Paint paint2 = drawingSupplier.getNextPaint();
        this.seriesPaintList.setPaint(n2, paint2);
        return paint2;
    }

    public void setSeriesPaint(int n2, Paint paint) {
        this.seriesPaintList.setPaint(n2, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getBaseSeriesPaint() {
        return this.baseSeriesPaint;
    }

    public void setBaseSeriesPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSeriesPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getSeriesOutlinePaint() {
        return this.seriesOutlinePaint;
    }

    public void setSeriesOutlinePaint(Paint paint) {
        this.seriesOutlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getSeriesOutlinePaint(int n2) {
        if (this.seriesOutlinePaint != null) {
            return this.seriesOutlinePaint;
        }
        Paint paint = this.seriesOutlinePaintList.getPaint(n2);
        if (paint != null) return paint;
        return this.baseSeriesOutlinePaint;
    }

    public void setSeriesOutlinePaint(int n2, Paint paint) {
        this.seriesOutlinePaintList.setPaint(n2, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getBaseSeriesOutlinePaint() {
        return this.baseSeriesOutlinePaint;
    }

    public void setBaseSeriesOutlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSeriesOutlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getSeriesOutlineStroke() {
        return this.seriesOutlineStroke;
    }

    public void setSeriesOutlineStroke(Stroke stroke) {
        this.seriesOutlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getSeriesOutlineStroke(int n2) {
        if (this.seriesOutlineStroke != null) {
            return this.seriesOutlineStroke;
        }
        Stroke stroke = this.seriesOutlineStrokeList.getStroke(n2);
        if (stroke != null) return stroke;
        return this.baseSeriesOutlineStroke;
    }

    public void setSeriesOutlineStroke(int n2, Stroke stroke) {
        this.seriesOutlineStrokeList.setStroke(n2, stroke);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getBaseSeriesOutlineStroke() {
        return this.baseSeriesOutlineStroke;
    }

    public void setBaseSeriesOutlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseSeriesOutlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Shape getLegendItemShape() {
        return this.legendItemShape;
    }

    public void setLegendItemShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.legendItemShape = shape;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Font getLabelFont() {
        return this.labelFont;
    }

    public void setLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.labelFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getLabelPaint() {
        return this.labelPaint;
    }

    public void setLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public CategoryItemLabelGenerator getLabelGenerator() {
        return this.labelGenerator;
    }

    public void setLabelGenerator(CategoryItemLabelGenerator categoryItemLabelGenerator) {
        if (categoryItemLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.labelGenerator = categoryItemLabelGenerator;
    }

    public CategoryToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }

    public void setToolTipGenerator(CategoryToolTipGenerator categoryToolTipGenerator) {
        this.toolTipGenerator = categoryToolTipGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public CategoryURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }

    public void setURLGenerator(CategoryURLGenerator categoryURLGenerator) {
        this.urlGenerator = categoryURLGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        List list = null;
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            list = this.dataset.getRowKeys();
        } else if (this.dataExtractOrder == TableOrder.BY_COLUMN) {
            list = this.dataset.getColumnKeys();
        }
        if (list == null) return legendItemCollection;
        int n2 = 0;
        Iterator iterator = list.iterator();
        Shape shape = this.getLegendItemShape();
        while (iterator.hasNext()) {
            String string;
            String string2 = string = iterator.next().toString();
            Paint paint = this.getSeriesPaint(n2);
            Paint paint2 = this.getSeriesOutlinePaint(n2);
            Stroke stroke = this.getSeriesOutlineStroke(n2);
            LegendItem legendItem = new LegendItem(string, string2, null, null, shape, paint, stroke, paint2);
            legendItemCollection.add(legendItem);
            ++n2;
        }
        return legendItemCollection;
    }

    protected Point2D getWebPoint(Rectangle2D rectangle2D, double d2, double d3) {
        double d4 = Math.toRadians(d2);
        double d5 = Math.cos(d4) * d3 * rectangle2D.getWidth() / 2.0;
        double d6 = (- Math.sin(d4)) * d3 * rectangle2D.getHeight() / 2.0;
        return new Point2D.Double(rectangle2D.getX() + d5 + rectangle2D.getWidth() / 2.0, rectangle2D.getY() + d6 + rectangle2D.getHeight() / 2.0);
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
            plotRenderingInfo.setDataArea(rectangle2D);
        }
        this.drawBackground(graphics2D, rectangle2D);
        this.drawOutline(graphics2D, rectangle2D);
        Shape shape = graphics2D.getClip();
        graphics2D.clip(rectangle2D);
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
        if (!DatasetUtilities.isEmptyOrNull(this.dataset)) {
            int n2;
            int n3 = 0;
            int n4 = 0;
            if (this.dataExtractOrder == TableOrder.BY_ROW) {
                n3 = this.dataset.getRowCount();
                n4 = this.dataset.getColumnCount();
            } else {
                n3 = this.dataset.getColumnCount();
                n4 = this.dataset.getRowCount();
            }
            if (this.maxValue == -1.0) {
                this.calculateMaxValue(n3, n4);
            }
            double d2 = rectangle2D.getWidth() * this.getInteriorGap();
            double d3 = rectangle2D.getHeight() * this.getInteriorGap();
            double d4 = rectangle2D.getX() + d2 / 2.0;
            double d5 = rectangle2D.getY() + d3 / 2.0;
            double d6 = rectangle2D.getWidth() - d2;
            double d7 = rectangle2D.getHeight() - d3;
            double d8 = rectangle2D.getWidth() * this.headPercent;
            double d9 = rectangle2D.getHeight() * this.headPercent;
            double d10 = Math.min(d6, d7) / 2.0;
            d4 = (d4 + d4 + d6) / 2.0 - d10;
            d5 = (d5 + d5 + d7) / 2.0 - d10;
            d6 = 2.0 * d10;
            d7 = 2.0 * d10;
            Point2D.Double double_ = new Point2D.Double(d4 + d6 / 2.0, d5 + d7 / 2.0);
            Rectangle2D.Double double_2 = new Rectangle2D.Double(d4, d5, d6, d7);
            for (n2 = 0; n2 < n4; ++n2) {
                double d11 = this.getStartAngle() + this.getDirection().getFactor() * (double)n2 * 360.0 / (double)n4;
                Point2D point2D2 = this.getWebPoint(double_2, d11, 1.0);
                Line2D.Double double_3 = new Line2D.Double(double_, point2D2);
                graphics2D.setPaint(this.axisLinePaint);
                graphics2D.setStroke(this.axisLineStroke);
                graphics2D.draw(double_3);
                this.drawLabel(graphics2D, double_2, 0.0, n2, d11, 360.0 / (double)n4);
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.drawRadarPoly(graphics2D, double_2, double_, plotRenderingInfo, n2, n4, d9, d8);
            }
        } else {
            this.drawNoDataMessage(graphics2D, rectangle2D);
        }
        graphics2D.setClip(shape);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D);
    }

    private void calculateMaxValue(int n2, int n3) {
        double d2 = 0.0;
        Number number = null;
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n3; ++i2) {
                number = this.getPlotValue(n4, i2);
                if (number == null || (d2 = number.doubleValue()) <= this.maxValue) continue;
                this.maxValue = d2;
            }
            ++n4;
        }
    }

    protected void drawRadarPoly(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotRenderingInfo plotRenderingInfo, int n2, int n3, double d2, double d3) {
        Polygon polygon = new Polygon();
        EntityCollection entityCollection = null;
        if (plotRenderingInfo != null) {
            entityCollection = plotRenderingInfo.getOwner().getEntityCollection();
        }
        int n4 = 0;
        do {
            double d4;
            if (n4 >= n3) {
                Paint paint = this.getSeriesPaint(n2);
                graphics2D.setPaint(paint);
                graphics2D.setStroke(this.getSeriesOutlineStroke(n2));
                graphics2D.draw(polygon);
                if (!this.webFilled) return;
                graphics2D.setComposite(AlphaComposite.getInstance(3, 0.1f));
                graphics2D.fill(polygon);
                graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
                return;
            }
            Number number = this.getPlotValue(n2, n4);
            if (number != null && (d4 = number.doubleValue()) >= 0.0) {
                double d5 = this.getStartAngle() + this.getDirection().getFactor() * (double)n4 * 360.0 / (double)n3;
                Point2D point2D2 = this.getWebPoint(rectangle2D, d5, d4 / this.maxValue);
                polygon.addPoint((int)point2D2.getX(), (int)point2D2.getY());
                Paint paint = this.getSeriesPaint(n2);
                Paint paint2 = this.getSeriesOutlinePaint(n2);
                Stroke stroke = this.getSeriesOutlineStroke(n2);
                Ellipse2D.Double double_ = new Ellipse2D.Double(point2D2.getX() - d3 / 2.0, point2D2.getY() - d2 / 2.0, d3, d2);
                graphics2D.setPaint(paint);
                graphics2D.fill(double_);
                graphics2D.setStroke(stroke);
                graphics2D.setPaint(paint2);
                graphics2D.draw(double_);
                if (entityCollection != null) {
                    String string = null;
                    if (this.toolTipGenerator != null) {
                        string = this.toolTipGenerator.generateToolTip(this.dataset, n2, n4);
                    }
                    String string2 = null;
                    if (this.urlGenerator != null) {
                        string2 = this.urlGenerator.generateURL(this.dataset, n2, n4);
                    }
                    Rectangle rectangle = new Rectangle((int)(point2D2.getX() - d3), (int)(point2D2.getY() - d2), (int)(d3 * 2.0), (int)(d2 * 2.0));
                    CategoryItemEntity categoryItemEntity = new CategoryItemEntity(rectangle, string, string2, this.dataset, n2, this.dataset.getColumnKey(n4), n4);
                    entityCollection.add(categoryItemEntity);
                }
            }
            ++n4;
        } while (true);
    }

    protected Number getPlotValue(int n2, int n3) {
        Number number = null;
        if (this.dataExtractOrder == TableOrder.BY_ROW) {
            return this.dataset.getValue(n2, n3);
        }
        if (this.dataExtractOrder != TableOrder.BY_COLUMN) return number;
        return this.dataset.getValue(n3, n2);
    }

    protected void drawLabel(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, int n2, double d3, double d4) {
        FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
        String string = null;
        string = this.dataExtractOrder == TableOrder.BY_ROW ? this.labelGenerator.generateColumnLabel(this.dataset, n2) : this.labelGenerator.generateRowLabel(this.dataset, n2);
        Rectangle2D rectangle2D2 = this.getLabelFont().getStringBounds(string, fontRenderContext);
        LineMetrics lineMetrics = this.getLabelFont().getLineMetrics(string, fontRenderContext);
        double d5 = lineMetrics.getAscent();
        Point2D point2D = this.calculateLabelLocation(rectangle2D2, d5, rectangle2D, d3);
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        graphics2D.setPaint(this.getLabelPaint());
        graphics2D.setFont(this.getLabelFont());
        graphics2D.drawString(string, (float)point2D.getX(), (float)point2D.getY());
        graphics2D.setComposite(composite);
    }

    protected Point2D calculateLabelLocation(Rectangle2D rectangle2D, double d2, Rectangle2D rectangle2D2, double d3) {
        Arc2D.Double double_ = new Arc2D.Double(rectangle2D2, d3, 0.0, 0);
        Point2D point2D = double_.getEndPoint();
        double d4 = (- point2D.getX() - rectangle2D2.getCenterX()) * this.axisLabelGap;
        double d5 = (- point2D.getY() - rectangle2D2.getCenterY()) * this.axisLabelGap;
        double d6 = point2D.getX() - d4;
        double d7 = point2D.getY() - d5;
        if (d6 < rectangle2D2.getCenterX()) {
            d6 -= rectangle2D.getWidth();
        }
        if (d6 == rectangle2D2.getCenterX()) {
            d6 -= rectangle2D.getWidth() / 2.0;
        }
        if (d7 <= rectangle2D2.getCenterY()) return new Point2D.Double(d6, d7);
        d7 += d2;
        return new Point2D.Double(d6, d7);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SpiderWebPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        SpiderWebPlot spiderWebPlot = (SpiderWebPlot)object;
        if (!this.dataExtractOrder.equals(spiderWebPlot.dataExtractOrder)) {
            return false;
        }
        if (this.headPercent != spiderWebPlot.headPercent) {
            return false;
        }
        if (this.interiorGap != spiderWebPlot.interiorGap) {
            return false;
        }
        if (this.startAngle != spiderWebPlot.startAngle) {
            return false;
        }
        if (!this.direction.equals(spiderWebPlot.direction)) {
            return false;
        }
        if (this.maxValue != spiderWebPlot.maxValue) {
            return false;
        }
        if (this.webFilled != spiderWebPlot.webFilled) {
            return false;
        }
        if (this.axisLabelGap != spiderWebPlot.axisLabelGap) {
            return false;
        }
        if (!PaintUtilities.equal(this.axisLinePaint, spiderWebPlot.axisLinePaint)) {
            return false;
        }
        if (!this.axisLineStroke.equals(spiderWebPlot.axisLineStroke)) {
            return false;
        }
        if (!ShapeUtilities.equal(this.legendItemShape, spiderWebPlot.legendItemShape)) {
            return false;
        }
        if (!PaintUtilities.equal(this.seriesPaint, spiderWebPlot.seriesPaint)) {
            return false;
        }
        if (!this.seriesPaintList.equals(spiderWebPlot.seriesPaintList)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseSeriesPaint, spiderWebPlot.baseSeriesPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.seriesOutlinePaint, spiderWebPlot.seriesOutlinePaint)) {
            return false;
        }
        if (!this.seriesOutlinePaintList.equals(spiderWebPlot.seriesOutlinePaintList)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseSeriesOutlinePaint, spiderWebPlot.baseSeriesOutlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesOutlineStroke, spiderWebPlot.seriesOutlineStroke)) {
            return false;
        }
        if (!this.seriesOutlineStrokeList.equals(spiderWebPlot.seriesOutlineStrokeList)) {
            return false;
        }
        if (!this.baseSeriesOutlineStroke.equals(spiderWebPlot.baseSeriesOutlineStroke)) {
            return false;
        }
        if (!this.labelFont.equals(spiderWebPlot.labelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelPaint, spiderWebPlot.labelPaint)) {
            return false;
        }
        if (!this.labelGenerator.equals(spiderWebPlot.labelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipGenerator, spiderWebPlot.toolTipGenerator)) {
            return false;
        }
        if (ObjectUtilities.equal(this.urlGenerator, spiderWebPlot.urlGenerator)) return true;
        return false;
    }

    @Override
    public Object clone() {
        SpiderWebPlot spiderWebPlot = (SpiderWebPlot)super.clone();
        spiderWebPlot.legendItemShape = ShapeUtilities.clone(this.legendItemShape);
        spiderWebPlot.seriesPaintList = (PaintList)this.seriesPaintList.clone();
        spiderWebPlot.seriesOutlinePaintList = (PaintList)this.seriesOutlinePaintList.clone();
        spiderWebPlot.seriesOutlineStrokeList = (StrokeList)this.seriesOutlineStrokeList.clone();
        return spiderWebPlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
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

    private void readObject(ObjectInputStream objectInputStream) {
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
        if (this.dataset == null) return;
        this.dataset.addChangeListener(this);
    }
}

