/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class CompactHashMap$Itr
implements Iterator {
    int expectedModCount;
    boolean nextCalled;
    int index;
    final /* synthetic */ CompactHashMap this$0;

    private CompactHashMap$Itr(CompactHashMap compactHashMap) {
        this.this$0 = compactHashMap;
        this.expectedModCount = this.this$0.modCount;
        this.nextCalled = false;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.index >= CompactHashMap.access$000(this.this$0)) return false;
        return true;
    }

    abstract Object getOutput(int var1);

    public Object next() {
        this.checkForConcurrentModification();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.nextCalled = true;
        return this.getOutput(this.index++);
    }

    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.nextCalled);
        ++this.expectedModCount;
        --this.index;
        CompactHashMap.access$100(this.this$0, this.index);
        this.nextCalled = false;
    }

    private void checkForConcurrentModification() {
        if (this.this$0.modCount == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }

    /* synthetic */ CompactHashMap$Itr(CompactHashMap compactHashMap, CompactHashMap$1 compactHashMap$1) {
        this(compactHashMap);
    }
}

