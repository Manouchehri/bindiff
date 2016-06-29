/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class CompactLinkedHashMap$Itr
implements Iterator {
    private int next;
    private int toRemove;
    private int expectedModCount;
    final /* synthetic */ CompactLinkedHashMap this$0;

    private CompactLinkedHashMap$Itr(CompactLinkedHashMap compactLinkedHashMap) {
        this.this$0 = compactLinkedHashMap;
        this.next = CompactLinkedHashMap.access$000(this.this$0);
        this.toRemove = -1;
        this.expectedModCount = this.this$0.modCount;
    }

    private void checkForConcurrentModification() {
        if (this.this$0.modCount == this.expectedModCount) return;
        throw new ConcurrentModificationException();
    }

    @Override
    public boolean hasNext() {
        if (this.next == -2) return false;
        return true;
    }

    abstract Object getOutput(int var1);

    public Object next() {
        this.checkForConcurrentModification();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object = this.getOutput(this.next);
        this.toRemove = this.next;
        this.next = CompactLinkedHashMap.access$100(this.this$0, this.next);
        return object;
    }

    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.toRemove != -1);
        this.this$0.remove(this.this$0.keys[this.toRemove]);
        if (this.next >= this.this$0.size()) {
            this.next = this.toRemove;
        }
        this.expectedModCount = this.this$0.modCount;
        this.toRemove = -1;
    }

    /* synthetic */ CompactLinkedHashMap$Itr(CompactLinkedHashMap compactLinkedHashMap, CompactLinkedHashMap$1 compactLinkedHashMap$1) {
        this(compactLinkedHashMap);
    }
}

