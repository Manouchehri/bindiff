package com.google.common.math;

import com.google.common.annotations.*;

@GoogleInternal
public final class Quantiles
{
    public static Quantiles$ScaleAndIndex median() {
        return scale(2).index(1);
    }
    
    public static Quantiles$Scale quartiles() {
        return scale(4);
    }
    
    public static Quantiles$Scale percentiles() {
        return scale(100);
    }
    
    public static Quantiles$Scale scale(final int n) {
        return new Quantiles$Scale(n, null);
    }
    
    private static void checkIndex(final int n, final int n2) {
        if (n < 0 || n > n2) {
            throw new IllegalArgumentException(new StringBuilder(70).append("Quantile indexes must be between 0 and the scale, which is ").append(n2).toString());
        }
    }
    
    private static double[] longsToDoubles(final long[] array) {
        final int length = array.length;
        final double[] array2 = new double[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    private static double[] intsToDoubles(final int[] array) {
        final int length = array.length;
        final double[] array2 = new double[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = array[i];
        }
        return array2;
    }
    
    private static void selectInPlace(final int n, final double[] array, int n2, int i) {
        if (n == n2) {
            int n3 = n2;
            for (int j = n2 + 1; j <= i; ++j) {
                if (array[n3] > array[j]) {
                    n3 = j;
                }
            }
            if (n3 != n2) {
                swap(array, n3, n2);
            }
            return;
        }
        while (i > n2) {
            final int partition = partition(array, n2, i);
            if (partition >= n) {
                i = partition - 1;
            }
            if (partition <= n) {
                n2 = partition + 1;
            }
        }
    }
    
    private static int partition(final double[] array, final int n, final int n2) {
        movePivotToStartOfSlice(array, n, n2);
        final double n3 = array[n];
        int n4 = n2;
        for (int i = n2; i > n; --i) {
            if (array[i] > n3) {
                swap(array, n4, i);
                --n4;
            }
        }
        swap(array, n, n4);
        return n4;
    }
    
    private static void movePivotToStartOfSlice(final double[] array, final int n, final int n2) {
        final int n3 = n + n2 >>> 1;
        final boolean b = array[n2] < array[n3];
        final boolean b2 = array[n3] < array[n];
        final boolean b3 = array[n2] < array[n];
        if (b == b2) {
            swap(array, n3, n);
        }
        else if (b != b3) {
            swap(array, n, n2);
        }
    }
    
    private static void selectAllInPlace(final int[] array, final int n, final int n2, final double[] array2, final int n3, final int n4) {
        final int chooseNextSelection = chooseNextSelection(array, n, n2, n3, n4);
        final int n5 = array[chooseNextSelection];
        selectInPlace(n5, array2, n3, n4);
        int n6;
        for (n6 = chooseNextSelection - 1; n6 >= n && array[n6] == n5; --n6) {}
        if (n6 >= n) {
            selectAllInPlace(array, n, n6, array2, n3, n5 - 1);
        }
        int n7;
        for (n7 = chooseNextSelection + 1; n7 <= n2 && array[n7] == n5; ++n7) {}
        if (n7 <= n2) {
            selectAllInPlace(array, n7, n2, array2, n5 + 1, n4);
        }
    }
    
    private static int chooseNextSelection(final int[] array, final int n, final int n2, final int n3, final int n4) {
        if (n == n2) {
            return n;
        }
        final int n5 = n3 + n4 >>> 1;
        int n6 = n;
        int i = n2;
        while (i > n6 + 1) {
            final int n7 = n6 + i >>> 1;
            if (array[n7] > n5) {
                i = n7;
            }
            else {
                if (array[n7] >= n5) {
                    return n7;
                }
                n6 = n7;
            }
        }
        if (n3 + n4 - array[n6] - array[i] > 0) {
            return i;
        }
        return n6;
    }
    
    private static void swap(final double[] array, final int n, final int n2) {
        final double n3 = array[n];
        array[n] = array[n2];
        array[n2] = n3;
    }
}
