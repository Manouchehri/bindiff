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
import com.google.common.primitives.Ints;
import com.google.common.primitives.ParseRequest;
import com.google.common.primitives.UnsignedInts$LexicographicalComparator;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class UnsignedInts {
    static final long INT_MASK = 0xFFFFFFFFL;

    private UnsignedInts() {
    }

    static int flip(int n2) {
        return n2 ^ Integer.MIN_VALUE;
    }

    @CheckReturnValue
    public static int compare(int n2, int n3) {
        return Ints.compare(UnsignedInts.flip(n2), UnsignedInts.flip(n3));
    }

    @CheckReturnValue
    public static long toLong(int n2) {
        return (long)n2 & 0xFFFFFFFFL;
    }

    @CheckReturnValue
    public static /* varargs */ int min(int ... arrn) {
        Preconditions.checkArgument(arrn.length > 0);
        int n2 = UnsignedInts.flip(arrn[0]);
        int n3 = 1;
        while (n3 < arrn.length) {
            int n4 = UnsignedInts.flip(arrn[n3]);
            if (n4 < n2) {
                n2 = n4;
            }
            ++n3;
        }
        return UnsignedInts.flip(n2);
    }

    @CheckReturnValue
    public static /* varargs */ int max(int ... arrn) {
        Preconditions.checkArgument(arrn.length > 0);
        int n2 = UnsignedInts.flip(arrn[0]);
        int n3 = 1;
        while (n3 < arrn.length) {
            int n4 = UnsignedInts.flip(arrn[n3]);
            if (n4 > n2) {
                n2 = n4;
            }
            ++n3;
        }
        return UnsignedInts.flip(n2);
    }

    @CheckReturnValue
    public static /* varargs */ String join(String string, int ... arrn) {
        Preconditions.checkNotNull(string);
        if (arrn.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrn.length * 5);
        stringBuilder.append(UnsignedInts.toString(arrn[0]));
        int n2 = 1;
        while (n2 < arrn.length) {
            stringBuilder.append(string).append(UnsignedInts.toString(arrn[n2]));
            ++n2;
        }
        return stringBuilder.toString();
    }

    @CheckReturnValue
    public static Comparator lexicographicalComparator() {
        return UnsignedInts$LexicographicalComparator.INSTANCE;
    }

    @CheckReturnValue
    public static int divide(int n2, int n3) {
        return (int)(UnsignedInts.toLong(n2) / UnsignedInts.toLong(n3));
    }

    @CheckReturnValue
    public static int remainder(int n2, int n3) {
        return (int)(UnsignedInts.toLong(n2) % UnsignedInts.toLong(n3));
    }

    public static int decode(String string) {
        ParseRequest parseRequest = ParseRequest.fromString(string);
        try {
            return UnsignedInts.parseUnsignedInt(parseRequest.rawValue, parseRequest.radix);
        }
        catch (NumberFormatException var2_2) {
            String string2 = String.valueOf(string);
            NumberFormatException numberFormatException = new NumberFormatException(string2.length() != 0 ? "Error parsing value: ".concat(string2) : new String("Error parsing value: "));
            numberFormatException.initCause(var2_2);
            throw numberFormatException;
        }
    }

    public static int parseUnsignedInt(String string) {
        return UnsignedInts.parseUnsignedInt(string, 10);
    }

    public static int parseUnsignedInt(String string, int n2) {
        Preconditions.checkNotNull(string);
        long l2 = Long.parseLong(string, n2);
        if ((l2 & 0xFFFFFFFFL) == l2) return (int)l2;
        throw new NumberFormatException(new StringBuilder(69 + String.valueOf(string).length()).append("Input ").append(string).append(" in base ").append(n2).append(" is not in the range of an unsigned integer").toString());
    }

    @CheckReturnValue
    public static String toString(int n2) {
        return UnsignedInts.toString(n2, 10);
    }

    @CheckReturnValue
    public static String toString(int n2, int n3) {
        long l2 = (long)n2 & 0xFFFFFFFFL;
        return Long.toString(l2, n3);
    }
}

