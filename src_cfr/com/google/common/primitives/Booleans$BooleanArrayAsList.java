/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Booleans$BooleanArrayAsList
extends AbstractList
implements Serializable,
RandomAccess {
    final boolean[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0;

    Booleans$BooleanArrayAsList(boolean[] arrbl) {
        this(arrbl, 0, arrbl.length);
    }

    Booleans$BooleanArrayAsList(boolean[] arrbl, int n2, int n3) {
        this.array = arrbl;
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
    public Boolean get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return this.array[this.start + n2];
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Boolean)) return false;
        if (Booleans.access$000(this.array, (Boolean)object, this.start, this.end) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(Object object) {
        if (!(object instanceof Boolean)) return -1;
        int n2 = Booleans.access$000(this.array, (Boolean)object, this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!(object instanceof Boolean)) return -1;
        int n2 = Booleans.access$100(this.array, (Boolean)object, this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public Boolean set(int n2, Boolean bl2) {
        Preconditions.checkElementIndex(n2, this.size());
        boolean bl3 = this.array[this.start + n2];
        this.array[this.start + n2] = (Boolean)Preconditions.checkNotNull(bl2);
        return bl3;
    }

    @Override
    public List subList(int n2, int n3) {
        int n4 = this.size();
        Preconditions.checkPositionIndexes(n2, n3, n4);
        if (n2 != n3) return new Booleans$BooleanArrayAsList(this.array, this.start + n2, this.start + n3);
        return Collections.emptyList();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Booleans$BooleanArrayAsList)) return super.equals(object);
        Booleans$BooleanArrayAsList booleans$BooleanArrayAsList = (Booleans$BooleanArrayAsList)object;
        int n2 = this.size();
        if (booleans$BooleanArrayAsList.size() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.array[this.start + n3] != booleans$BooleanArrayAsList.array[booleans$BooleanArrayAsList.start + n3]) {
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
            n2 = 31 * n2 + Booleans.hashCode(this.array[n3]);
            ++n3;
        }
        return n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size() * 7);
        stringBuilder.append(this.array[this.start] ? "[true" : "[false");
        int n2 = this.start + 1;
        while (n2 < this.end) {
            stringBuilder.append(this.array[n2] ? ", true" : ", false");
            ++n2;
        }
        return stringBuilder.append(']').toString();
    }

    boolean[] toBooleanArray() {
        int n2 = this.size();
        boolean[] arrbl = new boolean[n2];
        System.arraycopy(this.array, this.start, arrbl, 0, n2);
        return arrbl;
    }
}

