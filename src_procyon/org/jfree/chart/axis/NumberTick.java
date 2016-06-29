package org.jfree.chart.axis;

import org.jfree.ui.*;

public class NumberTick extends ValueTick
{
    private Number number;
    
    public NumberTick(final Number number, final String s, final TextAnchor textAnchor, final TextAnchor textAnchor2, final double n) {
        super(number.doubleValue(), s, textAnchor, textAnchor2, n);
        this.number = number;
    }
    
    public Number getNumber() {
        return this.number;
    }
}
