package org.jfree.chart.axis;

import org.jfree.data.*;
import java.text.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import org.jfree.ui.*;

public class LogarithmicAxis extends NumberAxis
{
    private static final long serialVersionUID = 2502918599004103054L;
    public static final double LOG10_VALUE;
    public static final double SMALL_LOG_VALUE = 1.0E-100;
    protected boolean allowNegativesFlag;
    protected boolean strictValuesFlag;
    protected final NumberFormat numberFormatterObj;
    protected boolean expTickLabelsFlag;
    protected boolean log10TickLabelsFlag;
    protected boolean autoRangeNextLogFlag;
    protected boolean smallLogFlag;
    
    public LogarithmicAxis(final String s) {
        super(s);
        this.allowNegativesFlag = false;
        this.strictValuesFlag = true;
        this.numberFormatterObj = NumberFormat.getInstance();
        this.expTickLabelsFlag = false;
        this.log10TickLabelsFlag = false;
        this.autoRangeNextLogFlag = false;
        this.smallLogFlag = false;
        this.setupNumberFmtObj();
    }
    
    public void setAllowNegativesFlag(final boolean allowNegativesFlag) {
        this.allowNegativesFlag = allowNegativesFlag;
    }
    
    public boolean getAllowNegativesFlag() {
        return this.allowNegativesFlag;
    }
    
    public void setStrictValuesFlag(final boolean strictValuesFlag) {
        this.strictValuesFlag = strictValuesFlag;
    }
    
    public boolean getStrictValuesFlag() {
        return this.strictValuesFlag;
    }
    
    public void setExpTickLabelsFlag(final boolean expTickLabelsFlag) {
        this.expTickLabelsFlag = expTickLabelsFlag;
        this.setupNumberFmtObj();
    }
    
    public boolean getExpTickLabelsFlag() {
        return this.expTickLabelsFlag;
    }
    
    public void setLog10TickLabelsFlag(final boolean log10TickLabelsFlag) {
        this.log10TickLabelsFlag = log10TickLabelsFlag;
    }
    
    public boolean getLog10TickLabelsFlag() {
        return this.log10TickLabelsFlag;
    }
    
    public void setAutoRangeNextLogFlag(final boolean autoRangeNextLogFlag) {
        this.autoRangeNextLogFlag = autoRangeNextLogFlag;
    }
    
    public boolean getAutoRangeNextLogFlag() {
        return this.autoRangeNextLogFlag;
    }
    
    public void setRange(final Range range) {
        super.setRange(range);
        this.setupSmallLogFlag();
    }
    
    protected void setupSmallLogFlag() {
        final double lowerBound = this.getRange().getLowerBound();
        this.smallLogFlag = (!this.allowNegativesFlag && lowerBound < 10.0 && lowerBound > 0.0);
    }
    
    protected void setupNumberFmtObj() {
        if (this.numberFormatterObj instanceof DecimalFormat) {
            ((DecimalFormat)this.numberFormatterObj).applyPattern(this.expTickLabelsFlag ? "0E0" : "0.###");
        }
    }
    
    protected double switchedLog10(final double n) {
        return this.smallLogFlag ? (Math.log(n) / LogarithmicAxis.LOG10_VALUE) : this.adjustedLog10(n);
    }
    
    public double switchedPow10(final double n) {
        return this.smallLogFlag ? Math.pow(10.0, n) : this.adjustedPow10(n);
    }
    
    public double adjustedLog10(double n) {
        final boolean b = n < 0.0;
        if (b) {
            n = -n;
        }
        if (n < 10.0) {
            n += (10.0 - n) / 10.0;
        }
        final double n2 = Math.log(n) / LogarithmicAxis.LOG10_VALUE;
        return b ? (-n2) : n2;
    }
    
    public double adjustedPow10(double n) {
        final boolean b = n < 0.0;
        if (b) {
            n = -n;
        }
        double pow;
        if (n < 1.0) {
            pow = (Math.pow(10.0, n + 1.0) - 10.0) / 9.0;
        }
        else {
            pow = Math.pow(10.0, n);
        }
        return b ? (-pow) : pow;
    }
    
    protected double computeLogFloor(final double n) {
        double n2;
        if (this.allowNegativesFlag) {
            if (n > 10.0) {
                n2 = Math.pow(10.0, Math.floor(Math.log(n) / LogarithmicAxis.LOG10_VALUE));
            }
            else if (n < -10.0) {
                n2 = -Math.pow(10.0, -Math.floor(-(Math.log(-n) / LogarithmicAxis.LOG10_VALUE)));
            }
            else {
                n2 = Math.floor(n);
            }
        }
        else if (n > 0.0) {
            n2 = Math.pow(10.0, Math.floor(Math.log(n) / LogarithmicAxis.LOG10_VALUE));
        }
        else {
            n2 = Math.floor(n);
        }
        return n2;
    }
    
