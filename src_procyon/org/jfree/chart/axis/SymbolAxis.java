package org.jfree.chart.axis;

import org.jfree.chart.event.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.data.*;
import org.jfree.chart.plot.*;
import java.util.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import java.text.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class SymbolAxis extends NumberAxis implements Serializable
{
    private static final long serialVersionUID = 7216330468770619716L;
    public static final Paint DEFAULT_GRID_BAND_PAINT;
    private List symbols;
    private transient Paint gridBandPaint;
    private boolean gridBandsVisible;
    
    public SymbolAxis(final String s, final String[] array) {
        super(s);
        this.symbols = Arrays.asList(array);
        this.gridBandsVisible = true;
        this.gridBandPaint = SymbolAxis.DEFAULT_GRID_BAND_PAINT;
        this.setAutoTickUnitSelection(false, false);
        this.setAutoRangeStickyZero(false);
    }
    
    public String[] getSymbols() {
        return this.symbols.toArray(new String[this.symbols.size()]);
    }
    
    public Paint getGridBandPaint() {
        return this.gridBandPaint;
    }
    
    public void setGridBandPaint(final Paint gridBandPaint) {
        if (gridBandPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.gridBandPaint = gridBandPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public boolean isGridBandsVisible() {
        return this.gridBandsVisible;
    }
    
    public void setGridBandsVisible(final boolean gridBandsVisible) {
        if (this.gridBandsVisible != gridBandsVisible) {
            this.gridBandsVisible = gridBandsVisible;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    protected void selectAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        throw new UnsupportedOperationException();
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        AxisState draw = new AxisState(n);
        if (this.isVisible()) {
            draw = super.draw(graphics2D, n, rectangle2D, rectangle2D2, rectangleEdge, plotRenderingInfo);
        }
        if (this.gridBandsVisible) {
            this.drawGridBands(graphics2D, rectangle2D, rectangle2D2, rectangleEdge, draw.getTicks());
        }
        return draw;
    }
    
    protected void drawGridBands(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final List list) {
        final Shape clip = graphics2D.getClip();
        graphics2D.clip(rectangle2D2);
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            this.drawGridBandsHorizontal(graphics2D, rectangle2D, rectangle2D2, true, list);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            this.drawGridBandsVertical(graphics2D, rectangle2D, rectangle2D2, true, list);
        }
        graphics2D.setClip(clip);
    }
    
    protected void drawGridBandsHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final boolean b, final List list) {
        boolean b2 = b;
        final double y = rectangle2D2.getY();
        double n;
        if (this.getPlot().getOutlineStroke() != null) {
            n = ((BasicStroke)this.getPlot().getOutlineStroke()).getLineWidth();
        }
        else {
            n = 1.0;
        }
        for (final ValueTick valueTick : list) {
            final double valueToJava2D = this.valueToJava2D(valueTick.getValue() - 0.5, rectangle2D2, RectangleEdge.BOTTOM);
            final double valueToJava2D2 = this.valueToJava2D(valueTick.getValue() + 0.5, rectangle2D2, RectangleEdge.BOTTOM);
            if (b2) {
                graphics2D.setPaint(this.gridBandPaint);
            }
            else {
                graphics2D.setPaint(Color.white);
            }
            graphics2D.fill(new Rectangle2D.Double(valueToJava2D, y + n, valueToJava2D2 - valueToJava2D, rectangle2D2.getMaxY() - y - n));
            b2 = !b2;
        }
        graphics2D.setPaintMode();
    }
    
    protected void drawGridBandsVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final boolean b, final List list) {
        boolean b2 = b;
        final double x = rectangle2D2.getX();
        final Stroke outlineStroke = this.getPlot().getOutlineStroke();
        double n;
        if (outlineStroke != null && outlineStroke instanceof BasicStroke) {
            n = ((BasicStroke)outlineStroke).getLineWidth();
        }
        else {
            n = 1.0;
        }
        for (final ValueTick valueTick : list) {
            final double valueToJava2D = this.valueToJava2D(valueTick.getValue() + 0.5, rectangle2D2, RectangleEdge.LEFT);
            final double valueToJava2D2 = this.valueToJava2D(valueTick.getValue() - 0.5, rectangle2D2, RectangleEdge.LEFT);
            if (b2) {
                graphics2D.setPaint(this.gridBandPaint);
            }
            else {
                graphics2D.setPaint(Color.white);
            }
            graphics2D.fill(new Rectangle2D.Double(x + n, valueToJava2D, rectangle2D2.getMaxX() - x - n, valueToJava2D2 - valueToJava2D));
            b2 = !b2;
        }
        graphics2D.setPaintMode();
    }
    
    protected void autoAdjustRange() {
        final Plot plot = this.getPlot();
        if (plot == null) {
            return;
        }
        if (plot instanceof ValueAxisPlot) {
            double n = this.symbols.size() - 1;
            double n2 = 0.0;
            final double n3 = n - n2;
            final double autoRangeMinimumSize = this.getAutoRangeMinimumSize();
            if (n3 < autoRangeMinimumSize) {
                n = (n + n2 + autoRangeMinimumSize) / 2.0;
                n2 = (n + n2 - autoRangeMinimumSize) / 2.0;
            }
            final double n4 = 0.5;
            final double n5 = 0.5;
            double n6;
            double n7;
            if (this.getAutoRangeIncludesZero()) {
                if (this.getAutoRangeStickyZero()) {
                    if (n <= 0.0) {
                        n6 = 0.0;
                    }
                    else {
                        n6 = n + n4;
                    }
                    if (n2 >= 0.0) {
                        n7 = 0.0;
                    }
                    else {
                        n7 = n2 - n5;
                    }
                }
                else {
                    n6 = Math.max(0.0, n + n4);
                    n7 = Math.min(0.0, n2 - n5);
                }
            }
            else if (this.getAutoRangeStickyZero()) {
                if (n <= 0.0) {
                    n6 = Math.min(0.0, n + n4);
                }
                else {
                    n6 = n + n4 * n3;
                }
                if (n2 >= 0.0) {
                    n7 = Math.max(0.0, n2 - n5);
                }
                else {
                    n7 = n2 - n5;
                }
            }
            else {
                n6 = n + n4;
                n7 = n2 - n5;
            }
            this.setRange(new Range(n7, n6), false, false);
        }
    }
    
    public List refreshTicks(final Graphics2D graphics2D, final AxisState axisState, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        List list = null;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            list = this.refreshTicksHorizontal(graphics2D, rectangle2D, rectangleEdge);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            list = this.refreshTicksVertical(graphics2D, rectangle2D, rectangleEdge);
        }
        return list;
    }
    
    protected List refreshTicksHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> list = new ArrayList<NumberTick>();
        graphics2D.setFont(this.getTickLabelFont());
        final double size = this.getTickUnit().getSize();
        final int calculateVisibleTickCount = this.calculateVisibleTickCount();
        final double calculateLowestVisibleTickValue = this.calculateLowestVisibleTickValue();
        double n = 0.0;
        double n2 = 0.0;
        if (calculateVisibleTickCount <= 500) {
            for (int i = 0; i < calculateVisibleTickCount; ++i) {
                final double n3 = calculateLowestVisibleTickValue + i * size;
                final double valueToJava2D = this.valueToJava2D(n3, rectangle2D, rectangleEdge);
                final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
                String s;
                if (numberFormatOverride != null) {
                    s = numberFormatOverride.format(n3);
                }
                else {
                    s = this.valueToString(n3);
                }
                final Rectangle2D textBounds = TextUtilities.getTextBounds(s, graphics2D, graphics2D.getFontMetrics());
                final double n4 = this.isVerticalTickLabels() ? textBounds.getHeight() : textBounds.getWidth();
                boolean b = false;
                if (i > 0 && Math.abs(valueToJava2D - n) < (n2 + n4) / 2.0) {
                    b = true;
                }
                if (b) {
                    s = "";
                }
                else {
                    n = valueToJava2D;
                    n2 = n4;
                }
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
                list.add(new NumberTick(new Double(n3), s, textAnchor, textAnchor2, n5));
            }
        }
        return list;
    }
    
    protected List refreshTicksVertical(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<NumberTick> list = new ArrayList<NumberTick>();
        graphics2D.setFont(this.getTickLabelFont());
        final double size = this.getTickUnit().getSize();
        final int calculateVisibleTickCount = this.calculateVisibleTickCount();
        final double calculateLowestVisibleTickValue = this.calculateLowestVisibleTickValue();
        double n = 0.0;
        double n2 = 0.0;
        if (calculateVisibleTickCount <= 500) {
            for (int i = 0; i < calculateVisibleTickCount; ++i) {
                final double n3 = calculateLowestVisibleTickValue + i * size;
                final double valueToJava2D = this.valueToJava2D(n3, rectangle2D, rectangleEdge);
                final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
                String s;
                if (numberFormatOverride != null) {
                    s = numberFormatOverride.format(n3);
                }
                else {
                    s = this.valueToString(n3);
                }
                final Rectangle2D textBounds = TextUtilities.getTextBounds(s, graphics2D, graphics2D.getFontMetrics());
                final double n4 = this.isVerticalTickLabels() ? textBounds.getWidth() : textBounds.getHeight();
                boolean b = false;
                if (i > 0 && Math.abs(valueToJava2D - n) < (n2 + n4) / 2.0) {
                    b = true;
                }
                if (b) {
                    s = "";
                }
                else {
                    n = valueToJava2D;
                    n2 = n4;
                }
                double n5 = 0.0;
                TextAnchor textAnchor;
                TextAnchor textAnchor2;
                if (this.isVerticalTickLabels()) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    textAnchor2 = TextAnchor.BOTTOM_CENTER;
                    if (rectangleEdge == RectangleEdge.LEFT) {
                        n5 = -1.5707963267948966;
                    }
                    else {
                        n5 = 1.5707963267948966;
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
                list.add(new NumberTick(new Double(n3), s, textAnchor, textAnchor2, n5));
            }
        }
        return list;
    }
    
    public String valueToString(final double n) {
        String s;
        try {
            s = this.symbols.get((int)n);
        }
        catch (IndexOutOfBoundsException ex) {
            s = "";
        }
        return s;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SymbolAxis)) {
            return false;
        }
        final SymbolAxis symbolAxis = (SymbolAxis)o;
        return this.symbols.equals(symbolAxis.symbols) && this.gridBandsVisible == symbolAxis.gridBandsVisible && PaintUtilities.equal(this.gridBandPaint, symbolAxis.gridBandPaint) && super.equals(o);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.gridBandPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.gridBandPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        DEFAULT_GRID_BAND_PAINT = new Color(232, 234, 232, 128);
    }
}
