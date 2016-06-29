package org.jfree.data.time;

import org.jfree.data.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class DateRange extends Range implements Serializable
{
    private static final long serialVersionUID = -4705682568375418157L;
    private Date lowerDate;
    private Date upperDate;
    
    public DateRange() {
        this(new Date(0L), new Date(1L));
    }
    
    public DateRange(final Date lowerDate, final Date upperDate) {
        super(lowerDate.getTime(), upperDate.getTime());
        this.lowerDate = lowerDate;
        this.upperDate = upperDate;
    }
    
    public DateRange(final double n, final double n2) {
        super(n, n2);
        this.lowerDate = new Date((long)n);
        this.upperDate = new Date((long)n2);
    }
    
    public DateRange(final Range range) {
        this(range.getLowerBound(), range.getUpperBound());
    }
    
    public Date getLowerDate() {
        return this.lowerDate;
    }
    
    public Date getUpperDate() {
        return this.upperDate;
    }
    
    public String toString() {
        final DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
        return "[" + dateTimeInstance.format(this.lowerDate) + " --> " + dateTimeInstance.format(this.upperDate) + "]";
    }
}
