package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible
public final class Longs
{
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;
    
    public static int hashCode(final long n) {
        return (int)(n ^ n >>> 32);
    }
    
    @Deprecated
    public static int compare(final long n, final long n2) {
        return (n < n2) ? -1 : ((n > n2) ? 1 : 0);
    }
    
    public static boolean contains(final long[] array, final long n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final long[] array, final long n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final long[] array, final long n, final int n2, final int n3) {
        for (int i = n2; i < n3; ++i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final long[] array, final long[] array2) {
        Preconditions.checkNotNull(array, (Object)"array");
        Preconditions.checkNotNull(array2, (Object)"target");
        if (array2.length == 0) {
            return 0;
        }
        int i = 0;
    Label_0023:
        while (i < array.length - array2.length + 1) {
            for (int j = 0; j < array2.length; ++j) {
                if (array[i + j] != array2[j]) {
                    ++i;
                    continue Label_0023;
                }
            }
            return i;
        }
        return -1;
    }
    
    public static int lastIndexOf(final long[] array, final long n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final long[] array, final long n, final int n2, final int n3) {
        for (int i = n3 - 1; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static long min(final long... array) {
        Preconditions.checkArgument(array.length > 0);
        long n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < n) {
                n = array[i];
            }
        }
        return n;
    }
    
    public static long max(final long... array) {
        Preconditions.checkArgument(array.length > 0);
        long n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > n) {
                n = array[i];
            }
        }
        return n;
    }
    
    public static long[] concat(final long[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final long[] array2 = new long[n];
        int n2 = 0;
        for (final long[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static byte[] toByteArray(long n) {
        final byte[] array = new byte[8];
        for (int i = 7; i >= 0; --i) {
            array[i] = (byte)(n & 0xFFL);
            n >>= 8;
        }
        return array;
    }
    
    public static long fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 8, "array too small: %s < %s", array.length, 8);
        return fromBytes(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
    }
    
    public static long fromBytes(final byte b, final byte b2, final byte b3, final byte b4, final byte b5, final byte b6, final byte b7, final byte b8) {
        return (b & 0xFFL) << 56 | (b2 & 0xFFL) << 48 | (b3 & 0xFFL) << 40 | (b4 & 0xFFL) << 32 | (b5 & 0xFFL) << 24 | (b6 & 0xFFL) << 16 | (b7 & 0xFFL) << 8 | (b8 & 0xFFL);
    }
    
    @Nullable
    @CheckForNull
    @Beta
    public static Long tryParse(final String s) {
        if (((String)Preconditions.checkNotNull(s)).isEmpty()) {
            return null;
        }
        int i;
        final int n = i = ((s.charAt(0) == 45) ? 1 : 0);
        if (i == s.length()) {
            return null;
        }
        final char c = (char)(s.charAt(i++) - '0');
        if (c < '\0' || c > '\t') {
            return null;
        }
        long n2 = -c;
        while (i < s.length()) {
            final char c2 = (char)(s.charAt(i++) - '0');
            if (c2 < '\0' || c2 > '\t' || n2 < -922337203685477580L) {
                return null;
            }
            final long n3 = n2 * 10L;
            if (n3 < Long.MIN_VALUE + c2) {
                return null;
            }
            n2 = n3 - c2;
        }
        if (n != 0) {
            return n2;
        }
        if (n2 == Long.MIN_VALUE) {
            return null;
        }
        return -n2;
    }
    
    @Beta
    public static Converter stringConverter() {
        return Longs$LongConverter.INSTANCE;
    }
    
    public static long[] ensureCapacity(final long[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static long[] copyOf(final long[] array, final int n) {
        final long[] array2 = new long[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final long... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 10);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return Longs$LexicographicalComparator.INSTANCE;
    }
    
    public static long[] toArray(final Collection collection) {
        if (collection instanceof Longs$LongArrayAsList) {
            return ((Longs$LongArrayAsList)collection).toLongArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final long[] array2 = new long[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = ((Number)Preconditions.checkNotNull(array[i])).longValue();
        }
        return array2;
    }
    
    public static List asList(final long... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Longs$LongArrayAsList(array);
    }
}
