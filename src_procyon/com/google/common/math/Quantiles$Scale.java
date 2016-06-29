package com.google.common.math;

import com.google.common.base.*;
import java.util.*;
import com.google.common.primitives.*;

public final class Quantiles$Scale
{
    private final int scale;
    
    private Quantiles$Scale(final int scale) {
        Preconditions.checkArgument(scale > 0, (Object)"Quantile scale must be positive");
        this.scale = scale;
    }
    
    public Quantiles$ScaleAndIndex index(final int n) {
        return new Quantiles$ScaleAndIndex(this.scale, n, null);
    }
    
    public Quantiles$ScaleAndIndexes indexes(final int... array) {
        return new Quantiles$ScaleAndIndexes(this.scale, array.clone(), null);
    }
    
    public Quantiles$ScaleAndIndexes indexes(final Collection collection) {
        return new Quantiles$ScaleAndIndexes(this.scale, Ints.toArray(collection), null);
    }
}
