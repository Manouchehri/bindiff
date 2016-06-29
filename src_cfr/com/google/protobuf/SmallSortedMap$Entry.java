/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import java.util.Map;

class SmallSortedMap$Entry
implements Comparable,
Map.Entry {
    private final Comparable key;
    private Object value;
    final /* synthetic */ SmallSortedMap this$0;

    SmallSortedMap$Entry(SmallSortedMap smallSortedMap, Map.Entry entry) {
        this(smallSortedMap, (Comparable)entry.getKey(), entry.getValue());
    }

    SmallSortedMap$Entry(SmallSortedMap smallSortedMap, Comparable comparable, Object object) {
        this.this$0 = smallSortedMap;
        this.key = comparable;
        this.value = object;
    }

    public Comparable getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int compareTo(SmallSortedMap$Entry smallSortedMap$Entry) {
        return this.getKey().compareTo(smallSortedMap$Entry.getKey());
    }

    public Object setValue(Object object) {
        SmallSortedMap.access$200(this.this$0);
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        if (!this.equals(this.key, entry.getKey())) return false;
        if (!this.equals(this.value, entry.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int n2;
        int n3 = this.key == null ? 0 : this.key.hashCode();
        if (this.value == null) {
            n2 = 0;
            return n3 ^ n2;
        }
        n2 = this.value.hashCode();
        return n3 ^ n2;
    }

    public String toString() {
        String string = String.valueOf(String.valueOf(this.key));
        String string2 = String.valueOf(String.valueOf(this.value));
        return new StringBuilder(1 + string.length() + string2.length()).append(string).append("=").append(string2).toString();
    }

    private boolean equals(Object object, Object object2) {
        if (object != null) {
            boolean bl2 = object.equals(object2);
            return bl2;
        }
        if (object2 != null) return false;
        return true;
    }
}

