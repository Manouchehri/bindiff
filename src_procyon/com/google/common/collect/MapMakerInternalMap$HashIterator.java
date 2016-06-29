package com.google.common.collect;

import java.util.concurrent.atomic.*;
import java.util.*;

abstract class MapMakerInternalMap$HashIterator implements Iterator
{
    int nextSegmentIndex;
    int nextTableIndex;
    MapMakerInternalMap$Segment currentSegment;
    AtomicReferenceArray currentTable;
    MapMakerInternalMap$ReferenceEntry nextEntry;
    MapMakerInternalMap$WriteThroughEntry nextExternal;
    MapMakerInternalMap$WriteThroughEntry lastReturned;
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$HashIterator(final MapMakerInternalMap this$0) {
        this.this$0 = this$0;
        this.nextSegmentIndex = this$0.segments.length - 1;
        this.nextTableIndex = -1;
        this.advance();
    }
    
    @Override
    public abstract Object next();
    
    final void advance() {
        this.nextExternal = null;
        if (this.nextInChain()) {
            return;
        }
        if (this.nextInTable()) {
            return;
        }
        while (this.nextSegmentIndex >= 0) {
            this.currentSegment = this.this$0.segments[this.nextSegmentIndex--];
            if (this.currentSegment.count != 0) {
                this.currentTable = this.currentSegment.table;
                this.nextTableIndex = this.currentTable.length() - 1;
                if (this.nextInTable()) {
                    return;
                }
                continue;
            }
        }
    }
    
    boolean nextInChain() {
        if (this.nextEntry != null) {
            this.nextEntry = this.nextEntry.getNext();
            while (this.nextEntry != null) {
                if (this.advanceTo(this.nextEntry)) {
                    return true;
                }
                this.nextEntry = this.nextEntry.getNext();
            }
        }
        return false;
    }
    
    boolean nextInTable() {
        while (this.nextTableIndex >= 0) {
            final MapMakerInternalMap$ReferenceEntry nextEntry = this.currentTable.get(this.nextTableIndex--);
            this.nextEntry = nextEntry;
            if (nextEntry != null && (this.advanceTo(this.nextEntry) || this.nextInChain())) {
                return true;
            }
        }
        return false;
    }
    
    boolean advanceTo(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        try {
            final Object key = mapMakerInternalMap$ReferenceEntry.getKey();
            final Object liveValue = this.this$0.getLiveValue(mapMakerInternalMap$ReferenceEntry);
            if (liveValue != null) {
                this.nextExternal = new MapMakerInternalMap$WriteThroughEntry(this.this$0, key, liveValue);
                return true;
            }
            return false;
        }
        finally {
            this.currentSegment.postReadCleanup();
        }
    }
    
    @Override
    public boolean hasNext() {
        return this.nextExternal != null;
    }
    
    MapMakerInternalMap$WriteThroughEntry nextEntry() {
        if (this.nextExternal == null) {
            throw new NoSuchElementException();
        }
        this.lastReturned = this.nextExternal;
        this.advance();
        return this.lastReturned;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.lastReturned != null);
        this.this$0.remove(this.lastReturned.getKey());
        this.lastReturned = null;
    }
}
