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
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PaintUtilities;

public class SymbolAxis
extends NumberAxis
implements Serializable {
    private static final long serialVersionUID = 7216330468770619716L;
    public static final Paint DEFAULT_GRID_BAND_PAINT = new Color(232, 234, 232, 128);
    private List symbols;
    private transient Paint gridBandPaint;
    private boolean gridBandsVisible;

    public SymbolAxis(String string, String[] arrstring) {
        super(string);
        this.symbols = Arrays.asList(arrstring);
        this.gridBandsVisible = true;
        this.gridBandPaint = DEFAULT_GRID_BAND_PAINT;
        this.setAutoTickUnitSelection(false, false);
        this.setAutoRangeStickyZero(false);
    }

    public String[] getSymbols() {
        String[] arrstring = new String[this.symbols.size()];
        return this.symbols.toArray(arrstring);
    }

    public Paint getGridBandPaint() {
        return this.gridBandPaint;
    }

    public void setGridBandPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.gridBandPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isGridBandsVisible() {
        return this.gridBandsVisible;
    }

    public void setGridBandsVisible(boolean bl2) {
        if (this.gridBandsVisible == bl2) return;
        this.gridBandsVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    protected void selectAutoTickUnit(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        AxisState axisState = new AxisState(d2);
        if (this.isVisible()) {
            axisState = super.draw(graphics2D, d2, rectangle2D, rectangle2D2, rectangleEdge, plotRenderingInfo);
        }
        if (!this.gridBandsVisible) return axisState;
        this.drawGridBands(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, axisState.getTicks());
        return axisState;
    }

    protected void drawGridBands(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, List list) {
        Shape shape = graphics2D.getClip();
        graphics2D.clip(rectangle2D2);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.drawGridBandsHorizontal(graphics2D, rectangle2D, rectangle2D2, true, list);
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            this.drawGridBandsVertical(graphics2D, rectangle2D, rectangle2D2, true, list);
        }
        graphics2D.setClip(shape);
    }

    protected void drawGridBandsHorizontal(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, boolean bl2, List list) {
        boolean bl3 = bl2;
        double d2 = rectangle2D2.getY();
        double d3 = this.getPlot().getOutlineStroke() != null ? (double)((BasicStroke)this.getPlot().getOutlineStroke()).getLineWidth() : 1.0;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                graphics2D.setPaintMode();
                return;
            }
            ValueTick valueTick = (ValueTick)iterator.next();
            double d4 = this.valueToJava2D(valueTick.getValue() - 0.5, rectangle2D2, RectangleEdge.BOTTOM);
            double d5 = this.valueToJava2D(valueTick.getValue() + 0.5, rectangle2D2, RectangleEdge.BOTTOM);
            if (bl3) {
                graphics2D.setPaint(this.gridBandPaint);
            } else {
                graphics2D.setPaint(Color.white);
            }
            Rectangle2D.Double double_ = new Rectangle2D.Double(d4, d2 + d3, d5 - d4, rectangle2D2.getMaxY() - d2 - d3);
            graphics2D.fill(double_);
            bl3 = !bl3;
        } while (true);
    }

    protected void drawGridBandsVertical(Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, boolean bl2, List list) {
        boolean bl3 = bl2;
        double d2 = rectangle2D2.getX();
        Stroke stroke = this.getPlot().getOutlineStroke();
        double d3 = stroke != null && stroke instanceof BasicStroke ? (double)((BasicStroke)stroke).getLineWidth() : 1.0;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                graphics2D.setPaintMode();
                return;
            }
            ValueTick valueTick = (ValueTick)iterator.next();
            double d4 = this.valueToJava2D(valueTick.getValue() + 0.5, rectangle2D2, RectangleEdge.LEFT);
            double d5 = this.valueToJava2D(valueTick.getValue() - 0.5, rectangle2D2, RectangleEdge.LEFT);
            if (bl3) {
                graphics2D.setPaint(this.gridBandPaint);
            } else {
                graphics2D.setPaint(Color.white);
            }
            Rectangle2D.Double double_ = new Rectangle2D.Double(d2 + d3, d4, rectangle2D2.getMaxX() - d2 - d3, d5 - d4);
            graphics2D.fill(double_);
            bl3 = !bl3;
        } while (true);
    }

    @Override
    protected void autoAdjustRange() {
        double d2;
        double d3;
        Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (!(plot instanceof ValueAxisPlot)) return;
        double d4 = this.symbols.size() - 1;
        double d5 = d4 - (d3 = 0.0);
        if (d5 < (d2 = this.getAutoRangeMinimumSize())) {
            d4 = (d4 + d3 + d2) / 2.0;
            d3 = (d4 + d3 - d2) / 2.0;
        }
        double d6 = 0.5;
        double d7 = 0.5;
        if (this.getAutoRangeIncludesZero()) {
            if (this.getAutoRangeStickyZero()) {
                d4 = d4 <= 0.0 ? 0.0 : (d4 += d6);
                d3 = d3 >= 0.0 ? 0.0 : (d3 -= d7);
            } else {
                d4 = Math.max(0.0, d4 + d6);
                d3 = Math.min(0.0, d3 - d7);
            }
        } else if (this.getAutoRangeStickyZero()) {
            d4 = d4 <= 0.0 ? Math.min(0.0, d4 + d6) : (d4 += d6 * d5);
            d3 = d3 >= 0.0 ? Math.max(0.0, d3 - d7) : (d3 -= d7);
        } else {
            d4 += d6;
            d3 -= d7;
        }
        this.setRange(new Range(d3, d4), false, false);
    }

    @Override
    public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        List list = null;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            return this.refreshTicksHorizontal(graphics2D, rectangle2D, rectangleEdge);
        }
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return list;
        return this.refreshTicksVertical(graphics2D, rectangle2D, rectangleEdge);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected List refreshTicksHorizontal(Graphics2D var1_1, Rectangle2D var2_2, RectangleEdge var3_3) {
        var4_4 = new ArrayList<NumberTick>();
        var5_5 = this.getTickLabelFont();
        var1_1.setFont(var5_5);
        var6_6 = this.getTickUnit().getSize();
        var8_7 = this.calculateVisibleTickCount();
        var9_8 = this.calculateLowestVisibleTickValue();
        var11_9 = 0.0;
        var13_10 = 0.0;
        if (var8_7 > 500) return var4_4;
        var15_11 = 0;
        while (var15_11 < var8_7) {
            var16_12 = var9_8 + (double)var15_11 * var6_6;
            var18_13 = this.valueToJava2D(var16_12, var2_2, var3_3);
            var21_15 = this.getNumberFormatOverride();
            var20_14 = var21_15 != null ? var21_15.format(var16_12) : this.valueToString(var16_12);
            var22_16 = TextUtilities.getTextBounds(var20_14, var1_1, var1_1.getFontMetrics());
            var23_17 = this.isVerticalTickLabels() != false ? var22_16.getHeight() : var22_16.getWidth();
            var25_18 = false;
            if (var15_11 <= 0) ** GOTO lbl-1000
            var26_20 = (var13_10 + var23_17) / 2.0;
            if (Math.abs(var18_13 - var11_9) < var26_20) {
                var25_18 = true;
            }
            if (var25_18) {
                var20_14 = "";
            } else lbl-1000: // 2 sources:
            {
                var11_9 = var18_13;
                var13_10 = var23_17;
            }
            var26_19 = null;
            var27_21 = null;
            var28_22 = 0.0;
            if (this.isVerticalTickLabels()) {
                var26_19 = TextAnchor.CENTER_RIGHT;
                var27_21 = TextAnchor.CENTER_RIGHT;
                var28_22 = var3_3 == RectangleEdge.TOP ? 1.5707963267948966 : -1.5707963267948966;
            } else if (var3_3 == RectangleEdge.TOP) {
                var26_19 = TextAnchor.BOTTOM_CENTER;
                var27_21 = TextAnchor.BOTTOM_CENTER;
            } else {
                var26_19 = TextAnchor.TOP_CENTER;
                var27_21 = TextAnchor.TOP_CENTER;
            }
            var30_23 = new NumberTick(new Double(var16_12), var20_14, var26_19, var27_21, var28_22);
            var4_4.add(var30_23);
            ++var15_11;
        }
        return var4_4;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected List refreshTicksVertical(Graphics2D var1_1, Rectangle2D var2_2, RectangleEdge var3_3) {
        var4_4 = new ArrayList<NumberTick>();
        var5_5 = this.getTickLabelFont();
        var1_1.setFont(var5_5);
        var6_6 = this.getTickUnit().getSize();
        var8_7 = this.calculateVisibleTickCount();
        var9_8 = this.calculateLowestVisibleTickValue();
        var11_9 = 0.0;
        var13_10 = 0.0;
        if (var8_7 > 500) return var4_4;
        var15_11 = 0;
        while (var15_11 < var8_7) {
            var16_12 = var9_8 + (double)var15_11 * var6_6;
            var18_13 = this.valueToJava2D(var16_12, var2_2, var3_3);
            var21_15 = this.getNumberFormatOverride();
            var20_14 = var21_15 != null ? var21_15.format(var16_12) : this.valueToString(var16_12);
            var22_16 = TextUtilities.getTextBounds(var20_14, var1_1, var1_1.getFontMetrics());
            var23_17 = this.isVerticalTickLabels() != false ? var22_16.getWidth() : var22_16.getHeight();
            var25_18 = false;
            if (var15_11 <= 0) ** GOTO lbl-1000
            var26_20 = (var13_10 + var23_17) / 2.0;
            if (Math.abs(var18_13 - var11_9) < var26_20) {
                var25_18 = true;
            }
            if (var25_18) {
                var20_14 = "";
            } else lbl-1000: // 2 sources:
            {
                var11_9 = var18_13;
                var13_10 = var23_17;
            }
            var26_19 = null;
            var27_21 = null;
            var28_22 = 0.0;
            if (this.isVerticalTickLabels()) {
                var26_19 = TextAnchor.BOTTOM_CENTER;
                var27_21 = TextAnchor.BOTTOM_CENTER;
                var28_22 = var3_3 == RectangleEdge.LEFT ? -1.5707963267948966 : 1.5707963267948966;
            } else if (var3_3 == RectangleEdge.LEFT) {
                var26_19 = TextAnchor.CENTER_RIGHT;
                var27_21 = TextAnchor.CENTER_RIGHT;
            } else {
                var26_19 = TextAnchor.CENTER_LEFT;
                var27_21 = TextAnchor.CENTER_LEFT;
            }
            var30_23 = new NumberTick(new Double(var16_12), var20_14, var26_19, var27_21, var28_22);
            var4_4.add(var30_23);
            ++var15_11;
        }
        return var4_4;
    }

    public String valueToString(double d2) {
        try {
            return (String)this.symbols.get((int)d2);
        }
        catch (IndexOutOfBoundsException var4_3) {
            return "";
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SymbolAxis)) {
            return false;
        }
        SymbolAxis symbolAxis = (SymbolAxis)object;
        if (!this.symbols.equals(symbolAxis.symbols)) {
            return false;
        }
        if (this.gridBandsVisible != symbolAxis.gridBandsVisible) {
            return false;
        }
        if (PaintUtilities.equal(this.gridBandPaint, symbolAxis.gridBandPaint)) return super.equals(object);
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.gridBandPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.gridBandPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

