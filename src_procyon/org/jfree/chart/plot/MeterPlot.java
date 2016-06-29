package org.jfree.chart.plot;

import org.jfree.data.*;
import java.text.*;
import org.jfree.chart.event.*;
import org.jfree.data.general.*;
import org.jfree.chart.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.util.*;

public class MeterPlot extends Plot implements Serializable, Cloneable
{
    private static final long serialVersionUID = 2987472457734470962L;
    static final Paint DEFAULT_DIAL_BACKGROUND_PAINT;
    static final Paint DEFAULT_NEEDLE_PAINT;
    static final Font DEFAULT_VALUE_FONT;
    static final Paint DEFAULT_VALUE_PAINT;
    public static final int DEFAULT_METER_ANGLE = 270;
    public static final float DEFAULT_BORDER_SIZE = 3.0f;
    public static final float DEFAULT_CIRCLE_SIZE = 10.0f;
    public static final Font DEFAULT_LABEL_FONT;
    private ValueDataset dataset;
    private DialShape shape;
    private int meterAngle;
    private Range range;
    private double tickSize;
    private transient Paint tickPaint;
    private String units;
    private Font valueFont;
    private transient Paint valuePaint;
    private boolean drawBorder;
    private transient Paint dialOutlinePaint;
    private transient Paint dialBackgroundPaint;
    private transient Paint needlePaint;
    private boolean tickLabelsVisible;
    private Font tickLabelFont;
    private transient Paint tickLabelPaint;
    private NumberFormat tickLabelFormat;
    protected static ResourceBundle localizationResources;
    private List intervals;
    
    public MeterPlot() {
        this(null);
    }
    
    public MeterPlot(final ValueDataset dataset) {
        this.shape = DialShape.CIRCLE;
        this.meterAngle = 270;
        this.range = new Range(0.0, 100.0);
        this.tickSize = 10.0;
        this.tickPaint = Color.white;
        this.units = "Units";
        this.needlePaint = MeterPlot.DEFAULT_NEEDLE_PAINT;
        this.tickLabelsVisible = true;
        this.tickLabelFont = MeterPlot.DEFAULT_LABEL_FONT;
        this.tickLabelPaint = Color.black;
        this.tickLabelFormat = NumberFormat.getInstance();
        this.valueFont = MeterPlot.DEFAULT_VALUE_FONT;
        this.valuePaint = MeterPlot.DEFAULT_VALUE_PAINT;
        this.dialBackgroundPaint = MeterPlot.DEFAULT_DIAL_BACKGROUND_PAINT;
        this.intervals = new ArrayList();
        this.setDataset(dataset);
    }
    
    public DialShape getDialShape() {
        return this.shape;
    }
    
