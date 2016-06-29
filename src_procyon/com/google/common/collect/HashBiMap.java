package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class HashBiMap extends Maps$IteratorBasedAbstractMap implements BiMap, Serializable
{
    private static final double LOAD_FACTOR = 1.0;
    private transient HashBiMap$BiEntry[] hashTableKToV;
    private transient HashBiMap$BiEntry[] hashTableVToK;
    private transient HashBiMap$BiEntry firstInKeyInsertionOrder;
    private transient HashBiMap$BiEntry lastInKeyInsertionOrder;
    private transient int size;
    private transient int mask;
    private transient int modCount;
    private transient BiMap inverse;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    public static HashBiMap create() {
        return create(16);
    }
    
    public static HashBiMap create(final int n) {
        return new HashBiMap(n);
    }
    
    public static HashBiMap create(final Map map) {
        final HashBiMap create = create(map.size());
        create.putAll(map);
        return create;
    }
    
    private HashBiMap(final int n) {
        this.init(n);
    }
    
    private void init(final int n) {
        CollectPreconditions.checkNonnegative(n, "expectedSize");
        final int closedTableSize = Hashing.closedTableSize(n, 1.0);
        this.hashTableKToV = this.createTable(closedTableSize);
        this.hashTableVToK = this.createTable(closedTableSize);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = closedTableSize - 1;
        this.modCount = 0;
    }
    
    private void delete(final HashBiMap$BiEntry hashBiMap$BiEntry) {
        final int n = hashBiMap$BiEntry.keyHash & this.mask;
        HashBiMap$BiEntry hashBiMap$BiEntry2 = null;
        for (HashBiMap$BiEntry nextInKToVBucket = this.hashTableKToV[n]; nextInKToVBucket != hashBiMap$BiEntry; nextInKToVBucket = nextInKToVBucket.nextInKToVBucket) {
            hashBiMap$BiEntry2 = nextInKToVBucket;
        }
        if (hashBiMap$BiEntry2 == null) {
            this.hashTableKToV[n] = hashBiMap$BiEntry.nextInKToVBucket;
        }
        else {
            hashBiMap$BiEntry2.nextInKToVBucket = hashBiMap$BiEntry.nextInKToVBucket;
        }
        final int n2 = hashBiMap$BiEntry.valueHash & this.mask;
        HashBiMap$BiEntry hashBiMap$BiEntry3 = null;
        for (HashBiMap$BiEntry nextInVToKBucket = this.hashTableVToK[n2]; nextInVToKBucket != hashBiMap$BiEntry; nextInVToKBucket = nextInVToKBucket.nextInVToKBucket) {
            hashBiMap$BiEntry3 = nextInVToKBucket;
        }
        if (hashBiMap$BiEntry3 == null) {
            this.hashTableVToK[n2] = hashBiMap$BiEntry.nextInVToKBucket;
        }
        else {
            hashBiMap$BiEntry3.nextInVToKBucket = hashBiMap$BiEntry.nextInVToKBucket;
        }
        if (hashBiMap$BiEntry.prevInKeyInsertionOrder == null) {
            this.firstInKeyInsertionOrder = hashBiMap$BiEntry.nextInKeyInsertionOrder;
        }
        else {
            hashBiMap$BiEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = hashBiMap$BiEntry.nextInKeyInsertionOrder;
        }
        if (hashBiMap$BiEntry.nextInKeyInsertionOrder == null) {
            this.lastInKeyInsertionOrder = hashBiMap$BiEntry.prevInKeyInsertionOrder;
        }
        else {
            hashBiMap$BiEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = hashBiMap$BiEntry.prevInKeyInsertionOrder;
        }
        --this.size;
        ++this.modCount;
    }
    
    private void insert(final HashBiMap$BiEntry prevInKeyInsertionOrder, @Nullable final HashBiMap$BiEntry hashBiMap$BiEntry) {
        final int n = prevInKeyInsertionOrder.keyHash & this.mask;
        prevInKeyInsertionOrder.nextInKToVBucket = this.hashTableKToV[n];
        this.hashTableKToV[n] = prevInKeyInsertionOrder;
        final int n2 = prevInKeyInsertionOrder.valueHash & this.mask;
        prevInKeyInsertionOrder.nextInVToKBucket = this.hashTableVToK[n2];
        this.hashTableVToK[n2] = prevInKeyInsertionOrder;
        if (hashBiMap$BiEntry == null) {
            prevInKeyInsertionOrder.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
            prevInKeyInsertionOrder.nextInKeyInsertionOrder = null;
            if (this.lastInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = prevInKeyInsertionOrder;
            }
            else {
                this.lastInKeyInsertionOrder.nextInKeyInsertionOrder = prevInKeyInsertionOrder;
            }
            this.lastInKeyInsertionOrder = prevInKeyInsertionOrder;
        }
        else {
            prevInKeyInsertionOrder.prevInKeyInsertionOrder = hashBiMap$BiEntry.prevInKeyInsertionOrder;
            if (prevInKeyInsertionOrder.prevInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = prevInKeyInsertionOrder;
            }
            else {
                prevInKeyInsertionOrder.prevInKeyInsertionOrder.nextInKeyInsertionOrder = prevInKeyInsertionOrder;
            }
            prevInKeyInsertionOrder.nextInKeyInsertionOrder = hashBiMap$BiEntry.nextInKeyInsertionOrder;
            if (prevInKeyInsertionOrder.nextInKeyInsertionOrder == null) {
                this.lastInKeyInsertionOrder = prevInKeyInsertionOrder;
            }
            else {
                prevInKeyInsertionOrder.nextInKeyInsertionOrder.prevInKeyInsertionOrder = prevInKeyInsertionOrder;
            }
        }
        ++this.size;
        ++this.modCount;
    }
    
    private HashBiMap$BiEntry seekByKey(@Nullable final Object o, final int n) {
        for (HashBiMap$BiEntry nextInKToVBucket = this.hashTableKToV[n & this.mask]; nextInKToVBucket != null; nextInKToVBucket = nextInKToVBucket.nextInKToVBucket) {
            if (n == nextInKToVBucket.keyHash && Objects.equal(o, nextInKToVBucket.key)) {
                return nextInKToVBucket;
            }
        }
        return null;
    }
    
    private HashBiMap$BiEntry seekByValue(@Nullable final Object o, final int n) {
        for (HashBiMap$BiEntry nextInVToKBucket = this.hashTableVToK[n & this.mask]; nextInVToKBucket != null; nextInVToKBucket = nextInVToKBucket.nextInVToKBucket) {
            if (n == nextInVToKBucket.valueHash && Objects.equal(o, nextInVToKBucket.value)) {
                return nextInVToKBucket;
            }
        }
        return null;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.seekByKey(o, Hashing.smearedHash(o)) != null;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.seekByValue(o, Hashing.smearedHash(o)) != null;
    }
    
    @Nullable
    @Override
    public Object get(@Nullable final Object o) {
        return Maps.valueOrNull(this.seekByKey(o, Hashing.smearedHash(o)));
    }
    
    @Override
    public Object put(@Nullable final Object o, @Nullable final Object o2) {
        return this.put(o, o2, false);
    }
    
    @Override
    public Object forcePut(@Nullable final Object o, @Nullable final Object o2) {
        return this.put(o, o2, true);
    }
    
    private Object put(@Nullable final Object o, @Nullable final Object o2, final boolean b) {
        final int smearedHash = Hashing.smearedHash(o);
        final int smearedHash2 = Hashing.smearedHash(o2);
        final HashBiMap$BiEntry seekByKey = this.seekByKey(o, smearedHash);
        if (seekByKey != null && smearedHash2 == seekByKey.valueHash && Objects.equal(o2, seekByKey.value)) {
            return o2;
        }
        final HashBiMap$BiEntry seekByValue = this.seekByValue(o2, smearedHash2);
        if (seekByValue != null) {
            if (!b) {
                final String value = String.valueOf(o2);
                throw new IllegalArgumentException(new StringBuilder(23 + String.valueOf(value).length()).append("value already present: ").append(value).toString());
            }
            this.delete(seekByValue);
        }
        final HashBiMap$BiEntry hashBiMap$BiEntry = new HashBiMap$BiEntry(o, smearedHash, o2, smearedHash2);
        if (seekByKey != null) {
            this.delete(seekByKey);
            this.insert(hashBiMap$BiEntry, seekByKey);
            seekByKey.prevInKeyInsertionOrder = null;
            seekByKey.nextInKeyInsertionOrder = null;
            this.rehashIfNecessary();
            return seekByKey.value;
        }
        this.insert(hashBiMap$BiEntry, null);
        this.rehashIfNecessary();
        return null;
    }
    
    @Nullable
    private Object putInverse(@Nullable final Object o, @Nullable final Object o2, final boolean b) {
        final int smearedHash = Hashing.smearedHash(o);
        final int smearedHash2 = Hashing.smearedHash(o2);
        final HashBiMap$BiEntry seekByValue = this.seekByValue(o, smearedHash);
        if (seekByValue != null && smearedHash2 == seekByValue.keyHash && Objects.equal(o2, seekByValue.key)) {
            return o2;
        }
        final HashBiMap$BiEntry seekByKey = this.seekByKey(o2, smearedHash2);
        if (seekByKey != null) {
            if (!b) {
                final String value = String.valueOf(o2);
                throw new IllegalArgumentException(new StringBuilder(23 + String.valueOf(value).length()).append("value already present: ").append(value).toString());
            }
            this.delete(seekByKey);
        }
        if (seekByValue != null) {
            this.delete(seekByValue);
        }
        this.insert(new HashBiMap$BiEntry(o2, smearedHash2, o, smearedHash), seekByKey);
        if (seekByKey != null) {
            seekByKey.prevInKeyInsertionOrder = null;
            seekByKey.nextInKeyInsertionOrder = null;
        }
        this.rehashIfNecessary();
        return Maps.keyOrNull(seekByValue);
    }
    
    private void rehashIfNecessary() {
        final HashBiMap$BiEntry[] hashTableKToV = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, hashTableKToV.length, 1.0)) {
            final int n = hashTableKToV.length * 2;
            this.hashTableKToV = this.createTable(n);
            this.hashTableVToK = this.createTable(n);
            this.mask = n - 1;
            this.size = 0;
            for (HashBiMap$BiEntry hashBiMap$BiEntry = this.firstInKeyInsertionOrder; hashBiMap$BiEntry != null; hashBiMap$BiEntry = hashBiMap$BiEntry.nextInKeyInsertionOrder) {
                this.insert(hashBiMap$BiEntry, hashBiMap$BiEntry);
            }
            ++this.modCount;
        }
    }
    
    private HashBiMap$BiEntry[] createTable(final int n) {
        return new HashBiMap$BiEntry[n];
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        final HashBiMap$BiEntry seekByKey = this.seekByKey(o, Hashing.smearedHash(o));
        if (seekByKey == null) {
            return null;
        }
        this.delete(seekByKey);
        seekByKey.prevInKeyInsertionOrder = null;
        seekByKey.nextInKeyInsertionOrder = null;
        return seekByKey.value;
    }
    
    @Override
    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        ++this.modCount;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public Set keySet() {
        return new HashBiMap$KeySet(this);
    }
    
    @Override
    public Set values() {
        return this.inverse().keySet();
    }
    
    @Override
    Iterator entryIterator() {
        return new HashBiMap$1(this);
    }
    
    @Override
    public BiMap inverse() {
        return (this.inverse == null) ? (this.inverse = new HashBiMap$Inverse(this, null)) : this.inverse;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.init(16);
        Serialization.populateMap(this, objectInputStream, Serialization.readCount(objectInputStream));
    }
}
