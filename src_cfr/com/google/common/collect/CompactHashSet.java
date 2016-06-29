/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashSet$1;
import com.google.common.collect.Hashing;
import com.google.common.collect.ObjectArrays;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible(value="not worth using in GWT for now")
public class CompactHashSet
extends AbstractSet
implements Serializable {
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 0xFFFFFFFFL;
    private static final long HASH_MASK = -4294967296L;
    private static final int DEFAULT_SIZE = 3;
    static final int UNSET = -1;
    private transient int[] table;
    private transient long[] entries;
    transient Object[] elements;
    transient float loadFactor;
    transient int modCount;
    private transient int threshold;
    private transient int size;

    public static CompactHashSet create() {
        return new CompactHashSet();
    }

    public static CompactHashSet create(Collection collection) {
        CompactHashSet compactHashSet = CompactHashSet.createWithExpectedSize(collection.size());
        compactHashSet.addAll(collection);
        return compactHashSet;
    }

    public static /* varargs */ CompactHashSet create(Object ... arrobject) {
        CompactHashSet compactHashSet = CompactHashSet.createWithExpectedSize(arrobject.length);
        Collections.addAll(compactHashSet, arrobject);
        return compactHashSet;
    }

    public static CompactHashSet createWithExpectedSize(int n2) {
        return new CompactHashSet(n2);
    }

    CompactHashSet() {
        this.init(3, 1.0f);
    }

    CompactHashSet(int n2) {
        this.init(n2, 1.0f);
    }

    void init(int n2, float f2) {
        Preconditions.checkArgument(n2 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f2 > 0.0f, "Illegal load factor");
        int n3 = Hashing.closedTableSize(n2, f2);
        this.table = CompactHashSet.newTable(n3);
        this.loadFactor = f2;
        this.elements = new Object[n2];
        this.entries = CompactHashSet.newEntries(n2);
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

    private static int getHash(long l2) {
        return (int)(l2 >>> 32);
    }

    private static int getNext(long l2) {
        return (int)l2;
    }

    private static long swapNext(long l2, int n2) {
        return -4294967296L & l2 | 0xFFFFFFFFL & (long)n2;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    @Override
    public boolean add(@Nullable Object object) {
        int n2;
        long[] arrl = this.entries;
        Object[] arrobject = this.elements;
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
                if (CompactHashSet.getHash(l2) != n3 || !Objects.equal(object, arrobject[n6])) continue;
                return false;
            } while ((n6 = CompactHashSet.getNext(l2)) != -1);
            arrl[n2] = CompactHashSet.swapNext(l2, n5);
        }
        if (n5 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        n2 = n5 + 1;
        this.resizeMeMaybe(n2);
        this.insertEntry(n5, object, n3);
        this.size = n2;
        if (n5 >= this.threshold) {
            this.resizeTable(2 * this.table.length);
        }
        ++this.modCount;
        return true;
    }

    void insertEntry(int n2, Object object, int n3) {
        this.entries[n2] = (long)n3 << 32 | 0xFFFFFFFFL;
        this.elements[n2] = object;
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
        this.elements = Arrays.copyOf(this.elements, n2);
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
        int[] arrn2 = CompactHashSet.newTable(n2);
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
            int n7 = CompactHashSet.getHash(l2);
            int n8 = n7 & n5;
            int n9 = arrn2[n8];
            arrn2[n8] = n6++;
            arrl[n6] = (long)n7 << 32 | 0xFFFFFFFFL & (long)n9;
        } while (true);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        int n2 = Hashing.smearedHash(object);
        int n3 = this.table[n2 & this.hashTableMask()];
        while (n3 != -1) {
            long l2 = this.entries[n3];
            if (CompactHashSet.getHash(l2) == n2 && Objects.equal(object, this.elements[n3])) {
                return true;
            }
            n3 = CompactHashSet.getNext(l2);
        }
        return false;
    }

    @Override
    public boolean remove(@Nullable Object object) {
        return this.remove(object, Hashing.smearedHash(object));
    }

    private boolean remove(Object object, int n2) {
        int n3 = n2 & this.hashTableMask();
        int n4 = this.table[n3];
        if (n4 == -1) {
            return false;
        }
        int n5 = -1;
        do {
            if (CompactHashSet.getHash(this.entries[n4]) == n2 && Objects.equal(object, this.elements[n4])) {
                if (n5 == -1) {
                    this.table[n3] = CompactHashSet.getNext(this.entries[n4]);
                } else {
                    this.entries[n5] = CompactHashSet.swapNext(this.entries[n5], CompactHashSet.getNext(this.entries[n4]));
                }
                this.moveEntry(n4);
                --this.size;
                ++this.modCount;
                return true;
            }
            n5 = n4;
        } while ((n4 = CompactHashSet.getNext(this.entries[n4])) != -1);
        return false;
    }

    void moveEntry(int n2) {
        long l2;
        long l3;
        int n3 = this.size() - 1;
        if (n2 >= n3) {
            this.elements[n2] = null;
            this.entries[n2] = -1;
            return;
        }
        this.elements[n2] = this.elements[n3];
        this.elements[n3] = null;
        this.entries[n2] = l2 = this.entries[n3];
        this.entries[n3] = -1;
        int n4 = CompactHashSet.getHash(l2) & this.hashTableMask();
        int n5 = this.table[n4];
        if (n5 == n3) {
            this.table[n4] = n2;
            return;
        }
        do {
            int n6 = n5;
            l3 = this.entries[n5];
        } while ((n5 = CompactHashSet.getNext(l3)) != n3);
        this.entries[n6] = CompactHashSet.swapNext(l3, n2);
    }

    @Override
    public Iterator iterator() {
        return new CompactHashSet$1(this);
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
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return ObjectArrays.toArrayImpl(this.elements, 0, this.size, arrobject);
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
        Arrays.fill(this.elements, 0, this.size, null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            objectOutputStream.writeObject(e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int n2;
        objectInputStream.defaultReadObject();
        this.init(3, 1.0f);
        int n3 = n2 = objectInputStream.readInt();
        while (--n3 >= 0) {
            Object object = objectInputStream.readObject();
            this.add(object);
        }
    }

    static /* synthetic */ int access$000(CompactHashSet compactHashSet) {
        return compactHashSet.size;
    }

    static /* synthetic */ long[] access$100(CompactHashSet compactHashSet) {
        return compactHashSet.entries;
    }

    static /* synthetic */ int access$200(long l2) {
        return CompactHashSet.getHash(l2);
    }

    static /* synthetic */ boolean access$300(CompactHashSet compactHashSet, Object object, int n2) {
        return compactHashSet.remove(object, n2);
    }
}

