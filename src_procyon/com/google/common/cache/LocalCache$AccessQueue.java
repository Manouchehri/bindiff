package com.google.common.cache;

import java.util.*;

final class LocalCache$AccessQueue extends AbstractQueue
{
    final LocalCache$ReferenceEntry head;
    
    LocalCache$AccessQueue() {
        this.head = new LocalCache$AccessQueue$1(this);
    }
    
    public boolean offer(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache.connectAccessOrder(localCache$ReferenceEntry.getPreviousInAccessQueue(), localCache$ReferenceEntry.getNextInAccessQueue());
        LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), localCache$ReferenceEntry);
        LocalCache.connectAccessOrder(localCache$ReferenceEntry, this.head);
        return true;
    }
    
    @Override
    public LocalCache$ReferenceEntry peek() {
        final LocalCache$ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue();
        return (nextInAccessQueue == this.head) ? null : nextInAccessQueue;
    }
    
    @Override
    public LocalCache$ReferenceEntry poll() {
        final LocalCache$ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue();
        if (nextInAccessQueue == this.head) {
            return null;
        }
        this.remove(nextInAccessQueue);
        return nextInAccessQueue;
    }
    
    @Override
    public boolean remove(final Object o) {
        final LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)o;
        final LocalCache$ReferenceEntry previousInAccessQueue = localCache$ReferenceEntry.getPreviousInAccessQueue();
        final LocalCache$ReferenceEntry nextInAccessQueue = localCache$ReferenceEntry.getNextInAccessQueue();
        LocalCache.connectAccessOrder(previousInAccessQueue, nextInAccessQueue);
        LocalCache.nullifyAccessOrder(localCache$ReferenceEntry);
        return nextInAccessQueue != LocalCache$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean contains(final Object o) {
        return ((LocalCache$ReferenceEntry)o).getNextInAccessQueue() != LocalCache$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean isEmpty() {
        return this.head.getNextInAccessQueue() == this.head;
    }
    
    @Override
    public int size() {
        int n = 0;
        for (LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInAccessQueue(); localCache$ReferenceEntry != this.head; localCache$ReferenceEntry = localCache$ReferenceEntry.getNextInAccessQueue()) {
            ++n;
        }
        return n;
    }
    
    @Override
    public void clear() {
        LocalCache$ReferenceEntry nextInAccessQueue2;
        for (LocalCache$ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue2) {
            nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
            LocalCache.nullifyAccessOrder(nextInAccessQueue);
        }
        this.head.setNextInAccessQueue(this.head);
        this.head.setPreviousInAccessQueue(this.head);
    }
    
    @Override
    public Iterator iterator() {
        return new LocalCache$AccessQueue$2(this, this.peek());
    }
}
