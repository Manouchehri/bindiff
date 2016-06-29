/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.math.Quantiles$1;
import com.google.common.math.Quantiles$Scale;
import com.google.common.math.Quantiles$ScaleAndIndex;

@GoogleInternal
public final class Quantiles {
    public static Quantiles$ScaleAndIndex median() {
        return Quantiles.scale(2).index(1);
    }

    public static Quantiles$Scale quartiles() {
        return Quantiles.scale(4);
    }

    public static Quantiles$Scale percentiles() {
        return Quantiles.scale(100);
    }

    public static Quantiles$Scale scale(int n2) {
        return new Quantiles$Scale(n2, null);
    }

    private static void checkIndex(int n2, int n3) {
        if (n2 < 0) throw new IllegalArgumentException(new StringBuilder(70).append("Quantile indexes must be between 0 and the scale, which is ").append(n3).toString());
        if (n2 <= n3) return;
        throw new IllegalArgumentException(new StringBuilder(70).append("Quantile indexes must be between 0 and the scale, which is ").append(n3).toString());
    }

    private static double[] longsToDoubles(long[] arrl) {
        int n2 = arrl.length;
        double[] arrd = new double[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrd[n3] = arrl[n3];
            ++n3;
        }
        return arrd;
    }

    private static double[] intsToDoubles(int[] arrn) {
        int n2 = arrn.length;
        double[] arrd = new double[n2];
        int n3 = 0;
        while (n3 < n2) {
            arrd[n3] = arrn[n3];
            ++n3;
        }
        return arrd;
    }

    private static void selectInPlace(int n2, double[] arrd, int n3, int n4) {
        if (n2 == n3) {
            int n5 = n3;
            int n6 = n3 + 1;
            do {
                if (n6 > n4) {
                    if (n5 == n3) return;
                    Quantiles.swap(arrd, n5, n3);
                    return;
                }
                if (arrd[n5] > arrd[n6]) {
                    n5 = n6;
                }
                ++n6;
            } while (true);
        }
        while (n4 > n3) {
            int n7 = Quantiles.partition(arrd, n3, n4);
            if (n7 >= n2) {
                n4 = n7 - 1;
            }
            if (n7 > n2) continue;
            n3 = n7 + 1;
        }
    }

    private static int partition(double[] arrd, int n2, int n3) {
        Quantiles.movePivotToStartOfSlice(arrd, n2, n3);
        double d2 = arrd[n2];
        int n4 = n3;
        int n5 = n3;
        do {
            if (n5 <= n2) {
                Quantiles.swap(arrd, n2, n4);
                return n4;
            }
            if (arrd[n5] > d2) {
                Quantiles.swap(arrd, n4, n5);
                --n4;
            }
            --n5;
        } while (true);
    }

    private static void movePivotToStartOfSlice(double[] arrd, int n2, int n3) {
        boolean bl2;
        int n4 = n2 + n3 >>> 1;
        boolean bl3 = arrd[n3] < arrd[n4];
        boolean bl4 = arrd[n4] < arrd[n2];
        boolean bl5 = bl2 = arrd[n3] < arrd[n2];
        if (bl3 == bl4) {
            Quantiles.swap(arrd, n4, n2);
            return;
        }
        if (bl3 == bl2) return;
        Quantiles.swap(arrd, n2, n3);
    }

    private static void selectAllInPlace(int[] arrn, int n2, int n3, double[] arrd, int n4, int n5) {
        int n6;
        int n7;
        int n8 = Quantiles.chooseNextSelection(arrn, n2, n3, n4, n5);
        int n9 = arrn[n8];
        Quantiles.selectInPlace(n9, arrd, n4, n5);
        for (n7 = n8 - 1; n7 >= n2 && arrn[n7] == n9; --n7) {
        }
        if (n7 >= n2) {
            Quantiles.selectAllInPlace(arrn, n2, n7, arrd, n4, n9 - 1);
        }
        for (n6 = n8 + 1; n6 <= n3 && arrn[n6] == n9; ++n6) {
        }
        if (n6 > n3) return;
        Quantiles.selectAllInPlace(arrn, n6, n3, arrd, n9 + 1, n5);
    }

    private static int chooseNextSelection(int[] arrn, int n2, int n3, int n4, int n5) {
        if (n2 == n3) {
            return n2;
        }
        int n6 = n4 + n5 >>> 1;
        int n7 = n2;
        int n8 = n3;
        do {
            if (n8 <= n7 + 1) {
                if (n4 + n5 - arrn[n7] - arrn[n8] <= 0) return n7;
                return n8;
            }
            int n9 = n7 + n8 >>> 1;
            if (arrn[n9] > n6) {
                n8 = n9;
                continue;
            }
            if (arrn[n9] >= n6) return n9;
            n7 = n9;
        } while (true);
    }

    private static void swap(double[] arrd, int n2, int n3) {
        double d2 = arrd[n2];
        arrd[n2] = arrd[n3];
        arrd[n3] = d2;
    }

    static /* synthetic */ void access$300(int n2, int n3) {
        Quantiles.checkIndex(n2, n3);
    }

    static /* synthetic */ double[] access$400(long[] arrl) {
        return Quantiles.longsToDoubles(arrl);
    }

    static /* synthetic */ double[] access$500(int[] arrn) {
        return Quantiles.intsToDoubles(arrn);
    }

    static /* synthetic */ void access$600(int n2, double[] arrd, int n3, int n4) {
        Quantiles.selectInPlace(n2, arrd, n3, n4);
    }

    static /* synthetic */ void access$700(int[] arrn, int n2, int n3, double[] arrd, int n4, int n5) {
        Quantiles.selectAllInPlace(arrn, n2, n3, arrd, n4, n5);
    }
}

