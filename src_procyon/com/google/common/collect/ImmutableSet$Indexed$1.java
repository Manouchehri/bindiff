package com.google.common.collect;

class ImmutableSet$Indexed$1 extends ImmutableAsList
{
    final /* synthetic */ ImmutableSet$Indexed this$0;
    
    ImmutableSet$Indexed$1(final ImmutableSet$Indexed this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Object get(final int n) {
        return this.this$0.get(n);
    }
    
    @Override
    ImmutableSet$Indexed delegateCollection() {
        return this.this$0;
    }
}
