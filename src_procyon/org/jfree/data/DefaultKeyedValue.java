package org.jfree.data;

import java.io.*;
import org.jfree.util.*;

public class DefaultKeyedValue implements Serializable, Cloneable, KeyedValue, PublicCloneable
{
    private static final long serialVersionUID = -7388924517460437712L;
    private Comparable key;
    private Number value;
    
    public DefaultKeyedValue(final Comparable key, final Number value) {
        this.key = key;
        this.value = value;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public Number getValue() {
        return this.value;
    }
    
    public synchronized void setValue(final Number value) {
        this.value = value;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultKeyedValue)) {
            return false;
        }
        final DefaultKeyedValue defaultKeyedValue = (DefaultKeyedValue)o;
        Label_0054: {
            if (this.key != null) {
                if (this.key.equals(defaultKeyedValue.key)) {
                    break Label_0054;
                }
            }
            else if (defaultKeyedValue.key == null) {
                break Label_0054;
            }
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(defaultKeyedValue.value)) {
                return true;
            }
        }
        else if (defaultKeyedValue.value == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 29 * ((this.key != null) ? this.key.hashCode() : 0) + ((this.value != null) ? this.value.hashCode() : 0);
    }
    
    public Object clone() {
        return super.clone();
    }
}
