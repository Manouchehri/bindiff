package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import javax.annotation.*;
import java.util.*;

class ImmutableRangeSet$1 extends ImmutableList
{
    final /* synthetic */ int val$length;
    final /* synthetic */ int val$fromIndex;
    final /* synthetic */ Range val$range;
    final /* synthetic */ ImmutableRangeSet this$0;
    
    ImmutableRangeSet$1(final ImmutableRangeSet this$0, final int val$length, final int val$fromIndex, final Range val$range) {
        this.this$0 = this$0;
        this.val$length = val$length;
        this.val$fromIndex = val$fromIndex;
        this.val$range = val$range;
    }
    
    @Override
    public int size() {
        return this.val$length;
    }
    
    @Override
    public Range get(final int n) {
        Preconditions.checkElementIndex(n, this.val$length);
        if (n == 0 || n == this.val$length - 1) {
            return this.this$0.ranges.get(n + this.val$fromIndex).intersection(this.val$range);
        }
        return this.this$0.ranges.get(n + this.val$fromIndex);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
