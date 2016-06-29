/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LinearTransformation$1;
import com.google.common.math.LinearTransformation$LinearTransformationBuilder;
import com.google.common.math.LinearTransformation$RegularLinearTransformation;
import com.google.common.math.LinearTransformation$VerticalLinearTransformation;

@GoogleInternal
public abstract class LinearTransformation {
    public static LinearTransformation$LinearTransformationBuilder mapping(double d2, double d3) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d2) && DoubleUtils.isFinite(d3));
        return new LinearTransformation$LinearTransformationBuilder(d2, d3, null);
    }

    public static LinearTransformation vertical(double d2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d2));
        return new LinearTransformation$VerticalLinearTransformation(d2);
    }

    public static LinearTransformation horizontal(double d2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d2));
        double d3 = 0.0;
        return new LinearTransformation$RegularLinearTransformation(d3, d2);
    }

    public abstract boolean isVertical();

    public abstract boolean isHorizontal();

    public abstract double slope();

    public abstract double transformX(double var1);

    public abstract double transformY(double var1);
}

