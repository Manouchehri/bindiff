package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class MapConstraints$ConstrainedEntries$1 extends TransformedIterator
{
    final /* synthetic */ MapConstraints$ConstrainedEntries this$0;
    
    MapConstraints$ConstrainedEntries$1(final MapConstraints$ConstrainedEntries this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Map.Entry transform(final Map.Entry entry) {
        return constrainedEntry(entry, this.this$0.constraint);
    }
}
