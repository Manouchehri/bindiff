package com.google.common.primitives;

import java.io.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
class Longs$LongArrayAsList extends AbstractList implements Serializable, RandomAccess
{
    final long[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0L;
    
    Longs$LongArrayAsList(final long[] array) {
        this(array, 0, array.length);
    }
    
    Longs$LongArrayAsList(final long[] array, final int start, final int end) {
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
    public Long get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.array[this.start + n];
    }
    
    @Override
    public boolean contains(final Object o) {
        return o instanceof Long && indexOf(this.array, (long)o, this.start, this.end) != -1;
    }
    
    @Override
    public int indexOf(final Object o) {
        if (o instanceof Long) {
            final int access$000 = indexOf(this.array, (long)o, this.start, this.end);
            if (access$000 >= 0) {
                return access$000 - this.start;
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        if (o instanceof Long) {
            final int access$100 = lastIndexOf(this.array, (long)o, this.start, this.end);
            if (access$100 >= 0) {
                return access$100 - this.start;
            }
        }
        return -1;
    }
    
    public Long set(final int n, final Long n2) {
        Preconditions.checkElementIndex(n, this.size());
        final long n3 = this.array[this.start + n];
        this.array[this.start + n] = (long)Preconditions.checkNotNull(n2);
        return n3;
    }
    
    @Override
    public List subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        if (n == n2) {
            return Collections.emptyList();
        }
        return new Longs$LongArrayAsList(this.array, this.start + n, this.start + n2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Longs$LongArrayAsList)) {
            return super.equals(o);
        }
        final Longs$LongArrayAsList list = (Longs$LongArrayAsList)o;
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
            n = 31 * n + Longs.hashCode(this.array[i]);
        }
        return n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.size() * 10);
        sb.append('[').append(this.array[this.start]);
        for (int i = this.start + 1; i < this.end; ++i) {
            sb.append(", ").append(this.array[i]);
        }
        return sb.append(']').toString();
    }
    
    long[] toLongArray() {
        final int size = this.size();
        final long[] array = new long[size];
        System.arraycopy(this.array, this.start, array, 0, size);
        return array;
    }
}
