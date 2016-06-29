/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import org.jfree.data.KeyedValue;
import org.jfree.util.PublicCloneable;

public class DefaultKeyedValue
implements Serializable,
Cloneable,
KeyedValue,
PublicCloneable {
    private static final long serialVersionUID = -7388924517460437712L;
    private Comparable key;
    private Number value;

    public DefaultKeyedValue(Comparable comparable, Number number) {
        this.key = comparable;
        this.value = number;
    }

    @Override
    public Comparable getKey() {
        return this.key;
    }

    @Override
    public Number getValue() {
        return this.value;
    }

    public synchronized void setValue(Number number) {
        this.value = number;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultKeyedValue)) {
            return false;
        }
        DefaultKeyedValue defaultKeyedValue = (DefaultKeyedValue)object;
        if (this.key != null ? !this.key.equals(defaultKeyedValue.key) : defaultKeyedValue.key != null) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(defaultKeyedValue.value)) return true;
            return false;
        }
        if (defaultKeyedValue.value == null) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.key != null ? this.key.hashCode() : 0;
        return 29 * n2 + (this.value != null ? this.value.hashCode() : 0);
    }

    @Override
    public Object clone() {
        return (DefaultKeyedValue)super.clone();
    }
}

