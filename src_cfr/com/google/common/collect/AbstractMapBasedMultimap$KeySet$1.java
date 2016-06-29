/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import com.google.common.collect.CollectPreconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class AbstractMapBasedMultimap$KeySet$1
implements Iterator {
    Map.Entry entry;
    final /* synthetic */ Iterator val$entryIterator;
    final /* synthetic */ AbstractMapBasedMultimap$KeySet this$1;

    AbstractMapBasedMultimap$KeySet$1(AbstractMapBasedMultimap$KeySet keySet, Iterator iterator) {
        this.this$1 = keySet;
        this.val$entryIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }

    public Object next() {
        this.entry = (Map.Entry)this.val$entryIterator.next();
        return this.entry.getKey();
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.entry != null);
        Collection collection = (Collection)this.entry.getValue();
        this.val$entryIterator.remove();
        AbstractMapBasedMultimap.access$202(this.this$1.this$0, AbstractMapBasedMultimap.access$200(this.this$1.this$0) - collection.size());
        collection.clear();
    }
}

