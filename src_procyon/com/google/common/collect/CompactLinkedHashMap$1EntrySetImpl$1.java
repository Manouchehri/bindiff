package com.google.common.collect;

import java.util.*;

class CompactLinkedHashMap$1EntrySetImpl$1 extends CompactLinkedHashMap$Itr
{
    final /* synthetic */ CompactLinkedHashMap$1EntrySetImpl this$1;
    
    CompactLinkedHashMap$1EntrySetImpl$1(final CompactLinkedHashMap$1EntrySetImpl this$1) {
        this.this$1 = this$1;
        super(this$1.this$0, null);
    }
    
    @Override
    Map.Entry getOutput(final int n) {
        return new CompactHashMap$MapEntry(this.this$1.this$0, n);
    }
}
