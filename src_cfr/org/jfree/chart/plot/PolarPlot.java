/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class PolarPlot
extends Plot
implements Serializable,
Cloneable,
RendererChangeListener,
ValueAxisPlot,
Zoomable {
    private static final long serialVersionUID = 3794383185924179525L;
    private static final int MARGIN = 20;
    private static final double ANNOTATION_MARGIN = 7.0;
    public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[]{2.0f, 2.0f}, 0.0f);
    public static final Paint DEFAULT_GRIDLINE_PAINT = Color.gray;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    private List angleTicks;
    private ValueAxis axis;
    private XYDataset dataset;
    private PolarItemRenderer renderer;
    private boolean angleLabelsVisible = true;
    private Font angleLabelFont = new Font("SansSerif", 0, 12);
    private transient Paint angleLabelPaint = Color.black;
    private boolean angleGridlinesVisible;
    private transient Stroke angleGridlineStroke;
    private transient Paint angleGridlinePaint;
    private boolean radiusGridlinesVisible;
    private transient Stroke radiusGridlineStroke;
    private transient Paint radiusGridlinePaint;
    private List cornerTextItems = new ArrayList();

    public PolarPlot() {
        this(null, null, null);
    }

    public PolarPlot(XYDataset xYDataset, ValueAxis valueAxis, PolarItemRenderer polarItemRenderer) {
        this.dataset = xYDataset;
        if (this.dataset != null) {
            this.dataset.addChangeListener(this);
        }
        this.angleTicks = new ArrayList();
        this.angleTicks.add(new NumberTick(new Double(0.0), "0", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(45.0), "45", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(90.0), "90", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(135.0), "135", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(180.0), "180", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(225.0), "225", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(270.0), "270", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(315.0), "315", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.axis = valueAxis;
        if (this.axis != null) {
            this.axis.setPlot(this);
            this.axis.addChangeListener(this);
        }
        this.renderer = polarItemRenderer;
        if (this.renderer != null) {
            this.renderer.setPlot(this);
            this.renderer.addChangeListener(this);
        }
        this.angleGridlinesVisible = true;
        this.angleGridlineStroke = DEFAULT_GRIDLINE_STROKE;
        this.angleGridlinePaint = DEFAULT_GRIDLINE_PAINT;
        this.radiusGridlinesVisible = true;
        this.radiusGridlineStroke = DEFAULT_GRIDLINE_STROKE;
        this.radiusGridlinePaint = DEFAULT_GRIDLINE_PAINT;
    }

    public void addCornerTextItem(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.cornerTextItems.add(string);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void removeCornerTextItem(String string) {
        boolean bl2 = this.cornerTextItems.remove(string);
        if (!bl2) return;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearCornerTextItems() {
        if (this.cornerTextItems.size() <= 0) return;
        this.cornerTextItems.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Polar_Plot");
    }

    public ValueAxis getAxis() {
        return this.axis;
    }

    public void setAxis(ValueAxis valueAxis) {
        if (valueAxis != null) {
            valueAxis.setPlot(this);
        }
        if (this.axis != null) {
            this.axis.removeChangeListener(this);
        }
        this.axis = valueAxis;
        if (this.axis != null) {
            this.axis.configure();
            this.axis.addChangeListener(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public XYDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(XYDataset xYDataset) {
        XYDataset xYDataset2 = this.dataset;
        if (xYDataset2 != null) {
            xYDataset2.removeChangeListener(this);
        }
        this.dataset = xYDataset;
        if (this.dataset != null) {
            this.setDatasetGroup(this.dataset.getGroup());
            this.dataset.addChangeListener(this);
        }
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, this.dataset);
        this.datasetChanged(datasetChangeEvent);
    }

    public PolarItemRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(PolarItemRenderer polarItemRenderer) {
        if (this.renderer != null) {
            this.renderer.removeChangeListener(this);
        }
        this.renderer = polarItemRenderer;
        if (this.renderer != null) {
            this.renderer.setPlot(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isAngleLabelsVisible() {
        return this.angleLabelsVisible;
    }

    public void setAngleLabelsVisible(boolean bl2) {
        if (this.angleLabelsVisible == bl2) return;
        this.angleLabelsVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Font getAngleLabelFont() {
        return this.angleLabelFont;
    }

    public void setAngleLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.angleLabelFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getAngleLabelPaint() {
        return this.angleLabelPaint;
    }

    public void setAngleLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.angleLabelPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isAngleGridlinesVisible() {
        return this.angleGridlinesVisible;
    }

    public void setAngleGridlinesVisible(boolean bl2) {
        if (this.angleGridlinesVisible == bl2) return;
        this.angleGridlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getAngleGridlineStroke() {
        return this.angleGridlineStroke;
    }

    public void setAngleGridlineStroke(Stroke stroke) {
        this.angleGridlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getAngleGridlinePaint() {
        return this.angleGridlinePaint;
    }

    public void setAngleGridlinePaint(Paint paint) {
        this.angleGridlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean isRadiusGridlinesVisible() {
        return this.radiusGridlinesVisible;
    }

    public void setRadiusGridlinesVisible(boolean bl2) {
        if (this.radiusGridlinesVisible == bl2) return;
        this.radiusGridlinesVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getRadiusGridlineStroke() {
        return this.radiusGridlineStroke;
    }

    public void setRadiusGridlineStroke(Stroke stroke) {
        this.radiusGridlineStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getRadiusGridlinePaint() {
        return this.radiusGridlinePaint;
    }

    public void setRadiusGridlinePaint(Paint paint) {
        this.radiusGridlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        boolean bl2 = rectangle2D.getWidth() <= 10.0;
        if (rectangle2D.getHeight() > 10.0) return;
        boolean bl3 = true;
        boolean bl4 = bl3;
        if (bl2) return;
        if (bl4) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        Rectangle2D rectangle2D2 = rectangle2D;
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(rectangle2D2);
        }
        this.drawBackground(graphics2D, rectangle2D2);
        double d2 = Math.min(rectangle2D2.getWidth() / 2.0, rectangle2D2.getHeight() / 2.0) - 20.0;
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D2.getCenterX(), rectangle2D2.getCenterY(), d2, d2);
        AxisState axisState = this.drawAxis(graphics2D, rectangle2D, double_);
        if (this.renderer != null) {
            Shape shape = graphics2D.getClip();
            Composite composite = graphics2D.getComposite();
            graphics2D.clip(rectangle2D2);
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
            this.drawGridlines(graphics2D, rectangle2D2, this.angleTicks, axisState.getTicks());
            this.render(graphics2D, rectangle2D2, plotRenderingInfo);
            graphics2D.setClip(shape);
            graphics2D.setComposite(composite);
        }
        this.drawOutline(graphics2D, rectangle2D2);
        this.drawCornerTextItems(graphics2D, rectangle2D2);
    }

    protected void drawCornerTextItems(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        if (this.cornerTextItems.isEmpty()) {
            return;
        }
        graphics2D.setColor(Color.black);
        double d2 = 0.0;
        double d3 = 0.0;
        for (String string : this.cornerTextItems) {
            FontMetrics fontMetrics = graphics2D.getFontMetrics();
            Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
            d2 = Math.max(d2, rectangle2D2.getWidth());
            d3 += rectangle2D2.getHeight();
        }
        double d4 = 14.0;
        double d5 = 7.0;
        double d6 = rectangle2D.getMaxX() - (d2 += d4);
        double d7 = rectangle2D.getMaxY() - (d3 += d5);
        graphics2D.drawRect((int)d6, (int)d7, (int)d2, (int)d3);
        d6 += 7.0;
        Iterator iterator = this.cornerTextItems.iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            Rectangle2D rectangle2D3 = TextUtilities.getTextBounds(string2, graphics2D, graphics2D.getFontMetrics());
            graphics2D.drawString(string2, (int)d6, (int)(d7 += rectangle2D3.getHeight()));
        }
    }

    protected AxisState drawAxis(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        return this.axis.draw(graphics2D, rectangle2D2.getMinY(), rectangle2D, rectangle2D2, RectangleEdge.TOP, null);
    }

    protected void render(Graphics2D graphics2D, Rectangle2D rectangle2D, PlotRenderingInfo plotRenderingInfo) {
        if (DatasetUtilities.isEmptyOrNull(this.dataset)) {
            this.drawNoDataMessage(graphics2D, rectangle2D);
            return;
        }
        int n2 = this.dataset.getSeriesCount();
        int n3 = 0;
        while (n3 < n2) {
            this.renderer.drawSeries(graphics2D, rectangle2D, plotRenderingInfo, this, this.dataset, n3);
            ++n3;
        }
    }

    protected void drawGridlines(Graphics2D graphics2D, Rectangle2D rectangle2D, List list, List list2) {
        Stroke stroke;
        Paint paint;
        if (this.renderer == null) {
            return;
        }
        if (this.isAngleGridlinesVisible()) {
            stroke = this.getAngleGridlineStroke();
            paint = this.getAngleGridlinePaint();
            if (stroke != null && paint != null) {
                this.renderer.drawAngularGridLines(graphics2D, this, list, rectangle2D);
            }
        }
        if (!this.isRadiusGridlinesVisible()) return;
        stroke = this.getRadiusGridlineStroke();
        paint = this.getRadiusGridlinePaint();
        if (stroke == null) return;
        if (paint == null) return;
        this.renderer.drawRadialGridLines(graphics2D, this, this.axis, list2, rectangle2D);
    }

    @Override
    public void zoom(double d2) {
        if (d2 > 0.0) {
            double d3 = this.getMaxRadius();
            double d4 = d3 * d2;
            this.axis.setUpperBound(d4);
            this.getAxis().setAutoRange(false);
            return;
        }
        this.getAxis().setAutoRange(true);
    }

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        Range range = null;
        if (this.dataset == null) return range;
        return Range.combine(range, DatasetUtilities.findRangeBounds(this.dataset));
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        if (this.axis != null) {
            this.axis.configure();
        }
        if (this.getParent() != null) {
            this.getParent().datasetChanged(datasetChangeEvent);
            return;
        }
        super.datasetChanged(datasetChangeEvent);
    }

    @Override
    public void rendererChanged(RendererChangeEvent rendererChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public int getSeriesCount() {
        int n2 = 0;
        if (this.dataset == null) return n2;
        return this.dataset.getSeriesCount();
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        if (this.dataset == null) return legendItemCollection;
        if (this.renderer == null) return legendItemCollection;
        int n2 = this.dataset.getSeriesCount();
        int n3 = 0;
        while (n3 < n2) {
            LegendItem legendItem = this.renderer.getLegendItem(n3);
            legendItemCollection.add(legendItem);
            ++n3;
        }
        return legendItemCollection;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PolarPlot)) {
            return false;
        }
        PolarPlot polarPlot = (PolarPlot)object;
        if (!ObjectUtilities.equal(this.axis, polarPlot.axis)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.renderer, polarPlot.renderer)) {
            return false;
        }
        if (this.angleGridlinesVisible != polarPlot.angleGridlinesVisible) {
            return false;
        }
        if (this.angleLabelsVisible != polarPlot.angleLabelsVisible) {
            return false;
        }
        if (!this.angleLabelFont.equals(polarPlot.angleLabelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.angleLabelPaint, polarPlot.angleLabelPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.angleGridlineStroke, polarPlot.angleGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.angleGridlinePaint, polarPlot.angleGridlinePaint)) {
            return false;
        }
        if (this.radiusGridlinesVisible != polarPlot.radiusGridlinesVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.radiusGridlineStroke, polarPlot.radiusGridlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.radiusGridlinePaint, polarPlot.radiusGridlinePaint)) {
            return false;
        }
        if (this.cornerTextItems.equals(polarPlot.cornerTextItems)) return super.equals(object);
        return false;
    }

    @Override
    public Object clone() {
        PolarPlot polarPlot = (PolarPlot)super.clone();
        if (this.axis != null) {
            polarPlot.axis = (ValueAxis)ObjectUtilities.clone(this.axis);
            polarPlot.axis.setPlot(polarPlot);
            polarPlot.axis.addChangeListener(polarPlot);
        }
        if (polarPlot.dataset != null) {
            polarPlot.dataset.addChangeListener(polarPlot);
        }
        if (this.renderer != null) {
            polarPlot.renderer = (PolarItemRenderer)ObjectUtilities.clone(this.renderer);
        }
        polarPlot.cornerTextItems = new ArrayList(this.cornerTextItems);
        return polarPlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.angleGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.angleGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.radiusGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.radiusGridlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.angleLabelPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.angleGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.angleGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.radiusGridlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.radiusGridlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.angleLabelPaint = SerialUtilities.readPaint(objectInputStream);
        if (this.axis != null) {
            this.axis.setPlot(this);
            this.axis.addChangeListener(this);
        }
        if (this.dataset == null) return;
        this.dataset.addChangeListener(this);
    }

    @Override
    public void zoomDomainAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
    }

    @Override
    public void zoomDomainAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
    }

    @Override
    public void zoomRangeAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.zoom(d2);
    }

    @Override
    public void zoomRangeAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.zoom((d3 + d2) / 2.0);
    }

    @Override
    public boolean isDomainZoomable() {
        return false;
    }

    @Override
    public boolean isRangeZoomable() {
        return true;
    }

    @Override
    public PlotOrientation getOrientation() {
        return PlotOrientation.HORIZONTAL;
    }

    public double getMaxRadius() {
        return this.axis.getUpperBound();
    }

    public Point translateValueThetaRadiusToJava2D(double d2, double d3, Rectangle2D rectangle2D) {
        double d4 = Math.toRadians(d2 - 90.0);
        double d5 = rectangle2D.getMinX() + 20.0;
        double d6 = rectangle2D.getMaxX() - 20.0;
        double d7 = rectangle2D.getMinY() + 20.0;
        double d8 = rectangle2D.getMaxY() - 20.0;
        double d9 = d6 - d5;
        double d10 = d8 - d7;
        double d11 = Math.min(d9, d10);
        double d12 = d5 + d9 / 2.0;
        double d13 = d7 + d10 / 2.0;
        double d14 = this.axis.getLowerBound();
        double d15 = this.getMaxRadius();
        double d16 = Math.max(d3, d14);
        double d17 = d11 / 2.0 * Math.cos(d4);
        double d18 = d11 / 2.0 * Math.sin(d4);
        float f2 = (float)(d12 + d17 * (d16 - d14) / (d15 - d14));
        float f3 = (float)(d13 + d18 * (d16 - d14) / (d15 - d14));
        int n2 = Math.round(f2);
        int n3 = Math.round(f3);
        return new Point(n2, n3);
    }
}

