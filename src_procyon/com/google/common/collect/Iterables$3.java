package com.google.common.collect;

import java.util.*;

final class Iterables$3 extends TransformedIterator
{
    Iterables$3(final Iterator iterator) {
        super(iterator);
    }
    
    Iterator transform(final Iterable iterable) {
        return iterable.iterator();
    }
}
