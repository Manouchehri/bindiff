package org.jfree.chart.plot;

import java.awt.*;
import org.jfree.chart.event.*;

public class ValueMarker extends Marker
{
    private double value;
    
    public ValueMarker(final double value) {
        this.value = value;
    }
    
    public ValueMarker(final double n, final Paint paint, final Stroke stroke) {
        this(n, paint, stroke, paint, stroke, 1.0f);
    }
    
    public ValueMarker(final double value, final Paint paint, final Stroke stroke, final Paint paint2, final Stroke stroke2, final float n) {
        super(paint, stroke, paint, stroke, n);
        this.value = value;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void setValue(final double value) {
        this.value = value;
        this.notifyListeners(new MarkerChangeEvent(this));
    }
    
    public boolean equals(final Object o) {
        return o == this || (super.equals(o) && o instanceof ValueMarker && this.value == ((ValueMarker)o).value);
    }
}
