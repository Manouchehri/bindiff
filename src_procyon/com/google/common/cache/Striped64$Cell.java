package com.google.common.cache;

import sun.misc.*;
import java.util.*;
import java.security.*;

final class Striped64$Cell
{
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
    
    Striped64$Cell(final long value) {
        this.value = value;
    }
    
    final boolean cas(final long n, final long n2) {
        return Striped64$Cell.UNSAFE.compareAndSwapLong(this, Striped64$Cell.valueOffset, n, n2);
    }
    
    static {
        try {
            UNSAFE = getUnsafe();
            valueOffset = Striped64$Cell.UNSAFE.objectFieldOffset(Striped64$Cell.class.getDeclaredField("value"));
        }
        catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
