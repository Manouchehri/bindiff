package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Iterators$9 extends TransformedIterator
{
    final /* synthetic */ Function val$function;
    
    Iterators$9(final Iterator iterator, final Function val$function) {
        this.val$function = val$function;
        super(iterator);
    }
    
    @Override
    Object transform(final Object o) {
        return this.val$function.apply(o);
    }
}
