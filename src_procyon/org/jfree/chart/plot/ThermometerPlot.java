package org.jfree.chart.plot;

import java.text.*;
import org.jfree.chart.axis.*;
import org.jfree.data.general.*;
import org.jfree.chart.event.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.data.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;

public class ThermometerPlot extends Plot implements Serializable, Cloneable, ValueAxisPlot, Zoomable
{
    private static final long serialVersionUID = 4087093313147984390L;
    public static final int UNITS_NONE = 0;
    public static final int UNITS_FAHRENHEIT = 1;
    public static final int UNITS_CELCIUS = 2;
    public static final int UNITS_KELVIN = 3;
    public static final int NONE = 0;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int BULB = 3;
    public static final int NORMAL = 0;
    public static final int WARNING = 1;
    public static final int CRITICAL = 2;
    protected static final int BULB_RADIUS = 40;
    protected static final int BULB_DIAMETER = 80;
    protected static final int COLUMN_RADIUS = 20;
    protected static final int COLUMN_DIAMETER = 40;
    protected static final int GAP_RADIUS = 5;
    protected static final int GAP_DIAMETER = 10;
    protected static final int AXIS_GAP = 10;
    protected static final String[] UNITS;
    protected static final int RANGE_LOW = 0;
    protected static final int RANGE_HIGH = 1;
    protected static final int DISPLAY_LOW = 2;
    protected static final int DISPLAY_HIGH = 3;
    protected static final double DEFAULT_LOWER_BOUND = 0.0;
    protected static final double DEFAULT_UPPER_BOUND = 100.0;
    private ValueDataset dataset;
    private ValueAxis rangeAxis;
    private double lowerBound;
    private double upperBound;
    private RectangleInsets padding;
    private transient Stroke thermometerStroke;
    private transient Paint thermometerPaint;
    private int units;
    private int valueLocation;
    private int axisLocation;
    private Font valueFont;
    private transient Paint valuePaint;
    private NumberFormat valueFormat;
    private transient Paint mercuryPaint;
    private boolean showValueLines;
    private int subrange;
    private double[][] subrangeInfo;
    private boolean followDataInSubranges;
    private boolean useSubrangePaint;
    private Paint[] subrangePaint;
    private boolean subrangeIndicatorsVisible;
    private transient Stroke subrangeIndicatorStroke;
    private transient Stroke rangeIndicatorStroke;
    protected static ResourceBundle localizationResources;
    
    public ThermometerPlot() {
        this(new DefaultValueDataset());
    }
    
