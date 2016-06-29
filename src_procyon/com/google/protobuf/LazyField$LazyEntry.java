package com.google.protobuf;

import java.util.*;

class LazyField$LazyEntry implements Entry
{
    private Entry entry;
    
    private LazyField$LazyEntry(final Entry entry) {
        this.entry = entry;
    }
    
    public Object getKey() {
        return this.entry.getKey();
    }
    
    public Object getValue() {
        final LazyField lazyField = this.entry.getValue();
        if (lazyField == null) {
            return null;
        }
        return lazyField.getValue();
    }
    
    public LazyField getField() {
        return this.entry.getValue();
    }
    
    public Object setValue(final Object o) {
        if (!(o instanceof MessageLite)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.entry.getValue().setValue((MessageLite)o);
    }
}
