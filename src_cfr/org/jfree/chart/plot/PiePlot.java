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
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.PaintMap;
import org.jfree.chart.StrokeMap;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PieLabelDistributor;
import org.jfree.chart.plot.PieLabelRecord;
import org.jfree.chart.plot.PiePlotState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBox;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;

public class PiePlot
extends Plot
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -795612466005590431L;
    public static final double DEFAULT_INTERIOR_GAP = 0.25;
    public static final double MAX_INTERIOR_GAP = 0.4;
    public static final double DEFAULT_START_ANGLE = 90.0;
    public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_LABEL_PAINT = Color.black;
    public static final Paint DEFAULT_LABEL_BACKGROUND_PAINT = new Color(255, 255, 192);
    public static final Paint DEFAULT_LABEL_OUTLINE_PAINT = Color.black;
    public static final Stroke DEFAULT_LABEL_OUTLINE_STROKE = new BasicStroke(0.5f);
    public static final Paint DEFAULT_LABEL_SHADOW_PAINT = Color.lightGray;
    public static final double DEFAULT_MINIMUM_ARC_ANGLE_TO_DRAW = 1.0E-5;
    private PieDataset dataset;
    private int pieIndex;
    private double interiorGap;
    private boolean circular;
    private double startAngle;
    private Rotation direction;
    private transient Paint sectionPaint;
    private PaintMap sectionPaintMap;
    private transient Paint baseSectionPaint;
    private boolean sectionOutlinesVisible;
    private transient Paint sectionOutlinePaint;
    private PaintMap sectionOutlinePaintMap;
    private transient Paint baseSectionOutlinePaint;
    private transient Stroke sectionOutlineStroke;
    private StrokeMap sectionOutlineStrokeMap;
    private transient Stroke baseSectionOutlineStroke;
    private transient Paint shadowPaint = Color.gray;
    private double shadowXOffset = 4.0;
    private double shadowYOffset = 4.0;
    private Map explodePercentages;
    private PieSectionLabelGenerator labelGenerator;
    private Font labelFont;
    private transient Paint labelPaint;
    private transient Paint labelBackgroundPaint;
    private transient Paint labelOutlinePaint;
    private transient Stroke labelOutlineStroke;
    private transient Paint labelShadowPaint;
    private double maximumLabelWidth = 0.2;
    private double labelGap = 0.05;
    private boolean labelLinksVisible;
    private double labelLinkMargin = 0.05;
    private transient Paint labelLinkPaint = Color.black;
    private transient Stroke labelLinkStroke = new BasicStroke(0.5f);
    private PieToolTipGenerator toolTipGenerator;
    private PieURLGenerator urlGenerator;
    private PieSectionLabelGenerator legendLabelGenerator;
    private PieSectionLabelGenerator legendLabelToolTipGenerator;
    private PieURLGenerator legendLabelURLGenerator;
    private boolean ignoreNullValues;
    private boolean ignoreZeroValues;
    private transient Shape legendItemShape;
    private double minimumArcAngleToDraw;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

    public PiePlot() {
        this(null);
    }

    public PiePlot(PieDataset pieDataset) {
        this.dataset = pieDataset;
        if (pieDataset != null) {
            pieDataset.addChangeListener(this);
        }
        this.pieIndex = 0;
        this.interiorGap = 0.25;
        this.circular = true;
        this.startAngle = 90.0;
        this.direction = Rotation.CLOCKWISE;
        this.minimumArcAngleToDraw = 1.0E-5;
        this.sectionPaint = null;
        this.sectionPaintMap = new PaintMap();
        this.baseSectionPaint = Color.gray;
        this.sectionOutlinesVisible = true;
        this.sectionOutlinePaint = null;
        this.sectionOutlinePaintMap = new PaintMap();
        this.baseSectionOutlinePaint = DEFAULT_OUTLINE_PAINT;
        this.sectionOutlineStroke = null;
        this.sectionOutlineStrokeMap = new StrokeMap();
        this.baseSectionOutlineStroke = DEFAULT_OUTLINE_STROKE;
        this.explodePercentages = new TreeMap();
        this.labelGenerator = new StandardPieSectionLabelGenerator();
        this.labelFont = DEFAULT_LABEL_FONT;
        this.labelPaint = DEFAULT_LABEL_PAINT;
        this.labelBackgroundPaint = DEFAULT_LABEL_BACKGROUND_PAINT;
        this.labelOutlinePaint = DEFAULT_LABEL_OUTLINE_PAINT;
        this.labelOutlineStroke = DEFAULT_LABEL_OUTLINE_STROKE;
        this.labelShadowPaint = DEFAULT_LABEL_SHADOW_PAINT;
        this.labelLinksVisible = true;
        this.toolTipGenerator = null;
        this.urlGenerator = null;
        this.legendLabelGenerator = new StandardPieSectionLabelGenerator();
        this.legendLabelToolTipGenerator = null;
        this.legendLabelURLGenerator = null;
        this.legendItemShape = Plot.DEFAULT_LEGEND_ITEM_CIRCLE;
        this.ignoreNullValues = false;
        this.ignoreZeroValues = false;
    }

    public PieDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(PieDataset pieDataset) {
        PieDataset pieDataset2 = this.dataset;
        if (pieDataset2 != null) {
            pieDataset2.removeChangeListener(this);
        }
        this.dataset = pieDataset;
        if (pieDataset != null) {
            this.setDatasetGroup(pieDataset.getGroup());
            pieDataset.addChangeListener(this);
        }
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, pieDataset);
        this.datasetChanged(datasetChangeEvent);
    }

    public int getPieIndex() {
        return this.pieIndex;
    }

    public void setPieIndex(int n2) {
        this.pieIndex = n2;
    }

    public double getStartAngle() {
        return this.startAngle;
    }

    public void setStartAngle(double d2) {
        this.startAngle = d2;
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
        if (d2 < 0.0) throw new IllegalArgumentException(new StringBuffer().append("Invalid 'percent' (").append(d2).append(") argument.").toString());
        if (d2 > 0.4) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid 'percent' (").append(d2).append(") argument.").toString());
        }
        if (this.interiorGap == d2) return;
        this.interiorGap = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isCircular() {
        return this.circular;
    }

    public void setCircular(boolean bl2) {
        this.setCircular(bl2, true);
    }

    public void setCircular(boolean bl2, boolean bl3) {
        this.circular = bl2;
        if (!bl3) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getIgnoreNullValues() {
        return this.ignoreNullValues;
    }

    public void setIgnoreNullValues(boolean bl2) {
        this.ignoreNullValues = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getIgnoreZeroValues() {
        return this.ignoreZeroValues;
    }

    public void setIgnoreZeroValues(boolean bl2) {
        this.ignoreZeroValues = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected Paint lookupSectionPaint(Comparable comparable) {
        return this.lookupSectionPaint(comparable, false);
    }

    protected Paint lookupSectionPaint(Comparable comparable, boolean bl2) {
        Paint paint = this.getSectionPaint();
        if (paint != null) {
            return paint;
        }
        paint = this.sectionPaintMap.getPaint(comparable);
        if (paint != null) {
            return paint;
        }
        if (!bl2) {
            return this.baseSectionPaint;
        }
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseSectionPaint;
        paint = drawingSupplier.getNextPaint();
        this.sectionPaintMap.put(comparable, paint);
        return paint;
    }

    public Paint getSectionPaint() {
        return this.sectionPaint;
    }

    public void setSectionPaint(Paint paint) {
        this.sectionPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected Comparable getSectionKey(int n2) {
        Comparable comparable = null;
        if (this.dataset == null) return new Integer(n2);
        if (n2 >= 0 && n2 < this.dataset.getItemCount()) {
            comparable = this.dataset.getKey(n2);
        }
        if (comparable != null) return comparable;
        return new Integer(n2);
    }

    public Paint getSectionPaint(Comparable comparable) {
        return this.sectionPaintMap.getPaint(comparable);
    }

    public void setSectionPaint(Comparable comparable, Paint paint) {
        this.sectionPaintMap.put(comparable, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getBaseSectionPaint() {
        return this.baseSectionPaint;
    }

    public void setBaseSectionPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSectionPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getSectionOutlinesVisible() {
        return this.sectionOutlinesVisible;
    }

    public void setSectionOutlinesVisible(boolean bl2) {
        this.sectionOutlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected Paint lookupSectionOutlinePaint(Comparable comparable) {
        return this.lookupSectionOutlinePaint(comparable, false);
    }

    protected Paint lookupSectionOutlinePaint(Comparable comparable, boolean bl2) {
        Paint paint = this.getSectionOutlinePaint();
        if (paint != null) {
            return paint;
        }
        paint = this.sectionOutlinePaintMap.getPaint(comparable);
        if (paint != null) {
            return paint;
        }
        if (!bl2) {
            return this.baseSectionOutlinePaint;
        }
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseSectionOutlinePaint;
        paint = drawingSupplier.getNextOutlinePaint();
        this.sectionOutlinePaintMap.put(comparable, paint);
        return paint;
    }

    public Paint getSectionOutlinePaint() {
        return this.sectionOutlinePaint;
    }

    public void setSectionOutlinePaint(Paint paint) {
        this.sectionOutlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getSectionOutlinePaint(Comparable comparable) {
        return this.sectionOutlinePaintMap.getPaint(comparable);
    }

    public void setSectionOutlinePaint(Comparable comparable, Paint paint) {
        this.sectionOutlinePaintMap.put(comparable, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getBaseSectionOutlinePaint() {
        return this.baseSectionOutlinePaint;
    }

    public void setBaseSectionOutlinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSectionOutlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    protected Stroke lookupSectionOutlineStroke(Comparable comparable) {
        return this.lookupSectionOutlineStroke(comparable, false);
    }

    protected Stroke lookupSectionOutlineStroke(Comparable comparable, boolean bl2) {
        Stroke stroke = this.getSectionOutlineStroke();
        if (stroke != null) {
            return stroke;
        }
        stroke = this.sectionOutlineStrokeMap.getStroke(comparable);
        if (stroke != null) {
            return stroke;
        }
        if (!bl2) {
            return this.baseSectionOutlineStroke;
        }
        DrawingSupplier drawingSupplier = this.getDrawingSupplier();
        if (drawingSupplier == null) return this.baseSectionOutlineStroke;
        stroke = drawingSupplier.getNextOutlineStroke();
        this.sectionOutlineStrokeMap.put(comparable, stroke);
        return stroke;
    }

    public Stroke getSectionOutlineStroke() {
        return this.sectionOutlineStroke;
    }

    public void setSectionOutlineStroke(Stroke stroke) {
        this.sectionOutlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getSectionOutlineStroke(Comparable comparable) {
        return this.sectionOutlineStrokeMap.getStroke(comparable);
    }

    public void setSectionOutlineStroke(Comparable comparable, Stroke stroke) {
        this.sectionOutlineStrokeMap.put(comparable, stroke);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getBaseSectionOutlineStroke() {
        return this.baseSectionOutlineStroke;
    }

    public void setBaseSectionOutlineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseSectionOutlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowPaint(Paint paint) {
        this.shadowPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getShadowXOffset() {
        return this.shadowXOffset;
    }

    public void setShadowXOffset(double d2) {
        this.shadowXOffset = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getShadowYOffset() {
        return this.shadowYOffset;
    }

    public void setShadowYOffset(double d2) {
        this.shadowYOffset = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getExplodePercent(Comparable comparable) {
        double d2 = 0.0;
        if (this.explodePercentages == null) return d2;
        Number number = (Number)this.explodePercentages.get(comparable);
        if (number == null) return d2;
        return number.doubleValue();
    }

    public void setExplodePercent(Comparable comparable, double d2) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        if (this.explodePercentages == null) {
            this.explodePercentages = new TreeMap();
        }
        this.explodePercentages.put(comparable, new Double(d2));
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getMaximumExplodePercent() {
        double d2 = 0.0;
        Iterator iterator = this.dataset.getKeys().iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            Number number = (Number)this.explodePercentages.get(comparable);
            if (number == null) continue;
            d2 = Math.max(d2, number.doubleValue());
        }
        return d2;
    }

    public PieSectionLabelGenerator getLabelGenerator() {
        return this.labelGenerator;
    }

    public void setLabelGenerator(PieSectionLabelGenerator pieSectionLabelGenerator) {
        this.labelGenerator = pieSectionLabelGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getLabelGap() {
        return this.labelGap;
    }

    public void setLabelGap(double d2) {
        this.labelGap = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getMaximumLabelWidth() {
        return this.maximumLabelWidth;
    }

    public void setMaximumLabelWidth(double d2) {
        this.maximumLabelWidth = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getLabelLinksVisible() {
        return this.labelLinksVisible;
    }

    public void setLabelLinksVisible(boolean bl2) {
        this.labelLinksVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getLabelLinkMargin() {
        return this.labelLinkMargin;
    }

    public void setLabelLinkMargin(double d2) {
        this.labelLinkMargin = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getLabelLinkPaint() {
        return this.labelLinkPaint;
    }

    public void setLabelLinkPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelLinkPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getLabelLinkStroke() {
        return this.labelLinkStroke;
    }

    public void setLabelLinkStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.labelLinkStroke = stroke;
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

    public Paint getLabelBackgroundPaint() {
        return this.labelBackgroundPaint;
    }

    public void setLabelBackgroundPaint(Paint paint) {
        this.labelBackgroundPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getLabelOutlinePaint() {
        return this.labelOutlinePaint;
    }

    public void setLabelOutlinePaint(Paint paint) {
        this.labelOutlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getLabelOutlineStroke() {
        return this.labelOutlineStroke;
    }

    public void setLabelOutlineStroke(Stroke stroke) {
        this.labelOutlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getLabelShadowPaint() {
        return this.labelShadowPaint;
    }

    public void setLabelShadowPaint(Paint paint) {
        this.labelShadowPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public PieToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }

    public void setToolTipGenerator(PieToolTipGenerator pieToolTipGenerator) {
        this.toolTipGenerator = pieToolTipGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public PieURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }

    public void setURLGenerator(PieURLGenerator pieURLGenerator) {
        this.urlGenerator = pieURLGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getMinimumArcAngleToDraw() {
        return this.minimumArcAngleToDraw;
    }

    public void setMinimumArcAngleToDraw(double d2) {
        this.minimumArcAngleToDraw = d2;
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

    public PieSectionLabelGenerator getLegendLabelGenerator() {
        return this.legendLabelGenerator;
    }

    public void setLegendLabelGenerator(PieSectionLabelGenerator pieSectionLabelGenerator) {
        if (pieSectionLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.legendLabelGenerator = pieSectionLabelGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public PieSectionLabelGenerator getLegendLabelToolTipGenerator() {
        return this.legendLabelToolTipGenerator;
    }

    public void setLegendLabelToolTipGenerator(PieSectionLabelGenerator pieSectionLabelGenerator) {
        this.legendLabelToolTipGenerator = pieSectionLabelGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public PieURLGenerator getLegendLabelURLGenerator() {
        return this.legendLabelURLGenerator;
    }

    public void setLegendLabelURLGenerator(PieURLGenerator pieURLGenerator) {
        this.legendLabelURLGenerator = pieURLGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public PiePlotState initialise(Graphics2D graphics2D, Rectangle2D rectangle2D, PiePlot piePlot, Integer n2, PlotRenderingInfo plotRenderingInfo) {
        PiePlotState piePlotState = new PiePlotState(plotRenderingInfo);
        piePlotState.setPassesRequired(2);
        piePlotState.setTotal(DatasetUtilities.calculatePieDatasetTotal(piePlot.getDataset()));
        piePlotState.setLatestAngle(piePlot.getStartAngle());
        return piePlotState;
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
            this.drawPie(graphics2D, rectangle2D, plotRenderingInfo);
        } else {
            this.drawNoDataMessage(graphics2D, rectangle2D);
        }
        graphics2D.setClip(shape);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D);
    }

    protected void drawPie(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo) {
        PiePlotState piePlotState = this.initialise(graphics2D, rectangle2D, this, null, plotRenderingInfo);
        double d2 = 0.0;
        if (this.labelGenerator != null) {
            d2 = this.labelGap + this.maximumLabelWidth + this.labelLinkMargin;
        }
        double d3 = rectangle2D.getWidth() * (this.interiorGap + d2);
        double d4 = rectangle2D.getHeight() * this.interiorGap;
        double d5 = rectangle2D.getX() + d3 / 2.0;
        double d6 = rectangle2D.getY() + d4 / 2.0;
        double d7 = rectangle2D.getWidth() - d3;
        double d8 = rectangle2D.getHeight() - d4;
        if (this.circular) {
            double d9 = Math.min(d7, d8) / 2.0;
            d5 = (d5 + d5 + d7) / 2.0 - d9;
            d6 = (d6 + d6 + d8) / 2.0 - d9;
            d7 = 2.0 * d9;
            d8 = 2.0 * d9;
        }
        Rectangle2D.Double double_ = new Rectangle2D.Double(d5, d6, d7, d8);
        piePlotState.setLinkArea(double_);
        double d10 = double_.getWidth() * this.labelLinkMargin;
        double d11 = double_.getHeight() * this.labelLinkMargin;
        Rectangle2D.Double double_2 = new Rectangle2D.Double(d5 + d10 / 2.0, d6 + d11 / 2.0, d7 - d10, d8 - d11);
        piePlotState.setExplodedPieArea(double_2);
        double d12 = this.getMaximumExplodePercent();
        double d13 = d12 / (1.0 + d12);
        double d14 = double_2.getWidth() * d13;
        double d15 = double_2.getHeight() * d13;
        Rectangle2D.Double double_3 = new Rectangle2D.Double(double_2.getX() + d14 / 2.0, double_2.getY() + d15 / 2.0, double_2.getWidth() - d14, double_2.getHeight() - d15);
        piePlotState.setPieArea(double_3);
        piePlotState.setPieCenterX(double_3.getCenterX());
        piePlotState.setPieCenterY(double_3.getCenterY());
        piePlotState.setPieWRadius(double_3.getWidth() / 2.0);
        piePlotState.setPieHRadius(double_3.getHeight() / 2.0);
        if (this.dataset == null || this.dataset.getKeys().size() <= 0) {
            this.drawNoDataMessage(graphics2D, rectangle2D);
            return;
        }
        List list = this.dataset.getKeys();
        double d16 = DatasetUtilities.calculatePieDatasetTotal(this.dataset);
        int n2 = piePlotState.getPassesRequired();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.drawLabels(graphics2D, list, d16, rectangle2D, double_, piePlotState);
                return;
            }
            double d17 = 0.0;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                double d18;
                Number number = this.dataset.getValue(i2);
                if (number == null || (d18 = number.doubleValue()) <= 0.0) continue;
                d17 += d18;
                this.drawItem(graphics2D, i2, double_2, piePlotState, n3);
            }
            ++n3;
        } while (true);
    }

    protected void drawItem(Graphics2D graphics2D, int n2, Rectangle2D rectangle2D, PiePlotState piePlotState, int n3) {
        Number number = this.dataset.getValue(n2);
        if (number == null) {
            return;
        }
        double d2 = number.doubleValue();
        double d3 = 0.0;
        double d4 = 0.0;
        if (this.direction == Rotation.CLOCKWISE) {
            d3 = piePlotState.getLatestAngle();
            d4 = d3 - d2 / piePlotState.getTotal() * 360.0;
        } else {
            if (this.direction != Rotation.ANTICLOCKWISE) throw new IllegalStateException("Rotation type not recognised.");
            d3 = piePlotState.getLatestAngle();
            d4 = d3 + d2 / piePlotState.getTotal() * 360.0;
        }
        double d5 = d4 - d3;
        if (Math.abs(d5) > this.getMinimumArcAngleToDraw()) {
            double d6 = 0.0;
            double d7 = this.getMaximumExplodePercent();
            if (d7 > 0.0) {
                d6 = this.getExplodePercent(n2) / d7;
            }
            Rectangle2D rectangle2D2 = this.getArcBounds(piePlotState.getPieArea(), piePlotState.getExplodedPieArea(), d3, d5, d6);
            Arc2D.Double double_ = new Arc2D.Double(rectangle2D2, d3, d5, 2);
            if (n3 == 0) {
                if (this.shadowPaint != null) {
                    Shape shape = ShapeUtilities.createTranslatedShape(double_, (float)this.shadowXOffset, (float)this.shadowYOffset);
                    graphics2D.setPaint(this.shadowPaint);
                    graphics2D.fill(shape);
                }
            } else if (n3 == 1) {
                EntityCollection entityCollection;
                Comparable comparable = this.getSectionKey(n2);
                Paint paint = this.lookupSectionPaint(comparable, true);
                graphics2D.setPaint(paint);
                graphics2D.fill(double_);
                Paint paint2 = this.lookupSectionOutlinePaint(comparable);
                Stroke stroke = this.lookupSectionOutlineStroke(comparable);
                if (this.sectionOutlinesVisible) {
                    graphics2D.setPaint(paint2);
                    graphics2D.setStroke(stroke);
                    graphics2D.draw(double_);
                }
                if (piePlotState.getInfo() != null && (entityCollection = piePlotState.getEntityCollection()) != null) {
                    String string = null;
                    if (this.toolTipGenerator != null) {
                        string = this.toolTipGenerator.generateToolTip(this.dataset, comparable);
                    }
                    String string2 = null;
                    if (this.urlGenerator != null) {
                        string2 = this.urlGenerator.generateURL(this.dataset, comparable, this.pieIndex);
                    }
                    PieSectionEntity pieSectionEntity = new PieSectionEntity(double_, this.dataset, this.pieIndex, n2, comparable, string, string2);
                    entityCollection.add(pieSectionEntity);
                }
            }
        }
        piePlotState.setLatestAngle(d4);
    }

    protected void drawLabels(Graphics2D graphics2D, List list, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, PiePlotState piePlotState) {
        Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        double d3 = 0.0;
        for (Comparable comparable : list) {
            boolean bl2 = true;
            double d4 = 0.0;
            Number number = this.dataset.getValue(comparable);
            if (number == null) {
                bl2 = !this.ignoreNullValues;
            } else {
                d4 = number.doubleValue();
                boolean bl3 = this.ignoreZeroValues ? d4 > 0.0 : (bl2 = d4 >= 0.0);
            }
            if (!bl2) continue;
            double d5 = this.startAngle + this.direction.getFactor() * (((d3 += d4) - d4 / 2.0) * 360.0) / d2;
            if (Math.cos(Math.toRadians(d5)) < 0.0) {
                defaultKeyedValues.addValue(comparable, new Double(d5));
                continue;
            }
            defaultKeyedValues2.addValue(comparable, new Double(d5));
        }
        graphics2D.setFont(this.getLabelFont());
        float f2 = (float)(this.getMaximumLabelWidth() * rectangle2D.getWidth());
        if (this.labelGenerator != null) {
            this.drawLeftLabels(defaultKeyedValues, graphics2D, rectangle2D, rectangle2D2, f2, piePlotState);
            this.drawRightLabels(defaultKeyedValues2, graphics2D, rectangle2D, rectangle2D2, f2, piePlotState);
        }
        graphics2D.setComposite(composite);
    }

    protected void drawLeftLabels(KeyedValues keyedValues, Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, float f2, PiePlotState piePlotState) {
        int n2;
        PieLabelDistributor pieLabelDistributor = new PieLabelDistributor(keyedValues.getItemCount());
        double d2 = rectangle2D.getWidth() * this.labelGap;
        double d3 = piePlotState.getLinkArea().getHeight() / 2.0;
        for (n2 = 0; n2 < keyedValues.getItemCount(); ++n2) {
            String string = this.labelGenerator.generateSectionLabel(this.dataset, keyedValues.getKey(n2));
            if (string == null) continue;
            TextBlock textBlock = TextUtilities.createTextBlock(string, this.labelFont, this.labelPaint, f2, new G2TextMeasurer(graphics2D));
            TextBox textBox = new TextBox(textBlock);
            textBox.setBackgroundPaint(this.labelBackgroundPaint);
            textBox.setOutlinePaint(this.labelOutlinePaint);
            textBox.setOutlineStroke(this.labelOutlineStroke);
            textBox.setShadowPaint(this.labelShadowPaint);
            double d4 = Math.toRadians(keyedValues.getValue(n2).doubleValue());
            double d5 = piePlotState.getPieCenterY() - Math.sin(d4) * d3;
            double d6 = textBox.getHeight(graphics2D);
            pieLabelDistributor.addPieLabelRecord(new PieLabelRecord(keyedValues.getKey(n2), d4, d5, textBox, d6, d2 / 2.0 + d2 / 2.0 * (- Math.cos(d4)), 0.9 + this.getExplodePercent(this.dataset.getIndex(keyedValues.getKey(n2)))));
        }
        pieLabelDistributor.distributeLabels(rectangle2D.getMinY(), rectangle2D.getHeight());
        n2 = 0;
        while (n2 < pieLabelDistributor.getItemCount()) {
            this.drawLeftLabel(graphics2D, piePlotState, pieLabelDistributor.getPieLabelRecord(n2));
            ++n2;
        }
    }

    protected void drawRightLabels(KeyedValues keyedValues, Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, float f2, PiePlotState piePlotState) {
        int n2;
        PieLabelDistributor pieLabelDistributor = new PieLabelDistributor(keyedValues.getItemCount());
        double d2 = rectangle2D.getWidth() * this.labelGap;
        double d3 = piePlotState.getLinkArea().getHeight() / 2.0;
        for (n2 = 0; n2 < keyedValues.getItemCount(); ++n2) {
            String string = this.labelGenerator.generateSectionLabel(this.dataset, keyedValues.getKey(n2));
            if (string == null) continue;
            TextBlock textBlock = TextUtilities.createTextBlock(string, this.labelFont, this.labelPaint, f2, new G2TextMeasurer(graphics2D));
            TextBox textBox = new TextBox(textBlock);
            textBox.setBackgroundPaint(this.labelBackgroundPaint);
            textBox.setOutlinePaint(this.labelOutlinePaint);
            textBox.setOutlineStroke(this.labelOutlineStroke);
            textBox.setShadowPaint(this.labelShadowPaint);
            double d4 = Math.toRadians(keyedValues.getValue(n2).doubleValue());
            double d5 = piePlotState.getPieCenterY() - Math.sin(d4) * d3;
            double d6 = textBox.getHeight(graphics2D);
            pieLabelDistributor.addPieLabelRecord(new PieLabelRecord(keyedValues.getKey(n2), d4, d5, textBox, d6, d2 / 2.0 + d2 / 2.0 * Math.cos(d4), 0.9 + this.getExplodePercent(this.dataset.getIndex(keyedValues.getKey(n2)))));
        }
        pieLabelDistributor.distributeLabels(rectangle2D.getMinY(), rectangle2D.getHeight());
        n2 = 0;
        while (n2 < pieLabelDistributor.getItemCount()) {
            this.drawRightLabel(graphics2D, piePlotState, pieLabelDistributor.getPieLabelRecord(n2));
            ++n2;
        }
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        if (this.dataset == null) {
            return legendItemCollection;
        }
        List list = this.dataset.getKeys();
        int n2 = 0;
        Shape shape = this.getLegendItemShape();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            Number number = this.dataset.getValue(comparable);
            boolean bl2 = true;
            if (number == null) {
                bl2 = !this.ignoreNullValues;
            } else {
                double d2 = number.doubleValue();
                if (d2 == 0.0) {
                    bl2 = !this.ignoreZeroValues;
                } else {
                    boolean bl3 = bl2 = d2 > 0.0;
                }
            }
            if (bl2) {
                String string;
                String string2 = string = this.legendLabelGenerator.generateSectionLabel(this.dataset, comparable);
                String string3 = null;
                if (this.legendLabelToolTipGenerator != null) {
                    string3 = this.legendLabelToolTipGenerator.generateSectionLabel(this.dataset, comparable);
                }
                String string4 = null;
                if (this.legendLabelURLGenerator != null) {
                    string4 = this.legendLabelURLGenerator.generateURL(this.dataset, comparable, this.pieIndex);
                }
                Paint paint = this.lookupSectionPaint(comparable, true);
                Paint paint2 = this.lookupSectionOutlinePaint(comparable);
                Stroke stroke = this.lookupSectionOutlineStroke(comparable);
                LegendItem legendItem = new LegendItem(string, string2, string3, string4, true, shape, true, paint, true, paint2, stroke, false, (Shape)new Line2D.Float(), (Stroke)new BasicStroke(), (Paint)Color.black);
                legendItemCollection.add(legendItem);
                ++n2;
                continue;
            }
            ++n2;
        }
        return legendItemCollection;
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Pie_Plot");
    }

    @Override
    public void zoom(double d2) {
    }

    protected Rectangle2D getArcBounds(Rectangle2D rectangle2D, Rectangle2D rectangle2D2, double d2, double d3, double d4) {
        if (d4 == 0.0) {
            return rectangle2D;
        }
        Arc2D.Double double_ = new Arc2D.Double(rectangle2D, d2, d3 / 2.0, 0);
        Point2D point2D = double_.getEndPoint();
        Arc2D.Double double_2 = new Arc2D.Double(rectangle2D2, d2, d3 / 2.0, 0);
        Point2D point2D2 = double_2.getEndPoint();
        double d5 = (point2D.getX() - point2D2.getX()) * d4;
        double d6 = (point2D.getY() - point2D2.getY()) * d4;
        return new Rectangle2D.Double(rectangle2D.getX() - d5, rectangle2D.getY() - d6, rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    protected void drawLeftLabel(Graphics2D graphics2D, PiePlotState piePlotState, PieLabelRecord pieLabelRecord) {
        double d2 = piePlotState.getLinkArea().getMinX();
        double d3 = d2 - pieLabelRecord.getGap();
        double d4 = pieLabelRecord.getAllocatedY();
        if (this.labelLinksVisible) {
            double d5;
            double d6 = pieLabelRecord.getAngle();
            double d7 = piePlotState.getPieCenterX() + Math.cos(d6) * piePlotState.getPieWRadius() * pieLabelRecord.getLinkPercent();
            double d8 = piePlotState.getPieCenterY() - Math.sin(d6) * piePlotState.getPieHRadius() * pieLabelRecord.getLinkPercent();
            double d9 = piePlotState.getPieCenterX() + Math.cos(d6) * piePlotState.getLinkArea().getWidth() / 2.0;
            double d10 = d5 = piePlotState.getPieCenterY() - Math.sin(d6) * piePlotState.getLinkArea().getHeight() / 2.0;
            graphics2D.setPaint(this.labelLinkPaint);
            graphics2D.setStroke(this.labelLinkStroke);
            graphics2D.draw(new Line2D.Double(d7, d8, d9, d5));
            graphics2D.draw(new Line2D.Double(d2, d10, d9, d5));
            graphics2D.draw(new Line2D.Double(d2, d10, d3, d4));
        }
        TextBox textBox = pieLabelRecord.getLabel();
        textBox.draw(graphics2D, (float)d3, (float)d4, RectangleAnchor.RIGHT);
    }

    protected void drawRightLabel(Graphics2D graphics2D, PiePlotState piePlotState, PieLabelRecord pieLabelRecord) {
        double d2 = piePlotState.getLinkArea().getMaxX();
        double d3 = d2 + pieLabelRecord.getGap();
        double d4 = pieLabelRecord.getAllocatedY();
        if (this.labelLinksVisible) {
            double d5;
            double d6 = pieLabelRecord.getAngle();
            double d7 = piePlotState.getPieCenterX() + Math.cos(d6) * piePlotState.getPieWRadius() * pieLabelRecord.getLinkPercent();
            double d8 = piePlotState.getPieCenterY() - Math.sin(d6) * piePlotState.getPieHRadius() * pieLabelRecord.getLinkPercent();
            double d9 = piePlotState.getPieCenterX() + Math.cos(d6) * piePlotState.getLinkArea().getWidth() / 2.0;
            double d10 = d5 = piePlotState.getPieCenterY() - Math.sin(d6) * piePlotState.getLinkArea().getHeight() / 2.0;
            graphics2D.setPaint(this.labelLinkPaint);
            graphics2D.setStroke(this.labelLinkStroke);
            graphics2D.draw(new Line2D.Double(d7, d8, d9, d5));
            graphics2D.draw(new Line2D.Double(d2, d10, d9, d5));
            graphics2D.draw(new Line2D.Double(d2, d10, d3, d4));
        }
        TextBox textBox = pieLabelRecord.getLabel();
        textBox.draw(graphics2D, (float)d3, (float)d4, RectangleAnchor.LEFT);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PiePlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        PiePlot piePlot = (PiePlot)object;
        if (this.pieIndex != piePlot.pieIndex) {
            return false;
        }
        if (this.interiorGap != piePlot.interiorGap) {
            return false;
        }
        if (this.circular != piePlot.circular) {
            return false;
        }
        if (this.startAngle != piePlot.startAngle) {
            return false;
        }
        if (this.direction != piePlot.direction) {
            return false;
        }
        if (this.ignoreZeroValues != piePlot.ignoreZeroValues) {
            return false;
        }
        if (this.ignoreNullValues != piePlot.ignoreNullValues) {
            return false;
        }
        if (!PaintUtilities.equal(this.sectionPaint, piePlot.sectionPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.sectionPaintMap, piePlot.sectionPaintMap)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseSectionPaint, piePlot.baseSectionPaint)) {
            return false;
        }
        if (this.sectionOutlinesVisible != piePlot.sectionOutlinesVisible) {
            return false;
        }
        if (!PaintUtilities.equal(this.sectionOutlinePaint, piePlot.sectionOutlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.sectionOutlinePaintMap, piePlot.sectionOutlinePaintMap)) {
            return false;
        }
        if (!PaintUtilities.equal(this.baseSectionOutlinePaint, piePlot.baseSectionOutlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.sectionOutlineStroke, piePlot.sectionOutlineStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.sectionOutlineStrokeMap, piePlot.sectionOutlineStrokeMap)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.baseSectionOutlineStroke, piePlot.baseSectionOutlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.shadowPaint, piePlot.shadowPaint)) {
            return false;
        }
        if (this.shadowXOffset != piePlot.shadowXOffset) {
            return false;
        }
        if (this.shadowYOffset != piePlot.shadowYOffset) {
            return false;
        }
        if (!ObjectUtilities.equal(this.explodePercentages, piePlot.explodePercentages)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelGenerator, piePlot.labelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelFont, piePlot.labelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelPaint, piePlot.labelPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelBackgroundPaint, piePlot.labelBackgroundPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelOutlinePaint, piePlot.labelOutlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelOutlineStroke, piePlot.labelOutlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelShadowPaint, piePlot.labelShadowPaint)) {
            return false;
        }
        if (this.maximumLabelWidth != piePlot.maximumLabelWidth) {
            return false;
        }
        if (this.labelGap != piePlot.labelGap) {
            return false;
        }
        if (this.labelLinkMargin != piePlot.labelLinkMargin) {
            return false;
        }
        if (this.labelLinksVisible != piePlot.labelLinksVisible) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelLinkPaint, piePlot.labelLinkPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelLinkStroke, piePlot.labelLinkStroke)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.toolTipGenerator, piePlot.toolTipGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.urlGenerator, piePlot.urlGenerator)) {
            return false;
        }
        if (this.minimumArcAngleToDraw != piePlot.minimumArcAngleToDraw) {
            return false;
        }
        if (!ShapeUtilities.equal(this.legendItemShape, piePlot.legendItemShape)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.legendLabelGenerator, piePlot.legendLabelGenerator)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.legendLabelToolTipGenerator, piePlot.legendLabelToolTipGenerator)) {
            return false;
        }
        if (ObjectUtilities.equal(this.legendLabelURLGenerator, piePlot.legendLabelURLGenerator)) return true;
        return false;
    }

    @Override
    public Object clone() {
        PiePlot piePlot = (PiePlot)super.clone();
        if (piePlot.dataset != null) {
            piePlot.dataset.addChangeListener(piePlot);
        }
        if (this.urlGenerator instanceof PublicCloneable) {
            piePlot.urlGenerator = (PieURLGenerator)ObjectUtilities.clone(this.urlGenerator);
        }
        piePlot.legendItemShape = ShapeUtilities.clone(this.legendItemShape);
        if (this.legendLabelGenerator != null) {
            piePlot.legendLabelGenerator = (PieSectionLabelGenerator)ObjectUtilities.clone(this.legendLabelGenerator);
        }
        if (this.legendLabelToolTipGenerator != null) {
            piePlot.legendLabelToolTipGenerator = (PieSectionLabelGenerator)ObjectUtilities.clone(this.legendLabelToolTipGenerator);
        }
        if (!(this.legendLabelURLGenerator instanceof PublicCloneable)) return piePlot;
        piePlot.legendLabelURLGenerator = (PieURLGenerator)ObjectUtilities.clone(this.legendLabelURLGenerator);
        return piePlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.sectionPaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseSectionPaint, objectOutputStream);
        SerialUtilities.writePaint(this.sectionOutlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.baseSectionOutlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.sectionOutlineStroke, objectOutputStream);
        SerialUtilities.writeStroke(this.baseSectionOutlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.shadowPaint, objectOutputStream);
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
        SerialUtilities.writePaint(this.labelBackgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.labelOutlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.labelOutlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.labelShadowPaint, objectOutputStream);
        SerialUtilities.writePaint(this.labelLinkPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.labelLinkStroke, objectOutputStream);
        SerialUtilities.writeShape(this.legendItemShape, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.sectionPaint = SerialUtilities.readPaint(objectInputStream);
        this.baseSectionPaint = SerialUtilities.readPaint(objectInputStream);
        this.sectionOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.baseSectionOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.sectionOutlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.baseSectionOutlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.shadowPaint = SerialUtilities.readPaint(objectInputStream);
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
        this.labelBackgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.labelOutlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.labelOutlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.labelShadowPaint = SerialUtilities.readPaint(objectInputStream);
        this.labelLinkPaint = SerialUtilities.readPaint(objectInputStream);
        this.labelLinkStroke = SerialUtilities.readStroke(objectInputStream);
        this.legendItemShape = SerialUtilities.readShape(objectInputStream);
    }

    public Paint getSectionPaint(int n2) {
        Comparable comparable = this.getSectionKey(n2);
        return this.getSectionPaint(comparable);
    }

    public void setSectionPaint(int n2, Paint paint) {
        Comparable comparable = this.getSectionKey(n2);
        this.setSectionPaint(comparable, paint);
    }

    public Paint getSectionOutlinePaint(int n2) {
        Comparable comparable = this.getSectionKey(n2);
        return this.getSectionOutlinePaint(comparable);
    }

    public void setSectionOutlinePaint(int n2, Paint paint) {
        Comparable comparable = this.getSectionKey(n2);
        this.setSectionOutlinePaint(comparable, paint);
    }

    public Stroke getSectionOutlineStroke(int n2) {
        Comparable comparable = this.getSectionKey(n2);
        return this.getSectionOutlineStroke(comparable);
    }

    public void setSectionOutlineStroke(int n2, Stroke stroke) {
        Comparable comparable = this.getSectionKey(n2);
        this.setSectionOutlineStroke(comparable, stroke);
    }

    public double getExplodePercent(int n2) {
        Comparable comparable = this.getSectionKey(n2);
        return this.getExplodePercent(comparable);
    }

    public void setExplodePercent(int n2, double d2) {
        Comparable comparable = this.getSectionKey(n2);
        this.setExplodePercent(comparable, d2);
    }
}

