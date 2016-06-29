package org.jfree.chart.axis;

import org.jfree.ui.*;

public abstract class ValueTick extends Tick
{
    private double value;
    
    public ValueTick(final double value, final String s, final TextAnchor textAnchor, final TextAnchor textAnchor2, final double n) {
        super(s, textAnchor, textAnchor2, n);
        this.value = value;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof ValueTick && super.equals(o) && this.value == ((ValueTick)o).value);
    }
}
