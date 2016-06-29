/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$DoubleList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class DoubleArrayList
extends AbstractProtobufList
implements Internal$DoubleList,
RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;
    private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList();
    private double[] array;
    private int size;

    public static DoubleArrayList emptyList() {
        return EMPTY_LIST;
    }

    DoubleArrayList() {
        this.array = new double[10];
        this.size = 0;
    }

    DoubleArrayList(List list) {
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList)list;
            this.array = (double[])doubleArrayList.array.clone();
            this.size = doubleArrayList.size;
            return;
        }
        this.size = list.size();
        this.array = new double[this.size];
        int n2 = 0;
        while (n2 < this.size) {
            this.array[n2] = (Double)list.get(n2);
            ++n2;
        }
    }

    public Double get(int n2) {
        return this.getDouble(n2);
    }

    @Override
    public double getDouble(int n2) {
        this.ensureIndexInRange(n2);
        return this.array[n2];
    }

    @Override
    public int size() {
        return this.size;
    }

    public Double set(int n2, Double d2) {
        return this.setDouble(n2, d2);
    }

    @Override
    public double setDouble(int n2, double d2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        double d3 = this.array[n2];
        this.array[n2] = d2;
        return d3;
    }

    public void add(int n2, Double d2) {
        this.addDouble(n2, d2);
    }

    @Override
    public void addDouble(double d2) {
        this.addDouble(this.size, d2);
    }

    private void addDouble(int n2, double d2) {
        this.ensureIsMutable();
        if (n2 < 0) throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n2, this.array, n2 + 1, this.size - n2);
        } else {
            int n3 = this.size * 3 / 2 + 1;
            double[] arrd = new double[n3];
            System.arraycopy(this.array, 0, arrd, 0, n2);
            System.arraycopy(this.array, n2, arrd, n2 + 1, this.size - n2);
            this.array = arrd;
        }
        this.array[n2] = d2;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList)collection;
        if (doubleArrayList.size == 0) {
            return false;
        }
        int n2 = Integer.MAX_VALUE - this.size;
        if (n2 < doubleArrayList.size) {
            throw new OutOfMemoryError();
        }
        int n3 = this.size + doubleArrayList.size;
        if (n3 > this.array.length) {
            this.array = Arrays.copyOf(this.array, n3);
        }
        System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
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
    public Double remove(int n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        double d2 = this.array[n2];
        System.arraycopy(this.array, n2 + 1, this.array, n2, this.size - n2);
        --this.size;
        ++this.modCount;
        return d2;
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

