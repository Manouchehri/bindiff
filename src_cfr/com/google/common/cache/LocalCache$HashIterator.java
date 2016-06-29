/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$WriteThroughEntry;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class LocalCache$HashIterator
implements Iterator {
    int nextSegmentIndex;
    int nextTableIndex;
    LocalCache$Segment currentSegment;
    AtomicReferenceArray currentTable;
    LocalCache$ReferenceEntry nextEntry;
    LocalCache$WriteThroughEntry nextExternal;
    LocalCache$WriteThroughEntry lastReturned;
    final /* synthetic */ LocalCache this$0;

    LocalCache$HashIterator(LocalCache localCache) {
        this.this$0 = localCache;
        this.nextSegmentIndex = localCache.segments.length - 1;
        this.nextTableIndex = -1;
        this.advance();
    }

    public abstract Object next();

    /*
     * Unable to fully structure code
     */
    final void advance() {
        this.nextExternal = null;
        if (this.nextInChain()) {
            return;
        }
        if (this.nextInTable()) {
            return;
        }
        do lbl-1000: // 3 sources:
        {
            if (this.nextSegmentIndex < 0) return;
            this.currentSegment = this.this$0.segments[this.nextSegmentIndex--];
            if (this.currentSegment.count == 0) ** GOTO lbl-1000
            this.currentTable = this.currentSegment.table;
            this.nextTableIndex = this.currentTable.length() - 1;
        } while (!this.nextInTable());
    }

    boolean nextInChain() {
        if (this.nextEntry == null) return false;
        this.nextEntry = this.nextEntry.getNext();
        while (this.nextEntry != null) {
            if (this.advanceTo(this.nextEntry)) {
                return true;
            }
            this.nextEntry = this.nextEntry.getNext();
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    boolean nextInTable() {
        do lbl-1000: // 3 sources:
        {
            if (this.nextTableIndex < 0) return false;
            if ((this.nextEntry = (LocalCache$ReferenceEntry)this.currentTable.get(this.nextTableIndex--)) == null) ** GOTO lbl-1000
            if (this.advanceTo(this.nextEntry) != false) return true;
        } while (!this.nextInChain());
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean advanceTo(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        try {
            long l2 = this.this$0.ticker.read();
            Object object = localCache$ReferenceEntry.getKey();
            Object object2 = this.this$0.getLiveValue(localCache$ReferenceEntry, l2);
            if (object2 != null) {
                this.nextExternal = new LocalCache$WriteThroughEntry(this.this$0, object, object2);
                boolean bl2 = true;
                return bl2;
            }
            boolean bl3 = false;
            return bl3;
        }
        finally {
            this.currentSegment.postReadCleanup();
        }
    }

    @Override
    public boolean hasNext() {
        if (this.nextExternal == null) return false;
        return true;
    }

    LocalCache$WriteThroughEntry nextEntry() {
        if (this.nextExternal == null) {
            throw new NoSuchElementException();
        }
        this.lastReturned = this.nextExternal;
        this.advance();
        return this.lastReturned;
    }

    @Override
    public void remove() {
        Preconditions.checkState(this.lastReturned != null);
        this.this$0.remove(this.lastReturned.getKey());
        this.lastReturned = null;
    }
}

