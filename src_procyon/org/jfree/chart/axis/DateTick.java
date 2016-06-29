package org.jfree.chart.axis;

import java.util.*;
import org.jfree.ui.*;
import org.jfree.util.*;

public class DateTick extends ValueTick
{
    private Date date;
    
    public DateTick(final Date date, final String s, final TextAnchor textAnchor, final TextAnchor textAnchor2, final double n) {
        super(date.getTime(), s, textAnchor, textAnchor2, n);
        this.date = date;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof DateTick && super.equals(o) && ObjectUtilities.equal(this.date, ((DateTick)o).date));
    }
    
    public int hashCode() {
        return this.date.hashCode();
    }
}
