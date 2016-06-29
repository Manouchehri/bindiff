/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactHashMap$KeySetView;
import com.google.common.collect.CompactHashMap$ValuesView;
import com.google.common.collect.Hashing;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible(value="not worth using in GWT for now")
public class CompactHashMap
extends AbstractMap
implements Serializable {
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 0xFFFFFFFFL;
    private static final long HASH_MASK = -4294967296L;
    static final int DEFAULT_SIZE = 3;
    static final int UNSET = -1;
    private transient int[] table;
    @VisibleForTesting
    transient long[] entries;
    @VisibleForTesting
    transient Object[] keys;
    @VisibleForTesting
    transient Object[] values;
    transient float loadFactor;
    transient int modCount;
    private transient int threshold;
    private transient int size;
    private transient Set keySetView;
    private transient Set entrySetView;
    private transient Collection valuesView;

    public static CompactHashMap create() {
        return new CompactHashMap();
    }

    public static CompactHashMap createWithExpectedSize(int n2) {
        return new CompactHashMap(n2);
    }

    CompactHashMap() {
        this.init(3, 1.0f);
    }

    CompactHashMap(int n2) {
        this(n2, 1.0f);
    }

    CompactHashMap(int n2, float f2) {
        this.init(n2, f2);
    }

    void init(int n2, float f2) {
        Preconditions.checkArgument(n2 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f2 > 0.0f, "Illegal load factor");
        int n3 = Hashing.closedTableSize(n2, f2);
        this.table = CompactHashMap.newTable(n3);
        this.loadFactor = f2;
        this.keys = new Object[n2];
        this.values = new Object[n2];
        this.entries = CompactHashMap.newEntries(n2);
        this.threshold = Math.max(1, (int)((float)n3 * f2));
    }

    private static int[] newTable(int n2) {
        int[] arrn = new int[n2];
        Arrays.fill(arrn, -1);
        return arrn;
    }

    private static long[] newEntries(int n2) {
        long[] arrl = new long[n2];
        Arrays.fill(arrl, -1);
        return arrl;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static int getHash(long l2) {
        return (int)(l2 >>> 32);
    }

    private static int getNext(long l2) {
        return (int)l2;
    }

    private static long swapNext(long l2, int n2) {
        return -4294967296L & l2 | 0xFFFFFFFFL & (long)n2;
    }

    void accessEntry(int n2) {
    }

    @Nullable
    @Override
    public Object put(@Nullable Object object, @Nullable Object object2) {
        int n2;
        long[] arrl = this.entries;
        Object[] arrobject = this.keys;
        Object[] arrobject2 = this.values;
        int n3 = Hashing.smearedHash(object);
        int n4 = n3 & this.hashTableMask();
        int n5 = this.size;
        int n6 = this.table[n4];
        if (n6 == -1) {
            this.table[n4] = n5;
        } else {
            long l2;
            do {
                n2 = n6;
                l2 = arrl[n6];
                if (CompactHashMap.getHash(l2) != n3 || !Objects.equal(object, arrobject[n6])) continue;
                Object object3 = arrobject2[n6];
                arrobject2[n6] = object2;
                this.accessEntry(n6);
                return object3;
            } while ((n6 = CompactHashMap.getNext(l2)) != -1);
            arrl[n2] = CompactHashMap.swapNext(l2, n5);
        }
        if (n5 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        n2 = n5 + 1;
        this.resizeMeMaybe(n2);
        this.insertEntry(n5, object, object2, n3);
        this.size = n2;
        if (n5 >= this.threshold) {
            this.resizeTable(2 * this.table.length);
        }
        ++this.modCount;
        return null;
    }

    void insertEntry(int n2, @Nullable Object object, @Nullable Object object2, int n3) {
        this.entries[n2] = (long)n3 << 32 | 0xFFFFFFFFL;
        this.keys[n2] = object;
        this.values[n2] = object2;
    }

    private void resizeMeMaybe(int n2) {
        int n3 = this.entries.length;
        if (n2 <= n3) return;
        int n4 = n3 + Math.max(1, n3 >>> 1);
        if (n4 < 0) {
            n4 = Integer.MAX_VALUE;
        }
        if (n4 == n3) return;
        this.resizeEntries(n4);
    }

    void resizeEntries(int n2) {
        this.keys = Arrays.copyOf(this.keys, n2);
        this.values = Arrays.copyOf(this.values, n2);
        long[] arrl = this.entries;
        int n3 = arrl.length;
        arrl = Arrays.copyOf(arrl, n2);
        if (n2 > n3) {
            Arrays.fill(arrl, n3, n2, -1);
        }
        this.entries = arrl;
    }

    private void resizeTable(int n2) {
        int[] arrn = this.table;
        int n3 = arrn.length;
        if (n3 >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int n4 = 1 + (int)((float)n2 * this.loadFactor);
        int[] arrn2 = CompactHashMap.newTable(n2);
        long[] arrl = this.entries;
        int n5 = arrn2.length - 1;
        int n6 = 0;
        do {
            if (n6 >= this.size) {
                this.threshold = n4;
                this.table = arrn2;
                return;
            }
            long l2 = arrl[n6];
            int n7 = CompactHashMap.getHash(l2);
            int n8 = n7 & n5;
            int n9 = arrn2[n8];
            arrn2[n8] = n6++;
            arrl[n6] = (long)n7 << 32 | 0xFFFFFFFFL & (long)n9;
        } while (true);
    }

    private int indexOf(@Nullable Object object) {
        int n2 = Hashing.smearedHash(object);
        int n3 = this.table[n2 & this.hashTableMask()];
        while (n3 != -1) {
            long l2 = this.entries[n3];
            if (CompactHashMap.getHash(l2) == n2 && Objects.equal(object, this.keys[n3])) {
                return n3;
            }
            n3 = CompactHashMap.getNext(l2);
        }
        return -1;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.indexOf(object) == -1) return false;
        return true;
    }

    @Override
    public Object get(@Nullable Object object) {
        int n2 = this.indexOf(object);
        this.accessEntry(n2);
        if (n2 == -1) {
            return null;
        }
        Object object2 = this.values[n2];
        return object2;
    }

    @Nullable
    @Override
    public Object remove(@Nullable Object object) {
        return this.remove(object, Hashing.smearedHash(object));
    }

    private Object removeEntry(int n2) {
        return this.remove(this.keys[n2], CompactHashMap.getHash(this.entries[n2]));
    }

    @Nullable
    private Object remove(@Nullable Object object, int n2) {
        int n3 = n2 & this.hashTableMask();
        int n4 = this.table[n3];
        if (n4 == -1) {
            return null;
        }
        int n5 = -1;
        do {
            if (CompactHashMap.getHash(this.entries[n4]) == n2 && Objects.equal(object, this.keys[n4])) {
                Object object2 = this.values[n4];
                if (n5 == -1) {
                    this.table[n3] = CompactHashMap.getNext(this.entries[n4]);
                } else {
                    this.entries[n5] = CompactHashMap.swapNext(this.entries[n5], CompactHashMap.getNext(this.entries[n4]));
                }
                this.moveLastEntry(n4);
                --this.size;
                ++this.modCount;
                return object2;
            }
            n5 = n4;
        } while ((n4 = CompactHashMap.getNext(this.entries[n4])) != -1);
        return null;
    }

    void moveLastEntry(int n2) {
        long l2;
        long l3;
        int n3 = this.size() - 1;
        if (n2 >= n3) {
            this.keys[n2] = null;
            this.values[n2] = null;
            this.entries[n2] = -1;
            return;
        }
        this.keys[n2] = this.keys[n3];
        this.values[n2] = this.values[n3];
        this.keys[n3] = null;
        this.values[n3] = null;
        this.entries[n2] = l2 = this.entries[n3];
        this.entries[n3] = -1;
        int n4 = CompactHashMap.getHash(l2) & this.hashTableMask();
        int n5 = this.table[n4];
        if (n5 == n3) {
            this.table[n4] = n2;
            return;
        }
        do {
            int n6 = n5;
            l3 = this.entries[n5];
        } while ((n5 = CompactHashMap.getNext(l3)) != n3);
        this.entries[n6] = CompactHashMap.swapNext(l3, n2);
    }

    @Override
    public Set keySet() {
        Set set;
        if (this.keySetView == null) {
            set = this.keySetView = this.createKeySet();
            return set;
        }
        set = this.keySetView;
        return set;
    }

    Set createKeySet() {
        return new CompactHashMap$KeySetView(this);
    }

    @Override
    public Set entrySet() {
        Set set;
        if (this.entrySetView == null) {
            set = this.entrySetView = this.createEntrySet();
            return set;
        }
        set = this.entrySetView;
        return set;
    }

    Set createEntrySet() {
        return new CompactHashMap$EntrySetView(this);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size != 0) return false;
        return true;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        int n2 = 0;
        while (n2 < this.size) {
            if (Objects.equal(object, this.values[n2])) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public Collection values() {
        Collection collection;
        if (this.valuesView == null) {
            collection = this.valuesView = this.createValues();
            return collection;
        }
        collection = this.valuesView;
        return collection;
    }

    Collection createValues() {
        return new CompactHashMap$ValuesView(this);
    }

    public void trimToSize() {
        int n2;
        double d2;
        int n3 = this.size;
        if (n3 < this.entries.length) {
            this.resizeEntries(n3);
        }
        if ((n2 = Math.max(1, Integer.highestOneBit((int)((float)n3 / this.loadFactor)))) < 1073741824 && (d2 = (double)n3 / (double)n2) > (double)this.loadFactor) {
            n2 <<= 1;
        }
        if (n2 >= this.table.length) return;
        this.resizeTable(n2);
    }

    @Override
    public void clear() {
        ++this.modCount;
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        int n2 = 0;
        while (n2 < this.size) {
            objectOutputStream.writeObject(this.keys[n2]);
            objectOutputStream.writeObject(this.values[n2]);
            ++n2;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        objectInputStream.defaultReadObject();
        this.init(3, 1.0f);
        int n3 = n2 = objectInputStream.readInt();
        while (--n3 >= 0) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
        }
    }

    static /* synthetic */ int access$000(CompactHashMap compactHashMap) {
        return compactHashMap.size;
    }

    static /* synthetic */ Object access$100(CompactHashMap compactHashMap, int n2) {
        return compactHashMap.removeEntry(n2);
    }

    static /* synthetic */ int access$200(CompactHashMap compactHashMap, Object object) {
        return compactHashMap.indexOf(object);
    }
}

