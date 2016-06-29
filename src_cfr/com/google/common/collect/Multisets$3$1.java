/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$3;
import java.util.Iterator;

class Multisets$3$1
extends AbstractIterator {
    final /* synthetic */ Iterator val$iterator1;
    final /* synthetic */ Iterator val$iterator2;
    final /* synthetic */ Multisets$3 this$0;

    Multisets$3$1(Multisets$3 var1_1, Iterator iterator, Iterator iterator2) {
        this.this$0 = var1_1;
        this.val$iterator1 = iterator;
        this.val$iterator2 = iterator2;
    }

    @Override
    protected Multiset$Entry computeNext() {
        Multiset$Entry multiset$Entry;
        Object object;
        if (this.val$iterator1.hasNext()) {
            Multiset$Entry multiset$Entry2 = (Multiset$Entry)this.val$iterator1.next();
            Object object2 = multiset$Entry2.getElement();
            int n2 = multiset$Entry2.getCount() + this.this$0.val$multiset2.count(object2);
            return Multisets.immutableEntry(object2, n2);
        }
        do {
            if (!this.val$iterator2.hasNext()) return (Multiset$Entry)this.endOfData();
        } while (this.this$0.val$multiset1.contains(object = (multiset$Entry = (Multiset$Entry)this.val$iterator2.next()).getElement()));
        return Multisets.immutableEntry(object, multiset$Entry.getCount());
    }
}

