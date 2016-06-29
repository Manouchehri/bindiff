/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.AbstractBiMap$EntrySet$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractBiMap$EntrySet
extends ForwardingSet {
    final Set esDelegate;
    final /* synthetic */ AbstractBiMap this$0;

    private AbstractBiMap$EntrySet(AbstractBiMap abstractBiMap) {
        this.this$0 = abstractBiMap;
        this.esDelegate = AbstractBiMap.access$200(this.this$0).entrySet();
    }

    @Override
    protected Set delegate() {
        return this.esDelegate;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean remove(Object object) {
        if (!this.esDelegate.contains(object)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        AbstractBiMap.access$200(this.this$0.inverse).remove(entry.getValue());
        this.esDelegate.remove(entry);
        return true;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = this.esDelegate.iterator();
        return new AbstractBiMap$EntrySet$1(this, iterator);
    }

    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return this.standardToArray(arrobject);
    }

    @Override
    public boolean contains(Object object) {
        return Maps.containsEntryImpl(this.delegate(), object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.standardContainsAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.standardRetainAll(collection);
    }

    /* synthetic */ AbstractBiMap$EntrySet(AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(abstractBiMap);
    }
}

