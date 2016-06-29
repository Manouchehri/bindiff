package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;

final class Iterables$15 extends FluentIterable
{
    final /* synthetic */ Iterable val$iterables;
    final /* synthetic */ Comparator val$comparator;
    
    Iterables$15(final Iterable val$iterables, final Comparator val$comparator) {
        this.val$iterables = val$iterables;
        this.val$comparator = val$comparator;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.mergeSorted(Iterables.transform(this.val$iterables, toIterator()), this.val$comparator);
    }
}
