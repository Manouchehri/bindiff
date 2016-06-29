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
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.AxisChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public abstract class Axis
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 7719289504573298271L;
    public static final boolean DEFAULT_AXIS_VISIBLE = true;
    public static final Font DEFAULT_AXIS_LABEL_FONT = new Font("SansSerif", 0, 12);
    public static final Paint DEFAULT_AXIS_LABEL_PAINT = Color.black;
    public static final RectangleInsets DEFAULT_AXIS_LABEL_INSETS = new RectangleInsets(3.0, 3.0, 3.0, 3.0);
    public static final Paint DEFAULT_AXIS_LINE_PAINT = Color.gray;
    public static final Stroke DEFAULT_AXIS_LINE_STROKE = new BasicStroke(1.0f);
    public static final boolean DEFAULT_TICK_LABELS_VISIBLE = true;
    public static final Font DEFAULT_TICK_LABEL_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_TICK_LABEL_PAINT = Color.black;
    public static final RectangleInsets DEFAULT_TICK_LABEL_INSETS = new RectangleInsets(2.0, 4.0, 2.0, 4.0);
    public static final boolean DEFAULT_TICK_MARKS_VISIBLE = true;
    public static final Stroke DEFAULT_TICK_MARK_STROKE = new BasicStroke(1.0f);
    public static final Paint DEFAULT_TICK_MARK_PAINT = Color.gray;
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

    protected Axis(String string) {
        this.label = string;
        this.visible = true;
        this.labelFont = DEFAULT_AXIS_LABEL_FONT;
        this.labelPaint = DEFAULT_AXIS_LABEL_PAINT;
        this.labelInsets = DEFAULT_AXIS_LABEL_INSETS;
        this.labelAngle = 0.0;
        this.axisLineVisible = true;
        this.axisLinePaint = DEFAULT_AXIS_LINE_PAINT;
        this.axisLineStroke = DEFAULT_AXIS_LINE_STROKE;
        this.tickLabelsVisible = true;
        this.tickLabelFont = DEFAULT_TICK_LABEL_FONT;
        this.tickLabelPaint = DEFAULT_TICK_LABEL_PAINT;
        this.tickLabelInsets = DEFAULT_TICK_LABEL_INSETS;
        this.tickMarksVisible = true;
        this.tickMarkStroke = DEFAULT_TICK_MARK_STROKE;
        this.tickMarkPaint = DEFAULT_TICK_MARK_PAINT;
        this.tickMarkInsideLength = 0.0f;
        this.tickMarkOutsideLength = 2.0f;
        this.plot = null;
        this.listenerList = new EventListenerList();
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl2) {
        if (bl2 == this.visible) return;
        this.visible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String string) {
        String string2 = this.label;
        if (string2 != null) {
            if (string2.equals(string)) return;
            this.label = string;
            this.notifyListeners(new AxisChangeEvent(this));
            return;
        }
        if (string == null) return;
        this.label = string;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Font getLabelFont() {
        return this.labelFont;
    }

    public void setLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (this.labelFont.equals(font)) return;
        this.labelFont = font;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getLabelPaint() {
        return this.labelPaint;
    }

    public void setLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public RectangleInsets getLabelInsets() {
        return this.labelInsets;
    }

    public void setLabelInsets(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (rectangleInsets.equals(this.labelInsets)) return;
        this.labelInsets = rectangleInsets;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public double getLabelAngle() {
        return this.labelAngle;
    }

    public void setLabelAngle(double d2) {
        this.labelAngle = d2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isAxisLineVisible() {
        return this.axisLineVisible;
    }

    public void setAxisLineVisible(boolean bl2) {
        this.axisLineVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getAxisLinePaint() {
        return this.axisLinePaint;
    }

    public void setAxisLinePaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.axisLinePaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Stroke getAxisLineStroke() {
        return this.axisLineStroke;
    }

    public void setAxisLineStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.axisLineStroke = stroke;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isTickLabelsVisible() {
        return this.tickLabelsVisible;
    }

    public void setTickLabelsVisible(boolean bl2) {
        if (bl2 == this.tickLabelsVisible) return;
        this.tickLabelsVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Font getTickLabelFont() {
        return this.tickLabelFont;
    }

    public void setTickLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        if (this.tickLabelFont.equals(font)) return;
        this.tickLabelFont = font;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getTickLabelPaint() {
        return this.tickLabelPaint;
    }

    public void setTickLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.tickLabelPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public RectangleInsets getTickLabelInsets() {
        return this.tickLabelInsets;
    }

    public void setTickLabelInsets(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'insets' argument.");
        }
        if (this.tickLabelInsets.equals(rectangleInsets)) return;
        this.tickLabelInsets = rectangleInsets;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public boolean isTickMarksVisible() {
        return this.tickMarksVisible;
    }

    public void setTickMarksVisible(boolean bl2) {
        if (bl2 == this.tickMarksVisible) return;
        this.tickMarksVisible = bl2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public float getTickMarkInsideLength() {
        return this.tickMarkInsideLength;
    }

    public void setTickMarkInsideLength(float f2) {
        this.tickMarkInsideLength = f2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public float getTickMarkOutsideLength() {
        return this.tickMarkOutsideLength;
    }

    public void setTickMarkOutsideLength(float f2) {
        this.tickMarkOutsideLength = f2;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Stroke getTickMarkStroke() {
        return this.tickMarkStroke;
    }

    public void setTickMarkStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (this.tickMarkStroke.equals(stroke)) return;
        this.tickMarkStroke = stroke;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Paint getTickMarkPaint() {
        return this.tickMarkPaint;
    }

    public void setTickMarkPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.tickMarkPaint = paint;
        this.notifyListeners(new AxisChangeEvent(this));
    }

    public Plot getPlot() {
        return this.plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
        this.configure();
    }

    public double getFixedDimension() {
        return this.fixedDimension;
    }

    public void setFixedDimension(double d2) {
        this.fixedDimension = d2;
    }

    public abstract void configure();

    public abstract AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5);

    public abstract AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7);

    public abstract List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4);

    public void addChangeListener(AxisChangeListener axisChangeListener) {
        Class class_ = class$org$jfree$chart$event$AxisChangeListener == null ? (Axis.class$org$jfree$chart$event$AxisChangeListener = Axis.class$("org.jfree.chart.event.AxisChangeListener")) : class$org$jfree$chart$event$AxisChangeListener;
        this.listenerList.add(class_, axisChangeListener);
    }

    public void removeChangeListener(AxisChangeListener axisChangeListener) {
        Class class_ = class$org$jfree$chart$event$AxisChangeListener == null ? (Axis.class$org$jfree$chart$event$AxisChangeListener = Axis.class$("org.jfree.chart.event.AxisChangeListener")) : class$org$jfree$chart$event$AxisChangeListener;
        this.listenerList.remove(class_, axisChangeListener);
    }

    public boolean hasListener(EventListener eventListener) {
        List<Object> list = Arrays.asList(this.listenerList.getListenerList());
        return list.contains(eventListener);
    }

    protected void notifyListeners(AxisChangeEvent axisChangeEvent) {
        Object[] arrobject = this.listenerList.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$AxisChangeListener == null ? Axis.class$("org.jfree.chart.event.AxisChangeListener") : class$org$jfree$chart$event$AxisChangeListener)) {
                ((AxisChangeListener)arrobject[n2 + 1]).axisChanged(axisChangeEvent);
            }
            n2 -= 2;
        }
    }

    protected Rectangle2D getLabelEnclosure(Graphics2D graphics2D, RectangleEdge rectangleEdge) {
        Rectangle2D rectangle2D = new Rectangle2D.Double();
        String string = this.getLabel();
        if (string == null) return rectangle2D;
        if (string.equals("")) return rectangle2D;
        FontMetrics fontMetrics = graphics2D.getFontMetrics(this.getLabelFont());
        Rectangle2D rectangle2D2 = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        RectangleInsets rectangleInsets = this.getLabelInsets();
        rectangle2D2 = rectangleInsets.createOutsetRectangle(rectangle2D2);
        double d2 = this.getLabelAngle();
        if (rectangleEdge == RectangleEdge.LEFT || rectangleEdge == RectangleEdge.RIGHT) {
            d2 -= 1.5707963267948966;
        }
        double d3 = rectangle2D2.getCenterX();
        double d4 = rectangle2D2.getCenterY();
        AffineTransform affineTransform = AffineTransform.getRotateInstance(d2, d3, d4);
        Shape shape = affineTransform.createTransformedShape(rectangle2D2);
        return shape.getBounds2D();
    }

    protected AxisState drawLabel(String string, Graphics2D graphics2D, Rectangle2D rectangle2D, Rectangle2D rectangle2D2, RectangleEdge rectangleEdge, AxisState axisState) {
        if (axisState == null) {
            throw new IllegalArgumentException("Null 'state' argument.");
        }
        if (string == null) return axisState;
        if (string.equals("")) {
            return axisState;
        }
        Font font = this.getLabelFont();
        RectangleInsets rectangleInsets = this.getLabelInsets();
        graphics2D.setFont(font);
        graphics2D.setPaint(this.getLabelPaint());
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Rectangle2D rectangle2D3 = TextUtilities.getTextBounds(string, graphics2D, fontMetrics);
        if (rectangleEdge == RectangleEdge.TOP) {
            AffineTransform affineTransform = AffineTransform.getRotateInstance(this.getLabelAngle(), rectangle2D3.getCenterX(), rectangle2D3.getCenterY());
            Shape shape = affineTransform.createTransformedShape(rectangle2D3);
            rectangle2D3 = shape.getBounds2D();
            double d2 = rectangle2D2.getCenterX();
            double d3 = axisState.getCursor() - rectangleInsets.getBottom() - rectangle2D3.getHeight() / 2.0;
            TextUtilities.drawRotatedString(string, graphics2D, (float)d2, (float)d3, TextAnchor.CENTER, this.getLabelAngle(), TextAnchor.CENTER);
            axisState.cursorUp(rectangleInsets.getTop() + rectangle2D3.getHeight() + rectangleInsets.getBottom());
            return axisState;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            AffineTransform affineTransform = AffineTransform.getRotateInstance(this.getLabelAngle(), rectangle2D3.getCenterX(), rectangle2D3.getCenterY());
            Shape shape = affineTransform.createTransformedShape(rectangle2D3);
            rectangle2D3 = shape.getBounds2D();
            double d4 = rectangle2D2.getCenterX();
            double d5 = axisState.getCursor() + rectangleInsets.getTop() + rectangle2D3.getHeight() / 2.0;
            TextUtilities.drawRotatedString(string, graphics2D, (float)d4, (float)d5, TextAnchor.CENTER, this.getLabelAngle(), TextAnchor.CENTER);
            axisState.cursorDown(rectangleInsets.getTop() + rectangle2D3.getHeight() + rectangleInsets.getBottom());
            return axisState;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            AffineTransform affineTransform = AffineTransform.getRotateInstance(this.getLabelAngle() - 1.5707963267948966, rectangle2D3.getCenterX(), rectangle2D3.getCenterY());
            Shape shape = affineTransform.createTransformedShape(rectangle2D3);
            rectangle2D3 = shape.getBounds2D();
            double d6 = axisState.getCursor() - rectangleInsets.getRight() - rectangle2D3.getWidth() / 2.0;
            double d7 = rectangle2D2.getCenterY();
            TextUtilities.drawRotatedString(string, graphics2D, (float)d6, (float)d7, TextAnchor.CENTER, this.getLabelAngle() - 1.5707963267948966, TextAnchor.CENTER);
            axisState.cursorLeft(rectangleInsets.getLeft() + rectangle2D3.getWidth() + rectangleInsets.getRight());
            return axisState;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return axisState;
        AffineTransform affineTransform = AffineTransform.getRotateInstance(this.getLabelAngle() + 1.5707963267948966, rectangle2D3.getCenterX(), rectangle2D3.getCenterY());
        Shape shape = affineTransform.createTransformedShape(rectangle2D3);
        rectangle2D3 = shape.getBounds2D();
        double d8 = axisState.getCursor() + rectangleInsets.getLeft() + rectangle2D3.getWidth() / 2.0;
        double d9 = rectangle2D2.getY() + rectangle2D2.getHeight() / 2.0;
        TextUtilities.drawRotatedString(string, graphics2D, (float)d8, (float)d9, TextAnchor.CENTER, this.getLabelAngle() + 1.5707963267948966, TextAnchor.CENTER);
        axisState.cursorRight(rectangleInsets.getLeft() + rectangle2D3.getWidth() + rectangleInsets.getRight());
        return axisState;
    }

    protected void drawAxisLine(Graphics2D graphics2D, double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Line2D.Double double_ = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            double_ = new Line2D.Double(rectangle2D.getX(), d2, rectangle2D.getMaxX(), d2);
        } else if (rectangleEdge == RectangleEdge.BOTTOM) {
            double_ = new Line2D.Double(rectangle2D.getX(), d2, rectangle2D.getMaxX(), d2);
        } else if (rectangleEdge == RectangleEdge.LEFT) {
            double_ = new Line2D.Double(d2, rectangle2D.getY(), d2, rectangle2D.getMaxY());
        } else if (rectangleEdge == RectangleEdge.RIGHT) {
            double_ = new Line2D.Double(d2, rectangle2D.getY(), d2, rectangle2D.getMaxY());
        }
        graphics2D.setPaint(this.axisLinePaint);
        graphics2D.setStroke(this.axisLineStroke);
        graphics2D.draw(double_);
    }

    public Object clone() {
        Axis axis = (Axis)super.clone();
        axis.plot = null;
        axis.listenerList = new EventListenerList();
        return axis;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Axis)) {
            return false;
        }
        Axis axis = (Axis)object;
        if (this.visible != axis.visible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.label, axis.label)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelFont, axis.labelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelPaint, axis.labelPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelInsets, axis.labelInsets)) {
            return false;
        }
        if (this.labelAngle != axis.labelAngle) {
            return false;
        }
        if (this.axisLineVisible != axis.axisLineVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.axisLineStroke, axis.axisLineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.axisLinePaint, axis.axisLinePaint)) {
            return false;
        }
        if (this.tickLabelsVisible != axis.tickLabelsVisible) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickLabelFont, axis.tickLabelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.tickLabelPaint, axis.tickLabelPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickLabelInsets, axis.tickLabelInsets)) {
            return false;
        }
        if (this.tickMarksVisible != axis.tickMarksVisible) {
            return false;
        }
        if (this.tickMarkInsideLength != axis.tickMarkInsideLength) {
            return false;
        }
        if (this.tickMarkOutsideLength != axis.tickMarkOutsideLength) {
            return false;
        }
        if (!PaintUtilities.equal(this.tickMarkPaint, axis.tickMarkPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.tickMarkStroke, axis.tickMarkStroke)) {
            return false;
        }
        if (this.fixedDimension == axis.fixedDimension) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
        SerialUtilities.writePaint(this.tickLabelPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.axisLineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.axisLinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.tickMarkStroke, objectOutputStream);
        SerialUtilities.writePaint(this.tickMarkPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
        this.tickLabelPaint = SerialUtilities.readPaint(objectInputStream);
        this.axisLineStroke = SerialUtilities.readStroke(objectInputStream);
        this.axisLinePaint = SerialUtilities.readPaint(objectInputStream);
        this.tickMarkStroke = SerialUtilities.readStroke(objectInputStream);
        this.tickMarkPaint = SerialUtilities.readPaint(objectInputStream);
        this.listenerList = new EventListenerList();
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

