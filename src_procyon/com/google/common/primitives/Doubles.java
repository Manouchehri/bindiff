package com.google.common.primitives;

import java.util.regex.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
public final class Doubles
{
    public static final int BYTES = 8;
    @GwtIncompatible("regular expressions")
    static final Pattern FLOATING_POINT_PATTERN;
    
    public static int hashCode(final double n) {
        return Double.valueOf(n).hashCode();
    }
    
    static int compare(final double n, final double n2) {
        return Double.compare(n, n2);
    }
    
    public static boolean isFinite(final double n) {
        return Double.NEGATIVE_INFINITY < n & n < Double.POSITIVE_INFINITY;
    }
    
    public static boolean contains(final double[] array, final double n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public static int indexOf(final double[] array, final double n) {
        return indexOf(array, n, 0, array.length);
    }
    
    private static int indexOf(final double[] array, final double n, final int n2, final int n3) {
        for (int i = n2; i < n3; ++i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static int indexOf(final double[] array, final double[] array2) {
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
    
    public static int lastIndexOf(final double[] array, final double n) {
        return lastIndexOf(array, n, 0, array.length);
    }
    
    private static int lastIndexOf(final double[] array, final double n, final int n2, final int n3) {
        for (int i = n3 - 1; i >= n2; --i) {
            if (array[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    public static double min(final double... array) {
        Preconditions.checkArgument(array.length > 0);
        double min = array[0];
        for (int i = 1; i < array.length; ++i) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
    
    public static double max(final double... array) {
        Preconditions.checkArgument(array.length > 0);
        double max = array[0];
        for (int i = 1; i < array.length; ++i) {
            max = Math.max(max, array[i]);
        }
        return max;
    }
    
    public static double[] concat(final double[]... array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].length;
        }
        final double[] array2 = new double[n];
        int n2 = 0;
        for (final double[] array3 : array) {
            System.arraycopy(array3, 0, array2, n2, array3.length);
            n2 += array3.length;
        }
        return array2;
    }
    
    @Beta
    public static Converter stringConverter() {
        return Doubles$DoubleConverter.INSTANCE;
    }
    
    public static double[] ensureCapacity(final double[] array, final int n, final int n2) {
        Preconditions.checkArgument(n >= 0, "Invalid minLength: %s", n);
        Preconditions.checkArgument(n2 >= 0, "Invalid padding: %s", n2);
        return (array.length < n) ? copyOf(array, n + n2) : array;
    }
    
    private static double[] copyOf(final double[] array, final int n) {
        final double[] array2 = new double[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public static String join(final String s, final double... array) {
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
        return Doubles$LexicographicalComparator.INSTANCE;
    }
    
    public static double[] toArray(final Collection collection) {
        if (collection instanceof Doubles$DoubleArrayAsList) {
            return ((Doubles$DoubleArrayAsList)collection).toDoubleArray();
        }
        final Object[] array = collection.toArray();
        final int length = array.length;
        final double[] array2 = new double[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = ((Number)Preconditions.checkNotNull(array[i])).doubleValue();
        }
        return array2;
    }
    
    public static List asList(final double... array) {
        if (array.length == 0) {
            return Collections.emptyList();
        }
        return new Doubles$DoubleArrayAsList(array);
    }
    
    @GwtIncompatible("regular expressions")
    private static Pattern fpPattern() {
        final String concat = String.valueOf("(?:\\d++(?:\\.\\d*+)?|\\.\\d++)").concat("(?:[eE][+-]?\\d++)?[fFdD]?");
        final String s = "(?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)";
        final String string = new StringBuilder(25 + String.valueOf(s).length()).append("0[xX]").append(s).append("[pP][+-]?\\d++[fFdD]?").toString();
        return Pattern.compile(new StringBuilder(23 + String.valueOf(concat).length() + String.valueOf(string).length()).append("[+-]?(?:NaN|Infinity|").append(concat).append("|").append(string).append(")").toString());
    }
    
    @Nullable
    @CheckForNull
    @Beta
    @GwtIncompatible("regular expressions")
    public static Double tryParse(final String s) {
        if (Doubles.FLOATING_POINT_PATTERN.matcher(s).matches()) {
            try {
                return Double.parseDouble(s);
            }
            catch (NumberFormatException ex) {}
        }
        return null;
    }
    
    static {
        FLOATING_POINT_PATTERN = fpPattern();
    }
}
