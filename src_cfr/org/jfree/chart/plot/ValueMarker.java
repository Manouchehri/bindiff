/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Stroke;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.plot.Marker;

public class ValueMarker
extends Marker {
    private double value;

    public ValueMarker(double d2) {
        this.value = d2;
    }

    public ValueMarker(double d2, Paint paint, Stroke stroke) {
        this(d2, paint, stroke, paint, stroke, 1.0f);
    }

    public ValueMarker(double d2, Paint paint, Stroke stroke, Paint paint2, Stroke stroke2, float f2) {
        super(paint, stroke, paint, stroke, f2);
        this.value = d2;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double d2) {
        this.value = d2;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof ValueMarker)) {
            return false;
        }
        ValueMarker valueMarker = (ValueMarker)object;
        if (this.value == valueMarker.value) return true;
        return false;
    }
}

