package com.google.protobuf;

import java.util.*;

final class IntArrayList extends AbstractProtobufList implements Internal$IntList, RandomAccess
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final IntArrayList EMPTY_LIST;
    private int[] array;
    private int size;
    
    public static IntArrayList emptyList() {
        return IntArrayList.EMPTY_LIST;
    }
    
    IntArrayList() {
        this.array = new int[10];
        this.size = 0;
    }
    
    IntArrayList(final List list) {
        if (list instanceof IntArrayList) {
            final IntArrayList list2 = (IntArrayList)list;
            this.array = list2.array.clone();
            this.size = list2.size;
        }
        else {
            this.size = list.size();
            this.array = new int[this.size];
            for (int i = 0; i < this.size; ++i) {
                this.array[i] = list.get(i);
            }
        }
    }
    
    public Integer get(final int n) {
        return this.getInt(n);
    }
    
    public int getInt(final int n) {
        this.ensureIndexInRange(n);
        return this.array[n];
    }
    
    public int size() {
        return this.size;
    }
    
    public Integer set(final int n, final Integer n2) {
        return this.setInt(n, n2);
    }
    
    public int setInt(final int n, final int n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final int n3 = this.array[n];
        this.array[n] = n2;
        return n3;
    }
    
    public void add(final int n, final Integer n2) {
        this.addInt(n, n2);
    }
    
    public void addInt(final int n) {
        this.addInt(this.size, n);
    }
    
    private void addInt(final int n, final int n2) {
        this.ensureIsMutable();
        if (n < 0 || n > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n, this.array, n + 1, this.size - n);
        }
        else {
            final int[] array = new int[this.size * 3 / 2 + 1];
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
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        final IntArrayList list = (IntArrayList)collection;
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
    
    public Integer remove(final int n) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final int n2 = this.array[n];
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
        (EMPTY_LIST = new IntArrayList()).makeImmutable();
    }
}
