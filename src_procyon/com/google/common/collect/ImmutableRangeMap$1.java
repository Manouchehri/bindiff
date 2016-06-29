package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class ImmutableRangeMap$1 extends ImmutableList
{
    final /* synthetic */ int val$len;
    final /* synthetic */ int val$off;
    final /* synthetic */ Range val$range;
    final /* synthetic */ ImmutableRangeMap this$0;
    
    ImmutableRangeMap$1(final ImmutableRangeMap this$0, final int val$len, final int val$off, final Range val$range) {
        this.this$0 = this$0;
        this.val$len = val$len;
        this.val$off = val$off;
        this.val$range = val$range;
    }
    
    @Override
    public int size() {
        return this.val$len;
    }
    
    @Override
    public Range get(final int n) {
        Preconditions.checkElementIndex(n, this.val$len);
        if (n == 0 || n == this.val$len - 1) {
            return this.this$0.ranges.get(n + this.val$off).intersection(this.val$range);
        }
        return this.this$0.ranges.get(n + this.val$off);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
