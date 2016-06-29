/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Ints$IntArrayAsList
extends AbstractList
implements Serializable,
RandomAccess {
    final int[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0;

    Ints$IntArrayAsList(int[] arrn) {
        this(arrn, 0, arrn.length);
    }

    Ints$IntArrayAsList(int[] arrn, int n2, int n3) {
        this.array = arrn;
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
    public Integer get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return this.array[this.start + n2];
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Integer)) return false;
        if (Ints.access$000(this.array, (Integer)object, this.start, this.end) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(Object object) {
        if (!(object instanceof Integer)) return -1;
        int n2 = Ints.access$000(this.array, (Integer)object, this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!(object instanceof Integer)) return -1;
        int n2 = Ints.access$100(this.array, (Integer)object, this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public Integer set(int n2, Integer n3) {
        Preconditions.checkElementIndex(n2, this.size());
        int n4 = this.array[this.start + n2];
        this.array[this.start + n2] = (Integer)Preconditions.checkNotNull(n3);
        return n4;
    }

    @Override
    public List subList(int n2, int n3) {
        int n4 = this.size();
        Preconditions.checkPositionIndexes(n2, n3, n4);
        if (n2 != n3) return new Ints$IntArrayAsList(this.array, this.start + n2, this.start + n3);
        return Collections.emptyList();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Ints$IntArrayAsList)) return super.equals(object);
        Ints$IntArrayAsList ints$IntArrayAsList = (Ints$IntArrayAsList)object;
        int n2 = this.size();
        if (ints$IntArrayAsList.size() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.array[this.start + n3] != ints$IntArrayAsList.array[ints$IntArrayAsList.start + n3]) {
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
            n2 = 31 * n2 + Ints.hashCode(this.array[n3]);
            ++n3;
        }
        return n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size() * 5);
        stringBuilder.append('[').append(this.array[this.start]);
        int n2 = this.start + 1;
        while (n2 < this.end) {
            stringBuilder.append(", ").append(this.array[n2]);
            ++n2;
        }
        return stringBuilder.append(']').toString();
    }

    int[] toIntArray() {
        int n2 = this.size();
        int[] arrn = new int[n2];
        System.arraycopy(this.array, this.start, arrn, 0, n2);
        return arrn;
    }
}

