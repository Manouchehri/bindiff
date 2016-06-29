/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.io.Serializable;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.KeyedValueDataset;
import org.jfree.util.ObjectUtilities;

public class DefaultKeyedValueDataset
extends AbstractDataset
implements Serializable,
KeyedValueDataset {
    private static final long serialVersionUID = -8149484339560406750L;
    private KeyedValue data;

    public DefaultKeyedValueDataset() {
        this(null);
    }

    public DefaultKeyedValueDataset(Comparable comparable, Number number) {
        this(new DefaultKeyedValue(comparable, number));
    }

    public DefaultKeyedValueDataset(KeyedValue keyedValue) {
        this.data = keyedValue;
    }

    @Override
    public Comparable getKey() {
        Comparable comparable = null;
        if (this.data == null) return comparable;
        return this.data.getKey();
    }

    @Override
    public Number getValue() {
        Number number = null;
        if (this.data == null) return number;
        return this.data.getValue();
    }

    public void updateValue(Number number) {
        if (this.data == null) {
            throw new RuntimeException("updateValue: can't update null.");
        }
        this.setValue(this.data.getKey(), number);
    }

    public void setValue(Comparable comparable, Number number) {
        this.data = new DefaultKeyedValue(comparable, number);
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyedValueDataset)) {
            return false;
        }
        KeyedValueDataset keyedValueDataset = (KeyedValueDataset)object;
        if (this.data == null) {
            if (keyedValueDataset.getKey() != null) return false;
            if (keyedValueDataset.getValue() == null) return true;
            return false;
        }
        if (!ObjectUtilities.equal(this.data.getKey(), keyedValueDataset.getKey())) {
            return false;
        }
        if (ObjectUtilities.equal(this.data.getValue(), keyedValueDataset.getValue())) return true;
        return false;
    }

    public int hashCode() {
        if (this.data == null) return 0;
        int n2 = this.data.hashCode();
        return n2;
    }

    @Override
    public Object clone() {
        return (DefaultKeyedValueDataset)super.clone();
    }
}

