package org.jfree.chart.axis;

import java.io.*;
import java.text.*;

public class NumberTickUnit extends TickUnit implements Serializable
{
    private static final long serialVersionUID = 3849459506627654442L;
    private NumberFormat formatter;
    
    public NumberTickUnit(final double n) {
        this(n, NumberFormat.getNumberInstance());
    }
    
    public NumberTickUnit(final double n, final NumberFormat formatter) {
        super(n);
        if (formatter == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        this.formatter = formatter;
    }
    
    public String valueToString(final double n) {
        return this.formatter.format(n);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof NumberTickUnit && super.equals(o) && this.formatter.equals(((NumberTickUnit)o).formatter));
    }
    
    public int hashCode() {
        return 29 * super.hashCode() + ((this.formatter != null) ? this.formatter.hashCode() : 0);
    }
}
