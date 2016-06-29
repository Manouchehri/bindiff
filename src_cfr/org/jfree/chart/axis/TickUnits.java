/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;

public class TickUnits
implements Serializable,
Cloneable,
TickUnitSource {
    private static final long serialVersionUID = 1134174035901467545L;
    private List tickUnits = new ArrayList();

    public void add(TickUnit tickUnit) {
        if (tickUnit == null) {
            throw new NullPointerException("Null 'unit' argument.");
        }
        this.tickUnits.add(tickUnit);
        Collections.sort(this.tickUnits);
    }

    public int size() {
        return this.tickUnits.size();
    }

    public TickUnit get(int n2) {
        return (TickUnit)this.tickUnits.get(n2);
    }

    @Override
    public TickUnit getLargerTickUnit(TickUnit tickUnit) {
        int n2 = Collections.binarySearch(this.tickUnits, tickUnit);
        if (n2 >= 0) {
            return (TickUnit)this.tickUnits.get(Math.min(++n2, this.tickUnits.size() - 1));
        }
        n2 = - n2;
        return (TickUnit)this.tickUnits.get(Math.min(n2, this.tickUnits.size() - 1));
    }

    @Override
    public TickUnit getCeilingTickUnit(TickUnit tickUnit) {
        int n2 = Collections.binarySearch(this.tickUnits, tickUnit);
        if (n2 >= 0) {
            return (TickUnit)this.tickUnits.get(n2);
        }
        n2 = - n2 + 1;
        return (TickUnit)this.tickUnits.get(Math.min(n2, this.tickUnits.size() - 1));
    }

    @Override
    public TickUnit getCeilingTickUnit(double d2) {
        return this.getCeilingTickUnit(new NumberTickUnit(d2, NumberFormat.getInstance()));
    }

    public Object clone() {
        TickUnits tickUnits = (TickUnits)super.clone();
        tickUnits.tickUnits = new ArrayList(this.tickUnits);
        return tickUnits;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof TickUnits)) return false;
        TickUnits tickUnits = (TickUnits)object;
        return tickUnits.tickUnits.equals(this.tickUnits);
    }
}

