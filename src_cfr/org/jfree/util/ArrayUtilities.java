/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.Arrays;

public class ArrayUtilities {
    private ArrayUtilities() {
    }

    public static float[][] clone(float[][] arrf) {
        if (arrf == null) {
            return null;
        }
        float[][] arrarrf = new float[arrf.length][];
        System.arraycopy(arrf, 0, arrarrf, 0, arrf.length);
        int n2 = 0;
        while (n2 < arrf.length) {
            float[] arrf2 = arrf[n2];
            float[] arrf3 = new float[arrf2.length];
            System.arraycopy(arrf2, 0, arrf3, 0, arrf2.length);
            arrarrf[n2] = arrf3;
            ++n2;
        }
        return arrarrf;
    }

    public static boolean equalReferencesInArrays(Object[] arrobject, Object[] arrobject2) {
        if (arrobject == null) {
            if (arrobject2 != null) return false;
            return true;
        }
        if (arrobject2 == null) {
            return false;
        }
        if (arrobject.length != arrobject2.length) {
            return false;
        }
        int n2 = 0;
        while (n2 < arrobject.length) {
            if (arrobject[n2] == null && arrobject2[n2] != null) {
                return false;
            }
            if (arrobject2[n2] == null && arrobject[n2] != null) {
                return false;
            }
            if (arrobject[n2] != arrobject2[n2]) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static boolean equal(float[][] arrf, float[][] arrf2) {
        if (arrf == null) {
            if (arrf2 != null) return false;
            return true;
        }
        if (arrf2 == null) {
            return false;
        }
        if (arrf.length != arrf2.length) {
            return false;
        }
        int n2 = 0;
        while (n2 < arrf.length) {
            if (!Arrays.equals(arrf[n2], arrf2[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static boolean hasDuplicateItems(Object[] arrobject) {
        int n2 = 0;
        while (n2 < arrobject.length) {
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = arrobject[n2];
                Object object2 = arrobject[i2];
                if (object == null || object2 == null || !object.equals(object2)) continue;
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static int compareVersionArrays(Comparable[] arrcomparable, Comparable[] arrcomparable2) {
        int n2 = Math.min(arrcomparable.length, arrcomparable2.length);
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable = arrcomparable[n3];
            Comparable comparable2 = arrcomparable2[n3];
            if (comparable != null || comparable2 != null) {
                if (comparable == null) {
                    return 1;
                }
                if (comparable2 == null) {
                    return -1;
                }
                int n4 = comparable.compareTo(comparable2);
                if (n4 != 0) {
                    return n4;
                }
            }
            ++n3;
        }
        return 0;
    }
}

