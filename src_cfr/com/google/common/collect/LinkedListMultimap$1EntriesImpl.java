/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

class LinkedListMultimap$1EntriesImpl
extends AbstractSequentialList {
    final /* synthetic */ LinkedListMultimap this$0;

    LinkedListMultimap$1EntriesImpl(LinkedListMultimap linkedListMultimap) {
        this.this$0 = linkedListMultimap;
    }

    @Override
    public int size() {
        return LinkedListMultimap.access$900(this.this$0);
    }

    @Override
    public ListIterator listIterator(int n2) {
        return new LinkedListMultimap$NodeIterator(this.this$0, n2);
    }
}

