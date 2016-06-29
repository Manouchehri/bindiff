package com.google.common.collect;

import java.util.*;

final class FluentIterable$1 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterable;
    
    FluentIterable$1(final Iterable iterable, final Iterable val$iterable) {
        this.val$iterable = val$iterable;
        super(iterable);
    }
    
    @Override
    public Iterator iterator() {
        return this.val$iterable.iterator();
    }
}
