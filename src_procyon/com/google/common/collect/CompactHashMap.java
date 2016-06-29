package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactHashMap extends AbstractMap implements Serializable
{
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
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
    
    public static CompactHashMap createWithExpectedSize(final int n) {
        return new CompactHashMap(n);
    }
    
    CompactHashMap() {
        this.init(3, 1.0f);
    }
    
    CompactHashMap(final int n) {
        this(n, 1.0f);
    }
    
    CompactHashMap(final int n, final float n2) {
        this.init(n, n2);
    }
    
    void init(final int n, final float loadFactor) {
        Preconditions.checkArgument(n >= 0, (Object)"Initial capacity must be non-negative");
        Preconditions.checkArgument(loadFactor > 0.0f, (Object)"Illegal load factor");
        final int closedTableSize = Hashing.closedTableSize(n, loadFactor);
        this.table = newTable(closedTableSize);
        this.loadFactor = loadFactor;
        this.keys = new Object[n];
        this.values = new Object[n];
        this.entries = newEntries(n);
        this.threshold = Math.max(1, (int)(closedTableSize * loadFactor));
    }
    
    private static int[] newTable(final int n) {
        final int[] array = new int[n];
        Arrays.fill(array, -1);
        return array;
    }
    
    private static long[] newEntries(final int n) {
        final long[] array = new long[n];
        Arrays.fill(array, -1L);
        return array;
    }
    
    private int hashTableMask() {
        return this.table.length - 1;
    }
    
    private static int getHash(final long n) {
        return (int)(n >>> 32);
    }
    
    private static int getNext(final long n) {
        return (int)n;
    }
    
    private static long swapNext(final long n, final int n2) {
        return (0xFFFFFFFF00000000L & n) | (0xFFFFFFFFL & n2);
    }
    
    void accessEntry(final int n) {
    }
    
    @Nullable
    @Override
    public Object put(@Nullable final Object o, @Nullable final Object o2) {
        final long[] entries = this.entries;
        final Object[] keys = this.keys;
        final Object[] values = this.values;
        final int smearedHash = Hashing.smearedHash(o);
        final int n = smearedHash & this.hashTableMask();
        final int size = this.size;
        int i = this.table[n];
        if (i == -1) {
            this.table[n] = size;
        }
        else {
            int n2;
            long n3;
            do {
                n2 = i;
                n3 = entries[i];
                if (getHash(n3) == smearedHash && Objects.equal(o, keys[i])) {
                    final Object o3 = values[i];
                    values[i] = o2;
                    this.accessEntry(i);
                    return o3;
                }
                i = getNext(n3);
            } while (i != -1);
            entries[n2] = swapNext(n3, size);
        }
        if (size == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        final int size2 = size + 1;
        this.resizeMeMaybe(size2);
        this.insertEntry(size, o, o2, smearedHash);
        this.size = size2;
        if (size >= this.threshold) {
            this.resizeTable(2 * this.table.length);
        }
        ++this.modCount;
        return null;
    }
    
    void insertEntry(final int n, @Nullable final Object o, @Nullable final Object o2, final int n2) {
        this.entries[n] = (n2 << 32 | 0xFFFFFFFFL);
        this.keys[n] = o;
        this.values[n] = o2;
    }
    
    private void resizeMeMaybe(final int n) {
        final int length = this.entries.length;
        if (n > length) {
            int n2 = length + Math.max(1, length >>> 1);
            if (n2 < 0) {
                n2 = Integer.MAX_VALUE;
            }
            if (n2 != length) {
                this.resizeEntries(n2);
            }
        }
    }
    
    void resizeEntries(final int n) {
        this.keys = Arrays.copyOf(this.keys, n);
        this.values = Arrays.copyOf(this.values, n);
        final long[] entries = this.entries;
        final int length = entries.length;
        final long[] copy = Arrays.copyOf(entries, n);
        if (n > length) {
            Arrays.fill(copy, length, n, -1L);
        }
        this.entries = copy;
    }
    
    private void resizeTable(final int n) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        final int threshold = 1 + (int)(n * this.loadFactor);
        final int[] table = newTable(n);
        final long[] entries = this.entries;
        final int n2 = table.length - 1;
        for (int i = 0; i < this.size; ++i) {
            final int hash = getHash(entries[i]);
            final int n3 = hash & n2;
            entries[table[n3] = i] = (hash << 32 | (0xFFFFFFFFL & table[n3]));
        }
        this.threshold = threshold;
        this.table = table;
    }
    
    private int indexOf(@Nullable final Object o) {
        final int smearedHash = Hashing.smearedHash(o);
        long n;
        for (int i = this.table[smearedHash & this.hashTableMask()]; i != -1; i = getNext(n)) {
            n = this.entries[i];
            if (getHash(n) == smearedHash && Objects.equal(o, this.keys[i])) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.indexOf(o) != -1;
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        final int index = this.indexOf(o);
        this.accessEntry(index);
        return (index == -1) ? null : this.values[index];
    }
    
    @Nullable
    @Override
    public Object remove(@Nullable final Object o) {
        return this.remove(o, Hashing.smearedHash(o));
    }
    
    private Object removeEntry(final int n) {
        return this.remove(this.keys[n], getHash(this.entries[n]));
    }
    
    @Nullable
    private Object remove(@Nullable final Object o, final int n) {
        final int n2 = n & this.hashTableMask();
        int next = this.table[n2];
        if (next == -1) {
            return null;
        }
        int n3 = -1;
        while (getHash(this.entries[next]) != n || !Objects.equal(o, this.keys[next])) {
            n3 = next;
            next = getNext(this.entries[next]);
            if (next == -1) {
                return null;
            }
        }
        final Object o2 = this.values[next];
        if (n3 == -1) {
            this.table[n2] = getNext(this.entries[next]);
        }
        else {
            this.entries[n3] = swapNext(this.entries[n3], getNext(this.entries[next]));
        }
        this.moveLastEntry(next);
        --this.size;
        ++this.modCount;
        return o2;
    }
    
    void moveLastEntry(final int n) {
        final int n2 = this.size() - 1;
        if (n < n2) {
            this.keys[n] = this.keys[n2];
            this.values[n] = this.values[n2];
            this.keys[n2] = null;
            this.values[n2] = null;
            final long n3 = this.entries[n2];
            this.entries[n] = n3;
            this.entries[n2] = -1L;
            final int n4 = getHash(n3) & this.hashTableMask();
            int i = this.table[n4];
            if (i == n2) {
                this.table[n4] = n;
            }
            else {
                int n5;
                long n6;
                do {
                    n5 = i;
                    i = getNext(n6 = this.entries[i]);
                } while (i != n2);
                this.entries[n5] = swapNext(n6, n);
            }
        }
        else {
            this.keys[n] = null;
            this.values[n] = null;
            this.entries[n] = -1L;
        }
    }
    
    @Override
    public Set keySet() {
        return (this.keySetView == null) ? (this.keySetView = this.createKeySet()) : this.keySetView;
    }
    
    Set createKeySet() {
        return new CompactHashMap$KeySetView(this);
    }
    
    @Override
    public Set entrySet() {
        return (this.entrySetView == null) ? (this.entrySetView = this.createEntrySet()) : this.entrySetView;
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
        return this.size == 0;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (Objects.equal(o, this.values[i])) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Collection values() {
        return (this.valuesView == null) ? (this.valuesView = this.createValues()) : this.valuesView;
    }
    
    Collection createValues() {
        return new CompactHashMap$ValuesView(this);
    }
    
    public void trimToSize() {
        final int size = this.size;
        if (size < this.entries.length) {
            this.resizeEntries(size);
        }
        int max = Math.max(1, Integer.highestOneBit((int)(size / this.loadFactor)));
        if (max < 1073741824 && size / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.table.length) {
            this.resizeTable(max);
        }
    }
    
    @Override
    public void clear() {
        ++this.modCount;
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        for (int i = 0; i < this.size; ++i) {
            objectOutputStream.writeObject(this.keys[i]);
            objectOutputStream.writeObject(this.values[i]);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.init(3, 1.0f);
        int int1 = objectInputStream.readInt();
        while (--int1 >= 0) {
            this.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }
}
