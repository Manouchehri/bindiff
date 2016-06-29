/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.io.Serializable;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.ValueDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class DefaultValueDataset
extends AbstractDataset
implements Serializable,
Cloneable,
ValueDataset,
PublicCloneable {
    private static final long serialVersionUID = 8137521217249294891L;
    private Number value;

    public DefaultValueDataset() {
        this(null);
    }

    public DefaultValueDataset(double d2) {
        this(new Double(d2));
    }

    public DefaultValueDataset(Number number) {
        this.value = number;
    }

    @Override
    public Number getValue() {
        return this.value;
    }

    public void setValue(Number number) {
        this.value = number;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ValueDataset)) return false;
        ValueDataset valueDataset = (ValueDataset)object;
        return ObjectUtilities.equal(this.value, valueDataset.getValue());
    }

    public int hashCode() {
        if (this.value == null) return 0;
        int n2 = this.value.hashCode();
        return n2;
    }
}

