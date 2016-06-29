/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.xy.XYDataItem;
import org.jfree.util.ObjectUtilities;

public class XYSeries
extends Series
implements Serializable,
Cloneable {
    static final long serialVersionUID = -5908509288197150436L;
    protected List data = new ArrayList();
    private int maximumItemCount = Integer.MAX_VALUE;
    private boolean autoSort;
    private boolean allowDuplicateXValues;

    public XYSeries(Comparable comparable) {
        this(comparable, true, true);
    }

    public XYSeries(Comparable comparable, boolean bl2) {
        this(comparable, bl2, true);
    }

    public XYSeries(Comparable comparable, boolean bl2, boolean bl3) {
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

    public List getItems() {
        return Collections.unmodifiableList(this.data);
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

    public void add(XYDataItem xYDataItem) {
        this.add(xYDataItem, true);
    }

    public void add(double d2, double d3) {
        this.add(new Double(d2), (Number)new Double(d3), true);
    }

    public void add(double d2, double d3, boolean bl2) {
        this.add(new Double(d2), (Number)new Double(d3), bl2);
    }

    public void add(double d2, Number number) {
        this.add(new Double(d2), number);
    }

    public void add(double d2, Number number, boolean bl2) {
        this.add(new Double(d2), number, bl2);
    }

    public void add(Number number, Number number2) {
        this.add(number, number2, true);
    }

    public void add(Number number, Number number2, boolean bl2) {
        XYDataItem xYDataItem = new XYDataItem(number, number2);
        this.add(xYDataItem, bl2);
    }

    public void add(XYDataItem xYDataItem, boolean bl2) {
        if (xYDataItem == null) {
            throw new IllegalArgumentException("Null 'item' argument.");
        }
        if (this.autoSort) {
            int n2 = Collections.binarySearch(this.data, xYDataItem);
            if (n2 < 0) {
                this.data.add(- n2 - 1, xYDataItem);
            } else {
                if (!this.allowDuplicateXValues) throw new SeriesException("X-value already exists.");
                int n3 = this.data.size();
                while (n2 < n3 && xYDataItem.compareTo(this.data.get(n2)) == 0) {
                    ++n2;
                }
                if (n2 < this.data.size()) {
                    this.data.add(n2, xYDataItem);
                } else {
                    this.data.add(xYDataItem);
                }
            }
        } else {
            int n4;
            if (!this.allowDuplicateXValues && (n4 = this.indexOf(xYDataItem.getX())) >= 0) {
                throw new SeriesException("X-value already exists.");
            }
            this.data.add(xYDataItem);
        }
        if (this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
        }
        if (!bl2) return;
        this.fireSeriesChanged();
    }

    public void delete(int n2, int n3) {
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

    public XYDataItem remove(int n2) {
        XYDataItem xYDataItem = (XYDataItem)this.data.remove(n2);
        this.fireSeriesChanged();
        return xYDataItem;
    }

    public XYDataItem remove(Number number) {
        return this.remove(this.indexOf(number));
    }

    public void clear() {
        if (this.data.size() <= 0) return;
        this.data.clear();
        this.fireSeriesChanged();
    }

    public XYDataItem getDataItem(int n2) {
        return (XYDataItem)this.data.get(n2);
    }

    public Number getX(int n2) {
        return this.getDataItem(n2).getX();
    }

    public Number getY(int n2) {
        return this.getDataItem(n2).getY();
    }

    public void update(int n2, Number number) {
        XYDataItem xYDataItem = this.getDataItem(n2);
        xYDataItem.setY(number);
        this.fireSeriesChanged();
    }

    public void updateByIndex(int n2, Number number) {
        this.update(n2, number);
    }

    public void update(Number number, Number number2) {
        int n2 = this.indexOf(number);
        if (n2 < 0) {
            throw new SeriesException(new StringBuffer().append("No observation for x = ").append(number).toString());
        }
        XYDataItem xYDataItem = this.getDataItem(n2);
        xYDataItem.setY(number2);
        this.fireSeriesChanged();
    }

    public XYDataItem addOrUpdate(Number number, Number number2) {
        if (number == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        XYDataItem xYDataItem = null;
        int n2 = this.indexOf(number);
        if (n2 >= 0) {
            XYDataItem xYDataItem2 = (XYDataItem)this.data.get(n2);
            try {
                xYDataItem = (XYDataItem)xYDataItem2.clone();
            }
            catch (CloneNotSupportedException var6_6) {
                throw new SeriesException("Couldn't clone XYDataItem!");
            }
            xYDataItem2.setY(number2);
        } else {
            if (this.autoSort) {
                this.data.add(- n2 - 1, new XYDataItem(number, number2));
            } else {
                this.data.add(new XYDataItem(number, number2));
            }
            if (this.getItemCount() > this.maximumItemCount) {
                this.data.remove(0);
            }
        }
        this.fireSeriesChanged();
        return xYDataItem;
    }

    public int indexOf(Number number) {
        if (this.autoSort) {
            return Collections.binarySearch(this.data, new XYDataItem(number, null));
        }
        int n2 = 0;
        while (n2 < this.data.size()) {
            XYDataItem xYDataItem = (XYDataItem)this.data.get(n2);
            if (xYDataItem.getX().equals(number)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public double[][] toArray() {
        int n2 = this.getItemCount();
        double[][] arrd = new double[2][n2];
        int n3 = 0;
        while (n3 < n2) {
            arrd[0][n3] = this.getX(n3).doubleValue();
            Number number = this.getY(n3);
            arrd[1][n3] = number != null ? number.doubleValue() : Double.NaN;
            ++n3;
        }
        return arrd;
    }

    @Override
    public Object clone() {
        return this.createCopy(0, this.getItemCount() - 1);
    }

    public XYSeries createCopy(int n2, int n3) {
        XYSeries xYSeries = (XYSeries)super.clone();
        xYSeries.data = new ArrayList();
        if (this.data.size() <= 0) return xYSeries;
        int n4 = n2;
        while (n4 <= n3) {
            XYDataItem xYDataItem = (XYDataItem)this.data.get(n4);
            XYDataItem xYDataItem2 = (XYDataItem)xYDataItem.clone();
            try {
                xYSeries.add(xYDataItem2);
            }
            catch (SeriesException var7_7) {
                System.err.println("Unable to add cloned data item.");
            }
            ++n4;
        }
        return xYSeries;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYSeries)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYSeries xYSeries = (XYSeries)object;
        if (this.maximumItemCount != xYSeries.maximumItemCount) {
            return false;
        }
        if (this.autoSort != xYSeries.autoSort) {
            return false;
        }
        if (this.allowDuplicateXValues != xYSeries.allowDuplicateXValues) {
            return false;
        }
        if (ObjectUtilities.equal(this.data, xYSeries.data)) return true;
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

