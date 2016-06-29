package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Iterables$7 extends FluentIterable
{
    final /* synthetic */ Iterable val$unfiltered;
    final /* synthetic */ Predicate val$predicate;
    
    Iterables$7(final Iterable val$unfiltered, final Predicate val$predicate) {
        this.val$unfiltered = val$unfiltered;
        this.val$predicate = val$predicate;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.filter(this.val$unfiltered.iterator(), this.val$predicate);
    }
}
