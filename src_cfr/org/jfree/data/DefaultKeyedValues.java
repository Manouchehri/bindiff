/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparator;
import org.jfree.data.KeyedValueComparatorType;
import org.jfree.data.KeyedValues;
import org.jfree.data.UnknownKeyException;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.SortOrder;

public class DefaultKeyedValues
implements Serializable,
Cloneable,
KeyedValues,
PublicCloneable {
    private static final long serialVersionUID = 8468154364608194797L;
    private List data = new ArrayList();

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public Number getValue(int n2) {
        Number number = null;
        KeyedValue keyedValue = (KeyedValue)this.data.get(n2);
        if (keyedValue == null) return number;
        return keyedValue.getValue();
    }

    @Override
    public Comparable getKey(int n2) {
        Comparable comparable = null;
        KeyedValue keyedValue = (KeyedValue)this.data.get(n2);
        if (keyedValue == null) return comparable;
        return keyedValue.getKey();
    }

    @Override
    public int getIndex(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        int n2 = 0;
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            KeyedValue keyedValue = (KeyedValue)iterator.next();
            if (keyedValue.getKey().equals(comparable)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    @Override
    public List getKeys() {
        ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
        Iterator iterator = this.data.iterator();
        while (iterator.hasNext()) {
            KeyedValue keyedValue = (KeyedValue)iterator.next();
            arrayList.add(keyedValue.getKey());
        }
        return arrayList;
    }

    @Override
    public Number getValue(Comparable comparable) {
        int n2 = this.getIndex(comparable);
        if (n2 >= 0) return this.getValue(n2);
        throw new UnknownKeyException(new StringBuffer().append("Key not found: ").append(comparable).toString());
    }

    public void addValue(Comparable comparable, double d2) {
        this.addValue(comparable, new Double(d2));
    }

    public void addValue(Comparable comparable, Number number) {
        this.setValue(comparable, number);
    }

    public void setValue(Comparable comparable, double d2) {
        this.setValue(comparable, new Double(d2));
    }

    public void setValue(Comparable comparable, Number number) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        int n2 = this.getIndex(comparable);
        if (n2 >= 0) {
            DefaultKeyedValue defaultKeyedValue = (DefaultKeyedValue)this.data.get(n2);
            defaultKeyedValue.setValue(number);
            return;
        }
        DefaultKeyedValue defaultKeyedValue = new DefaultKeyedValue(comparable, number);
        this.data.add(defaultKeyedValue);
    }

    public void removeValue(int n2) {
        this.data.remove(n2);
    }

    public void removeValue(Comparable comparable) {
        int n2 = this.getIndex(comparable);
        if (n2 < 0) return;
        this.removeValue(n2);
    }

    public void clear() {
        this.data.clear();
    }

    public void sortByKeys(SortOrder sortOrder) {
        KeyedValueComparator keyedValueComparator = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, sortOrder);
        Collections.sort(this.data, keyedValueComparator);
    }

    public void sortByValues(SortOrder sortOrder) {
        KeyedValueComparator keyedValueComparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, sortOrder);
        Collections.sort(this.data, keyedValueComparator);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyedValues)) {
            return false;
        }
        KeyedValues keyedValues = (KeyedValues)object;
        int n2 = this.getItemCount();
        if (n2 != keyedValues.getItemCount()) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable;
            Comparable comparable2 = this.getKey(n3);
            if (!comparable2.equals(comparable = keyedValues.getKey(n3))) {
                return false;
            }
            Number number = this.getValue(n3);
            Number number2 = keyedValues.getValue(n3);
            if (number == null ? number2 != null : !number.equals(number2)) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    public int hashCode() {
        if (this.data == null) return 0;
        int n2 = this.data.hashCode();
        return n2;
    }

    @Override
    public Object clone() {
        DefaultKeyedValues defaultKeyedValues = (DefaultKeyedValues)super.clone();
        defaultKeyedValues.data = (List)ObjectUtilities.deepClone(this.data);
        return defaultKeyedValues;
    }
}

