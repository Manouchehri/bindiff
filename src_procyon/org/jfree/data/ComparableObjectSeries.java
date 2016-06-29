package org.jfree.data;

import java.io.*;
import java.util.*;
import org.jfree.data.general.*;
import org.jfree.util.*;

public class ComparableObjectSeries extends Series implements Serializable, Cloneable
{
    protected List data;
    private int maximumItemCount;
    private boolean autoSort;
    private boolean allowDuplicateXValues;
    
    public ComparableObjectSeries(final Comparable comparable) {
        this(comparable, true, true);
    }
    
    public ComparableObjectSeries(final Comparable comparable, final boolean autoSort, final boolean allowDuplicateXValues) {
        super(comparable);
        this.maximumItemCount = Integer.MAX_VALUE;
        this.data = new ArrayList();
        this.autoSort = autoSort;
        this.allowDuplicateXValues = allowDuplicateXValues;
    }
    
    public boolean getAutoSort() {
        return this.autoSort;
    }
    
    public boolean getAllowDuplicateXValues() {
        return this.allowDuplicateXValues;
    }
    
    public int getItemCount() {
        return this.data.size();
    }
    
    public int getMaximumItemCount() {
        return this.maximumItemCount;
    }
    
    public void setMaximumItemCount(final int maximumItemCount) {
        this.maximumItemCount = maximumItemCount;
        boolean b = false;
        while (this.data.size() > maximumItemCount) {
            this.data.remove(0);
            b = true;
        }
        if (b) {
            this.fireSeriesChanged();
        }
    }
    
    protected void add(final Comparable comparable, final Object o) {
        this.add(comparable, o, true);
    }
    
    protected void add(final Comparable comparable, final Object o, final boolean b) {
        this.add(new ComparableObjectItem(comparable, o), b);
    }
    
    protected void add(final ComparableObjectItem comparableObjectItem, final boolean b) {
        if (comparableObjectItem == null) {
            throw new IllegalArgumentException("Null 'item' argument.");
        }
        if (this.autoSort) {
            int binarySearch = Collections.binarySearch(this.data, comparableObjectItem);
            if (binarySearch < 0) {
                this.data.add(-binarySearch - 1, comparableObjectItem);
            }
            else {
                if (!this.allowDuplicateXValues) {
                    throw new SeriesException("X-value already exists.");
                }
                while (binarySearch < this.data.size() && comparableObjectItem.compareTo(this.data.get(binarySearch)) == 0) {
                    ++binarySearch;
                }
                if (binarySearch < this.data.size()) {
                    this.data.add(binarySearch, comparableObjectItem);
                }
                else {
                    this.data.add(comparableObjectItem);
                }
            }
        }
        else {
            if (!this.allowDuplicateXValues && this.indexOf(comparableObjectItem.getComparable()) >= 0) {
                throw new SeriesException("X-value already exists.");
            }
            this.data.add(comparableObjectItem);
        }
        if (this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
        }
        if (b) {
            this.fireSeriesChanged();
        }
    }
    
    public int indexOf(final Comparable comparable) {
        if (this.autoSort) {
            return Collections.binarySearch(this.data, new ComparableObjectItem(comparable, null));
        }
        for (int i = 0; i < this.data.size(); ++i) {
            if (((ComparableObjectItem)this.data.get(i)).getComparable().equals(comparable)) {
                return i;
            }
        }
        return -1;
    }
    
    protected void update(final Comparable comparable, final Object object) {
        final int index = this.indexOf(comparable);
        if (index < 0) {
            throw new SeriesException("No observation for x = " + comparable);
        }
        this.getDataItem(index).setObject(object);
        this.fireSeriesChanged();
    }
    
    protected void updateByIndex(final int n, final Object object) {
        this.getDataItem(n).setObject(object);
        this.fireSeriesChanged();
    }
    
    protected ComparableObjectItem getDataItem(final int n) {
        return this.data.get(n);
    }
    
    protected void delete(final int n, final int n2) {
        for (int i = n; i <= n2; ++i) {
            this.data.remove(n);
        }
        this.fireSeriesChanged();
    }
    
    protected void clear() {
        if (this.data.size() > 0) {
            this.data.clear();
            this.fireSeriesChanged();
        }
    }
    
    protected ComparableObjectItem remove(final int n) {
        final ComparableObjectItem comparableObjectItem = this.data.remove(n);
        this.fireSeriesChanged();
        return comparableObjectItem;
    }
    
    public ComparableObjectItem remove(final Comparable comparable) {
        return this.remove(this.indexOf(comparable));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ComparableObjectSeries)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final ComparableObjectSeries comparableObjectSeries = (ComparableObjectSeries)o;
        return this.maximumItemCount == comparableObjectSeries.maximumItemCount && this.autoSort == comparableObjectSeries.autoSort && this.allowDuplicateXValues == comparableObjectSeries.allowDuplicateXValues && ObjectUtilities.equal(this.data, comparableObjectSeries.data);
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * (29 * super.hashCode() + ((this.data != null) ? this.data.hashCode() : 0)) + this.maximumItemCount) + (this.autoSort ? 1 : 0)) + (this.allowDuplicateXValues ? 1 : 0);
    }
}
