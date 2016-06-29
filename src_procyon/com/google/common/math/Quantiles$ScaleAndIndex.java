package com.google.common.math;

import java.util.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import java.math.*;
import com.google.common.annotations.*;

public final class Quantiles$ScaleAndIndex
{
    private final int scale;
    private final int index;
    
    private Quantiles$ScaleAndIndex(final int scale, final int index) {
        checkIndex(index, scale);
        this.scale = scale;
        this.index = index;
    }
    
    public double compute(final Collection collection) {
        return this.computeInPlace(Doubles.toArray(collection));
    }
    
    public double compute(final double... array) {
        return this.computeInPlace((double[])array.clone());
    }
    
    public double compute(final long... array) {
        return this.computeInPlace(longsToDoubles(array));
    }
    
    public double compute(final int... array) {
        return this.computeInPlace(intsToDoubles(array));
    }
    
    public double computeInPlace(final double... array) {
        Preconditions.checkArgument(array.length > 0, (Object)"Cannot calculate quantiles of an empty dataset");
        final long n = this.index * (array.length - 1);
        final int n2 = (int)LongMath.divide(n, this.scale, RoundingMode.DOWN);
        final int n3 = (int)(n - n2 * this.scale);
        selectInPlace(n2, array, 0, array.length - 1);
        if (n3 == 0) {
            return array[n2];
        }
        selectInPlace(n2 + 1, array, n2 + 1, array.length - 1);
        return array[n2] + (array[n2 + 1] - array[n2]) * n3 / this.scale;
    }
}
