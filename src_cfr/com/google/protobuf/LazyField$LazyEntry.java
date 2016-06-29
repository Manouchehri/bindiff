/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$1;
import com.google.protobuf.MessageLite;
import java.util.Map;

class LazyField$LazyEntry
implements Map.Entry {
    private Map.Entry entry;

    private LazyField$LazyEntry(Map.Entry entry) {
        this.entry = entry;
    }

    public Object getKey() {
        return this.entry.getKey();
    }

    public Object getValue() {
        LazyField lazyField = (LazyField)this.entry.getValue();
        if (lazyField != null) return lazyField.getValue();
        return null;
    }

    public LazyField getField() {
        return (LazyField)this.entry.getValue();
    }

    public Object setValue(Object object) {
        if (object instanceof MessageLite) return ((LazyField)this.entry.getValue()).setValue((MessageLite)object);
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* synthetic */ LazyField$LazyEntry(Map.Entry entry, LazyField$1 lazyField$1) {
        this(entry);
    }
}

