package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import java.math.*;
import com.google.common.math.*;

@Beta
public abstract class Striped
{
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier READ_WRITE_LOCK_SUPPLIER;
    private static final int ALL_SET = -1;
    
    public abstract Object get(final Object p0);
    
    public abstract Object getAt(final int p0);
    
    abstract int indexFor(final Object p0);
    
    public abstract int size();
    
    public Iterable bulkGet(final Iterable iterable) {
        final Object[] array = Iterables.toArray(iterable, Object.class);
        if (array.length == 0) {
            return ImmutableList.of();
        }
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = this.indexFor(array[i]);
        }
        Arrays.sort(array2);
        int n = array2[0];
        array[0] = this.getAt(n);
        for (int j = 1; j < array.length; ++j) {
            final int n2 = array2[j];
            if (n2 == n) {
                array[j] = array[j - 1];
            }
            else {
                array[j] = this.getAt(n2);
                n = n2;
            }
        }
        return Collections.unmodifiableList((List<?>)Arrays.asList(array));
    }
    
    public static Striped lock(final int n) {
        return new Striped$CompactStriped(n, new Striped$1(), null);
    }
    
    public static Striped lazyWeakLock(final int n) {
        return lazy(n, new Striped$2());
    }
    
    private static Striped lazy(final int n, final Supplier supplier) {
        return (n < 1024) ? new Striped$SmallLazyStriped(n, supplier) : new Striped$LargeLazyStriped(n, supplier);
    }
    
    public static Striped semaphore(final int n, final int n2) {
        return new Striped$CompactStriped(n, new Striped$3(n2), null);
    }
    
    public static Striped lazyWeakSemaphore(final int n, final int n2) {
        return lazy(n, new Striped$4(n2));
    }
    
    public static Striped readWriteLock(final int n) {
        return new Striped$CompactStriped(n, Striped.READ_WRITE_LOCK_SUPPLIER, null);
    }
    
    public static Striped lazyWeakReadWriteLock(final int n) {
        return lazy(n, Striped.READ_WRITE_LOCK_SUPPLIER);
    }
    
    private static int ceilToPowerOfTwo(final int n) {
        return 1 << IntMath.log2(n, RoundingMode.CEILING);
    }
    
    private static int smear(int n) {
        n ^= (n >>> 20 ^ n >>> 12);
        return n ^ n >>> 7 ^ n >>> 4;
    }
    
    static {
        READ_WRITE_LOCK_SUPPLIER = new Striped$5();
    }
}
