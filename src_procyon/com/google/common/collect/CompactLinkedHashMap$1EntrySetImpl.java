package com.google.common.collect;

import java.util.*;

class CompactLinkedHashMap$1EntrySetImpl extends CompactHashMap$EntrySetView
{
    final /* synthetic */ CompactLinkedHashMap this$0;
    
    CompactLinkedHashMap$1EntrySetImpl(final CompactLinkedHashMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Iterator iterator() {
        return new CompactLinkedHashMap$1EntrySetImpl$1(this);
    }
}
