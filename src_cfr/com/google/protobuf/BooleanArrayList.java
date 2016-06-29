/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$BooleanList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class BooleanArrayList
extends AbstractProtobufList
implements Internal$BooleanList,
RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;
    private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList();
    private boolean[] array;
    private int size;

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    BooleanArrayList() {
        this.array = new boolean[10];
        this.size = 0;
    }

    BooleanArrayList(List list) {
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList)list;
            this.array = (boolean[])booleanArrayList.array.clone();
            this.size = booleanArrayList.size;
            return;
        }
        this.size = list.size();
        this.array = new boolean[this.size];
        int n2 = 0;
        while (n2 < this.size) {
            this.array[n2] = (Boolean)list.get(n2);
            ++n2;
        }
    }

    public Boolean get(int n2) {
        return this.getBoolean(n2);
    }

    @Override
    public boolean getBoolean(int n2) {
        this.ensureIndexInRange(n2);
        return this.array[n2];
    }

    @Override
    public int size() {
        return this.size;
    }

    public Boolean set(int n2, Boolean bl2) {
        return this.setBoolean(n2, bl2);
    }

    @Override
    public boolean setBoolean(int n2, boolean bl2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        boolean bl3 = this.array[n2];
        this.array[n2] = bl2;
        return bl3;
    }

    public void add(int n2, Boolean bl2) {
        this.addBoolean(n2, bl2);
    }

    @Override
    public void addBoolean(boolean bl2) {
        this.addBoolean(this.size, bl2);
    }

    private void addBoolean(int n2, boolean bl2) {
        this.ensureIsMutable();
        if (n2 < 0) throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        if (n2 > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(n2));
        }
        if (this.size < this.array.length) {
            System.arraycopy(this.array, n2, this.array, n2 + 1, this.size - n2);
        } else {
            int n3 = this.size * 3 / 2 + 1;
            boolean[] arrbl = new boolean[n3];
            System.arraycopy(this.array, 0, arrbl, 0, n2);
            System.arraycopy(this.array, n2, arrbl, n2 + 1, this.size - n2);
            this.array = arrbl;
        }
        this.array[n2] = bl2;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection collection) {
        this.ensureIsMutable();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList)collection;
        if (booleanArrayList.size == 0) {
            return false;
        }
        int n2 = Integer.MAX_VALUE - this.size;
        if (n2 < booleanArrayList.size) {
            throw new OutOfMemoryError();
        }
        int n3 = this.size + booleanArrayList.size;
        if (n3 > this.array.length) {
            this.array = Arrays.copyOf(this.array, n3);
        }
        System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
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
    public Boolean remove(int n2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n2);
        boolean bl2 = this.array[n2];
        System.arraycopy(this.array, n2 + 1, this.array, n2, this.size - n2);
        --this.size;
        ++this.modCount;
        return bl2;
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

