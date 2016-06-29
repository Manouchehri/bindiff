/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1;
import com.google.common.primitives.UnsignedLongs;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Comparator;
import sun.misc.Unsafe;

@VisibleForTesting
enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator
{
    INSTANCE;
    
    static final boolean BIG_ENDIAN;
    static final Unsafe theUnsafe;
    static final int BYTE_ARRAY_BASE_OFFSET;

    private UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator() {
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException var0) {
            try {
                return (Unsafe)AccessController.doPrivileged(new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1());
            }
            catch (PrivilegedActionException var0_1) {
                throw new RuntimeException("Could not initialize intrinsics", var0_1.getCause());
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public int compare(byte[] var1_1, byte[] var2_2) {
        block4 : {
            var3_3 = Math.min(var1_1.length, var2_2.length);
            var4_4 = var3_3 / 8;
            for (var5_5 = 0; var5_5 < var4_4 * 8; var5_5 += 8) {
                var6_6 = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.theUnsafe.getLong((Object)var1_1, (long)UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.BYTE_ARRAY_BASE_OFFSET + (long)var5_5);
                if (var6_6 == (var8_8 = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.theUnsafe.getLong((Object)var2_2, (long)UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.BYTE_ARRAY_BASE_OFFSET + (long)var5_5))) continue;
                if (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.BIG_ENDIAN) {
                    return UnsignedLongs.compare(var6_6, var8_8);
                }
                break block4;
            }
            ** GOTO lbl13
        }
        var10_9 = Long.numberOfTrailingZeros(var6_6 ^ var8_8) & -8;
        return (int)((var6_6 >>> var10_9 & 255) - (var8_8 >>> var10_9 & 255));
lbl13: // 1 sources:
        var5_5 = var4_4 * 8;
        while (var5_5 < var3_3) {
            var6_7 = UnsignedBytes.compare(var1_1[var5_5], var2_2[var5_5]);
            if (var6_7 != 0) {
                return var6_7;
            }
            ++var5_5;
        }
        return var1_1.length - var2_2.length;
    }

    static {
        BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        theUnsafe = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
        if (theUnsafe.arrayIndexScale(byte[].class) == 1) return;
        throw new AssertionError();
    }
}

