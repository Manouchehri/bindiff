package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
public final class Chars
{
    public static final int BYTES = 2;
    
    public static int hashCode(final char c) {
        return c;
    }
    
    public static char checkedCast(final long n) {
        final char c = (char)n;
        if (c != n) {
            throw new IllegalArgumentException(new StringBuilder(34).append("Out of range: ").append(n).toString());
        }
        return c;
    }
    
    public static char saturatedCast(final long n) {
        if (n > 65535L) {
            return '\uffff';
        }
        if (n < 0L) {
            return '\0';
        }
        return (char)n;
    }
    
    @Deprecated
    public static int compare(final char c, final char c2) {
        return c - c2;
    }
    
    public static boolean contains(final char[] array, final char c) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == c) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final char[] array, final char c) {
        return indexOf(array, c, 0, array.length);
    }
    
    private static int indexOf(final char[] array, final char c, final int n, final int n2) {
        for (int i = n; i < n2; ++i) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final char[] array, final char[] array2) {
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
    
    public static int lastIndexOf(final char[] array, final char c) {
        return lastIndexOf(array, c, 0, array.length);
    }
    
    private static int lastIndexOf(final char[] array, final char c, final int n, final int n2) {
        for (int i = n2 - 1; i >= n; --i) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    public static char min(final char... array) {
        Preconditions.checkArgument(array.length > 0);
        char c = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < c) {
                c = array[i];
            }
        }
        return c;
    }
    
    public static char max(final char... array) {
        Preconditions.checkArgument(array.length > 0);
        char c = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > c) {
                c = array[i];
            }
        }
        return c;
    }
    
    public static char[] concat(final char[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final char[] array2 = new char[n];
        int n2 = 0;
        for (final char[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    @GwtIncompatible("doesn't work")
    public static byte[] toByteArray(final char c) {
        return new byte[] { (byte)(c >> 8), (byte)c };
    }
    
    @GwtIncompatible("doesn't work")
    public static char fromByteArray(final byte[] array) {
        Preconditions.checkArgument(array.length >= 2, "array too small: %s < %s", array.length, 2);
        return fromBytes(array[0], array[1]);
    }
    
    @GwtIncompatible("doesn't work")
    public static char fromBytes(final byte b, final byte b2) {
        return (char)(b << 8 | (b2 & 0xFF));
    }
    
    public static char[] ensureCapacity(final char[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static char[] copyOf(final char[] array, final int n) {
        final char[] array2 = new char[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final char... array) {
        Preconditions.checkNotNull(s);
        final int length = array.length;
        if (length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(length + s.length() * (length - 1));
        sb.append(array[0]);
        for (int i = 1; i < length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return Chars$LexicographicalComparator.INSTANCE;
    }
    
    public static char[] toArray(final Collection collection) {
        if (collection instanceof Chars$CharArrayAsList) {
            return ((Chars$CharArrayAsList)collection).toCharArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final char[] array2 = new char[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = (char)Preconditions.checkNotNull(array[i]);
        }
        return array2;
    }
    
    public static List asList(final char... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Chars$CharArrayAsList(array);
    }
}
