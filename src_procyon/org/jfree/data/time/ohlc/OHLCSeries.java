package org.jfree.data.time.ohlc;

import org.jfree.data.time.*;
import org.jfree.data.*;

public class OHLCSeries extends ComparableObjectSeries
{
    public OHLCSeries(final Comparable comparable) {
        super(comparable, true, false);
    }
    
    public RegularTimePeriod getPeriod(final int n) {
        return ((OHLCItem)this.getDataItem(n)).getPeriod();
    }
    
    public ComparableObjectItem getDataItem(final int n) {
        return super.getDataItem(n);
    }
    
    public void add(final RegularTimePeriod regularTimePeriod, final double n, final double n2, final double n3, final double n4) {
        if (this.getItemCount() > 0 && !regularTimePeriod.getClass().equals(((OHLCItem)this.getDataItem(0)).getPeriod().getClass())) {
            throw new IllegalArgumentException("Can't mix RegularTimePeriod class types.");
        }
        super.add(new OHLCItem(regularTimePeriod, n, n2, n3, n4), true);
    }
}
