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

class AbstractBiMap$ValueSet
extends ForwardingSet {
    final Set valuesDelegate;
    final /* synthetic */ AbstractBiMap this$0;

    private AbstractBiMap$ValueSet(AbstractBiMap abstractBiMap) {
        this.this$0 = abstractBiMap;
        this.valuesDelegate = this.this$0.inverse.keySet();
    }

    @Override
    protected Set delegate() {
        return this.valuesDelegate;
    }

    @Override
    public Iterator iterator() {
        return Maps.valueIterator(this.this$0.entrySet().iterator());
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
    public String toString() {
        return this.standardToString();
    }

    /* synthetic */ AbstractBiMap$ValueSet(AbstractBiMap abstractBiMap, AbstractBiMap$1 abstractBiMap$1) {
        this(abstractBiMap);
    }
}

