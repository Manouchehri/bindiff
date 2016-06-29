package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;

final class Iterables$2 extends FluentIterable
{
    final /* synthetic */ Iterable val$inputs;
    
    Iterables$2(final Iterable val$inputs) {
        this.val$inputs = val$inputs;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.concat(iterators(this.val$inputs));
    }
}
