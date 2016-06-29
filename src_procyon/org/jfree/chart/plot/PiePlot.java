package org.jfree.chart.plot;

import org.jfree.chart.urls.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.event.*;
import org.jfree.data.general.*;
import java.awt.*;
import java.util.*;
import org.jfree.chart.entity.*;
import org.jfree.data.*;
import org.jfree.text.*;
import java.awt.geom.*;
import org.jfree.chart.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class PiePlot extends Plot implements Serializable, Cloneable
{
    private static final long serialVersionUID = -795612466005590431L;
    public static final double DEFAULT_INTERIOR_GAP = 0.25;
    public static final double MAX_INTERIOR_GAP = 0.4;
    public static final double DEFAULT_START_ANGLE = 90.0;
    public static final Font DEFAULT_LABEL_FONT;
    public static final Paint DEFAULT_LABEL_PAINT;
    public static final Paint DEFAULT_LABEL_BACKGROUND_PAINT;
    public static final Paint DEFAULT_LABEL_OUTLINE_PAINT;
    public static final Stroke DEFAULT_LABEL_OUTLINE_STROKE;
    public static final Paint DEFAULT_LABEL_SHADOW_PAINT;
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
    private transient Paint shadowPaint;
    private double shadowXOffset;
    private double shadowYOffset;
    private Map explodePercentages;
    private PieSectionLabelGenerator labelGenerator;
    private Font labelFont;
    private transient Paint labelPaint;
    private transient Paint labelBackgroundPaint;
    private transient Paint labelOutlinePaint;
    private transient Stroke labelOutlineStroke;
    private transient Paint labelShadowPaint;
    private double maximumLabelWidth;
    private double labelGap;
    private boolean labelLinksVisible;
    private double labelLinkMargin;
    private transient Paint labelLinkPaint;
    private transient Stroke labelLinkStroke;
    private PieToolTipGenerator toolTipGenerator;
    private PieURLGenerator urlGenerator;
    private PieSectionLabelGenerator legendLabelGenerator;
    private PieSectionLabelGenerator legendLabelToolTipGenerator;
    private PieURLGenerator legendLabelURLGenerator;
    private boolean ignoreNullValues;
    private boolean ignoreZeroValues;
    private transient Shape legendItemShape;
    private double minimumArcAngleToDraw;
    protected static ResourceBundle localizationResources;
    
    public PiePlot() {
        this(null);
    }
    
    public PiePlot(final PieDataset dataset) {
        this.shadowPaint = Color.gray;
        this.shadowXOffset = 4.0;
        this.shadowYOffset = 4.0;
        this.maximumLabelWidth = 0.2;
        this.labelGap = 0.05;
        this.labelLinkMargin = 0.05;
        this.labelLinkPaint = Color.black;
        this.labelLinkStroke = new BasicStroke(0.5f);
        this.dataset = dataset;
        if (dataset != null) {
            dataset.addChangeListener(this);
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
        this.baseSectionOutlinePaint = PiePlot.DEFAULT_OUTLINE_PAINT;
        this.sectionOutlineStroke = null;
        this.sectionOutlineStrokeMap = new StrokeMap();
        this.baseSectionOutlineStroke = PiePlot.DEFAULT_OUTLINE_STROKE;
        this.explodePercentages = new TreeMap();
        this.labelGenerator = new StandardPieSectionLabelGenerator();
        this.labelFont = PiePlot.DEFAULT_LABEL_FONT;
        this.labelPaint = PiePlot.DEFAULT_LABEL_PAINT;
        this.labelBackgroundPaint = PiePlot.DEFAULT_LABEL_BACKGROUND_PAINT;
        this.labelOutlinePaint = PiePlot.DEFAULT_LABEL_OUTLINE_PAINT;
        this.labelOutlineStroke = PiePlot.DEFAULT_LABEL_OUTLINE_STROKE;
        this.labelShadowPaint = PiePlot.DEFAULT_LABEL_SHADOW_PAINT;
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
    
    public void setDataset(final PieDataset dataset) {
        final PieDataset dataset2 = this.dataset;
        if (dataset2 != null) {
            dataset2.removeChangeListener(this);
        }
        if ((this.dataset = dataset) != null) {
            this.setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, dataset));
    }
    
    public int getPieIndex() {
        return this.pieIndex;
    }
    
    public void setPieIndex(final int pieIndex) {
        this.pieIndex = pieIndex;
    }
    
    public double getStartAngle() {
        return this.startAngle;
    }
    
    public void setStartAngle(final double startAngle) {
        this.startAngle = startAngle;
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
            throw new IllegalArgumentException("Invalid 'percent' (" + interiorGap + ") argument.");
        }
        if (this.interiorGap != interiorGap) {
            this.interiorGap = interiorGap;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean isCircular() {
        return this.circular;
    }
    
    public void setCircular(final boolean b) {
        this.setCircular(b, true);
    }
    
    public void setCircular(final boolean circular, final boolean b) {
        this.circular = circular;
        if (b) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean getIgnoreNullValues() {
        return this.ignoreNullValues;
    }
    
    public void setIgnoreNullValues(final boolean ignoreNullValues) {
        this.ignoreNullValues = ignoreNullValues;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getIgnoreZeroValues() {
        return this.ignoreZeroValues;
    }
    
    public void setIgnoreZeroValues(final boolean ignoreZeroValues) {
        this.ignoreZeroValues = ignoreZeroValues;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected Paint lookupSectionPaint(final Comparable comparable) {
        return this.lookupSectionPaint(comparable, false);
    }
    
    protected Paint lookupSectionPaint(final Comparable comparable, final boolean b) {
        final Paint sectionPaint = this.getSectionPaint();
        if (sectionPaint != null) {
            return sectionPaint;
        }
        final Paint paint = this.sectionPaintMap.getPaint(comparable);
        if (paint != null) {
            return paint;
        }
        Paint paint2;
        if (b) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                paint2 = drawingSupplier.getNextPaint();
                this.sectionPaintMap.put(comparable, paint2);
            }
            else {
                paint2 = this.baseSectionPaint;
            }
        }
        else {
            paint2 = this.baseSectionPaint;
        }
        return paint2;
    }
    
    public Paint getSectionPaint() {
        return this.sectionPaint;
    }
    
    public void setSectionPaint(final Paint sectionPaint) {
        this.sectionPaint = sectionPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected Comparable getSectionKey(final int n) {
        Comparable key = null;
        if (this.dataset != null && n >= 0 && n < this.dataset.getItemCount()) {
            key = this.dataset.getKey(n);
        }
        if (key == null) {
            key = new Integer(n);
        }
        return key;
    }
    
    public Paint getSectionPaint(final Comparable comparable) {
        return this.sectionPaintMap.getPaint(comparable);
    }
    
    public void setSectionPaint(final Comparable comparable, final Paint paint) {
        this.sectionPaintMap.put(comparable, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getBaseSectionPaint() {
        return this.baseSectionPaint;
    }
    
    public void setBaseSectionPaint(final Paint baseSectionPaint) {
        if (baseSectionPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSectionPaint = baseSectionPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getSectionOutlinesVisible() {
        return this.sectionOutlinesVisible;
    }
    
    public void setSectionOutlinesVisible(final boolean sectionOutlinesVisible) {
        this.sectionOutlinesVisible = sectionOutlinesVisible;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected Paint lookupSectionOutlinePaint(final Comparable comparable) {
        return this.lookupSectionOutlinePaint(comparable, false);
    }
    
    protected Paint lookupSectionOutlinePaint(final Comparable comparable, final boolean b) {
        final Paint sectionOutlinePaint = this.getSectionOutlinePaint();
        if (sectionOutlinePaint != null) {
            return sectionOutlinePaint;
        }
        final Paint paint = this.sectionOutlinePaintMap.getPaint(comparable);
        if (paint != null) {
            return paint;
        }
        Paint paint2;
        if (b) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                paint2 = drawingSupplier.getNextOutlinePaint();
                this.sectionOutlinePaintMap.put(comparable, paint2);
            }
            else {
                paint2 = this.baseSectionOutlinePaint;
            }
        }
        else {
            paint2 = this.baseSectionOutlinePaint;
        }
        return paint2;
    }
    
    public Paint getSectionOutlinePaint() {
        return this.sectionOutlinePaint;
    }
    
    public void setSectionOutlinePaint(final Paint sectionOutlinePaint) {
        this.sectionOutlinePaint = sectionOutlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getSectionOutlinePaint(final Comparable comparable) {
        return this.sectionOutlinePaintMap.getPaint(comparable);
    }
    
    public void setSectionOutlinePaint(final Comparable comparable, final Paint paint) {
        this.sectionOutlinePaintMap.put(comparable, paint);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getBaseSectionOutlinePaint() {
        return this.baseSectionOutlinePaint;
    }
    
    public void setBaseSectionOutlinePaint(final Paint baseSectionOutlinePaint) {
        if (baseSectionOutlinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.baseSectionOutlinePaint = baseSectionOutlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    protected Stroke lookupSectionOutlineStroke(final Comparable comparable) {
        return this.lookupSectionOutlineStroke(comparable, false);
    }
    
    protected Stroke lookupSectionOutlineStroke(final Comparable comparable, final boolean b) {
        final Stroke sectionOutlineStroke = this.getSectionOutlineStroke();
        if (sectionOutlineStroke != null) {
            return sectionOutlineStroke;
        }
        final Stroke stroke = this.sectionOutlineStrokeMap.getStroke(comparable);
        if (stroke != null) {
            return stroke;
        }
        Stroke stroke2;
        if (b) {
            final DrawingSupplier drawingSupplier = this.getDrawingSupplier();
            if (drawingSupplier != null) {
                stroke2 = drawingSupplier.getNextOutlineStroke();
                this.sectionOutlineStrokeMap.put(comparable, stroke2);
            }
            else {
                stroke2 = this.baseSectionOutlineStroke;
            }
        }
        else {
            stroke2 = this.baseSectionOutlineStroke;
        }
        return stroke2;
    }
    
    public Stroke getSectionOutlineStroke() {
        return this.sectionOutlineStroke;
    }
    
    public void setSectionOutlineStroke(final Stroke sectionOutlineStroke) {
        this.sectionOutlineStroke = sectionOutlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getSectionOutlineStroke(final Comparable comparable) {
        return this.sectionOutlineStrokeMap.getStroke(comparable);
    }
    
    public void setSectionOutlineStroke(final Comparable comparable, final Stroke stroke) {
        this.sectionOutlineStrokeMap.put(comparable, stroke);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getBaseSectionOutlineStroke() {
        return this.baseSectionOutlineStroke;
    }
    
    public void setBaseSectionOutlineStroke(final Stroke baseSectionOutlineStroke) {
        if (baseSectionOutlineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.baseSectionOutlineStroke = baseSectionOutlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }
    
    public void setShadowPaint(final Paint shadowPaint) {
        this.shadowPaint = shadowPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getShadowXOffset() {
        return this.shadowXOffset;
    }
    
    public void setShadowXOffset(final double shadowXOffset) {
        this.shadowXOffset = shadowXOffset;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getShadowYOffset() {
        return this.shadowYOffset;
    }
    
    public void setShadowYOffset(final double shadowYOffset) {
        this.shadowYOffset = shadowYOffset;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getExplodePercent(final Comparable comparable) {
        double doubleValue = 0.0;
        if (this.explodePercentages != null) {
            final Number n = this.explodePercentages.get(comparable);
            if (n != null) {
                doubleValue = n.doubleValue();
            }
        }
        return doubleValue;
    }
    
    public void setExplodePercent(final Comparable comparable, final double n) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        if (this.explodePercentages == null) {
            this.explodePercentages = new TreeMap();
        }
        this.explodePercentages.put(comparable, new Double(n));
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getMaximumExplodePercent() {
        double max = 0.0;
        final Iterator<Comparable<?>> iterator = this.dataset.getKeys().iterator();
        while (iterator.hasNext()) {
            final Number n = this.explodePercentages.get(iterator.next());
            if (n != null) {
                max = Math.max(max, n.doubleValue());
            }
        }
        return max;
    }
    
    public PieSectionLabelGenerator getLabelGenerator() {
        return this.labelGenerator;
    }
    
    public void setLabelGenerator(final PieSectionLabelGenerator labelGenerator) {
        this.labelGenerator = labelGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getLabelGap() {
        return this.labelGap;
    }
    
    public void setLabelGap(final double labelGap) {
        this.labelGap = labelGap;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getMaximumLabelWidth() {
        return this.maximumLabelWidth;
    }
    
    public void setMaximumLabelWidth(final double maximumLabelWidth) {
        this.maximumLabelWidth = maximumLabelWidth;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getLabelLinksVisible() {
        return this.labelLinksVisible;
    }
    
    public void setLabelLinksVisible(final boolean labelLinksVisible) {
        this.labelLinksVisible = labelLinksVisible;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getLabelLinkMargin() {
        return this.labelLinkMargin;
    }
    
    public void setLabelLinkMargin(final double labelLinkMargin) {
        this.labelLinkMargin = labelLinkMargin;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getLabelLinkPaint() {
        return this.labelLinkPaint;
    }
    
    public void setLabelLinkPaint(final Paint labelLinkPaint) {
        if (labelLinkPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelLinkPaint = labelLinkPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getLabelLinkStroke() {
        return this.labelLinkStroke;
    }
    
    public void setLabelLinkStroke(final Stroke labelLinkStroke) {
        if (labelLinkStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.labelLinkStroke = labelLinkStroke;
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
    
    public Paint getLabelBackgroundPaint() {
        return this.labelBackgroundPaint;
    }
    
    public void setLabelBackgroundPaint(final Paint labelBackgroundPaint) {
        this.labelBackgroundPaint = labelBackgroundPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getLabelOutlinePaint() {
        return this.labelOutlinePaint;
    }
    
    public void setLabelOutlinePaint(final Paint labelOutlinePaint) {
        this.labelOutlinePaint = labelOutlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getLabelOutlineStroke() {
        return this.labelOutlineStroke;
    }
    
    public void setLabelOutlineStroke(final Stroke labelOutlineStroke) {
        this.labelOutlineStroke = labelOutlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getLabelShadowPaint() {
        return this.labelShadowPaint;
    }
    
    public void setLabelShadowPaint(final Paint labelShadowPaint) {
        this.labelShadowPaint = labelShadowPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PieToolTipGenerator getToolTipGenerator() {
        return this.toolTipGenerator;
    }
    
    public void setToolTipGenerator(final PieToolTipGenerator toolTipGenerator) {
        this.toolTipGenerator = toolTipGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PieURLGenerator getURLGenerator() {
        return this.urlGenerator;
    }
    
    public void setURLGenerator(final PieURLGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public double getMinimumArcAngleToDraw() {
        return this.minimumArcAngleToDraw;
    }
    
    public void setMinimumArcAngleToDraw(final double minimumArcAngleToDraw) {
        this.minimumArcAngleToDraw = minimumArcAngleToDraw;
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
    
    public PieSectionLabelGenerator getLegendLabelGenerator() {
        return this.legendLabelGenerator;
    }
    
    public void setLegendLabelGenerator(final PieSectionLabelGenerator legendLabelGenerator) {
        if (legendLabelGenerator == null) {
            throw new IllegalArgumentException("Null 'generator' argument.");
        }
        this.legendLabelGenerator = legendLabelGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PieSectionLabelGenerator getLegendLabelToolTipGenerator() {
        return this.legendLabelToolTipGenerator;
    }
    
    public void setLegendLabelToolTipGenerator(final PieSectionLabelGenerator legendLabelToolTipGenerator) {
        this.legendLabelToolTipGenerator = legendLabelToolTipGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PieURLGenerator getLegendLabelURLGenerator() {
        return this.legendLabelURLGenerator;
    }
    
    public void setLegendLabelURLGenerator(final PieURLGenerator legendLabelURLGenerator) {
        this.legendLabelURLGenerator = legendLabelURLGenerator;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public PiePlotState initialise(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PiePlot piePlot, final Integer n, final PlotRenderingInfo plotRenderingInfo) {
        final PiePlotState piePlotState = new PiePlotState(plotRenderingInfo);
        piePlotState.setPassesRequired(2);
        piePlotState.setTotal(DatasetUtilities.calculatePieDatasetTotal(piePlot.getDataset()));
        piePlotState.setLatestAngle(piePlot.getStartAngle());
        return piePlotState;
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
            this.drawPie(graphics2D, rectangle2D, plotRenderingInfo);
        }
        else {
            this.drawNoDataMessage(graphics2D, rectangle2D);
        }
        graphics2D.setClip(clip);
        graphics2D.setComposite(composite);
        this.drawOutline(graphics2D, rectangle2D);
    }
    
    protected void drawPie(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo) {
        final PiePlotState initialise = this.initialise(graphics2D, rectangle2D, this, null, plotRenderingInfo);
        double n = 0.0;
        if (this.labelGenerator != null) {
            n = this.labelGap + this.maximumLabelWidth + this.labelLinkMargin;
        }
        final double n2 = rectangle2D.getWidth() * (this.interiorGap + n);
        final double n3 = rectangle2D.getHeight() * this.interiorGap;
        double n4 = rectangle2D.getX() + n2 / 2.0;
        double n5 = rectangle2D.getY() + n3 / 2.0;
        double n6 = rectangle2D.getWidth() - n2;
        double n7 = rectangle2D.getHeight() - n3;
        if (this.circular) {
            final double n8 = Math.min(n6, n7) / 2.0;
            n4 = (n4 + n4 + n6) / 2.0 - n8;
            n5 = (n5 + n5 + n7) / 2.0 - n8;
            n6 = 2.0 * n8;
            n7 = 2.0 * n8;
        }
        final Rectangle2D.Double linkArea = new Rectangle2D.Double(n4, n5, n6, n7);
        initialise.setLinkArea(linkArea);
        final double n9 = linkArea.getWidth() * this.labelLinkMargin;
        final double n10 = linkArea.getHeight() * this.labelLinkMargin;
        final Rectangle2D.Double explodedPieArea = new Rectangle2D.Double(n4 + n9 / 2.0, n5 + n10 / 2.0, n6 - n9, n7 - n10);
        initialise.setExplodedPieArea(explodedPieArea);
        final double maximumExplodePercent = this.getMaximumExplodePercent();
        final double n11 = maximumExplodePercent / (1.0 + maximumExplodePercent);
        final double n12 = explodedPieArea.getWidth() * n11;
        final double n13 = explodedPieArea.getHeight() * n11;
        final Rectangle2D.Double pieArea = new Rectangle2D.Double(explodedPieArea.getX() + n12 / 2.0, explodedPieArea.getY() + n13 / 2.0, explodedPieArea.getWidth() - n12, explodedPieArea.getHeight() - n13);
        initialise.setPieArea(pieArea);
        initialise.setPieCenterX(pieArea.getCenterX());
        initialise.setPieCenterY(pieArea.getCenterY());
        initialise.setPieWRadius(pieArea.getWidth() / 2.0);
        initialise.setPieHRadius(pieArea.getHeight() / 2.0);
        if (this.dataset != null && this.dataset.getKeys().size() > 0) {
            final List keys = this.dataset.getKeys();
            final double calculatePieDatasetTotal = DatasetUtilities.calculatePieDatasetTotal(this.dataset);
            for (int passesRequired = initialise.getPassesRequired(), i = 0; i < passesRequired; ++i) {
                double n14 = 0.0;
                for (int j = 0; j < keys.size(); ++j) {
                    final Number value = this.dataset.getValue(j);
                    if (value != null) {
                        final double doubleValue = value.doubleValue();
                        if (doubleValue > 0.0) {
                            n14 += doubleValue;
                            this.drawItem(graphics2D, j, explodedPieArea, initialise, i);
                        }
                    }
                }
            }
            this.drawLabels(graphics2D, keys, calculatePieDatasetTotal, rectangle2D, linkArea, initialise);
        }
        else {
            this.drawNoDataMessage(graphics2D, rectangle2D);
        }
    }
    
    protected void drawItem(final Graphics2D graphics2D, final int n, final Rectangle2D rectangle2D, final PiePlotState piePlotState, final int n2) {
        final Number value = this.dataset.getValue(n);
        if (value == null) {
            return;
        }
        final double doubleValue = value.doubleValue();
        double n3;
        double latestAngle;
        if (this.direction == Rotation.CLOCKWISE) {
            n3 = piePlotState.getLatestAngle();
            latestAngle = n3 - doubleValue / piePlotState.getTotal() * 360.0;
        }
        else {
            if (this.direction != Rotation.ANTICLOCKWISE) {
                throw new IllegalStateException("Rotation type not recognised.");
            }
            n3 = piePlotState.getLatestAngle();
            latestAngle = n3 + doubleValue / piePlotState.getTotal() * 360.0;
        }
        final double n4 = latestAngle - n3;
        if (Math.abs(n4) > this.getMinimumArcAngleToDraw()) {
            double n5 = 0.0;
            final double maximumExplodePercent = this.getMaximumExplodePercent();
            if (maximumExplodePercent > 0.0) {
                n5 = this.getExplodePercent(n) / maximumExplodePercent;
            }
            final Arc2D.Double double1 = new Arc2D.Double(this.getArcBounds(piePlotState.getPieArea(), piePlotState.getExplodedPieArea(), n3, n4, n5), n3, n4, 2);
            if (n2 == 0) {
                if (this.shadowPaint != null) {
                    final Shape translatedShape = ShapeUtilities.createTranslatedShape(double1, (float)this.shadowXOffset, (float)this.shadowYOffset);
                    graphics2D.setPaint(this.shadowPaint);
                    graphics2D.fill(translatedShape);
                }
            }
            else if (n2 == 1) {
                final Comparable sectionKey = this.getSectionKey(n);
                graphics2D.setPaint(this.lookupSectionPaint(sectionKey, true));
                graphics2D.fill(double1);
                final Paint lookupSectionOutlinePaint = this.lookupSectionOutlinePaint(sectionKey);
                final Stroke lookupSectionOutlineStroke = this.lookupSectionOutlineStroke(sectionKey);
                if (this.sectionOutlinesVisible) {
                    graphics2D.setPaint(lookupSectionOutlinePaint);
                    graphics2D.setStroke(lookupSectionOutlineStroke);
                    graphics2D.draw(double1);
                }
                if (piePlotState.getInfo() != null) {
                    final EntityCollection entityCollection = piePlotState.getEntityCollection();
                    if (entityCollection != null) {
                        String generateToolTip = null;
                        if (this.toolTipGenerator != null) {
                            generateToolTip = this.toolTipGenerator.generateToolTip(this.dataset, sectionKey);
                        }
                        String generateURL = null;
                        if (this.urlGenerator != null) {
                            generateURL = this.urlGenerator.generateURL(this.dataset, sectionKey, this.pieIndex);
                        }
                        entityCollection.add(new PieSectionEntity(double1, this.dataset, this.pieIndex, n, sectionKey, generateToolTip, generateURL));
                    }
                }
            }
        }
        piePlotState.setLatestAngle(latestAngle);
    }
    
    protected void drawLabels(final Graphics2D graphics2D, final List list, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final PiePlotState piePlotState) {
        final Composite composite = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.getInstance(3, 1.0f));
        final DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        final DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        double n2 = 0.0;
        for (final Comparable comparable : list) {
            double doubleValue = 0.0;
            final Number value = this.dataset.getValue(comparable);
            boolean b;
            if (value == null) {
                b = !this.ignoreNullValues;
            }
            else {
                doubleValue = value.doubleValue();
                b = (this.ignoreZeroValues ? (doubleValue > 0.0) : (doubleValue >= 0.0));
            }
            if (b) {
                n2 += doubleValue;
                final double n3 = this.startAngle + this.direction.getFactor() * ((n2 - doubleValue / 2.0) * 360.0) / n;
                if (Math.cos(Math.toRadians(n3)) < 0.0) {
                    defaultKeyedValues.addValue(comparable, new Double(n3));
                }
                else {
                    defaultKeyedValues2.addValue(comparable, new Double(n3));
                }
            }
        }
        graphics2D.setFont(this.getLabelFont());
        final float n4 = (float)(this.getMaximumLabelWidth() * rectangle2D.getWidth());
        if (this.labelGenerator != null) {
            this.drawLeftLabels(defaultKeyedValues, graphics2D, rectangle2D, rectangle2D2, n4, piePlotState);
            this.drawRightLabels(defaultKeyedValues2, graphics2D, rectangle2D, rectangle2D2, n4, piePlotState);
        }
        graphics2D.setComposite(composite);
    }
    
    protected void drawLeftLabels(final KeyedValues keyedValues, final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final float n, final PiePlotState piePlotState) {
        final PieLabelDistributor pieLabelDistributor = new PieLabelDistributor(keyedValues.getItemCount());
        final double n2 = rectangle2D.getWidth() * this.labelGap;
        final double n3 = piePlotState.getLinkArea().getHeight() / 2.0;
        for (int i = 0; i < keyedValues.getItemCount(); ++i) {
            final String generateSectionLabel = this.labelGenerator.generateSectionLabel(this.dataset, keyedValues.getKey(i));
            if (generateSectionLabel != null) {
                final TextBox textBox = new TextBox(TextUtilities.createTextBlock(generateSectionLabel, this.labelFont, this.labelPaint, n, new G2TextMeasurer(graphics2D)));
                textBox.setBackgroundPaint(this.labelBackgroundPaint);
                textBox.setOutlinePaint(this.labelOutlinePaint);
                textBox.setOutlineStroke(this.labelOutlineStroke);
                textBox.setShadowPaint(this.labelShadowPaint);
                final double radians = Math.toRadians(keyedValues.getValue(i).doubleValue());
                pieLabelDistributor.addPieLabelRecord(new PieLabelRecord(keyedValues.getKey(i), radians, piePlotState.getPieCenterY() - Math.sin(radians) * n3, textBox, textBox.getHeight(graphics2D), n2 / 2.0 + n2 / 2.0 * -Math.cos(radians), 0.9 + this.getExplodePercent(this.dataset.getIndex(keyedValues.getKey(i)))));
            }
        }
        pieLabelDistributor.distributeLabels(rectangle2D.getMinY(), rectangle2D.getHeight());
        for (int j = 0; j < pieLabelDistributor.getItemCount(); ++j) {
            this.drawLeftLabel(graphics2D, piePlotState, pieLabelDistributor.getPieLabelRecord(j));
        }
    }
    
    protected void drawRightLabels(final KeyedValues keyedValues, final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final float n, final PiePlotState piePlotState) {
        final PieLabelDistributor pieLabelDistributor = new PieLabelDistributor(keyedValues.getItemCount());
        final double n2 = rectangle2D.getWidth() * this.labelGap;
        final double n3 = piePlotState.getLinkArea().getHeight() / 2.0;
        for (int i = 0; i < keyedValues.getItemCount(); ++i) {
            final String generateSectionLabel = this.labelGenerator.generateSectionLabel(this.dataset, keyedValues.getKey(i));
            if (generateSectionLabel != null) {
                final TextBox textBox = new TextBox(TextUtilities.createTextBlock(generateSectionLabel, this.labelFont, this.labelPaint, n, new G2TextMeasurer(graphics2D)));
                textBox.setBackgroundPaint(this.labelBackgroundPaint);
                textBox.setOutlinePaint(this.labelOutlinePaint);
                textBox.setOutlineStroke(this.labelOutlineStroke);
                textBox.setShadowPaint(this.labelShadowPaint);
                final double radians = Math.toRadians(keyedValues.getValue(i).doubleValue());
                pieLabelDistributor.addPieLabelRecord(new PieLabelRecord(keyedValues.getKey(i), radians, piePlotState.getPieCenterY() - Math.sin(radians) * n3, textBox, textBox.getHeight(graphics2D), n2 / 2.0 + n2 / 2.0 * Math.cos(radians), 0.9 + this.getExplodePercent(this.dataset.getIndex(keyedValues.getKey(i)))));
            }
        }
        pieLabelDistributor.distributeLabels(rectangle2D.getMinY(), rectangle2D.getHeight());
        for (int j = 0; j < pieLabelDistributor.getItemCount(); ++j) {
            this.drawRightLabel(graphics2D, piePlotState, pieLabelDistributor.getPieLabelRecord(j));
        }
    }
    
    public LegendItemCollection getLegendItems() {
        final LegendItemCollection collection = new LegendItemCollection();
        if (this.dataset == null) {
            return collection;
        }
        final List keys = this.dataset.getKeys();
        int n = 0;
        final Shape legendItemShape = this.getLegendItemShape();
        for (final Comparable comparable : keys) {
            final Number value = this.dataset.getValue(comparable);
            boolean b;
            if (value == null) {
                b = !this.ignoreNullValues;
            }
            else {
                final double doubleValue = value.doubleValue();
                if (doubleValue == 0.0) {
                    b = !this.ignoreZeroValues;
                }
                else {
                    b = (doubleValue > 0.0);
                }
            }
            if (b) {
                final String generateSectionLabel = this.legendLabelGenerator.generateSectionLabel(this.dataset, comparable);
                String generateSectionLabel2 = null;
                if (this.legendLabelToolTipGenerator != null) {
                    generateSectionLabel2 = this.legendLabelToolTipGenerator.generateSectionLabel(this.dataset, comparable);
                }
                String generateURL = null;
                if (this.legendLabelURLGenerator != null) {
                    generateURL = this.legendLabelURLGenerator.generateURL(this.dataset, comparable, this.pieIndex);
                }
                collection.add(new LegendItem(generateSectionLabel, generateSectionLabel, generateSectionLabel2, generateURL, true, legendItemShape, true, this.lookupSectionPaint(comparable, true), true, this.lookupSectionOutlinePaint(comparable), this.lookupSectionOutlineStroke(comparable), false, new Line2D.Float(), new BasicStroke(), Color.black));
                ++n;
            }
            else {
                ++n;
            }
        }
        return collection;
    }
    
    public String getPlotType() {
        return PiePlot.localizationResources.getString("Pie_Plot");
    }
    
    public void zoom(final double n) {
    }
    
    protected Rectangle2D getArcBounds(final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final double n, final double n2, final double n3) {
        if (n3 == 0.0) {
            return rectangle2D;
        }
        final Point2D endPoint = new Arc2D.Double(rectangle2D, n, n2 / 2.0, 0).getEndPoint();
        final Point2D endPoint2 = new Arc2D.Double(rectangle2D2, n, n2 / 2.0, 0).getEndPoint();
        return new Rectangle2D.Double(rectangle2D.getX() - (endPoint.getX() - endPoint2.getX()) * n3, rectangle2D.getY() - (endPoint.getY() - endPoint2.getY()) * n3, rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    protected void drawLeftLabel(final Graphics2D graphics2D, final PiePlotState piePlotState, final PieLabelRecord pieLabelRecord) {
        final double minX = piePlotState.getLinkArea().getMinX();
        final double n = minX - pieLabelRecord.getGap();
        final double allocatedY = pieLabelRecord.getAllocatedY();
        if (this.labelLinksVisible) {
            final double angle = pieLabelRecord.getAngle();
            final double n2 = piePlotState.getPieCenterX() + Math.cos(angle) * piePlotState.getPieWRadius() * pieLabelRecord.getLinkPercent();
            final double n3 = piePlotState.getPieCenterY() - Math.sin(angle) * piePlotState.getPieHRadius() * pieLabelRecord.getLinkPercent();
            final double n4 = piePlotState.getPieCenterX() + Math.cos(angle) * piePlotState.getLinkArea().getWidth() / 2.0;
            final double n6;
            final double n5 = n6 = piePlotState.getPieCenterY() - Math.sin(angle) * piePlotState.getLinkArea().getHeight() / 2.0;
            graphics2D.setPaint(this.labelLinkPaint);
            graphics2D.setStroke(this.labelLinkStroke);
            graphics2D.draw(new Line2D.Double(n2, n3, n4, n5));
            graphics2D.draw(new Line2D.Double(minX, n6, n4, n5));
            graphics2D.draw(new Line2D.Double(minX, n6, n, allocatedY));
        }
        pieLabelRecord.getLabel().draw(graphics2D, (float)n, (float)allocatedY, RectangleAnchor.RIGHT);
    }
    
    protected void drawRightLabel(final Graphics2D graphics2D, final PiePlotState piePlotState, final PieLabelRecord pieLabelRecord) {
        final double maxX = piePlotState.getLinkArea().getMaxX();
        final double n = maxX + pieLabelRecord.getGap();
        final double allocatedY = pieLabelRecord.getAllocatedY();
        if (this.labelLinksVisible) {
            final double angle = pieLabelRecord.getAngle();
            final double n2 = piePlotState.getPieCenterX() + Math.cos(angle) * piePlotState.getPieWRadius() * pieLabelRecord.getLinkPercent();
            final double n3 = piePlotState.getPieCenterY() - Math.sin(angle) * piePlotState.getPieHRadius() * pieLabelRecord.getLinkPercent();
            final double n4 = piePlotState.getPieCenterX() + Math.cos(angle) * piePlotState.getLinkArea().getWidth() / 2.0;
            final double n6;
            final double n5 = n6 = piePlotState.getPieCenterY() - Math.sin(angle) * piePlotState.getLinkArea().getHeight() / 2.0;
            graphics2D.setPaint(this.labelLinkPaint);
            graphics2D.setStroke(this.labelLinkStroke);
            graphics2D.draw(new Line2D.Double(n2, n3, n4, n5));
            graphics2D.draw(new Line2D.Double(maxX, n6, n4, n5));
            graphics2D.draw(new Line2D.Double(maxX, n6, n, allocatedY));
        }
        pieLabelRecord.getLabel().draw(graphics2D, (float)n, (float)allocatedY, RectangleAnchor.LEFT);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PiePlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final PiePlot piePlot = (PiePlot)o;
        return this.pieIndex == piePlot.pieIndex && this.interiorGap == piePlot.interiorGap && this.circular == piePlot.circular && this.startAngle == piePlot.startAngle && this.direction == piePlot.direction && this.ignoreZeroValues == piePlot.ignoreZeroValues && this.ignoreNullValues == piePlot.ignoreNullValues && PaintUtilities.equal(this.sectionPaint, piePlot.sectionPaint) && ObjectUtilities.equal(this.sectionPaintMap, piePlot.sectionPaintMap) && PaintUtilities.equal(this.baseSectionPaint, piePlot.baseSectionPaint) && this.sectionOutlinesVisible == piePlot.sectionOutlinesVisible && PaintUtilities.equal(this.sectionOutlinePaint, piePlot.sectionOutlinePaint) && ObjectUtilities.equal(this.sectionOutlinePaintMap, piePlot.sectionOutlinePaintMap) && PaintUtilities.equal(this.baseSectionOutlinePaint, piePlot.baseSectionOutlinePaint) && ObjectUtilities.equal(this.sectionOutlineStroke, piePlot.sectionOutlineStroke) && ObjectUtilities.equal(this.sectionOutlineStrokeMap, piePlot.sectionOutlineStrokeMap) && ObjectUtilities.equal(this.baseSectionOutlineStroke, piePlot.baseSectionOutlineStroke) && PaintUtilities.equal(this.shadowPaint, piePlot.shadowPaint) && this.shadowXOffset == piePlot.shadowXOffset && this.shadowYOffset == piePlot.shadowYOffset && ObjectUtilities.equal(this.explodePercentages, piePlot.explodePercentages) && ObjectUtilities.equal(this.labelGenerator, piePlot.labelGenerator) && ObjectUtilities.equal(this.labelFont, piePlot.labelFont) && PaintUtilities.equal(this.labelPaint, piePlot.labelPaint) && PaintUtilities.equal(this.labelBackgroundPaint, piePlot.labelBackgroundPaint) && PaintUtilities.equal(this.labelOutlinePaint, piePlot.labelOutlinePaint) && ObjectUtilities.equal(this.labelOutlineStroke, piePlot.labelOutlineStroke) && PaintUtilities.equal(this.labelShadowPaint, piePlot.labelShadowPaint) && this.maximumLabelWidth == piePlot.maximumLabelWidth && this.labelGap == piePlot.labelGap && this.labelLinkMargin == piePlot.labelLinkMargin && this.labelLinksVisible == piePlot.labelLinksVisible && PaintUtilities.equal(this.labelLinkPaint, piePlot.labelLinkPaint) && ObjectUtilities.equal(this.labelLinkStroke, piePlot.labelLinkStroke) && ObjectUtilities.equal(this.toolTipGenerator, piePlot.toolTipGenerator) && ObjectUtilities.equal(this.urlGenerator, piePlot.urlGenerator) && this.minimumArcAngleToDraw == piePlot.minimumArcAngleToDraw && ShapeUtilities.equal(this.legendItemShape, piePlot.legendItemShape) && ObjectUtilities.equal(this.legendLabelGenerator, piePlot.legendLabelGenerator) && ObjectUtilities.equal(this.legendLabelToolTipGenerator, piePlot.legendLabelToolTipGenerator) && ObjectUtilities.equal(this.legendLabelURLGenerator, piePlot.legendLabelURLGenerator);
    }
    
    public Object clone() {
        final PiePlot piePlot = (PiePlot)super.clone();
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
        if (this.legendLabelURLGenerator instanceof PublicCloneable) {
            piePlot.legendLabelURLGenerator = (PieURLGenerator)ObjectUtilities.clone(this.legendLabelURLGenerator);
        }
        return piePlot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
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
    
    private void readObject(final ObjectInputStream objectInputStream) {
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
    
    public Paint getSectionPaint(final int n) {
        return this.getSectionPaint(this.getSectionKey(n));
    }
    
    public void setSectionPaint(final int n, final Paint paint) {
        this.setSectionPaint(this.getSectionKey(n), paint);
    }
    
    public Paint getSectionOutlinePaint(final int n) {
        return this.getSectionOutlinePaint(this.getSectionKey(n));
    }
    
    public void setSectionOutlinePaint(final int n, final Paint paint) {
        this.setSectionOutlinePaint(this.getSectionKey(n), paint);
    }
    
    public Stroke getSectionOutlineStroke(final int n) {
        return this.getSectionOutlineStroke(this.getSectionKey(n));
    }
    
    public void setSectionOutlineStroke(final int n, final Stroke stroke) {
        this.setSectionOutlineStroke(this.getSectionKey(n), stroke);
    }
    
    public double getExplodePercent(final int n) {
        return this.getExplodePercent(this.getSectionKey(n));
    }
    
    public void setExplodePercent(final int n, final double n2) {
        this.setExplodePercent(this.getSectionKey(n), n2);
    }
    
    static {
        DEFAULT_LABEL_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_LABEL_PAINT = Color.black;
        DEFAULT_LABEL_BACKGROUND_PAINT = new Color(255, 255, 192);
        DEFAULT_LABEL_OUTLINE_PAINT = Color.black;
        DEFAULT_LABEL_OUTLINE_STROKE = new BasicStroke(0.5f);
        DEFAULT_LABEL_SHADOW_PAINT = Color.lightGray;
        PiePlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
