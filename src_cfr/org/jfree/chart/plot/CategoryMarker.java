/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.plot.Marker;
import org.jfree.ui.LengthAdjustmentType;

public class CategoryMarker
extends Marker
implements Serializable,
Cloneable {
    private Comparable key;
    private boolean drawAsLine = false;

    public CategoryMarker(Comparable comparable) {
        this(comparable, Color.gray, new BasicStroke(1.0f));
    }

    public CategoryMarker(Comparable comparable, Paint paint, Stroke stroke) {
        this(comparable, paint, stroke, paint, stroke, 1.0f);
    }

    public CategoryMarker(Comparable comparable, Paint paint, Stroke stroke, Paint paint2, Stroke stroke2, float f2) {
        super(paint, stroke, paint2, stroke2, f2);
        this.key = comparable;
        this.setLabelOffsetType(LengthAdjustmentType.EXPAND);
    }

    public Comparable getKey() {
        return this.key;
    }

    public void setKey(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.key = comparable;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    public boolean getDrawAsLine() {
        return this.drawAsLine;
    }

    public void setDrawAsLine(boolean bl2) {
        this.drawAsLine = bl2;
        this.notifyListeners(new MarkerChangeEvent(this));
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof CategoryMarker)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        CategoryMarker categoryMarker = (CategoryMarker)object;
        if (!this.key.equals(categoryMarker.key)) {
            return false;
        }
        if (this.drawAsLine == categoryMarker.drawAsLine) return true;
        return false;
    }
}

