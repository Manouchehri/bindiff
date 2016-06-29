package com.google.common.primitives;

import java.io.*;
import java.util.regex.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible
class Doubles$DoubleArrayAsList extends AbstractList implements Serializable, RandomAccess
{
    final double[] array;
    final int start;
    final int end;
    private static final long serialVersionUID = 0L;
    
    Doubles$DoubleArrayAsList(final double[] array) {
        this(array, 0, array.length);
    }
    
    Doubles$DoubleArrayAsList(final double[] array, final int start, final int end) {
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
    public Double get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.array[this.start + n];
    }
    
    @Override
    public boolean contains(final Object o) {
        return o instanceof Double && indexOf(this.array, (double)o, this.start, this.end) != -1;
    }
    
    @Override
    public int indexOf(final Object o) {
        if (o instanceof Double) {
            final int access$000 = indexOf(this.array, (double)o, this.start, this.end);
            if (access$000 >= 0) {
                return access$000 - this.start;
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        if (o instanceof Double) {
            final int access$100 = lastIndexOf(this.array, (double)o, this.start, this.end);
            if (access$100 >= 0) {
                return access$100 - this.start;
            }
        }
        return -1;
    }
    
    public Double set(final int n, final Double n2) {
        Preconditions.checkElementIndex(n, this.size());
        final double n3 = this.array[this.start + n];
        this.array[this.start + n] = (double)Preconditions.checkNotNull(n2);
        return n3;
    }
    
    @Override
    public List subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.size());
        if (n == n2) {
            return Collections.emptyList();
        }
        return new Doubles$DoubleArrayAsList(this.array, this.start + n, this.start + n2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Doubles$DoubleArrayAsList)) {
            return super.equals(o);
        }
        final Doubles$DoubleArrayAsList list = (Doubles$DoubleArrayAsList)o;
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
            n = 31 * n + Doubles.hashCode(this.array[i]);
        }
        return n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.size() * 12);
        sb.append('[').append(this.array[this.start]);
        for (int i = this.start + 1; i < this.end; ++i) {
            sb.append(", ").append(this.array[i]);
        }
        return sb.append(']').toString();
    }
    
    double[] toDoubleArray() {
        final int size = this.size();
        final double[] array = new double[size];
        System.arraycopy(this.array, this.start, array, 0, size);
        return array;
    }
}
