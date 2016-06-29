package org.jfree.chart.axis;

import java.io.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.chart.plot.*;

public class ColorBar implements Serializable, Cloneable
{
    private static final long serialVersionUID = -2101776212647268103L;
    public static final int DEFAULT_COLORBAR_THICKNESS = 0;
    public static final double DEFAULT_COLORBAR_THICKNESS_PERCENT = 0.1;
    public static final int DEFAULT_OUTERGAP = 2;
    private ValueAxis axis;
    private int colorBarThickness;
    private double colorBarThicknessPercent;
    private ColorPalette colorPalette;
    private int colorBarLength;
    private int outerGap;
    
    public ColorBar(final String s) {
        this.colorBarThickness = 0;
        this.colorBarThicknessPercent = 0.1;
        this.colorPalette = null;
        this.colorBarLength = 0;
        final NumberAxis axis = new NumberAxis(s);
        axis.setAutoRangeIncludesZero(false);
        (this.axis = axis).setLowerMargin(0.0);
        this.axis.setUpperMargin(0.0);
        this.colorPalette = new RainbowPalette();
        this.colorBarThickness = 0;
        this.colorBarThicknessPercent = 0.1;
        this.outerGap = 2;
        this.colorPalette.setMinZ(this.axis.getRange().getLowerBound());
        this.colorPalette.setMaxZ(this.axis.getRange().getUpperBound());
    }
    
    public void configure(final ContourPlot contourPlot) {
        final double minZValue = contourPlot.getDataset().getMinZValue();
        final double maxZValue = contourPlot.getDataset().getMaxZValue();
        this.setMinimumValue(minZValue);
        this.setMaximumValue(maxZValue);
    }
    
    public ValueAxis getAxis() {
        return this.axis;
    }
    
    public void setAxis(final ValueAxis axis) {
        this.axis = axis;
    }
    
    public void autoAdjustRange() {
        this.axis.autoAdjustRange();
        this.colorPalette.setMinZ(this.axis.getLowerBound());
        this.colorPalette.setMaxZ(this.axis.getUpperBound());
    }
    
    public double draw(final Graphics2D graphics2D, double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final Rectangle2D rectangle2D3, final RectangleEdge rectangleEdge) {
        Rectangle2D rectangle2D4 = null;
        double calculateBarThickness = this.calculateBarThickness(rectangle2D2, rectangleEdge);
        if (this.colorBarThickness > 0) {
            calculateBarThickness = this.colorBarThickness;
        }
        double n2;
        if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n2 = rectangle2D2.getHeight();
        }
        else {
            n2 = rectangle2D2.getWidth();
        }
        if (this.colorBarLength > 0) {
            n2 = this.colorBarLength;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            rectangle2D4 = new Rectangle2D.Double(rectangle2D2.getX(), rectangle2D.getMaxY() + this.outerGap, n2, calculateBarThickness);
        }
        else if (rectangleEdge == RectangleEdge.TOP) {
            rectangle2D4 = new Rectangle2D.Double(rectangle2D2.getX(), rectangle2D3.getMinY() + this.outerGap, n2, calculateBarThickness);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            rectangle2D4 = new Rectangle2D.Double(rectangle2D.getX() - calculateBarThickness - this.outerGap, rectangle2D2.getMinY(), calculateBarThickness, n2);
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            rectangle2D4 = new Rectangle2D.Double(rectangle2D.getMaxX() + this.outerGap, rectangle2D2.getMinY(), calculateBarThickness, n2);
        }
        this.axis.refreshTicks(graphics2D, new AxisState(), rectangle2D4, rectangleEdge);
        this.drawColorBar(graphics2D, rectangle2D4, rectangleEdge);
        AxisState axisState = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            n = rectangle2D4.getMinY();
            axisState = this.axis.draw(graphics2D, n, rectangle2D3, rectangle2D4, RectangleEdge.TOP, null);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            n = rectangle2D4.getMaxY();
            axisState = this.axis.draw(graphics2D, n, rectangle2D3, rectangle2D4, RectangleEdge.BOTTOM, null);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            n = rectangle2D4.getMinX();
            axisState = this.axis.draw(graphics2D, n, rectangle2D3, rectangle2D4, RectangleEdge.LEFT, null);
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            n = rectangle2D4.getMaxX();
            axisState = this.axis.draw(graphics2D, n, rectangle2D3, rectangle2D4, RectangleEdge.RIGHT, null);
        }
        return axisState.getCursor();
    }
    
    public void drawColorBar(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final Object renderingHint = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        final Stroke stroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(1.0f));
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            final double y = rectangle2D.getY();
            final double maxY = rectangle2D.getMaxY();
            double x = rectangle2D.getX();
            final Line2D.Double double1 = new Line2D.Double();
            while (x <= rectangle2D.getMaxX()) {
                final double java2DToValue = this.axis.java2DToValue(x, rectangle2D, rectangleEdge);
                double1.setLine(x, y, x, maxY);
                graphics2D.setPaint(this.getPaint(java2DToValue));
                graphics2D.draw(double1);
                ++x;
            }
        }
        else {
            final double x2 = rectangle2D.getX();
            final double maxX = rectangle2D.getMaxX();
            double y2 = rectangle2D.getY();
            final Line2D.Double double2 = new Line2D.Double();
            while (y2 <= rectangle2D.getMaxY()) {
                final double java2DToValue2 = this.axis.java2DToValue(y2, rectangle2D, rectangleEdge);
                double2.setLine(x2, y2, maxX, y2);
                graphics2D.setPaint(this.getPaint(java2DToValue2));
                graphics2D.draw(double2);
                ++y2;
            }
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, renderingHint);
        graphics2D.setStroke(stroke);
    }
    
    public ColorPalette getColorPalette() {
        return this.colorPalette;
    }
    
    public Paint getPaint(final double n) {
        return this.colorPalette.getPaint(n);
    }
    
    public void setColorPalette(final ColorPalette colorPalette) {
        this.colorPalette = colorPalette;
    }
    
    public void setMaximumValue(final double n) {
        this.colorPalette.setMaxZ(n);
        this.axis.setUpperBound(n);
    }
    
    public void setMinimumValue(final double n) {
        this.colorPalette.setMinZ(n);
        this.axis.setLowerBound(n);
    }
    
    public AxisSpace reserveSpace(final Graphics2D graphics2D, final Plot plot, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final AxisSpace axisSpace) {
        final AxisSpace reserveSpace = this.axis.reserveSpace(graphics2D, plot, rectangle2D, rectangleEdge, axisSpace);
        reserveSpace.add(this.calculateBarThickness(rectangle2D2, rectangleEdge) + 2 * this.outerGap, rectangleEdge);
        return reserveSpace;
    }
    
    private double calculateBarThickness(final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n;
        if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n = rectangle2D.getWidth() * this.colorBarThicknessPercent;
        }
        else {
            n = rectangle2D.getHeight() * this.colorBarThicknessPercent;
        }
        return n;
    }
    
    public Object clone() {
        final ColorBar colorBar = (ColorBar)super.clone();
        colorBar.axis = (ValueAxis)this.axis.clone();
        return colorBar;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ColorBar)) {
            return false;
        }
        final ColorBar colorBar = (ColorBar)o;
        return this.axis.equals(colorBar.axis) && this.colorBarThickness == colorBar.colorBarThickness && this.colorBarThicknessPercent == colorBar.colorBarThicknessPercent && this.colorPalette.equals(colorBar.colorPalette) && this.colorBarLength == colorBar.colorBarLength && this.outerGap == colorBar.outerGap;
    }
    
    public int hashCode() {
        return this.axis.hashCode();
    }
}
