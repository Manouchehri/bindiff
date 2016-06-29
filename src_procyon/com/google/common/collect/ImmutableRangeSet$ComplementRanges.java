package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import javax.annotation.*;
import java.util.*;

final class ImmutableRangeSet$ComplementRanges extends ImmutableList
{
    private final boolean positiveBoundedBelow;
    private final boolean positiveBoundedAbove;
    private final int size;
    final /* synthetic */ ImmutableRangeSet this$0;
    
    ImmutableRangeSet$ComplementRanges(final ImmutableRangeSet this$0) {
        this.this$0 = this$0;
        this.positiveBoundedBelow = this$0.ranges.get(0).hasLowerBound();
        this.positiveBoundedAbove = ((Range)Iterables.getLast(this$0.ranges)).hasUpperBound();
        int size = this$0.ranges.size() - 1;
        if (this.positiveBoundedBelow) {
            ++size;
        }
        if (this.positiveBoundedAbove) {
            ++size;
        }
        this.size = size;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public Range get(final int n) {
        Preconditions.checkElementIndex(n, this.size);
        Cut upperBound;
        if (this.positiveBoundedBelow) {
            upperBound = ((n == 0) ? Cut.belowAll() : this.this$0.ranges.get(n - 1).upperBound);
        }
        else {
            upperBound = this.this$0.ranges.get(n).upperBound;
        }
        Cut cut;
        if (this.positiveBoundedAbove && n == this.size - 1) {
            cut = Cut.aboveAll();
        }
        else {
            cut = this.this$0.ranges.get(n + (this.positiveBoundedBelow ? 0 : 1)).lowerBound;
        }
        return Range.create(upperBound, cut);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
