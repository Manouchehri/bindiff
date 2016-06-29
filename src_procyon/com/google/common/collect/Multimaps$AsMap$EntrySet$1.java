package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.base.*;
import java.util.*;

class Multimaps$AsMap$EntrySet$1 implements Function
{
    final /* synthetic */ Multimaps$AsMap$EntrySet this$1;
    
    Multimaps$AsMap$EntrySet$1(final Multimaps$AsMap$EntrySet this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public Collection apply(final Object o) {
        return this.this$1.this$0.multimap.get(o);
    }
}
