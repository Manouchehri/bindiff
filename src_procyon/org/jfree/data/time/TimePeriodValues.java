package org.jfree.data.time;

import java.io.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.data.general.*;

public class TimePeriodValues extends Series implements Serializable
{
    static final long serialVersionUID = -2210593619794989709L;
    protected static final String DEFAULT_DOMAIN_DESCRIPTION = "Time";
    protected static final String DEFAULT_RANGE_DESCRIPTION = "Value";
    private String domain;
    private String range;
    private List data;
    private int minStartIndex;
    private int maxStartIndex;
    private int minMiddleIndex;
    private int maxMiddleIndex;
    private int minEndIndex;
    private int maxEndIndex;
    
    public TimePeriodValues(final String s) {
        this(s, "Time", "Value");
    }
    
    public TimePeriodValues(final String s, final String domain, final String range) {
        super(s);
        this.minStartIndex = -1;
        this.maxStartIndex = -1;
        this.minMiddleIndex = -1;
        this.maxMiddleIndex = -1;
        this.minEndIndex = -1;
        this.maxEndIndex = -1;
        this.domain = domain;
        this.range = range;
        this.data = new ArrayList();
    }
    
    public String getDomainDescription() {
        return this.domain;
    }
    
    public void setDomainDescription(final String domain) {
        this.firePropertyChange("Domain", this.domain, this.domain = domain);
    }
    
    public String getRangeDescription() {
        return this.range;
    }
    
    public void setRangeDescription(final String range) {
        this.firePropertyChange("Range", this.range, this.range = range);
    }
    
    public int getItemCount() {
        return this.data.size();
    }
    
    public TimePeriodValue getDataItem(final int n) {
        return this.data.get(n);
    }
    
    public TimePeriod getTimePeriod(final int n) {
        return this.getDataItem(n).getPeriod();
    }
    
    public Number getValue(final int n) {
        return this.getDataItem(n).getValue();
    }
    
    public void add(final TimePeriodValue timePeriodValue) {
        if (timePeriodValue == null) {
            throw new IllegalArgumentException("Null item not allowed.");
        }
        this.data.add(timePeriodValue);
        this.updateBounds(timePeriodValue.getPeriod(), this.data.size() - 1);
        this.fireSeriesChanged();
    }
    
    private void updateBounds(final TimePeriod timePeriod, final int n) {
        final long time = timePeriod.getStart().getTime();
        final long time2 = timePeriod.getEnd().getTime();
        final long n2 = time + (time2 - time) / 2L;
        if (this.minStartIndex >= 0) {
            if (time < this.getDataItem(this.minStartIndex).getPeriod().getStart().getTime()) {
                this.minStartIndex = n;
            }
        }
        else {
            this.minStartIndex = n;
        }
        if (this.maxStartIndex >= 0) {
            if (time > this.getDataItem(this.maxStartIndex).getPeriod().getStart().getTime()) {
                this.maxStartIndex = n;
            }
        }
        else {
            this.maxStartIndex = n;
        }
        if (this.minMiddleIndex >= 0) {
            final long time3 = this.getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime();
            if (n2 < time3 + (this.getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime() - time3) / 2L) {
                this.minMiddleIndex = n;
            }
        }
        else {
            this.minMiddleIndex = n;
        }
        if (this.maxMiddleIndex >= 0) {
            final long time4 = this.getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime();
            if (n2 > time4 + (this.getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime() - time4) / 2L) {
                this.maxMiddleIndex = n;
            }
        }
        else {
            this.maxMiddleIndex = n;
        }
        if (this.minEndIndex >= 0) {
            if (time2 < this.getDataItem(this.minEndIndex).getPeriod().getEnd().getTime()) {
                this.minEndIndex = n;
            }
        }
        else {
            this.minEndIndex = n;
        }
        if (this.maxEndIndex >= 0) {
            if (time2 > this.getDataItem(this.maxEndIndex).getPeriod().getEnd().getTime()) {
                this.maxEndIndex = n;
            }
        }
        else {
            this.maxEndIndex = n;
        }
    }
    
    private void recalculateBounds() {
        this.minStartIndex = -1;
        this.minMiddleIndex = -1;
        this.minEndIndex = -1;
        this.maxStartIndex = -1;
        this.maxMiddleIndex = -1;
        this.maxEndIndex = -1;
        for (int i = 0; i < this.data.size(); ++i) {
            this.updateBounds(((TimePeriodValue)this.data.get(i)).getPeriod(), i);
        }
    }
    
    public void add(final TimePeriod timePeriod, final double n) {
        this.add(new TimePeriodValue(timePeriod, n));
    }
    
    public void add(final TimePeriod timePeriod, final Number n) {
        this.add(new TimePeriodValue(timePeriod, n));
    }
    
    public void update(final int n, final Number value) {
        this.getDataItem(n).setValue(value);
        this.fireSeriesChanged();
    }
    
    public void delete(final int n, final int n2) {
        for (int i = 0; i <= n2 - n; ++i) {
            this.data.remove(n);
        }
        this.recalculateBounds();
        this.fireSeriesChanged();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TimePeriodValues)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final TimePeriodValues timePeriodValues = (TimePeriodValues)o;
        if (!ObjectUtilities.equal(this.getDomainDescription(), timePeriodValues.getDomainDescription())) {
            return false;
        }
        if (!ObjectUtilities.equal(this.getRangeDescription(), timePeriodValues.getRangeDescription())) {
            return false;
        }
        final int itemCount = this.getItemCount();
        if (itemCount != timePeriodValues.getItemCount()) {
            return false;
        }
        for (int i = 0; i < itemCount; ++i) {
            if (!this.getDataItem(i).equals(timePeriodValues.getDataItem(i))) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * (29 * (29 * (29 * (29 * (29 * ((this.domain != null) ? this.domain.hashCode() : 0) + ((this.range != null) ? this.range.hashCode() : 0)) + this.data.hashCode()) + this.minStartIndex) + this.maxStartIndex) + this.minMiddleIndex) + this.maxMiddleIndex) + this.minEndIndex) + this.maxEndIndex;
    }
    
    public Object clone() {
        return this.createCopy(0, this.getItemCount() - 1);
    }
    
    public TimePeriodValues createCopy(final int n, final int n2) {
        final TimePeriodValues timePeriodValues = (TimePeriodValues)super.clone();
        timePeriodValues.data = new ArrayList();
        if (this.data.size() > 0) {
            for (int i = n; i <= n2; ++i) {
                final TimePeriodValue timePeriodValue = (TimePeriodValue)this.data.get(i).clone();
                try {
                    timePeriodValues.add(timePeriodValue);
                }
                catch (SeriesException ex) {
                    System.err.println("Failed to add cloned item.");
                }
            }
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
