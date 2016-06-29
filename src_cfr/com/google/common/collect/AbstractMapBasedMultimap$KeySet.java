/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$KeySet
extends Maps$KeySet {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$KeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, Map map) {
        this.this$0 = abstractMapBasedMultimap;
        super(map);
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = this.map().entrySet().iterator();
        return new AbstractMapBasedMultimap$KeySet$1(this, iterator);
    }

    @Override
    public boolean remove(Object object) {
        int n2 = 0;
        Collection collection = (Collection)this.map().remove(object);
        if (collection != null) {
            n2 = collection.size();
            collection.clear();
            AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) - n2);
        }
        if (n2 <= 0) return false;
        return true;
    }

    @Override
    public void clear() {
        Iterators.clear(this.iterator());
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.map().keySet().containsAll(collection);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (this.map().keySet().equals(object)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.map().keySet().hashCode();
    }
}

