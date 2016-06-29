package com.google.common.primitives;

import java.util.*;
import com.google.common.annotations.*;
import sun.misc.*;
import java.security.*;
import java.nio.*;

@VisibleForTesting
enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator
{
    INSTANCE("INSTANCE", 0);
    
    static final boolean BIG_ENDIAN;
    static final Unsafe theUnsafe;
    static final int BYTE_ARRAY_BASE_OFFSET;
    
    private UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator(final String s, final int n) {
    }
    
    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException ex2) {
            try {
                return AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1());
            }
            catch (PrivilegedActionException ex) {
                throw new RuntimeException("Could not initialize intrinsics", ex.getCause());
            }
        }
    }
    
    public int compare(final byte[] array, final byte[] array2) {
        final int min = Math.min(array.length, array2.length);
        final int n = min / 8;
        int i = 0;
        while (i < n * 8) {
            final long long1 = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.theUnsafe.getLong(array, UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.BYTE_ARRAY_BASE_OFFSET + i);
            final long long2 = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.theUnsafe.getLong(array2, UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.BYTE_ARRAY_BASE_OFFSET + i);
            if (long1 != long2) {
                if (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.BIG_ENDIAN) {
                    return UnsignedLongs.compare(long1, long2);
                }
                final int n2 = Long.numberOfTrailingZeros(long1 ^ long2) & 0xFFFFFFF8;
                return (int)((long1 >>> n2 & 0xFFL) - (long2 >>> n2 & 0xFFL));
            }
            else {
                i += 8;
            }
        }
        for (int j = n * 8; j < min; ++j) {
            final int compare = UnsignedBytes.compare(array[j], array2[j]);
            if (compare != 0) {
                return compare;
            }
        }
        return array.length - array2.length;
    }
    
    static {
        BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        theUnsafe = getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.theUnsafe.arrayBaseOffset(byte[].class);
        if (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.theUnsafe.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
        }
    }
}
