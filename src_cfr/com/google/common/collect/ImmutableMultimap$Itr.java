/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$1;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

abstract class ImmutableMultimap$Itr
extends UnmodifiableIterator {
    final Iterator mapIterator;
    Object key;
    Iterator valueIterator;
    final /* synthetic */ ImmutableMultimap this$0;

    private ImmutableMultimap$Itr(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
        this.mapIterator = this.this$0.asMap().entrySet().iterator();
        this.key = null;
        this.valueIterator = Iterators.emptyIterator();
    }

    abstract Object output(Object var1, Object var2);

    @Override
    public boolean hasNext() {
        if (this.mapIterator.hasNext()) return true;
        if (this.valueIterator.hasNext()) return true;
        return false;
    }

    public Object next() {
        if (this.valueIterator.hasNext()) return this.output(this.key, this.valueIterator.next());
        Map.Entry entry = (Map.Entry)this.mapIterator.next();
        this.key = entry.getKey();
        this.valueIterator = ((Collection)entry.getValue()).iterator();
        return this.output(this.key, this.valueIterator.next());
    }

    /* synthetic */ ImmutableMultimap$Itr(ImmutableMultimap immutableMultimap, ImmutableMultimap$1 immutableMultimap$1) {
        this(immutableMultimap);
    }
}

