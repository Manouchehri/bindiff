/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$4;
import java.util.Iterator;
import java.util.Set;

class Sets$4$1
extends AbstractIterator {
    final /* synthetic */ Iterator val$itr1;
    final /* synthetic */ Iterator val$itr2;
    final /* synthetic */ Sets$4 this$0;

    Sets$4$1(Sets$4 var1_1, Iterator iterator, Iterator iterator2) {
        this.this$0 = var1_1;
        this.val$itr1 = iterator;
        this.val$itr2 = iterator2;
    }

    @Override
    public Object computeNext() {
        Object e2;
        while (this.val$itr1.hasNext()) {
            e2 = this.val$itr1.next();
            if (this.this$0.val$set2.contains(e2)) continue;
            return e2;
        }
        do {
            if (!this.val$itr2.hasNext()) return this.endOfData();
        } while (this.this$0.val$set1.contains(e2 = this.val$itr2.next()));
        return e2;
    }
}

