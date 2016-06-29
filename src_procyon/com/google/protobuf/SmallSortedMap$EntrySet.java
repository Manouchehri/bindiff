package com.google.protobuf;

import java.util.*;

class SmallSortedMap$EntrySet extends AbstractSet
{
    final /* synthetic */ SmallSortedMap this$0;
    
    private SmallSortedMap$EntrySet(final SmallSortedMap this$0) {
        this.this$0 = this$0;
    }
    
    public Iterator iterator() {
        return new SmallSortedMap$EntryIterator(this.this$0, null);
    }
    
    public int size() {
        return this.this$0.size();
    }
    
    public boolean contains(final Object o) {
        final Map.Entry entry = (Map.Entry)o;
        final Object value = this.this$0.get(entry.getKey());
        final Object value2 = entry.getValue();
        return value == value2 || (value != null && value.equals(value2));
    }
    
    public boolean add(final Map.Entry entry) {
        if (!this.contains(entry)) {
            this.this$0.put(entry.getKey(), entry.getValue());
            return true;
        }
        return false;
    }
    
    public boolean remove(final Object o) {
        final Map.Entry entry = (Map.Entry)o;
        if (this.contains(entry)) {
            this.this$0.remove(entry.getKey());
            return true;
        }
        return false;
    }
    
    public void clear() {
        this.this$0.clear();
    }
}
