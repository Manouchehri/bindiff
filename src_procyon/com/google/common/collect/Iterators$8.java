package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

final class Iterators$8 extends AbstractIterator
{
    final /* synthetic */ Iterator val$unfiltered;
    final /* synthetic */ Predicate val$predicate;
    
    Iterators$8(final Iterator val$unfiltered, final Predicate val$predicate) {
        this.val$unfiltered = val$unfiltered;
        this.val$predicate = val$predicate;
    }
    
    @Override
    protected Object computeNext() {
        while (this.val$unfiltered.hasNext()) {
            final Object next = this.val$unfiltered.next();
            if (this.val$predicate.apply(next)) {
                return next;
            }
        }
        return this.endOfData();
    }
}
