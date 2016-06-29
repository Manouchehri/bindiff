package com.google.common.primitives;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
public final class Floats
{
    public static final int BYTES = 4;
    
    public static int hashCode(final float n) {
        return Float.valueOf(n).hashCode();
    }
    
    static int compare(final float n, final float n2) {
        return Float.compare(n, n2);
    }
    
    public static boolean isFinite(final float n) {
        return Float.NEGATIVE_INFINITY < n & n < Float.POSITIVE_INFINITY;
    }
    
    public static boolean contains(final float[] array, final float n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final float[] array, final float n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final float[] array, final float n, final int n2, final int n3) {
        for (int i = n2; i < n3; ++i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final float[] array, final float[] array2) {
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
    
    public static int lastIndexOf(final float[] array, final float n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final float[] array, final float n, final int n2, final int n3) {
        for (int i = n3 - 1; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static float min(final float... array) {
        Preconditions.checkArgument(array.length > 0);
        float min = array[0];
        for (int i = 1; i < array.length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    public static float max(final float... array) {
        Preconditions.checkArgument(array.length > 0);
        float max = array[0];
        for (int i = 1; i < array.length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    public static float[] concat(final float[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final float[] array2 = new float[n];
        int n2 = 0;
        for (final float[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    @Beta
    public static Converter stringConverter() {
        return Floats$FloatConverter.INSTANCE;
    }
    
    public static float[] ensureCapacity(final float[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static float[] copyOf(final float[] array, final int n) {
        final float[] array2 = new float[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final float... array) {
        Preconditions.checkNotNull(s);
        if (array.length == 0) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(array.length * 12);
        sb.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(s).append(array[i]);
        }
        return sb.toString();
    }
    
    public static Comparator lexicographicalComparator() {
        return Floats$LexicographicalComparator.INSTANCE;
    }
    
    public static float[] toArray(final Collection collection) {
        if (collection instanceof Floats$FloatArrayAsList) {
            return ((Floats$FloatArrayAsList)collection).toFloatArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final float[] array2 = new float[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = ((Number)Preconditions.checkNotNull(array[i])).floatValue();
        }
        return array2;
    }
    
    public static List asList(final float... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Floats$FloatArrayAsList(array);
    }
    
    @Nullable
    @CheckForNull
    @Beta
    @GwtIncompatible("regular expressions")
    public static Float tryParse(final String s) {
        if (Doubles.FLOATING_POINT_PATTERN.matcher(s).matches()) {
            try {
                return Float.parseFloat(s);
            }
            catch (NumberFormatException ex) {}
        }
        return null;
    }
}
