/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Chars$CharArrayAsList
extends AbstractList
implements Serializable,
RandomAccess {
    final char[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0;

    Chars$CharArrayAsList(char[] arrc) {
        this(arrc, 0, arrc.length);
    }

    Chars$CharArrayAsList(char[] arrc, int n2, int n3) {
        this.array = arrc;
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
    public Character get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        return Character.valueOf(this.array[this.start + n2]);
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Character)) return false;
        if (Chars.access$000(this.array, ((Character)object).charValue(), this.start, this.end) == -1) return false;
        return true;
    }

    @Override
    public int indexOf(Object object) {
        if (!(object instanceof Character)) return -1;
        int n2 = Chars.access$000(this.array, ((Character)object).charValue(), this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (!(object instanceof Character)) return -1;
        int n2 = Chars.access$100(this.array, ((Character)object).charValue(), this.start, this.end);
        if (n2 < 0) return -1;
        return n2 - this.start;
    }

    @Override
    public Character set(int n2, Character c2) {
        Preconditions.checkElementIndex(n2, this.size());
        char c3 = this.array[this.start + n2];
        this.array[this.start + n2] = ((Character)Preconditions.checkNotNull(c2)).charValue();
        return Character.valueOf(c3);
    }

    @Override
    public List subList(int n2, int n3) {
        int n4 = this.size();
        Preconditions.checkPositionIndexes(n2, n3, n4);
        if (n2 != n3) return new Chars$CharArrayAsList(this.array, this.start + n2, this.start + n3);
        return Collections.emptyList();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Chars$CharArrayAsList)) return super.equals(object);
        Chars$CharArrayAsList chars$CharArrayAsList = (Chars$CharArrayAsList)object;
        int n2 = this.size();
        if (chars$CharArrayAsList.size() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (this.array[this.start + n3] != chars$CharArrayAsList.array[chars$CharArrayAsList.start + n3]) {
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
            n2 = 31 * n2 + Chars.hashCode(this.array[n3]);
            ++n3;
        }
        return n2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size() * 3);
        stringBuilder.append('[').append(this.array[this.start]);
        int n2 = this.start + 1;
        while (n2 < this.end) {
            stringBuilder.append(", ").append(this.array[n2]);
            ++n2;
        }
        return stringBuilder.append(']').toString();
    }

    char[] toCharArray() {
        int n2 = this.size();
        char[] arrc = new char[n2];
        System.arraycopy(this.array, this.start, arrc, 0, n2);
        return arrc;
    }
}

