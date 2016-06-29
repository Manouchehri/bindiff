package com.google.protobuf;

import java.util.*;

class UnmodifiableLazyStringList$2 implements Iterator
{
    Iterator iter;
    final /* synthetic */ UnmodifiableLazyStringList this$0;
    
    UnmodifiableLazyStringList$2(final UnmodifiableLazyStringList this$0) {
        this.this$0 = this$0;
        this.iter = this.this$0.list.iterator();
    }
    
    public boolean hasNext() {
        return this.iter.hasNext();
    }
    
    public String next() {
        return this.iter.next();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
