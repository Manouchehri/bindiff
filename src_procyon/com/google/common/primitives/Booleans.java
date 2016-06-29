package com.google.common.primitives;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
public final class Booleans
{
    public static int hashCode(final boolean b) {
        return b ? 1231 : 1237;
    }
    
    @Deprecated
    public static int compare(final boolean b, final boolean b2) {
        return (b == b2) ? 0 : (b ? 1 : -1);
    }
    
    public static boolean contains(final boolean[] array, final boolean b) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == b) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final boolean[] array, final boolean b) {
        return indexOf(array, b, 0, array.length);
    }
    
    private static int indexOf(final boolean[] array, final boolean b, final int n, final int n2) {
        for (int i = n; i < n2; ++i) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final boolean[] array, final boolean[] array2) {
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
    
    public static int lastIndexOf(final boolean[] array, final boolean b) {
        return lastIndexOf(array, b, 0, array.length);
    }
    
    private static int lastIndexOf(final boolean[] array, final boolean b, final int n, final int n2) {
        for (int i = n2 - 1; i >= n; --i) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean[] concat(final boolean[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final boolean[] array2 = new boolean[n];
        int n2 = 0;
        for (final boolean[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    public static boolean[] ensureCapacity(final boolean[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static boolean[] copyOf(final boolean[] array, final int n) {
        final boolean[] array2 = new boolean[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final boolean... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 7);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return Booleans$LexicographicalComparator.INSTANCE;
    }
    
    public static boolean[] toArray(final Collection collection) {
        if (collection instanceof Booleans$BooleanArrayAsList) {
            return ((Booleans$BooleanArrayAsList)collection).toBooleanArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final boolean[] array2 = new boolean[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = (boolean)Preconditions.checkNotNull(array[i]);
        }
        return array2;
    }
    
    public static List asList(final boolean... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Booleans$BooleanArrayAsList(array);
    }
    
    @Beta
    public static int countTrue(final boolean... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i]) {
                ++n;
            }
        }
        return n;
    }
}
