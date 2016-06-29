package org.jfree.chart.plot;

import org.jfree.data.xy.*;
import org.jfree.chart.renderer.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.data.general.*;
import org.jfree.data.*;
import org.jfree.chart.event.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class PolarPlot extends Plot implements Serializable, Cloneable, RendererChangeListener, ValueAxisPlot, Zoomable
{
    private static final long serialVersionUID = 3794383185924179525L;
    private static final int MARGIN = 20;
    private static final double ANNOTATION_MARGIN = 7.0;
    public static final Stroke DEFAULT_GRIDLINE_STROKE;
    public static final Paint DEFAULT_GRIDLINE_PAINT;
    protected static ResourceBundle localizationResources;
    private List angleTicks;
    private ValueAxis axis;
    private XYDataset dataset;
    private PolarItemRenderer renderer;
    private boolean angleLabelsVisible;
    private Font angleLabelFont;
    private transient Paint angleLabelPaint;
    private boolean angleGridlinesVisible;
    private transient Stroke angleGridlineStroke;
    private transient Paint angleGridlinePaint;
    private boolean radiusGridlinesVisible;
    private transient Stroke radiusGridlineStroke;
    private transient Paint radiusGridlinePaint;
    private List cornerTextItems;
    
    public PolarPlot() {
        this(null, null, null);
    }
    
    public PolarPlot(final XYDataset dataset, final ValueAxis axis, final PolarItemRenderer renderer) {
        this.angleLabelsVisible = true;
        this.angleLabelFont = new Font("SansSerif", 0, 12);
        this.angleLabelPaint = Color.black;
        this.cornerTextItems = new ArrayList();
        this.dataset = dataset;
        if (this.dataset != null) {
            this.dataset.addChangeListener(this);
        }
        (this.angleTicks = new ArrayList()).add(new NumberTick(new Double(0.0), "0", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(45.0), "45", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(90.0), "90", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(135.0), "135", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(180.0), "180", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(225.0), "225", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(270.0), "270", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.angleTicks.add(new NumberTick(new Double(315.0), "315", TextAnchor.CENTER, TextAnchor.CENTER, 0.0));
        this.axis = axis;
        if (this.axis != null) {
            this.axis.setPlot(this);
            this.axis.addChangeListener(this);
        }
        this.renderer = renderer;
        if (this.renderer != null) {
            this.renderer.setPlot(this);
            this.renderer.addChangeListener(this);
        }
        this.angleGridlinesVisible = true;
        this.angleGridlineStroke = PolarPlot.DEFAULT_GRIDLINE_STROKE;
        this.angleGridlinePaint = PolarPlot.DEFAULT_GRIDLINE_PAINT;
        this.radiusGridlinesVisible = true;
        this.radiusGridlineStroke = PolarPlot.DEFAULT_GRIDLINE_STROKE;
        this.radiusGridlinePaint = PolarPlot.DEFAULT_GRIDLINE_PAINT;
    }
    
    public void addCornerTextItem(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("Null 'text' argument.");
        }
        this.cornerTextItems.add(s);
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void removeCornerTextItem(final String s) {
        if (this.cornerTextItems.remove(s)) {
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void clearCornerTextItems() {
        if (this.cornerTextItems.size() > 0) {
            this.cornerTextItems.clear();
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public String getPlotType() {
        return PolarPlot.localizationResources.getString("Polar_Plot");
    }
    
    public ValueAxis getAxis() {
        return this.axis;
    }
    
    public void setAxis(final ValueAxis axis) {
        if (axis != null) {
            axis.setPlot(this);
        }
        if (this.axis != null) {
            this.axis.removeChangeListener(this);
        }
        this.axis = axis;
        if (this.axis != null) {
            this.axis.configure();
            this.axis.addChangeListener(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public XYDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final XYDataset dataset) {
        final XYDataset dataset2 = this.dataset;
        if (dataset2 != null) {
            dataset2.removeChangeListener(this);
        }
        this.dataset = dataset;
        if (this.dataset != null) {
            this.setDatasetGroup(this.dataset.getGroup());
            this.dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, this.dataset));
    }
    
    public PolarItemRenderer getRenderer() {
        return this.renderer;
    }
    
    public void setRenderer(final PolarItemRenderer renderer) {
        if (this.renderer != null) {
            this.renderer.removeChangeListener(this);
        }
        this.renderer = renderer;
        if (this.renderer != null) {
            this.renderer.setPlot(this);
        }
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isAngleLabelsVisible() {
        return this.angleLabelsVisible;
    }
    
    public void setAngleLabelsVisible(final boolean angleLabelsVisible) {
        if (this.angleLabelsVisible != angleLabelsVisible) {
            this.angleLabelsVisible = angleLabelsVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Font getAngleLabelFont() {
        return this.angleLabelFont;
    }
    
    public void setAngleLabelFont(final Font angleLabelFont) {
        if (angleLabelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.angleLabelFont = angleLabelFont;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getAngleLabelPaint() {
        return this.angleLabelPaint;
    }
    
    public void setAngleLabelPaint(final Paint angleLabelPaint) {
        if (angleLabelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.angleLabelPaint = angleLabelPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isAngleGridlinesVisible() {
        return this.angleGridlinesVisible;
    }
    
    public void setAngleGridlinesVisible(final boolean angleGridlinesVisible) {
        if (this.angleGridlinesVisible != angleGridlinesVisible) {
            this.angleGridlinesVisible = angleGridlinesVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getAngleGridlineStroke() {
        return this.angleGridlineStroke;
    }
    
    public void setAngleGridlineStroke(final Stroke angleGridlineStroke) {
        this.angleGridlineStroke = angleGridlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getAngleGridlinePaint() {
        return this.angleGridlinePaint;
    }
    
    public void setAngleGridlinePaint(final Paint angleGridlinePaint) {
        this.angleGridlinePaint = angleGridlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean isRadiusGridlinesVisible() {
        return this.radiusGridlinesVisible;
    }
    
    public void setRadiusGridlinesVisible(final boolean radiusGridlinesVisible) {
        if (this.radiusGridlinesVisible != radiusGridlinesVisible) {
            this.radiusGridlinesVisible = radiusGridlinesVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Stroke getRadiusGridlineStroke() {
        return this.radiusGridlineStroke;
    }
    
    public void setRadiusGridlineStroke(final Stroke radiusGridlineStroke) {
        this.radiusGridlineStroke = radiusGridlineStroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getRadiusGridlinePaint() {
        return this.radiusGridlinePaint;
    }
    
    public void setRadiusGridlinePaint(final Paint radiusGridlinePaint) {
        this.radiusGridlinePaint = radiusGridlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        final boolean b = rectangle2D.getWidth() <= 10.0;
        final boolean b2 = rectangle2D.getHeight() <= 10.0;
        if (b || b2) {
            return;
        }
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        this.getInsets().trim(rectangle2D);
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setDataArea(rectangle2D);
        }
        this.drawBackground(graphics2D, rectangle2D);
        final double n = Math.min(rectangle2D.getWidth() / 2.0, rectangle2D.getHeight() / 2.0) - 20.0;
        final AxisState drawAxis = this.drawAxis(graphics2D, rectangle2D, new Rectangle2D.Double(rectangle2D.getCenterX(), rectangle2D.getCenterY(), n, n));
        if (this.renderer != null) {
            final Shape clip = graphics2D.getClip();
            final Composite composite = graphics2D.getComposite();
            graphics2D.clip(rectangle2D);
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
            this.drawGridlines(graphics2D, rectangle2D, this.angleTicks, drawAxis.getTicks());
            this.render(graphics2D, rectangle2D, plotRenderingInfo);
            graphics2D.setClip(clip);
            graphics2D.setComposite(composite);
        }
        this.drawOutline(graphics2D, rectangle2D);
        this.drawCornerTextItems(graphics2D, rectangle2D);
    }
    
    protected void drawCornerTextItems(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        if (this.cornerTextItems.isEmpty()) {
            return;
        }
        graphics2D.setColor(Color.black);
        double max = 0.0;
        double n = 0.0;
        final Iterator<String> iterator = this.cornerTextItems.iterator();
        while (iterator.hasNext()) {
            final Rectangle2D textBounds = TextUtilities.getTextBounds(iterator.next(), graphics2D, graphics2D.getFontMetrics());
            max = Math.max(max, textBounds.getWidth());
            n += textBounds.getHeight();
        }
        final double n2 = 14.0;
        final double n3 = 7.0;
        final double n4 = max + n2;
        final double n5 = n + n3;
        final double n6 = rectangle2D.getMaxX() - n4;
        double n7 = rectangle2D.getMaxY() - n5;
        graphics2D.drawRect((int)n6, (int)n7, (int)n4, (int)n5);
        final double n8 = n6 + 7.0;
        for (final String s : this.cornerTextItems) {
            n7 += TextUtilities.getTextBounds(s, graphics2D, graphics2D.getFontMetrics()).getHeight();
            graphics2D.drawString(s, (int)n8, (int)n7);
        }
    }
    
    protected AxisState drawAxis(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2) {
        return this.axis.draw(graphics2D, rectangle2D2.getMinY(), rectangle2D, rectangle2D2, RectangleEdge.TOP, null);
    }
    
    protected void render(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final PlotRenderingInfo plotRenderingInfo) {
        if (!DatasetUtilities.isEmptyOrNull(this.dataset)) {
            for (int seriesCount = this.dataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
                this.renderer.drawSeries(graphics2D, rectangle2D, plotRenderingInfo, this, this.dataset, i);
            }
        }
        else {
            this.drawNoDataMessage(graphics2D, rectangle2D);
        }
    }
    
    protected void drawGridlines(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final List list, final List list2) {
        if (this.renderer == null) {
            return;
        }
        if (this.isAngleGridlinesVisible()) {
            final Stroke angleGridlineStroke = this.getAngleGridlineStroke();
            final Paint angleGridlinePaint = this.getAngleGridlinePaint();
            if (angleGridlineStroke != null && angleGridlinePaint != null) {
                this.renderer.drawAngularGridLines(graphics2D, this, list, rectangle2D);
            }
        }
        if (this.isRadiusGridlinesVisible()) {
            final Stroke radiusGridlineStroke = this.getRadiusGridlineStroke();
            final Paint radiusGridlinePaint = this.getRadiusGridlinePaint();
            if (radiusGridlineStroke != null && radiusGridlinePaint != null) {
                this.renderer.drawRadialGridLines(graphics2D, this, this.axis, list2, rectangle2D);
            }
        }
    }
    
    public void zoom(final double n) {
        if (n > 0.0) {
            this.axis.setUpperBound(this.getMaxRadius() * n);
            this.getAxis().setAutoRange(false);
        }
        else {
            this.getAxis().setAutoRange(true);
        }
    }
    
    public Range getDataRange(final ValueAxis valueAxis) {
        Range combine = null;
        if (this.dataset != null) {
            combine = Range.combine(combine, DatasetUtilities.findRangeBounds(this.dataset));
        }
        return combine;
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        if (this.axis != null) {
            this.axis.configure();
        }
        if (this.getParent() != null) {
            this.getParent().datasetChanged(datasetChangeEvent);
        }
        else {
            super.datasetChanged(datasetChangeEvent);
        }
    }
    
    public void rendererChanged(final RendererChangeEvent rendererChangeEvent) {
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public int getSeriesCount() {
        int seriesCount = 0;
        if (this.dataset != null) {
            seriesCount = this.dataset.getSeriesCount();
        }
        return seriesCount;
    }
    
    public LegendItemCollection getLegendItems() {
        final LegendItemCollection collection = new LegendItemCollection();
        if (this.dataset != null && this.renderer != null) {
            for (int seriesCount = this.dataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
                collection.add(this.renderer.getLegendItem(i));
            }
        }
        return collection;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PolarPlot)) {
            return false;
        }
        final PolarPlot polarPlot = (PolarPlot)o;
        return ObjectUtilities.equal(this.axis, polarPlot.axis) && ObjectUtilities.equal(this.renderer, polarPlot.renderer) && this.angleGridlinesVisible == polarPlot.angleGridlinesVisible && this.angleLabelsVisible == polarPlot.angleLabelsVisible && this.angleLabelFont.equals(polarPlot.angleLabelFont) && PaintUtilities.equal(this.angleLabelPaint, polarPlot.angleLabelPaint) && ObjectUtilities.equal(this.angleGridlineStroke, polarPlot.angleGridlineStroke) && PaintUtilities.equal(this.angleGridlinePaint, polarPlot.angleGridlinePaint) && this.radiusGridlinesVisible == polarPlot.radiusGridlinesVisible && ObjectUtilities.equal(this.radiusGridlineStroke, polarPlot.radiusGridlineStroke) && PaintUtilities.equal(this.radiusGridlinePaint, polarPlot.radiusGridlinePaint) && this.cornerTextItems.equals(polarPlot.cornerTextItems) && super.equals(o);
    }
    
    public Object clone() {
        final PolarPlot plot = (PolarPlot)super.clone();
        if (this.axis != null) {
            (plot.axis = (ValueAxis)ObjectUtilities.clone(this.axis)).setPlot(plot);
            plot.axis.addChangeListener(plot);
        }
        if (plot.dataset != null) {
            plot.dataset.addChangeListener(plot);
        }
        if (this.renderer != null) {
            plot.renderer = (PolarItemRenderer)ObjectUtilities.clone(this.renderer);
        }
        plot.cornerTextItems = new ArrayList(this.cornerTextItems);
        return plot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.angleGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.angleGridlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.radiusGridlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.radiusGridlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.angleLabelPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
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
        if (this.dataset != null) {
            this.dataset.addChangeListener(this);
        }
    }
    
    public void zoomDomainAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
    }
    
    public void zoomDomainAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
    }
    
    public void zoomRangeAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.zoom(n);
    }
    
    public void zoomRangeAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.zoom((n2 + n) / 2.0);
    }
    
    public boolean isDomainZoomable() {
        return false;
    }
    
    public boolean isRangeZoomable() {
        return true;
    }
    
    public PlotOrientation getOrientation() {
        return PlotOrientation.HORIZONTAL;
    }
    
    public double getMaxRadius() {
        return this.axis.getUpperBound();
    }
    
    public Point translateValueThetaRadiusToJava2D(final double n, final double n2, final Rectangle2D rectangle2D) {
        final double radians = Math.toRadians(n - 90.0);
        final double n3 = rectangle2D.getMinX() + 20.0;
        final double n4 = rectangle2D.getMaxX() - 20.0;
        final double n5 = rectangle2D.getMinY() + 20.0;
        final double n6 = rectangle2D.getMaxY() - 20.0;
        final double n7 = n4 - n3;
        final double n8 = n6 - n5;
        final double min = Math.min(n7, n8);
        final double n9 = n3 + n7 / 2.0;
        final double n10 = n5 + n8 / 2.0;
        final double lowerBound = this.axis.getLowerBound();
        final double maxRadius = this.getMaxRadius();
        final double max = Math.max(n2, lowerBound);
        return new Point(Math.round((float)(n9 + min / 2.0 * Math.cos(radians) * (max - lowerBound) / (maxRadius - lowerBound))), Math.round((float)(n10 + min / 2.0 * Math.sin(radians) * (max - lowerBound) / (maxRadius - lowerBound))));
    }
    
    static {
        DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5f, 0, 2, 0.0f, new float[] { 2.0f, 2.0f }, 0.0f);
        DEFAULT_GRIDLINE_PAINT = Color.gray;
        PolarPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
