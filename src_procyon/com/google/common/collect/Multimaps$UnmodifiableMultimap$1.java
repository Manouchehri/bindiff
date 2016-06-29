package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;

class Multimaps$UnmodifiableMultimap$1 implements Function
{
    final /* synthetic */ Multimaps$UnmodifiableMultimap this$0;
    
    Multimaps$UnmodifiableMultimap$1(final Multimaps$UnmodifiableMultimap this$0) {
        this.this$0 = this$0;
    }
    
    public Collection apply(final Collection collection) {
        return unmodifiableValueCollection(collection);
    }
}
