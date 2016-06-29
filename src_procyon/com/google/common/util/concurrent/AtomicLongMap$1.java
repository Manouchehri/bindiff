package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.atomic.*;

class AtomicLongMap$1 implements Function
{
    final /* synthetic */ AtomicLongMap this$0;
    
    AtomicLongMap$1(final AtomicLongMap this$0) {
        this.this$0 = this$0;
    }
    
    public Long apply(final AtomicLong atomicLong) {
        return atomicLong.get();
    }
}
