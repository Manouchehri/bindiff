package com.google.common.collect;

import com.google.common.base.*;

final class Maps$7 implements Maps$EntryTransformer
{
    final /* synthetic */ Function val$function;
    
    Maps$7(final Function val$function) {
        this.val$function = val$function;
    }
    
    @Override
    public Object transformEntry(final Object o, final Object o2) {
        return this.val$function.apply(o2);
    }
}
