/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class CompactHashSet$1
implements Iterator {
    int expectedModCount;
    boolean nextCalled;
    int index;
    final /* synthetic */ CompactHashSet this$0;

    CompactHashSet$1(CompactHashSet compactHashSet) {
        this.this$0 = compactHashSet;
        this.expectedModCount = this.this$0.modCount;
        this.nextCalled = false;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.index >= CompactHashSet.access$000(this.this$0)) return false;
        return true;
    }

    public Object next() {
        this.checkForConcurrentModification();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.nextCalled = true;
        return this.this$0.elements[this.index++];
    }

    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.nextCalled);
        ++this.expectedModCount;
        --this.index;
        CompactHashSet.access$300(this.this$0, this.this$0.elements[this.index], CompactHashSet.access$200(CompactHashSet.access$100(this.this$0)[this.index]));
        this.nextCalled = false;
    }

    private void checkForConcurrentModification() {
        if (this.this$0.modCount == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }
}

