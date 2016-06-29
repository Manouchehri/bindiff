package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.primitives.*;

final class ComparisonChain$1 extends ComparisonChain
{
    ComparisonChain$1() {
        super(null);
    }
    
    @Override
    public ComparisonChain compare(final Comparable comparable, final Comparable comparable2) {
        return this.classify(comparable.compareTo(comparable2));
    }
    
    @Override
    public ComparisonChain compare(@Nullable final Object o, @Nullable final Object o2, final Comparator comparator) {
        return this.classify(comparator.compare(o, o2));
    }
    
    @Override
    public ComparisonChain compare(final int n, final int n2) {
        return this.classify(Ints.compare(n, n2));
    }
    
    @Override
    public ComparisonChain compare(final long n, final long n2) {
        return this.classify(Longs.compare(n, n2));
    }
    
    @Override
    public ComparisonChain compare(final float n, final float n2) {
        return this.classify(Float.compare(n, n2));
    }
    
    @Override
    public ComparisonChain compare(final double n, final double n2) {
        return this.classify(Double.compare(n, n2));
    }
    
    @Override
    public ComparisonChain compareTrueFirst(final boolean b, final boolean b2) {
        return this.classify(Booleans.compare(b2, b));
    }
    
    @Override
    public ComparisonChain compareFalseFirst(final boolean b, final boolean b2) {
        return this.classify(Booleans.compare(b, b2));
    }
    
    ComparisonChain classify(final int n) {
        return (n < 0) ? ComparisonChain.access$100() : ((n > 0) ? ComparisonChain.access$200() : ComparisonChain.access$300());
    }
    
    @Override
    public int result() {
        return 0;
    }
}
