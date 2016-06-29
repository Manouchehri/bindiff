package com.google.common.collect;

class ImmutableList$1 extends AbstractIndexedListIterator
{
    final /* synthetic */ ImmutableList this$0;
    
    ImmutableList$1(final ImmutableList this$0, final int n, final int n2) {
        this.this$0 = this$0;
        super(n, n2);
    }
    
    @Override
    protected Object get(final int n) {
        return this.this$0.get(n);
    }
}
