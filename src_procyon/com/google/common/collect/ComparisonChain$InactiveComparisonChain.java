package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

final class ComparisonChain$InactiveComparisonChain extends ComparisonChain
{
    final int result;
    
    ComparisonChain$InactiveComparisonChain(final int result) {
        super(null);
        this.result = result;
    }
    
    @Override
    public ComparisonChain compare(@Nullable final Comparable comparable, @Nullable final Comparable comparable2) {
        return this;
    }
    
    @Override
    public ComparisonChain compare(@Nullable final Object o, @Nullable final Object o2, @Nullable final Comparator comparator) {
        return this;
    }
    
    @Override
    public ComparisonChain compare(final int n, final int n2) {
        return this;
    }
    
    @Override
    public ComparisonChain compare(final long n, final long n2) {
        return this;
    }
    
    @Override
    public ComparisonChain compare(final float n, final float n2) {
        return this;
    }
    
    @Override
    public ComparisonChain compare(final double n, final double n2) {
        return this;
    }
    
    @Override
    public ComparisonChain compareTrueFirst(final boolean b, final boolean b2) {
        return this;
    }
    
    @Override
    public ComparisonChain compareFalseFirst(final boolean b, final boolean b2) {
        return this;
    }
    
    @Override
    public int result() {
        return this.result;
    }
}
