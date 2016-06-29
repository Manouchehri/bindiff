package com.google.common.collect;

import java.util.*;

class CompactLinkedHashMap$1ValuesImpl extends CompactHashMap$ValuesView
{
    final /* synthetic */ CompactLinkedHashMap this$0;
    
    CompactLinkedHashMap$1ValuesImpl(final CompactLinkedHashMap this$0) {
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
        return new CompactLinkedHashMap$1ValuesImpl$1(this);
    }
}
