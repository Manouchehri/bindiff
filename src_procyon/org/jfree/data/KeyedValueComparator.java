package org.jfree.data;

import java.util.*;
import org.jfree.util.*;

public class KeyedValueComparator implements Comparator
{
    private KeyedValueComparatorType type;
    private SortOrder order;
    
    public KeyedValueComparator(final KeyedValueComparatorType type, final SortOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Null 'order' argument.");
        }
        this.type = type;
        this.order = order;
    }
    
    public KeyedValueComparatorType getType() {
        return this.type;
    }
    
    public SortOrder getOrder() {
        return this.order;
    }
    
    public int compare(final Object o, final Object o2) {
        if (o2 == null) {
            return -1;
        }
        if (o == null) {
            return 1;
        }
        final KeyedValue keyedValue = (KeyedValue)o;
        final KeyedValue keyedValue2 = (KeyedValue)o2;
        int n;
        if (this.type == KeyedValueComparatorType.BY_KEY) {
            if (this.order.equals(SortOrder.ASCENDING)) {
                n = keyedValue.getKey().compareTo(keyedValue2.getKey());
            }
            else {
                if (!this.order.equals(SortOrder.DESCENDING)) {
                    throw new IllegalArgumentException("Unrecognised sort order.");
                }
                n = keyedValue2.getKey().compareTo(keyedValue.getKey());
            }
        }
        else {
            if (this.type != KeyedValueComparatorType.BY_VALUE) {
                throw new IllegalArgumentException("Unrecognised type.");
            }
            final Number value = keyedValue.getValue();
            final Number value2 = keyedValue2.getValue();
            if (value2 == null) {
                return -1;
            }
            if (value == null) {
                return 1;
            }
            final double doubleValue = value.doubleValue();
            final double doubleValue2 = value2.doubleValue();
            if (this.order.equals(SortOrder.ASCENDING)) {
                if (doubleValue > doubleValue2) {
                    n = 1;
                }
                else if (doubleValue < doubleValue2) {
                    n = -1;
                }
                else {
                    n = 0;
                }
            }
            else {
                if (!this.order.equals(SortOrder.DESCENDING)) {
                    throw new IllegalArgumentException("Unrecognised sort order.");
                }
                if (doubleValue > doubleValue2) {
                    n = -1;
                }
                else if (doubleValue < doubleValue2) {
                    n = 1;
                }
                else {
                    n = 0;
                }
            }
        }
        return n;
    }
}
