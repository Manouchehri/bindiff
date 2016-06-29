package com.google.common.collect;

import java.util.*;

class CompactHashMap$EntrySetView$1 extends CompactHashMap$Itr
{
    final /* synthetic */ CompactHashMap$EntrySetView this$1;
    
    CompactHashMap$EntrySetView$1(final CompactHashMap$EntrySetView this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    Map.Entry getOutput(final int n) {
        return new CompactHashMap$MapEntry(this.this$1.this$0, n);
    }
}
