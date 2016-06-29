package com.google.common.math;

import com.google.common.base.*;

final class LinearTransformation$RegularLinearTransformation extends LinearTransformation
{
    final double slope;
    final double yIntercept;
    
    LinearTransformation$RegularLinearTransformation(final double slope, final double yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }
    
    @Override
    public boolean isVertical() {
        return false;
    }
    
    @Override
    public boolean isHorizontal() {
        return this.slope == 0.0;
    }
    
    @Override
    public double slope() {
        return this.slope;
    }
    
    @Override
    public double transformX(final double n) {
        return n * this.slope + this.yIntercept;
    }
    
    @Override
    public double transformY(final double n) {
        Preconditions.checkState(this.slope != 0.0);
        return (n - this.yIntercept) / this.slope;
    }
    
    @Override
    public String toString() {
        return String.format("y = %g * x + %g", this.slope, this.yIntercept);
    }
}
