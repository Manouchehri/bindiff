/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$DistinctKeyIterator;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Iterator;
import java.util.List;

class LinkedListMultimap$1KeySetImpl
extends Sets$ImprovedAbstractSet {
    final /* synthetic */ LinkedListMultimap this$0;

    LinkedListMultimap$1KeySetImpl(LinkedListMultimap linkedListMultimap) {
        this.this$0 = linkedListMultimap;
    }

    @Override
    public int size() {
        return LinkedListMultimap.access$600(this.this$0).size();
    }

    @Override
    public Iterator iterator() {
        return new LinkedListMultimap$DistinctKeyIterator(this.this$0, null);
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        if (this.this$0.removeAll(object).isEmpty()) return false;
        return true;
    }
}

