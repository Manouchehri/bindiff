/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SmallSortedMap$EntryIterator
implements Iterator {
    private int pos;
    private boolean nextCalledBeforeRemove;
    private Iterator lazyOverflowIterator;
    final /* synthetic */ SmallSortedMap this$0;

    private SmallSortedMap$EntryIterator(SmallSortedMap smallSortedMap) {
        this.this$0 = smallSortedMap;
        this.pos = -1;
    }

    @Override
    public boolean hasNext() {
        if (this.pos + 1 < SmallSortedMap.access$400(this.this$0).size()) return true;
        if (this.getOverflowIterator().hasNext()) return true;
        return false;
    }

    public Map.Entry next() {
        this.nextCalledBeforeRemove = true;
        if (++this.pos >= SmallSortedMap.access$400(this.this$0).size()) return (Map.Entry)this.getOverflowIterator().next();
        return (Map.Entry)SmallSortedMap.access$400(this.this$0).get(this.pos);
    }

    @Override
    public void remove() {
        if (!this.nextCalledBeforeRemove) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.nextCalledBeforeRemove = false;
        SmallSortedMap.access$200(this.this$0);
        if (this.pos < SmallSortedMap.access$400(this.this$0).size()) {
            SmallSortedMap.access$500(this.this$0, this.pos--);
            return;
        }
        this.getOverflowIterator().remove();
    }

    private Iterator getOverflowIterator() {
        if (this.lazyOverflowIterator != null) return this.lazyOverflowIterator;
        this.lazyOverflowIterator = SmallSortedMap.access$600(this.this$0).entrySet().iterator();
        return this.lazyOverflowIterator;
    }

    /* synthetic */ SmallSortedMap$EntryIterator(SmallSortedMap smallSortedMap, SmallSortedMap$1 smallSortedMap$1) {
        this(smallSortedMap);
    }
}

