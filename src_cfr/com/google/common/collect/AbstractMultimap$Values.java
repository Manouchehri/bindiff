/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import java.util.AbstractCollection;
import java.util.Iterator;
import javax.annotation.Nullable;

class AbstractMultimap$Values
extends AbstractCollection {
    final /* synthetic */ AbstractMultimap this$0;

    AbstractMultimap$Values(AbstractMultimap abstractMultimap) {
        this.this$0 = abstractMultimap;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.valueIterator();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.this$0.containsValue(object);
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

