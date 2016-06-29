/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Shorts$LexicographicalComparator;
import com.google.common.primitives.Shorts$ShortArrayAsList;
import com.google.common.primitives.Shorts$ShortConverter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible(emulated=1)
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    private Shorts() {
    }

    public static int hashCode(short s2) {
        return s2;
    }

    public static short checkedCast(long l2) {
        short s2 = (short)l2;
        if ((long)s2 == l2) return s2;
        throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(l2).toString());
    }

    public static short saturatedCast(long l2) {
        if (l2 > 32767) {
            return 32767;
        }
        if (l2 >= -32768) return (short)l2;
        return -32768;
    }

    @Deprecated
    public static int compare(short s2, short s3) {
        return s2 - s3;
    }

    public static boolean contains(short[] arrs, short s2) {
        short[] arrs2 = arrs;
        int n2 = arrs2.length;
        int n3 = 0;
        while (n3 < n2) {
            short s3 = arrs2[n3];
            if (s3 == s2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static int indexOf(short[] arrs, short s2) {
        return Shorts.indexOf(arrs, s2, 0, arrs.length);
    }

    private static int indexOf(short[] arrs, short s2, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            if (arrs[n4] == s2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public static int indexOf(short[] arrs, short[] arrs2) {
        Preconditions.checkNotNull(arrs, "array");
        Preconditions.checkNotNull(arrs2, "target");
        if (arrs2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrs.length - arrs2.length + 1) {
            int n3 = 0;
            while (n3 < arrs2.length) {
                if (arrs[n2 + n3] != arrs2[n3]) {
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

    public static int lastIndexOf(short[] arrs, short s2) {
        return Shorts.lastIndexOf(arrs, s2, 0, arrs.length);
    }

    private static int lastIndexOf(short[] arrs, short s2, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            if (arrs[n4] == s2) {
                return n4;
            }
            --n4;
        }
        return -1;
    }

    public static /* varargs */ short min(short ... arrs) {
        Preconditions.checkArgument(arrs.length > 0);
        short s2 = arrs[0];
        int n2 = 1;
        while (n2 < arrs.length) {
            if (arrs[n2] < s2) {
                s2 = arrs[n2];
            }
            ++n2;
        }
        return s2;
    }

    public static /* varargs */ short max(short ... arrs) {
        Preconditions.checkArgument(arrs.length > 0);
        short s2 = arrs[0];
        int n2 = 1;
        while (n2 < arrs.length) {
            if (arrs[n2] > s2) {
                s2 = arrs[n2];
            }
            ++n2;
        }
        return s2;
    }

    public static /* varargs */ short[] concat(short[] ... arrs) {
        short[] arrs2;
        int n2 = 0;
        short[][] arrs3 = arrs;
        int n3 = arrs3.length;
        for (int i2 = 0; i2 < n3; n2 += arrs2.length, ++i2) {
            arrs2 = arrs3[i2];
        }
        arrs3 = new short[n2];
        n3 = 0;
        short[][] arrs4 = arrs;
        int n4 = arrs4.length;
        int n5 = 0;
        while (n5 < n4) {
            short[] arrs5 = arrs4[n5];
            System.arraycopy(arrs5, 0, arrs3, n3, arrs5.length);
            n3 += arrs5.length;
            ++n5;
        }
        return arrs3;
    }

    @GwtIncompatible(value="doesn't work")
    public static byte[] toByteArray(short s2) {
        return new byte[]{(byte)(s2 >> 8), (byte)s2};
    }

    @GwtIncompatible(value="doesn't work")
    public static short fromByteArray(byte[] arrby) {
        Preconditions.checkArgument(arrby.length >= 2, "array too small: %s < %s", arrby.length, 2);
        return Shorts.fromBytes(arrby[0], arrby[1]);
    }

    @GwtIncompatible(value="doesn't work")
    public static short fromBytes(byte by2, byte by3) {
        return (short)(by2 << 8 | by3 & 255);
    }

    @Beta
    public static Converter stringConverter() {
        return Shorts$ShortConverter.INSTANCE;
    }

    public static short[] ensureCapacity(short[] arrs, int n2, int n3) {
        short[] arrs2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrs.length < n2) {
            arrs2 = Shorts.copyOf(arrs, n2 + n3);
            return arrs2;
        }
        arrs2 = arrs;
        return arrs2;
    }

    private static short[] copyOf(short[] arrs, int n2) {
        short[] arrs2 = new short[n2];
        System.arraycopy(arrs, 0, arrs2, 0, Math.min(arrs.length, n2));
        return arrs2;
    }

    public static /* varargs */ String join(String string, short ... arrs) {
        Preconditions.checkNotNull(string);
        if (arrs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrs.length * 6);
        stringBuilder.append(arrs[0]);
        int n2 = 1;
        while (n2 < arrs.length) {
            stringBuilder.append(string).append(arrs[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Shorts$LexicographicalComparator.INSTANCE;
    }

    public static short[] toArray(Collection collection) {
        if (collection instanceof Shorts$ShortArrayAsList) {
            return ((Shorts$ShortArrayAsList)collection).toShortArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        short[] arrs = new short[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrs[n3] = ((Number)Preconditions.checkNotNull(arrobject[n3])).shortValue();
            ++n3;
        }
        return arrs;
    }

    public static /* varargs */ List asList(short ... arrs) {
        if (arrs.length != 0) return new Shorts$ShortArrayAsList(arrs);
        return Collections.emptyList();
    }

    static /* synthetic */ int access$000(short[] arrs, short s2, int n2, int n3) {
        return Shorts.indexOf(arrs, s2, n2, n3);
    }

    static /* synthetic */ int access$100(short[] arrs, short s2, int n2, int n3) {
        return Shorts.lastIndexOf(arrs, s2, n2, n3);
    }
}

