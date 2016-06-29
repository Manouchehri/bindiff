package com.google.common.collect;

class CompactHashMap$KeySetView$1 extends CompactHashMap$Itr
{
    final /* synthetic */ CompactHashMap$KeySetView this$1;
    
    CompactHashMap$KeySetView$1(final CompactHashMap$KeySetView this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    Object getOutput(final int n) {
        return this.this$1.this$0.keys[n];
    }
}
