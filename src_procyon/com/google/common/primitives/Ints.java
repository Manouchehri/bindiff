package com.google.common.primitives;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
public final class Ints
{
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;
    private static final byte[] asciiDigits;
    
    public static int hashCode(final int n) {
        return n;
    }
    
    public static int checkedCast(final long n) {
        final int n2 = (int)n;
        if (n2 != n) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(n).toString());
        }
        return n2;
    }
    
    public static int saturatedCast(final long n) {
        if (n > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (n < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int)n;
    }
    
    @Deprecated
    public static int compare(final int n, final int n2) {
        return (n < n2) ? -1 : ((n > n2) ? 1 : 0);
    }
    
    public static boolean contains(final int[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final int[] array, final int n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final int[] array, final int n, final int n2, final int n3) {
        for (int i = n2; i < n3; ++i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final int[] array, final int[] array2) {
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
    
    public static int lastIndexOf(final int[] array, final int n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final int[] array, final int n, final int n2, final int n3) {
        for (int i = n3 - 1; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static int min(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < n) {
                n = array[i];
            }
        }
        return n;
    }
    
    public static int max(final int... array) {
        Preconditions.checkArgument(array.length > 0);
        int n = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > n) {
                n = array[i];
            }
        }
        return n;
    }
    
    public static int[] concat(final int[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final int[] array2 = new int[n];
        int n2 = 0;
        for (final int[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    @GwtIncompatible("doesn't work")
    public static byte[] toByteArray(final int n) {
        return new byte[] { (byte)(n >> 24), (byte)(n >> 16), (byte)(n >> 8), (byte)n };
    }
    
    @GwtIncompatible("doesn't work")
    public static int fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 4, "array too small: %s < %s", array.length, 4);
        return fromBytes(array[0], array[1], array[2], array[3]);
    }
    
    @GwtIncompatible("doesn't work")
    public static int fromBytes(final byte b, final byte b2, final byte b3, final byte b4) {
        return b << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8 | (b4 & 0xFF);
    }
    
    @Beta
    public static Converter stringConverter() {
        return Ints$IntConverter.INSTANCE;
    }
    
    public static int[] ensureCapacity(final int[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static int[] copyOf(final int[] array, final int n) {
        final int[] array2 = new int[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final int... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 5);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return Ints$LexicographicalComparator.INSTANCE;
    }
    
    public static int[] toArray(final Collection collection) {
        if (collection instanceof Ints$IntArrayAsList) {
            return ((Ints$IntArrayAsList)collection).toIntArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final int[] array2 = new int[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = ((Number)Preconditions.checkNotNull(array[i])).intValue();
        }
        return array2;
    }
    
    public static List asList(final int... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Ints$IntArrayAsList(array);
    }
    
    private static int digit(final char c) {
        return (c < '\u0080') ? Ints.asciiDigits[c] : -1;
    }
    
    @Nullable
    @CheckForNull
    @Beta
    public static Integer tryParse(final String s) {
        return tryParse(s, 10);
    }
    
    @Nullable
    @CheckForNull
    public static Integer tryParse(final String s, final int n) {
        if (((String)Preconditions.checkNotNull(s)).isEmpty()) {
            return null;
        }
        if (n < 2 || n > 36) {
            throw new IllegalArgumentException(new StringBuilder(65).append("radix must be between MIN_RADIX and MAX_RADIX but was ").append(n).toString());
        }
        int i;
        final int n2 = i = ((s.charAt(0) == 45) ? 1 : 0);
        if (i == s.length()) {
            return null;
        }
        final int digit = digit(s.charAt(i++));
        if (digit < 0 || digit >= n) {
            return null;
        }
        int n3 = -digit;
        final int n4 = Integer.MIN_VALUE / n;
        while (i < s.length()) {
            final int digit2 = digit(s.charAt(i++));
            if (digit2 < 0 || digit2 >= n || n3 < n4) {
                return null;
            }
            final int n5 = n3 * n;
            if (n5 < Integer.MIN_VALUE + digit2) {
                return null;
            }
            n3 = n5 - digit2;
        }
        if (n2 != 0) {
            return n3;
        }
        if (n3 == Integer.MIN_VALUE) {
            return null;
        }
        return -n3;
    }
    
    static {
        Arrays.fill(asciiDigits = new byte[128], (byte)(-1));
        for (int i = 0; i <= 9; ++i) {
            Ints.asciiDigits[48 + i] = (byte)i;
        }
        for (int j = 0; j <= 26; ++j) {
            Ints.asciiDigits[65 + j] = (byte)(10 + j);
            Ints.asciiDigits[97 + j] = (byte)(10 + j);
        }
    }
}
