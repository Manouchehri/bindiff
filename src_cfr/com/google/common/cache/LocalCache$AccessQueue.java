/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AccessQueue$1;
import com.google.common.cache.LocalCache$AccessQueue$2;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$AccessQueue
extends AbstractQueue {
    final LocalCache$ReferenceEntry head;

    LocalCache$AccessQueue() {
        this.head = new LocalCache$AccessQueue$1(this);
    }

    @Override
    public boolean offer(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache.connectAccessOrder(localCache$ReferenceEntry.getPreviousInAccessQueue(), localCache$ReferenceEntry.getNextInAccessQueue());
        LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), localCache$ReferenceEntry);
        LocalCache.connectAccessOrder(localCache$ReferenceEntry, this.head);
        return true;
    }

    @Override
    public LocalCache$ReferenceEntry peek() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInAccessQueue();
        if (localCache$ReferenceEntry == this.head) {
            return null;
        }
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry;
        return localCache$ReferenceEntry2;
    }

    @Override
    public LocalCache$ReferenceEntry poll() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInAccessQueue();
        if (localCache$ReferenceEntry == this.head) {
            return null;
        }
        this.remove(localCache$ReferenceEntry);
        return localCache$ReferenceEntry;
    }

    @Override
    public boolean remove(Object object) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)object;
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getPreviousInAccessQueue();
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry.getNextInAccessQueue();
        LocalCache.connectAccessOrder(localCache$ReferenceEntry2, localCache$ReferenceEntry3);
        LocalCache.nullifyAccessOrder(localCache$ReferenceEntry);
        if (localCache$ReferenceEntry3 == LocalCache$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)object;
        if (localCache$ReferenceEntry.getNextInAccessQueue() == LocalCache$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (this.head.getNextInAccessQueue() != this.head) return false;
        return true;
    }

    @Override
    public int size() {
        int n2 = 0;
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInAccessQueue();
        while (localCache$ReferenceEntry != this.head) {
            ++n2;
            localCache$ReferenceEntry = localCache$ReferenceEntry.getNextInAccessQueue();
        }
        return n2;
    }

    @Override
    public void clear() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInAccessQueue();
        do {
            if (localCache$ReferenceEntry == this.head) {
                this.head.setNextInAccessQueue(this.head);
                this.head.setPreviousInAccessQueue(this.head);
                return;
            }
            LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getNextInAccessQueue();
            LocalCache.nullifyAccessOrder(localCache$ReferenceEntry);
            localCache$ReferenceEntry = localCache$ReferenceEntry2;
        } while (true);
    }

    @Override
    public Iterator iterator() {
        return new LocalCache$AccessQueue$2(this, this.peek());
    }
}

