/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$WriteThroughEntry;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class MapMakerInternalMap$HashIterator
implements Iterator {
    int nextSegmentIndex;
    int nextTableIndex;
    MapMakerInternalMap$Segment currentSegment;
    AtomicReferenceArray currentTable;
    MapMakerInternalMap$ReferenceEntry nextEntry;
    MapMakerInternalMap$WriteThroughEntry nextExternal;
    MapMakerInternalMap$WriteThroughEntry lastReturned;
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$HashIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        this.nextSegmentIndex = mapMakerInternalMap.segments.length - 1;
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
            if ((this.nextEntry = (MapMakerInternalMap$ReferenceEntry)this.currentTable.get(this.nextTableIndex--)) == null) ** GOTO lbl-1000
            if (this.advanceTo(this.nextEntry) != false) return true;
        } while (!this.nextInChain());
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean advanceTo(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        try {
            Object object = mapMakerInternalMap$ReferenceEntry.getKey();
            Object object2 = this.this$0.getLiveValue(mapMakerInternalMap$ReferenceEntry);
            if (object2 != null) {
                this.nextExternal = new MapMakerInternalMap$WriteThroughEntry(this.this$0, object, object2);
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

