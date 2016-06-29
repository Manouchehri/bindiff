/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class ImmutableMultiset$1
extends UnmodifiableIterator {
    int remaining;
    Object element;
    final /* synthetic */ Iterator val$entryIterator;
    final /* synthetic */ ImmutableMultiset this$0;

    ImmutableMultiset$1(ImmutableMultiset immutableMultiset, Iterator iterator) {
        this.this$0 = immutableMultiset;
        this.val$entryIterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (this.remaining > 0) return true;
        if (this.val$entryIterator.hasNext()) return true;
        return false;
    }

    public Object next() {
        if (this.remaining <= 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)this.val$entryIterator.next();
            this.element = multiset$Entry.getElement();
            this.remaining = multiset$Entry.getCount();
        }
        --this.remaining;
        return this.element;
    }
}

