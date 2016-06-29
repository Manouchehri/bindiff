package com.google.common.cache;

import java.util.*;

final class LocalCache$WriteQueue extends AbstractQueue
{
    final LocalCache$ReferenceEntry head;
    
    LocalCache$WriteQueue() {
        this.head = new LocalCache$WriteQueue$1(this);
    }
    
    public boolean offer(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache.connectWriteOrder(localCache$ReferenceEntry.getPreviousInWriteQueue(), localCache$ReferenceEntry.getNextInWriteQueue());
        LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), localCache$ReferenceEntry);
        LocalCache.connectWriteOrder(localCache$ReferenceEntry, this.head);
        return true;
    }
    
    @Override
    public LocalCache$ReferenceEntry peek() {
        final LocalCache$ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue();
        return (nextInWriteQueue == this.head) ? null : nextInWriteQueue;
    }
    
    @Override
    public LocalCache$ReferenceEntry poll() {
        final LocalCache$ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue();
        if (nextInWriteQueue == this.head) {
            return null;
        }
        this.remove(nextInWriteQueue);
        return nextInWriteQueue;
    }
    
    @Override
    public boolean remove(final Object o) {
        final LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)o;
        final LocalCache$ReferenceEntry previousInWriteQueue = localCache$ReferenceEntry.getPreviousInWriteQueue();
        final LocalCache$ReferenceEntry nextInWriteQueue = localCache$ReferenceEntry.getNextInWriteQueue();
        LocalCache.connectWriteOrder(previousInWriteQueue, nextInWriteQueue);
        LocalCache.nullifyWriteOrder(localCache$ReferenceEntry);
        return nextInWriteQueue != LocalCache$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean contains(final Object o) {
        return ((LocalCache$ReferenceEntry)o).getNextInWriteQueue() != LocalCache$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean isEmpty() {
        return this.head.getNextInWriteQueue() == this.head;
    }
    
    @Override
    public int size() {
        int n = 0;
        for (LocalCache$ReferenceEntry localCache$ReferenceEntry = this.head.getNextInWriteQueue(); localCache$ReferenceEntry != this.head; localCache$ReferenceEntry = localCache$ReferenceEntry.getNextInWriteQueue()) {
            ++n;
        }
        return n;
    }
    
    @Override
    public void clear() {
        LocalCache$ReferenceEntry nextInWriteQueue2;
        for (LocalCache$ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue2) {
            nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
            LocalCache.nullifyWriteOrder(nextInWriteQueue);
        }
        this.head.setNextInWriteQueue(this.head);
        this.head.setPreviousInWriteQueue(this.head);
    }
    
    @Override
    public Iterator iterator() {
        return new LocalCache$WriteQueue$2(this, this.peek());
    }
}
