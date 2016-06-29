package com.google.common.collect;

import com.google.common.base.*;
import javax.annotation.*;

final class Maps$8 implements Function
{
    final /* synthetic */ Maps$EntryTransformer val$transformer;
    final /* synthetic */ Object val$key;
    
    Maps$8(final Maps$EntryTransformer val$transformer, final Object val$key) {
        this.val$transformer = val$transformer;
        this.val$key = val$key;
    }
    
    @Override
    public Object apply(@Nullable final Object o) {
        return this.val$transformer.transformEntry(this.val$key, o);
    }
}
