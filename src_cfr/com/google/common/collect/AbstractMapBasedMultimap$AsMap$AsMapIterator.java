/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractMapBasedMultimap$AsMap$AsMapIterator
implements Iterator {
    final Iterator delegateIterator;
    Collection collection;
    final /* synthetic */ AbstractMapBasedMultimap$AsMap this$1;

    AbstractMapBasedMultimap$AsMap$AsMapIterator(AbstractMapBasedMultimap$AsMap abstractMapBasedMultimap$AsMap) {
        this.this$1 = abstractMapBasedMultimap$AsMap;
        this.delegateIterator = this.this$1.submap.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.delegateIterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry = (Map.Entry)this.delegateIterator.next();
        this.collection = (Collection)entry.getValue();
        return this.this$1.wrapEntry(entry);
    }

    @Override
    public void remove() {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$202(this.this$1.this$0, AbstractMapBasedMultimap.access$200(this.this$1.this$0) - this.collection.size());
        this.collection.clear();
    }
}

