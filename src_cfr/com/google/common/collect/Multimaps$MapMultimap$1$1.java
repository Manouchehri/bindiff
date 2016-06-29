/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multimaps$MapMultimap;
import com.google.common.collect.Multimaps$MapMultimap$1;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

class Multimaps$MapMultimap$1$1
implements Iterator {
    int i;
    final /* synthetic */ Multimaps$MapMultimap$1 this$1;

    Multimaps$MapMultimap$1$1(Multimaps$MapMultimap$1 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public boolean hasNext() {
        if (this.i != 0) return false;
        if (!this.this$1.this$0.map.containsKey(this.this$1.val$key)) return false;
        return true;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.i;
        return this.this$1.this$0.map.get(this.this$1.val$key);
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.i == 1);
        this.i = -1;
        this.this$1.this$0.map.remove(this.this$1.val$key);
    }
}

