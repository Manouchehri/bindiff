package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
public final class Shorts
{
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;
    
    public static int hashCode(final short n) {
        return n;
    }
    
    public static short checkedCast(final long n) {
        final short n2 = (short)n;
        if (n2 != n) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(n).toString());
        }
        return n2;
    }
    
    public static short saturatedCast(final long n) {
        if (n > 32767L) {
            return 32767;
        }
        if (n < -32768L) {
            return -32768;
        }
        return (short)n;
    }
    
    @Deprecated
    public static int compare(final short n, final short n2) {
        return n - n2;
    }
    
    public static boolean contains(final short[] array, final short n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final short[] array, final short n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final short[] array, final short n, final int n2, final int n3) {
        for (int i = n2; i < n3; ++i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final short[] array, final short[] array2) {
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
    
    public static int lastIndexOf(final short[] array, final short n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final short[] array, final short n, final int n2, final int n3) {
        for (int i = n3 - 1; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static short min(final short... array) {
        Preconditions.checkArgument(array.length > 0);
        short n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < n) {
                n = array[i];
            }
        }
        return n;
    }
    
    public static short max(final short... array) {
        Preconditions.checkArgument(array.length > 0);
        short n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > n) {
                n = array[i];
            }
        }
        return n;
    }
    
    public static short[] concat(final short[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final short[] array2 = new short[n];
        int n2 = 0;
        for (final short[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    @GwtIncompatible("doesn't work")
    public static byte[] toByteArray(final short n) {
        return new byte[] { (byte)(n >> 8), (byte)n };
    }
    
    @GwtIncompatible("doesn't work")
    public static short fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 2, "array too small: %s < %s", array.length, 2);
        return fromBytes(array[0], array[1]);
    }
    
    @GwtIncompatible("doesn't work")
    public static short fromBytes(final byte b, final byte b2) {
        return (short)(b << 8 | (b2 & 0xFF));
    }
    
    @Beta
    public static Converter stringConverter() {
        return Shorts$ShortConverter.INSTANCE;
    }
    
    public static short[] ensureCapacity(final short[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static short[] copyOf(final short[] array, final int n) {
        final short[] array2 = new short[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final short... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 6);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return Shorts$LexicographicalComparator.INSTANCE;
    }
    
    public static short[] toArray(final Collection collection) {
        if (collection instanceof Shorts$ShortArrayAsList) {
            return ((Shorts$ShortArrayAsList)collection).toShortArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final short[] array2 = new short[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = ((Number)Preconditions.checkNotNull(array[i])).shortValue();
        }
        return array2;
    }
    
    public static List asList(final short... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Shorts$ShortArrayAsList(array);
    }
}
