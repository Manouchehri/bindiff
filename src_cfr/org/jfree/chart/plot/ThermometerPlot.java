/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.data.Range;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.UnitType;

public class ThermometerPlot
extends Plot
implements Serializable,
Cloneable,
ValueAxisPlot,
Zoomable {
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
    protected static final String[] UNITS = new String[]{"", "\u00b0F", "\u00b0C", "\u00b0K"};
    protected static final int RANGE_LOW = 0;
    protected static final int RANGE_HIGH = 1;
    protected static final int DISPLAY_LOW = 2;
    protected static final int DISPLAY_HIGH = 3;
    protected static final double DEFAULT_LOWER_BOUND = 0.0;
    protected static final double DEFAULT_UPPER_BOUND = 100.0;
    private ValueDataset dataset;
    private ValueAxis rangeAxis;
    private double lowerBound = 0.0;
    private double upperBound = 100.0;
    private RectangleInsets padding = new RectangleInsets(UnitType.RELATIVE, 0.05, 0.05, 0.05, 0.05);
    private transient Stroke thermometerStroke = new BasicStroke(1.0f);
    private transient Paint thermometerPaint = Color.black;
    private int units = 2;
    private int valueLocation = 3;
    private int axisLocation = 2;
    private Font valueFont = new Font("SansSerif", 1, 16);
    private transient Paint valuePaint = Color.white;
    private NumberFormat valueFormat = new DecimalFormat();
    private transient Paint mercuryPaint = Color.lightGray;
    private boolean showValueLines = false;
    private int subrange = -1;
    private double[][] subrangeInfo = new double[][]{{0.0, 50.0, 0.0, 50.0}, {50.0, 75.0, 50.0, 75.0}, {75.0, 100.0, 75.0, 100.0}};
    private boolean followDataInSubranges = false;
    private boolean useSubrangePaint = true;
    private Paint[] subrangePaint = new Paint[]{Color.green, Color.orange, Color.red};
    private boolean subrangeIndicatorsVisible = true;
    private transient Stroke subrangeIndicatorStroke = new BasicStroke(2.0f);
    private transient Stroke rangeIndicatorStroke = new BasicStroke(3.0f);
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

    public ThermometerPlot() {
        this(new DefaultValueDataset());
    }

    public ThermometerPlot(ValueDataset valueDataset) {
        this.dataset = valueDataset;
        if (valueDataset != null) {
            valueDataset.addChangeListener(this);
        }
        NumberAxis numberAxis = new NumberAxis(null);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setAxisLineVisible(false);
        this.setRangeAxis(numberAxis);
        this.setAxisRange();
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

    public ValueAxis getRangeAxis() {
        return this.rangeAxis;
    }

    public void setRangeAxis(ValueAxis valueAxis) {
        if (valueAxis != null) {
            valueAxis.setPlot(this);
            valueAxis.addChangeListener(this);
        }
        if (this.rangeAxis != null) {
            this.rangeAxis.removeChangeListener(this);
        }
        this.rangeAxis = valueAxis;
    }

    public double getLowerBound() {
        return this.lowerBound;
    }

    public void setLowerBound(double d2) {
        this.lowerBound = d2;
        this.setAxisRange();
    }

    public double getUpperBound() {
        return this.upperBound;
    }

    public void setUpperBound(double d2) {
        this.upperBound = d2;
        this.setAxisRange();
    }

    public void setRange(double d2, double d3) {
        this.lowerBound = d2;
        this.upperBound = d3;
        this.setAxisRange();
    }

    public RectangleInsets getPadding() {
        return this.padding;
    }

    public void setPadding(RectangleInsets rectangleInsets) {
        this.padding = rectangleInsets;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Stroke getThermometerStroke() {
        return this.thermometerStroke;
    }

    public void setThermometerStroke(Stroke stroke) {
        if (stroke == null) return;
        this.thermometerStroke = stroke;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getThermometerPaint() {
        return this.thermometerPaint;
    }

    public void setThermometerPaint(Paint paint) {
        if (paint == null) return;
        this.thermometerPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public int getUnits() {
        return this.units;
    }

    public void setUnits(int n2) {
        if (n2 < 0) return;
        if (n2 >= UNITS.length) return;
        if (this.units == n2) return;
        this.units = n2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setUnits(String string) {
        if (string == null) {
            return;
        }
        string = string.toUpperCase().trim();
        int n2 = 0;
        while (n2 < UNITS.length) {
            if (string.equals(UNITS[n2].toUpperCase().trim())) {
                this.setUnits(n2);
                n2 = UNITS.length;
            }
            ++n2;
        }
    }

    public int getValueLocation() {
        return this.valueLocation;
    }

    public void setValueLocation(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Location not recognised.");
        if (n2 >= 4) throw new IllegalArgumentException("Location not recognised.");
        this.valueLocation = n2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setAxisLocation(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Location not recognised.");
        if (n2 >= 3) throw new IllegalArgumentException("Location not recognised.");
        this.axisLocation = n2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public int getAxisLocation() {
        return this.axisLocation;
    }

    public Font getValueFont() {
        return this.valueFont;
    }

    public void setValueFont(Font font) {
        if (font == null) return;
        if (this.valueFont.equals(font)) return;
        this.valueFont = font;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getValuePaint() {
        return this.valuePaint;
    }

    public void setValuePaint(Paint paint) {
        if (paint == null) return;
        if (this.valuePaint.equals(paint)) return;
        this.valuePaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setValueFormat(NumberFormat numberFormat) {
        if (numberFormat == null) return;
        this.valueFormat = numberFormat;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public Paint getMercuryPaint() {
        return this.mercuryPaint;
    }

    public void setMercuryPaint(Paint paint) {
        this.mercuryPaint = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getShowValueLines() {
        return this.showValueLines;
    }

    public void setShowValueLines(boolean bl2) {
        this.showValueLines = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setSubrangeInfo(int n2, double d2, double d3) {
        this.setSubrangeInfo(n2, d2, d3, d2, d3);
    }

    public void setSubrangeInfo(int n2, double d2, double d3, double d4, double d5) {
        if (n2 < 0) return;
        if (n2 >= 3) return;
        this.setSubrange(n2, d2, d3);
        this.setDisplayRange(n2, d4, d5);
        this.setAxisRange();
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public void setSubrange(int n2, double d2, double d3) {
        if (n2 < 0) return;
        if (n2 >= 3) return;
        this.subrangeInfo[n2][1] = d3;
        this.subrangeInfo[n2][0] = d2;
    }

    public void setDisplayRange(int n2, double d2, double d3) {
        if (n2 < 0) return;
        if (n2 >= this.subrangeInfo.length) return;
        if (!ThermometerPlot.isValidNumber(d3)) return;
        if (!ThermometerPlot.isValidNumber(d2)) return;
        if (d3 > d2) {
            this.subrangeInfo[n2][3] = d3;
            this.subrangeInfo[n2][2] = d2;
            return;
        }
        this.subrangeInfo[n2][3] = d2;
        this.subrangeInfo[n2][2] = d3;
    }

    public Paint getSubrangePaint(int n2) {
        if (n2 < 0) return this.mercuryPaint;
        if (n2 >= this.subrangePaint.length) return this.mercuryPaint;
        return this.subrangePaint[n2];
    }

    public void setSubrangePaint(int n2, Paint paint) {
        if (n2 < 0) return;
        if (n2 >= this.subrangePaint.length) return;
        if (paint == null) return;
        this.subrangePaint[n2] = paint;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getFollowDataInSubranges() {
        return this.followDataInSubranges;
    }

    public void setFollowDataInSubranges(boolean bl2) {
        this.followDataInSubranges = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    public boolean getUseSubrangePaint() {
        return this.useSubrangePaint;
    }

    public void setUseSubrangePaint(boolean bl2) {
        this.useSubrangePaint = bl2;
        this.notifyListeners(new PlotChangeEvent(this));
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void draw(Graphics2D var1_1, Rectangle2D var2_2, Point2D var3_3, PlotState var4_4, PlotRenderingInfo var5_5) {
        var6_6 = new RoundRectangle2D.Double();
        var7_7 = new RoundRectangle2D.Double();
        var8_8 = new RoundRectangle2D.Double();
        var9_9 = new Ellipse2D.Double();
        var10_10 = new Ellipse2D.Double();
        var11_11 = null;
        var12_12 = null;
        if (var5_5 != null) {
            var5_5.setPlotArea(var2_2);
        }
        var13_13 = this.getInsets();
        var13_13.trim(var2_2);
        this.drawBackground(var1_1, var2_2);
        var14_14 = (Rectangle2D)var2_2.clone();
        this.padding.trim(var14_14);
        var15_15 = (int)(var14_14.getX() + var14_14.getWidth() / 2.0);
        var16_16 = (int)(var14_14.getY() + var14_14.getHeight() / 2.0);
        var17_17 = (int)(var14_14.getMinY() + 40.0);
        var18_18 = (int)(var14_14.getMaxY() - 80.0);
        var19_19 = new Rectangle2D.Double(var15_15 - 20, var17_17, 20.0, var18_18 - var17_17);
        var9_9.setFrame(var15_15 - 40, var18_18, 80.0, 80.0);
        var6_6.setRoundRect(var15_15 - 20, var14_14.getMinY(), 40.0, var18_18 + 80 - var17_17, 40.0, 40.0);
        var20_20 = new Area(var9_9);
        var21_21 = new Area(var6_6);
        var20_20.add(var21_21);
        var10_10.setFrame(var15_15 - 40 + 5, var18_18 + 5, 70.0, 70.0);
        var7_7.setRoundRect(var15_15 - 20 + 5, var14_14.getMinY() + 5.0, 30.0, var18_18 + 80 - 10 - var17_17, 30.0, 30.0);
        var22_22 = new Area(var10_10);
        var21_21 = new Area(var7_7);
        var22_22.add(var21_21);
        if (this.dataset != null && this.dataset.getValue() != null) {
            var23_23 = this.dataset.getValue().doubleValue();
            var25_25 = this.rangeAxis.valueToJava2D(var23_23, var19_19, RectangleEdge.LEFT);
            var27_26 = 30;
            var28_27 = 15;
            var29_28 = var27_26 / 2;
            var30_29 = (int)Math.round(var25_25);
            if ((double)var30_29 < 5.0 + var14_14.getMinY()) {
                var30_29 = (int)(5.0 + var14_14.getMinY());
                var29_28 = 40;
            }
            var31_30 = new Area(var10_10);
            if (var30_29 < var18_18 + 40) {
                var8_8.setRoundRect(var15_15 - var28_27, var30_29, var27_26, var18_18 + 40 - var30_29, var29_28, var29_28);
                var21_21 = new Area(var8_8);
                var31_30.add(var21_21);
            }
            var1_1.setPaint(this.getCurrentPaint());
            var1_1.fill(var31_30);
            if (this.subrangeIndicatorsVisible) {
                var1_1.setStroke(this.subrangeIndicatorStroke);
                var32_31 = this.rangeAxis.getRange();
                var33_33 = this.subrangeInfo[0][0];
                if (var32_31.contains(var33_33)) {
                    var35_37 = var15_15 + 20 + 2;
                    var37_38 = this.rangeAxis.valueToJava2D(var33_33, var19_19, RectangleEdge.LEFT);
                    var39_39 = new Line2D.Double(var35_37, var37_38, var35_37 + 10.0, var37_38);
                    var1_1.setPaint(this.subrangePaint[0]);
                    var1_1.draw(var39_39);
                }
                if (var32_31.contains(var33_33 = this.subrangeInfo[1][0])) {
                    var35_37 = var15_15 + 20 + 2;
                    var37_38 = this.rangeAxis.valueToJava2D(var33_33, var19_19, RectangleEdge.LEFT);
                    var39_39 = new Line2D.Double(var35_37, var37_38, var35_37 + 10.0, var37_38);
                    var1_1.setPaint(this.subrangePaint[1]);
                    var1_1.draw(var39_39);
                }
                if (var32_31.contains(var33_33 = this.subrangeInfo[2][0])) {
                    var35_37 = var15_15 + 20 + 2;
                    var37_38 = this.rangeAxis.valueToJava2D(var33_33, var19_19, RectangleEdge.LEFT);
                    var39_39 = new Line2D.Double(var35_37, var37_38, var35_37 + 10.0, var37_38);
                    var1_1.setPaint(this.subrangePaint[2]);
                    var1_1.draw(var39_39);
                }
            }
            if (this.rangeAxis != null && this.axisLocation != 0) {
                var32_32 = 10;
                if (this.showValueLines) {
                    var32_32 += 40;
                }
                var34_40 = 0.0;
                switch (this.axisLocation) {
                    case 1: {
                        var34_40 = var15_15 + 20;
                        var33_34 = new Rectangle2D.Double(var34_40, var17_17, var32_32, var18_18 - var17_17 + 1);
                        this.rangeAxis.draw(var1_1, var34_40, var2_2, var33_34, RectangleEdge.RIGHT, null);
                        ** break;
                    }
                }
                var34_40 = var15_15 - 20;
                var33_35 = new Rectangle2D.Double(var34_40, var17_17, var32_32, var18_18 - var17_17 + 1);
                this.rangeAxis.draw(var1_1, var34_40, var2_2, var33_35, RectangleEdge.LEFT, null);
            }
lbl83: // 4 sources:
            var1_1.setFont(this.valueFont);
            var1_1.setPaint(this.valuePaint);
            var12_12 = var1_1.getFontMetrics();
            switch (this.valueLocation) {
                case 1: {
                    var1_1.drawString(this.valueFormat.format(var23_23), var15_15 + 20 + 5, var16_16);
                    break;
                }
                case 2: {
                    var32_31 = this.valueFormat.format(var23_23);
                    var33_36 = var12_12.stringWidth((String)var32_31);
                    var1_1.drawString((String)var32_31, var15_15 - 20 - 5 - var33_36, var16_16);
                    break;
                }
                case 3: {
                    var11_11 = this.valueFormat.format(var23_23);
                    var27_26 = var12_12.stringWidth(var11_11) / 2;
                    var1_1.drawString(var11_11, var15_15 - var27_26, var18_18 + 40 + 5);
                    break;
                }
            }
        }
        var1_1.setPaint(this.thermometerPaint);
        var1_1.setFont(this.valueFont);
        var12_12 = var1_1.getFontMetrics();
        var23_24 = var15_15 - 20 - 10 - var12_12.stringWidth(ThermometerPlot.UNITS[this.units]);
        if ((double)var23_24 > var2_2.getMinX()) {
            var1_1.drawString(ThermometerPlot.UNITS[this.units], var23_24, (int)(var2_2.getMinY() + 20.0));
        }
        var1_1.setStroke(this.thermometerStroke);
        var1_1.draw(var20_20);
        var1_1.draw(var22_22);
        this.drawOutline(var1_1, var2_2);
    }

    @Override
    public void zoom(double d2) {
    }

    @Override
    public String getPlotType() {
        return localizationResources.getString("Thermometer_Plot");
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        Number number = this.dataset.getValue();
        if (number != null) {
            double d2 = number.doubleValue();
            this.subrange = this.inSubrange(0, d2) ? 0 : (this.inSubrange(1, d2) ? 1 : (this.inSubrange(2, d2) ? 2 : -1));
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

    @Override
    public Range getDataRange(ValueAxis valueAxis) {
        return new Range(this.lowerBound, this.upperBound);
    }

    protected void setAxisRange() {
        if (this.subrange >= 0 && this.followDataInSubranges) {
            this.rangeAxis.setRange(new Range(this.subrangeInfo[this.subrange][2], this.subrangeInfo[this.subrange][3]));
            return;
        }
        this.rangeAxis.setRange(this.lowerBound, this.upperBound);
    }

    @Override
    public LegendItemCollection getLegendItems() {
        return null;
    }

    @Override
    public PlotOrientation getOrientation() {
        return PlotOrientation.VERTICAL;
    }

    protected static boolean isValidNumber(double d2) {
        if (Double.isNaN(d2)) return false;
        if (Double.isInfinite(d2)) return false;
        return true;
    }

    private boolean inSubrange(int n2, double d2) {
        if (d2 <= this.subrangeInfo[n2][0]) return false;
        if (d2 > this.subrangeInfo[n2][1]) return false;
        return true;
    }

    private Paint getCurrentPaint() {
        Paint paint = this.mercuryPaint;
        if (!this.useSubrangePaint) return paint;
        double d2 = this.dataset.getValue().doubleValue();
        if (this.inSubrange(0, d2)) {
            return this.subrangePaint[0];
        }
        if (this.inSubrange(1, d2)) {
            return this.subrangePaint[1];
        }
        if (!this.inSubrange(2, d2)) return paint;
        return this.subrangePaint[2];
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ThermometerPlot)) {
            return false;
        }
        ThermometerPlot thermometerPlot = (ThermometerPlot)object;
        if (!super.equals(object)) {
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
        if (!ThermometerPlot.equal(this.subrangeInfo, thermometerPlot.subrangeInfo)) {
            return false;
        }
        if (this.useSubrangePaint != thermometerPlot.useSubrangePaint) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.subrangePaint.length) {
            if (!PaintUtilities.equal(this.subrangePaint[n2], thermometerPlot.subrangePaint[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    private static boolean equal(double[][] arrd, double[][] arrd2) {
        if (arrd == null) {
            if (arrd2 != null) return false;
            return true;
        }
        if (arrd2 == null) {
            return false;
        }
        if (arrd.length != arrd2.length) {
            return false;
        }
        int n2 = 0;
        while (n2 < arrd.length) {
            if (!Arrays.equals(arrd[n2], arrd2[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public Object clone() {
        ThermometerPlot thermometerPlot = (ThermometerPlot)super.clone();
        if (thermometerPlot.dataset != null) {
            thermometerPlot.dataset.addChangeListener(thermometerPlot);
        }
        thermometerPlot.rangeAxis = (ValueAxis)ObjectUtilities.clone(this.rangeAxis);
        if (thermometerPlot.rangeAxis != null) {
            thermometerPlot.rangeAxis.setPlot(thermometerPlot);
            thermometerPlot.rangeAxis.addChangeListener(thermometerPlot);
        }
        thermometerPlot.valueFormat = (NumberFormat)this.valueFormat.clone();
        thermometerPlot.subrangePaint = (Paint[])this.subrangePaint.clone();
        return thermometerPlot;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.thermometerStroke, objectOutputStream);
        SerialUtilities.writePaint(this.thermometerPaint, objectOutputStream);
        SerialUtilities.writePaint(this.valuePaint, objectOutputStream);
        SerialUtilities.writePaint(this.mercuryPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.subrangeIndicatorStroke, objectOutputStream);
        SerialUtilities.writeStroke(this.rangeIndicatorStroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.thermometerStroke = SerialUtilities.readStroke(objectInputStream);
        this.thermometerPaint = SerialUtilities.readPaint(objectInputStream);
        this.valuePaint = SerialUtilities.readPaint(objectInputStream);
        this.mercuryPaint = SerialUtilities.readPaint(objectInputStream);
        this.subrangeIndicatorStroke = SerialUtilities.readStroke(objectInputStream);
        this.rangeIndicatorStroke = SerialUtilities.readStroke(objectInputStream);
        if (this.rangeAxis == null) return;
        this.rangeAxis.addChangeListener(this);
    }

    @Override
    public void zoomDomainAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
    }

    @Override
    public void zoomRangeAxes(double d2, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.rangeAxis.resizeRange(d2);
    }

    @Override
    public void zoomDomainAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
    }

    @Override
    public void zoomRangeAxes(double d2, double d3, PlotRenderingInfo plotRenderingInfo, Point2D point2D) {
        this.rangeAxis.zoomRange(d2, d3);
    }

    @Override
    public boolean isDomainZoomable() {
        return false;
    }

    @Override
    public boolean isRangeZoomable() {
        return true;
    }
}

