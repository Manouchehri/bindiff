/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped$1;
import com.google.common.util.concurrent.Striped$2;
import com.google.common.util.concurrent.Striped$3;
import com.google.common.util.concurrent.Striped$4;
import com.google.common.util.concurrent.Striped$5;
import com.google.common.util.concurrent.Striped$CompactStriped;
import com.google.common.util.concurrent.Striped$LargeLazyStriped;
import com.google.common.util.concurrent.Striped$SmallLazyStriped;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Beta
public abstract class Striped {
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier READ_WRITE_LOCK_SUPPLIER = new Striped$5();
    private static final int ALL_SET = -1;

    private Striped() {
    }

    public abstract Object get(Object var1);

    public abstract Object getAt(int var1);

    abstract int indexFor(Object var1);

    public abstract int size();

    public Iterable bulkGet(Iterable iterable) {
        int n2;
        Object[] arrobject = Iterables.toArray(iterable, Object.class);
        if (arrobject.length == 0) {
            return ImmutableList.of();
        }
        int[] arrn = new int[arrobject.length];
        for (n2 = 0; n2 < arrobject.length; ++n2) {
            arrn[n2] = this.indexFor(arrobject[n2]);
        }
        Arrays.sort(arrn);
        n2 = arrn[0];
        arrobject[0] = this.getAt(n2);
        int n3 = 1;
        do {
            if (n3 >= arrobject.length) {
                List<Object> list = Arrays.asList(arrobject);
                return Collections.unmodifiableList(list);
            }
            int n4 = arrn[n3];
            if (n4 == n2) {
                arrobject[n3] = arrobject[n3 - 1];
            } else {
                arrobject[n3] = this.getAt(n4);
                n2 = n4;
            }
            ++n3;
        } while (true);
    }

    public static Striped lock(int n2) {
        return new Striped$CompactStriped(n2, new Striped$1(), null);
    }

    public static Striped lazyWeakLock(int n2) {
        return Striped.lazy(n2, new Striped$2());
    }

    private static Striped lazy(int n2, Supplier supplier) {
        Striped$SmallLazyStriped striped$SmallLazyStriped /* !! */ ;
        if (n2 < 1024) {
            striped$SmallLazyStriped /* !! */  = new Striped$SmallLazyStriped(n2, supplier);
            return striped$SmallLazyStriped /* !! */ ;
        }
        striped$SmallLazyStriped /* !! */  = new Striped$LargeLazyStriped(n2, supplier);
        return striped$SmallLazyStriped /* !! */ ;
    }

    public static Striped semaphore(int n2, int n3) {
        return new Striped$CompactStriped(n2, new Striped$3(n3), null);
    }

    public static Striped lazyWeakSemaphore(int n2, int n3) {
        return Striped.lazy(n2, new Striped$4(n3));
    }

    public static Striped readWriteLock(int n2) {
        return new Striped$CompactStriped(n2, READ_WRITE_LOCK_SUPPLIER, null);
    }

    public static Striped lazyWeakReadWriteLock(int n2) {
        return Striped.lazy(n2, READ_WRITE_LOCK_SUPPLIER);
    }

    private static int ceilToPowerOfTwo(int n2) {
        return 1 << IntMath.log2(n2, RoundingMode.CEILING);
    }

    private static int smear(int n2) {
        n2 ^= n2 >>> 20 ^ n2 >>> 12;
        return n2 ^ n2 >>> 7 ^ n2 >>> 4;
    }

    /* synthetic */ Striped(Striped$1 striped$1) {
        this();
    }

    static /* synthetic */ int access$200(int n2) {
        return Striped.ceilToPowerOfTwo(n2);
    }

    static /* synthetic */ int access$300(int n2) {
        return Striped.smear(n2);
    }
}

