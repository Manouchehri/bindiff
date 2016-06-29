/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$LongList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class LongArrayList
extends AbstractProtobufList
implements Internal$LongList,
RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;
    private static final LongArrayList EMPTY_LIST = new LongArrayList();
    private long[] array;
    private int size;

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    LongArrayList() {
        this.array = new long[10];
        this.size = 0;
    }

    LongArrayList(List list) {
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList)list;
            this.array = (long[])longArrayList.array.clone();
            this.size = longArrayList.size;
            return;
        }
        this.size = list.size();
        this.array = new long[this.size];
        int n2 = 0;
        while (n2 < this.size) {
            this.array[n2] = (Long)list.get(n2);
            ++n2;
        }
    }

    public Long get(int n2) {
        return this.getLong(n2);
    }

    @Override
    public long getLong(int n2) {
        this.ensureIndexInRange(n2);
        return this.array[n2];
    }

    @Override
    public int size() {
        return this.size;
    }

    public Long set(int n2, Long l2) {
        return this.setLong(n2, l2);
    }

    @Override
    public long setLong(int n2, long l2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        long l3 = this.array[n2];
        this.array[n2] = l2;
        return l3;
    }

    public void add(int n2, Long l2) {
        this.addLong(n2, l2);
    }

    @Override
    public void addLong(long l2) {
        this.addLong(this.size, l2);
    }

    private void addLong(int n2, long l2) {
        this.ensureIsMutable();
        if (n2 < 0) throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n2, this.array, n2 + 1, this.size - n2);
        } else {
            int n3 = this.size * 3 / 2 + 1;
            long[] arrl = new long[n3];
            System.arraycopy(this.array, 0, arrl, 0, n2);
            System.arraycopy(this.array, n2, arrl, n2 + 1, this.size - n2);
            this.array = arrl;
        }
        this.array[n2] = l2;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList)collection;
        if (longArrayList.size == 0) {
            return false;
        }
        int n2 = Integer.MAX_VALUE - this.size;
        if (n2 < longArrayList.size) {
            throw new OutOfMemoryError();
        }
        int n3 = this.size + longArrayList.size;
        if (n3 > this.array.length) {
            this.array = Arrays.copyOf(this.array, n3);
        }
        System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
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
    public Long remove(int n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        long l2 = this.array[n2];
        System.arraycopy(this.array, n2 + 1, this.array, n2, this.size - n2);
        --this.size;
        ++this.modCount;
        return l2;
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

