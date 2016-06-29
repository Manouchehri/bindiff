/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBiMap$1;
import com.google.common.collect.HashBiMap$BiEntry;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$KeySet;
import com.google.common.collect.Hashing;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class HashBiMap
extends Maps$IteratorBasedAbstractMap
implements BiMap,
Serializable {
    private static final double LOAD_FACTOR = 1.0;
    private transient HashBiMap$BiEntry[] hashTableKToV;
    private transient HashBiMap$BiEntry[] hashTableVToK;
    private transient HashBiMap$BiEntry firstInKeyInsertionOrder;
    private transient HashBiMap$BiEntry lastInKeyInsertionOrder;
    private transient int size;
    private transient int mask;
    private transient int modCount;
    private transient BiMap inverse;
    @GwtIncompatible(value="Not needed in emulated source")
    private static final long serialVersionUID = 0;

    public static HashBiMap create() {
        return HashBiMap.create(16);
    }

    public static HashBiMap create(int n2) {
        return new HashBiMap(n2);
    }

    public static HashBiMap create(Map map) {
        HashBiMap hashBiMap = HashBiMap.create(map.size());
        hashBiMap.putAll(map);
        return hashBiMap;
    }

    private HashBiMap(int n2) {
        this.init(n2);
    }

    private void init(int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedSize");
        int n3 = Hashing.closedTableSize(n2, 1.0);
        this.hashTableKToV = this.createTable(n3);
        this.hashTableVToK = this.createTable(n3);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = n3 - 1;
        this.modCount = 0;
    }

    private void delete(HashBiMap$BiEntry hashBiMap$BiEntry) {
        int n2 = hashBiMap$BiEntry.keyHash & this.mask;
        HashBiMap$BiEntry hashBiMap$BiEntry2 = null;
        HashBiMap$BiEntry hashBiMap$BiEntry3 = this.hashTableKToV[n2];
        do {
            if (hashBiMap$BiEntry3 == hashBiMap$BiEntry) {
                if (hashBiMap$BiEntry2 == null) {
                    this.hashTableKToV[n2] = hashBiMap$BiEntry.nextInKToVBucket;
                    break;
                }
                hashBiMap$BiEntry2.nextInKToVBucket = hashBiMap$BiEntry.nextInKToVBucket;
                break;
            }
            hashBiMap$BiEntry2 = hashBiMap$BiEntry3;
            hashBiMap$BiEntry3 = hashBiMap$BiEntry3.nextInKToVBucket;
        } while (true);
        int n3 = hashBiMap$BiEntry.valueHash & this.mask;
        hashBiMap$BiEntry2 = null;
        HashBiMap$BiEntry hashBiMap$BiEntry4 = this.hashTableVToK[n3];
        do {
            if (hashBiMap$BiEntry4 == hashBiMap$BiEntry) {
                if (hashBiMap$BiEntry2 == null) {
                    this.hashTableVToK[n3] = hashBiMap$BiEntry.nextInVToKBucket;
                    break;
                }
                hashBiMap$BiEntry2.nextInVToKBucket = hashBiMap$BiEntry.nextInVToKBucket;
                break;
            }
            hashBiMap$BiEntry2 = hashBiMap$BiEntry4;
            hashBiMap$BiEntry4 = hashBiMap$BiEntry4.nextInVToKBucket;
        } while (true);
        if (hashBiMap$BiEntry.prevInKeyInsertionOrder == null) {
            this.firstInKeyInsertionOrder = hashBiMap$BiEntry.nextInKeyInsertionOrder;
        } else {
            hashBiMap$BiEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = hashBiMap$BiEntry.nextInKeyInsertionOrder;
        }
        if (hashBiMap$BiEntry.nextInKeyInsertionOrder == null) {
            this.lastInKeyInsertionOrder = hashBiMap$BiEntry.prevInKeyInsertionOrder;
        } else {
            hashBiMap$BiEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = hashBiMap$BiEntry.prevInKeyInsertionOrder;
        }
        --this.size;
        ++this.modCount;
    }

    private void insert(HashBiMap$BiEntry hashBiMap$BiEntry, @Nullable HashBiMap$BiEntry hashBiMap$BiEntry2) {
        int n2 = hashBiMap$BiEntry.keyHash & this.mask;
        hashBiMap$BiEntry.nextInKToVBucket = this.hashTableKToV[n2];
        this.hashTableKToV[n2] = hashBiMap$BiEntry;
        int n3 = hashBiMap$BiEntry.valueHash & this.mask;
        hashBiMap$BiEntry.nextInVToKBucket = this.hashTableVToK[n3];
        this.hashTableVToK[n3] = hashBiMap$BiEntry;
        if (hashBiMap$BiEntry2 == null) {
            hashBiMap$BiEntry.prevInKeyInsertionOrder = this.lastInKeyInsertionOrder;
            hashBiMap$BiEntry.nextInKeyInsertionOrder = null;
            if (this.lastInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = hashBiMap$BiEntry;
            } else {
                this.lastInKeyInsertionOrder.nextInKeyInsertionOrder = hashBiMap$BiEntry;
            }
            this.lastInKeyInsertionOrder = hashBiMap$BiEntry;
        } else {
            hashBiMap$BiEntry.prevInKeyInsertionOrder = hashBiMap$BiEntry2.prevInKeyInsertionOrder;
            if (hashBiMap$BiEntry.prevInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = hashBiMap$BiEntry;
            } else {
                hashBiMap$BiEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = hashBiMap$BiEntry;
            }
            hashBiMap$BiEntry.nextInKeyInsertionOrder = hashBiMap$BiEntry2.nextInKeyInsertionOrder;
            if (hashBiMap$BiEntry.nextInKeyInsertionOrder == null) {
                this.lastInKeyInsertionOrder = hashBiMap$BiEntry;
            } else {
                hashBiMap$BiEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = hashBiMap$BiEntry;
            }
        }
        ++this.size;
        ++this.modCount;
    }

    private HashBiMap$BiEntry seekByKey(@Nullable Object object, int n2) {
        HashBiMap$BiEntry hashBiMap$BiEntry = this.hashTableKToV[n2 & this.mask];
        while (hashBiMap$BiEntry != null) {
            if (n2 == hashBiMap$BiEntry.keyHash && Objects.equal(object, hashBiMap$BiEntry.key)) {
                return hashBiMap$BiEntry;
            }
            hashBiMap$BiEntry = hashBiMap$BiEntry.nextInKToVBucket;
        }
        return null;
    }

    private HashBiMap$BiEntry seekByValue(@Nullable Object object, int n2) {
        HashBiMap$BiEntry hashBiMap$BiEntry = this.hashTableVToK[n2 & this.mask];
        while (hashBiMap$BiEntry != null) {
            if (n2 == hashBiMap$BiEntry.valueHash && Objects.equal(object, hashBiMap$BiEntry.value)) {
                return hashBiMap$BiEntry;
            }
            hashBiMap$BiEntry = hashBiMap$BiEntry.nextInVToKBucket;
        }
        return null;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.seekByKey(object, Hashing.smearedHash(object)) == null) return false;
        return true;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        if (this.seekByValue(object, Hashing.smearedHash(object)) == null) return false;
        return true;
    }

    @Nullable
    public Object get(@Nullable Object object) {
        return Maps.valueOrNull(this.seekByKey(object, Hashing.smearedHash(object)));
    }

    @Override
    public Object put(@Nullable Object object, @Nullable Object object2) {
        return this.put(object, object2, false);
    }

    @Override
    public Object forcePut(@Nullable Object object, @Nullable Object object2) {
        return this.put(object, object2, true);
    }

    private Object put(@Nullable Object object, @Nullable Object object2, boolean bl2) {
        int n2 = Hashing.smearedHash(object);
        int n3 = Hashing.smearedHash(object2);
        HashBiMap$BiEntry hashBiMap$BiEntry = this.seekByKey(object, n2);
        if (hashBiMap$BiEntry != null && n3 == hashBiMap$BiEntry.valueHash && Objects.equal(object2, hashBiMap$BiEntry.value)) {
            return object2;
        }
        HashBiMap$BiEntry hashBiMap$BiEntry2 = this.seekByValue(object2, n3);
        if (hashBiMap$BiEntry2 != null) {
            if (!bl2) {
                String string = String.valueOf(object2);
                throw new IllegalArgumentException(new StringBuilder(23 + String.valueOf(string).length()).append("value already present: ").append(string).toString());
            }
            this.delete(hashBiMap$BiEntry2);
        }
        HashBiMap$BiEntry hashBiMap$BiEntry3 = new HashBiMap$BiEntry(object, n2, object2, n3);
        if (hashBiMap$BiEntry != null) {
            this.delete(hashBiMap$BiEntry);
            this.insert(hashBiMap$BiEntry3, hashBiMap$BiEntry);
            hashBiMap$BiEntry.prevInKeyInsertionOrder = null;
            hashBiMap$BiEntry.nextInKeyInsertionOrder = null;
            this.rehashIfNecessary();
            return hashBiMap$BiEntry.value;
        }
        this.insert(hashBiMap$BiEntry3, null);
        this.rehashIfNecessary();
        return null;
    }

    @Nullable
    private Object putInverse(@Nullable Object object, @Nullable Object object2, boolean bl2) {
        int n2 = Hashing.smearedHash(object);
        int n3 = Hashing.smearedHash(object2);
        HashBiMap$BiEntry hashBiMap$BiEntry = this.seekByValue(object, n2);
        if (hashBiMap$BiEntry != null && n3 == hashBiMap$BiEntry.keyHash && Objects.equal(object2, hashBiMap$BiEntry.key)) {
            return object2;
        }
        HashBiMap$BiEntry hashBiMap$BiEntry2 = this.seekByKey(object2, n3);
        if (hashBiMap$BiEntry2 != null) {
            if (!bl2) {
                String string = String.valueOf(object2);
                throw new IllegalArgumentException(new StringBuilder(23 + String.valueOf(string).length()).append("value already present: ").append(string).toString());
            }
            this.delete(hashBiMap$BiEntry2);
        }
        if (hashBiMap$BiEntry != null) {
            this.delete(hashBiMap$BiEntry);
        }
        HashBiMap$BiEntry hashBiMap$BiEntry3 = new HashBiMap$BiEntry(object2, n3, object, n2);
        this.insert(hashBiMap$BiEntry3, hashBiMap$BiEntry2);
        if (hashBiMap$BiEntry2 != null) {
            hashBiMap$BiEntry2.prevInKeyInsertionOrder = null;
            hashBiMap$BiEntry2.nextInKeyInsertionOrder = null;
        }
        this.rehashIfNecessary();
        return Maps.keyOrNull(hashBiMap$BiEntry);
    }

    private void rehashIfNecessary() {
        HashBiMap$BiEntry[] arrhashBiMap$BiEntry = this.hashTableKToV;
        if (!Hashing.needsResizing(this.size, arrhashBiMap$BiEntry.length, 1.0)) return;
        int n2 = arrhashBiMap$BiEntry.length * 2;
        this.hashTableKToV = this.createTable(n2);
        this.hashTableVToK = this.createTable(n2);
        this.mask = n2 - 1;
        this.size = 0;
        HashBiMap$BiEntry hashBiMap$BiEntry = this.firstInKeyInsertionOrder;
        do {
            if (hashBiMap$BiEntry == null) {
                ++this.modCount;
                return;
            }
            this.insert(hashBiMap$BiEntry, hashBiMap$BiEntry);
            hashBiMap$BiEntry = hashBiMap$BiEntry.nextInKeyInsertionOrder;
        } while (true);
    }

    private HashBiMap$BiEntry[] createTable(int n2) {
        return new HashBiMap$BiEntry[n2];
    }

    public Object remove(@Nullable Object object) {
        HashBiMap$BiEntry hashBiMap$BiEntry = this.seekByKey(object, Hashing.smearedHash(object));
        if (hashBiMap$BiEntry == null) {
            return null;
        }
        this.delete(hashBiMap$BiEntry);
        hashBiMap$BiEntry.prevInKeyInsertionOrder = null;
        hashBiMap$BiEntry.nextInKeyInsertionOrder = null;
        return hashBiMap$BiEntry.value;
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
        BiMap biMap;
        if (this.inverse == null) {
            biMap = this.inverse = new HashBiMap$Inverse(this, null);
            return biMap;
        }
        biMap = this.inverse;
        return biMap;
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.init(16);
        int n2 = Serialization.readCount(objectInputStream);
        Serialization.populateMap(this, objectInputStream, n2);
    }

    static /* synthetic */ HashBiMap$BiEntry access$000(HashBiMap hashBiMap) {
        return hashBiMap.firstInKeyInsertionOrder;
    }

    static /* synthetic */ int access$100(HashBiMap hashBiMap) {
        return hashBiMap.modCount;
    }

    static /* synthetic */ void access$200(HashBiMap hashBiMap, HashBiMap$BiEntry hashBiMap$BiEntry) {
        hashBiMap.delete(hashBiMap$BiEntry);
    }

    static /* synthetic */ HashBiMap$BiEntry access$300(HashBiMap hashBiMap, Object object, int n2) {
        return hashBiMap.seekByKey(object, n2);
    }

    static /* synthetic */ HashBiMap$BiEntry access$400(HashBiMap hashBiMap, Object object, int n2) {
        return hashBiMap.seekByValue(object, n2);
    }

    static /* synthetic */ void access$500(HashBiMap hashBiMap, HashBiMap$BiEntry hashBiMap$BiEntry, HashBiMap$BiEntry hashBiMap$BiEntry2) {
        hashBiMap.insert(hashBiMap$BiEntry, hashBiMap$BiEntry2);
    }

    static /* synthetic */ int access$700(HashBiMap hashBiMap) {
        return hashBiMap.size;
    }

    static /* synthetic */ Object access$800(HashBiMap hashBiMap, Object object, Object object2, boolean bl2) {
        return hashBiMap.putInverse(object, object2, bl2);
    }
}

