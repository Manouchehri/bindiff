/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.CyclicNumberAxis$CycleBoundTick;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.Tick;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class CyclicNumberAxis
extends NumberAxis {
    public static Stroke DEFAULT_ADVANCE_LINE_STROKE = new BasicStroke(1.0f);
    public static final Paint DEFAULT_ADVANCE_LINE_PAINT = Color.gray;
    protected double offset;
    protected double period;
    protected boolean boundMappedToLastCycle;
    protected boolean advanceLineVisible;
    protected transient Stroke advanceLineStroke = DEFAULT_ADVANCE_LINE_STROKE;
    protected transient Paint advanceLinePaint;
    private transient boolean internalMarkerWhenTicksOverlap;
    private transient Tick internalMarkerCycleBoundTick;

    public CyclicNumberAxis(double d2) {
        this(d2, 0.0);
    }

    public CyclicNumberAxis(double d2, double d3) {
        this(d2, d3, null);
    }

    public CyclicNumberAxis(double d2, String string) {
        this(0.0, d2, string);
    }

    public CyclicNumberAxis(double d2, double d3, String string) {
        super(string);
        this.period = d2;
        this.offset = d3;
        this.setFixedAutoRange(d2);
        this.advanceLineVisible = true;
        this.advanceLinePaint = DEFAULT_ADVANCE_LINE_PAINT;
    }

    public boolean isAdvanceLineVisible() {
        return this.advanceLineVisible;
    }

    public void setAdvanceLineVisible(boolean bl2) {
        this.advanceLineVisible = bl2;
    }

    public Paint getAdvanceLinePaint() {
        return this.advanceLinePaint;
    }

    public void setAdvanceLinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.advanceLinePaint = paint;
    }

    public Stroke getAdvanceLineStroke() {
        return this.advanceLineStroke;
    }

    public void setAdvanceLineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.advanceLineStroke = stroke;
    }

    public boolean isBoundMappedToLastCycle() {
        return this.boundMappedToLastCycle;
    }

    public void setBoundMappedToLastCycle(boolean bl2) {
        this.boundMappedToLastCycle = bl2;
    }

    protected void selectHorizontalAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge) {
        double d2 = this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit());
        double d3 = this.getRange().getLength() * d2 / rectangle2D2.getWidth();
        this.setTickUnit((NumberTickUnit)this.getStandardTickUnits().getCeilingTickUnit(d3), false, false);
    }

    protected void selectVerticalAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge) {
        double d2 = this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit());
        double d3 = this.getRange().getLength() * d2 / rectangle2D2.getHeight();
        this.setTickUnit((NumberTickUnit)this.getStandardTickUnits().getCeilingTickUnit(d3), false, false);
    }

    @Override
    protected float[] calculateAnchorPoint(ValueTick valueTick, double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        if (!(valueTick instanceof CyclicNumberAxis$CycleBoundTick)) return super.calculateAnchorPoint(valueTick, d2, rectangle2D, rectangleEdge);
        boolean bl2 = this.boundMappedToLastCycle;
        this.boundMappedToLastCycle = ((CyclicNumberAxis$CycleBoundTick)valueTick).mapToLastCycle;
        float[] arrf = super.calculateAnchorPoint(valueTick, d2, rectangle2D, rectangleEdge);
        this.boundMappedToLastCycle = bl2;
        return arrf;
    }

    @Override
    protected List refreshTicksHorizontal(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        ArrayList<CyclicNumberAxis$CycleBoundTick> arrayList = new ArrayList<CyclicNumberAxis$CycleBoundTick>();
        Font font = this.getTickLabelFont();
        graphics2D.setFont(font);
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        double d2 = this.getTickUnit().getSize();
        double d3 = this.getCycleBound();
        double d4 = Math.ceil(d3 / d2) * d2;
        double d5 = this.getRange().getUpperBound();
        boolean bl2 = false;
        boolean bl3 = this.boundMappedToLastCycle;
        this.boundMappedToLastCycle = false;
        CyclicNumberAxis$CycleBoundTick cyclicNumberAxis$CycleBoundTick = null;
        float f2 = 0.0f;
        if (d5 == d3) {
            d4 = this.calculateLowestVisibleTickValue();
            bl2 = true;
            this.boundMappedToLastCycle = true;
        }
        do {
            if (d4 > d5) {
                this.boundMappedToLastCycle = bl3;
                return arrayList;
            }
            boolean bl4 = false;
            if (d4 + d2 > d5 && !bl2) {
                bl4 = true;
            }
            double d6 = this.valueToJava2D(d4, rectangle2D, rectangleEdge);
            NumberFormat numberFormat = this.getNumberFormatOverride();
            String string = numberFormat != null ? numberFormat.format(d4) : this.getTickUnit().valueToString(d4);
            float f3 = (float)d6;
            TextAnchor textAnchor = null;
            TextAnchor textAnchor2 = null;
            double d7 = 0.0;
            if (this.isVerticalTickLabels()) {
                d7 = rectangleEdge == RectangleEdge.TOP ? 1.5707963267948966 : -1.5707963267948966;
                textAnchor = TextAnchor.CENTER_RIGHT;
                if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                    textAnchor = this.isInverted() ? TextAnchor.TOP_RIGHT : TextAnchor.BOTTOM_RIGHT;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.TOP_RIGHT;
                }
                textAnchor2 = textAnchor;
            } else if (rectangleEdge == RectangleEdge.TOP) {
                textAnchor = TextAnchor.BOTTOM_CENTER;
                if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                    textAnchor = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.BOTTOM_RIGHT;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.BOTTOM_LEFT;
                }
                textAnchor2 = textAnchor;
            } else {
                textAnchor = TextAnchor.TOP_CENTER;
                if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                    textAnchor = this.isInverted() ? TextAnchor.TOP_LEFT : TextAnchor.TOP_RIGHT;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = this.isInverted() ? TextAnchor.TOP_RIGHT : TextAnchor.TOP_LEFT;
                }
                textAnchor2 = textAnchor;
            }
            CyclicNumberAxis$CycleBoundTick cyclicNumberAxis$CycleBoundTick2 = new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, new Double(d4), string, textAnchor, textAnchor2, d7);
            if (d4 == d3) {
                this.internalMarkerCycleBoundTick = cyclicNumberAxis$CycleBoundTick2;
            }
            arrayList.add(cyclicNumberAxis$CycleBoundTick2);
            cyclicNumberAxis$CycleBoundTick = cyclicNumberAxis$CycleBoundTick2;
            f2 = f3;
            d4 += d2;
            if (!bl4) continue;
            d4 = this.calculateLowestVisibleTickValue();
            d5 = d3;
            bl2 = true;
            this.boundMappedToLastCycle = true;
        } while (true);
    }

    protected List refreshVerticalTicks(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        ArrayList<CyclicNumberAxis$CycleBoundTick> arrayList = new ArrayList<CyclicNumberAxis$CycleBoundTick>();
        arrayList.clear();
        Font font = this.getTickLabelFont();
        graphics2D.setFont(font);
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        double d2 = this.getTickUnit().getSize();
        double d3 = this.getCycleBound();
        double d4 = Math.ceil(d3 / d2) * d2;
        double d5 = this.getRange().getUpperBound();
        boolean bl2 = false;
        boolean bl3 = this.boundMappedToLastCycle;
        this.boundMappedToLastCycle = true;
        CyclicNumberAxis$CycleBoundTick cyclicNumberAxis$CycleBoundTick = null;
        float f2 = 0.0f;
        if (d5 == d3) {
            d4 = this.calculateLowestVisibleTickValue();
            bl2 = true;
            this.boundMappedToLastCycle = true;
        }
        do {
            if (d4 > d5) {
                this.boundMappedToLastCycle = bl3;
                return arrayList;
            }
            boolean bl4 = false;
            if (d4 + d2 > d5 && !bl2) {
                bl4 = true;
            }
            double d6 = this.valueToJava2D(d4, rectangle2D, rectangleEdge);
            NumberFormat numberFormat = this.getNumberFormatOverride();
            String string = numberFormat != null ? numberFormat.format(d4) : this.getTickUnit().valueToString(d4);
            float f3 = (float)d6;
            TextAnchor textAnchor = null;
            TextAnchor textAnchor2 = null;
            double d7 = 0.0;
            if (this.isVerticalTickLabels()) {
                if (rectangleEdge == RectangleEdge.LEFT) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                        textAnchor = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.BOTTOM_RIGHT;
                        arrayList.remove(arrayList.size() - 1);
                        arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                        this.internalMarkerWhenTicksOverlap = true;
                        textAnchor = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.BOTTOM_LEFT;
                    }
                    textAnchor2 = textAnchor;
                    d7 = -1.5707963267948966;
                } else {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                        textAnchor = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.BOTTOM_LEFT;
                        arrayList.remove(arrayList.size() - 1);
                        arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                        this.internalMarkerWhenTicksOverlap = true;
                        textAnchor = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.BOTTOM_RIGHT;
                    }
                    textAnchor2 = textAnchor;
                    d7 = 1.5707963267948966;
                }
            } else if (rectangleEdge == RectangleEdge.LEFT) {
                textAnchor = TextAnchor.CENTER_RIGHT;
                if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                    textAnchor = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.TOP_RIGHT;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = this.isInverted() ? TextAnchor.TOP_RIGHT : TextAnchor.BOTTOM_RIGHT;
                }
                textAnchor2 = textAnchor;
            } else {
                textAnchor = TextAnchor.CENTER_LEFT;
                if (cyclicNumberAxis$CycleBoundTick != null && f2 == f3 && d4 != d3) {
                    textAnchor = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.TOP_LEFT;
                    arrayList.remove(arrayList.size() - 1);
                    arrayList.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, cyclicNumberAxis$CycleBoundTick.getNumber(), cyclicNumberAxis$CycleBoundTick.getText(), textAnchor, textAnchor, cyclicNumberAxis$CycleBoundTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = this.isInverted() ? TextAnchor.TOP_LEFT : TextAnchor.BOTTOM_LEFT;
                }
                textAnchor2 = textAnchor;
            }
            CyclicNumberAxis$CycleBoundTick cyclicNumberAxis$CycleBoundTick2 = new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, new Double(d4), string, textAnchor, textAnchor2, d7);
            if (d4 == d3) {
                this.internalMarkerCycleBoundTick = cyclicNumberAxis$CycleBoundTick2;
            }
            arrayList.add(cyclicNumberAxis$CycleBoundTick2);
            cyclicNumberAxis$CycleBoundTick = cyclicNumberAxis$CycleBoundTick2;
            f2 = f3;
            if (d4 == d3) {
                this.internalMarkerCycleBoundTick = cyclicNumberAxis$CycleBoundTick2;
            }
            d4 += d2;
            if (!bl4) continue;
            d4 = this.calculateLowestVisibleTickValue();
            d5 = d3;
            bl2 = true;
            this.boundMappedToLastCycle = false;
        } while (true);
    }

    @Override
    public double java2DToValue(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Range range = this.getRange();
        double d3 = range.getUpperBound();
        double d4 = this.getCycleBound();
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = rectangle2D.getMinX();
            d6 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d5 = rectangle2D.getMaxY();
            d6 = rectangle2D.getMinY();
        }
        if (this.isInverted()) {
            double d7 = d6 - (d3 - d4) * (d6 - d5) / this.period;
            if (d2 < d7) return d4 - (d2 - d5) * this.period / (d6 - d5);
            return d4 + (d6 - d2) * this.period / (d6 - d5);
        }
        double d8 = (d3 - d4) * (d6 - d5) / this.period + d5;
        if (d2 > d8) return d4 - (d6 - d2) * this.period / (d6 - d5);
        return d4 + (d2 - d5) * this.period / (d6 - d5);
    }

    @Override
    public double valueToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3;
        Range range = this.getRange();
        double d4 = range.getLowerBound();
        double d5 = range.getUpperBound();
        double d6 = this.getCycleBound();
        if (d2 < d4) return Double.NaN;
        if (d2 > d5) {
            return Double.NaN;
        }
        double d7 = 0.0;
        double d8 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d7 = rectangle2D.getMinX();
            d8 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d8 = rectangle2D.getMinY();
            d7 = rectangle2D.getMaxY();
        }
        if (this.isInverted()) {
            double d9;
            if (d2 != d6) {
                if (d2 <= d6) return d7 + (d6 - d2) * (d8 - d7) / this.period;
                return d8 - (d2 - d6) * (d8 - d7) / this.period;
            }
            if (this.boundMappedToLastCycle) {
                d9 = d7;
                return d9;
            }
            d9 = d8;
            return d9;
        }
        if (d2 != d6) {
            if (d2 < d6) return d8 - (d6 - d2) * (d8 - d7) / this.period;
            return d7 + (d2 - d6) * (d8 - d7) / this.period;
        }
        if (this.boundMappedToLastCycle) {
            d3 = d8;
            return d3;
        }
        d3 = d7;
        return d3;
    }

    @Override
    public void centerRange(double d2) {
        this.setRange(d2 - this.period / 2.0, d2 + this.period / 2.0);
    }

    @Override
    public void setAutoRangeMinimumSize(double d2, boolean bl2) {
        if (d2 > this.period) {
            this.period = d2;
        }
        super.setAutoRangeMinimumSize(d2, bl2);
    }

    @Override
    public void setFixedAutoRange(double d2) {
        this.period = d2;
        super.setFixedAutoRange(d2);
    }

    @Override
    public void setRange(Range range, boolean bl2, boolean bl3) {
        double d2 = range.getUpperBound() - range.getLowerBound();
        if (d2 > this.period) {
            this.period = d2;
        }
        super.setRange(range, bl2, bl3);
    }

    public double getCycleBound() {
        return Math.floor((this.getRange().getUpperBound() - this.offset) / this.period) * this.period + this.offset;
    }

    public double getOffset() {
        return this.offset;
    }

    public void setOffset(double d2) {
        this.offset = d2;
    }

    public double getPeriod() {
        return this.period;
    }

    public void setPeriod(double d2) {
        this.period = d2;
    }

    @Override
    protected AxisState drawTickMarksAndLabels(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge) {
        this.internalMarkerWhenTicksOverlap = false;
        AxisState axisState = super.drawTickMarksAndLabels(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge);
        if (!this.internalMarkerWhenTicksOverlap) {
            return axisState;
        }
        double d3 = this.getTickMarkOutsideLength();
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getTickLabelFont());
        d3 = this.isVerticalTickLabels() ? (double)fontMetrics.getMaxAdvance() : (double)fontMetrics.getHeight();
        double d4 = 0.0;
        if (!this.isTickMarksVisible()) return axisState;
        float f2 = (float)this.valueToJava2D(this.getRange().getUpperBound(), rectangle2D2, rectangleEdge);
        Line2D.Double double_ = null;
        graphics2D.setStroke(this.getTickMarkStroke());
        graphics2D.setPaint(this.getTickMarkPaint());
        if (rectangleEdge == RectangleEdge.LEFT) {
            double_ = new Line2D.Double(d2 - d3, f2, d2 + d4, f2);
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            double_ = new Line2D.Double(d2 + d3, f2, d2 - d4, f2);
        } else if (rectangleEdge == RectangleEdge.TOP) {
            double_ = new Line2D.Double(f2, d2 - d3, f2, d2 + d4);
        } else if (rectangleEdge == RectangleEdge.BOTTOM) {
            double_ = new Line2D.Double(f2, d2 + d3, f2, d2 - d4);
        }
        graphics2D.draw(double_);
        return axisState;
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        AxisState axisState = super.draw(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge, plotRenderingInfo);
        if (!this.isAdvanceLineVisible()) return axisState;
        double d3 = this.valueToJava2D(this.getRange().getUpperBound(), rectangle2D2, rectangleEdge);
        Line2D.Double double_ = null;
        graphics2D.setStroke(this.getAdvanceLineStroke());
        graphics2D.setPaint(this.getAdvanceLinePaint());
        if (rectangleEdge == RectangleEdge.LEFT) {
            double_ = new Line2D.Double(d2, d3, d2 + rectangle2D2.getWidth(), d3);
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            double_ = new Line2D.Double(d2 - rectangle2D2.getWidth(), d3, d2, d3);
        } else if (rectangleEdge == RectangleEdge.TOP) {
            double_ = new Line2D.Double(d3, d2 + rectangle2D2.getHeight(), d3, d2);
        } else if (rectangleEdge == RectangleEdge.BOTTOM) {
            double_ = new Line2D.Double(d3, d2, d3, d2 - rectangle2D2.getHeight());
        }
        graphics2D.draw(double_);
        return axisState;
    }

    @Override
    public AxisSpace reserveSpace(Graphics2D graphics2D, Plot plot, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        this.internalMarkerCycleBoundTick = null;
        AxisSpace axisSpace2 = super.reserveSpace(graphics2D, plot, rectangle2D, rectangleEdge, axisSpace);
        if (this.internalMarkerCycleBoundTick == null) {
            return axisSpace2;
        }
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getTickLabelFont());
        Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(this.internalMarkerCycleBoundTick.getText(), graphics2D, fontMetrics);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            if (this.isVerticalTickLabels()) {
                axisSpace.add(rectangle2D2.getHeight() / 2.0, RectangleEdge.RIGHT);
                return axisSpace2;
            }
            axisSpace.add(rectangle2D2.getWidth() / 2.0, RectangleEdge.RIGHT);
            return axisSpace2;
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return axisSpace2;
        if (this.isVerticalTickLabels()) {
            axisSpace.add(rectangle2D2.getWidth() / 2.0, RectangleEdge.TOP);
            return axisSpace2;
        }
        axisSpace.add(rectangle2D2.getHeight() / 2.0, RectangleEdge.TOP);
        return axisSpace2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.advanceLinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.advanceLineStroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.advanceLinePaint = SerialUtilities.readPaint(objectInputStream);
        this.advanceLineStroke = SerialUtilities.readStroke(objectInputStream);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CyclicNumberAxis)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CyclicNumberAxis cyclicNumberAxis = (CyclicNumberAxis)object;
        if (this.period != cyclicNumberAxis.period) {
            return false;
        }
        if (this.offset != cyclicNumberAxis.offset) {
            return false;
        }
        if (!PaintUtilities.equal(this.advanceLinePaint, cyclicNumberAxis.advanceLinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.advanceLineStroke, cyclicNumberAxis.advanceLineStroke)) {
            return false;
        }
        if (this.advanceLineVisible != cyclicNumberAxis.advanceLineVisible) {
            return false;
        }
        if (this.boundMappedToLastCycle == cyclicNumberAxis.boundMappedToLastCycle) return true;
        return false;
    }
}

