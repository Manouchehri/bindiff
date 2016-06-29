package org.jfree.chart.axis;

import javax.swing.event.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.event.*;
import java.util.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public abstract class Axis implements Serializable, Cloneable
{
    private static final long serialVersionUID = 7719289504573298271L;
    public static final boolean DEFAULT_AXIS_VISIBLE = true;
    public static final Font DEFAULT_AXIS_LABEL_FONT;
    public static final Paint DEFAULT_AXIS_LABEL_PAINT;
    public static final RectangleInsets DEFAULT_AXIS_LABEL_INSETS;
    public static final Paint DEFAULT_AXIS_LINE_PAINT;
    public static final Stroke DEFAULT_AXIS_LINE_STROKE;
    public static final boolean DEFAULT_TICK_LABELS_VISIBLE = true;
    public static final Font DEFAULT_TICK_LABEL_FONT;
    public static final Paint DEFAULT_TICK_LABEL_PAINT;
    public static final RectangleInsets DEFAULT_TICK_LABEL_INSETS;
    public static final boolean DEFAULT_TICK_MARKS_VISIBLE = true;
    public static final Stroke DEFAULT_TICK_MARK_STROKE;
    public static final Paint DEFAULT_TICK_MARK_PAINT;
    public static final float DEFAULT_TICK_MARK_INSIDE_LENGTH = 0.0f;
    public static final float DEFAULT_TICK_MARK_OUTSIDE_LENGTH = 2.0f;
    private boolean visible;
    private String label;
    private Font labelFont;
    private transient Paint labelPaint;
    private RectangleInsets labelInsets;
    private double labelAngle;
    private boolean axisLineVisible;
    private transient Stroke axisLineStroke;
    private transient Paint axisLinePaint;
    private boolean tickLabelsVisible;
    private Font tickLabelFont;
    private transient Paint tickLabelPaint;
    private RectangleInsets tickLabelInsets;
    private boolean tickMarksVisible;
    private float tickMarkInsideLength;
    private float tickMarkOutsideLength;
    private transient Stroke tickMarkStroke;
    private transient Paint tickMarkPaint;
    private double fixedDimension;
    private transient Plot plot;
    private transient EventListenerList listenerList;
    static Class class$org$jfree$chart$event$AxisChangeListener;
    
    protected Axis(final String label) {
        this.label = label;
        this.visible = true;
        this.labelFont = Axis.DEFAULT_AXIS_LABEL_FONT;
        this.labelPaint = Axis.DEFAULT_AXIS_LABEL_PAINT;
        this.labelInsets = Axis.DEFAULT_AXIS_LABEL_INSETS;
        this.labelAngle = 0.0;
        this.axisLineVisible = true;
        this.axisLinePaint = Axis.DEFAULT_AXIS_LINE_PAINT;
        this.axisLineStroke = Axis.DEFAULT_AXIS_LINE_STROKE;
        this.tickLabelsVisible = true;
        this.tickLabelFont = Axis.DEFAULT_TICK_LABEL_FONT;
        this.tickLabelPaint = Axis.DEFAULT_TICK_LABEL_PAINT;
        this.tickLabelInsets = Axis.DEFAULT_TICK_LABEL_INSETS;
        this.tickMarksVisible = true;
        this.tickMarkStroke = Axis.DEFAULT_TICK_MARK_STROKE;
        this.tickMarkPaint = Axis.DEFAULT_TICK_MARK_PAINT;
        this.tickMarkInsideLength = 0.0f;
        this.tickMarkOutsideLength = 2.0f;
        this.plot = null;
        this.listenerList = new EventListenerList();
    }
    
    public boolean isVisible() {
        return this.visible;
    }
    
    public void setVisible(final boolean visible) {
        if (visible != this.visible) {
            this.visible = visible;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(final String s) {
        final String label = this.label;
        if (label != null) {
            if (!label.equals(s)) {
                this.label = s;
                this.notifyListeners(new AxisChangeEvent(this));
            }
        }
        else if (s != null) {
            this.label = s;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public Font getLabelFont() {
        return this.labelFont;
    }
    
    public void setLabelFont(final Font labelFont) {
        if (labelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (!this.labelFont.equals(labelFont)) {
            this.labelFont = labelFont;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public Paint getLabelPaint() {
        return this.labelPaint;
    }
    
    public void setLabelPaint(final Paint labelPaint) {
        if (labelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelPaint = labelPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public RectangleInsets getLabelInsets() {
        return this.labelInsets;
    }
    
    public void setLabelInsets(final RectangleInsets labelInsets) {
        if (labelInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (!labelInsets.equals(this.labelInsets)) {
            this.labelInsets = labelInsets;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public double getLabelAngle() {
        return this.labelAngle;
    }
    
    public void setLabelAngle(final double labelAngle) {
        this.labelAngle = labelAngle;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public boolean isAxisLineVisible() {
        return this.axisLineVisible;
    }
    
    public void setAxisLineVisible(final boolean axisLineVisible) {
        this.axisLineVisible = axisLineVisible;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Paint getAxisLinePaint() {
        return this.axisLinePaint;
    }
    
    public void setAxisLinePaint(final Paint axisLinePaint) {
        if (axisLinePaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.axisLinePaint = axisLinePaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Stroke getAxisLineStroke() {
        return this.axisLineStroke;
    }
    
    public void setAxisLineStroke(final Stroke axisLineStroke) {
        if (axisLineStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.axisLineStroke = axisLineStroke;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public boolean isTickLabelsVisible() {
        return this.tickLabelsVisible;
    }
    
    public void setTickLabelsVisible(final boolean tickLabelsVisible) {
        if (tickLabelsVisible != this.tickLabelsVisible) {
            this.tickLabelsVisible = tickLabelsVisible;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public Font getTickLabelFont() {
        return this.tickLabelFont;
    }
    
    public void setTickLabelFont(final Font tickLabelFont) {
        if (tickLabelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (!this.tickLabelFont.equals(tickLabelFont)) {
            this.tickLabelFont = tickLabelFont;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public Paint getTickLabelPaint() {
        return this.tickLabelPaint;
    }
    
    public void setTickLabelPaint(final Paint tickLabelPaint) {
        if (tickLabelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.tickLabelPaint = tickLabelPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public RectangleInsets getTickLabelInsets() {
        return this.tickLabelInsets;
    }
    
    public void setTickLabelInsets(final RectangleInsets tickLabelInsets) {
        if (tickLabelInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (!this.tickLabelInsets.equals(tickLabelInsets)) {
            this.tickLabelInsets = tickLabelInsets;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public boolean isTickMarksVisible() {
        return this.tickMarksVisible;
    }
    
    public void setTickMarksVisible(final boolean tickMarksVisible) {
        if (tickMarksVisible != this.tickMarksVisible) {
            this.tickMarksVisible = tickMarksVisible;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public float getTickMarkInsideLength() {
        return this.tickMarkInsideLength;
    }
    
    public void setTickMarkInsideLength(final float tickMarkInsideLength) {
        this.tickMarkInsideLength = tickMarkInsideLength;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public float getTickMarkOutsideLength() {
        return this.tickMarkOutsideLength;
    }
    
    public void setTickMarkOutsideLength(final float tickMarkOutsideLength) {
        this.tickMarkOutsideLength = tickMarkOutsideLength;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Stroke getTickMarkStroke() {
        return this.tickMarkStroke;
    }
    
    public void setTickMarkStroke(final Stroke tickMarkStroke) {
        if (tickMarkStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (!this.tickMarkStroke.equals(tickMarkStroke)) {
            this.tickMarkStroke = tickMarkStroke;
            this.notifyListeners(new AxisChangeEvent(this));
        }
    }
    
    public Paint getTickMarkPaint() {
        return this.tickMarkPaint;
    }
    
    public void setTickMarkPaint(final Paint tickMarkPaint) {
        if (tickMarkPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.tickMarkPaint = tickMarkPaint;
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    public Plot getPlot() {
        return this.plot;
    }
    
    public void setPlot(final Plot plot) {
        this.plot = plot;
        this.configure();
    }
    
    public double getFixedDimension() {
        return this.fixedDimension;
    }
    
    public void setFixedDimension(final double fixedDimension) {
        this.fixedDimension = fixedDimension;
    }
    
    public abstract void configure();
    
    public abstract AxisSpace reserveSpace(final Graphics2D p0, final Plot p1, final Rectangle2D p2, final RectangleEdge p3, final AxisSpace p4);
    
    public abstract AxisState draw(final Graphics2D p0, final double p1, final Rectangle2D p2, final Rectangle2D p3, final RectangleEdge p4, final PlotRenderingInfo p5);
    
    public abstract List refreshTicks(final Graphics2D p0, final AxisState p1, final Rectangle2D p2, final RectangleEdge p3);
    
    public void addChangeListener(final AxisChangeListener axisChangeListener) {
        this.listenerList.add((Axis.class$org$jfree$chart$event$AxisChangeListener == null) ? (Axis.class$org$jfree$chart$event$AxisChangeListener = class$("org.jfree.chart.event.AxisChangeListener")) : Axis.class$org$jfree$chart$event$AxisChangeListener, axisChangeListener);
    }
    
    public void removeChangeListener(final AxisChangeListener axisChangeListener) {
        this.listenerList.remove((Axis.class$org$jfree$chart$event$AxisChangeListener == null) ? (Axis.class$org$jfree$chart$event$AxisChangeListener = class$("org.jfree.chart.event.AxisChangeListener")) : Axis.class$org$jfree$chart$event$AxisChangeListener, axisChangeListener);
    }
    
    public boolean hasListener(final EventListener eventListener) {
        return Arrays.asList(this.listenerList.getListenerList()).contains(eventListener);
    }
    
    protected void notifyListeners(final AxisChangeEvent axisChangeEvent) {
        final Object[] listenerList = this.listenerList.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((Axis.class$org$jfree$chart$event$AxisChangeListener == null) ? (Axis.class$org$jfree$chart$event$AxisChangeListener = class$("org.jfree.chart.event.AxisChangeListener")) : Axis.class$org$jfree$chart$event$AxisChangeListener)) {
                ((AxisChangeListener)listenerList[i + 1]).axisChanged(axisChangeEvent);
            }
        }
    }
    
    protected Rectangle2D getLabelEnclosure(final Graphics2D graphics2D, final RectangleEdge rectangleEdge) {
        Rectangle2D bounds2D = new Rectangle2D.Double();
        final String label = this.getLabel();
        if (label != null && !label.equals("")) {
            final Rectangle2D outsetRectangle = this.getLabelInsets().createOutsetRectangle(TextUtilities.getTextBounds(label, graphics2D, graphics2D.getFontMetrics(this.getLabelFont())));
            double labelAngle = this.getLabelAngle();
            if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
                labelAngle -= 1.5707963267948966;
            }
            bounds2D = AffineTransform.getRotateInstance(labelAngle, outsetRectangle.getCenterX(), outsetRectangle.getCenterY()).createTransformedShape(outsetRectangle).getBounds2D();
        }
        return bounds2D;
    }
    
    protected AxisState drawLabel(final String s, final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final RectangleEdge rectangleEdge, final AxisState axisState) {
        if (axisState == null) {
            throw new IllegalArgumentException("Null 'state' argument.");
        }
        if (s == null || s.equals("")) {
            return axisState;
        }
        final Font labelFont = this.getLabelFont();
        final RectangleInsets labelInsets = this.getLabelInsets();
        graphics2D.setFont(labelFont);
        graphics2D.setPaint(this.getLabelPaint());
        final Rectangle2D textBounds = TextUtilities.getTextBounds(s, graphics2D, graphics2D.getFontMetrics());
        if (rectangleEdge == RectangleEdge.TOP) {
            final Rectangle2D bounds2D = AffineTransform.getRotateInstance(this.getLabelAngle(), textBounds.getCenterX(), textBounds.getCenterY()).createTransformedShape(textBounds).getBounds2D();
            TextUtilities.drawRotatedString(s, graphics2D, (float)rectangle2D2.getCenterX(), (float)(axisState.getCursor() - labelInsets.getBottom() - bounds2D.getHeight() / 2.0), TextAnchor.CENTER, this.getLabelAngle(), TextAnchor.CENTER);
            axisState.cursorUp(labelInsets.getTop() + bounds2D.getHeight() + labelInsets.getBottom());
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            final Rectangle2D bounds2D2 = AffineTransform.getRotateInstance(this.getLabelAngle(), textBounds.getCenterX(), textBounds.getCenterY()).createTransformedShape(textBounds).getBounds2D();
            TextUtilities.drawRotatedString(s, graphics2D, (float)rectangle2D2.getCenterX(), (float)(axisState.getCursor() + labelInsets.getTop() + bounds2D2.getHeight() / 2.0), TextAnchor.CENTER, this.getLabelAngle(), TextAnchor.CENTER);
            axisState.cursorDown(labelInsets.getTop() + bounds2D2.getHeight() + labelInsets.getBottom());
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            final Rectangle2D bounds2D3 = AffineTransform.getRotateInstance(this.getLabelAngle() - 1.5707963267948966, textBounds.getCenterX(), textBounds.getCenterY()).createTransformedShape(textBounds).getBounds2D();
            TextUtilities.drawRotatedString(s, graphics2D, (float)(axisState.getCursor() - labelInsets.getRight() - bounds2D3.getWidth() / 2.0), (float)rectangle2D2.getCenterY(), TextAnchor.CENTER, this.getLabelAngle() - 1.5707963267948966, TextAnchor.CENTER);
            axisState.cursorLeft(labelInsets.getLeft() + bounds2D3.getWidth() + labelInsets.getRight());
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            final Rectangle2D bounds2D4 = AffineTransform.getRotateInstance(this.getLabelAngle() + 1.5707963267948966, textBounds.getCenterX(), textBounds.getCenterY()).createTransformedShape(textBounds).getBounds2D();
            TextUtilities.drawRotatedString(s, graphics2D, (float)(axisState.getCursor() + labelInsets.getLeft() + bounds2D4.getWidth() / 2.0), (float)(rectangle2D2.getY() + rectangle2D2.getHeight() / 2.0), TextAnchor.CENTER, this.getLabelAngle() + 1.5707963267948966, TextAnchor.CENTER);
            axisState.cursorRight(labelInsets.getLeft() + bounds2D4.getWidth() + labelInsets.getRight());
        }
        return axisState;
    }
    
    protected void drawAxisLine(final Graphics2D graphics2D, final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        Shape shape = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            shape = new Line2D.Double(rectangle2D.getX(), n, rectangle2D.getMaxX(), n);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            shape = new Line2D.Double(rectangle2D.getX(), n, rectangle2D.getMaxX(), n);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            shape = new Line2D.Double(n, rectangle2D.getY(), n, rectangle2D.getMaxY());
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            shape = new Line2D.Double(n, rectangle2D.getY(), n, rectangle2D.getMaxY());
        }
        graphics2D.setPaint(this.axisLinePaint);
        graphics2D.setStroke(this.axisLineStroke);
        graphics2D.draw(shape);
    }
    
    public Object clone() {
        final Axis axis = (Axis)super.clone();
        axis.plot = null;
        axis.listenerList = new EventListenerList();
        return axis;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Axis)) {
            return false;
        }
        final Axis axis = (Axis)o;
        return this.visible == axis.visible && ObjectUtilities.equal(this.label, axis.label) && ObjectUtilities.equal(this.labelFont, axis.labelFont) && PaintUtilities.equal(this.labelPaint, axis.labelPaint) && ObjectUtilities.equal(this.labelInsets, axis.labelInsets) && this.labelAngle == axis.labelAngle && this.axisLineVisible == axis.axisLineVisible && ObjectUtilities.equal(this.axisLineStroke, axis.axisLineStroke) && PaintUtilities.equal(this.axisLinePaint, axis.axisLinePaint) && this.tickLabelsVisible == axis.tickLabelsVisible && ObjectUtilities.equal(this.tickLabelFont, axis.tickLabelFont) && PaintUtilities.equal(this.tickLabelPaint, axis.tickLabelPaint) && ObjectUtilities.equal(this.tickLabelInsets, axis.tickLabelInsets) && this.tickMarksVisible == axis.tickMarksVisible && this.tickMarkInsideLength == axis.tickMarkInsideLength && this.tickMarkOutsideLength == axis.tickMarkOutsideLength && PaintUtilities.equal(this.tickMarkPaint, axis.tickMarkPaint) && ObjectUtilities.equal(this.tickMarkStroke, axis.tickMarkStroke) && this.fixedDimension == axis.fixedDimension;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
        SerialUtilities.writePaint(this.tickLabelPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.axisLineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.axisLinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.tickMarkStroke, objectOutputStream);
        SerialUtilities.writePaint(this.tickMarkPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
        this.tickLabelPaint = SerialUtilities.readPaint(objectInputStream);
        this.axisLineStroke = SerialUtilities.readStroke(objectInputStream);
        this.axisLinePaint = SerialUtilities.readPaint(objectInputStream);
        this.tickMarkStroke = SerialUtilities.readStroke(objectInputStream);
        this.tickMarkPaint = SerialUtilities.readPaint(objectInputStream);
        this.listenerList = new EventListenerList();
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        DEFAULT_AXIS_LABEL_FONT = new Font("SansSerif", 0, 12);
        DEFAULT_AXIS_LABEL_PAINT = Color.black;
        DEFAULT_AXIS_LABEL_INSETS = new RectangleInsets(3.0, 3.0, 3.0, 3.0);
        DEFAULT_AXIS_LINE_PAINT = Color.gray;
        DEFAULT_AXIS_LINE_STROKE = new BasicStroke(1.0f);
        DEFAULT_TICK_LABEL_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_TICK_LABEL_PAINT = Color.black;
        DEFAULT_TICK_LABEL_INSETS = new RectangleInsets(2.0, 4.0, 2.0, 4.0);
        DEFAULT_TICK_MARK_STROKE = new BasicStroke(1.0f);
        DEFAULT_TICK_MARK_PAINT = Color.gray;
    }
}
