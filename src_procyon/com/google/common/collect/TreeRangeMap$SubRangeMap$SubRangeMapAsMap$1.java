package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1 extends Maps$KeySet
{
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;
    
    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2, final Map map) {
        this.this$2 = this$2;
        super(map);
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        return this.this$2.remove(o) != null;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$2.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
    }
}
