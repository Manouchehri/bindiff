/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Iterator;

class AbstractMultiset$EntrySet
extends Multisets$EntrySet {
    final /* synthetic */ AbstractMultiset this$0;

    AbstractMultiset$EntrySet(AbstractMultiset abstractMultiset) {
        this.this$0 = abstractMultiset;
    }

    @Override
    Multiset multiset() {
        return this.this$0;
    }

    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    @Override
    public int size() {
        return this.this$0.distinctElements();
    }
}

