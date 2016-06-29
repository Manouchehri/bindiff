/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.util.Comparator;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparatorType;
import org.jfree.util.SortOrder;

public class KeyedValueComparator
implements Comparator {
    private KeyedValueComparatorType type;
    private SortOrder order;

    public KeyedValueComparator(KeyedValueComparatorType keyedValueComparatorType, SortOrder sortOrder) {
        if (sortOrder == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.type = keyedValueComparatorType;
        this.order = sortOrder;
    }

    public KeyedValueComparatorType getType() {
        return this.type;
    }

    public SortOrder getOrder() {
        return this.order;
    }

    public int compare(Object object, Object object2) {
        if (object2 == null) {
            return -1;
        }
        if (object == null) {
            return 1;
        }
        KeyedValue keyedValue = (KeyedValue)object;
        KeyedValue keyedValue2 = (KeyedValue)object2;
        if (this.type == KeyedValueComparatorType.BY_KEY) {
            if (this.order.equals(SortOrder.ASCENDING)) {
                return keyedValue.getKey().compareTo(keyedValue2.getKey());
            }
            if (!this.order.equals(SortOrder.DESCENDING)) throw new IllegalArgumentException("Unrecognised sort order.");
            return keyedValue2.getKey().compareTo(keyedValue.getKey());
        }
        if (this.type != KeyedValueComparatorType.BY_VALUE) throw new IllegalArgumentException("Unrecognised type.");
        Number number = keyedValue.getValue();
        Number number2 = keyedValue2.getValue();
        if (number2 == null) {
            return -1;
        }
        if (number == null) {
            return 1;
        }
        double d2 = number.doubleValue();
        double d3 = number2.doubleValue();
        if (this.order.equals(SortOrder.ASCENDING)) {
            if (d2 > d3) {
                return 1;
            }
            if (d2 >= d3) return 0;
            return -1;
        }
        if (!this.order.equals(SortOrder.DESCENDING)) throw new IllegalArgumentException("Unrecognised sort order.");
        if (d2 > d3) {
            return -1;
        }
        if (d2 >= d3) return 0;
        return 1;
    }
}

