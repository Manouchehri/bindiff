/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Bytes;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Bytes$ByteArrayAsList
extends AbstractList
implements Serializable,
RandomAccess {
    final byte[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0;

    Bytes$ByteArrayAsList(byte[] arrby) {
        this(arrby, 0, arrby.length);
    }

    Bytes$ByteArrayAsList(byte[] arrby, int n2, int n3) {
        this.array = arrby;
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
    public Byte get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return Byte.valueOf(this.array[this.start + n2]);
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Byte)) return false;
        if (Bytes.access$000(this.array, ((Byte)object).byteValue(), this.start, this.end) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(Object object) {
        if (!(object instanceof Byte)) return -1;
        int n2 = Bytes.access$000(this.array, ((Byte)object).byteValue(), this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!(object instanceof Byte)) return -1;
        int n2 = Bytes.access$100(this.array, ((Byte)object).byteValue(), this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public Byte set(int n2, Byte by2) {
        Preconditions.checkElementIndex(n2, this.size());
        byte by3 = this.array[this.start + n2];
        this.array[this.start + n2] = ((Byte)Preconditions.checkNotNull(by2)).byteValue();
        return Byte.valueOf(by3);
    }

    @Override
    public List subList(int n2, int n3) {
        int n4 = this.size();
        Preconditions.checkPositionIndexes(n2, n3, n4);
        if (n2 != n3) return new Bytes$ByteArrayAsList(this.array, this.start + n2, this.start + n3);
        return Collections.emptyList();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Bytes$ByteArrayAsList)) return super.equals(object);
        Bytes$ByteArrayAsList bytes$ByteArrayAsList = (Bytes$ByteArrayAsList)object;
        int n2 = this.size();
        if (bytes$ByteArrayAsList.size() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.array[this.start + n3] != bytes$ByteArrayAsList.array[bytes$ByteArrayAsList.start + n3]) {
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
            n2 = 31 * n2 + Bytes.hashCode(this.array[n3]);
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

    byte[] toByteArray() {
        int n2 = this.size();
        byte[] arrby = new byte[n2];
        System.arraycopy(this.array, this.start, arrby, 0, n2);
        return arrby;
    }
}

