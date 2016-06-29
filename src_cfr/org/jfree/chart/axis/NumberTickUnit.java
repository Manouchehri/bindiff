/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.NumberFormat;
import org.jfree.chart.axis.TickUnit;

public class NumberTickUnit
extends TickUnit
implements Serializable {
    private static final long serialVersionUID = 3849459506627654442L;
    private NumberFormat formatter;

    public NumberTickUnit(double d2) {
        this(d2, NumberFormat.getNumberInstance());
    }

    public NumberTickUnit(double d2, NumberFormat numberFormat) {
        super(d2);
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null 'formatter' argument.");
        }
        this.formatter = numberFormat;
    }

    @Override
    public String valueToString(double d2) {
        return this.formatter.format(d2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NumberTickUnit)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        NumberTickUnit numberTickUnit = (NumberTickUnit)object;
        if (this.formatter.equals(numberTickUnit.formatter)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        return 29 * n2 + (this.formatter != null ? this.formatter.hashCode() : 0);
    }
}

