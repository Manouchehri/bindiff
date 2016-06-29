/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import com.google.protobuf.Internal$MapAdapter$EntryAdapter;
import java.util.Iterator;
import java.util.Map;

class Internal$MapAdapter$IteratorAdapter
implements Iterator {
    private final Iterator realIterator;
    final /* synthetic */ Internal$MapAdapter this$0;

    public Internal$MapAdapter$IteratorAdapter(Internal$MapAdapter internal$MapAdapter, Iterator iterator) {
        this.this$0 = internal$MapAdapter;
        this.realIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.realIterator.hasNext();
    }

    public Map.Entry next() {
        return new Internal$MapAdapter$EntryAdapter(this.this$0, (Map.Entry)this.realIterator.next());
    }

    @Override
    public void remove() {
        this.realIterator.remove();
    }
}

