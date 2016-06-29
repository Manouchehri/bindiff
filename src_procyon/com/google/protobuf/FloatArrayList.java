package com.google.protobuf;

import java.util.*;

final class FloatArrayList extends AbstractProtobufList implements Internal$FloatList, RandomAccess
{
    private static final int DEFAULT_CAPACITY = 10;
    private static final FloatArrayList EMPTY_LIST;
    private float[] array;
    private int size;
    
    public static FloatArrayList emptyList() {
        return FloatArrayList.EMPTY_LIST;
    }
    
    FloatArrayList() {
        this.array = new float[10];
        this.size = 0;
    }
    
    FloatArrayList(final List list) {
        if (list instanceof FloatArrayList) {
            final FloatArrayList list2 = (FloatArrayList)list;
            this.array = list2.array.clone();
            this.size = list2.size;
        }
        else {
            this.size = list.size();
            this.array = new float[this.size];
            for (int i = 0; i < this.size; ++i) {
                this.array[i] = list.get(i);
            }
        }
    }
    
    public Float get(final int n) {
        return this.getFloat(n);
    }
    
    public float getFloat(final int n) {
        this.ensureIndexInRange(n);
        return this.array[n];
    }
    
    public int size() {
        return this.size;
    }
    
    public Float set(final int n, final Float n2) {
        return this.setFloat(n, n2);
    }
    
    public float setFloat(final int n, final float n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final float n3 = this.array[n];
        this.array[n] = n2;
        return n3;
    }
    
    public void add(final int n, final Float n2) {
        this.addFloat(n, n2);
    }
    
    public void addFloat(final float n) {
        this.addFloat(this.size, n);
    }
    
    private void addFloat(final int n, final float n2) {
        this.ensureIsMutable();
        if (n < 0 || n > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n, this.array, n + 1, this.size - n);
        }
        else {
            final float[] array = new float[this.size * 3 / 2 + 1];
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
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        final FloatArrayList list = (FloatArrayList)collection;
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
    
    public Float remove(final int n) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n);
        final float n2 = this.array[n];
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
        (EMPTY_LIST = new FloatArrayList()).makeImmutable();
    }
}
