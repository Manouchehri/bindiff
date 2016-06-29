/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$2;
import java.util.Iterator;

class Multisets$2$1
extends AbstractIterator {
    final /* synthetic */ Iterator val$iterator1;
    final /* synthetic */ Multisets$2 this$0;

    Multisets$2$1(Multisets$2 var1_1, Iterator iterator) {
        this.this$0 = var1_1;
        this.val$iterator1 = iterator;
    }

    @Override
    protected Multiset$Entry computeNext() {
        Object object;
        Multiset$Entry multiset$Entry;
        int n2;
        do {
            if (!this.val$iterator1.hasNext()) return (Multiset$Entry)this.endOfData();
            multiset$Entry = (Multiset$Entry)this.val$iterator1.next();
            object = multiset$Entry.getElement();
        } while ((n2 = Math.min(multiset$Entry.getCount(), this.this$0.val$multiset2.count(object))) <= 0);
        return Multisets.immutableEntry(object, n2);
    }
}

