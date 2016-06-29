/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.PublicCloneable;
import org.jfree.util.SortOrder;

public class DefaultPieDataset
extends AbstractDataset
implements Serializable,
Cloneable,
PieDataset,
PublicCloneable {
    private static final long serialVersionUID = 2904745139106540618L;
    private DefaultKeyedValues data;

    public DefaultPieDataset() {
        this.data = new DefaultKeyedValues();
    }

    public DefaultPieDataset(KeyedValues keyedValues) {
        if (keyedValues == null) {
            throw new IllegalArgumentException("Null 'data' argument.");
        }
        this.data = new DefaultKeyedValues();
        int n2 = 0;
        while (n2 < keyedValues.getItemCount()) {
            this.data.addValue(keyedValues.getKey(n2), keyedValues.getValue(n2));
            ++n2;
        }
    }

    @Override
    public int getItemCount() {
        return this.data.getItemCount();
    }

    @Override
    public List getKeys() {
        return Collections.unmodifiableList(this.data.getKeys());
    }

    @Override
    public Comparable getKey(int n2) {
        return this.data.getKey(n2);
    }

    @Override
    public int getIndex(Comparable comparable) {
        return this.data.getIndex(comparable);
    }

    @Override
    public Number getValue(int n2) {
        Number number = null;
        if (this.getItemCount() <= n2) return number;
        return this.data.getValue(n2);
    }

    @Override
    public Number getValue(Comparable comparable) {
        if (comparable != null) return this.data.getValue(comparable);
        throw new IllegalArgumentException("Null 'key' argument.");
    }

    public void setValue(Comparable comparable, Number number) {
        this.data.setValue(comparable, number);
        this.fireDatasetChanged();
    }

    public void setValue(Comparable comparable, double d2) {
        this.setValue(comparable, new Double(d2));
    }

    public void remove(Comparable comparable) {
        this.data.removeValue(comparable);
        this.fireDatasetChanged();
    }

    public void clear() {
        if (this.getItemCount() <= 0) return;
        this.data.clear();
        this.fireDatasetChanged();
    }

    public void sortByKeys(SortOrder sortOrder) {
        this.data.sortByKeys(sortOrder);
        this.fireDatasetChanged();
    }

    public void sortByValues(SortOrder sortOrder) {
        this.data.sortByValues(sortOrder);
        this.fireDatasetChanged();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PieDataset)) {
            return false;
        }
        PieDataset pieDataset = (PieDataset)object;
        int n2 = this.getItemCount();
        if (pieDataset.getItemCount() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable;
            Comparable comparable2 = this.getKey(n3);
            if (!comparable2.equals(comparable = pieDataset.getKey(n3))) {
                return false;
            }
            Number number = this.getValue(n3);
            Number number2 = pieDataset.getValue(n3);
            if (number == null ? number2 != null : !number.equals(number2)) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Override
    public Object clone() {
        DefaultPieDataset defaultPieDataset = (DefaultPieDataset)super.clone();
        defaultPieDataset.data = (DefaultKeyedValues)this.data.clone();
        return defaultPieDataset;
    }
}