    public ThermometerPlot(final ValueDataset dataset) {
        this.lowerBound = 0.0;
        this.upperBound = 100.0;
        this.thermometerStroke = new BasicStroke(1.0f);
        this.thermometerPaint = Color.black;
        this.units = 2;
        this.valueLocation = 3;
        this.axisLocation = 2;
        this.valueFont = new Font("SansSerif", 1, 16);
        this.valuePaint = Color.white;
        this.valueFormat = new DecimalFormat();
        this.mercuryPaint = Color.lightGray;
        this.showValueLines = false;
        this.subrange = -1;
        this.subrangeInfo = new double[][] { { 0.0, 50.0, 0.0, 50.0 }, { 50.0, 75.0, 50.0, 75.0 }, { 75.0, 100.0, 75.0, 100.0 } };
        this.followDataInSubranges = false;
        this.useSubrangePaint = true;
        this.subrangePaint = new Paint[] { Color.green, Color.orange, Color.red };
        this.subrangeIndicatorsVisible = true;
        this.subrangeIndicatorStroke = new BasicStroke(2.0f);
        this.rangeIndicatorStroke = new BasicStroke(3.0f);
        this.padding = new RectangleInsets(UnitType.RELATIVE, 0.05, 0.05, 0.05, 0.05);
        this.dataset = dataset;
        if (dataset != null) {
            dataset.addChangeListener(this);
        }
        final NumberAxis rangeAxis = new NumberAxis(null);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAxisLineVisible(false);
        this.setRangeAxis(rangeAxis);
        this.setAxisRange();
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
    
    public ValueAxis getRangeAxis() {
        return this.rangeAxis;
    }
    
    public void setRangeAxis(final ValueAxis rangeAxis) {
        if (rangeAxis != null) {
            rangeAxis.setPlot(this);
            rangeAxis.addChangeListener(this);
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.removeChangeListener(this);
        }
        this.rangeAxis = rangeAxis;
    }
    
    public double getLowerBound() {
        return this.lowerBound;
    }
    
    public void setLowerBound(final double lowerBound) {
        this.lowerBound = lowerBound;
        this.setAxisRange();
    }
    
    public double getUpperBound() {
        return this.upperBound;
    }
    
    public void setUpperBound(final double upperBound) {
        this.upperBound = upperBound;
        this.setAxisRange();
    }
    
    public void setRange(final double lowerBound, final double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.setAxisRange();
    }
    
    public RectangleInsets getPadding() {
        return this.padding;
    }
    
    public void setPadding(final RectangleInsets padding) {
        this.padding = padding;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public Stroke getThermometerStroke() {
        return this.thermometerStroke;
    }
    
    public void setThermometerStroke(final Stroke thermometerStroke) {
        if (thermometerStroke != null) {
            this.thermometerStroke = thermometerStroke;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Paint getThermometerPaint() {
        return this.thermometerPaint;
    }
    
    public void setThermometerPaint(final Paint thermometerPaint) {
        if (thermometerPaint != null) {
            this.thermometerPaint = thermometerPaint;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public int getUnits() {
        return this.units;
    }
    
    public void setUnits(final int units) {
        if (units >= 0 && units < ThermometerPlot.UNITS.length && this.units != units) {
            this.units = units;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setUnits(String trim) {
        if (trim == null) {
            return;
        }
        trim = trim.toUpperCase().trim();
        for (int i = 0; i < ThermometerPlot.UNITS.length; ++i) {
            if (trim.equals(ThermometerPlot.UNITS[i].toUpperCase().trim())) {
                this.setUnits(i);
                i = ThermometerPlot.UNITS.length;
            }
        }
    }
    
    public int getValueLocation() {
        return this.valueLocation;
    }
    
    public void setValueLocation(final int valueLocation) {
        if (valueLocation >= 0 && valueLocation < 4) {
            this.valueLocation = valueLocation;
            this.notifyListeners(new PlotChangeEvent(this));
            return;
        }
        throw new IllegalArgumentException("Location not recognised.");
    }
    
    public void setAxisLocation(final int axisLocation) {
        if (axisLocation >= 0 && axisLocation < 3) {
            this.axisLocation = axisLocation;
            this.notifyListeners(new PlotChangeEvent(this));
            return;
        }
        throw new IllegalArgumentException("Location not recognised.");
    }
    
    public int getAxisLocation() {
        return this.axisLocation;
    }
    
    public Font getValueFont() {
        return this.valueFont;
    }
    
    public void setValueFont(final Font valueFont) {
        if (valueFont != null && !this.valueFont.equals(valueFont)) {
            this.valueFont = valueFont;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Paint getValuePaint() {
        return this.valuePaint;
    }
    
    public void setValuePaint(final Paint valuePaint) {
        if (valuePaint != null && !this.valuePaint.equals(valuePaint)) {
            this.valuePaint = valuePaint;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setValueFormat(final NumberFormat valueFormat) {
        if (valueFormat != null) {
            this.valueFormat = valueFormat;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public Paint getMercuryPaint() {
        return this.mercuryPaint;
    }
    
    public void setMercuryPaint(final Paint mercuryPaint) {
        this.mercuryPaint = mercuryPaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getShowValueLines() {
        return this.showValueLines;
    }
    
    public void setShowValueLines(final boolean showValueLines) {
        this.showValueLines = showValueLines;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void setSubrangeInfo(final int n, final double n2, final double n3) {
        this.setSubrangeInfo(n, n2, n3, n2, n3);
    }
    
    public void setSubrangeInfo(final int n, final double n2, final double n3, final double n4, final double n5) {
        if (n >= 0 && n < 3) {
            this.setSubrange(n, n2, n3);
            this.setDisplayRange(n, n4, n5);
            this.setAxisRange();
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public void setSubrange(final int n, final double n2, final double n3) {
        if (n >= 0 && n < 3) {
            this.subrangeInfo[n][1] = n3;
            this.subrangeInfo[n][0] = n2;
        }
    }
    
    public void setDisplayRange(final int n, final double n2, final double n3) {
        if (n >= 0 && n < this.subrangeInfo.length && isValidNumber(n3) && isValidNumber(n2)) {
            if (n3 > n2) {
                this.subrangeInfo[n][3] = n3;
                this.subrangeInfo[n][2] = n2;
            }
            else {
                this.subrangeInfo[n][3] = n2;
                this.subrangeInfo[n][2] = n3;
            }
        }
    }
    
    public Paint getSubrangePaint(final int n) {
        if (n >= 0 && n < this.subrangePaint.length) {
            return this.subrangePaint[n];
        }
        return this.mercuryPaint;
    }
    
    public void setSubrangePaint(final int n, final Paint paint) {
        if (n >= 0 && n < this.subrangePaint.length && paint != null) {
            this.subrangePaint[n] = paint;
            this.notifyListeners(new PlotChangeEvent(this));
        }
    }
    
    public boolean getFollowDataInSubranges() {
        return this.followDataInSubranges;
    }
    
    public void setFollowDataInSubranges(final boolean followDataInSubranges) {
        this.followDataInSubranges = followDataInSubranges;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public boolean getUseSubrangePaint() {
        return this.useSubrangePaint;
    }
    
    public void setUseSubrangePaint(final boolean useSubrangePaint) {
        this.useSubrangePaint = useSubrangePaint;
        this.notifyListeners(new PlotChangeEvent(this));
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D plotArea, final Point2D point2D, final PlotState plotState, final PlotRenderingInfo plotRenderingInfo) {
        final RoundRectangle2D.Double double1 = new RoundRectangle2D.Double();
        final RoundRectangle2D.Double double2 = new RoundRectangle2D.Double();
        final RoundRectangle2D.Double double3 = new RoundRectangle2D.Double();
        final Ellipse2D.Double double4 = new Ellipse2D.Double();
        final Ellipse2D.Double double5 = new Ellipse2D.Double();
        if (plotRenderingInfo != null) {
            plotRenderingInfo.setPlotArea(plotArea);
        }
        this.getInsets().trim(plotArea);
        this.drawBackground(graphics2D, plotArea);
        final Rectangle2D rectangle2D = (Rectangle2D)plotArea.clone();
        this.padding.trim(rectangle2D);
        final int n = (int)(rectangle2D.getX() + rectangle2D.getWidth() / 2.0);
        final int n2 = (int)(rectangle2D.getY() + rectangle2D.getHeight() / 2.0);
        final int n3 = (int)(rectangle2D.getMinY() + 40.0);
        final int n4 = (int)(rectangle2D.getMaxY() - 80.0);
        final Rectangle2D.Double double6 = new Rectangle2D.Double(n - 20, n3, 20.0, n4 - n3);
        double4.setFrame(n - 40, n4, 80.0, 80.0);
        double1.setRoundRect(n - 20, rectangle2D.getMinY(), 40.0, n4 + 80 - n3, 40.0, 40.0);
        final Area area = new Area(double4);
        area.add(new Area(double1));
        double5.setFrame(n - 40 + 5, n4 + 5, 70.0, 70.0);
        double2.setRoundRect(n - 20 + 5, rectangle2D.getMinY() + 5.0, 30.0, n4 + 80 - 10 - n3, 30.0, 30.0);
        final Area area2 = new Area(double5);
        area2.add(new Area(double2));
        if (this.dataset != null && this.dataset.getValue() != null) {
            final double doubleValue = this.dataset.getValue().doubleValue();
            final double valueToJava2D = this.rangeAxis.valueToJava2D(doubleValue, double6, RectangleEdge.LEFT);
            final int n5 = 30;
            final int n6 = 15;
            int n7 = n5 / 2;
            int n8 = (int)Math.round(valueToJava2D);
            if (n8 < 5.0 + rectangle2D.getMinY()) {
                n8 = (int)(5.0 + rectangle2D.getMinY());
                n7 = 40;
            }
            final Area area3 = new Area(double5);
            if (n8 < n4 + 40) {
                double3.setRoundRect(n - n6, n8, n5, n4 + 40 - n8, n7, n7);
                area3.add(new Area(double3));
            }
            graphics2D.setPaint(this.getCurrentPaint());
            graphics2D.fill(area3);
            if (this.subrangeIndicatorsVisible) {
                graphics2D.setStroke(this.subrangeIndicatorStroke);
                final Range range = this.rangeAxis.getRange();
                final double n9 = this.subrangeInfo[0][0];
                if (range.contains(n9)) {
                    final double n10 = n + 20 + 2;
                    final double valueToJava2D2 = this.rangeAxis.valueToJava2D(n9, double6, RectangleEdge.LEFT);
                    final Line2D.Double double7 = new Line2D.Double(n10, valueToJava2D2, n10 + 10.0, valueToJava2D2);
                    graphics2D.setPaint(this.subrangePaint[0]);
                    graphics2D.draw(double7);
                }
                final double n11 = this.subrangeInfo[1][0];
                if (range.contains(n11)) {
                    final double n12 = n + 20 + 2;
                    final double valueToJava2D3 = this.rangeAxis.valueToJava2D(n11, double6, RectangleEdge.LEFT);
                    final Line2D.Double double8 = new Line2D.Double(n12, valueToJava2D3, n12 + 10.0, valueToJava2D3);
                    graphics2D.setPaint(this.subrangePaint[1]);
                    graphics2D.draw(double8);
                }
                final double n13 = this.subrangeInfo[2][0];
                if (range.contains(n13)) {
                    final double n14 = n + 20 + 2;
                    final double valueToJava2D4 = this.rangeAxis.valueToJava2D(n13, double6, RectangleEdge.LEFT);
                    final Line2D.Double double9 = new Line2D.Double(n14, valueToJava2D4, n14 + 10.0, valueToJava2D4);
                    graphics2D.setPaint(this.subrangePaint[2]);
                    graphics2D.draw(double9);
                }
            }
            if (this.rangeAxis != null && this.axisLocation != 0) {
                int n15 = 10;
                if (this.showValueLines) {
                    n15 += 40;
                }
                switch (this.axisLocation) {
                    case 1: {
                        final double n16 = n + 20;
                        this.rangeAxis.draw(graphics2D, n16, plotArea, new Rectangle2D.Double(n16, n3, n15, n4 - n3 + 1), RectangleEdge.RIGHT, null);
                        break;
                    }
                    default: {
                        final double n17 = n - 20;
                        this.rangeAxis.draw(graphics2D, n17, plotArea, new Rectangle2D.Double(n17, n3, n15, n4 - n3 + 1), RectangleEdge.LEFT, null);
                        break;
                    }
                }
            }
            graphics2D.setFont(this.valueFont);
            graphics2D.setPaint(this.valuePaint);
            final FontMetrics fontMetrics = graphics2D.getFontMetrics();
            switch (this.valueLocation) {
                case 1: {
                    graphics2D.drawString(this.valueFormat.format(doubleValue), n + 20 + 5, n2);
                    break;
                }
                case 2: {
                    final String format = this.valueFormat.format(doubleValue);
                    graphics2D.drawString(format, n - 20 - 5 - fontMetrics.stringWidth(format), n2);
                    break;
                }
                case 3: {
                    final String format2 = this.valueFormat.format(doubleValue);
                    graphics2D.drawString(format2, n - fontMetrics.stringWidth(format2) / 2, n4 + 40 + 5);
                    break;
                }
            }
        }
        graphics2D.setPaint(this.thermometerPaint);
        graphics2D.setFont(this.valueFont);
        final int n18 = n - 20 - 10 - graphics2D.getFontMetrics().stringWidth(ThermometerPlot.UNITS[this.units]);
        if (n18 > plotArea.getMinX()) {
            graphics2D.drawString(ThermometerPlot.UNITS[this.units], n18, (int)(plotArea.getMinY() + 20.0));
        }
        graphics2D.setStroke(this.thermometerStroke);
        graphics2D.draw(area);
        graphics2D.draw(area2);
        this.drawOutline(graphics2D, plotArea);
    }
    
    public void zoom(final double n) {
    }
    
    public String getPlotType() {
        return ThermometerPlot.localizationResources.getString("Thermometer_Plot");
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        final Number value = this.dataset.getValue();
        if (value != null) {
            final double doubleValue = value.doubleValue();
            if (this.inSubrange(0, doubleValue)) {
                this.subrange = 0;
            }
            else if (this.inSubrange(1, doubleValue)) {
                this.subrange = 1;
            }
            else if (this.inSubrange(2, doubleValue)) {
                this.subrange = 2;
            }
            else {
                this.subrange = -1;
            }
            this.setAxisRange();
        }
        super.datasetChanged(datasetChangeEvent);
    }
    
    public Number getMinimumVerticalDataValue() {
        return new Double(this.lowerBound);
    }
    
    public Number getMaximumVerticalDataValue() {
        return new Double(this.upperBound);
    }
    
    public Range getDataRange(final ValueAxis valueAxis) {
        return new Range(this.lowerBound, this.upperBound);
    }
    
    protected void setAxisRange() {
        if (this.subrange >= 0 && this.followDataInSubranges) {
            this.rangeAxis.setRange(new Range(this.subrangeInfo[this.subrange][2], this.subrangeInfo[this.subrange][3]));
        }
        else {
            this.rangeAxis.setRange(this.lowerBound, this.upperBound);
        }
    }
    
    public LegendItemCollection getLegendItems() {
        return null;
    }
    
    public PlotOrientation getOrientation() {
        return PlotOrientation.VERTICAL;
    }
    
    protected static boolean isValidNumber(final double n) {
        return !Double.isNaN(n) && !Double.isInfinite(n);
    }
    
    private boolean inSubrange(final int n, final double n2) {
        return n2 > this.subrangeInfo[n][0] && n2 <= this.subrangeInfo[n][1];
    }
    
    private Paint getCurrentPaint() {
        Paint mercuryPaint = this.mercuryPaint;
        if (this.useSubrangePaint) {
            final double doubleValue = this.dataset.getValue().doubleValue();
            if (this.inSubrange(0, doubleValue)) {
                mercuryPaint = this.subrangePaint[0];
            }
            else if (this.inSubrange(1, doubleValue)) {
                mercuryPaint = this.subrangePaint[1];
            }
            else if (this.inSubrange(2, doubleValue)) {
                mercuryPaint = this.subrangePaint[2];
            }
        }
        return mercuryPaint;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ThermometerPlot)) {
            return false;
        }
        final ThermometerPlot thermometerPlot = (ThermometerPlot)o;
        if (!super.equals(o)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.rangeAxis, thermometerPlot.rangeAxis)) {
            return false;
        }
        if (this.axisLocation != thermometerPlot.axisLocation) {
            return false;
        }
        if (this.lowerBound != thermometerPlot.lowerBound) {
            return false;
        }
        if (this.upperBound != thermometerPlot.upperBound) {
            return false;
        }
        if (!ObjectUtilities.equal(this.padding, thermometerPlot.padding)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.thermometerStroke, thermometerPlot.thermometerStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.thermometerPaint, thermometerPlot.thermometerPaint)) {
            return false;
        }
        if (this.units != thermometerPlot.units) {
            return false;
        }
        if (this.valueLocation != thermometerPlot.valueLocation) {
            return false;
        }
        if (!ObjectUtilities.equal(this.valueFont, thermometerPlot.valueFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.valuePaint, thermometerPlot.valuePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.valueFormat, thermometerPlot.valueFormat)) {
            return false;
        }
        if (!PaintUtilities.equal(this.mercuryPaint, thermometerPlot.mercuryPaint)) {
            return false;
        }
        if (this.showValueLines != thermometerPlot.showValueLines) {
            return false;
        }
        if (this.subrange != thermometerPlot.subrange) {
            return false;
        }
        if (this.followDataInSubranges != thermometerPlot.followDataInSubranges) {
            return false;
        }
        if (!equal(this.subrangeInfo, thermometerPlot.subrangeInfo)) {
            return false;
        }
        if (this.useSubrangePaint != thermometerPlot.useSubrangePaint) {
            return false;
        }
        for (int i = 0; i < this.subrangePaint.length; ++i) {
            if (!PaintUtilities.equal(this.subrangePaint[i], thermometerPlot.subrangePaint[i])) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean equal(final double[][] array, final double[][] array2) {
        if (array == null) {
            return array2 == null;
        }
        if (array2 == null) {
            return false;
        }
        if (array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (!Arrays.equals(array[i], array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public Object clone() {
        final ThermometerPlot plot = (ThermometerPlot)super.clone();
        if (plot.dataset != null) {
            plot.dataset.addChangeListener(plot);
        }
        plot.rangeAxis = (ValueAxis)ObjectUtilities.clone(this.rangeAxis);
        if (plot.rangeAxis != null) {
            plot.rangeAxis.setPlot(plot);
            plot.rangeAxis.addChangeListener(plot);
        }
        plot.valueFormat = (NumberFormat)this.valueFormat.clone();
        plot.subrangePaint = this.subrangePaint.clone();
        return plot;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.thermometerStroke, objectOutputStream);
        SerialUtilities.writePaint(this.thermometerPaint, objectOutputStream);
        SerialUtilities.writePaint(this.valuePaint, objectOutputStream);
        SerialUtilities.writePaint(this.mercuryPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.subrangeIndicatorStroke, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeIndicatorStroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.thermometerStroke = SerialUtilities.readStroke(objectInputStream);
        this.thermometerPaint = SerialUtilities.readPaint(objectInputStream);
        this.valuePaint = SerialUtilities.readPaint(objectInputStream);
        this.mercuryPaint = SerialUtilities.readPaint(objectInputStream);
        this.subrangeIndicatorStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeIndicatorStroke = SerialUtilities.readStroke(objectInputStream);
        if (this.rangeAxis != null) {
            this.rangeAxis.addChangeListener(this);
        }
    }
    
    public void zoomDomainAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
    }
    
    public void zoomRangeAxes(final double n, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.rangeAxis.resizeRange(n);
    }
    
    public void zoomDomainAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
    }
    
    public void zoomRangeAxes(final double n, final double n2, final PlotRenderingInfo plotRenderingInfo, final Point2D point2D) {
        this.rangeAxis.zoomRange(n, n2);
    }
    
    public boolean isDomainZoomable() {
        return false;
    }
    
    public boolean isRangeZoomable() {
        return true;
    }
    
    static {
        UNITS = new String[] { "", "°F", "°C", "°K" };
        ThermometerPlot.localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
    }
}
