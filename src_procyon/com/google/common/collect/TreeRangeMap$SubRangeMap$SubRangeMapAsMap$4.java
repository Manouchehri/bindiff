package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4 extends Maps$Values
{
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;
    
    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2, final Map map) {
        this.this$2 = this$2;
        super(map);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.this$2.removeEntryIf(Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$2.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.valueFunction()));
    }
}
