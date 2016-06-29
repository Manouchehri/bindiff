/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Floats$FloatArrayAsList
extends AbstractList
implements Serializable,
RandomAccess {
    final float[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0;

    Floats$FloatArrayAsList(float[] arrf) {
        this(arrf, 0, arrf.length);
    }

    Floats$FloatArrayAsList(float[] arrf, int n2, int n3) {
        this.array = arrf;
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
    public Float get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return Float.valueOf(this.array[this.start + n2]);
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Float)) return false;
        if (Floats.access$000(this.array, ((Float)object).floatValue(), this.start, this.end) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(Object object) {
        if (!(object instanceof Float)) return -1;
        int n2 = Floats.access$000(this.array, ((Float)object).floatValue(), this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!(object instanceof Float)) return -1;
        int n2 = Floats.access$100(this.array, ((Float)object).floatValue(), this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public Float set(int n2, Float f2) {
        Preconditions.checkElementIndex(n2, this.size());
        float f3 = this.array[this.start + n2];
        this.array[this.start + n2] = ((Float)Preconditions.checkNotNull(f2)).floatValue();
        return Float.valueOf(f3);
    }

    @Override
    public List subList(int n2, int n3) {
        int n4 = this.size();
        Preconditions.checkPositionIndexes(n2, n3, n4);
        if (n2 != n3) return new Floats$FloatArrayAsList(this.array, this.start + n2, this.start + n3);
        return Collections.emptyList();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Floats$FloatArrayAsList)) return super.equals(object);
        Floats$FloatArrayAsList floats$FloatArrayAsList = (Floats$FloatArrayAsList)object;
        int n2 = this.size();
        if (floats$FloatArrayAsList.size() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.array[this.start + n3] != floats$FloatArrayAsList.array[floats$FloatArrayAsList.start + n3]) {
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
            n2 = 31 * n2 + Floats.hashCode(this.array[n3]);
            ++n3;
        }
        return n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size() * 12);
        stringBuilder.append('[').append(this.array[this.start]);
        int n2 = this.start + 1;
        while (n2 < this.end) {
            stringBuilder.append(", ").append(this.array[n2]);
            ++n2;
        }
        return stringBuilder.append(']').toString();
    }

    float[] toFloatArray() {
        int n2 = this.size();
        float[] arrf = new float[n2];
        System.arraycopy(this.array, this.start, arrf, 0, n2);
        return arrf;
    }
}

