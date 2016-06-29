/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.Sort$1;
import org.ibex.nestedvm.util.Sort$Comparable;
import org.ibex.nestedvm.util.Sort$CompareFunc;

public final class Sort {
    private static final Sort$CompareFunc comparableCompareFunc = new Sort$1();

    private Sort() {
    }

    public static void sort(Sort$Comparable[] arrsort$Comparable) {
        Sort.sort(arrsort$Comparable, comparableCompareFunc);
    }

    public static void sort(Object[] arrobject, Sort$CompareFunc sort$CompareFunc) {
        Sort.sort(arrobject, sort$CompareFunc, 0, arrobject.length - 1);
    }

    private static void sort(Object[] arrobject, Sort$CompareFunc sort$CompareFunc, int n2, int n3) {
        Object object;
        if (n2 >= n3) {
            return;
        }
        if (n3 - n2 <= 6) {
            int n4 = n2 + 1;
            while (n4 <= n3) {
                Object object2 = arrobject[n4];
                for (int i2 = n4 - 1; i2 >= n2 && sort$CompareFunc.compare(arrobject[i2], object2) > 0; --i2) {
                    arrobject[i2 + 1] = arrobject[i2];
                }
                arrobject[i2 + 1] = object2;
                ++n4;
            }
            return;
        }
        Object object3 = arrobject[n3];
        int n5 = n2 - 1;
        int n6 = n3;
        do {
            if (n5 < n6 && sort$CompareFunc.compare(arrobject[++n5], object3) < 0) continue;
            while (n6 > n5 && sort$CompareFunc.compare(arrobject[--n6], object3) > 0) {
            }
            object = arrobject[n5];
            arrobject[n5] = arrobject[n6];
            arrobject[n6] = object;
            if (n5 >= n6) break;
        } while (true);
        object = arrobject[n5];
        arrobject[n5] = arrobject[n3];
        arrobject[n3] = object;
        Sort.sort(arrobject, sort$CompareFunc, n2, n5 - 1);
        Sort.sort(arrobject, sort$CompareFunc, n5 + 1, n3);
    }
}

