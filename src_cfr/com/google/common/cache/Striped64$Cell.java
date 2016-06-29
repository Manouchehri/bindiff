/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.Striped64;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

final class Striped64$Cell {
    volatile long p0;
    volatile long p1;
    volatile long p2;
    volatile long p3;
    volatile long p4;
    volatile long p5;
    volatile long p6;
    volatile long value;
    volatile long q0;
    volatile long q1;
    volatile long q2;
    volatile long q3;
    volatile long q4;
    volatile long q5;
    volatile long q6;
    private static final Unsafe UNSAFE;
    private static final long valueOffset;

    Striped64$Cell(long l2) {
        this.value = l2;
    }

    final boolean cas(long l2, long l3) {
        return UNSAFE.compareAndSwapLong(this, valueOffset, l2, l3);
    }

    static {
        try {
            UNSAFE = Striped64.access$000();
            reference var0 = Striped64$Cell.class;
            valueOffset = UNSAFE.objectFieldOffset(var0.getDeclaredField("value"));
            return;
        }
        catch (Exception var0_1) {
            throw new Error(var0_1);
        }
    }
}