    public void setDialShape(final DialShape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.shape = shape;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public int getMeterAngle() {
        return this.meterAngle;
    }
    
    public void setMeterAngle(final int meterAngle) {
        if (meterAngle < 1 || meterAngle > 360) {
            throw new IllegalArgumentException("Invalid 'angle' (" + meterAngle + ")");
        }
        this.meterAngle = meterAngle;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Range getRange() {
        return this.range;
    }
    
    public void setRange(final Range range) {
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
    
    public void setTickSize(final double tickSize) {
        if (tickSize <= 0.0) {
            throw new IllegalArgumentException("Requires 'size' > 0.");
        }
        this.tickSize = tickSize;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getTickPaint() {
        return this.tickPaint;
    }
    
    public void setTickPaint(final Paint tickPaint) {
        if (tickPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.tickPaint = tickPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public String getUnits() {
        return this.units;
    }
    
    public void setUnits(final String units) {
        this.units = units;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getNeedlePaint() {
        return this.needlePaint;
    }
    
    public void setNeedlePaint(final Paint needlePaint) {
        if (needlePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.needlePaint = needlePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getTickLabelsVisible() {
        return this.tickLabelsVisible;
    }
    
    public void setTickLabelsVisible(final boolean tickLabelsVisible) {
        if (this.tickLabelsVisible != tickLabelsVisible) {
            this.tickLabelsVisible = tickLabelsVisible;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Font getTickLabelFont() {
        return this.tickLabelFont;
    }
    
    public void setTickLabelFont(final Font tickLabelFont) {
        if (tickLabelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (!this.tickLabelFont.equals(tickLabelFont)) {
            this.tickLabelFont = tickLabelFont;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Paint getTickLabelPaint() {
        return this.tickLabelPaint;
    }
    
    public void setTickLabelPaint(final Paint tickLabelPaint) {
        if (tickLabelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (!this.tickLabelPaint.equals(tickLabelPaint)) {
            this.tickLabelPaint = tickLabelPaint;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public NumberFormat getTickLabelFormat() {
        return this.tickLabelFormat;
    }
    
    public void setTickLabelFormat(final NumberFormat tickLabelFormat) {
        if (tickLabelFormat == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.tickLabelFormat = tickLabelFormat;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Font getValueFont() {
        return this.valueFont;
    }
    
    public void setValueFont(final Font valueFont) {
        if (valueFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.valueFont = valueFont;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getValuePaint() {
        return this.valuePaint;
    }
    
    public void setValuePaint(final Paint valuePaint) {
        if (valuePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.valuePaint = valuePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDialBackgroundPaint() {
        return this.dialBackgroundPaint;
    }
    
    public void setDialBackgroundPaint(final Paint dialBackgroundPaint) {
        this.dialBackgroundPaint = dialBackgroundPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getDrawBorder() {
        return this.drawBorder;
    }
    
    public void setDrawBorder(final boolean drawBorder) {
        this.drawBorder = drawBorder;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Paint getDialOutlinePaint() {
        return this.dialOutlinePaint;
    }
    
    public void setDialOutlinePaint(final Paint dialOutlinePaint) {
        this.dialOutlinePaint = dialOutlinePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public ValueDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final ValueDataset dataset) {
        final ValueDataset dataset2 = this.dataset;
        if (dataset2 != null) {
            dataset2.removeChangeListener(this);
        }
        if ((this.dataset = dataset) != null) {
            this.setDatasetGroup(dataset.getGroup());
            dataset.addChangeListener(this);
        }
        this.datasetChanged(new DatasetChangeEvent(this, dataset));
    }
    
    public List getIntervals() {
        return Collections.unmodifiableList((List<?>)this.intervals);
    }
    
    public void addInterval(final MeterInterval meterInterval) {
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
    
    public LegendItemCollection getLegendItems() {
        final LegendItemCollection collection = new LegendItemCollection();
        for (final MeterInterval meterInterval : this.intervals) {
            Paint paint = meterInterval.getBackgroundPaint();
            if (paint == null) {
                paint = meterInterval.getOutlinePaint();
            }
            collection.add(new LegendItem(meterInterval.getLabel(), meterInterval.getLabel(), null, null, new Rectangle2D.Double(-4.0, -4.0, 8.0, 8.0), paint));
        }
        return collection;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        plotArea.setRect(plotArea.getX() + 4.0, plotArea.getY() + 4.0, plotArea.getWidth() - 8.0, plotArea.getHeight() - 8.0);
        if (this.drawBorder) {
            this.drawBackground(graphics2D, plotArea);
        }
        final double n = 6.0;
        final double n2 = 6.0;
        final double n3 = plotArea.getX() + n / 2.0;
        final double n4 = plotArea.getY() + n2 / 2.0;
        final double n5 = plotArea.getWidth() - n;
        final double n6 = plotArea.getHeight() - n2 + ((this.meterAngle <= 180 && this.shape != DialShape.CIRCLE) ? (plotArea.getHeight() / 1.25) : 0.0);
        final double n7 = Math.min(n5, n6) / 2.0;
        final Rectangle2D.Double double1 = new Rectangle2D.Double((n3 + n3 + n5) / 2.0 - n7, (n4 + n4 + n6) / 2.0 - n7, 2.0 * n7, 2.0 * n7);
        final Rectangle2D.Double double2 = new Rectangle2D.Double(double1.getX() - 4.0, double1.getY() - 4.0, double1.getWidth() + 8.0, double1.getHeight() + 8.0);
        final double centerX = double1.getCenterX();
        final double centerY = double1.getCenterY();
        final ValueDataset dataset = this.getDataset();
        if (dataset != null) {
            final double lowerBound = this.range.getLowerBound();
            final double upperBound = this.range.getUpperBound();
            final Shape clip = graphics2D.getClip();
            graphics2D.clip(double2);
            final Composite composite = graphics2D.getComposite();
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
            if (this.dialBackgroundPaint != null) {
                this.fillArc(graphics2D, double2, lowerBound, upperBound, this.dialBackgroundPaint, true);
            }
            this.drawTicks(graphics2D, double1, lowerBound, upperBound);
            this.drawArcForInterval(graphics2D, double1, new MeterInterval("", this.range, this.dialOutlinePaint, new BasicStroke(1.0f), null));
            final Iterator<MeterInterval> iterator = (Iterator<MeterInterval>)this.intervals.iterator();
            while (iterator.hasNext()) {
                this.drawArcForInterval(graphics2D, double1, iterator.next());
            }
            final Number value = dataset.getValue();
            if (value != null) {
                final double doubleValue = value.doubleValue();
                this.drawValueLabel(graphics2D, double1);
                if (this.range.contains(doubleValue)) {
                    graphics2D.setPaint(this.needlePaint);
                    graphics2D.setStroke(new BasicStroke(2.0f));
                    final double n8 = double1.getWidth() / 2.0 + 3.0 + 15.0;
                    final double valueToAngle = this.valueToAngle(doubleValue);
                    final double n9 = centerX + n8 * Math.cos(3.141592653589793 * (valueToAngle / 180.0));
                    final double n10 = centerY - n8 * Math.sin(3.141592653589793 * (valueToAngle / 180.0));
                    final Polygon polygon = new Polygon();
                    if ((valueToAngle > 135.0 && valueToAngle < 225.0) || (valueToAngle < 45.0 && valueToAngle > -45.0)) {
                        final double n11 = centerY - 2.5;
                        final double n12 = centerY + 2.5;
                        polygon.addPoint((int)centerX, (int)n11);
                        polygon.addPoint((int)centerX, (int)n12);
                    }
                    else {
                        polygon.addPoint((int)(centerX - 2.5), (int)centerY);
                        polygon.addPoint((int)(centerX + 2.5), (int)centerY);
                    }
                    polygon.addPoint((int)n9, (int)n10);
                    graphics2D.fill(polygon);
                    graphics2D.fill(new Ellipse2D.Double(centerX - 5.0, centerY - 5.0, 10.0, 10.0));
                }
            }
            graphics2D.setClip(clip);
            graphics2D.setComposite(composite);
        }
        if (this.drawBorder) {
            this.drawOutline(graphics2D, plotArea);
        }
    }
    
    protected void drawArcForInterval(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final MeterInterval meterInterval) {
        final double lowerBound = meterInterval.getRange().getLowerBound();
        final double upperBound = meterInterval.getRange().getUpperBound();
        final Paint outlinePaint = meterInterval.getOutlinePaint();
        final Stroke outlineStroke = meterInterval.getOutlineStroke();
        final Paint backgroundPaint = meterInterval.getBackgroundPaint();
        if (backgroundPaint != null) {
            this.fillArc(graphics2D, rectangle2D, lowerBound, upperBound, backgroundPaint, false);
        }
        if (outlinePaint != null) {
            if (outlineStroke != null) {
                this.drawArc(graphics2D, rectangle2D, lowerBound, upperBound, outlinePaint, outlineStroke);
            }
            this.drawTick(graphics2D, rectangle2D, lowerBound, true);
            this.drawTick(graphics2D, rectangle2D, upperBound, true);
        }
    }
    
    protected void drawArc(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final double n2, final Paint paint, final Stroke stroke) {
        final double valueToAngle = this.valueToAngle(n2);
        final double n3 = this.valueToAngle(n) - valueToAngle;
        final double x = rectangle2D.getX();
        final double y = rectangle2D.getY();
        final double width = rectangle2D.getWidth();
        final double height = rectangle2D.getHeight();
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
        if (paint != null && stroke != null) {
            final Arc2D.Double double1 = new Arc2D.Double(x, y, width, height, valueToAngle, n3, 0);
            graphics2D.setPaint(paint);
            graphics2D.setStroke(stroke);
            graphics2D.draw(double1);
        }
    }
    
    protected void fillArc(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final double n2, final Paint paint, final boolean b) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument");
        }
        final double valueToAngle = this.valueToAngle(n2);
        double n3 = this.valueToAngle(n) - valueToAngle;
        final double x = rectangle2D.getX();
        final double y = rectangle2D.getY();
        final double width = rectangle2D.getWidth();
        final double height = rectangle2D.getHeight();
        int n4;
        if (this.shape == DialShape.PIE) {
            n4 = 2;
        }
        else if (this.shape == DialShape.CHORD) {
            if (b && this.meterAngle > 180) {
                n4 = 1;
            }
            else {
                n4 = 2;
            }
        }
        else {
            if (this.shape != DialShape.CIRCLE) {
                throw new IllegalStateException("DialShape not recognised.");
            }
            n4 = 2;
            if (b) {
                n3 = 360.0;
            }
        }
        graphics2D.setPaint(paint);
        graphics2D.fill(new Arc2D.Double(x, y, width, height, valueToAngle, n3, n4));
    }
    
    public double valueToAngle(double n) {
        n -= this.range.getLowerBound();
        return 180 + (this.meterAngle - 180) / 2 - n / this.range.getLength() * this.meterAngle;
    }
    
    protected void drawTicks(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final double n2) {
        for (double n3 = n; n3 <= n2; n3 += this.tickSize) {
            this.drawTick(graphics2D, rectangle2D, n3);
        }
    }
    
    protected void drawTick(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n) {
        this.drawTick(graphics2D, rectangle2D, n, false);
    }
    
    protected void drawTick(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n, final boolean b) {
        final double valueToAngle = this.valueToAngle(n);
        final double centerX = rectangle2D.getCenterX();
        final double centerY = rectangle2D.getCenterY();
        graphics2D.setPaint(this.tickPaint);
        graphics2D.setStroke(new BasicStroke(2.0f));
        final double n2 = rectangle2D.getWidth() / 2.0 + 3.0;
        final double n3 = n2 - 15.0;
        final double n4 = centerX + n2 * Math.cos(3.141592653589793 * (valueToAngle / 180.0));
        final double n5 = centerY - n2 * Math.sin(3.141592653589793 * (valueToAngle / 180.0));
        final double n6 = centerX + n3 * Math.cos(3.141592653589793 * (valueToAngle / 180.0));
        final double n7 = centerY - n3 * Math.sin(3.141592653589793 * (valueToAngle / 180.0));
        graphics2D.draw(new Line2D.Double(n4, n5, n6, n7));
        if (this.tickLabelsVisible && b) {
            final String format = this.tickLabelFormat.format(n);
            graphics2D.setFont(this.tickLabelFont);
            graphics2D.setPaint(this.tickLabelPaint);
            final Rectangle2D textBounds = TextUtilities.getTextBounds(format, graphics2D, graphics2D.getFontMetrics());
            double n8 = n6;
            final double n9 = n7;
            if (valueToAngle == 90.0 || valueToAngle == 270.0) {
                n8 -= textBounds.getWidth() / 2.0;
            }
            else if (valueToAngle < 90.0 || valueToAngle > 270.0) {
                n8 -= textBounds.getWidth();
            }
            double n10;
            if ((valueToAngle > 135.0 && valueToAngle < 225.0) || valueToAngle > 315.0 || valueToAngle < 45.0) {
                n10 = n9 - textBounds.getHeight() / 2.0;
            }
            else {
                n10 = n9 + textBounds.getHeight() / 2.0;
            }
            graphics2D.drawString(format, (float)n8, (float)n10);
        }
    }
    
    protected void drawValueLabel(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        graphics2D.setFont(this.valueFont);
        graphics2D.setPaint(this.valuePaint);
        String string = "No value";
        if (this.dataset != null) {
            final Number value = this.dataset.getValue();
            if (value != null) {
                string = this.tickLabelFormat.format(value.doubleValue()) + " " + this.units;
            }
        }
        TextUtilities.drawAlignedString(string, graphics2D, (float)rectangle2D.getCenterX(), (float)rectangle2D.getCenterY() + 10.0f, TextAnchor.TOP_CENTER);
    }
    
    public String getPlotType() {
        return MeterPlot.localizationResources.getString("Meter_Plot");
    }
    
    public void zoom(final double n) {
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MeterPlot)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final MeterPlot meterPlot = (MeterPlot)o;
        return ObjectUtilities.equal(this.units, meterPlot.units) && ObjectUtilities.equal(this.range, meterPlot.range) && ObjectUtilities.equal(this.intervals, meterPlot.intervals) && PaintUtilities.equal(this.dialOutlinePaint, meterPlot.dialOutlinePaint) && this.shape == meterPlot.shape && PaintUtilities.equal(this.dialBackgroundPaint, meterPlot.dialBackgroundPaint) && PaintUtilities.equal(this.needlePaint, meterPlot.needlePaint) && ObjectUtilities.equal(this.valueFont, meterPlot.valueFont) && PaintUtilities.equal(this.valuePaint, meterPlot.valuePaint) && PaintUtilities.equal(this.tickPaint, meterPlot.tickPaint) && this.tickSize == meterPlot.tickSize && this.tickLabelsVisible == meterPlot.tickLabelsVisible && ObjectUtilities.equal(this.tickLabelFont, meterPlot.tickLabelFont) && PaintUtilities.equal(this.tickLabelPaint, meterPlot.tickLabelPaint) && ObjectUtilities.equal(this.tickLabelFormat, meterPlot.tickLabelFormat) && this.drawBorder == meterPlot.drawBorder && this.meterAngle == meterPlot.meterAngle;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.dialBackgroundPaint, objectOutputStream);
        SerialUtilities.writePaint(this.needlePaint, objectOutputStream);
        SerialUtilities.writePaint(this.valuePaint, objectOutputStream);
        SerialUtilities.writePaint(this.tickPaint, objectOutputStream);
        SerialUtilities.writePaint(this.tickLabelPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.dialBackgroundPaint = SerialUtilities.readPaint(objectInputStream);
        this.needlePaint = SerialUtilities.readPaint(objectInputStream);
        this.valuePaint = SerialUtilities.readPaint(objectInputStream);
        this.tickPaint = SerialUtilities.readPaint(objectInputStream);
        this.tickLabelPaint = SerialUtilities.readPaint(objectInputStream);
        if (this.dataset != null) {
            this.dataset.addChangeListener(this);
        }
    }
    
    public Object clone() {
        final MeterPlot meterPlot = (MeterPlot)super.clone();
        meterPlot.tickLabelFormat = (NumberFormat)this.tickLabelFormat.clone();
        meterPlot.intervals = new ArrayList(this.intervals);
        if (meterPlot.dataset != null) {
            meterPlot.dataset.addChangeListener(meterPlot);
        }
        return meterPlot;
    }
    
    static {
        DEFAULT_DIAL_BACKGROUND_PAINT = Color.black;
        DEFAULT_NEEDLE_PAINT = Color.green;
        DEFAULT_VALUE_FONT = new Font("SansSerif", 1, 12);
        DEFAULT_VALUE_PAINT = Color.yellow;
        DEFAULT_LABEL_FONT = new Font("SansSerif", 1, 10);
        MeterPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
