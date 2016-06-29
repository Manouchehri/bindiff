/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.math.Quantiles;
import com.google.common.math.Quantiles$1;
import com.google.common.primitives.Doubles;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Quantiles$ScaleAndIndexes {
    private final int scale;
    private final int[] indexes;

    private Quantiles$ScaleAndIndexes(int n2, int[] arrn) {
        int[] arrn2 = arrn;
        int n3 = arrn2.length;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                this.scale = n2;
                this.indexes = arrn;
                return;
            }
            int n5 = arrn2[n4];
            Quantiles.access$300(n5, n2);
            ++n4;
        } while (true);
    }

    public Map compute(Collection collection) {
        return this.computeInPlace(Doubles.toArray(collection));
    }

    public /* varargs */ Map compute(double ... arrd) {
        return this.computeInPlace((double[])arrd.clone());
    }

    public /* varargs */ Map compute(long ... arrl) {
        return this.computeInPlace(Quantiles.access$400(arrl));
    }

    public /* varargs */ Map compute(int ... arrn) {
        return this.computeInPlace(Quantiles.access$500(arrn));
    }

    public /* varargs */ Map computeInPlace(double ... arrd) {
        int n2;
        Preconditions.checkArgument(arrd.length > 0, "Cannot calculate quantiles of an empty dataset");
        int[] arrn = new int[this.indexes.length];
        int[] arrn2 = new int[this.indexes.length];
        int[] arrn3 = new int[this.indexes.length * 2];
        int n3 = 0;
        for (int i2 = 0; i2 < this.indexes.length; ++i2) {
            long l2 = (long)this.indexes[i2] * (long)(arrd.length - 1);
            n2 = (int)LongMath.divide(l2, this.scale, RoundingMode.DOWN);
            int n4 = (int)(l2 - (long)n2 * (long)this.scale);
            arrn[i2] = n2;
            arrn2[i2] = n4;
            arrn3[n3] = n2;
            ++n3;
            if (n4 == 0) continue;
            arrn3[n3] = n2 + 1;
            ++n3;
        }
        Arrays.sort(arrn3, 0, n3);
        Quantiles.access$700(arrn3, 0, n3 - 1, arrd, 0, arrd.length - 1);
        HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
        int n5 = 0;
        while (n5 < this.indexes.length) {
            int n6 = arrn[n5];
            n2 = arrn2[n5];
            if (n2 == 0) {
                hashMap.put(this.indexes[n5], arrd[n6]);
            } else {
                double d2 = (double)n2 / (double)this.scale;
                hashMap.put(this.indexes[n5], arrd[n6] + d2 * (arrd[n6 + 1] - arrd[n6]));
            }
            ++n5;
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* synthetic */ Quantiles$ScaleAndIndexes(int n2, int[] arrn, Quantiles$1 quantiles$1) {
        this(n2, arrn);
    }
}

