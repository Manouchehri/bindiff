package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import java.io.*;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactHashSet extends AbstractSet implements Serializable
{
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
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
    
    public static CompactHashSet create(final Collection collection) {
        final CompactHashSet withExpectedSize = createWithExpectedSize(collection.size());
        withExpectedSize.addAll(collection);
        return withExpectedSize;
    }
    
    public static CompactHashSet create(final Object... array) {
        final CompactHashSet withExpectedSize = createWithExpectedSize(array.length);
        Collections.addAll(withExpectedSize, array);
        return withExpectedSize;
    }
    
    public static CompactHashSet createWithExpectedSize(final int n) {
        return new CompactHashSet(n);
    }
    
    CompactHashSet() {
        this.init(3, 1.0f);
    }
    
    CompactHashSet(final int n) {
        this.init(n, 1.0f);
    }
    
    void init(final int n, final float loadFactor) {
        Preconditions.checkArgument(n >= 0, (Object)"Initial capacity must be non-negative");
        Preconditions.checkArgument(loadFactor > 0.0f, (Object)"Illegal load factor");
        final int closedTableSize = Hashing.closedTableSize(n, loadFactor);
        this.table = newTable(closedTableSize);
        this.loadFactor = loadFactor;
        this.elements = new Object[n];
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
    
    private static int getHash(final long n) {
        return (int)(n >>> 32);
    }
    
    private static int getNext(final long n) {
        return (int)n;
    }
    
    private static long swapNext(final long n, final int n2) {
        return (0xFFFFFFFF00000000L & n) | (0xFFFFFFFFL & n2);
    }
    
    private int hashTableMask() {
        return this.table.length - 1;
    }
    
    @Override
    public boolean add(@Nullable final Object o) {
        final long[] entries = this.entries;
        final Object[] elements = this.elements;
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
                if (getHash(n3) == smearedHash && Objects.equal(o, elements[i])) {
                    return false;
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
        this.insertEntry(size, o, smearedHash);
        this.size = size2;
        if (size >= this.threshold) {
            this.resizeTable(2 * this.table.length);
        }
        ++this.modCount;
        return true;
    }
    
    void insertEntry(final int n, final Object o, final int n2) {
        this.entries[n] = (n2 << 32 | 0xFFFFFFFFL);
        this.elements[n] = o;
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
        this.elements = Arrays.copyOf(this.elements, n);
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
    
    @Override
    public boolean contains(@Nullable final Object o) {
        final int smearedHash = Hashing.smearedHash(o);
        long n;
        for (int i = this.table[smearedHash & this.hashTableMask()]; i != -1; i = getNext(n)) {
            n = this.entries[i];
            if (getHash(n) == smearedHash && Objects.equal(o, this.elements[i])) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        return this.remove(o, Hashing.smearedHash(o));
    }
    
    private boolean remove(final Object o, final int n) {
        final int n2 = n & this.hashTableMask();
        int next = this.table[n2];
        if (next == -1) {
            return false;
        }
        int n3 = -1;
        while (getHash(this.entries[next]) != n || !Objects.equal(o, this.elements[next])) {
            n3 = next;
            next = getNext(this.entries[next]);
            if (next == -1) {
                return false;
            }
        }
        if (n3 == -1) {
            this.table[n2] = getNext(this.entries[next]);
        }
        else {
            this.entries[n3] = swapNext(this.entries[n3], getNext(this.entries[next]));
        }
        this.moveEntry(next);
        --this.size;
        ++this.modCount;
        return true;
    }
    
    void moveEntry(final int n) {
        final int n2 = this.size() - 1;
        if (n < n2) {
            this.elements[n] = this.elements[n2];
            this.elements[n2] = null;
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
            this.elements[n] = null;
            this.entries[n] = -1L;
        }
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
        return this.size == 0;
    }
    
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return ObjectArrays.toArrayImpl(this.elements, 0, this.size, array);
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
        Arrays.fill(this.elements, 0, this.size, null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        final Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            objectOutputStream.writeObject(iterator.next());
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.init(3, 1.0f);
        int int1 = objectInputStream.readInt();
        while (--int1 >= 0) {
            this.add(objectInputStream.readObject());
        }
    }
}
