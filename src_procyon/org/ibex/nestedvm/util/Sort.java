package org.ibex.nestedvm.util;

public final class Sort
{
    private static final Sort$CompareFunc comparableCompareFunc;
    
    public static void sort(final Sort$Comparable[] array) {
        sort(array, Sort.comparableCompareFunc);
    }
    
    public static void sort(final Object[] array, final Sort$CompareFunc sort$CompareFunc) {
        sort(array, sort$CompareFunc, 0, array.length - 1);
    }
    
    private static void sort(final Object[] array, final Sort$CompareFunc sort$CompareFunc, final int n, int n2) {
        if (n >= n2) {
            return;
        }
        if (n2 - n <= 6) {
            for (int i = n + 1; i <= n2; ++i) {
                Object o;
                int n3;
                for (o = array[i], n3 = i - 1; n3 >= n && sort$CompareFunc.compare(array[n3], o) > 0; --n3) {
                    array[n3 + 1] = array[n3];
                }
                array[n3 + 1] = o;
            }
            return;
        }
        final Object o2 = array[n2];
        int n4 = n - 1;
        while (true) {
            if (n4 < n2 && sort$CompareFunc.compare(array[++n4], o2) < 0) {
                continue;
            }
            while (n2 > n4 && sort$CompareFunc.compare(array[--n2], o2) > 0) {}
            final Object o3 = array[n4];
            array[n4] = array[n2];
            array[n2] = o3;
            if (n4 >= n2) {
                break;
            }
        }
        final Object o4 = array[n4];
        array[n4] = array[n2];
        array[n2] = o4;
        sort(array, sort$CompareFunc, n, n4 - 1);
        sort(array, sort$CompareFunc, n4 + 1, n2);
    }
    
    static {
        comparableCompareFunc = new Sort$1();
    }
}
