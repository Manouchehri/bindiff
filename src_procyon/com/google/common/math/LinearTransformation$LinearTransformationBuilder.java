package com.google.common.math;

import com.google.common.base.*;

public final class LinearTransformation$LinearTransformationBuilder
{
    private final double x1;
    private final double y1;
    
    private LinearTransformation$LinearTransformationBuilder(final double x1, final double y1) {
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public LinearTransformation and(final double n, final double n2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(n) && DoubleUtils.isFinite(n2));
        if (n == this.x1) {
            Preconditions.checkArgument(n2 != this.y1);
            return new LinearTransformation$VerticalLinearTransformation(this.x1);
        }
        return this.withSlope((n2 - this.y1) / (n - this.x1));
    }
    
    public LinearTransformation withSlope(final double n) {
        Preconditions.checkArgument(!Double.isNaN(n));
        if (DoubleUtils.isFinite(n)) {
            return new LinearTransformation$RegularLinearTransformation(n, this.y1 - this.x1 * n);
        }
        return new LinearTransformation$VerticalLinearTransformation(this.x1);
    }
}
