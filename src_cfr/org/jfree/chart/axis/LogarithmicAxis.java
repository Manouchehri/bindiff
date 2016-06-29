/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class LogarithmicAxis
extends NumberAxis {
    private static final long serialVersionUID = 2502918599004103054L;
    public static final double LOG10_VALUE = Math.log(10.0);
    public static final double SMALL_LOG_VALUE = 1.0E-100;
    protected boolean allowNegativesFlag = false;
    protected boolean strictValuesFlag = true;
    protected final NumberFormat numberFormatterObj = NumberFormat.getInstance();
    protected boolean expTickLabelsFlag = false;
    protected boolean log10TickLabelsFlag = false;
    protected boolean autoRangeNextLogFlag = false;
    protected boolean smallLogFlag = false;

    public LogarithmicAxis(String string) {
        super(string);
        this.setupNumberFmtObj();
    }

    public void setAllowNegativesFlag(boolean bl2) {
        this.allowNegativesFlag = bl2;
    }

    public boolean getAllowNegativesFlag() {
        return this.allowNegativesFlag;
    }

    public void setStrictValuesFlag(boolean bl2) {
        this.strictValuesFlag = bl2;
    }

    public boolean getStrictValuesFlag() {
        return this.strictValuesFlag;
    }

    public void setExpTickLabelsFlag(boolean bl2) {
        this.expTickLabelsFlag = bl2;
        this.setupNumberFmtObj();
    }

    public boolean getExpTickLabelsFlag() {
        return this.expTickLabelsFlag;
    }

    public void setLog10TickLabelsFlag(boolean bl2) {
        this.log10TickLabelsFlag = bl2;
    }

    public boolean getLog10TickLabelsFlag() {
        return this.log10TickLabelsFlag;
    }

    public void setAutoRangeNextLogFlag(boolean bl2) {
        this.autoRangeNextLogFlag = bl2;
    }

    public boolean getAutoRangeNextLogFlag() {
        return this.autoRangeNextLogFlag;
    }

    @Override
    public void setRange(Range range) {
        super.setRange(range);
        this.setupSmallLogFlag();
    }

    protected void setupSmallLogFlag() {
        double d2 = this.getRange().getLowerBound();
        this.smallLogFlag = !this.allowNegativesFlag && d2 < 10.0 && d2 > 0.0;
    }

    protected void setupNumberFmtObj() {
        if (!(this.numberFormatterObj instanceof DecimalFormat)) return;
        ((DecimalFormat)this.numberFormatterObj).applyPattern(this.expTickLabelsFlag ? "0E0" : "0.###");
    }

    protected double switchedLog10(double d2) {
        double d3;
        if (this.smallLogFlag) {
            d3 = Math.log(d2) / LOG10_VALUE;
            return d3;
        }
        d3 = this.adjustedLog10(d2);
        return d3;
    }

    public double switchedPow10(double d2) {
        double d3;
        if (this.smallLogFlag) {
            d3 = Math.pow(10.0, d2);
            return d3;
        }
        d3 = this.adjustedPow10(d2);
        return d3;
    }

    public double adjustedLog10(double d2) {
        double d3;
        boolean bl2;
        boolean bl3 = bl2 = d2 < 0.0;
        if (bl2) {
            d2 = - d2;
        }
        if (d2 < 10.0) {
            d2 += (10.0 - d2) / 10.0;
        }
        double d4 = Math.log(d2) / LOG10_VALUE;
        if (bl2) {
            d3 = - d4;
            return d3;
        }
        d3 = d4;
        return d3;
    }

    public double adjustedPow10(double d2) {
        double d3;
        boolean bl2;
        boolean bl3 = bl2 = d2 < 0.0;
        if (bl2) {
            d2 = - d2;
        }
        double d4 = d2 < 1.0 ? (Math.pow(10.0, d2 + 1.0) - 10.0) / 9.0 : Math.pow(10.0, d2);
        if (bl2) {
            d3 = - d4;
            return d3;
        }
        d3 = d4;
        return d3;
    }

    protected double computeLogFloor(double d2) {
        double d3;
        if (this.allowNegativesFlag) {
            if (d2 > 10.0) {
                d3 = Math.log(d2) / LOG10_VALUE;
                d3 = Math.floor(d3);
                return Math.pow(10.0, d3);
            }
            if (d2 >= -10.0) return Math.floor(d2);
            d3 = Math.log(- d2) / LOG10_VALUE;
            d3 = Math.floor(- d3);
            return - Math.pow(10.0, - d3);
        }
        if (d2 <= 0.0) return Math.floor(d2);
        d3 = Math.log(d2) / LOG10_VALUE;
        d3 = Math.floor(d3);
        return Math.pow(10.0, d3);
    }

    protected double computeLogCeil(double d2) {
        double d3;
        if (this.allowNegativesFlag) {
            if (d2 > 10.0) {
                d3 = Math.log(d2) / LOG10_VALUE;
                d3 = Math.ceil(d3);
                return Math.pow(10.0, d3);
            }
            if (d2 >= -10.0) return Math.ceil(d2);
            d3 = Math.log(- d2) / LOG10_VALUE;
            d3 = Math.ceil(- d3);
            return - Math.pow(10.0, - d3);
        }
        if (d2 <= 0.0) return Math.ceil(d2);
        d3 = Math.log(d2) / LOG10_VALUE;
        d3 = Math.ceil(d3);
        return Math.pow(10.0, d3);
    }

    @Override
    public void autoAdjustRange() {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (!(plot instanceof ValueAxisPlot)) return;
        ValueAxisPlot valueAxisPlot = (ValueAxisPlot)((Object)plot);
        Range range = valueAxisPlot.getDataRange(this);
        if (range == null) {
            range = this.getDefaultAutoRange();
            d6 = range.getLowerBound();
        } else {
            d6 = range.getLowerBound();
            if (this.strictValuesFlag && !this.allowNegativesFlag && d6 <= 0.0) {
                throw new RuntimeException("Values less than or equal to zero not allowed with logarithmic axis");
            }
        }
        if (d6 > 0.0 && (d4 = this.getLowerMargin()) > 0.0) {
            d3 = Math.log(d6) / LOG10_VALUE;
            d7 = Math.abs(d3);
            if (d7 < 1.0) {
                d7 = 1.0;
            }
            d6 = Math.pow(10.0, d3 - d7 * d4);
        }
        if (this.autoRangeNextLogFlag) {
            d6 = this.computeLogFloor(d6);
        }
        if (!this.allowNegativesFlag && d6 >= 0.0 && d6 < 1.0E-100) {
            d6 = range.getLowerBound();
        }
        if ((d3 = range.getUpperBound()) > 0.0 && (d7 = this.getUpperMargin()) > 0.0) {
            d2 = Math.log(d3) / LOG10_VALUE;
            d5 = Math.abs(d2);
            if (d5 < 1.0) {
                d5 = 1.0;
            }
            d3 = Math.pow(10.0, d2 + d5 * d7);
        }
        if (!this.allowNegativesFlag && d3 < 1.0 && d3 > 0.0 && d6 > 0.0) {
            d2 = Math.log(d3) / LOG10_VALUE;
            d2 = Math.ceil(- d2 + 0.001);
            d3 = (d2 = Math.pow(10.0, d2)) > 0.0 ? Math.ceil(d3 * d2) / d2 : Math.ceil(d3);
        } else {
            d3 = this.autoRangeNextLogFlag ? this.computeLogCeil(d3) : Math.ceil(d3);
        }
        d2 = this.getAutoRangeMinimumSize();
        if (d3 - d6 < d2) {
            d3 = (d3 + d6 + d2) / 2.0;
            if (d3 - (d6 = (d3 + d6 - d2) / 2.0) < d2) {
                d5 = Math.abs(d3);
                double d8 = d5 > 1.0E-100 ? d5 / 100.0 : 0.01;
                d3 = (d3 + d6 + d8) / 2.0;
                d6 = (d3 + d6 - d8) / 2.0;
            }
        }
        this.setRange(new Range(d6, d3), false, false);
        this.setupSmallLogFlag();
    }

    @Override
    public double valueToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Range range = this.getRange();
        double d3 = this.switchedLog10(range.getLowerBound());
        double d4 = this.switchedLog10(range.getUpperBound());
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = rectangle2D.getMinX();
            d6 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d5 = rectangle2D.getMaxY();
            d6 = rectangle2D.getMinY();
        }
        d2 = this.switchedLog10(d2);
        if (!this.isInverted()) return d5 + (d2 - d3) / (d4 - d3) * (d6 - d5);
        return d6 - (d2 - d3) / (d4 - d3) * (d6 - d5);
    }

    @Override
    public double java2DToValue(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Range range = this.getRange();
        double d3 = this.switchedLog10(range.getLowerBound());
        double d4 = this.switchedLog10(range.getUpperBound());
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = rectangle2D.getX();
            d6 = rectangle2D.getMaxX();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d5 = rectangle2D.getMaxY();
            d6 = rectangle2D.getMinY();
        }
        if (!this.isInverted()) return this.switchedPow10(d3 + (d2 - d5) / (d6 - d5) * (d4 - d3));
        return this.switchedPow10(d4 - (d2 - d5) / (d6 - d5) * (d4 - d3));
    }

    @Override
    public void zoomRange(double d2, double d3) {
        double d4 = this.switchedLog10(this.getRange().getLowerBound());
        double d5 = this.switchedLog10(this.getRange().getUpperBound()) - d4;
        Range range = this.isInverted() ? new Range(this.switchedPow10(d4 + d5 * (1.0 - d3)), this.switchedPow10(d4 + d5 * (1.0 - d2))) : new Range(this.switchedPow10(d4 + d5 * d2), this.switchedPow10(d4 + d5 * d3));
        this.setRange(range);
    }

    @Override
    protected List refreshTicksHorizontal(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        int n2;
        ArrayList<NumberTick> arrayList = new ArrayList<NumberTick>();
        Range range = this.getRange();
        double d2 = range.getLowerBound();
        if (this.smallLogFlag && d2 < 1.0E-100) {
            d2 = 1.0E-100;
        }
        double d3 = range.getUpperBound();
        int n3 = (int)Math.rint(this.switchedLog10(d2));
        if (n3 == (n2 = (int)Math.rint(this.switchedLog10(d3))) && n3 > 0 && Math.pow(10.0, n3) > d2) {
            --n3;
        }
        boolean bl2 = false;
        int n4 = n3;
        while (n4 <= n2) {
            for (int i2 = 0; i2 < 10; ++i2) {
                double d4;
                String string;
                if (this.smallLogFlag) {
                    d4 = Math.pow(10.0, n4) + Math.pow(10.0, n4) * (double)i2;
                    if (this.expTickLabelsFlag || n4 < 0 && d4 > 0.0 && d4 < 1.0) {
                        if (i2 == 0 || n4 > -4 && i2 < 2 || d4 >= d3) {
                            this.numberFormatterObj.setMaximumFractionDigits(- n4);
                            string = this.makeTickLabel(d4, true);
                        } else {
                            string = "";
                        }
                    } else {
                        string = i2 < 1 || n4 < 1 && i2 < 5 || i2 < 4 - n4 || d4 >= d3 ? this.makeTickLabel(d4) : "";
                    }
                } else {
                    if (bl2) {
                        --i2;
                    }
                    double d5 = d4 = n4 >= 0 ? Math.pow(10.0, n4) + Math.pow(10.0, n4) * (double)i2 : - Math.pow(10.0, - n4) - Math.pow(10.0, - n4 - 1) * (double)i2;
                    if (!bl2) {
                        if (Math.abs(d4 - 1.0) < 1.0E-4 && d2 <= 0.0 && d3 >= 0.0) {
                            d4 = 0.0;
                            bl2 = true;
                        }
                    } else {
                        bl2 = false;
                    }
                    String string2 = string = this.expTickLabelsFlag && i2 < 2 || i2 < 1 || n4 < 1 && i2 < 5 || i2 < 4 - n4 || d4 >= d3 ? this.makeTickLabel(d4) : "";
                }
                if (d4 > d3) {
                    return arrayList;
                }
                if (d4 < d2 - 1.0E-100) continue;
                TextAnchor textAnchor = null;
                TextAnchor textAnchor2 = null;
                double d6 = 0.0;
                if (this.isVerticalTickLabels()) {
                    textAnchor = TextAnchor.CENTER_RIGHT;
                    textAnchor2 = TextAnchor.CENTER_RIGHT;
                    d6 = rectangleEdge == RectangleEdge.TOP ? 1.5707963267948966 : -1.5707963267948966;
                } else if (rectangleEdge == RectangleEdge.TOP) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                } else {
                    textAnchor = TextAnchor.TOP_CENTER;
                    textAnchor2 = TextAnchor.TOP_CENTER;
                }
                NumberTick numberTick = new NumberTick(new Double(d4), string, textAnchor, textAnchor2, d6);
                arrayList.add(numberTick);
            }
            ++n4;
        }
        return arrayList;
    }

    @Override
    protected List refreshTicksVertical(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        int n2;
        ArrayList<NumberTick> arrayList = new ArrayList<NumberTick>();
        double d2 = this.getRange().getLowerBound();
        if (this.smallLogFlag && d2 < 1.0E-100) {
            d2 = 1.0E-100;
        }
        double d3 = this.getRange().getUpperBound();
        int n3 = (int)Math.rint(this.switchedLog10(d2));
        if (n3 == (n2 = (int)Math.rint(this.switchedLog10(d3))) && n3 > 0 && Math.pow(10.0, n3) > d2) {
            --n3;
        }
        boolean bl2 = false;
        int n4 = n3;
        while (n4 <= n2) {
            int n5 = 10;
            if (n4 == n2) {
                n5 = 1;
            }
            for (int i2 = 0; i2 < n5; ++i2) {
                Serializable serializable2;
                String string;
                double d4;
                if (this.smallLogFlag) {
                    d4 = Math.pow(10.0, n4) + Math.pow(10.0, n4) * (double)i2;
                    if (i2 == 0) {
                        if (this.log10TickLabelsFlag) {
                            string = new StringBuffer().append("10^").append(n4).toString();
                        } else if (this.expTickLabelsFlag) {
                            string = new StringBuffer().append("1e").append(n4).toString();
                        } else if (n4 >= 0) {
                            Serializable serializable2 = this.getNumberFormatOverride();
                            string = serializable2 != null ? serializable2.format(d4) : Long.toString((long)Math.rint(d4));
                        } else {
                            this.numberFormatterObj.setMaximumFractionDigits(- n4);
                            string = this.numberFormatterObj.format(d4);
                        }
                    } else {
                        string = "";
                    }
                } else {
                    if (bl2) {
                        --i2;
                    }
                    double d5 = d4 = n4 >= 0 ? Math.pow(10.0, n4) + Math.pow(10.0, n4) * (double)i2 : - Math.pow(10.0, - n4) - Math.pow(10.0, - n4 - 1) * (double)i2;
                    if (i2 == 0) {
                        if (!bl2) {
                            if (n4 > n3 && n4 < n2 && Math.abs(d4 - 1.0) < 1.0E-4) {
                                d4 = 0.0;
                                bl2 = true;
                                string = "0";
                            } else {
                                string = this.log10TickLabelsFlag ? new StringBuffer().append(n4 < 0 ? "-" : "").append("10^").append(Math.abs(n4)).toString() : (this.expTickLabelsFlag ? new StringBuffer().append(n4 < 0 ? "-" : "").append("1e").append(Math.abs(n4)).toString() : ((serializable2 = this.getNumberFormatOverride()) != null ? serializable2.format(d4) : Long.toString((long)Math.rint(d4))));
                            }
                        } else {
                            string = "";
                            bl2 = false;
                        }
                    } else {
                        string = "";
                        bl2 = false;
                    }
                }
                if (d4 > d3) {
                    return arrayList;
                }
                if (d4 < d2 - 1.0E-100) continue;
                serializable2 = null;
                TextAnchor textAnchor = null;
                double d6 = 0.0;
                if (this.isVerticalTickLabels()) {
                    if (rectangleEdge == RectangleEdge.LEFT) {
                        serializable2 = TextAnchor.BOTTOM_CENTER;
                        textAnchor = TextAnchor.BOTTOM_CENTER;
                        d6 = -1.5707963267948966;
                    } else {
                        serializable2 = TextAnchor.BOTTOM_CENTER;
                        textAnchor = TextAnchor.BOTTOM_CENTER;
                        d6 = 1.5707963267948966;
                    }
                } else if (rectangleEdge == RectangleEdge.LEFT) {
                    serializable2 = TextAnchor.CENTER_RIGHT;
                    textAnchor = TextAnchor.CENTER_RIGHT;
                } else {
                    serializable2 = TextAnchor.CENTER_LEFT;
                    textAnchor = TextAnchor.CENTER_LEFT;
                }
                arrayList.add(new NumberTick(new Double(d4), string, (TextAnchor)serializable2, textAnchor, d6));
            }
            ++n4;
        }
        return arrayList;
    }

    protected String makeTickLabel(double d2, boolean bl2) {
        if (this.expTickLabelsFlag) return this.numberFormatterObj.format(d2).toLowerCase();
        if (!bl2) return this.getTickUnit().valueToString(d2);
        return this.numberFormatterObj.format(d2).toLowerCase();
    }

    protected String makeTickLabel(double d2) {
        return this.makeTickLabel(d2, false);
    }
}

