package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import com.google.common.math.*;
import javax.annotation.*;
import java.util.*;

class CartesianList$1 extends ImmutableList
{
    final /* synthetic */ int val$index;
    final /* synthetic */ CartesianList this$0;
    
    CartesianList$1(final CartesianList this$0, final int val$index) {
        this.this$0 = this$0;
        this.val$index = val$index;
    }
    
    @Override
    public int size() {
        return this.this$0.axes.size();
    }
    
    @Override
    public Object get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return this.this$0.axes.get(n).get(this.this$0.getAxisIndexForProductIndex(this.val$index, n));
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
