package com.google.protobuf;

import java.util.*;

class SmallSortedMap$Entry implements Comparable, Entry
{
    private final Comparable key;
    private Object value;
    final /* synthetic */ SmallSortedMap this$0;
    
    SmallSortedMap$Entry(final SmallSortedMap smallSortedMap, final Entry entry) {
        this(smallSortedMap, entry.getKey(), entry.getValue());
    }
    
    SmallSortedMap$Entry(final SmallSortedMap this$0, final Comparable key, final Object value) {
        this.this$0 = this$0;
        this.key = key;
        this.value = value;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public int compareTo(final SmallSortedMap$Entry smallSortedMap$Entry) {
        return this.getKey().compareTo(smallSortedMap$Entry.getKey());
    }
    
    public Object setValue(final Object value) {
        this.this$0.checkMutable();
        final Object value2 = this.value;
        this.value = value;
        return value2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Entry)) {
            return false;
        }
        final Entry entry = (Entry)o;
        return this.equals(this.key, entry.getKey()) && this.equals(this.value, entry.getValue());
    }
    
    public int hashCode() {
        return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
    }
    
    public String toString() {
        final String value = String.valueOf(String.valueOf(this.key));
        final String value2 = String.valueOf(String.valueOf(this.value));
        return new StringBuilder(1 + value.length() + value2.length()).append(value).append("=").append(value2).toString();
    }
    
    private boolean equals(final Object o, final Object o2) {
        return (o == null) ? (o2 == null) : o.equals(o2);
    }
}
