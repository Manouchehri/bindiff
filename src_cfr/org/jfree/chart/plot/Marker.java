/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public abstract class Marker
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -734389651405327166L;
    private transient Paint paint;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private float alpha;
    private String label = null;
    private Font labelFont;
    private transient Paint labelPaint;
    private RectangleAnchor labelAnchor;
    private TextAnchor labelTextAnchor;
    private RectangleInsets labelOffset;
    private LengthAdjustmentType labelOffsetType;
    private transient EventListenerList listenerList;
    static Class class$org$jfree$chart$event$MarkerChangeListener;

    protected Marker() {
        this(Color.gray);
    }

    protected Marker(Paint paint) {
        this(paint, new BasicStroke(0.5f), Color.gray, new BasicStroke(0.5f), 0.8f);
    }

    protected Marker(Paint paint, Stroke stroke, Paint paint2, Stroke stroke2, float f2) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (f2 < 0.0f) throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
        if (f2 > 1.0f) {
            throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
        }
        this.paint = paint;
        this.stroke = stroke;
        this.outlinePaint = paint2;
        this.outlineStroke = stroke2;
        this.alpha = f2;
        this.labelFont = new Font("SansSerif", 0, 9);
        this.labelPaint = Color.black;
        this.labelAnchor = RectangleAnchor.TOP_LEFT;
        this.labelOffset = new RectangleInsets(3.0, 3.0, 3.0, 3.0);
        this.labelOffsetType = LengthAdjustmentType.CONTRACT;
        this.labelTextAnchor = TextAnchor.CENTER;
        this.listenerList = new EventListenerList();
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    public void setStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.stroke = stroke;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }

    public void setOutlinePaint(Paint paint) {
        this.outlinePaint = paint;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }

    public void setOutlineStroke(Stroke stroke) {
        this.outlineStroke = stroke;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float f2) {
        if (f2 < 0.0f) throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
        if (f2 > 1.0f) {
            throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
        }
        this.alpha = f2;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String string) {
        this.label = string;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public Font getLabelFont() {
        return this.labelFont;
    }

    public void setLabelFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.labelFont = font;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public Paint getLabelPaint() {
        return this.labelPaint;
    }

    public void setLabelPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelPaint = paint;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public RectangleAnchor getLabelAnchor() {
        return this.labelAnchor;
    }

    public void setLabelAnchor(RectangleAnchor rectangleAnchor) {
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.labelAnchor = rectangleAnchor;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public RectangleInsets getLabelOffset() {
        return this.labelOffset;
    }

    public void setLabelOffset(RectangleInsets rectangleInsets) {
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'offset' argument.");
        }
        this.labelOffset = rectangleInsets;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public LengthAdjustmentType getLabelOffsetType() {
        return this.labelOffsetType;
    }

    public void setLabelOffsetType(LengthAdjustmentType lengthAdjustmentType) {
        if (lengthAdjustmentType == null) {
            throw new IllegalArgumentException("Null 'adj' argument.");
        }
        this.labelOffsetType = lengthAdjustmentType;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public TextAnchor getLabelTextAnchor() {
        return this.labelTextAnchor;
    }

    public void setLabelTextAnchor(TextAnchor textAnchor) {
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.labelTextAnchor = textAnchor;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public void addChangeListener(MarkerChangeListener markerChangeListener) {
        Class class_ = class$org$jfree$chart$event$MarkerChangeListener == null ? (Marker.class$org$jfree$chart$event$MarkerChangeListener = Marker.class$("org.jfree.chart.event.MarkerChangeListener")) : class$org$jfree$chart$event$MarkerChangeListener;
        this.listenerList.add(class_, markerChangeListener);
    }

    public void removeChangeListener(MarkerChangeListener markerChangeListener) {
        Class class_ = class$org$jfree$chart$event$MarkerChangeListener == null ? (Marker.class$org$jfree$chart$event$MarkerChangeListener = Marker.class$("org.jfree.chart.event.MarkerChangeListener")) : class$org$jfree$chart$event$MarkerChangeListener;
        this.listenerList.remove(class_, markerChangeListener);
    }

    public void notifyListeners(MarkerChangeEvent markerChangeEvent) {
        Object[] arrobject = this.listenerList.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$MarkerChangeListener == null ? Marker.class$("org.jfree.chart.event.MarkerChangeListener") : class$org$jfree$chart$event$MarkerChangeListener)) {
                ((MarkerChangeListener)arrobject[n2 + 1]).markerChanged(markerChangeEvent);
            }
            n2 -= 2;
        }
    }

    public EventListener[] getListeners(Class class_) {
        return this.listenerList.getListeners(class_);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Marker)) {
            return false;
        }
        Marker marker = (Marker)object;
        if (!PaintUtilities.equal(this.paint, marker.paint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.stroke, marker.stroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, marker.outlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, marker.outlineStroke)) {
            return false;
        }
        if (this.alpha != marker.alpha) {
            return false;
        }
        if (!ObjectUtilities.equal(this.label, marker.label)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelFont, marker.labelFont)) {
            return false;
        }
        if (!PaintUtilities.equal(this.labelPaint, marker.labelPaint)) {
            return false;
        }
        if (this.labelAnchor != marker.labelAnchor) {
            return false;
        }
        if (this.labelTextAnchor != marker.labelTextAnchor) {
            return false;
        }
        if (!ObjectUtilities.equal(this.labelOffset, marker.labelOffset)) {
            return false;
        }
        if (this.labelOffsetType.equals(marker.labelOffsetType)) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
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

