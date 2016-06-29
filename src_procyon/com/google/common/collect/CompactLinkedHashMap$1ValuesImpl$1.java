package com.google.common.collect;

class CompactLinkedHashMap$1ValuesImpl$1 extends CompactLinkedHashMap$Itr
{
    final /* synthetic */ CompactLinkedHashMap$1ValuesImpl this$1;
    
    CompactLinkedHashMap$1ValuesImpl$1(final CompactLinkedHashMap$1ValuesImpl this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    Object getOutput(final int n) {
        return this.this$1.this$0.values[n];
    }
}
