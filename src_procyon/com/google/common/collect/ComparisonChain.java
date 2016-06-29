package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible
public abstract class ComparisonChain
{
    private static final ComparisonChain ACTIVE;
    private static final ComparisonChain LESS;
    private static final ComparisonChain GREATER;
    
    public static ComparisonChain start() {
        return ComparisonChain.ACTIVE;
    }
    
    public abstract ComparisonChain compare(final Comparable p0, final Comparable p1);
    
    public abstract ComparisonChain compare(@Nullable final Object p0, @Nullable final Object p1, final Comparator p2);
    
    public abstract ComparisonChain compare(final int p0, final int p1);
    
    public abstract ComparisonChain compare(final long p0, final long p1);
    
    public abstract ComparisonChain compare(final float p0, final float p1);
    
    public abstract ComparisonChain compare(final double p0, final double p1);
    
    @Deprecated
    public final ComparisonChain compare(final Boolean b, final Boolean b2) {
        return this.compareFalseFirst(b, b2);
    }
    
    public abstract ComparisonChain compareTrueFirst(final boolean p0, final boolean p1);
    
    public abstract ComparisonChain compareFalseFirst(final boolean p0, final boolean p1);
    
    public abstract int result();
    
    static {
        ACTIVE = new ComparisonChain$1();
        LESS = new ComparisonChain$InactiveComparisonChain(-1);
        GREATER = new ComparisonChain$InactiveComparisonChain(1);
    }
}
