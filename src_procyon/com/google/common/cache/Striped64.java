package com.google.common.cache;

import java.util.*;
import sun.misc.*;
import java.security.*;

abstract class Striped64 extends Number
{
    static final ThreadLocal threadHashCode;
    static final Random rng;
    static final int NCPU;
    transient volatile Striped64$Cell[] cells;
    transient volatile long base;
    transient volatile int busy;
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    
    final boolean casBase(final long n, final long n2) {
        return Striped64.UNSAFE.compareAndSwapLong(this, Striped64.baseOffset, n, n2);
    }
    
    final boolean casBusy() {
        return Striped64.UNSAFE.compareAndSwapInt(this, Striped64.busyOffset, 0, 1);
    }
    
    abstract long fn(final long p0, final long p1);
    
    final void retryUpdate(final long n, int[] array, boolean b) {
        int n4;
        if (array == null) {
            Striped64.threadHashCode.set(array = new int[] { 0 });
            final int nextInt = Striped64.rng.nextInt();
            final int[] array2 = array;
            final int n2 = 0;
            final int n3 = (nextInt == 0) ? 1 : nextInt;
            array2[n2] = n3;
            n4 = n3;
        }
        else {
            n4 = array[0];
        }
        int n5 = 0;
        while (true) {
            final Striped64$Cell[] cells;
            final int length;
            if ((cells = this.cells) != null && (length = cells.length) > 0) {
                final Striped64$Cell striped64$Cell;
                if ((striped64$Cell = cells[length - 1 & n4]) == null) {
                    if (this.busy == 0) {
                        final Striped64$Cell striped64$Cell2 = new Striped64$Cell(n);
                        if (this.busy == 0 && this.casBusy()) {
                            boolean b2 = false;
                            try {
                                final Striped64$Cell[] cells2;
                                final int length2;
                                final int n6;
                                if ((cells2 = this.cells) != null && (length2 = cells2.length) > 0 && cells2[n6 = (length2 - 1 & n4)] == null) {
                                    cells2[n6] = striped64$Cell2;
                                    b2 = true;
                                }
                            }
                            finally {
                                this.busy = 0;
                            }
                            if (b2) {
                                break;
                            }
                            continue;
                        }
                    }
                    n5 = 0;
                }
                else if (!b) {
                    b = true;
                }
                else {
                    final Striped64$Cell striped64$Cell3 = striped64$Cell;
                    final long value = striped64$Cell.value;
                    if (striped64$Cell3.cas(value, this.fn(value, n))) {
                        break;
                    }
                    if (length >= Striped64.NCPU || this.cells != cells) {
                        n5 = 0;
                    }
                    else if (n5 == 0) {
                        n5 = 1;
                    }
                    else if (this.busy == 0 && this.casBusy()) {
                        try {
                            if (this.cells == cells) {
                                final Striped64$Cell[] cells3 = new Striped64$Cell[length << 1];
                                for (int i = 0; i < length; ++i) {
                                    cells3[i] = cells[i];
                                }
                                this.cells = cells3;
                            }
                        }
                        finally {
                            this.busy = 0;
                        }
                        n5 = 0;
                        continue;
                    }
                }
                final int n7 = n4 ^ n4 << 13;
                final int n8 = n7 ^ n7 >>> 17;
                n4 = (n8 ^ n8 << 5);
                array[0] = n4;
            }
            else if (this.busy == 0 && this.cells == cells && this.casBusy()) {
                boolean b3 = false;
                try {
                    if (this.cells == cells) {
                        final Striped64$Cell[] cells4 = new Striped64$Cell[2];
                        cells4[n4 & 0x1] = new Striped64$Cell(n);
                        this.cells = cells4;
                        b3 = true;
                    }
                }
                finally {
                    this.busy = 0;
                }
                if (b3) {
                    break;
                }
                continue;
            }
            else {
                final long base = this.base;
                if (this.casBase(base, this.fn(base, n))) {
                    break;
                }
                continue;
            }
        }
    }
    
    final void internalReset(final long n) {
        final Striped64$Cell[] cells = this.cells;
        this.base = n;
        if (cells != null) {
            for (final Striped64$Cell striped64$Cell : cells) {
                if (striped64$Cell != null) {
                    striped64$Cell.value = n;
                }
            }
        }
    }
    
    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException ex2) {
            try {
                return AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new Striped64$1());
            }
            catch (PrivilegedActionException ex) {
                throw new RuntimeException("Could not initialize intrinsics", ex.getCause());
            }
        }
    }
    
    static {
        threadHashCode = new ThreadLocal();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        try {
            UNSAFE = getUnsafe();
            final Class<Striped64> clazz = Striped64.class;
            baseOffset = Striped64.UNSAFE.objectFieldOffset(clazz.getDeclaredField("base"));
            busyOffset = Striped64.UNSAFE.objectFieldOffset(clazz.getDeclaredField("busy"));
        }
        catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
