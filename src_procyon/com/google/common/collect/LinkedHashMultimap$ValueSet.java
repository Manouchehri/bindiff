package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import java.io.*;

@VisibleForTesting
final class LinkedHashMultimap$ValueSet extends Sets$ImprovedAbstractSet implements LinkedHashMultimap$ValueSetLink
{
    private final Object key;
    @VisibleForTesting
    LinkedHashMultimap$ValueEntry[] hashTable;
    private int size;
    private int modCount;
    private LinkedHashMultimap$ValueSetLink firstEntry;
    private LinkedHashMultimap$ValueSetLink lastEntry;
    final /* synthetic */ LinkedHashMultimap this$0;
    
    LinkedHashMultimap$ValueSet(final LinkedHashMultimap this$0, final Object key, final int n) {
        this.this$0 = this$0;
        this.size = 0;
        this.modCount = 0;
        this.key = key;
        this.firstEntry = this;
        this.lastEntry = this;
        this.hashTable = new LinkedHashMultimap$ValueEntry[Hashing.closedTableSize(n, 1.0)];
    }
    
    private int mask() {
        return this.hashTable.length - 1;
    }
    
    @Override
    public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
        return this.lastEntry;
    }
    
    @Override
    public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
        return this.firstEntry;
    }
    
    @Override
    public void setPredecessorInValueSet(final LinkedHashMultimap$ValueSetLink lastEntry) {
        this.lastEntry = lastEntry;
    }
    
    @Override
    public void setSuccessorInValueSet(final LinkedHashMultimap$ValueSetLink firstEntry) {
        this.firstEntry = firstEntry;
    }
    
    @Override
    public Iterator iterator() {
        return new LinkedHashMultimap$ValueSet$1(this);
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        final int smearedHash = Hashing.smearedHash(o);
        for (LinkedHashMultimap$ValueEntry nextInValueBucket = this.hashTable[smearedHash & this.mask()]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.nextInValueBucket) {
            if (nextInValueBucket.matchesValue(o, smearedHash)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean add(@Nullable final Object o) {
        final int smearedHash = Hashing.smearedHash(o);
        final int n = smearedHash & this.mask();
        LinkedHashMultimap$ValueEntry nextInValueBucket;
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
        for (linkedHashMultimap$ValueEntry = (nextInValueBucket = this.hashTable[n]); nextInValueBucket != null; nextInValueBucket = nextInValueBucket.nextInValueBucket) {
            if (nextInValueBucket.matchesValue(o, smearedHash)) {
                return false;
            }
        }
        final LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = new LinkedHashMultimap$ValueEntry(this.key, o, smearedHash, linkedHashMultimap$ValueEntry);
        succeedsInValueSet(this.lastEntry, linkedHashMultimap$ValueEntry2);
        succeedsInValueSet(linkedHashMultimap$ValueEntry2, this);
        succeedsInMultimap(this.this$0.multimapHeaderEntry.getPredecessorInMultimap(), linkedHashMultimap$ValueEntry2);
        succeedsInMultimap(linkedHashMultimap$ValueEntry2, this.this$0.multimapHeaderEntry);
        this.hashTable[n] = linkedHashMultimap$ValueEntry2;
        ++this.size;
        ++this.modCount;
        this.rehashIfNecessary();
        return true;
    }
    
    private void rehashIfNecessary() {
        if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0)) {
            final LinkedHashMultimap$ValueEntry[] hashTable = new LinkedHashMultimap$ValueEntry[this.hashTable.length * 2];
            this.hashTable = hashTable;
            final int n = hashTable.length - 1;
            for (LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.firstEntry; linkedHashMultimap$ValueSetLink != this; linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet()) {
                final LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = (LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink;
                final int n2 = linkedHashMultimap$ValueEntry.smearedValueHash & n;
                linkedHashMultimap$ValueEntry.nextInValueBucket = hashTable[n2];
                hashTable[n2] = linkedHashMultimap$ValueEntry;
            }
        }
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        final int smearedHash = Hashing.smearedHash(o);
        final int n = smearedHash & this.mask();
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = null;
        for (LinkedHashMultimap$ValueEntry nextInValueBucket = this.hashTable[n]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.nextInValueBucket) {
            if (nextInValueBucket.matchesValue(o, smearedHash)) {
                if (linkedHashMultimap$ValueEntry == null) {
                    this.hashTable[n] = nextInValueBucket.nextInValueBucket;
                }
                else {
                    linkedHashMultimap$ValueEntry.nextInValueBucket = nextInValueBucket.nextInValueBucket;
                }
                deleteFromValueSet(nextInValueBucket);
                deleteFromMultimap(nextInValueBucket);
                --this.size;
                ++this.modCount;
                return true;
            }
            linkedHashMultimap$ValueEntry = nextInValueBucket;
        }
        return false;
    }
    
    @Override
    public void clear() {
        Arrays.fill(this.hashTable, null);
        this.size = 0;
        for (LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.firstEntry; linkedHashMultimap$ValueSetLink != this; linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet()) {
            deleteFromMultimap((LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink);
        }
        succeedsInValueSet(this, this);
        ++this.modCount;
    }
}
