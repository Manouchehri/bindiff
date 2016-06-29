/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;

final class LinearTransformation$RegularLinearTransformation
extends LinearTransformation {
    final double slope;
    final double yIntercept;

    LinearTransformation$RegularLinearTransformation(double d2, double d3) {
        this.slope = d2;
        this.yIntercept = d3;
    }

    @Override
    public boolean isVertical() {
        return false;
    }

    @Override
    public boolean isHorizontal() {
        if (this.slope != 0.0) return false;
        return true;
    }

    @Override
    public double slope() {
        return this.slope;
    }

    @Override
    public double transformX(double d2) {
        return d2 * this.slope + this.yIntercept;
    }

    @Override
    public double transformY(double d2) {
        Preconditions.checkState(this.slope != 0.0);
        return (d2 - this.yIntercept) / this.slope;
    }

    public String toString() {
        return String.format("y = %g * x + %g", this.slope, this.yIntercept);
    }
}

