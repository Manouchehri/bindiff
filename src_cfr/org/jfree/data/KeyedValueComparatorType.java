/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

public final class KeyedValueComparatorType {
    public static final KeyedValueComparatorType BY_KEY = new KeyedValueComparatorType("KeyedValueComparatorType.BY_KEY");
    public static final KeyedValueComparatorType BY_VALUE = new KeyedValueComparatorType("KeyedValueComparatorType.BY_VALUE");
    private String name;

    private KeyedValueComparatorType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof KeyedValueComparatorType)) {
            return false;
        }
        KeyedValueComparatorType keyedValueComparatorType = (KeyedValueComparatorType)object;
        if (this.name.equals(keyedValueComparatorType.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}

