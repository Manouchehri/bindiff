package com.google.common.base;

import java.util.*;

class Converter$1 implements Iterable
{
    final /* synthetic */ Iterable val$fromIterable;
    final /* synthetic */ Converter this$0;
    
    Converter$1(final Converter this$0, final Iterable val$fromIterable) {
        this.this$0 = this$0;
        this.val$fromIterable = val$fromIterable;
    }
    
    @Override
    public Iterator iterator() {
        return new Converter$1$1(this);
    }
}
