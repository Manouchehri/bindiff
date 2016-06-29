/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.Striped64$1;
import com.google.common.cache.Striped64$Cell;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64
extends Number {
    static final ThreadLocal threadHashCode = new ThreadLocal<T>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    volatile transient Striped64$Cell[] cells;
    volatile transient long base;
    volatile transient int busy;
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;

    Striped64() {
    }

    final boolean casBase(long l2, long l3) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, l2, l3);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long var1, long var3);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void retryUpdate(long l2, int[] arrn, boolean bl2) {
        int n2;
        int n3;
        if (arrn == null) {
            arrn = new int[1];
            threadHashCode.set(arrn);
            n3 = rng.nextInt();
            arrn[0] = n3 == 0 ? 1 : n3;
            n2 = arrn[0];
        } else {
            n2 = arrn[0];
        }
        n3 = 0;
        do {
            int n4;
            long l3;
            Striped64$Cell[] arrstriped64$Cell;
            if ((arrstriped64$Cell = this.cells) != null && (n4 = arrstriped64$Cell.length) > 0) {
                int n5;
                Striped64$Cell[] arrstriped64$Cell2;
                Striped64$Cell striped64$Cell = arrstriped64$Cell[n4 - 1 & n2];
                if (striped64$Cell == null) {
                    if (this.busy == 0) {
                        arrstriped64$Cell2 = new Striped64$Cell[](l2);
                        if (this.busy == 0 && this.casBusy()) {
                            n5 = 0;
                            try {
                                int n6;
                                int n7;
                                Striped64$Cell[] arrstriped64$Cell3 = this.cells;
                                if (arrstriped64$Cell3 != null && (n6 = arrstriped64$Cell3.length) > 0 && arrstriped64$Cell3[n7 = n6 - 1 & n2] == null) {
                                    arrstriped64$Cell3[n7] = arrstriped64$Cell2;
                                    n5 = 1;
                                }
                            }
                            finally {
                                this.busy = 0;
                            }
                            if (n5 == 0) continue;
                            return;
                        }
                    }
                    n3 = 0;
                } else if (!bl2) {
                    bl2 = true;
                } else {
                    l3 = striped64$Cell.value;
                    if (striped64$Cell.cas(l3, this.fn(l3, l2))) {
                        return;
                    }
                    if (n4 >= NCPU || this.cells != arrstriped64$Cell) {
                        n3 = 0;
                    } else if (n3 == 0) {
                        n3 = 1;
                    } else if (this.busy == 0 && this.casBusy()) {
                        try {
                            if (this.cells == arrstriped64$Cell) {
                                arrstriped64$Cell2 = new Striped64$Cell[n4 << 1];
                                for (n5 = 0; n5 < n4; ++n5) {
                                    arrstriped64$Cell2[n5] = arrstriped64$Cell[n5];
                                }
                                this.cells = arrstriped64$Cell2;
                            }
                        }
                        finally {
                            this.busy = 0;
                        }
                        n3 = 0;
                        continue;
                    }
                }
                n2 ^= n2 << 13;
                n2 ^= n2 >>> 17;
                n2 ^= n2 << 5;
                arrn[0] = n2;
                continue;
            }
            if (this.busy == 0 && this.cells == arrstriped64$Cell && this.casBusy()) {
                boolean bl3;
                bl3 = false;
                try {
                    if (this.cells == arrstriped64$Cell) {
                        Striped64$Cell[] arrstriped64$Cell4 = new Striped64$Cell[2];
                        arrstriped64$Cell4[n2 & 1] = new Striped64$Cell(l2);
                        this.cells = arrstriped64$Cell4;
                        bl3 = true;
                    }
                }
                finally {
                    this.busy = 0;
                }
                if (!bl3) continue;
                return;
            }
            l3 = this.base;
            if (this.casBase(l3, this.fn(l3, l2))) return;
        } while (true);
    }

    final void internalReset(long l2) {
        Striped64$Cell[] arrstriped64$Cell = this.cells;
        this.base = l2;
        if (arrstriped64$Cell == null) return;
        int n2 = arrstriped64$Cell.length;
        int n3 = 0;
        while (n3 < n2) {
            Striped64$Cell striped64$Cell = arrstriped64$Cell[n3];
            if (striped64$Cell != null) {
                striped64$Cell.value = l2;
            }
            ++n3;
        }
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException var0) {
            try {
                return (Unsafe)AccessController.doPrivileged(new Striped64$1());
            }
            catch (PrivilegedActionException var0_1) {
                throw new RuntimeException("Could not initialize intrinsics", var0_1.getCause());
            }
        }
    }

    static /* synthetic */ Unsafe access$000() {
        return Striped64.getUnsafe();
    }

    static {
        try {
            UNSAFE = Striped64.getUnsafe();
            reference var0 = Striped64.class;
            baseOffset = UNSAFE.objectFieldOffset(var0.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(var0.getDeclaredField("busy"));
            return;
        }
        catch (Exception var0_1) {
            throw new Error(var0_1);
        }
    }
}

