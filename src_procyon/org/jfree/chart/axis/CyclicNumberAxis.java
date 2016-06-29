package org.jfree.chart.axis;

import java.util.*;
import org.jfree.ui.*;
import java.text.*;
import org.jfree.data.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.text.*;
import org.jfree.io.*;
import java.io.*;
import org.jfree.util.*;
import java.awt.*;

public class CyclicNumberAxis extends NumberAxis
{
    public static Stroke DEFAULT_ADVANCE_LINE_STROKE;
    public static final Paint DEFAULT_ADVANCE_LINE_PAINT;
    protected double offset;
    protected double period;
    protected boolean boundMappedToLastCycle;
    protected boolean advanceLineVisible;
    protected transient Stroke advanceLineStroke;
    protected transient Paint advanceLinePaint;
    private transient boolean internalMarkerWhenTicksOverlap;
    private transient Tick internalMarkerCycleBoundTick;
    
    public CyclicNumberAxis(final double n) {
        this(n, 0.0);
    }
    
    public CyclicNumberAxis(final double n, final double n2) {
        this(n, n2, null);
    }
    
    public CyclicNumberAxis(final double n, final String s) {
        this(0.0, n, s);
    }
    
    public CyclicNumberAxis(final double n, final double offset, final String s) {
        super(s);
        this.advanceLineStroke = CyclicNumberAxis.DEFAULT_ADVANCE_LINE_STROKE;
        this.period = n;
        this.offset = offset;
        this.setFixedAutoRange(n);
        this.advanceLineVisible = true;
        this.advanceLinePaint = CyclicNumberAxis.DEFAULT_ADVANCE_LINE_PAINT;
    }
    
    public boolean isAdvanceLineVisible() {
        return this.advanceLineVisible;
    }
    
    public void setAdvanceLineVisible(final boolean advanceLineVisible) {
        this.advanceLineVisible = advanceLineVisible;
    }
    
    public Paint getAdvanceLinePaint() {
        return this.advanceLinePaint;
    }
    
    public void setAdvanceLinePaint(final Paint advanceLinePaint) {
        if (advanceLinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.advanceLinePaint = advanceLinePaint;
    }
    
    public Stroke getAdvanceLineStroke() {
        return this.advanceLineStroke;
    }
    
    public void setAdvanceLineStroke(final Stroke advanceLineStroke) {
        if (advanceLineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.advanceLineStroke = advanceLineStroke;
    }
    
    public boolean isBoundMappedToLastCycle() {
        return this.boundMappedToLastCycle;
    }
    
    public void setBoundMappedToLastCycle(final boolean boundMappedToLastCycle) {
        this.boundMappedToLastCycle = boundMappedToLastCycle;
    }
    
    protected void selectHorizontalAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge) {
        this.setTickUnit((NumberTickUnit)this.getStandardTickUnits().getCeilingTickUnit(this.getRange().getLength() * this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit()) / rectangle2D2.getWidth()), false, false);
    }
    
    protected void selectVerticalAutoTickUnit(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge) {
        this.setTickUnit((NumberTickUnit)this.getStandardTickUnits().getCeilingTickUnit(this.getRange().getLength() * this.estimateMaximumTickLabelWidth(graphics2D, this.getTickUnit()) / rectangle2D2.getHeight()), false, false);
    }
    
    protected float[] calculateAnchorPoint(final ValueTick valueTick, final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        if (valueTick instanceof CyclicNumberAxis$CycleBoundTick) {
            final boolean boundMappedToLastCycle = this.boundMappedToLastCycle;
            this.boundMappedToLastCycle = ((CyclicNumberAxis$CycleBoundTick)valueTick).mapToLastCycle;
            final float[] calculateAnchorPoint = super.calculateAnchorPoint(valueTick, n, rectangle2D, rectangleEdge);
            this.boundMappedToLastCycle = boundMappedToLastCycle;
            return calculateAnchorPoint;
        }
        return super.calculateAnchorPoint(valueTick, n, rectangle2D, rectangleEdge);
    }
    
