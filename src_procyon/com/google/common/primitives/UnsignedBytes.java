package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;

public final class UnsignedBytes
{
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;
    
    @CheckReturnValue
    public static int toInt(final byte b) {
        return b & 0xFF;
    }
    
    public static byte checkedCast(final long n) {
        if (n >> 8 != 0L) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(n).toString());
        }
        return (byte)n;
    }
    
    public static byte saturatedCast(final long n) {
        if (n > toInt((byte)(-1))) {
            return -1;
        }
        if (n < 0L) {
            return 0;
        }
        return (byte)n;
    }
    
    @CheckReturnValue
    public static int compare(final byte b, final byte b2) {
        return toInt(b) - toInt(b2);
    }
    
    @CheckReturnValue
    public static byte min(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        int int1 = toInt(array[0]);
        for (int i = 1; i < array.length; ++i) {
            final int int2 = toInt(array[i]);
            if (int2 < int1) {
                int1 = int2;
            }
        }
        return (byte)int1;
    }
    
    @CheckReturnValue
    public static byte max(final byte... array) {
        Preconditions.checkArgument(array.length > 0);
        int int1 = toInt(array[0]);
        for (int i = 1; i < array.length; ++i) {
            final int int2 = toInt(array[i]);
            if (int2 > int1) {
                int1 = int2;
            }
        }
        return (byte)int1;
    }
    
    @CheckReturnValue
    @Beta
    public static String toString(final byte b) {
        return toString(b, 10);
    }
    
    @CheckReturnValue
    @Beta
    public static String toString(final byte b, final int n) {
        Preconditions.checkArgument(n >= 2 && n <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n);
        return Integer.toString(toInt(b), n);
    }
    
    @Beta
    public static byte parseUnsignedByte(final String s) {
        return parseUnsignedByte(s, 10);
    }
    
    @Beta
    public static byte parseUnsignedByte(final String s, final int n) {
        final int int1 = Integer.parseInt((String)Preconditions.checkNotNull(s), n);
        if (int1 >> 8 == 0) {
            return (byte)int1;
        }
        throw new NumberFormatException(new StringBuilder(25).append("out of range: ").append(int1).toString());
    }
    
    @CheckReturnValue
    public static String join(final String s, final byte... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * (3 + s.length()));
        sb.append(toInt(array[0]));
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(toString(array[i]));
        }
        return sb.toString();
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
