/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class AbstractMapBasedMultimap$Itr
implements Iterator {
    final Iterator keyIterator;
    Object key;
    Collection collection;
    Iterator valueIterator;
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$Itr(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        this.this$0 = abstractMapBasedMultimap;
        this.keyIterator = AbstractMapBasedMultimap.access$000(abstractMapBasedMultimap).entrySet().iterator();
        this.key = null;
        this.collection = null;
        this.valueIterator = Iterators.emptyModifiableIterator();
    }

    abstract Object output(Object var1, Object var2);

    @Override
    public boolean hasNext() {
        if (this.keyIterator.hasNext()) return true;
        if (this.valueIterator.hasNext()) return true;
        return false;
    }

    public Object next() {
        if (this.valueIterator.hasNext()) return this.output(this.key, this.valueIterator.next());
        Map.Entry entry = (Map.Entry)this.keyIterator.next();
        this.key = entry.getKey();
        this.collection = (Collection)entry.getValue();
        this.valueIterator = this.collection.iterator();
        return this.output(this.key, this.valueIterator.next());
    }

    @Override
    public void remove() {
        this.valueIterator.remove();
        if (this.collection.isEmpty()) {
            this.keyIterator.remove();
        }
        AbstractMapBasedMultimap.access$210(this.this$0);
    }
}

