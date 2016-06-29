/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.ParseRequest;
import com.google.common.primitives.UnsignedLongs$LexicographicalComparator;
import java.math.BigInteger;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;
    private static final long[] maxValueDivs = new long[37];
    private static final int[] maxValueMods = new int[37];
    private static final int[] maxSafeDigits = new int[37];

    private UnsignedLongs() {
    }

    private static long flip(long l2) {
        return l2 ^ Long.MIN_VALUE;
    }

    @CheckReturnValue
    public static int compare(long l2, long l3) {
        return Longs.compare(UnsignedLongs.flip(l2), UnsignedLongs.flip(l3));
    }

    @CheckReturnValue
    public static /* varargs */ long min(long ... arrl) {
        Preconditions.checkArgument(arrl.length > 0);
        long l2 = UnsignedLongs.flip(arrl[0]);
        int n2 = 1;
        while (n2 < arrl.length) {
            long l3 = UnsignedLongs.flip(arrl[n2]);
            if (l3 < l2) {
                l2 = l3;
            }
            ++n2;
        }
        return UnsignedLongs.flip(l2);
    }

    @CheckReturnValue
    public static /* varargs */ long max(long ... arrl) {
        Preconditions.checkArgument(arrl.length > 0);
        long l2 = UnsignedLongs.flip(arrl[0]);
        int n2 = 1;
        while (n2 < arrl.length) {
            long l3 = UnsignedLongs.flip(arrl[n2]);
            if (l3 > l2) {
                l2 = l3;
            }
            ++n2;
        }
        return UnsignedLongs.flip(l2);
    }

    @CheckReturnValue
    public static /* varargs */ String join(String string, long ... arrl) {
        Preconditions.checkNotNull(string);
        if (arrl.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrl.length * 5);
        stringBuilder.append(UnsignedLongs.toString(arrl[0]));
        int n2 = 1;
        while (n2 < arrl.length) {
            stringBuilder.append(string).append(UnsignedLongs.toString(arrl[n2]));
            ++n2;
        }
        return stringBuilder.toString();
    }

    @CheckReturnValue
    public static Comparator lexicographicalComparator() {
        return UnsignedLongs$LexicographicalComparator.INSTANCE;
    }

    @CheckReturnValue
    public static long divide(long l2, long l3) {
        boolean bl2;
        if (l3 < 0) {
            if (UnsignedLongs.compare(l2, l3) >= 0) return 1;
            return 0;
        }
        if (l2 >= 0) {
            return l2 / l3;
        }
        long l4 = (l2 >>> 1) / l3 << 1;
        long l5 = l2 - l4 * l3;
        if (UnsignedLongs.compare(l5, l3) >= 0) {
            bl2 = true;
            return l4 + (long)bl2 ? 1 : 0;
        }
        bl2 = false;
        return l4 + (long)bl2 ? 1 : 0;
    }

    @CheckReturnValue
    public static long remainder(long l2, long l3) {
        long l4;
        if (l3 < 0) {
            if (UnsignedLongs.compare(l2, l3) >= 0) return l2 - l3;
            return l2;
        }
        if (l2 >= 0) {
            return l2 % l3;
        }
        long l5 = (l2 >>> 1) / l3 << 1;
        long l6 = l2 - l5 * l3;
        if (UnsignedLongs.compare(l6, l3) >= 0) {
            l4 = l3;
            return l6 - l4;
        }
        l4 = 0;
        return l6 - l4;
    }

    public static long parseUnsignedLong(String string) {
        return UnsignedLongs.parseUnsignedLong(string, 10);
    }

    public static long decode(String string) {
        ParseRequest parseRequest = ParseRequest.fromString(string);
        try {
            return UnsignedLongs.parseUnsignedLong(parseRequest.rawValue, parseRequest.radix);
        }
        catch (NumberFormatException var2_2) {
            String string2 = String.valueOf(string);
            NumberFormatException numberFormatException = new NumberFormatException(string2.length() != 0 ? "Error parsing value: ".concat(string2) : new String("Error parsing value: "));
            numberFormatException.initCause(var2_2);
            throw numberFormatException;
        }
    }

    public static long parseUnsignedLong(String string, int n2) {
        Preconditions.checkNotNull(string);
        if (string.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (n2 < 2) throw new NumberFormatException(new StringBuilder(26).append("illegal radix: ").append(n2).toString());
        if (n2 > 36) {
            throw new NumberFormatException(new StringBuilder(26).append("illegal radix: ").append(n2).toString());
        }
        int n3 = maxSafeDigits[n2] - 1;
        long l2 = 0;
        int n4 = 0;
        while (n4 < string.length()) {
            int n5 = Character.digit(string.charAt(n4), n2);
            if (n5 == -1) {
                throw new NumberFormatException(string);
            }
            if (n4 > n3 && UnsignedLongs.overflowInParse(l2, n5, n2)) {
                String string2;
                String string3 = String.valueOf(string);
                if (string3.length() != 0) {
                    string2 = "Too large for unsigned long: ".concat(string3);
                    throw new NumberFormatException(string2);
                }
                string2 = new String("Too large for unsigned long: ");
                throw new NumberFormatException(string2);
            }
            l2 = l2 * (long)n2 + (long)n5;
            ++n4;
        }
        return l2;
    }

    private static boolean overflowInParse(long l2, int n2, int n3) {
        if (l2 < 0) return true;
        if (l2 < maxValueDivs[n3]) {
            return false;
        }
        if (l2 > maxValueDivs[n3]) {
            return true;
        }
        if (n2 <= maxValueMods[n3]) return false;
        return true;
    }

    @CheckReturnValue
    public static String toString(long l2) {
        return UnsignedLongs.toString(l2, 10);
    }

    @CheckReturnValue
    public static String toString(long l2, int n2) {
        Preconditions.checkArgument(n2 >= 2 && n2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", n2);
        if (l2 == 0) {
            return "0";
        }
        char[] arrc = new char[64];
        int n3 = arrc.length;
        if (l2 < 0) {
            long l3 = UnsignedLongs.divide(l2, n2);
            long l4 = l2 - l3 * (long)n2;
            arrc[--n3] = Character.forDigit((int)l4, n2);
            l2 = l3;
        }
        while (l2 > 0) {
            arrc[--n3] = Character.forDigit((int)(l2 % (long)n2), n2);
            l2 /= (long)n2;
        }
        return new String(arrc, n3, arrc.length - n3);
    }

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        int n2 = 2;
        while (n2 <= 36) {
            UnsignedLongs.maxValueDivs[n2] = UnsignedLongs.divide(-1, n2);
            UnsignedLongs.maxValueMods[n2] = (int)UnsignedLongs.remainder(-1, n2);
            UnsignedLongs.maxSafeDigits[n2] = bigInteger.toString(n2).length() - 1;
            ++n2;
        }
    }
}

