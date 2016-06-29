package com.google.common.collect;

import java.util.*;

final class Sets$CartesianSet$1 extends ImmutableList
{
    final /* synthetic */ ImmutableList val$axes;
    
    Sets$CartesianSet$1(final ImmutableList val$axes) {
        this.val$axes = val$axes;
    }
    
    @Override
    public int size() {
        return this.val$axes.size();
    }
    
    @Override
    public List get(final int n) {
        return this.val$axes.get(n).asList();
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
