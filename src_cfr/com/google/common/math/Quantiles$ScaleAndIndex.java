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
import java.util.Collection;

public final class Quantiles$ScaleAndIndex {
    private final int scale;
    private final int index;

    private Quantiles$ScaleAndIndex(int n2, int n3) {
        Quantiles.access$300(n3, n2);
        this.scale = n2;
        this.index = n3;
    }

    public double compute(Collection collection) {
        return this.computeInPlace(Doubles.toArray(collection));
    }

    public /* varargs */ double compute(double ... arrd) {
        return this.computeInPlace((double[])arrd.clone());
    }

    public /* varargs */ double compute(long ... arrl) {
        return this.computeInPlace(Quantiles.access$400(arrl));
    }

    public /* varargs */ double compute(int ... arrn) {
        return this.computeInPlace(Quantiles.access$500(arrn));
    }

    public /* varargs */ double computeInPlace(double ... arrd) {
        Preconditions.checkArgument(arrd.length > 0, "Cannot calculate quantiles of an empty dataset");
        long l2 = (long)this.index * (long)(arrd.length - 1);
        int n2 = (int)LongMath.divide(l2, this.scale, RoundingMode.DOWN);
        int n3 = (int)(l2 - (long)n2 * (long)this.scale);
        Quantiles.access$600(n2, arrd, 0, arrd.length - 1);
        if (n3 == 0) {
            return arrd[n2];
        }
        Quantiles.access$600(n2 + 1, arrd, n2 + 1, arrd.length - 1);
        return arrd[n2] + (arrd[n2 + 1] - arrd[n2]) * (double)n3 / (double)this.scale;
    }

    /* synthetic */ Quantiles$ScaleAndIndex(int n2, int n3, Quantiles$1 quantiles$1) {
        this(n2, n3);
    }
}

