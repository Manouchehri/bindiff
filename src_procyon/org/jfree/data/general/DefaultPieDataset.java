package org.jfree.data.general;

import java.io.*;
import org.jfree.data.*;
import java.util.*;
import org.jfree.util.*;

public class DefaultPieDataset extends AbstractDataset implements Serializable, Cloneable, PieDataset, PublicCloneable
{
    private static final long serialVersionUID = 2904745139106540618L;
    private DefaultKeyedValues data;
    
    public DefaultPieDataset() {
        this.data = new DefaultKeyedValues();
    }
    
    public DefaultPieDataset(final KeyedValues keyedValues) {
        if (keyedValues == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        this.data = new DefaultKeyedValues();
        for (int i = 0; i < keyedValues.getItemCount(); ++i) {
            this.data.addValue(keyedValues.getKey(i), keyedValues.getValue(i));
        }
    }
    
    public int getItemCount() {
        return this.data.getItemCount();
    }
    
    public List getKeys() {
        return Collections.unmodifiableList((List<?>)this.data.getKeys());
    }
    
    public Comparable getKey(final int n) {
        return this.data.getKey(n);
    }
    
    public int getIndex(final Comparable comparable) {
        return this.data.getIndex(comparable);
    }
    
    public Number getValue(final int n) {
        Number value = null;
        if (this.getItemCount() > n) {
            value = this.data.getValue(n);
        }
        return value;
    }
    
    public Number getValue(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        return this.data.getValue(comparable);
    }
    
    public void setValue(final Comparable comparable, final Number n) {
        this.data.setValue(comparable, n);
        this.fireDatasetChanged();
    }
    
    public void setValue(final Comparable comparable, final double n) {
        this.setValue(comparable, new Double(n));
    }
    
    public void remove(final Comparable comparable) {
        this.data.removeValue(comparable);
        this.fireDatasetChanged();
    }
    
    public void clear() {
        if (this.getItemCount() > 0) {
            this.data.clear();
            this.fireDatasetChanged();
        }
    }
    
    public void sortByKeys(final SortOrder sortOrder) {
        this.data.sortByKeys(sortOrder);
        this.fireDatasetChanged();
    }
    
    public void sortByValues(final SortOrder sortOrder) {
        this.data.sortByValues(sortOrder);
        this.fireDatasetChanged();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PieDataset)) {
            return false;
        }
        final PieDataset pieDataset = (PieDataset)o;
        final int itemCount = this.getItemCount();
        if (pieDataset.getItemCount() != itemCount) {
            return false;
        }
        for (int i = 0; i < itemCount; ++i) {
            if (!this.getKey(i).equals(pieDataset.getKey(i))) {
                return false;
            }
            final Number value = this.getValue(i);
            final Number value2 = pieDataset.getValue(i);
            if (value == null) {
                if (value2 != null) {
                    return false;
                }
            }
            else if (!value.equals(value2)) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        return this.data.hashCode();
    }
    
    public Object clone() {
        final DefaultPieDataset defaultPieDataset = (DefaultPieDataset)super.clone();
        defaultPieDataset.data = (DefaultKeyedValues)this.data.clone();
        return defaultPieDataset;
    }
}
