package com.google.common.collect;

import com.google.common.base.*;

class FluentIterable$FromIterableFunction implements Function
{
    public FluentIterable apply(final Iterable iterable) {
        return FluentIterable.from(iterable);
    }
}
