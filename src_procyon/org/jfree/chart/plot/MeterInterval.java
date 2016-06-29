package org.jfree.chart.plot;

import org.jfree.data.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class MeterInterval implements Serializable
{
    private static final long serialVersionUID = 1530982090622488257L;
    private String label;
    private Range range;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private transient Paint backgroundPaint;
    
    public MeterInterval(final String s, final Range range) {
        this(s, range, Color.yellow, new BasicStroke(2.0f), null);
    }
    
    public MeterInterval(final String label, final Range range, final Paint outlinePaint, final Stroke outlineStroke, final Paint backgroundPaint) {
        if (label == null) {
            throw new IllegalArgumentException("Null 'label' argument.");
        }
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        this.label = label;
        this.range = range;
        this.outlinePaint = outlinePaint;
        this.outlineStroke = outlineStroke;
        this.backgroundPaint = backgroundPaint;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public Range getRange() {
        return this.range;
    }
    
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MeterInterval)) {
            return false;
        }
        final MeterInterval meterInterval = (MeterInterval)o;
        return this.label.equals(meterInterval.label) && this.range.equals(meterInterval.range) && PaintUtilities.equal(this.outlinePaint, meterInterval.outlinePaint) && ObjectUtilities.equal(this.outlineStroke, meterInterval.outlineStroke) && PaintUtilities.equal(this.backgroundPaint, meterInterval.backgroundPaint);
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
