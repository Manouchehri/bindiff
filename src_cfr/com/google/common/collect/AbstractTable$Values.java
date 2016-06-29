/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import java.util.AbstractCollection;
import java.util.Iterator;

class AbstractTable$Values
extends AbstractCollection {
    final /* synthetic */ AbstractTable this$0;

    AbstractTable$Values(AbstractTable abstractTable) {
        this.this$0 = abstractTable;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.valuesIterator();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsValue(object);
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public int size() {
        return this.this$0.size();
    }
}

