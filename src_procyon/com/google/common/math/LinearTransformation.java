package com.google.common.math;

import com.google.common.annotations.*;
import com.google.common.base.*;

@GoogleInternal
public abstract class LinearTransformation
{
    public static LinearTransformation$LinearTransformationBuilder mapping(final double n, final double n2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(n) && DoubleUtils.isFinite(n2));
        return new LinearTransformation$LinearTransformationBuilder(n, n2, null);
    }
    
    public static LinearTransformation vertical(final double n) {
        Preconditions.checkArgument(DoubleUtils.isFinite(n));
        return new LinearTransformation$VerticalLinearTransformation(n);
    }
    
    public static LinearTransformation horizontal(final double n) {
        Preconditions.checkArgument(DoubleUtils.isFinite(n));
        return new LinearTransformation$RegularLinearTransformation(0.0, n);
    }
    
    public abstract boolean isVertical();
    
    public abstract boolean isHorizontal();
    
    public abstract double slope();
    
    public abstract double transformX(final double p0);
    
    public abstract double transformY(final double p0);
}
