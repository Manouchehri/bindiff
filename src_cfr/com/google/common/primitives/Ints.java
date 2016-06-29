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
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints$IntArrayAsList;
import com.google.common.primitives.Ints$IntConverter;
import com.google.common.primitives.Ints$LexicographicalComparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(emulated=1)
public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;
    private static final byte[] asciiDigits;

    private Ints() {
    }

    public static int hashCode(int n2) {
        return n2;
    }

    public static int checkedCast(long l2) {
        int n2 = (int)l2;
        if ((long)n2 == l2) return n2;
        throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(l2).toString());
    }

    public static int saturatedCast(long l2) {
        if (l2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (l2 >= Integer.MIN_VALUE) return (int)l2;
        return Integer.MIN_VALUE;
    }

    @Deprecated
    public static int compare(int n2, int n3) {
        if (n2 < n3) {
            return -1;
        }
        if (n2 <= n3) return 0;
        return 1;
    }

    public static boolean contains(int[] arrn, int n2) {
        int[] arrn2 = arrn;
        int n3 = arrn2.length;
        int n4 = 0;
        while (n4 < n3) {
            int n5 = arrn2[n4];
            if (n5 == n2) {
                return true;
            }
            ++n4;
        }
        return false;
    }

    public static int indexOf(int[] arrn, int n2) {
        return Ints.indexOf(arrn, n2, 0, arrn.length);
    }

    private static int indexOf(int[] arrn, int n2, int n3, int n4) {
        int n5 = n3;
        while (n5 < n4) {
            if (arrn[n5] == n2) {
                return n5;
            }
            ++n5;
        }
        return -1;
    }

    public static int indexOf(int[] arrn, int[] arrn2) {
        Preconditions.checkNotNull(arrn, "array");
        Preconditions.checkNotNull(arrn2, "target");
        if (arrn2.length == 0) {
            return 0;
        }
        int n2 = 0;
        block0 : while (n2 < arrn.length - arrn2.length + 1) {
            int n3 = 0;
            while (n3 < arrn2.length) {
                if (arrn[n2 + n3] != arrn2[n3]) {
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

    public static int lastIndexOf(int[] arrn, int n2) {
        return Ints.lastIndexOf(arrn, n2, 0, arrn.length);
    }

    private static int lastIndexOf(int[] arrn, int n2, int n3, int n4) {
        int n5 = n4 - 1;
        while (n5 >= n3) {
            if (arrn[n5] == n2) {
                return n5;
            }
            --n5;
        }
        return -1;
    }

    public static /* varargs */ int min(int ... arrn) {
        Preconditions.checkArgument(arrn.length > 0);
        int n2 = arrn[0];
        int n3 = 1;
        while (n3 < arrn.length) {
            if (arrn[n3] < n2) {
                n2 = arrn[n3];
            }
            ++n3;
        }
        return n2;
    }

    public static /* varargs */ int max(int ... arrn) {
        Preconditions.checkArgument(arrn.length > 0);
        int n2 = arrn[0];
        int n3 = 1;
        while (n3 < arrn.length) {
            if (arrn[n3] > n2) {
                n2 = arrn[n3];
            }
            ++n3;
        }
        return n2;
    }

    public static /* varargs */ int[] concat(int[] ... arrn) {
        int[] arrn2;
        int n2 = 0;
        int[][] arrn3 = arrn;
        int n3 = arrn3.length;
        for (int i2 = 0; i2 < n3; n2 += arrn2.length, ++i2) {
            arrn2 = arrn3[i2];
        }
        arrn3 = new int[n2];
        n3 = 0;
        int[][] arrn4 = arrn;
        int n4 = arrn4.length;
        int n5 = 0;
        while (n5 < n4) {
            int[] arrn5 = arrn4[n5];
            System.arraycopy(arrn5, 0, arrn3, n3, arrn5.length);
            n3 += arrn5.length;
            ++n5;
        }
        return arrn3;
    }

    @GwtIncompatible(value="doesn't work")
    public static byte[] toByteArray(int n2) {
        return new byte[]{(byte)(n2 >> 24), (byte)(n2 >> 16), (byte)(n2 >> 8), (byte)n2};
    }

    @GwtIncompatible(value="doesn't work")
    public static int fromByteArray(byte[] arrby) {
        Preconditions.checkArgument(arrby.length >= 4, "array too small: %s < %s", arrby.length, 4);
        return Ints.fromBytes(arrby[0], arrby[1], arrby[2], arrby[3]);
    }

    @GwtIncompatible(value="doesn't work")
    public static int fromBytes(byte by2, byte by3, byte by4, byte by5) {
        return by2 << 24 | (by3 & 255) << 16 | (by4 & 255) << 8 | by5 & 255;
    }

    @Beta
    public static Converter stringConverter() {
        return Ints$IntConverter.INSTANCE;
    }

    public static int[] ensureCapacity(int[] arrn, int n2, int n3) {
        int[] arrn2;
        Preconditions.checkArgument(n2 >= 0, "Invalid minLength: %s", n2);
        Preconditions.checkArgument(n3 >= 0, "Invalid padding: %s", n3);
        if (arrn.length < n2) {
            arrn2 = Ints.copyOf(arrn, n2 + n3);
            return arrn2;
        }
        arrn2 = arrn;
        return arrn2;
    }

    private static int[] copyOf(int[] arrn, int n2) {
        int[] arrn2 = new int[n2];
        System.arraycopy(arrn, 0, arrn2, 0, Math.min(arrn.length, n2));
        return arrn2;
    }

    public static /* varargs */ String join(String string, int ... arrn) {
        Preconditions.checkNotNull(string);
        if (arrn.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(arrn.length * 5);
        stringBuilder.append(arrn[0]);
        int n2 = 1;
        while (n2 < arrn.length) {
            stringBuilder.append(string).append(arrn[n2]);
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return Ints$LexicographicalComparator.INSTANCE;
    }

    public static int[] toArray(Collection collection) {
        if (collection instanceof Ints$IntArrayAsList) {
            return ((Ints$IntArrayAsList)collection).toIntArray();
        }
        Object[] arrobject = collection.toArray();
        int n2 = arrobject.length;
        int[] arrn = new int[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrn[n3] = ((Number)Preconditions.checkNotNull(arrobject[n3])).intValue();
            ++n3;
        }
        return arrn;
    }

    public static /* varargs */ List asList(int ... arrn) {
        if (arrn.length != 0) return new Ints$IntArrayAsList(arrn);
        return Collections.emptyList();
    }

    private static int digit(char c2) {
        if (c2 >= '?') return -1;
        int n2 = asciiDigits[c2];
        return n2;
    }

    @Nullable
    @CheckForNull
    @Beta
    public static Integer tryParse(String string) {
        return Ints.tryParse(string, 10);
    }

    @Nullable
    @CheckForNull
    public static Integer tryParse(String string, int n2) {
        int n3;
        int n4;
        if (((String)Preconditions.checkNotNull(string)).isEmpty()) {
            return null;
        }
        if (n2 < 2) throw new IllegalArgumentException(new StringBuilder(65).append("radix must be between MIN_RADIX and MAX_RADIX but was ").append(n2).toString());
        if (n2 > 36) {
            throw new IllegalArgumentException(new StringBuilder(65).append("radix must be between MIN_RADIX and MAX_RADIX but was ").append(n2).toString());
        }
        boolean bl2 = string.charAt(0) == '-';
        int n5 = n4 = bl2 ? 1 : 0;
        if (n4 == string.length()) {
            return null;
        }
        if ((n3 = Ints.digit(string.charAt(n4++))) < 0) return null;
        if (n3 >= n2) {
            return null;
        }
        int n6 = - n3;
        int n7 = Integer.MIN_VALUE / n2;
        while (n4 < string.length()) {
            if ((n3 = Ints.digit(string.charAt(n4++))) < 0) return null;
            if (n3 >= n2) return null;
            if (n6 < n7) {
                return null;
            }
            if ((n6 *= n2) < Integer.MIN_VALUE + n3) {
                return null;
            }
            n6 -= n3;
        }
        if (bl2) {
            return n6;
        }
        if (n6 != Integer.MIN_VALUE) return - n6;
        return null;
    }

    static /* synthetic */ int access$000(int[] arrn, int n2, int n3, int n4) {
        return Ints.indexOf(arrn, n2, n3, n4);
    }

    static /* synthetic */ int access$100(int[] arrn, int n2, int n3, int n4) {
        return Ints.lastIndexOf(arrn, n2, n3, n4);
    }

    static {
        int n2;
        asciiDigits = new byte[128];
        Arrays.fill(asciiDigits, -1);
        for (n2 = 0; n2 <= 9; ++n2) {
            Ints.asciiDigits[48 + n2] = (byte)n2;
        }
        n2 = 0;
        while (n2 <= 26) {
            Ints.asciiDigits[65 + n2] = (byte)(10 + n2);
            Ints.asciiDigits[97 + n2] = (byte)(10 + n2);
            ++n2;
        }
    }
}

