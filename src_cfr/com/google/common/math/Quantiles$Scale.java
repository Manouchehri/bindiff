/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.Quantiles$1;
import com.google.common.math.Quantiles$ScaleAndIndex;
import com.google.common.math.Quantiles$ScaleAndIndexes;
import com.google.common.primitives.Ints;
import java.util.Collection;

public final class Quantiles$Scale {
    private final int scale;

    private Quantiles$Scale(int n2) {
        Preconditions.checkArgument(n2 > 0, "Quantile scale must be positive");
        this.scale = n2;
    }

    public Quantiles$ScaleAndIndex index(int n2) {
        return new Quantiles$ScaleAndIndex(this.scale, n2, null);
    }

    public /* varargs */ Quantiles$ScaleAndIndexes indexes(int ... arrn) {
        return new Quantiles$ScaleAndIndexes(this.scale, (int[])arrn.clone(), null);
    }

    public Quantiles$ScaleAndIndexes indexes(Collection collection) {
        return new Quantiles$ScaleAndIndexes(this.scale, Ints.toArray(collection), null);
    }

    /* synthetic */ Quantiles$Scale(int n2, Quantiles$1 quantiles$1) {
        this(n2);
    }
}

