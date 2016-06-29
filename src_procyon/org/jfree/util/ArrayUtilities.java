package org.jfree.util;

import java.util.*;

public class ArrayUtilities
{
    public static float[][] clone(final float[][] array) {
        if (array == null) {
            return null;
        }
        final float[][] array2 = new float[array.length][];
        System.arraycopy(array, 0, array2, 0, array.length);
        for (int i = 0; i < array.length; ++i) {
            final float[] array3 = array[i];
            final float[] array4 = new float[array3.length];
            System.arraycopy(array3, 0, array4, 0, array3.length);
            array2[i] = array4;
        }
        return array2;
    }
    
    public static boolean equalReferencesInArrays(final Object[] array, final Object[] array2) {
        if (array == null) {
            return array2 == null;
        }
        if (array2 == null) {
            return false;
        }
        if (array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null && array2[i] != null) {
                return false;
            }
            if (array2[i] == null && array[i] != null) {
                return false;
            }
            if (array[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean equal(final float[][] array, final float[][] array2) {
        if (array == null) {
            return array2 == null;
        }
        if (array2 == null) {
            return false;
        }
        if (array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (!Arrays.equals(array[i], array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean hasDuplicateItems(final Object[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < i; ++j) {
                final Object o = array[i];
                final Object o2 = array[j];
                if (o != null && o2 != null && o.equals(o2)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int compareVersionArrays(final Comparable[] array, final Comparable[] array2) {
        for (int min = Math.min(array.length, array2.length), i = 0; i < min; ++i) {
            final Comparable comparable = array[i];
            final Comparable comparable2 = array2[i];
            if (comparable != null || comparable2 != null) {
                if (comparable == null) {
                    return 1;
                }
                if (comparable2 == null) {
                    return -1;
                }
                final int compareTo = comparable.compareTo(comparable2);
                if (compareTo != 0) {
                    return compareTo;
                }
            }
        }
        return 0;
    }
}
