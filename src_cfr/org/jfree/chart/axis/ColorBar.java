/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.List;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ColorPalette;
import org.jfree.chart.plot.ContourPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.RainbowPalette;
import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.ui.RectangleEdge;

public class ColorBar
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -2101776212647268103L;
    public static final int DEFAULT_COLORBAR_THICKNESS = 0;
    public static final double DEFAULT_COLORBAR_THICKNESS_PERCENT = 0.1;
    public static final int DEFAULT_OUTERGAP = 2;
    private ValueAxis axis;
    private int colorBarThickness = 0;
    private double colorBarThicknessPercent = 0.1;
    private ColorPalette colorPalette = null;
    private int colorBarLength = 0;
    private int outerGap;

    public ColorBar(String string) {
        NumberAxis numberAxis = new NumberAxis(string);
        numberAxis.setAutoRangeIncludesZero(false);
        this.axis = numberAxis;
        this.axis.setLowerMargin(0.0);
        this.axis.setUpperMargin(0.0);
        this.colorPalette = new RainbowPalette();
        this.colorBarThickness = 0;
        this.colorBarThicknessPercent = 0.1;
        this.outerGap = 2;
        this.colorPalette.setMinZ(this.axis.getRange().getLowerBound());
        this.colorPalette.setMaxZ(this.axis.getRange().getUpperBound());
    }

    public void configure(ContourPlot contourPlot) {
        double d2 = contourPlot.getDataset().getMinZValue();
        double d3 = contourPlot.getDataset().getMaxZValue();
        this.setMinimumValue(d2);
        this.setMaximumValue(d3);
    }

    public ValueAxis getAxis() {
        return this.axis;
    }

    public void setAxis(ValueAxis valueAxis) {
        this.axis = valueAxis;
    }

    public void autoAdjustRange() {
        this.axis.autoAdjustRange();
        this.colorPalette.setMinZ(this.axis.getLowerBound());
        this.colorPalette.setMaxZ(this.axis.getUpperBound());
    }

    public double draw(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, Rectangle2D rectangle2D3, RectangleEdge rectangleEdge) {
        Rectangle2D.Double double_ = null;
        double d3 = this.calculateBarThickness(rectangle2D2, rectangleEdge);
        if (this.colorBarThickness > 0) {
            d3 = this.colorBarThickness;
        }
        double d4 = 0.0;
        d4 = RectangleEdge.isLeftOrRight(rectangleEdge) ? rectangle2D2.getHeight() : rectangle2D2.getWidth();
        if (this.colorBarLength > 0) {
            d4 = this.colorBarLength;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            double_ = new Rectangle2D.Double(rectangle2D2.getX(), rectangle2D.getMaxY() + (double)this.outerGap, d4, d3);
        } else if (rectangleEdge == RectangleEdge.TOP) {
            double_ = new Rectangle2D.Double(rectangle2D2.getX(), rectangle2D3.getMinY() + (double)this.outerGap, d4, d3);
        } else if (rectangleEdge == RectangleEdge.LEFT) {
            double_ = new Rectangle2D.Double(rectangle2D.getX() - d3 - (double)this.outerGap, rectangle2D2.getMinY(), d3, d4);
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            double_ = new Rectangle2D.Double(rectangle2D.getMaxX() + (double)this.outerGap, rectangle2D2.getMinY(), d3, d4);
        }
        this.axis.refreshTicks(graphics2D, new AxisState(), double_, rectangleEdge);
        this.drawColorBar(graphics2D, double_, rectangleEdge);
        AxisState axisState = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            d2 = double_.getMinY();
            axisState = this.axis.draw(graphics2D, d2, rectangle2D3, double_, RectangleEdge.TOP, null);
            return axisState.getCursor();
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            d2 = double_.getMaxY();
            axisState = this.axis.draw(graphics2D, d2, rectangle2D3, double_, RectangleEdge.BOTTOM, null);
            return axisState.getCursor();
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            d2 = double_.getMinX();
            axisState = this.axis.draw(graphics2D, d2, rectangle2D3, double_, RectangleEdge.LEFT, null);
            return axisState.getCursor();
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return axisState.getCursor();
        d2 = double_.getMaxX();
        axisState = this.axis.draw(graphics2D, d2, rectangle2D3, double_, RectangleEdge.RIGHT, null);
        return axisState.getCursor();
    }

    public void drawColorBar(Graphics2D graphics2D, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Object object = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        Stroke stroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(1.0f));
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            double d2 = rectangle2D.getY();
            double d3 = rectangle2D.getMaxY();
            Line2D.Double double_ = new Line2D.Double();
            for (double d4 = rectangle2D.getX(); d4 <= rectangle2D.getMaxX(); d4 += 1.0) {
                double d5 = this.axis.java2DToValue(d4, rectangle2D, rectangleEdge);
                double_.setLine(d4, d2, d4, d3);
                graphics2D.setPaint(this.getPaint(d5));
                graphics2D.draw(double_);
            }
        } else {
            double d6 = rectangle2D.getX();
            double d7 = rectangle2D.getMaxX();
            Line2D.Double double_ = new Line2D.Double();
            for (double d8 = rectangle2D.getY(); d8 <= rectangle2D.getMaxY(); d8 += 1.0) {
                double d9 = this.axis.java2DToValue(d8, rectangle2D, rectangleEdge);
                double_.setLine(d6, d8, d7, d8);
                graphics2D.setPaint(this.getPaint(d9));
                graphics2D.draw(double_);
            }
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, object);
        graphics2D.setStroke(stroke);
    }

    public ColorPalette getColorPalette() {
        return this.colorPalette;
    }

    public Paint getPaint(double d2) {
        return this.colorPalette.getPaint(d2);
    }

    public void setColorPalette(ColorPalette colorPalette) {
        this.colorPalette = colorPalette;
    }

    public void setMaximumValue(double d2) {
        this.colorPalette.setMaxZ(d2);
        this.axis.setUpperBound(d2);
    }

    public void setMinimumValue(double d2) {
        this.colorPalette.setMinZ(d2);
        this.axis.setLowerBound(d2);
    }

    public AxisSpace reserveSpace(Graphics2D graphics2D, Plot plot, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, AxisSpace axisSpace) {
        AxisSpace axisSpace2 = this.axis.reserveSpace(graphics2D, plot, rectangle2D, rectangleEdge, axisSpace);
        double d2 = this.calculateBarThickness(rectangle2D2, rectangleEdge);
        axisSpace2.add(d2 + (double)(2 * this.outerGap), rectangleEdge);
        return axisSpace2;
    }

    private double calculateBarThickness(Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d2 = 0.0;
        if (!RectangleEdge.isLeftOrRight(rectangleEdge)) return rectangle2D.getHeight() * this.colorBarThicknessPercent;
        return rectangle2D.getWidth() * this.colorBarThicknessPercent;
    }

    public Object clone() {
        ColorBar colorBar = (ColorBar)super.clone();
        colorBar.axis = (ValueAxis)this.axis.clone();
        return colorBar;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ColorBar)) {
            return false;
        }
        ColorBar colorBar = (ColorBar)object;
        if (!this.axis.equals(colorBar.axis)) {
            return false;
        }
        if (this.colorBarThickness != colorBar.colorBarThickness) {
            return false;
        }
        if (this.colorBarThicknessPercent != colorBar.colorBarThicknessPercent) {
            return false;
        }
        if (!this.colorPalette.equals(colorBar.colorPalette)) {
            return false;
        }
        if (this.colorBarLength != colorBar.colorBarLength) {
            return false;
        }
        if (this.outerGap == colorBar.outerGap) return true;
        return false;
    }

    public int hashCode() {
        return this.axis.hashCode();
    }
}

