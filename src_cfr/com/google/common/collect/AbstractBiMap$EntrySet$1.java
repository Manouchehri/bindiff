/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$EntrySet;
import com.google.common.collect.AbstractBiMap$EntrySet$1$1;
import com.google.common.collect.CollectPreconditions;
import java.util.Iterator;
import java.util.Map;

class AbstractBiMap$EntrySet$1
implements Iterator {
    Map.Entry entry;
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ AbstractBiMap$EntrySet this$1;

    AbstractBiMap$EntrySet$1(AbstractBiMap$EntrySet abstractBiMap$EntrySet, Iterator iterator) {
        this.this$1 = abstractBiMap$EntrySet;
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry = this.entry = (Map.Entry)this.val$iterator.next();
        return new AbstractBiMap$EntrySet$1$1(this, entry);
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.entry != null);
        Object v2 = this.entry.getValue();
        this.val$iterator.remove();
        AbstractBiMap.access$700(this.this$1.this$0, v2);
    }
}

