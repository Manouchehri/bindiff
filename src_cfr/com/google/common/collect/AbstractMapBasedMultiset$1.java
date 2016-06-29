/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.AbstractMapBasedMultiset$1$1;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;
import java.util.Map;

class AbstractMapBasedMultiset$1
implements Iterator {
    Map.Entry toRemove;
    final /* synthetic */ Iterator val$backingEntries;
    final /* synthetic */ AbstractMapBasedMultiset this$0;

    AbstractMapBasedMultiset$1(AbstractMapBasedMultiset abstractMapBasedMultiset, Iterator iterator) {
        this.this$0 = abstractMapBasedMultiset;
        this.val$backingEntries = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$backingEntries.hasNext();
    }

    public Multiset$Entry next() {
        Map.Entry entry;
        this.toRemove = entry = (Map.Entry)this.val$backingEntries.next();
        return new AbstractMapBasedMultiset$1$1(this, entry);
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != null);
        AbstractMapBasedMultiset.access$102(this.this$0, AbstractMapBasedMultiset.access$100(this.this$0) - (long)((Count)this.toRemove.getValue()).getAndSet(0));
        this.val$backingEntries.remove();
        this.toRemove = null;
    }
}

