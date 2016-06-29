package com.google.common.collect;

class CompactHashMap$ValuesView$1 extends CompactHashMap$Itr
{
    final /* synthetic */ CompactHashMap$ValuesView this$1;
    
    CompactHashMap$ValuesView$1(final CompactHashMap$ValuesView this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    Object getOutput(final int n) {
        return this.this$1.this$0.values[n];
    }
}
