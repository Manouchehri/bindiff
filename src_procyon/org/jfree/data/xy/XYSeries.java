package org.jfree.data.xy;

import java.io.*;
import java.util.*;
import org.jfree.data.general.*;
import org.jfree.util.*;

public class XYSeries extends Series implements Serializable, Cloneable
{
    static final long serialVersionUID = -5908509288197150436L;
    protected List data;
    private int maximumItemCount;
    private boolean autoSort;
    private boolean allowDuplicateXValues;
    
    public XYSeries(final Comparable comparable) {
        this(comparable, true, true);
    }
    
    public XYSeries(final Comparable comparable, final boolean b) {
        this(comparable, b, true);
    }
    
    public XYSeries(final Comparable comparable, final boolean autoSort, final boolean allowDuplicateXValues) {
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
    
    public List getItems() {
        return Collections.unmodifiableList((List<?>)this.data);
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
    
    public void add(final XYDataItem xyDataItem) {
        this.add(xyDataItem, true);
    }
    
    public void add(final double n, final double n2) {
        this.add(new Double(n), new Double(n2), true);
    }
    
    public void add(final double n, final double n2, final boolean b) {
        this.add(new Double(n), new Double(n2), b);
    }
    
    public void add(final double n, final Number n2) {
        this.add(new Double(n), n2);
    }
    
    public void add(final double n, final Number n2, final boolean b) {
        this.add(new Double(n), n2, b);
    }
    
    public void add(final Number n, final Number n2) {
        this.add(n, n2, true);
    }
    
    public void add(final Number n, final Number n2, final boolean b) {
        this.add(new XYDataItem(n, n2), b);
    }
    
    public void add(final XYDataItem xyDataItem, final boolean b) {
        if (xyDataItem == null) {
            throw new IllegalArgumentException("Null 'item' argument.");
        }
        if (this.autoSort) {
            int binarySearch = Collections.binarySearch(this.data, xyDataItem);
            if (binarySearch < 0) {
                this.data.add(-binarySearch - 1, xyDataItem);
            }
            else {
                if (!this.allowDuplicateXValues) {
                    throw new SeriesException("X-value already exists.");
                }
                while (binarySearch < this.data.size() && xyDataItem.compareTo(this.data.get(binarySearch)) == 0) {
                    ++binarySearch;
                }
                if (binarySearch < this.data.size()) {
                    this.data.add(binarySearch, xyDataItem);
                }
                else {
                    this.data.add(xyDataItem);
                }
            }
        }
        else {
            if (!this.allowDuplicateXValues && this.indexOf(xyDataItem.getX()) >= 0) {
                throw new SeriesException("X-value already exists.");
            }
            this.data.add(xyDataItem);
        }
        if (this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
        }
        if (b) {
            this.fireSeriesChanged();
        }
    }
    
    public void delete(final int n, final int n2) {
        for (int i = n; i <= n2; ++i) {
            this.data.remove(n);
        }
        this.fireSeriesChanged();
    }
    
    public XYDataItem remove(final int n) {
        final XYDataItem xyDataItem = this.data.remove(n);
        this.fireSeriesChanged();
        return xyDataItem;
    }
    
    public XYDataItem remove(final Number n) {
        return this.remove(this.indexOf(n));
    }
    
    public void clear() {
        if (this.data.size() > 0) {
            this.data.clear();
            this.fireSeriesChanged();
        }
    }
    
    public XYDataItem getDataItem(final int n) {
        return this.data.get(n);
    }
    
    public Number getX(final int n) {
        return this.getDataItem(n).getX();
    }
    
    public Number getY(final int n) {
        return this.getDataItem(n).getY();
    }
    
    public void update(final int n, final Number y) {
        this.getDataItem(n).setY(y);
        this.fireSeriesChanged();
    }
    
    public void updateByIndex(final int n, final Number n2) {
        this.update(n, n2);
    }
    
    public void update(final Number n, final Number y) {
        final int index = this.indexOf(n);
        if (index < 0) {
            throw new SeriesException("No observation for x = " + n);
        }
        this.getDataItem(index).setY(y);
        this.fireSeriesChanged();
    }
    
    public XYDataItem addOrUpdate(final Number n, final Number y) {
        if (n == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        XYDataItem xyDataItem = null;
        final int index = this.indexOf(n);
        if (index >= 0) {
            final XYDataItem xyDataItem2 = this.data.get(index);
            try {
                xyDataItem = (XYDataItem)xyDataItem2.clone();
            }
            catch (CloneNotSupportedException ex) {
                throw new SeriesException("Couldn't clone XYDataItem!");
            }
            xyDataItem2.setY(y);
        }
        else {
            if (this.autoSort) {
                this.data.add(-index - 1, new XYDataItem(n, y));
            }
            else {
                this.data.add(new XYDataItem(n, y));
            }
            if (this.getItemCount() > this.maximumItemCount) {
                this.data.remove(0);
            }
        }
        this.fireSeriesChanged();
        return xyDataItem;
    }
    
    public int indexOf(final Number n) {
        if (this.autoSort) {
            return Collections.binarySearch(this.data, new XYDataItem(n, null));
        }
        for (int i = 0; i < this.data.size(); ++i) {
            if (((XYDataItem)this.data.get(i)).getX().equals(n)) {
                return i;
            }
        }
        return -1;
    }
    
    public double[][] toArray() {
        final int itemCount = this.getItemCount();
        final double[][] array = new double[2][itemCount];
        for (int i = 0; i < itemCount; ++i) {
            array[0][i] = this.getX(i).doubleValue();
            final Number y = this.getY(i);
            if (y != null) {
                array[1][i] = y.doubleValue();
            }
            else {
                array[1][i] = Double.NaN;
            }
        }
        return array;
    }
    
    public Object clone() {
        return this.createCopy(0, this.getItemCount() - 1);
    }
    
    public XYSeries createCopy(final int n, final int n2) {
        final XYSeries xySeries = (XYSeries)super.clone();
        xySeries.data = new ArrayList();
        if (this.data.size() > 0) {
            for (int i = n; i <= n2; ++i) {
                final XYDataItem xyDataItem = (XYDataItem)this.data.get(i).clone();
                try {
                    xySeries.add(xyDataItem);
                }
                catch (SeriesException ex) {
                    System.err.println("Unable to add cloned data item.");
                }
            }
        }
        return xySeries;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYSeries)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYSeries xySeries = (XYSeries)o;
        return this.maximumItemCount == xySeries.maximumItemCount && this.autoSort == xySeries.autoSort && this.allowDuplicateXValues == xySeries.allowDuplicateXValues && ObjectUtilities.equal(this.data, xySeries.data);
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * (29 * super.hashCode() + ((this.data != null) ? this.data.hashCode() : 0)) + this.maximumItemCount) + (this.autoSort ? 1 : 0)) + (this.allowDuplicateXValues ? 1 : 0);
    }
}
