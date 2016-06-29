/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.AbstractMapBasedMultiset$1;
import com.google.common.collect.Count;
import com.google.common.collect.Multisets$AbstractEntry;
import java.util.Map;

class AbstractMapBasedMultiset$1$1
extends Multisets$AbstractEntry {
    final /* synthetic */ Map.Entry val$mapEntry;
    final /* synthetic */ AbstractMapBasedMultiset$1 this$1;

    AbstractMapBasedMultiset$1$1(AbstractMapBasedMultiset$1 var1_1, Map.Entry entry) {
        this.this$1 = var1_1;
        this.val$mapEntry = entry;
    }

    @Override
    public Object getElement() {
        return this.val$mapEntry.getKey();
    }

    @Override
    public int getCount() {
        Count count;
        Count count2 = (Count)this.val$mapEntry.getValue();
        if ((count2 == null || count2.get() == 0) && (count = (Count)AbstractMapBasedMultiset.access$000(this.this$1.this$0).get(this.getElement())) != null) {
            return count.get();
        }
        if (count2 == null) {
            return 0;
        }
        int n2 = count2.get();
        return n2;
    }
}

