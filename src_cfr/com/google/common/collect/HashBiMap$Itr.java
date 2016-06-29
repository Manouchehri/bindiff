/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$BiEntry;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class HashBiMap$Itr
implements Iterator {
    HashBiMap$BiEntry next;
    HashBiMap$BiEntry toRemove;
    int expectedModCount;
    final /* synthetic */ HashBiMap this$0;

    HashBiMap$Itr(HashBiMap hashBiMap) {
        this.this$0 = hashBiMap;
        this.next = HashBiMap.access$000(this.this$0);
        this.toRemove = null;
        this.expectedModCount = HashBiMap.access$100(this.this$0);
    }

    @Override
    public boolean hasNext() {
        if (HashBiMap.access$100(this.this$0) != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        if (this.next == null) return false;
        return true;
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        HashBiMap$BiEntry hashBiMap$BiEntry = this.next;
        this.next = hashBiMap$BiEntry.nextInKeyInsertionOrder;
        this.toRemove = hashBiMap$BiEntry;
        return this.output(hashBiMap$BiEntry);
    }

    @Override
    public void remove() {
        if (HashBiMap.access$100(this.this$0) != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        CollectPreconditions.checkRemove(this.toRemove != null);
        HashBiMap.access$200(this.this$0, this.toRemove);
        this.expectedModCount = HashBiMap.access$100(this.this$0);
        this.toRemove = null;
    }

    abstract Object output(HashBiMap$BiEntry var1);
}

