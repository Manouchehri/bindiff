/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.util.Date;
import org.jfree.chart.axis.ValueTick;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class DateTick
extends ValueTick {
    private Date date;

    public DateTick(Date date, String string, TextAnchor textAnchor, TextAnchor textAnchor2, double d2) {
        super(date.getTime(), string, textAnchor, textAnchor2, d2);
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DateTick)) return false;
        if (!super.equals(object)) return false;
        DateTick dateTick = (DateTick)object;
        if (ObjectUtilities.equal(this.date, dateTick.date)) return true;
        return false;
    }

    public int hashCode() {
        return this.date.hashCode();
    }
}

