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
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.Range;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.ValueDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class MeterPlot
extends Plot
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 2987472457734470962L;
    static final Paint DEFAULT_DIAL_BACKGROUND_PAINT = Color.black;
    static final Paint DEFAULT_NEEDLE_PAINT = Color.green;
    static final Font DEFAULT_VALUE_FONT = new Font("SansSerif", 1, 12);
    static final Paint DEFAULT_VALUE_PAINT = Color.yellow;
    public static final int DEFAULT_METER_ANGLE = 270;
    public static final float DEFAULT_BORDER_SIZE = 3.0f;
    public static final float DEFAULT_CIRCLE_SIZE = 10.0f;
    public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 1, 10);
    private ValueDataset dataset;
    private DialShape shape = DialShape.CIRCLE;
    private int meterAngle = 270;
    private Range range = new Range(0.0, 100.0);
    private double tickSize = 10.0;
    private transient Paint tickPaint = Color.white;
    private String units = "Units";
    private Font valueFont = DEFAULT_VALUE_FONT;
    private transient Paint valuePaint = DEFAULT_VALUE_PAINT;
    private boolean drawBorder;
    private transient Paint dialOutlinePaint;
    private transient Paint dialBackgroundPaint = DEFAULT_DIAL_BACKGROUND_PAINT;
    private transient Paint needlePaint = DEFAULT_NEEDLE_PAINT;
    private boolean tickLabelsVisible = true;
    private Font tickLabelFont = DEFAULT_LABEL_FONT;
    private transient Paint tickLabelPaint = Color.black;
    private NumberFormat tickLabelFormat = NumberFormat.getInstance();
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    private List intervals = new ArrayList();

    public MeterPlot() {
        this(null);
    }

    public MeterPlot(ValueDataset valueDataset) {
        this.setDataset(valueDataset);
    }

    public DialShape getDialShape() {
        return this.shape;
    }

    public void setDialShape(DialShape dialShape) {
        if (dialShape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.shape = dialShape;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public int getMeterAngle() {
        return this.meterAngle;
    }

    public void setMeterAngle(int n2) {
        if (n2 < 1) throw new IllegalArgumentException(new StringBuffer().append("Invalid 'angle' (").append(n2).append(")").toString());
        if (n2 > 360) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid 'angle' (").append(n2).append(")").toString());
        }
        this.meterAngle = n2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Range getRange() {
        return this.range;
    }

    public void setRange(Range range) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        if (range.getLength() <= 0.0) {
            throw new IllegalArgumentException("Range length must be positive.");
        }
        this.range = range;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public double getTickSize() {
        return this.tickSize;
    }

    public void setTickSize(double d2) {
        if (d2 <= 0.0) {
            throw new IllegalArgumentException("Requires 'size' > 0.");
        }
        this.tickSize = d2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getTickPaint() {
        return this.tickPaint;
    }

    public void setTickPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.tickPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String string) {
        this.units = string;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getNeedlePaint() {
        return this.needlePaint;
    }

    public void setNeedlePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.needlePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getTickLabelsVisible() {
        return this.tickLabelsVisible;
    }

    public void setTickLabelsVisible(boolean bl2) {
        if (this.tickLabelsVisible == bl2) return;
        this.tickLabelsVisible = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Font getTickLabelFont() {
        return this.tickLabelFont;
    }

    public void setTickLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (this.tickLabelFont.equals(font)) return;
        this.tickLabelFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getTickLabelPaint() {
        return this.tickLabelPaint;
    }

    public void setTickLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (this.tickLabelPaint.equals(paint)) return;
        this.tickLabelPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public NumberFormat getTickLabelFormat() {
        return this.tickLabelFormat;
    }

    public void setTickLabelFormat(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.tickLabelFormat = numberFormat;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Font getValueFont() {
        return this.valueFont;
    }

    public void setValueFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.valueFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getValuePaint() {
        return this.valuePaint;
    }

    public void setValuePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.valuePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDialBackgroundPaint() {
        return this.dialBackgroundPaint;
    }

    public void setDialBackgroundPaint(Paint paint) {
        this.dialBackgroundPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getDrawBorder() {
        return this.drawBorder;
    }

    public void setDrawBorder(boolean bl2) {
        this.drawBorder = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getDialOutlinePaint() {
        return this.dialOutlinePaint;
    }

    public void setDialOutlinePaint(Paint paint) {
        this.dialOutlinePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public ValueDataset getDataset() {
        return this.dataset;
    }

    public void setDataset(ValueDataset valueDataset) {
        ValueDataset valueDataset2 = this.dataset;
        if (valueDataset2 != null) {
            valueDataset2.removeChangeListener(this);
        }
        this.dataset = valueDataset;
        if (valueDataset != null) {
            this.setDatasetGroup(valueDataset.getGroup());
            valueDataset.addChangeListener(this);
        }
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, valueDataset);
        this.datasetChanged(datasetChangeEvent);
    }

    public List getIntervals() {
        return Collections.unmodifiableList(this.intervals);
    }

    public void addInterval(MeterInterval meterInterval) {
        if (meterInterval == null) {
            throw new IllegalArgumentException("Null 'interval' argument.");
        }
        this.intervals.add(meterInterval);
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void clearIntervals() {
        this.intervals.clear();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    @Override
    public LegendItemCollection getLegendItems() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        Iterator iterator = this.intervals.iterator();
        while (iterator.hasNext()) {
            MeterInterval meterInterval = (MeterInterval)iterator.next();
            Paint paint = meterInterval.getBackgroundPaint();
            if (paint == null) {
                paint = meterInterval.getOutlinePaint();
            }
            LegendItem legendItem = new LegendItem(meterInterval.getLabel(), meterInterval.getLabel(), null, null, (Shape)new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0), paint);
            legendItemCollection.add(legendItem);
        }
        return legendItemCollection;
    }

    @Override
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, PlotState plotState, PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(rectangle2D);
        }
        RectangleInsets rectangleInsets = this.getInsets();
        rectangleInsets.trim(rectangle2D);
        rectangle2D.setRect(rectangle2D.getX() + 4.0, rectangle2D.getY() + 4.0, rectangle2D.getWidth() - 8.0, rectangle2D.getHeight() - 8.0);
        if (this.drawBorder) {
            this.drawBackground(graphics2D, rectangle2D);
        }
        double d2 = 6.0;
        double d3 = 6.0;
        double d4 = rectangle2D.getX() + d2 / 2.0;
        double d5 = rectangle2D.getY() + d3 / 2.0;
        double d6 = rectangle2D.getWidth() - d2;
        double d7 = rectangle2D.getHeight() - d3 + (this.meterAngle <= 180 && this.shape != DialShape.CIRCLE ? rectangle2D.getHeight() / 1.25 : 0.0);
        double d8 = Math.min(d6, d7) / 2.0;
        d4 = (d4 + d4 + d6) / 2.0 - d8;
        d5 = (d5 + d5 + d7) / 2.0 - d8;
        d6 = 2.0 * d8;
        d7 = 2.0 * d8;
        Rectangle2D.Double double_ = new Rectangle2D.Double(d4, d5, d6, d7);
        Rectangle2D.Double double_2 = new Rectangle2D.Double(double_.getX() - 4.0, double_.getY() - 4.0, double_.getWidth() + 8.0, double_.getHeight() + 8.0);
        double d9 = double_.getCenterX();
        double d10 = double_.getCenterY();
        ValueDataset valueDataset = this.getDataset();
        if (valueDataset != null) {
            Number number2;
            double d11 = this.range.getLowerBound();
            double d12 = this.range.getUpperBound();
            Shape shape = graphics2D.getClip();
            graphics2D.clip(double_2);
            Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
            if (this.dialBackgroundPaint != null) {
                this.fillArc(graphics2D, double_2, d11, d12, this.dialBackgroundPaint, true);
            }
            this.drawTicks(graphics2D, double_, d11, d12);
            this.drawArcForInterval(graphics2D, double_, new MeterInterval("", this.range, this.dialOutlinePaint, new BasicStroke(1.0f), null));
            for (Number number2 : this.intervals) {
                this.drawArcForInterval(graphics2D, double_, (MeterInterval)((Object)number2));
            }
            number2 = valueDataset.getValue();
            if (number2 != null) {
                double d13 = number2.doubleValue();
                this.drawValueLabel(graphics2D, double_);
                if (this.range.contains(d13)) {
                    graphics2D.setPaint(this.needlePaint);
                    graphics2D.setStroke(new BasicStroke(2.0f));
                    double d14 = double_.getWidth() / 2.0 + 3.0 + 15.0;
                    double d15 = this.valueToAngle(d13);
                    double d16 = d9 + d14 * Math.cos(3.141592653589793 * (d15 / 180.0));
                    double d17 = d10 - d14 * Math.sin(3.141592653589793 * (d15 / 180.0));
                    Polygon polygon = new Polygon();
                    if (d15 > 135.0 && d15 < 225.0 || d15 < 45.0 && d15 > -45.0) {
                        double d18 = d10 - 2.5;
                        double d19 = d10 + 2.5;
                        polygon.addPoint((int)d9, (int)d18);
                        polygon.addPoint((int)d9, (int)d19);
                    } else {
                        polygon.addPoint((int)(d9 - 2.5), (int)d10);
                        polygon.addPoint((int)(d9 + 2.5), (int)d10);
                    }
                    polygon.addPoint((int)d16, (int)d17);
                    graphics2D.fill(polygon);
                    Ellipse2D.Double double_3 = new Ellipse2D.Double(d9 - 5.0, d10 - 5.0, 10.0, 10.0);
                    graphics2D.fill(double_3);
                }
            }
            graphics2D.setClip(shape);
            graphics2D.setComposite(composite);
        }
        if (!this.drawBorder) return;
        this.drawOutline(graphics2D, rectangle2D);
    }

    protected void drawArcForInterval(Graphics2D graphics2D, Rectangle2D rectangle2D, MeterInterval meterInterval) {
        double d2 = meterInterval.getRange().getLowerBound();
        double d3 = meterInterval.getRange().getUpperBound();
        Paint paint = meterInterval.getOutlinePaint();
        Stroke stroke = meterInterval.getOutlineStroke();
        Paint paint2 = meterInterval.getBackgroundPaint();
        if (paint2 != null) {
            this.fillArc(graphics2D, rectangle2D, d2, d3, paint2, false);
        }
        if (paint == null) return;
        if (stroke != null) {
            this.drawArc(graphics2D, rectangle2D, d2, d3, paint, stroke);
        }
        this.drawTick(graphics2D, rectangle2D, d2, true);
        this.drawTick(graphics2D, rectangle2D, d3, true);
    }

    protected void drawArc(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, double d3, Paint paint, Stroke stroke) {
        double d4 = this.valueToAngle(d3);
        double d5 = this.valueToAngle(d2);
        double d6 = d5 - d4;
        double d7 = rectangle2D.getX();
        double d8 = rectangle2D.getY();
        double d9 = rectangle2D.getWidth();
        double d10 = rectangle2D.getHeight();
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        if (paint == null) return;
        if (stroke == null) return;
        Arc2D.Double double_ = new Arc2D.Double(d7, d8, d9, d10, d4, d6, 0);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        graphics2D.draw(double_);
    }

    protected void fillArc(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, double d3, Paint paint, boolean bl2) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        double d4 = this.valueToAngle(d3);
        double d5 = this.valueToAngle(d2);
        double d6 = d5 - d4;
        double d7 = rectangle2D.getX();
        double d8 = rectangle2D.getY();
        double d9 = rectangle2D.getWidth();
        double d10 = rectangle2D.getHeight();
        int n2 = 0;
        if (this.shape == DialShape.PIE) {
            n2 = 2;
        } else if (this.shape == DialShape.CHORD) {
            n2 = bl2 && this.meterAngle > 180 ? 1 : 2;
        } else {
            if (this.shape != DialShape.CIRCLE) throw new IllegalStateException("DialShape not recognised.");
            n2 = 2;
            if (bl2) {
                d6 = 360.0;
            }
        }
        graphics2D.setPaint(paint);
        Arc2D.Double double_ = new Arc2D.Double(d7, d8, d9, d10, d4, d6, n2);
        graphics2D.fill(double_);
    }

    public double valueToAngle(double d2) {
        double d3 = 180 + (this.meterAngle - 180) / 2;
        return d3 - (d2 -= this.range.getLowerBound()) / this.range.getLength() * (double)this.meterAngle;
    }

    protected void drawTicks(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, double d3) {
        double d4 = d2;
        while (d4 <= d3) {
            this.drawTick(graphics2D, rectangle2D, d4);
            d4 += this.tickSize;
        }
    }

    protected void drawTick(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2) {
        this.drawTick(graphics2D, rectangle2D, d2, false);
    }

    protected void drawTick(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2, boolean bl2) {
        double d3 = this.valueToAngle(d2);
        double d4 = rectangle2D.getCenterX();
        double d5 = rectangle2D.getCenterY();
        graphics2D.setPaint(this.tickPaint);
        graphics2D.setStroke(new BasicStroke(2.0f));
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = rectangle2D.getWidth() / 2.0 + 3.0;
        double d9 = d8 - 15.0;
        double d10 = d4 + d8 * Math.cos(3.141592653589793 * (d3 / 180.0));
        double d11 = d5 - d8 * Math.sin(3.141592653589793 * (d3 / 180.0));
        d6 = d4 + d9 * Math.cos(3.141592653589793 * (d3 / 180.0));
        d7 = d5 - d9 * Math.sin(3.141592653589793 * (d3 / 180.0));
        Line2D.Double double_ = new Line2D.Double(d10, d11, d6, d7);
        graphics2D.draw(double_);
        if (!this.tickLabelsVisible) return;
        if (!bl2) return;
        String string = this.tickLabelFormat.format(d2);
        graphics2D.setFont(this.tickLabelFont);
        graphics2D.setPaint(this.tickLabelPaint);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        double d12 = d6;
        double d13 = d7;
        if (d3 == 90.0 || d3 == 270.0) {
            d12 -= rectangle2D2.getWidth() / 2.0;
        } else if (d3 < 90.0 || d3 > 270.0) {
            d12 -= rectangle2D2.getWidth();
        }
        d13 = d3 > 135.0 && d3 < 225.0 || d3 > 315.0 || d3 < 45.0 ? (d13 -= rectangle2D2.getHeight() / 2.0) : (d13 += rectangle2D2.getHeight() / 2.0);
        graphics2D.drawString(string, (float)d12, (float)d13);
    }

    protected void drawValueLabel(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Number number;
        graphics2D.setFont(this.valueFont);
        graphics2D.setPaint(this.valuePaint);
        String string = "No value";
        if (this.dataset != null && (number = this.dataset.getValue()) != null) {
            string = new StringBuffer().append(this.tickLabelFormat.format(number.doubleValue())).append(" ").append(this.units).toString();
        }
        float f2 = (float)rectangle2D.getCenterX();
        float f3 = (float)rectangle2D.getCenterY() + 10.0f;
        TextUtilities.drawAlignedString(string, graphics2D, f2, f3, TextAnchor.TOP_CENTER);
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Meter_Plot");
    }

    @Override
    public void zoom(double d2) {
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MeterPlot)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        MeterPlot meterPlot = (MeterPlot)object;
        if (!ObjectUtilities.equal(this.units, meterPlot.units)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.range, meterPlot.range)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.intervals, meterPlot.intervals)) {
            return false;
        }
        if (!PaintUtilities.equal(this.dialOutlinePaint, meterPlot.dialOutlinePaint)) {
            return false;
        }
        if (this.shape != meterPlot.shape) {
            return false;
        }
        if (!PaintUtilities.equal(this.dialBackgroundPaint, meterPlot.dialBackgroundPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.needlePaint, meterPlot.needlePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.valueFont, meterPlot.valueFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.valuePaint, meterPlot.valuePaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.tickPaint, meterPlot.tickPaint)) {
            return false;
        }
        if (this.tickSize != meterPlot.tickSize) {
            return false;
        }
        if (this.tickLabelsVisible != meterPlot.tickLabelsVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickLabelFont, meterPlot.tickLabelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.tickLabelPaint, meterPlot.tickLabelPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickLabelFormat, meterPlot.tickLabelFormat)) {
            return false;
        }
        if (this.drawBorder != meterPlot.drawBorder) {
            return false;
        }
        if (this.meterAngle == meterPlot.meterAngle) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.dialBackgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.needlePaint, objectOutputStream);
        SerialUtilities.writePaint(this.valuePaint, objectOutputStream);
        SerialUtilities.writePaint(this.tickPaint, objectOutputStream);
        SerialUtilities.writePaint(this.tickLabelPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.dialBackgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.needlePaint = SerialUtilities.readPaint(objectInputStream);
        this.valuePaint = SerialUtilities.readPaint(objectInputStream);
        this.tickPaint = SerialUtilities.readPaint(objectInputStream);
        this.tickLabelPaint = SerialUtilities.readPaint(objectInputStream);
        if (this.dataset == null) return;
        this.dataset.addChangeListener(this);
    }

    @Override
    public Object clone() {
        MeterPlot meterPlot = (MeterPlot)super.clone();
        meterPlot.tickLabelFormat = (NumberFormat)this.tickLabelFormat.clone();
        meterPlot.intervals = new ArrayList(this.intervals);
        if (meterPlot.dataset == null) return meterPlot;
        meterPlot.dataset.addChangeListener(meterPlot);
        return meterPlot;
    }
}

