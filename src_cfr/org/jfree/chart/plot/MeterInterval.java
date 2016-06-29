/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class MeterInterval
implements Serializable {
    private static final long serialVersionUID = 1530982090622488257L;
    private String label;
    private Range range;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private transient Paint backgroundPaint;

    public MeterInterval(String string, Range range) {
        this(string, range, Color.yellow, new BasicStroke(2.0f), null);
    }

    public MeterInterval(String string, Range range, Paint paint, Stroke stroke, Paint paint2) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'label' argument.");
        }
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        this.label = string;
        this.range = range;
        this.outlinePaint = paint;
        this.outlineStroke = stroke;
        this.backgroundPaint = paint2;
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

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MeterInterval)) {
            return false;
        }
        MeterInterval meterInterval = (MeterInterval)object;
        if (!this.label.equals(meterInterval.label)) {
            return false;
        }
        if (!this.range.equals(meterInterval.range)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, meterInterval.outlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, meterInterval.outlineStroke)) {
            return false;
        }
        if (PaintUtilities.equal(this.backgroundPaint, meterInterval.backgroundPaint)) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.backgroundPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.backgroundPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

