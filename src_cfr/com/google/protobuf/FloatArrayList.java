/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$FloatList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class FloatArrayList
extends AbstractProtobufList
implements Internal$FloatList,
RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;
    private static final FloatArrayList EMPTY_LIST = new FloatArrayList();
    private float[] array;
    private int size;

    public static FloatArrayList emptyList() {
        return EMPTY_LIST;
    }

    FloatArrayList() {
        this.array = new float[10];
        this.size = 0;
    }

    FloatArrayList(List list) {
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList)list;
            this.array = (float[])floatArrayList.array.clone();
            this.size = floatArrayList.size;
            return;
        }
        this.size = list.size();
        this.array = new float[this.size];
        int n2 = 0;
        while (n2 < this.size) {
            this.array[n2] = ((Float)list.get(n2)).floatValue();
            ++n2;
        }
    }

    public Float get(int n2) {
        return Float.valueOf(this.getFloat(n2));
    }

    @Override
    public float getFloat(int n2) {
        this.ensureIndexInRange(n2);
        return this.array[n2];
    }

    @Override
    public int size() {
        return this.size;
    }

    public Float set(int n2, Float f2) {
        return Float.valueOf(this.setFloat(n2, f2.floatValue()));
    }

    @Override
    public float setFloat(int n2, float f2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        float f3 = this.array[n2];
        this.array[n2] = f2;
        return f3;
    }

    public void add(int n2, Float f2) {
        this.addFloat(n2, f2.floatValue());
    }

    @Override
    public void addFloat(float f2) {
        this.addFloat(this.size, f2);
    }

    private void addFloat(int n2, float f2) {
        this.ensureIsMutable();
        if (n2 < 0) throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n2, this.array, n2 + 1, this.size - n2);
        } else {
            int n3 = this.size * 3 / 2 + 1;
            float[] arrf = new float[n3];
            System.arraycopy(this.array, 0, arrf, 0, n2);
            System.arraycopy(this.array, n2, arrf, n2 + 1, this.size - n2);
            this.array = arrf;
        }
        this.array[n2] = f2;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList)collection;
        if (floatArrayList.size == 0) {
            return false;
        }
        int n2 = Integer.MAX_VALUE - this.size;
        if (n2 < floatArrayList.size) {
            throw new OutOfMemoryError();
        }
        int n3 = this.size + floatArrayList.size;
        if (n3 > this.array.length) {
            this.array = Arrays.copyOf(this.array, n3);
        }
        System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
        this.size = n3;
        ++this.modCount;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        this.ensureIsMutable();
        int n2 = 0;
        while (n2 < this.size) {
            if (object.equals(Float.valueOf(this.array[n2]))) {
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
    public Float remove(int n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        float f2 = this.array[n2];
        System.arraycopy(this.array, n2 + 1, this.array, n2, this.size - n2);
        --this.size;
        ++this.modCount;
        return Float.valueOf(f2);
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

