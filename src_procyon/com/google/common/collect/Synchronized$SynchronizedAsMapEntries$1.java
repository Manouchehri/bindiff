package com.google.common.collect;

import java.util.*;

class Synchronized$SynchronizedAsMapEntries$1 extends TransformedIterator
{
    final /* synthetic */ Synchronized$SynchronizedAsMapEntries this$0;
    
    Synchronized$SynchronizedAsMapEntries$1(final Synchronized$SynchronizedAsMapEntries this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Map.Entry transform(final Map.Entry entry) {
        return new Synchronized$SynchronizedAsMapEntries$1$1(this, entry);
    }
}
