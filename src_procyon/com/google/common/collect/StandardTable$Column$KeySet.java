package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class StandardTable$Column$KeySet extends Maps$KeySet
{
    final /* synthetic */ StandardTable$Column this$1;
    
    StandardTable$Column$KeySet(final StandardTable$Column this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.this$1.this$0.contains(o, this.this$1.columnKey);
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.this$1.this$0.remove(o, this.this$1.columnKey) != null;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$1.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
}
