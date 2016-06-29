/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1ValuesImpl;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;
import java.util.Map;

class LinkedListMultimap$1ValuesImpl$1
extends TransformedListIterator {
    final /* synthetic */ LinkedListMultimap$NodeIterator val$nodeItr;
    final /* synthetic */ LinkedListMultimap.1ValuesImpl this$1;

    LinkedListMultimap$1ValuesImpl$1(LinkedListMultimap.1ValuesImpl valuesImpl, ListIterator listIterator, LinkedListMultimap$NodeIterator linkedListMultimap$NodeIterator) {
        this.this$1 = valuesImpl;
        this.val$nodeItr = linkedListMultimap$NodeIterator;
        super(listIterator);
    }

    Object transform(Map.Entry entry) {
        return entry.getValue();
    }

    @Override
    public void set(Object object) {
        this.val$nodeItr.setValue(object);
    }
}

