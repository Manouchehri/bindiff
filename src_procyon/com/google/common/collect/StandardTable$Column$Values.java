package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class StandardTable$Column$Values extends Maps$Values
{
    final /* synthetic */ StandardTable$Column this$1;
    
    StandardTable$Column$Values(final StandardTable$Column this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    public boolean remove(final Object o) {
        return o != null && this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(o)));
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
}
