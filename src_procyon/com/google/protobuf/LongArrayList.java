package com.google.protobuf;

import java.util.*;

final class LongArrayList extends AbstractProtobufList implements Internal$LongList, RandomAccess
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final LongArrayList EMPTY_LIST;
    private long[] array;
    private int size;
    
    public static LongArrayList emptyList() {
        return LongArrayList.EMPTY_LIST;
    }
    
    LongArrayList() {
        this.array = new long[10];
        this.size = 0;
    }
    
    LongArrayList(final List list) {
        if (list instanceof LongArrayList) {
            final LongArrayList list2 = (LongArrayList)list;
            this.array = list2.array.clone();
            this.size = list2.size;
        }
        else {
            this.size = list.size();
            this.array = new long[this.size];
            for (int i = 0; i < this.size; ++i) {
                this.array[i] = list.get(i);
            }
        }
    }
    
    public Long get(final int n) {
        return this.getLong(n);
    }
    
    public long getLong(final int n) {
        this.ensureIndexInRange(n);
        return this.array[n];
    }
    
    public int size() {
        return this.size;
    }
    
    public Long set(final int n, final Long n2) {
        return this.setLong(n, n2);
    }
    
    public long setLong(final int n, final long n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final long n3 = this.array[n];
        this.array[n] = n2;
        return n3;
    }
    
    public void add(final int n, final Long n2) {
        this.addLong(n, n2);
    }
    
    public void addLong(final long n) {
        this.addLong(this.size, n);
    }
    
    private void addLong(final int n, final long n2) {
        this.ensureIsMutable();
        if (n < 0 || n > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n, this.array, n + 1, this.size - n);
        }
        else {
            final long[] array = new long[this.size * 3 / 2 + 1];
            System.arraycopy(this.array, 0, array, 0, n);
            System.arraycopy(this.array, n, array, n + 1, this.size - n);
            this.array = array;
        }
        this.array[n] = n2;
        ++this.size;
        ++this.modCount;
    }
    
    public boolean addAll(final Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        final LongArrayList list = (LongArrayList)collection;
        if (list.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < list.size) {
            throw new OutOfMemoryError();
        }
        final int size = this.size + list.size;
        if (size > this.array.length) {
            this.array = Arrays.copyOf(this.array, size);
        }
        System.arraycopy(list.array, 0, this.array, this.size, list.size);
        this.size = size;
        ++this.modCount;
        return true;
    }
    
    public boolean remove(final Object o) {
        this.ensureIsMutable();
        for (int i = 0; i < this.size; ++i) {
            if (o.equals(this.array[i])) {
                System.arraycopy(this.array, i + 1, this.array, i, this.size - i);
                --this.size;
                ++this.modCount;
                return true;
            }
        }
        return false;
    }
    
    public Long remove(final int n) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final long n2 = this.array[n];
        System.arraycopy(this.array, n + 1, this.array, n, this.size - n);
        --this.size;
        ++this.modCount;
        return n2;
    }
    
    private void ensureIndexInRange(final int n) {
        if (n < 0 || n >= this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n));
        }
    }
    
    private String makeOutOfBoundsExceptionMessage(final int n) {
        return new StringBuilder(35).append("Index:").append(n).append(", Size:").append(this.size).toString();
    }
    
    static {
        (EMPTY_LIST = new LongArrayList()).makeImmutable();
    }
}
