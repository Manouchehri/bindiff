/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$WriteQueue$1;
import com.google.common.cache.LocalCache$WriteQueue$2;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$WriteQueue
extends AbstractQueue {
    final LocalCache$ReferenceEntry head;

    LocalCache$WriteQueue() {
        this.head = new LocalCache$WriteQueue$1(this);
    }

    @Override
    public boolean offer(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache.connectWriteOrder(localCache$ReferenceEntry.getPreviousInWriteQueue(), localCache$ReferenceEntry.getNextInWriteQueue());
        LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), localCache$ReferenceEntry);
        LocalCache.connectWriteOrder(localCache$ReferenceEntry, this.head);
        return true;
    }

    @Override
    public LocalCache$ReferenceEntry peek() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInWriteQueue();
        if (localCache$ReferenceEntry == this.head) {
            return null;
        }
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry;
        return localCache$ReferenceEntry2;
    }

    @Override
    public LocalCache$ReferenceEntry poll() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInWriteQueue();
        if (localCache$ReferenceEntry == this.head) {
            return null;
        }
        this.remove(localCache$ReferenceEntry);
        return localCache$ReferenceEntry;
    }

    @Override
    public boolean remove(Object object) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)object;
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getPreviousInWriteQueue();
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry.getNextInWriteQueue();
        LocalCache.connectWriteOrder(localCache$ReferenceEntry2, localCache$ReferenceEntry3);
        LocalCache.nullifyWriteOrder(localCache$ReferenceEntry);
        if (localCache$ReferenceEntry3 == LocalCache$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)object;
        if (localCache$ReferenceEntry.getNextInWriteQueue() == LocalCache$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (this.head.getNextInWriteQueue() != this.head) return false;
        return true;
    }

    @Override
    public int size() {
        int n2 = 0;
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInWriteQueue();
        while (localCache$ReferenceEntry != this.head) {
            ++n2;
            localCache$ReferenceEntry = localCache$ReferenceEntry.getNextInWriteQueue();
        }
        return n2;
    }

    @Override
    public void clear() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInWriteQueue();
        do {
            if (localCache$ReferenceEntry == this.head) {
                this.head.setNextInWriteQueue(this.head);
                this.head.setPreviousInWriteQueue(this.head);
                return;
            }
            LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getNextInWriteQueue();
            LocalCache.nullifyWriteOrder(localCache$ReferenceEntry);
            localCache$ReferenceEntry = localCache$ReferenceEntry2;
        } while (true);
    }

    @Override
    public Iterator iterator() {
        return new LocalCache$WriteQueue$2(this, this.peek());
    }
}

