/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.SignedBytes$LexicographicalComparator;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    private SignedBytes() {
    }

    public static byte checkedCast(long l2) {
        byte by2 = (byte)l2;
        if ((long)by2 == l2) return by2;
        throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(l2).toString());
    }

    public static byte saturatedCast(long l2) {
        if (l2 > 127) {
            return 127;
        }
        if (l2 >= -128) return (byte)l2;
        return -128;
    }

    public static int compare(byte by2, byte by3) {
        return by2 - by3;
    }

    public static /* varargs */ byte min(byte ... arrby) {
        Preconditions.checkArgument(arrby.length > 0);
        byte by2 = arrby[0];
        int n2 = 1;
        while (n2 < arrby.length) {
            if (arrby[n2] < by2) {
                by2 = arrby[n2];
            }
            ++n2;
        }
        return by2;
    }

    public static /* varargs */ byte max(byte ... arrby) {
        Preconditions.checkArgument(arrby.length > 0);
        byte by2 = arrby[0];
        int n2 = 1;
        while (n2 < arrby.length) {
            if (arrby[n2] > by2) {
                by2 = arrby[n2];
            }
            ++n2;
        }
        return by2;
    }

    public static /* varargs */ String join(String string, byte ... arrby) {
        Preconditions.checkNotNull(string);
        if (arrby.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrby.length * 5);
        stringBuilder.append(arrby[0]);
        int n2 = 1;
        while (n2 < arrby.length) {
            stringBuilder.append(string).append(arrby[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return SignedBytes$LexicographicalComparator.INSTANCE;
    }
}

