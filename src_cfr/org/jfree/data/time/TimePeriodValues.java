/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodValue;
import org.jfree.util.ObjectUtilities;

public class TimePeriodValues
extends Series
implements Serializable {
    static final long serialVersionUID = -2210593619794989709L;
    protected static final String DEFAULT_DOMAIN_DESCRIPTION = "Time";
    protected static final String DEFAULT_RANGE_DESCRIPTION = "Value";
    private String domain;
    private String range;
    private List data;
    private int minStartIndex = -1;
    private int maxStartIndex = -1;
    private int minMiddleIndex = -1;
    private int maxMiddleIndex = -1;
    private int minEndIndex = -1;
    private int maxEndIndex = -1;

    public TimePeriodValues(String string) {
        this(string, "Time", "Value");
    }

    public TimePeriodValues(String string, String string2, String string3) {
        super((Comparable)((Object)string));
        this.domain = string2;
        this.range = string3;
        this.data = new ArrayList();
    }

    public String getDomainDescription() {
        return this.domain;
    }

    public void setDomainDescription(String string) {
        String string2 = this.domain;
        this.domain = string;
        this.firePropertyChange("Domain", string2, string);
    }

    public String getRangeDescription() {
        return this.range;
    }

    public void setRangeDescription(String string) {
        String string2 = this.range;
        this.range = string;
        this.firePropertyChange("Range", string2, string);
    }

    public int getItemCount() {
        return this.data.size();
    }

    public TimePeriodValue getDataItem(int n2) {
        return (TimePeriodValue)this.data.get(n2);
    }

    public TimePeriod getTimePeriod(int n2) {
        return this.getDataItem(n2).getPeriod();
    }

    public Number getValue(int n2) {
        return this.getDataItem(n2).getValue();
    }

    public void add(TimePeriodValue timePeriodValue) {
        if (timePeriodValue == null) {
            throw new IllegalArgumentException("Null item not allowed.");
        }
        this.data.add(timePeriodValue);
        this.updateBounds(timePeriodValue.getPeriod(), this.data.size() - 1);
        this.fireSeriesChanged();
    }

    private void updateBounds(TimePeriod timePeriod, int n2) {
        long l2;
        long l3;
        long l4;
        long l5 = timePeriod.getStart().getTime();
        long l6 = timePeriod.getEnd().getTime();
        long l7 = l5 + (l6 - l5) / 2;
        if (this.minStartIndex >= 0) {
            l3 = this.getDataItem(this.minStartIndex).getPeriod().getStart().getTime();
            if (l5 < l3) {
                this.minStartIndex = n2;
            }
        } else {
            this.minStartIndex = n2;
        }
        if (this.maxStartIndex >= 0) {
            l3 = this.getDataItem(this.maxStartIndex).getPeriod().getStart().getTime();
            if (l5 > l3) {
                this.maxStartIndex = n2;
            }
        } else {
            this.maxStartIndex = n2;
        }
        if (this.minMiddleIndex >= 0) {
            l3 = this.getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime();
            l2 = l3 + ((l4 = this.getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime()) - l3) / 2;
            if (l7 < l2) {
                this.minMiddleIndex = n2;
            }
        } else {
            this.minMiddleIndex = n2;
        }
        if (this.maxMiddleIndex >= 0) {
            l3 = this.getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime();
            l2 = l3 + ((l4 = this.getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime()) - l3) / 2;
            if (l7 > l2) {
                this.maxMiddleIndex = n2;
            }
        } else {
            this.maxMiddleIndex = n2;
        }
        if (this.minEndIndex >= 0) {
            l3 = this.getDataItem(this.minEndIndex).getPeriod().getEnd().getTime();
            if (l6 < l3) {
                this.minEndIndex = n2;
            }
        } else {
            this.minEndIndex = n2;
        }
        if (this.maxEndIndex >= 0) {
            l3 = this.getDataItem(this.maxEndIndex).getPeriod().getEnd().getTime();
            if (l6 <= l3) return;
            this.maxEndIndex = n2;
            return;
        }
        this.maxEndIndex = n2;
    }

    private void recalculateBounds() {
        this.minStartIndex = -1;
        this.minMiddleIndex = -1;
        this.minEndIndex = -1;
        this.maxStartIndex = -1;
        this.maxMiddleIndex = -1;
        this.maxEndIndex = -1;
        int n2 = 0;
        while (n2 < this.data.size()) {
            TimePeriodValue timePeriodValue = (TimePeriodValue)this.data.get(n2);
            this.updateBounds(timePeriodValue.getPeriod(), n2);
            ++n2;
        }
    }

    public void add(TimePeriod timePeriod, double d2) {
        TimePeriodValue timePeriodValue = new TimePeriodValue(timePeriod, d2);
        this.add(timePeriodValue);
    }

    public void add(TimePeriod timePeriod, Number number) {
        TimePeriodValue timePeriodValue = new TimePeriodValue(timePeriod, number);
        this.add(timePeriodValue);
    }

    public void update(int n2, Number number) {
        TimePeriodValue timePeriodValue = this.getDataItem(n2);
        timePeriodValue.setValue(number);
        this.fireSeriesChanged();
    }

    public void delete(int n2, int n3) {
        int n4 = 0;
        do {
            if (n4 > n3 - n2) {
                this.recalculateBounds();
                this.fireSeriesChanged();
                return;
            }
            this.data.remove(n2);
            ++n4;
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TimePeriodValues)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        TimePeriodValues timePeriodValues = (TimePeriodValues)object;
        if (!ObjectUtilities.equal(this.getDomainDescription(), timePeriodValues.getDomainDescription())) {
            return false;
        }
        if (!ObjectUtilities.equal(this.getRangeDescription(), timePeriodValues.getRangeDescription())) {
            return false;
        }
        int n2 = this.getItemCount();
        if (n2 != timePeriodValues.getItemCount()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (!this.getDataItem(n3).equals(timePeriodValues.getDataItem(n3))) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = this.domain != null ? this.domain.hashCode() : 0;
        n2 = 29 * n2 + (this.range != null ? this.range.hashCode() : 0);
        n2 = 29 * n2 + this.data.hashCode();
        n2 = 29 * n2 + this.minStartIndex;
        n2 = 29 * n2 + this.maxStartIndex;
        n2 = 29 * n2 + this.minMiddleIndex;
        n2 = 29 * n2 + this.maxMiddleIndex;
        n2 = 29 * n2 + this.minEndIndex;
        return 29 * n2 + this.maxEndIndex;
    }

    @Override
    public Object clone() {
        return this.createCopy(0, this.getItemCount() - 1);
    }

    public TimePeriodValues createCopy(int n2, int n3) {
        TimePeriodValues timePeriodValues = (TimePeriodValues)super.clone();
        timePeriodValues.data = new ArrayList();
        if (this.data.size() <= 0) return timePeriodValues;
        int n4 = n2;
        while (n4 <= n3) {
            TimePeriodValue timePeriodValue = (TimePeriodValue)this.data.get(n4);
            TimePeriodValue timePeriodValue2 = (TimePeriodValue)timePeriodValue.clone();
            try {
                timePeriodValues.add(timePeriodValue2);
            }
            catch (SeriesException var7_7) {
                System.err.println("Failed to add cloned item.");
            }
            ++n4;
        }
        return timePeriodValues;
    }

    public int getMinStartIndex() {
        return this.minStartIndex;
    }

    public int getMaxStartIndex() {
        return this.maxStartIndex;
    }

    public int getMinMiddleIndex() {
        return this.minMiddleIndex;
    }

    public int getMaxMiddleIndex() {
        return this.maxMiddleIndex;
    }

    public int getMinEndIndex() {
        return this.minEndIndex;
    }

    public int getMaxEndIndex() {
        return this.maxEndIndex;
    }
}

