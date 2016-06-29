package org.jfree.data;

import java.io.*;
import org.jfree.util.*;
import java.util.*;

public class DefaultKeyedValues implements Serializable, Cloneable, KeyedValues, PublicCloneable
{
    private static final long serialVersionUID = 8468154364608194797L;
    private List data;
    
    public DefaultKeyedValues() {
        this.data = new ArrayList();
    }
    
    public int getItemCount() {
        return this.data.size();
    }
    
    public Number getValue(final int n) {
        Number value = null;
        final KeyedValue keyedValue = this.data.get(n);
        if (keyedValue != null) {
            value = keyedValue.getValue();
        }
        return value;
    }
    
    public Comparable getKey(final int n) {
        Comparable key = null;
        final KeyedValue keyedValue = this.data.get(n);
        if (keyedValue != null) {
            key = keyedValue.getKey();
        }
        return key;
    }
    
    public int getIndex(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        int n = 0;
        final Iterator<KeyedValue> iterator = (Iterator<KeyedValue>)this.data.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(comparable)) {
                return n;
            }
            ++n;
        }
        return -1;
    }
    
    public List getKeys() {
        final ArrayList<Comparable> list = new ArrayList<Comparable>();
        final Iterator<KeyedValue> iterator = this.data.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().getKey());
        }
        return list;
    }
    
    public Number getValue(final Comparable comparable) {
        final int index = this.getIndex(comparable);
        if (index < 0) {
            throw new UnknownKeyException("Key not found: " + comparable);
        }
        return this.getValue(index);
    }
    
    public void addValue(final Comparable comparable, final double n) {
        this.addValue(comparable, new Double(n));
    }
    
    public void addValue(final Comparable comparable, final Number n) {
        this.setValue(comparable, n);
    }
    
    public void setValue(final Comparable comparable, final double n) {
        this.setValue(comparable, new Double(n));
    }
    
    public void setValue(final Comparable comparable, final Number value) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        final int index = this.getIndex(comparable);
        if (index >= 0) {
            ((DefaultKeyedValue)this.data.get(index)).setValue(value);
        }
        else {
            this.data.add(new DefaultKeyedValue(comparable, value));
        }
    }
    
    public void removeValue(final int n) {
        this.data.remove(n);
    }
    
    public void removeValue(final Comparable comparable) {
        final int index = this.getIndex(comparable);
        if (index >= 0) {
            this.removeValue(index);
        }
    }
    
    public void clear() {
        this.data.clear();
    }
    
    public void sortByKeys(final SortOrder sortOrder) {
        Collections.sort((List<Object>)this.data, new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, sortOrder));
    }
    
    public void sortByValues(final SortOrder sortOrder) {
        Collections.sort((List<Object>)this.data, new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, sortOrder));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyedValues)) {
            return false;
        }
        final KeyedValues keyedValues = (KeyedValues)o;
        final int itemCount = this.getItemCount();
        if (itemCount != keyedValues.getItemCount()) {
            return false;
        }
        for (int i = 0; i < itemCount; ++i) {
            if (!this.getKey(i).equals(keyedValues.getKey(i))) {
                return false;
            }
            final Number value = this.getValue(i);
            final Number value2 = keyedValues.getValue(i);
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
        return (this.data != null) ? this.data.hashCode() : 0;
    }
    
    public Object clone() {
        final DefaultKeyedValues defaultKeyedValues = (DefaultKeyedValues)super.clone();
        defaultKeyedValues.data = (List)ObjectUtilities.deepClone(this.data);
        return defaultKeyedValues;
    }
}
