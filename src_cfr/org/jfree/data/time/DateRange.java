/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import org.jfree.data.Range;

public class DateRange
extends Range
implements Serializable {
    private static final long serialVersionUID = -4705682568375418157L;
    private Date lowerDate;
    private Date upperDate;

    public DateRange() {
        this(new Date(0), new Date(1));
    }

    public DateRange(Date date, Date date2) {
        super(date.getTime(), date2.getTime());
        this.lowerDate = date;
        this.upperDate = date2;
    }

    public DateRange(double d2, double d3) {
        super(d2, d3);
        this.lowerDate = new Date((long)d2);
        this.upperDate = new Date((long)d3);
    }

    public DateRange(Range range) {
        this(range.getLowerBound(), range.getUpperBound());
    }

    public Date getLowerDate() {
        return this.lowerDate;
    }

    public Date getUpperDate() {
        return this.upperDate;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        return new StringBuffer().append("[").append(dateFormat.format(this.lowerDate)).append(" --> ").append(dateFormat.format(this.upperDate)).append("]").toString();
    }
}

