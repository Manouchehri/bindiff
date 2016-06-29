package com.google.protobuf;

import java.util.*;

final class DoubleArrayList extends AbstractProtobufList implements Internal$DoubleList, RandomAccess
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final DoubleArrayList EMPTY_LIST;
    private double[] array;
    private int size;
    
    public static DoubleArrayList emptyList() {
        return DoubleArrayList.EMPTY_LIST;
    }
    
    DoubleArrayList() {
        this.array = new double[10];
        this.size = 0;
    }
    
    DoubleArrayList(final List list) {
        if (list instanceof DoubleArrayList) {
            final DoubleArrayList list2 = (DoubleArrayList)list;
            this.array = list2.array.clone();
            this.size = list2.size;
        }
        else {
            this.size = list.size();
            this.array = new double[this.size];
            for (int i = 0; i < this.size; ++i) {
                this.array[i] = list.get(i);
            }
        }
    }
    
    public Double get(final int n) {
        return this.getDouble(n);
    }
    
    public double getDouble(final int n) {
        this.ensureIndexInRange(n);
        return this.array[n];
    }
    
    public int size() {
        return this.size;
    }
    
    public Double set(final int n, final Double n2) {
        return this.setDouble(n, n2);
    }
    
    public double setDouble(final int n, final double n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final double n3 = this.array[n];
        this.array[n] = n2;
        return n3;
    }
    
    public void add(final int n, final Double n2) {
        this.addDouble(n, n2);
    }
    
    public void addDouble(final double n) {
        this.addDouble(this.size, n);
    }
    
    private void addDouble(final int n, final double n2) {
        this.ensureIsMutable();
        if (n < 0 || n > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n, this.array, n + 1, this.size - n);
        }
        else {
            final double[] array = new double[this.size * 3 / 2 + 1];
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
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        final DoubleArrayList list = (DoubleArrayList)collection;
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
    
    public Double remove(final int n) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final double n2 = this.array[n];
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
        (EMPTY_LIST = new DoubleArrayList()).makeImmutable();
    }
}
