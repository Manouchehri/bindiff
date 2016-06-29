/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    private UnsignedBytes() {
    }

    @CheckReturnValue
    public static int toInt(byte by2) {
        return by2 & 255;
    }

    public static byte checkedCast(long l2) {
        if (l2 >> 8 == 0) return (byte)l2;
        throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(l2).toString());
    }

    public static byte saturatedCast(long l2) {
        if (l2 > (long)UnsignedBytes.toInt(-1)) {
            return -1;
        }
        if (l2 >= 0) return (byte)l2;
        return 0;
    }

    @CheckReturnValue
    public static int compare(byte by2, byte by3) {
        return UnsignedBytes.toInt(by2) - UnsignedBytes.toInt(by3);
    }

    @CheckReturnValue
    public static /* varargs */ byte min(byte ... arrby) {
        Preconditions.checkArgument(arrby.length > 0);
        int n2 = UnsignedBytes.toInt(arrby[0]);
        int n3 = 1;
        while (n3 < arrby.length) {
            int n4 = UnsignedBytes.toInt(arrby[n3]);
            if (n4 < n2) {
                n2 = n4;
            }
            ++n3;
        }
        return (byte)n2;
    }

    @CheckReturnValue
    public static /* varargs */ byte max(byte ... arrby) {
        Preconditions.checkArgument(arrby.length > 0);
        int n2 = UnsignedBytes.toInt(arrby[0]);
        int n3 = 1;
        while (n3 < arrby.length) {
            int n4 = UnsignedBytes.toInt(arrby[n3]);
            if (n4 > n2) {
                n2 = n4;
            }
            ++n3;
        }
        return (byte)n2;
    }

    @CheckReturnValue
    @Beta
    public static String toString(byte by2) {
        return UnsignedBytes.toString(by2, 10);
    }

    @CheckReturnValue
    @Beta
    public static String toString(byte by2, int n2) {
        Preconditions.checkArgument(n2 >= 2 && n2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n2);
        return Integer.toString(UnsignedBytes.toInt(by2), n2);
    }

    @Beta
    public static byte parseUnsignedByte(String string) {
        return UnsignedBytes.parseUnsignedByte(string, 10);
    }

    @Beta
    public static byte parseUnsignedByte(String string, int n2) {
        int n3 = Integer.parseInt((String)Preconditions.checkNotNull(string), n2);
        if (n3 >> 8 != 0) throw new NumberFormatException(new StringBuilder(25).append("out of range: ").append(n3).toString());
        return (byte)n3;
    }

    @CheckReturnValue
    public static /* varargs */ String join(String string, byte ... arrby) {
        Preconditions.checkNotNull(string);
        if (arrby.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrby.length * (3 + string.length()));
        stringBuilder.append(UnsignedBytes.toInt(arrby[0]));
        int n2 = 1;
        while (n2 < arrby.length) {
            stringBuilder.append(string).append(UnsignedBytes.toString(arrby[n2]));
            ++n2;
        }
        return stringBuilder.toString();
    }

    @CheckReturnValue
    public static Comparator lexicographicalComparator() {
        return UnsignedBytes$LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    static Comparator lexicographicalComparatorJavaImpl() {
        return UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.INSTANCE;
    }
}

