package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible
public final class Bytes
{
    public static int hashCode(final byte b) {
        return b;
    }
    
    public static boolean contains(final byte[] array, final byte b) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == b) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final byte[] array, final byte b) {
        return indexOf(array, b, 0, array.length);
    }
    
    private static int indexOf(final byte[] array, final byte b, final int n, final int n2) {
        for (int i = n; i < n2; ++i) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final byte[] array, final byte[] array2) {
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
    
    public static int lastIndexOf(final byte[] array, final byte b) {
        return lastIndexOf(array, b, 0, array.length);
    }
    
    private static int lastIndexOf(final byte[] array, final byte b, final int n, final int n2) {
        for (int i = n2 - 1; i >= n; --i) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }
    
    public static byte[] concat(final byte[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final byte[] array2 = new byte[n];
        int n2 = 0;
        for (final byte[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static byte[] ensureCapacity(final byte[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static byte[] copyOf(final byte[] array, final int n) {
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static byte[] toArray(final Collection collection) {
        if (collection instanceof Bytes$ByteArrayAsList) {
            return ((Bytes$ByteArrayAsList)collection).toByteArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final byte[] array2 = new byte[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = ((Number)Preconditions.checkNotNull(array[i])).byteValue();
        }
        return array2;
    }
    
    public static List asList(final byte... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Bytes$ByteArrayAsList(array);
    }
}
