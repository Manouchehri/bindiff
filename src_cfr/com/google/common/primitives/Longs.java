/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckForNull
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs$LexicographicalComparator;
import com.google.common.primitives.Longs$LongArrayAsList;
import com.google.common.primitives.Longs$LongConverter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 0x4000000000000000L;

    private Longs() {
    }

    public static int hashCode(long l2) {
        return (int)(l2 ^ l2 >>> 32);
    }

    @Deprecated
    public static int compare(long l2, long l3) {
        if (l2 < l3) {
            return -1;
        }
        if (l2 <= l3) return 0;
        return 1;
    }

    public static boolean contains(long[] arrl, long l2) {
        long[] arrl2 = arrl;
        int n2 = arrl2.length;
        int n3 = 0;
        while (n3 < n2) {
            long l3 = arrl2[n3];
            if (l3 == l2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(long[] arrl, long l2) {
        return Longs.indexOf(arrl, l2, 0, arrl.length);
    }

    private static int indexOf(long[] arrl, long l2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrl[n4] == l2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(long[] arrl, long[] arrl2) {
        Preconditions.checkNotNull(arrl, "array");
        Preconditions.checkNotNull(arrl2, "target");
        if (arrl2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrl.length - arrl2.length + 1) {
            int n3 = 0;
            while (n3 < arrl2.length) {
                if (arrl[n2 + n3] != arrl2[n3]) {
                    ++n2;
                    continue block0;
                }
                ++n3;
            }
            return n2;
            break;
        }
        return -1;
    }

    public static int lastIndexOf(long[] arrl, long l2) {
        return Longs.lastIndexOf(arrl, l2, 0, arrl.length);
    }

    private static int lastIndexOf(long[] arrl, long l2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrl[n4] == l2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ long min(long ... arrl) {
        Preconditions.checkArgument(arrl.length > 0);
        long l2 = arrl[0];
        int n2 = 1;
        while (n2 < arrl.length) {
            if (arrl[n2] < l2) {
                l2 = arrl[n2];
            }
            ++n2;
        }
        return l2;
    }

    public static /* varargs */ long max(long ... arrl) {
        Preconditions.checkArgument(arrl.length > 0);
        long l2 = arrl[0];
        int n2 = 1;
        while (n2 < arrl.length) {
            if (arrl[n2] > l2) {
                l2 = arrl[n2];
            }
            ++n2;
        }
        return l2;
    }

    public static /* varargs */ long[] concat(long[] ... arrl) {
        long[] arrl2;
        int n2 = 0;
        long[][] arrl3 = arrl;
        int n3 = arrl3.length;
        for (int i2 = 0; i2 < n3; n2 += arrl2.length, ++i2) {
            arrl2 = arrl3[i2];
        }
        arrl3 = new long[n2];
        n3 = 0;
        long[][] arrl4 = arrl;
        int n4 = arrl4.length;
        int n5 = 0;
        while (n5 < n4) {
            long[] arrl5 = arrl4[n5];
            System.arraycopy(arrl5, 0, arrl3, n3, arrl5.length);
            n3 += arrl5.length;
            ++n5;
        }
        return arrl3;
    }

    public static byte[] toByteArray(long l2) {
        byte[] arrby = new byte[8];
        int n2 = 7;
        while (n2 >= 0) {
            arrby[n2] = (byte)(l2 & 255);
            l2 >>= 8;
            --n2;
        }
        return arrby;
    }

    public static long fromByteArray(byte[] arrby) {
        Preconditions.checkArgument(arrby.length >= 8, "array too small: %s < %s", arrby.length, 8);
        return Longs.fromBytes(arrby[0], arrby[1], arrby[2], arrby[3], arrby[4], arrby[5], arrby[6], arrby[7]);
    }

    public static long fromBytes(byte by2, byte by3, byte by4, byte by5, byte by6, byte by7, byte by8, byte by9) {
        return ((long)by2 & 255) << 56 | ((long)by3 & 255) << 48 | ((long)by4 & 255) << 40 | ((long)by5 & 255) << 32 | ((long)by6 & 255) << 24 | ((long)by7 & 255) << 16 | ((long)by8 & 255) << 8 | (long)by9 & 255;
    }

    @Nullable
    @CheckForNull
    @Beta
    public static Long tryParse(String string) {
        int n2;
        int n3;
        if (((String)Preconditions.checkNotNull(string)).isEmpty()) {
            return null;
        }
        boolean bl2 = string.charAt(0) == '-';
        int n4 = n2 = bl2 ? 1 : 0;
        if (n2 == string.length()) {
            return null;
        }
        if ((n3 = string.charAt(n2++) - 48) < 0) return null;
        if (n3 > 9) {
            return null;
        }
        long l2 = - n3;
        while (n2 < string.length()) {
            if ((n3 = string.charAt(n2++) - 48) < 0) return null;
            if (n3 > 9) return null;
            if (l2 < -922337203685477580L) {
                return null;
            }
            if ((l2 *= 10) < Long.MIN_VALUE + (long)n3) {
                return null;
            }
            l2 -= (long)n3;
        }
        if (bl2) {
            return l2;
        }
        if (l2 != Long.MIN_VALUE) return - l2;
        return null;
    }

    @Beta
    public static Converter stringConverter() {
        return Longs$LongConverter.INSTANCE;
    }

    public static long[] ensureCapacity(long[] arrl, int n2, int n3) {
        long[] arrl2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrl.length < n2) {
            arrl2 = Longs.copyOf(arrl, n2 + n3);
            return arrl2;
        }
        arrl2 = arrl;
        return arrl2;
    }

    private static long[] copyOf(long[] arrl, int n2) {
        long[] arrl2 = new long[n2];
        System.arraycopy(arrl, 0, arrl2, 0, Math.min(arrl.length, n2));
        return arrl2;
    }

    public static /* varargs */ String join(String string, long ... arrl) {
        Preconditions.checkNotNull(string);
        if (arrl.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrl.length * 10);
        stringBuilder.append(arrl[0]);
        int n2 = 1;
        while (n2 < arrl.length) {
            stringBuilder.append(string).append(arrl[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Longs$LexicographicalComparator.INSTANCE;
    }

    public static long[] toArray(Collection collection) {
        if (collection instanceof Longs$LongArrayAsList) {
            return ((Longs$LongArrayAsList)collection).toLongArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        long[] arrl = new long[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrl[n3] = ((Number)Preconditions.checkNotNull(arrobject[n3])).longValue();
            ++n3;
        }
        return arrl;
    }

    public static /* varargs */ List asList(long ... arrl) {
        if (arrl.length != 0) return new Longs$LongArrayAsList(arrl);
        return Collections.emptyList();
    }

    static /* synthetic */ int access$000(long[] arrl, long l2, int n2, int n3) {
        return Longs.indexOf(arrl, l2, n2, n3);
    }

    static /* synthetic */ int access$100(long[] arrl, long l2, int n2, int n3) {
        return Longs.lastIndexOf(arrl, l2, n2, n3);
    }
}

