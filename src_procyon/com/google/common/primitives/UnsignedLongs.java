package com.google.common.primitives;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import java.math.*;

@Beta
@GwtCompatible
public final class UnsignedLongs
{
    public static final long MAX_VALUE = -1L;
    private static final long[] maxValueDivs;
    private static final int[] maxValueMods;
    private static final int[] maxSafeDigits;
    
    private static long flip(final long n) {
        return n ^ Long.MIN_VALUE;
    }
    
    @CheckReturnValue
    public static int compare(final long n, final long n2) {
        return Longs.compare(flip(n), flip(n2));
    }
    
    @CheckReturnValue
    public static long min(final long... array) {
        Preconditions.checkArgument(array.length > 0);
        long flip = flip(array[0]);
        for (int i = 1; i < array.length; ++i) {
            final long flip2 = flip(array[i]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }
    
    @CheckReturnValue
    public static long max(final long... array) {
        Preconditions.checkArgument(array.length > 0);
        long flip = flip(array[0]);
        for (int i = 1; i < array.length; ++i) {
            final long flip2 = flip(array[i]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }
    
    @CheckReturnValue
    public static String join(final String s, final long... array) {
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
        return UnsignedLongs$LexicographicalComparator.INSTANCE;
    }
    
    @CheckReturnValue
    public static long divide(final long n, final long n2) {
        if (n2 < 0L) {
            if (compare(n, n2) < 0) {
                return 0L;
            }
            return 1L;
        }
        else {
            if (n >= 0L) {
                return n / n2;
            }
            final long n3 = (n >>> 1) / n2 << 1;
            return n3 + ((compare(n - n3 * n2, n2) >= 0) ? 1 : 0);
        }
    }
    
    @CheckReturnValue
    public static long remainder(final long n, final long n2) {
        if (n2 < 0L) {
            if (compare(n, n2) < 0) {
                return n;
            }
            return n - n2;
        }
        else {
            if (n >= 0L) {
                return n % n2;
            }
            final long n3 = n - ((n >>> 1) / n2 << 1) * n2;
            return n3 - ((compare(n3, n2) >= 0) ? n2 : 0L);
        }
    }
    
    public static long parseUnsignedLong(final String s) {
        return parseUnsignedLong(s, 10);
    }
    
    public static long decode(final String s) {
        final ParseRequest fromString = ParseRequest.fromString(s);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        }
        catch (NumberFormatException ex2) {
            final String s2 = "Error parsing value: ";
            final String value = String.valueOf(s);
            final NumberFormatException ex = new NumberFormatException((value.length() != 0) ? s2.concat(value) : new String(s2));
            ex.initCause(ex2);
            throw ex;
        }
    }
    
    public static long parseUnsignedLong(final String s, final int n) {
        Preconditions.checkNotNull(s);
        if (s.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (n < 2 || n > 36) {
            throw new NumberFormatException(new StringBuilder(26).append("illegal radix: ").append(n).toString());
        }
        final int n2 = UnsignedLongs.maxSafeDigits[n] - 1;
        long n3 = 0L;
        for (int i = 0; i < s.length(); ++i) {
            final int digit = Character.digit(s.charAt(i), n);
            if (digit == -1) {
                throw new NumberFormatException(s);
            }
            if (i > n2 && overflowInParse(n3, digit, n)) {
                final String s2 = "Too large for unsigned long: ";
                final String value = String.valueOf(s);
                throw new NumberFormatException((value.length() != 0) ? s2.concat(value) : new String(s2));
            }
            n3 = n3 * n + digit;
        }
        return n3;
    }
    
    private static boolean overflowInParse(final long n, final int n2, final int n3) {
        return n < 0L || (n >= UnsignedLongs.maxValueDivs[n3] && (n > UnsignedLongs.maxValueDivs[n3] || n2 > UnsignedLongs.maxValueMods[n3]));
    }
    
    @CheckReturnValue
    public static String toString(final long n) {
        return toString(n, 10);
    }
    
    @CheckReturnValue
    public static String toString(long n, final int n2) {
        Preconditions.checkArgument(n2 >= 2 && n2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n2);
        if (n == 0L) {
            return "0";
        }
        final char[] array = new char[64];
        int length = array.length;
        if (n < 0L) {
            final long divide = divide(n, n2);
            array[--length] = Character.forDigit((int)(n - divide * n2), n2);
            n = divide;
        }
        while (n > 0L) {
            array[--length] = Character.forDigit((int)(n % n2), n2);
            n /= n2;
        }
        return new String(array, length, array.length - length);
    }
    
    static {
        maxValueDivs = new long[37];
        maxValueMods = new int[37];
        maxSafeDigits = new int[37];
        final BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; ++i) {
            UnsignedLongs.maxValueDivs[i] = divide(-1L, i);
            UnsignedLongs.maxValueMods[i] = (int)remainder(-1L, i);
            UnsignedLongs.maxSafeDigits[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
