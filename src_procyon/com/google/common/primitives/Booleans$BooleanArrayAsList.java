package com.google.common.primitives;

import java.io.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;

@GwtCompatible
class Booleans$BooleanArrayAsList extends AbstractList implements Serializable, RandomAccess
{
    final boolean[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0L;
    
    Booleans$BooleanArrayAsList(final boolean[] array) {
        this(array, 0, array.length);
    }
    
    Booleans$BooleanArrayAsList(final boolean[] array, final int start, final int end) {
        this.array = array;
        this.start = start;
        this.end = end;
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
    public Boolean get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.array[this.start + n];
    }
    
    @Override
    public boolean contains(final Object o) {
        return o instanceof Boolean && indexOf(this.array, (boolean)o, this.start, this.end) != -1;
    }
    
    @Override
    public int indexOf(final Object o) {
        if (o instanceof Boolean) {
            final int access$000 = indexOf(this.array, (boolean)o, this.start, this.end);
            if (access$000 >= 0) {
                return access$000 - this.start;
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        if (o instanceof Boolean) {
            final int access$100 = lastIndexOf(this.array, (boolean)o, this.start, this.end);
            if (access$100 >= 0) {
                return access$100 - this.start;
            }
        }
        return -1;
    }
    
    public Boolean set(final int n, final Boolean b) {
        Preconditions.checkElementIndex(n, this.size());
        final boolean b2 = this.array[this.start + n];
        this.array[this.start + n] = (boolean)Preconditions.checkNotNull(b);
        return b2;
    }
    
    @Override
    public List subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        if (n == n2) {
            return Collections.emptyList();
        }
        return new Booleans$BooleanArrayAsList(this.array, this.start + n, this.start + n2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Booleans$BooleanArrayAsList)) {
            return super.equals(o);
        }
        final Booleans$BooleanArrayAsList list = (Booleans$BooleanArrayAsList)o;
        final int size = this.size();
        if (list.size() != size) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            if (this.array[this.start + i] != list.array[list.start + i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int n = 1;
        for (int i = this.start; i < this.end; ++i) {
            n = 31 * n + Booleans.hashCode(this.array[i]);
        }
        return n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.size() * 7);
        sb.append(this.array[this.start] ? "[true" : "[false");
        for (int i = this.start + 1; i < this.end; ++i) {
            sb.append(this.array[i] ? ", true" : ", false");
        }
        return sb.append(']').toString();
    }
    
    boolean[] toBooleanArray() {
        final int size = this.size();
        final boolean[] array = new boolean[size];
        System.arraycopy(this.array, this.start, array, 0, size);
        return array;
    }
}