    protected List refreshTicksHorizontal(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList list = new ArrayList<CyclicNumberAxis$CycleBoundTick>();
        graphics2D.setFont(this.getTickLabelFont());
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        final double size = this.getTickUnit().getSize();
        final double cycleBound = this.getCycleBound();
        double n = Math.ceil(cycleBound / size) * size;
        double upperBound = this.getRange().getUpperBound();
        int n2 = 0;
        final boolean boundMappedToLastCycle = this.boundMappedToLastCycle;
        this.boundMappedToLastCycle = false;
        NumberTick numberTick = null;
        float n3 = 0.0f;
        if (upperBound == cycleBound) {
            n = this.calculateLowestVisibleTickValue();
            n2 = 1;
            this.boundMappedToLastCycle = true;
        }
        while (n <= upperBound) {
            boolean b = false;
            if (n + size > upperBound && n2 == 0) {
                b = true;
            }
            final double valueToJava2D = this.valueToJava2D(n, rectangle2D, rectangleEdge);
            final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
            String s;
            if (numberFormatOverride != null) {
                s = numberFormatOverride.format(n);
            }
            else {
                s = this.getTickUnit().valueToString(n);
            }
            final float n4 = (float)valueToJava2D;
            double n5 = 0.0;
            TextAnchor textAnchor;
            TextAnchor textAnchor3;
            if (this.isVerticalTickLabels()) {
                if (rectangleEdge == RectangleEdge.TOP) {
                    n5 = 1.5707963267948966;
                }
                else {
                    n5 = -1.5707963267948966;
                }
                textAnchor = TextAnchor.CENTER_RIGHT;
                if (numberTick != null && n3 == n4 && n != cycleBound) {
                    final TextAnchor textAnchor2 = this.isInverted() ? TextAnchor.TOP_RIGHT : TextAnchor.BOTTOM_RIGHT;
                    list.remove(list.size() - 1);
                    list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor2, textAnchor2, numberTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = (this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.TOP_RIGHT);
                }
                textAnchor3 = textAnchor;
            }
            else if (rectangleEdge == RectangleEdge.TOP) {
                textAnchor = TextAnchor.BOTTOM_CENTER;
                if (numberTick != null && n3 == n4 && n != cycleBound) {
                    final TextAnchor textAnchor4 = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.BOTTOM_RIGHT;
                    list.remove(list.size() - 1);
                    list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor4, textAnchor4, numberTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = (this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.BOTTOM_LEFT);
                }
                textAnchor3 = textAnchor;
            }
            else {
                textAnchor = TextAnchor.TOP_CENTER;
                if (numberTick != null && n3 == n4 && n != cycleBound) {
                    final TextAnchor textAnchor5 = this.isInverted() ? TextAnchor.TOP_LEFT : TextAnchor.TOP_RIGHT;
                    list.remove(list.size() - 1);
                    list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor5, textAnchor5, numberTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = (this.isInverted() ? TextAnchor.TOP_RIGHT : TextAnchor.TOP_LEFT);
                }
                textAnchor3 = textAnchor;
            }
            final CyclicNumberAxis$CycleBoundTick internalMarkerCycleBoundTick = new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, new Double(n), s, textAnchor, textAnchor3, n5);
            if (n == cycleBound) {
                this.internalMarkerCycleBoundTick = internalMarkerCycleBoundTick;
            }
            list.add(internalMarkerCycleBoundTick);
            numberTick = internalMarkerCycleBoundTick;
            n3 = n4;
            n += size;
            if (b) {
                n = this.calculateLowestVisibleTickValue();
                upperBound = cycleBound;
                n2 = 1;
                this.boundMappedToLastCycle = true;
            }
        }
        this.boundMappedToLastCycle = boundMappedToLastCycle;
        return list;
    }
    
    protected List refreshVerticalTicks(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final ArrayList<CyclicNumberAxis$CycleBoundTick> list = new ArrayList<CyclicNumberAxis$CycleBoundTick>();
        list.clear();
        graphics2D.setFont(this.getTickLabelFont());
        if (this.isAutoTickUnitSelection()) {
            this.selectAutoTickUnit(graphics2D, rectangle2D, rectangleEdge);
        }
        final double size = this.getTickUnit().getSize();
        final double cycleBound = this.getCycleBound();
        double n = Math.ceil(cycleBound / size) * size;
        double upperBound = this.getRange().getUpperBound();
        int n2 = 0;
        final boolean boundMappedToLastCycle = this.boundMappedToLastCycle;
        this.boundMappedToLastCycle = true;
        NumberTick numberTick = null;
        float n3 = 0.0f;
        if (upperBound == cycleBound) {
            n = this.calculateLowestVisibleTickValue();
            n2 = 1;
            this.boundMappedToLastCycle = true;
        }
        while (n <= upperBound) {
            boolean b = false;
            if (n + size > upperBound && n2 == 0) {
                b = true;
            }
            final double valueToJava2D = this.valueToJava2D(n, rectangle2D, rectangleEdge);
            final NumberFormat numberFormatOverride = this.getNumberFormatOverride();
            String s;
            if (numberFormatOverride != null) {
                s = numberFormatOverride.format(n);
            }
            else {
                s = this.getTickUnit().valueToString(n);
            }
            final float n4 = (float)valueToJava2D;
            double n5 = 0.0;
            TextAnchor textAnchor;
            TextAnchor textAnchor3;
            if (this.isVerticalTickLabels()) {
                if (rectangleEdge == RectangleEdge.LEFT) {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    if (numberTick != null && n3 == n4 && n != cycleBound) {
                        final TextAnchor textAnchor2 = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.BOTTOM_RIGHT;
                        list.remove(list.size() - 1);
                        list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor2, textAnchor2, numberTick.getAngle()));
                        this.internalMarkerWhenTicksOverlap = true;
                        textAnchor = (this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.BOTTOM_LEFT);
                    }
                    textAnchor3 = textAnchor;
                    n5 = -1.5707963267948966;
                }
                else {
                    textAnchor = TextAnchor.BOTTOM_CENTER;
                    if (numberTick != null && n3 == n4 && n != cycleBound) {
                        final TextAnchor textAnchor4 = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.BOTTOM_LEFT;
                        list.remove(list.size() - 1);
                        list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor4, textAnchor4, numberTick.getAngle()));
                        this.internalMarkerWhenTicksOverlap = true;
                        textAnchor = (this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.BOTTOM_RIGHT);
                    }
                    textAnchor3 = textAnchor;
                    n5 = 1.5707963267948966;
                }
            }
            else if (rectangleEdge == RectangleEdge.LEFT) {
                textAnchor = TextAnchor.CENTER_RIGHT;
                if (numberTick != null && n3 == n4 && n != cycleBound) {
                    final TextAnchor textAnchor5 = this.isInverted() ? TextAnchor.BOTTOM_RIGHT : TextAnchor.TOP_RIGHT;
                    list.remove(list.size() - 1);
                    list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor5, textAnchor5, numberTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = (this.isInverted() ? TextAnchor.TOP_RIGHT : TextAnchor.BOTTOM_RIGHT);
                }
                textAnchor3 = textAnchor;
            }
            else {
                textAnchor = TextAnchor.CENTER_LEFT;
                if (numberTick != null && n3 == n4 && n != cycleBound) {
                    final TextAnchor textAnchor6 = this.isInverted() ? TextAnchor.BOTTOM_LEFT : TextAnchor.TOP_LEFT;
                    list.remove(list.size() - 1);
                    list.add(new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, numberTick.getNumber(), numberTick.getText(), textAnchor6, textAnchor6, numberTick.getAngle()));
                    this.internalMarkerWhenTicksOverlap = true;
                    textAnchor = (this.isInverted() ? TextAnchor.TOP_LEFT : TextAnchor.BOTTOM_LEFT);
                }
                textAnchor3 = textAnchor;
            }
            final CyclicNumberAxis$CycleBoundTick cyclicNumberAxis$CycleBoundTick = new CyclicNumberAxis$CycleBoundTick(this.boundMappedToLastCycle, new Double(n), s, textAnchor, textAnchor3, n5);
            if (n == cycleBound) {
                this.internalMarkerCycleBoundTick = cyclicNumberAxis$CycleBoundTick;
            }
            list.add(cyclicNumberAxis$CycleBoundTick);
            numberTick = cyclicNumberAxis$CycleBoundTick;
            n3 = n4;
            if (n == cycleBound) {
                this.internalMarkerCycleBoundTick = cyclicNumberAxis$CycleBoundTick;
            }
            n += size;
            if (b) {
                n = this.calculateLowestVisibleTickValue();
                upperBound = cycleBound;
                n2 = 1;
                this.boundMappedToLastCycle = false;
            }
        }
        this.boundMappedToLastCycle = boundMappedToLastCycle;
        return list;
    }
    
    public double java2DToValue(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final double upperBound = this.getRange().getUpperBound();
        final double cycleBound = this.getCycleBound();
        double n2 = 0.0;
        double n3 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getMinX();
            n3 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n2 = rectangle2D.getMaxY();
            n3 = rectangle2D.getMinY();
        }
        if (this.isInverted()) {
            if (n >= n3 - (upperBound - cycleBound) * (n3 - n2) / this.period) {
                return cycleBound + (n3 - n) * this.period / (n3 - n2);
            }
            return cycleBound - (n - n2) * this.period / (n3 - n2);
        }
        else {
            if (n <= (upperBound - cycleBound) * (n3 - n2) / this.period + n2) {
                return cycleBound + (n - n2) * this.period / (n3 - n2);
            }
            return cycleBound - (n3 - n) * this.period / (n3 - n2);
        }
    }
    
    public double valueToJava2D(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final Range range = this.getRange();
        final double lowerBound = range.getLowerBound();
        final double upperBound = range.getUpperBound();
        final double cycleBound = this.getCycleBound();
        if (n < lowerBound || n > upperBound) {
            return Double.NaN;
        }
        double n2 = 0.0;
        double n3 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getMinX();
            n3 = rectangle2D.getMaxX();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n3 = rectangle2D.getMinY();
            n2 = rectangle2D.getMaxY();
        }
        if (this.isInverted()) {
            if (n == cycleBound) {
                return this.boundMappedToLastCycle ? n2 : n3;
            }
            if (n > cycleBound) {
                return n3 - (n - cycleBound) * (n3 - n2) / this.period;
            }
            return n2 + (cycleBound - n) * (n3 - n2) / this.period;
        }
        else {
            if (n == cycleBound) {
                return this.boundMappedToLastCycle ? n3 : n2;
            }
            if (n >= cycleBound) {
                return n2 + (n - cycleBound) * (n3 - n2) / this.period;
            }
            return n3 - (cycleBound - n) * (n3 - n2) / this.period;
        }
    }
    
    public void centerRange(final double n) {
        this.setRange(n - this.period / 2.0, n + this.period / 2.0);
    }
    
    public void setAutoRangeMinimumSize(final double period, final boolean b) {
        if (period > this.period) {
            this.period = period;
        }
        super.setAutoRangeMinimumSize(period, b);
    }
    
    public void setFixedAutoRange(final double period) {
        super.setFixedAutoRange(this.period = period);
    }
    
    public void setRange(final Range range, final boolean b, final boolean b2) {
        final double period = range.getUpperBound() - range.getLowerBound();
        if (period > this.period) {
            this.period = period;
        }
        super.setRange(range, b, b2);
    }
    
    public double getCycleBound() {
        return Math.floor((this.getRange().getUpperBound() - this.offset) / this.period) * this.period + this.offset;
    }
    
    public double getOffset() {
        return this.offset;
    }
    
    public void setOffset(final double offset) {
        this.offset = offset;
    }
    
    public double getPeriod() {
        return this.period;
    }
    
    public void setPeriod(final double period) {
        this.period = period;
    }
    
    protected AxisState drawTickMarksAndLabels(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge) {
        this.internalMarkerWhenTicksOverlap = false;
        final AxisState drawTickMarksAndLabels = super.drawTickMarksAndLabels(graphics2D, n, rectangle2D, rectangle2D2, rectangleEdge);
        if (!this.internalMarkerWhenTicksOverlap) {
            return drawTickMarksAndLabels;
        }
        final double n2 = this.getTickMarkOutsideLength();
        final FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getTickLabelFont());
        double n3;
        if (this.isVerticalTickLabels()) {
            n3 = fontMetrics.getMaxAdvance();
        }
        else {
            n3 = fontMetrics.getHeight();
        }
        final double n4 = 0.0;
        if (this.isTickMarksVisible()) {
            final float n5 = (float)this.valueToJava2D(this.getRange().getUpperBound(), rectangle2D2, rectangleEdge);
            Shape shape = null;
            graphics2D.setStroke(this.getTickMarkStroke());
            graphics2D.setPaint(this.getTickMarkPaint());
            if (rectangleEdge == RectangleEdge.LEFT) {
                shape = new Line2D.Double(n - n3, n5, n + n4, n5);
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                shape = new Line2D.Double(n + n3, n5, n - n4, n5);
            }
            else if (rectangleEdge == RectangleEdge.TOP) {
                shape = new Line2D.Double(n5, n - n3, n5, n + n4);
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                shape = new Line2D.Double(n5, n + n3, n5, n - n4);
            }
            graphics2D.draw(shape);
        }
        return drawTickMarksAndLabels;
    }
    
    public AxisState draw(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final PlotRenderingInfo plotRenderingInfo) {
        final AxisState draw = super.draw(graphics2D, n, rectangle2D, rectangle2D2, rectangleEdge, plotRenderingInfo);
        if (this.isAdvanceLineVisible()) {
            final double valueToJava2D = this.valueToJava2D(this.getRange().getUpperBound(), rectangle2D2, rectangleEdge);
            Shape shape = null;
            graphics2D.setStroke(this.getAdvanceLineStroke());
            graphics2D.setPaint(this.getAdvanceLinePaint());
            if (rectangleEdge == RectangleEdge.LEFT) {
                shape = new Line2D.Double(n, valueToJava2D, n + rectangle2D2.getWidth(), valueToJava2D);
            }
            else if (rectangleEdge == RectangleEdge.RIGHT) {
                shape = new Line2D.Double(n - rectangle2D2.getWidth(), valueToJava2D, n, valueToJava2D);
            }
            else if (rectangleEdge == RectangleEdge.TOP) {
                shape = new Line2D.Double(valueToJava2D, n + rectangle2D2.getHeight(), valueToJava2D, n);
            }
            else if (rectangleEdge == RectangleEdge.BOTTOM) {
                shape = new Line2D.Double(valueToJava2D, n, valueToJava2D, n - rectangle2D2.getHeight());
            }
            graphics2D.draw(shape);
        }
        return draw;
    }
    
    public AxisSpace reserveSpace(final Graphics2D graphics2D, final Plot plot, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, final AxisSpace axisSpace) {
        this.internalMarkerCycleBoundTick = null;
        final AxisSpace reserveSpace = super.reserveSpace(graphics2D, plot, rectangle2D, rectangleEdge, axisSpace);
        if (this.internalMarkerCycleBoundTick == null) {
            return reserveSpace;
        }
        final Rectangle2D textBounds = TextUtilities.getTextBounds(this.internalMarkerCycleBoundTick.getText(), graphics2D, graphics2D.getFontMetrics(this.getTickLabelFont()));
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            if (this.isVerticalTickLabels()) {
                axisSpace.add(textBounds.getHeight() / 2.0, RectangleEdge.RIGHT);
            }
            else {
                axisSpace.add(textBounds.getWidth() / 2.0, RectangleEdge.RIGHT);
            }
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            if (this.isVerticalTickLabels()) {
                axisSpace.add(textBounds.getWidth() / 2.0, RectangleEdge.TOP);
            }
            else {
                axisSpace.add(textBounds.getHeight() / 2.0, RectangleEdge.TOP);
            }
        }
        return reserveSpace;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.advanceLinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.advanceLineStroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.advanceLinePaint = SerialUtilities.readPaint(objectInputStream);
        this.advanceLineStroke = SerialUtilities.readStroke(objectInputStream);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CyclicNumberAxis)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CyclicNumberAxis cyclicNumberAxis = (CyclicNumberAxis)o;
        return this.period == cyclicNumberAxis.period && this.offset == cyclicNumberAxis.offset && PaintUtilities.equal(this.advanceLinePaint, cyclicNumberAxis.advanceLinePaint) && ObjectUtilities.equal(this.advanceLineStroke, cyclicNumberAxis.advanceLineStroke) && this.advanceLineVisible == cyclicNumberAxis.advanceLineVisible && this.boundMappedToLastCycle == cyclicNumberAxis.boundMappedToLastCycle;
    }
    
    static {
        CyclicNumberAxis.DEFAULT_ADVANCE_LINE_STROKE = new BasicStroke(1.0f);
        DEFAULT_ADVANCE_LINE_PAINT = Color.gray;
    }
}
