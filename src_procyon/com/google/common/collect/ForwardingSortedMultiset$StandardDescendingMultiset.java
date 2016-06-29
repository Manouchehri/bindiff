package com.google.common.collect;

public abstract class ForwardingSortedMultiset$StandardDescendingMultiset extends DescendingMultiset
{
    final /* synthetic */ ForwardingSortedMultiset this$0;
    
    public ForwardingSortedMultiset$StandardDescendingMultiset(final ForwardingSortedMultiset this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    SortedMultiset forwardMultiset() {
        return this.this$0;
    }
}
