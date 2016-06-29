/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactLinkedHashSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class CompactLinkedHashSet$1
implements Iterator {
    int next;
    int toRemove;
    int expectedModCount;
    final /* synthetic */ CompactLinkedHashSet this$0;

    CompactLinkedHashSet$1(CompactLinkedHashSet compactLinkedHashSet) {
        this.this$0 = compactLinkedHashSet;
        this.next = CompactLinkedHashSet.access$000(this.this$0);
        this.toRemove = -1;
        this.expectedModCount = this.this$0.modCount;
    }

    private void checkForConcurrentModification() {
        if (this.this$0.modCount == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }

    @Override
    public boolean hasNext() {
        this.checkForConcurrentModification();
        if (this.next == -2) return false;
        return true;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object = this.this$0.elements[this.next];
        this.toRemove = this.next;
        this.next = CompactLinkedHashSet.access$100(this.this$0)[this.next];
        return object;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != -1);
        this.this$0.remove(this.this$0.elements[this.toRemove]);
        if (this.next == this.this$0.size()) {
            this.next = this.toRemove;
        }
        this.toRemove = -1;
        this.expectedModCount = this.this$0.modCount;
    }
}

