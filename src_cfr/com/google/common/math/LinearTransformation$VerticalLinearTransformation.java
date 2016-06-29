/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.math.LinearTransformation;

final class LinearTransformation$VerticalLinearTransformation
extends LinearTransformation {
    final double x;

    LinearTransformation$VerticalLinearTransformation(double d2) {
        this.x = d2;
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
    public double transformX(double d2) {
        throw new IllegalStateException();
    }

    @Override
    public double transformY(double d2) {
        return this.x;
    }

    public String toString() {
        return String.format("x = %g", this.x);
    }
}