    protected double computeLogCeil(final double n) {
        double n2;
        if (this.allowNegativesFlag) {
            if (n > 10.0) {
                n2 = Math.pow(10.0, Math.ceil(Math.log(n) / LogarithmicAxis.LOG10_VALUE));
            }
            else if (n < -10.0) {
                n2 = -Math.pow(10.0, -Math.ceil(-(Math.log(-n) / LogarithmicAxis.LOG10_VALUE)));
            }
            else {
                n2 = Math.ceil(n);
            }
        }
        else if (n > 0.0) {
            n2 = Math.pow(10.0, Math.ceil(Math.log(n) / LogarithmicAxis.LOG10_VALUE));
        }
        else {
            n2 = Math.ceil(n);
        }
        return n2;
    }
    
    public void autoAdjustRange() {
        final Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (plot instanceof ValueAxisPlot) {
            Range range = ((ValueAxisPlot)plot).getDataRange(this);
            double n;
            if (range == null) {
                range = this.getDefaultAutoRange();
                n = range.getLowerBound();
            }
            else {
                n = range.getLowerBound();
                if (this.strictValuesFlag && !this.allowNegativesFlag && n <= 0.0) {
                    throw new RuntimeException("Values less than or equal to zero not allowed with logarithmic axis");
                }
            }
            final double lowerMargin;
            if (n > 0.0 && (lowerMargin = this.getLowerMargin()) > 0.0) {
                final double n2 = Math.log(n) / LogarithmicAxis.LOG10_VALUE;
                double abs;
                if ((abs = Math.abs(n2)) < 1.0) {
                    abs = 1.0;
                }
                n = Math.pow(10.0, n2 - abs * lowerMargin);
            }
            if (this.autoRangeNextLogFlag) {
                n = this.computeLogFloor(n);
            }
            if (!this.allowNegativesFlag && n >= 0.0 && n < 1.0E-100) {
                n = range.getLowerBound();
            }
            double n3 = range.getUpperBound();
            final double upperMargin;
            if (n3 > 0.0 && (upperMargin = this.getUpperMargin()) > 0.0) {
                final double n4 = Math.log(n3) / LogarithmicAxis.LOG10_VALUE;
                double abs2;
                if ((abs2 = Math.abs(n4)) < 1.0) {
                    abs2 = 1.0;
                }
                n3 = Math.pow(10.0, n4 + abs2 * upperMargin);
            }
            double n5;
            if (!this.allowNegativesFlag && n3 < 1.0 && n3 > 0.0 && n > 0.0) {
                final double pow = Math.pow(10.0, Math.ceil(-(Math.log(n3) / LogarithmicAxis.LOG10_VALUE) + 0.001));
                n5 = ((pow > 0.0) ? (Math.ceil(n3 * pow) / pow) : Math.ceil(n3));
            }
            else {
                n5 = (this.autoRangeNextLogFlag ? this.computeLogCeil(n3) : Math.ceil(n3));
            }
            final double autoRangeMinimumSize = this.getAutoRangeMinimumSize();
            if (n5 - n < autoRangeMinimumSize) {
                n5 = (n5 + n + autoRangeMinimumSize) / 2.0;
                n = (n5 + n - autoRangeMinimumSize) / 2.0;
                if (n5 - n < autoRangeMinimumSize) {
                    final double abs3 = Math.abs(n5);
                    final double n6 = (abs3 > 1.0E-100) ? (abs3 / 100.0) : 0.01;
                    n5 = (n5 + n + n6) / 2.0;
                    n = (n5 + n - n6) / 2.0;
                }
            }
            this.setRange(new Range(n, n5), false, false);
            this.setupSmallLogFlag();
        }
    }
    
