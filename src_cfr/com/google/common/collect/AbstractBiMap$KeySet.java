/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class AbstractBiMap$KeySet
extends ForwardingSet {
    final /* synthetic */ AbstractBiMap this$0;

    private AbstractBiMap$KeySet(AbstractBiMap abstractBiMap) {
        this.this$0 = abstractBiMap;
    }

    @Override
    protected Set delegate() {
        return AbstractBiMap.access$200(this.this$0).keySet();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) {
            return false;
        }
        AbstractBiMap.access$300(this.this$0, object);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.standardRetainAll(collection);
    }

    @Override
    public Iterator iterator() {
        return Maps.keyIterator(this.this$0.entrySet().iterator());
    }

    /* synthetic */ AbstractBiMap$KeySet(AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(abstractBiMap);
    }
}

