package com.google.protobuf;

import java.util.*;

final class BooleanArrayList extends AbstractProtobufList implements Internal$BooleanList, RandomAccess
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final BooleanArrayList EMPTY_LIST;
    private boolean[] array;
    private int size;
    
    public static BooleanArrayList emptyList() {
        return BooleanArrayList.EMPTY_LIST;
    }
    
    BooleanArrayList() {
        this.array = new boolean[10];
        this.size = 0;
    }
    
    BooleanArrayList(final List list) {
        if (list instanceof BooleanArrayList) {
            final BooleanArrayList list2 = (BooleanArrayList)list;
            this.array = list2.array.clone();
            this.size = list2.size;
        }
        else {
            this.size = list.size();
            this.array = new boolean[this.size];
            for (int i = 0; i < this.size; ++i) {
                this.array[i] = list.get(i);
            }
        }
    }
    
    public Boolean get(final int n) {
        return this.getBoolean(n);
    }
    
    public boolean getBoolean(final int n) {
        this.ensureIndexInRange(n);
        return this.array[n];
    }
    
    public int size() {
        return this.size;
    }
    
    public Boolean set(final int n, final Boolean b) {
        return this.setBoolean(n, b);
    }
    
    public boolean setBoolean(final int n, final boolean b) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final boolean b2 = this.array[n];
        this.array[n] = b;
        return b2;
    }
    
    public void add(final int n, final Boolean b) {
        this.addBoolean(n, b);
    }
    
    public void addBoolean(final boolean b) {
        this.addBoolean(this.size, b);
    }
    
    private void addBoolean(final int n, final boolean b) {
        this.ensureIsMutable();
        if (n < 0 || n > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n, this.array, n + 1, this.size - n);
        }
        else {
            final boolean[] array = new boolean[this.size * 3 / 2 + 1];
            System.arraycopy(this.array, 0, array, 0, n);
            System.arraycopy(this.array, n, array, n + 1, this.size - n);
            this.array = array;
        }
        this.array[n] = b;
        ++this.size;
        ++this.modCount;
    }
    
    public boolean addAll(final Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        final BooleanArrayList list = (BooleanArrayList)collection;
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
    
    public Boolean remove(final int n) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final boolean b = this.array[n];
        System.arraycopy(this.array, n + 1, this.array, n, this.size - n);
        --this.size;
        ++this.modCount;
        return b;
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
        (EMPTY_LIST = new BooleanArrayList()).makeImmutable();
    }
}