    public double valueToJava2D(double switchedLog10, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final Range range = this.getRange();
        final double switchedLog11 = this.switchedLog10(range.getLowerBound());
        final double switchedLog12 = this.switchedLog10(range.getUpperBound());
        double n = 0.0;
        double n2 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n = rectangle2D.getMinX();
            n2 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n = rectangle2D.getMaxY();
            n2 = rectangle2D.getMinY();
        }
        switchedLog10 = this.switchedLog10(switchedLog10);
        if (this.isInverted()) {
            return n2 - (switchedLog10 - switchedLog11) / (switchedLog12 - switchedLog11) * (n2 - n);
        }
        return n + (switchedLog10 - switchedLog11) / (switchedLog12 - switchedLog11) * (n2 - n);
    }
    
    public double java2DToValue(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final Range range = this.getRange();
        final double switchedLog10 = this.switchedLog10(range.getLowerBound());
        final double switchedLog11 = this.switchedLog10(range.getUpperBound());
        double n2 = 0.0;
        double n3 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getX();
            n3 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n2 = rectangle2D.getMaxY();
            n3 = rectangle2D.getMinY();
        }
        if (this.isInverted()) {
            return this.switchedPow10(switchedLog11 - (n - n2) / (n3 - n2) * (switchedLog11 - switchedLog10));
        }
        return this.switchedPow10(switchedLog10 + (n - n2) / (n3 - n2) * (switchedLog11 - switchedLog10));
    }
    
    public void zoomRange(final double n, final double n2) {
        final double switchedLog10 = this.switchedLog10(this.getRange().getLowerBound());
        final double n3 = this.switchedLog10(this.getRange().getUpperBound()) - switchedLog10;
        Range range;
        if (this.isInverted()) {
            range = new Range(this.switchedPow10(switchedLog10 + n3 * (1.0 - n2)), this.switchedPow10(switchedLog10 + n3 * (1.0 - n)));
        }
        else {
            range = new Range(this.switchedPow10(switchedLog10 + n3 * n), this.switchedPow10(switchedLog10 + n3 * n2));
        }
        this.setRange(range);
    }
    
    protected List refreshTicksHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> list = new ArrayList<NumberTick>();
        final Range range = this.getRange();
        double lowerBound = range.getLowerBound();
        if (this.smallLogFlag && lowerBound < 1.0E-100) {
            lowerBound = 1.0E-100;
        }
        final double upperBound = range.getUpperBound();
        int n = (int)Math.rint(this.switchedLog10(lowerBound));
        final int n2 = (int)Math.rint(this.switchedLog10(upperBound));
        if (n == n2 && n > 0 && Math.pow(10.0, n) > lowerBound) {
            --n;
        }
        int n3 = 0;
        for (int i = n; i <= n2; ++i) {
            for (int j = 0; j < 10; ++j) {
                double n4;
                String tickLabel;
                if (this.smallLogFlag) {
                    n4 = Math.pow(10.0, i) + Math.pow(10.0, i) * j;
                    if (this.expTickLabelsFlag || (i < 0 && n4 > 0.0 && n4 < 1.0)) {
                        if (j == 0 || (i > -4 && j < 2) || n4 >= upperBound) {
                            this.numberFormatterObj.setMaximumFractionDigits(-i);
                            tickLabel = this.makeTickLabel(n4, true);
                        }
                        else {
                            tickLabel = "";
                        }
                    }
                    else {
                        tickLabel = ((j < 1 || (i < 1 && j < 5) || j < 4 - i || n4 >= upperBound) ? this.makeTickLabel(n4) : "");
                    }
                }
                else {
                    if (n3 != 0) {
                        --j;
                    }
                    n4 = ((i >= 0) ? (Math.pow(10.0, i) + Math.pow(10.0, i) * j) : (-(Math.pow(10.0, -i) - Math.pow(10.0, -i - 1) * j)));
                    if (n3 == 0) {
                        if (Math.abs(n4 - 1.0) < 1.0E-4 && lowerBound <= 0.0 && upperBound >= 0.0) {
                            n4 = 0.0;
                            n3 = 1;
                        }
                    }
                    else {
                        n3 = 0;
                    }
                    tickLabel = (((this.expTickLabelsFlag && j < 2) || j < 1 || (i < 1 && j < 5) || j < 4 - i || n4 >= upperBound) ? this.makeTickLabel(n4) : "");
                }
                if (n4 > upperBound) {
                    return list;
                }
                if (n4 >= lowerBound - 1.0E-100) {
                    double n5 = 0.0;
                    TextAnchor textAnchor;
                    TextAnchor textAnchor2;
                    if (this.isVerticalTickLabels()) {
                        textAnchor = TextAnchor.CENTER_RIGHT;
                        textAnchor2 = TextAnchor.CENTER_RIGHT;
                        if (rectangleEdge == RectangleEdge.TOP) {
                            n5 = 1.5707963267948966;
                        }
                        else {
                            n5 = -1.5707963267948966;
                        }
                    }
                    else if (rectangleEdge == RectangleEdge.TOP) {
                        textAnchor = TextAnchor.BOTTOM_CENTER;
                        textAnchor2 = TextAnchor.BOTTOM_CENTER;
                    }
                    else {
                        textAnchor = TextAnchor.TOP_CENTER;
                        textAnchor2 = TextAnchor.TOP_CENTER;
                    }
                    list.add(new NumberTick(new Double(n4), tickLabel, textAnchor, textAnchor2, n5));
                }
            }
        }
        return list;
    }
    
    protected List refreshTicksVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> list = new ArrayList<NumberTick>();
        double lowerBound = this.getRange().getLowerBound();
        if (this.smallLogFlag && lowerBound < 1.0E-100) {
            lowerBound = 1.0E-100;
        }
        final double upperBound = this.getRange().getUpperBound();
        int n = (int)Math.rint(this.switchedLog10(lowerBound));
        final int n2 = (int)Math.rint(this.switchedLog10(upperBound));
        if (n == n2 && n > 0 && Math.pow(10.0, n) > lowerBound) {
            --n;
        }
        int n3 = 0;
        for (int i = n; i <= n2; ++i) {
            int n4 = 10;
            if (i == n2) {
                n4 = 1;
            }
            for (int j = 0; j < n4; ++j) {
                double n5;
                String s;
                if (this.smallLogFlag) {
                    n5 = Math.pow(10.0, i) + Math.pow(10.0, i) * j;
                    if (j == 0) {
                        if (this.log10TickLabelsFlag) {
                            s = "10^" + i;
                        }
                        else if (this.expTickLabelsFlag) {
                            s = "1e" + i;
                        }
                        else if (i >= 0) {
                            final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
                            if (numberFormatOverride != null) {
                                s = numberFormatOverride.format(n5);
                            }
                            else {
                                s = Long.toString((long)Math.rint(n5));
                            }
                        }
                        else {
                            this.numberFormatterObj.setMaximumFractionDigits(-i);
                            s = this.numberFormatterObj.format(n5);
                        }
                    }
                    else {
                        s = "";
                    }
                }
                else {
                    if (n3 != 0) {
                        --j;
                    }
                    n5 = ((i >= 0) ? (Math.pow(10.0, i) + Math.pow(10.0, i) * j) : (-(Math.pow(10.0, -i) - Math.pow(10.0, -i - 1) * j)));
                    if (j == 0) {
                        if (n3 == 0) {
                            if (i > n && i < n2 && Math.abs(n5 - 1.0) < 1.0E-4) {
                                n5 = 0.0;
                                n3 = 1;
                                s = "0";
                            }
                            else if (this.log10TickLabelsFlag) {
                                s = ((i < 0) ? "-" : "") + "10^" + Math.abs(i);
                            }
                            else if (this.expTickLabelsFlag) {
                                s = ((i < 0) ? "-" : "") + "1e" + Math.abs(i);
                            }
                            else {
                                final NumberFormat numberFormatOverride2 = this.getNumberFormatOverride();
                                if (numberFormatOverride2 != null) {
                                    s = numberFormatOverride2.format(n5);
                                }
                                else {
                                    s = Long.toString((long)Math.rint(n5));
                                }
                            }
                        }
                        else {
                            s = "";
                            n3 = 0;
                        }
                    }
                    else {
                        s = "";
                        n3 = 0;
                    }
                }
                if (n5 > upperBound) {
                    return list;
                }
                if (n5 >= lowerBound - 1.0E-100) {
                    double n6 = 0.0;
                    TextAnchor textAnchor;
                    TextAnchor textAnchor2;
                    if (this.isVerticalTickLabels()) {
                        if (rectangleEdge == RectangleEdge.LEFT) {
                            textAnchor = TextAnchor.BOTTOM_CENTER;
                            textAnchor2 = TextAnchor.BOTTOM_CENTER;
                            n6 = -1.5707963267948966;
                        }
                        else {
                            textAnchor = TextAnchor.BOTTOM_CENTER;
                            textAnchor2 = TextAnchor.BOTTOM_CENTER;
                            n6 = 1.5707963267948966;
                        }
                    }
                    else if (rectangleEdge == RectangleEdge.LEFT) {
                        textAnchor = TextAnchor.CENTER_RIGHT;
                        textAnchor2 = TextAnchor.CENTER_RIGHT;
                    }
                    else {
                        textAnchor = TextAnchor.CENTER_LEFT;
                        textAnchor2 = TextAnchor.CENTER_LEFT;
                    }
                    list.add(new NumberTick(new Double(n5), s, textAnchor, textAnchor2, n6));
                }
            }
        }
        return list;
    }
    
    protected String makeTickLabel(final double n, final boolean b) {
        if (this.expTickLabelsFlag || b) {
            return this.numberFormatterObj.format(n).toLowerCase();
        }
        return this.getTickUnit().valueToString(n);
    }
    
    protected String makeTickLabel(final double n) {
        return this.makeTickLabel(n, false);
    }
    
    static {
        LOG10_VALUE = Math.log(10.0);
    }
}
