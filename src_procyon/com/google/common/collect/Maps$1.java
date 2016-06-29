package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Maps$1 extends TransformedIterator
{
    final /* synthetic */ Function val$function;
    
    Maps$1(final Iterator iterator, final Function val$function) {
        this.val$function = val$function;
        super(iterator);
    }
    
    @Override
    Map.Entry transform(final Object o) {
        return Maps.immutableEntry(o, this.val$function.apply(o));
    }
}
