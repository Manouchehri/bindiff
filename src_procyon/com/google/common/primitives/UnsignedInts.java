package com.google.common.primitives;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@Beta
@GwtCompatible
public final class UnsignedInts
{
    static final long INT_MASK = 4294967295L;
    
    static int flip(final int n) {
        return n ^ Integer.MIN_VALUE;
    }
    
    @CheckReturnValue
    public static int compare(final int n, final int n2) {
        return Ints.compare(flip(n), flip(n2));
    }
    
    @CheckReturnValue
    public static long toLong(final int n) {
        return n & 0xFFFFFFFFL;
    }
    
    @CheckReturnValue
    public static int min(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int flip = flip(array[0]);
        for (int i = 1; i < array.length; ++i) {
            final int flip2 = flip(array[i]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }
    
    @CheckReturnValue
    public static int max(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int flip = flip(array[0]);
        for (int i = 1; i < array.length; ++i) {
            final int flip2 = flip(array[i]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }
    
    @CheckReturnValue
    public static String join(final String s, final int... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(toString(array[0]));
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(toString(array[i]));
        }
        return sb.toString();
    }
    
    @CheckReturnValue
    public static Comparator lexicographicalComparator() {
        return UnsignedInts$LexicographicalComparator.INSTANCE;
    }
    
    @CheckReturnValue
    public static int divide(final int n, final int n2) {
        return (int)(toLong(n) / toLong(n2));
    }
    
    @CheckReturnValue
    public static int remainder(final int n, final int n2) {
        return (int)(toLong(n) % toLong(n2));
    }
    
    public static int decode(final String s) {
        final ParseRequest fromString = ParseRequest.fromString(s);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        }
        catch (NumberFormatException ex2) {
            final String s2 = "Error parsing value: ";
            final String value = String.valueOf(s);
            final NumberFormatException ex = new NumberFormatException((value.length() != 0) ? s2.concat(value) : new String(s2));
            ex.initCause(ex2);
            throw ex;
        }
    }
    
    public static int parseUnsignedInt(final String s) {
        return parseUnsignedInt(s, 10);
    }
    
    public static int parseUnsignedInt(final String s, final int n) {
        Preconditions.checkNotNull(s);
        final long long1 = Long.parseLong(s, n);
        if ((long1 & 0xFFFFFFFFL) != long1) {
            throw new NumberFormatException(new StringBuilder(69 + String.valueOf(s).length()).append("Input ").append(s).append(" in base ").append(n).append(" is not in the range of an unsigned integer").toString());
        }
        return (int)long1;
    }
    
    @CheckReturnValue
    public static String toString(final int n) {
        return toString(n, 10);
    }
    
    @CheckReturnValue
    public static String toString(final int n, final int n2) {
        return Long.toString(n & 0xFFFFFFFFL, n2);
    }
}
