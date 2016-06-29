package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Iterables$9 extends FluentIterable
{
    final /* synthetic */ Iterable val$fromIterable;
    final /* synthetic */ Function val$function;
    
    Iterables$9(final Iterable val$fromIterable, final Function val$function) {
        this.val$fromIterable = val$fromIterable;
        this.val$function = val$function;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
    }
}
