/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$IntList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class IntArrayList
extends AbstractProtobufList
implements Internal$IntList,
RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;
    private static final IntArrayList EMPTY_LIST = new IntArrayList();
    private int[] array;
    private int size;

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    IntArrayList() {
        this.array = new int[10];
        this.size = 0;
    }

    IntArrayList(List list) {
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList)list;
            this.array = (int[])intArrayList.array.clone();
            this.size = intArrayList.size;
            return;
        }
        this.size = list.size();
        this.array = new int[this.size];
        int n2 = 0;
        while (n2 < this.size) {
            this.array[n2] = (Integer)list.get(n2);
            ++n2;
        }
    }

    public Integer get(int n2) {
        return this.getInt(n2);
    }

    @Override
    public int getInt(int n2) {
        this.ensureIndexInRange(n2);
        return this.array[n2];
    }

    @Override
    public int size() {
        return this.size;
    }

    public Integer set(int n2, Integer n3) {
        return this.setInt(n2, n3);
    }

    @Override
    public int setInt(int n2, int n3) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        int n4 = this.array[n2];
        this.array[n2] = n3;
        return n4;
    }

    public void add(int n2, Integer n3) {
        this.addInt(n2, n3);
    }

    @Override
    public void addInt(int n2) {
        this.addInt(this.size, n2);
    }

    private void addInt(int n2, int n3) {
        this.ensureIsMutable();
        if (n2 < 0) throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n2, this.array, n2 + 1, this.size - n2);
        } else {
            int n4 = this.size * 3 / 2 + 1;
            int[] arrn = new int[n4];
            System.arraycopy(this.array, 0, arrn, 0, n2);
            System.arraycopy(this.array, n2, arrn, n2 + 1, this.size - n2);
            this.array = arrn;
        }
        this.array[n2] = n3;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList)collection;
        if (intArrayList.size == 0) {
            return false;
        }
        int n2 = Integer.MAX_VALUE - this.size;
        if (n2 < intArrayList.size) {
            throw new OutOfMemoryError();
        }
        int n3 = this.size + intArrayList.size;
        if (n3 > this.array.length) {
            this.array = Arrays.copyOf(this.array, n3);
        }
        System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
        this.size = n3;
        ++this.modCount;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        this.ensureIsMutable();
        int n2 = 0;
        while (n2 < this.size) {
            if (object.equals(this.array[n2])) {
                System.arraycopy(this.array, n2 + 1, this.array, n2, this.size - n2);
                --this.size;
                ++this.modCount;
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public Integer remove(int n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        int n3 = this.array[n2];
        System.arraycopy(this.array, n2 + 1, this.array, n2, this.size - n2);
        --this.size;
        ++this.modCount;
        return n3;
    }

    private void ensureIndexInRange(int n2) {
        if (n2 < 0) throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        if (n2 < this.size) return;
        throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
    }

    private String makeOutOfBoundsExceptionMessage(int n2) {
        int n3 = n2;
        int n4 = this.size;
        return new StringBuilder(35).append("Index:").append(n3).append(", Size:").append(n4).toString();
    }

    static {
        EMPTY_LIST.makeImmutable();
    }
}

