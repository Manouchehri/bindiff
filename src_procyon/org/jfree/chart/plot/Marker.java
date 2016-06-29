package org.jfree.chart.plot;

import org.jfree.ui.*;
import javax.swing.event.*;
import java.awt.*;
import org.jfree.chart.event.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public abstract class Marker implements Serializable, Cloneable
{
    private static final long serialVersionUID = -734389651405327166L;
    private transient Paint paint;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private float alpha;
    private String label;
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
    
    protected Marker(final Paint paint) {
        this(paint, new BasicStroke(0.5f), Color.gray, new BasicStroke(0.5f), 0.8f);
    }
    
    protected Marker(final Paint paint, final Stroke stroke, final Paint outlinePaint, final Stroke outlineStroke, final float alpha) {
        this.label = null;
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (alpha < 0.0f || alpha > 1.0f) {
            throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
        }
        this.paint = paint;
        this.stroke = stroke;
        this.outlinePaint = outlinePaint;
        this.outlineStroke = outlineStroke;
        this.alpha = alpha;
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
    
    public void setPaint(final Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public Stroke getStroke() {
        return this.stroke;
    }
    
    public void setStroke(final Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.stroke = stroke;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public void setOutlinePaint(final Paint outlinePaint) {
        this.outlinePaint = outlinePaint;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public void setOutlineStroke(final Stroke outlineStroke) {
        this.outlineStroke = outlineStroke;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public float getAlpha() {
        return this.alpha;
    }
    
    public void setAlpha(final float alpha) {
        if (alpha < 0.0f || alpha > 1.0f) {
            throw new IllegalArgumentException("The 'alpha' value must be in the range 0.0f to 1.0f");
        }
        this.alpha = alpha;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(final String label) {
        this.label = label;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public Font getLabelFont() {
        return this.labelFont;
    }
    
    public void setLabelFont(final Font labelFont) {
        if (labelFont == null) {
            throw new IllegalArgumentException("Null 'font' argument.");
        }
        this.labelFont = labelFont;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public Paint getLabelPaint() {
        return this.labelPaint;
    }
    
    public void setLabelPaint(final Paint labelPaint) {
        if (labelPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.labelPaint = labelPaint;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public RectangleAnchor getLabelAnchor() {
        return this.labelAnchor;
    }
    
    public void setLabelAnchor(final RectangleAnchor labelAnchor) {
        if (labelAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.labelAnchor = labelAnchor;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public RectangleInsets getLabelOffset() {
        return this.labelOffset;
    }
    
    public void setLabelOffset(final RectangleInsets labelOffset) {
        if (labelOffset == null) {
            throw new IllegalArgumentException("Null 'offset' argument.");
        }
        this.labelOffset = labelOffset;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public LengthAdjustmentType getLabelOffsetType() {
        return this.labelOffsetType;
    }
    
    public void setLabelOffsetType(final LengthAdjustmentType labelOffsetType) {
        if (labelOffsetType == null) {
            throw new IllegalArgumentException("Null 'adj' argument.");
        }
        this.labelOffsetType = labelOffsetType;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public TextAnchor getLabelTextAnchor() {
        return this.labelTextAnchor;
    }
    
    public void setLabelTextAnchor(final TextAnchor labelTextAnchor) {
        if (labelTextAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.labelTextAnchor = labelTextAnchor;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public void addChangeListener(final MarkerChangeListener markerChangeListener) {
        this.listenerList.add((Marker.class$org$jfree$chart$event$MarkerChangeListener == null) ? (Marker.class$org$jfree$chart$event$MarkerChangeListener = class$("org.jfree.chart.event.MarkerChangeListener")) : Marker.class$org$jfree$chart$event$MarkerChangeListener, markerChangeListener);
    }
    
    public void removeChangeListener(final MarkerChangeListener markerChangeListener) {
        this.listenerList.remove((Marker.class$org$jfree$chart$event$MarkerChangeListener == null) ? (Marker.class$org$jfree$chart$event$MarkerChangeListener = class$("org.jfree.chart.event.MarkerChangeListener")) : Marker.class$org$jfree$chart$event$MarkerChangeListener, markerChangeListener);
    }
    
    public void notifyListeners(final MarkerChangeEvent markerChangeEvent) {
        final Object[] listenerList = this.listenerList.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((Marker.class$org$jfree$chart$event$MarkerChangeListener == null) ? (Marker.class$org$jfree$chart$event$MarkerChangeListener = class$("org.jfree.chart.event.MarkerChangeListener")) : Marker.class$org$jfree$chart$event$MarkerChangeListener)) {
                ((MarkerChangeListener)listenerList[i + 1]).markerChanged(markerChangeEvent);
            }
        }
    }
    
    public EventListener[] getListeners(final Class clazz) {
        return this.listenerList.getListeners((Class<EventListener>)clazz);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Marker)) {
            return false;
        }
        final Marker marker = (Marker)o;
        return PaintUtilities.equal(this.paint, marker.paint) && ObjectUtilities.equal(this.stroke, marker.stroke) && PaintUtilities.equal(this.outlinePaint, marker.outlinePaint) && ObjectUtilities.equal(this.outlineStroke, marker.outlineStroke) && this.alpha == marker.alpha && ObjectUtilities.equal(this.label, marker.label) && ObjectUtilities.equal(this.labelFont, marker.labelFont) && PaintUtilities.equal(this.labelPaint, marker.labelPaint) && this.labelAnchor == marker.labelAnchor && this.labelTextAnchor == marker.labelTextAnchor && ObjectUtilities.equal(this.labelOffset, marker.labelOffset) && this.labelOffsetType.equals(marker.labelOffsetType);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
