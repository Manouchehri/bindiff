package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedAsMapValues$1 extends TransformedIterator
{
    final /* synthetic */ Synchronized$SynchronizedAsMapValues this$0;
    
    Synchronized$SynchronizedAsMapValues$1(final Synchronized$SynchronizedAsMapValues this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Collection transform(final Collection collection) {
        return typePreservingCollection(collection, this.this$0.mutex);
    }
}
