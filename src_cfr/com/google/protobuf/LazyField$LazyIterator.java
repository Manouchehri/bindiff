/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$1;
import com.google.protobuf.LazyField$LazyEntry;
import java.util.Iterator;
import java.util.Map;

class LazyField$LazyIterator
implements Iterator {
    private Iterator iterator;

    public LazyField$LazyIterator(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry = (Map.Entry)this.iterator.next();
        if (!(entry.getValue() instanceof LazyField)) return entry;
        return new LazyField$LazyEntry(entry, null);
    }

    @Override
    public void remove() {
        this.iterator.remove();
    }
}

