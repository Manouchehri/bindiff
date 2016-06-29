/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Shorts;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Shorts$ShortArrayAsList
extends AbstractList
implements Serializable,
RandomAccess {
    final short[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0;

    Shorts$ShortArrayAsList(short[] arrs) {
        this(arrs, 0, arrs.length);
    }

    Shorts$ShortArrayAsList(short[] arrs, int n2, int n3) {
        this.array = arrs;
        this.start = n2;
        this.end = n3;
    }

    @Override
    public int size() {
        return this.end - this.start;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Short get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return this.array[this.start + n2];
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Short)) return false;
        if (Shorts.access$000(this.array, (Short)object, this.start, this.end) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(Object object) {
        if (!(object instanceof Short)) return -1;
        int n2 = Shorts.access$000(this.array, (Short)object, this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!(object instanceof Short)) return -1;
        int n2 = Shorts.access$100(this.array, (Short)object, this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public Short set(int n2, Short s2) {
        Preconditions.checkElementIndex(n2, this.size());
        short s3 = this.array[this.start + n2];
        this.array[this.start + n2] = (Short)Preconditions.checkNotNull(s2);
        return s3;
    }

    @Override
    public List subList(int n2, int n3) {
        int n4 = this.size();
        Preconditions.checkPositionIndexes(n2, n3, n4);
        if (n2 != n3) return new Shorts$ShortArrayAsList(this.array, this.start + n2, this.start + n3);
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Shorts$ShortArrayAsList)) return super.equals(object);
        Shorts$ShortArrayAsList shorts$ShortArrayAsList = (Shorts$ShortArrayAsList)object;
        int n2 = this.size();
        if (shorts$ShortArrayAsList.size() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.array[this.start + n3] != shorts$ShortArrayAsList.array[shorts$ShortArrayAsList.start + n3]) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = 1;
        int n3 = this.start;
        while (n3 < this.end) {
            n2 = 31 * n2 + Shorts.hashCode(this.array[n3]);
            ++n3;
        }
        return n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size() * 6);
        stringBuilder.append('[').append(this.array[this.start]);
        int n2 = this.start + 1;
        while (n2 < this.end) {
            stringBuilder.append(", ").append(this.array[n2]);
            ++n2;
        }
        return stringBuilder.append(']').toString();
    }

    short[] toShortArray() {
        int n2 = this.size();
        short[] arrs = new short[n2];
        System.arraycopy(this.array, this.start, arrs, 0, n2);
        return arrs;
    }
}

