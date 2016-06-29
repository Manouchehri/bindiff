/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.ComparableObjectItem;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.util.ObjectUtilities;

public class ComparableObjectSeries
extends Series
implements Serializable,
Cloneable {
    protected List data = new ArrayList();
    private int maximumItemCount = Integer.MAX_VALUE;
    private boolean autoSort;
    private boolean allowDuplicateXValues;

    public ComparableObjectSeries(Comparable comparable) {
        this(comparable, true, true);
    }

    public ComparableObjectSeries(Comparable comparable, boolean bl2, boolean bl3) {
        super(comparable);
        this.autoSort = bl2;
        this.allowDuplicateXValues = bl3;
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

    public void setMaximumItemCount(int n2) {
        this.maximumItemCount = n2;
        boolean bl2 = false;
        while (this.data.size() > n2) {
            this.data.remove(0);
            bl2 = true;
        }
    }

    protected void add(Comparable comparable, Object object) {
        this.add(comparable, object, true);
    }

    protected void add(Comparable comparable, Object object, boolean bl2) {
        ComparableObjectItem comparableObjectItem = new ComparableObjectItem(comparable, object);
        this.add(comparableObjectItem, bl2);
    }

    protected void add(ComparableObjectItem comparableObjectItem, boolean bl2) {
        if (comparableObjectItem == null) {
            throw new IllegalArgumentException("Null 'item' argument.");
        }
        if (this.autoSort) {
            int n2 = Collections.binarySearch(this.data, comparableObjectItem);
            if (n2 < 0) {
                this.data.add(- n2 - 1, comparableObjectItem);
            } else {
                if (!this.allowDuplicateXValues) throw new SeriesException("X-value already exists.");
                int n3 = this.data.size();
                while (n2 < n3 && comparableObjectItem.compareTo(this.data.get(n2)) == 0) {
                    ++n2;
                }
                if (n2 < this.data.size()) {
                    this.data.add(n2, comparableObjectItem);
                } else {
                    this.data.add(comparableObjectItem);
                }
            }
        } else {
            int n4;
            if (!this.allowDuplicateXValues && (n4 = this.indexOf(comparableObjectItem.getComparable())) >= 0) {
                throw new SeriesException("X-value already exists.");
            }
            this.data.add(comparableObjectItem);
        }
        if (this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
        }
        if (!bl2) return;
        this.fireSeriesChanged();
    }

    public int indexOf(Comparable comparable) {
        if (this.autoSort) {
            return Collections.binarySearch(this.data, new ComparableObjectItem(comparable, null));
        }
        int n2 = 0;
        while (n2 < this.data.size()) {
            ComparableObjectItem comparableObjectItem = (ComparableObjectItem)this.data.get(n2);
            if (comparableObjectItem.getComparable().equals(comparable)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    protected void update(Comparable comparable, Object object) {
        int n2 = this.indexOf(comparable);
        if (n2 < 0) {
            throw new SeriesException(new StringBuffer().append("No observation for x = ").append(comparable).toString());
        }
        ComparableObjectItem comparableObjectItem = this.getDataItem(n2);
        comparableObjectItem.setObject(object);
        this.fireSeriesChanged();
    }

    protected void updateByIndex(int n2, Object object) {
        ComparableObjectItem comparableObjectItem = this.getDataItem(n2);
        comparableObjectItem.setObject(object);
        this.fireSeriesChanged();
    }

    protected ComparableObjectItem getDataItem(int n2) {
        return (ComparableObjectItem)this.data.get(n2);
    }

    protected void delete(int n2, int n3) {
        int n4 = n2;
        do {
            if (n4 > n3) {
                this.fireSeriesChanged();
                return;
            }
            this.data.remove(n2);
            ++n4;
        } while (true);
    }

    protected void clear() {
        if (this.data.size() <= 0) return;
        this.data.clear();
        this.fireSeriesChanged();
    }

    protected ComparableObjectItem remove(int n2) {
        ComparableObjectItem comparableObjectItem = (ComparableObjectItem)this.data.remove(n2);
        this.fireSeriesChanged();
        return comparableObjectItem;
    }

    public ComparableObjectItem remove(Comparable comparable) {
        return this.remove(this.indexOf(comparable));
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ComparableObjectSeries)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        ComparableObjectSeries comparableObjectSeries = (ComparableObjectSeries)object;
        if (this.maximumItemCount != comparableObjectSeries.maximumItemCount) {
            return false;
        }
        if (this.autoSort != comparableObjectSeries.autoSort) {
            return false;
        }
        if (this.allowDuplicateXValues != comparableObjectSeries.allowDuplicateXValues) {
            return false;
        }
        if (ObjectUtilities.equal(this.data, comparableObjectSeries.data)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 29 * n2 + (this.data != null ? this.data.hashCode() : 0);
        n2 = 29 * n2 + this.maximumItemCount;
        n2 = 29 * n2 + (this.autoSort ? 1 : 0);
        return 29 * n2 + (this.allowDuplicateXValues ? 1 : 0);
    }
}

