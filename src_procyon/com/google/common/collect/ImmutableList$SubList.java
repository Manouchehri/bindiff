package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class ImmutableList$SubList extends ImmutableList
{
    final transient int offset;
    final transient int length;
    final /* synthetic */ ImmutableList this$0;
    
    ImmutableList$SubList(final ImmutableList this$0, final int offset, final int length) {
        this.this$0 = this$0;
        this.offset = offset;
        this.length = length;
    }
    
    @Override
    public int size() {
        return this.length;
    }
    
    @Override
    public Object get(final int n) {
        Preconditions.checkElementIndex(n, this.length);
        return this.this$0.get(n + this.offset);
    }
    
    @Override
    public ImmutableList subList(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.length);
        return this.this$0.subList(n + this.offset, n2 + this.offset);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
