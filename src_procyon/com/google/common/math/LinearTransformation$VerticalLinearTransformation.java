package com.google.common.math;

final class LinearTransformation$VerticalLinearTransformation extends LinearTransformation
{
    final double x;
    
    LinearTransformation$VerticalLinearTransformation(final double x) {
        this.x = x;
    }
    
    @Override
    public boolean isVertical() {
        return true;
    }
    
    @Override
    public boolean isHorizontal() {
        return false;
    }
    
    @Override
    public double slope() {
        throw new IllegalStateException();
    }
    
    @Override
    public double transformX(final double n) {
        throw new IllegalStateException();
    }
    
    @Override
    public double transformY(final double n) {
        return this.x;
    }
    
    @Override
    public String toString() {
        return String.format("x = %g", this.x);
    }
}
