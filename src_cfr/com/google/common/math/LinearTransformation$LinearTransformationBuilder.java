/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$1;
import com.google.common.math.LinearTransformation$RegularLinearTransformation;
import com.google.common.math.LinearTransformation$VerticalLinearTransformation;

public final class LinearTransformation$LinearTransformationBuilder {
    private final double x1;
    private final double y1;

    private LinearTransformation$LinearTransformationBuilder(double d2, double d3) {
        this.x1 = d2;
        this.y1 = d3;
    }

    public LinearTransformation and(double d2, double d3) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d2) && DoubleUtils.isFinite(d3));
        if (d2 != this.x1) return this.withSlope((d3 - this.y1) / (d2 - this.x1));
        Preconditions.checkArgument(d3 != this.y1);
        return new LinearTransformation$VerticalLinearTransformation(this.x1);
    }

    public LinearTransformation withSlope(double d2) {
        Preconditions.checkArgument(!Double.isNaN(d2));
        if (!DoubleUtils.isFinite(d2)) return new LinearTransformation$VerticalLinearTransformation(this.x1);
        double d3 = this.y1 - this.x1 * d2;
        return new LinearTransformation$RegularLinearTransformation(d2, d3);
    }

    /* synthetic */ LinearTransformation$LinearTransformationBuilder(double d2, double d3, LinearTransformation$1 linearTransformation$1) {
        this(d2, d3);
    }
}

