package com.google.common.collect;

import java.util.*;

class CompactLinkedHashMap$1KeySetImpl extends CompactHashMap$KeySetView
{
    final /* synthetic */ CompactLinkedHashMap this$0;
    
    CompactLinkedHashMap$1KeySetImpl(final CompactLinkedHashMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return ObjectArrays.toArrayImpl(this, array);
    }
    
    @Override
    public Iterator iterator() {
        return new CompactLinkedHashMap$1KeySetImpl$1(this);
    }
}
