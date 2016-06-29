package org.jfree.data.general;

import java.io.*;
import org.jfree.data.*;
import org.jfree.util.*;

public class DefaultKeyedValueDataset extends AbstractDataset implements Serializable, KeyedValueDataset
{
    private static final long serialVersionUID = -8149484339560406750L;
    private KeyedValue data;
    
    public DefaultKeyedValueDataset() {
        this(null);
    }
    
    public DefaultKeyedValueDataset(final Comparable comparable, final Number n) {
        this(new DefaultKeyedValue(comparable, n));
    }
    
    public DefaultKeyedValueDataset(final KeyedValue data) {
        this.data = data;
    }
    
    public Comparable getKey() {
        Comparable key = null;
        if (this.data != null) {
            key = this.data.getKey();
        }
        return key;
    }
    
    public Number getValue() {
        Number value = null;
        if (this.data != null) {
            value = this.data.getValue();
        }
        return value;
    }
    
    public void updateValue(final Number n) {
        if (this.data == null) {
            throw new RuntimeException("updateValue: can't update null.");
        }
        this.setValue(this.data.getKey(), n);
    }
    
    public void setValue(final Comparable comparable, final Number n) {
        this.data = new DefaultKeyedValue(comparable, n);
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyedValueDataset)) {
            return false;
        }
        final KeyedValueDataset keyedValueDataset = (KeyedValueDataset)o;
        if (this.data == null) {
            return keyedValueDataset.getKey() == null && keyedValueDataset.getValue() == null;
        }
        return ObjectUtilities.equal(this.data.getKey(), keyedValueDataset.getKey()) && ObjectUtilities.equal(this.data.getValue(), keyedValueDataset.getValue());
    }
    
    public int hashCode() {
        return (this.data != null) ? this.data.hashCode() : 0;
    }
    
    public Object clone() {
        return super.clone();
    }
}
