package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class MapConstraints$ConstrainedAsMapEntries$1 extends TransformedIterator
{
    final /* synthetic */ MapConstraints$ConstrainedAsMapEntries this$0;
    
    MapConstraints$ConstrainedAsMapEntries$1(final MapConstraints$ConstrainedAsMapEntries this$0, final Iterator iterator) {
        this.this$0 = this$0;
        super(iterator);
    }
    
    Map.Entry transform(final Map.Entry entry) {
        return constrainedAsMapEntry(entry, this.this$0.constraint);
    }
}
