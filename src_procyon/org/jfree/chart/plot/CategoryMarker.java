package org.jfree.chart.plot;

import java.io.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.chart.event.*;

public class CategoryMarker extends Marker implements Serializable, Cloneable
{
    private Comparable key;
    private boolean drawAsLine;
    
    public CategoryMarker(final Comparable comparable) {
        this(comparable, Color.gray, new BasicStroke(1.0f));
    }
    
    public CategoryMarker(final Comparable comparable, final Paint paint, final Stroke stroke) {
        this(comparable, paint, stroke, paint, stroke, 1.0f);
    }
    
    public CategoryMarker(final Comparable key, final Paint paint, final Stroke stroke, final Paint paint2, final Stroke stroke2, final float n) {
        super(paint, stroke, paint2, stroke2, n);
        this.drawAsLine = false;
        this.key = key;
        this.setLabelOffsetType(LengthAdjustmentType.EXPAND);
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public void setKey(final Comparable key) {
        if (key == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.key = key;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public boolean getDrawAsLine() {
        return this.drawAsLine;
    }
    
    public void setDrawAsLine(final boolean drawAsLine) {
        this.drawAsLine = drawAsLine;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof CategoryMarker)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CategoryMarker categoryMarker = (CategoryMarker)o;
        return this.key.equals(categoryMarker.key) && this.drawAsLine == categoryMarker.drawAsLine;
    }
}
